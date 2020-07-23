package me.dayton.uCommands.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.dayton.uCommands.Config.Utils;

public class WeatherCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("weather")) {
			if(sender.hasPermission("ucommands.weather")) {
				if(args.length == 0) {
					p.sendMessage(Utils.chat("&7/weather &6rain&7 | &6clear&7 | &6storm"));
				} else if(args.length == 1) {
					if(args[0].equalsIgnoreCase("clear")) {
						p.getWorld().setStorm(false);
						p.sendMessage(Utils.chat("&7Weather set to &6clear"));
					}
					
					if(args[0].equalsIgnoreCase("rain")) {
						p.getWorld().setStorm(true);
						p.sendMessage(Utils.chat("&7Weather set to &6rain"));
					}
					
					if(args[0].equalsIgnoreCase("storm")) {
						p.getWorld().setThundering(true);
						p.sendMessage(Utils.chat("&7Weather set to &6storm"));
					}
				}
			} else {
				p.sendMessage(Utils.chat("&cPermission denied"));
			}
		}
		return false;
	}	
}