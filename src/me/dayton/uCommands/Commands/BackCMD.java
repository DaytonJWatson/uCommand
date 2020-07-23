package me.dayton.uCommands.Commands;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.dayton.uCommands.Main;
import me.dayton.uCommands.Config.Utils;

public class BackCMD implements CommandExecutor, Listener {

	public static HashMap<Player, Location> backLocation = new HashMap<>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("back")) {
			if(p.hasPermission("ucommands.back")) {
				if(backLocation.containsKey(p)) {
					p.teleport(backLocation.get(p));
					backLocation.remove(p);
					p.sendMessage(Utils.chat("&7Teleported &6back&7"));
				} else if(backLocation.isEmpty()) {
					p.sendMessage(Utils.chat("&7Nowhere to &6take &7you to"));
				}
			} else {
				p.sendMessage(Utils.chat("&cPermission denied"));
			}
		}
		return false;
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player p = e.getEntity().getPlayer();
		Location loc = p.getLocation();
		
		if(!p.hasPermission("ucommands.back")) {
			return;
		} else {
			backLocation.put(p, loc);
			new BukkitRunnable() {
				@Override
				public void run() {
					p.sendMessage(Utils.chat("&7Teleport back to your &6death &7location with /back"));
				}
			}.runTaskLater(Main.getInstance(), 20L);
		}
	}
	
	@EventHandler
	public void onTeleport(PlayerTeleportEvent e) {
		Player p = e.getPlayer();
		
		if(p.hasPermission("ucommands.back")) {
			backLocation.put(p, p.getLocation());
		} else {
			return;
		}
	}
}