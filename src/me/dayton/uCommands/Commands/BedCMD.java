package me.dayton.uCommands.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.dayton.uCommands.Config.Utils;

public class BedCMD implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
		Player p = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("bed")) {
			if (sender.hasPermission("ucommands.bed")) {
				if(args.length == 0) {
					if (p.getBedSpawnLocation() != null) {
						p.teleport(p.getBedSpawnLocation());
						p.sendMessage(Utils.chat("&7Taking you to your &6bed"));
					} else {
						p.sendMessage(Utils.chat("&7Your bed is &6missing &7or &6obstructed"));
					}
				} else if((args.length == 1) && (Bukkit.getPlayerExact(args[0]) != null) && p.hasPermission("ucommands.bed.others")) {
					Player targetPlayer = p.getServer().getPlayer(args[0]);
					Location targetPlayerBed = targetPlayer.getBedSpawnLocation();
					
					if(targetPlayerBed == null) {
						p.sendMessage(Utils.chat("&6" + targetPlayer.getName() + "'s &7bed is &6missing &7or &6obstructed"));
					} else {
						p.teleport(targetPlayerBed);
						p.sendMessage(Utils.chat("&7Taking you to &6" + targetPlayer.getName() + "'s &7bed"));
					}
				} else {
					p.sendMessage(Utils.chat("&cPermission denied"));
				}
			} else {
				p.sendMessage(Utils.chat("&cPermission denied"));
			}
		}
		return false;
	}
}
