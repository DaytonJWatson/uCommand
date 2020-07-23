package me.dayton.uCommands.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.dayton.uCommands.Config.Utils;

public class TimeCMD implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("day")) {
			if(sender.hasPermission("ucommands.time")) {
				p.getWorld().setTime(0);
				p.sendMessage(Utils.chat("&7Time set to &6day"));
			} else {
				p.sendMessage(Utils.chat("&cPermission denied"));
			}
		}
		
		if(cmd.getName().equalsIgnoreCase("noon")) {
			if(sender.hasPermission("ucommands.time")) {
				p.getWorld().setTime(6000);
				p.sendMessage(Utils.chat("&7Time set to &6noon"));
			} else {
				p.sendMessage(Utils.chat("&cPermission denied"));
			}
		}
		
		if(cmd.getName().equalsIgnoreCase("night")) {
			if(sender.hasPermission("ucommands.time")) {
				p.getWorld().setTime(13000);
				p.sendMessage(Utils.chat("&7Time set to &6night"));
			} else {
				p.sendMessage(Utils.chat("&cPermission denied"));
			}
		}
		
		if(cmd.getName().equalsIgnoreCase("midnight")) {
			if(sender.hasPermission("ucommands.time")) {
				p.getWorld().setTime(18000);
				p.sendMessage(Utils.chat("&7Time set to &6midnight"));
			} else {
				p.sendMessage(Utils.chat("&cPermission denied"));
			}
		}
		return false;
	}
}