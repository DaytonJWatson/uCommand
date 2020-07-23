package me.dayton.uCommands.Commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.dayton.uCommands.Config.Utils;
import me.dayton.uCommands.Methods.Spawn;

public class SpawnCMD implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("spawn")) {
			if(p.hasPermission("ucommands.spawn")) {
				if(Spawn.getLocation() == null) {
					p.sendMessage("&7Spawn location not &6set");
				} else {
					Spawn.spawn(p);
				}
			} else {
				sender.sendMessage(Utils.chat("&cPermission denied"));
			}
		}
		
		if(cmd.getName().equalsIgnoreCase("setspawn")) {
			if(p.hasPermission("ucommands.setspawn")) {
				Location spawnLocation = p.getLocation();
				
				Spawn.setLocation(spawnLocation);
				p.getWorld().setSpawnLocation((int) spawnLocation.getX(), (int) spawnLocation.getY(), (int) spawnLocation.getZ());
				p.sendMessage(Utils.chat("&7Spawn location &6set"));
			}
			else {
				p.sendMessage(Utils.chat("&cPermission denied"));
			}
		}
		return false;
	}
}