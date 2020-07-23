package me.dayton.uCommands.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.dayton.uCommands.Config.Utils;

public class CoordsCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("coords")) {
			if(sender.hasPermission("ucommands.coords")) {
				if(args.length == 0) {
					p.sendMessage(Utils.chat("&7Your &6coordinates &7are"));
					p.sendMessage(Utils.chat("&7X&8:&7 " + p.getLocation().getBlockX()));
					p.sendMessage(Utils.chat("&7Y&8:&7 " + p.getLocation().getBlockY()));
					p.sendMessage(Utils.chat("&7Z&8:&7 " + p.getLocation().getBlockZ()));
				} else if(args.length == 2) {
					if(args[0].equalsIgnoreCase("tell")) {
						Player targetPlayer = Bukkit.getServer().getPlayer(args[1]);
						if(targetPlayer == null) {
							p.sendMessage(Utils.chat("&7Player &c" + args[1] + " &7not found"));
						} else {
							p.sendMessage(Utils.chat("&7You told &6" + targetPlayer.getName() + " &7your coordinates"));
							targetPlayer.sendMessage(Utils.chat("&7" + p.getName() + " &7Has sent you their &6location"));
							targetPlayer.sendMessage(Utils.chat("&7X&8:&7 " + p.getLocation().getBlockX()));
							targetPlayer.sendMessage(Utils.chat("&7Y&8:&7 " + p.getLocation().getBlockY()));
							targetPlayer.sendMessage(Utils.chat("&7Z&8:&7 " + p.getLocation().getBlockZ()));
						}
					}
				} else if(args.length == 1) {
					if(sender.hasPermission("ucommands.coords.others")) {
						Player targetPlayer = Bukkit.getServer().getPlayer(args[0]);
						if(targetPlayer == null) {
							p.sendMessage(Utils.chat("&7Player &c" + args[0] + " &7not found"));
						} else {
							p.sendMessage(Utils.chat("&6" + targetPlayer.getName() + "'s &7coordinates are"));
							p.sendMessage(Utils.chat("&7X&8:&7 " + targetPlayer.getLocation().getBlockX()));
							p.sendMessage(Utils.chat("&7Y&8:&7 " + targetPlayer.getLocation().getBlockY()));
							p.sendMessage(Utils.chat("&7Z&8:&7 " + targetPlayer.getLocation().getBlockZ()));
						}
					} else {
						p.sendMessage(Utils.chat("&cPermission denied"));
					}
				}
			} else {
				p.sendMessage(Utils.chat("&cPermission denied"));
			}
		}
		return false;
	}
}