package me.dayton.uCommands.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.dayton.uCommands.Config.Utils;

public class FeedCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("feed")) {
			if(p.hasPermission("ucommands.feed")) {
				if(args.length == 0) {
					p.setFoodLevel(20);
					p.sendMessage(Utils.chat("&6Nourished"));
				} else if((args.length == 1) && p.hasPermission("ucommands.feed.others")) {
					Player targetPlayer = Bukkit.getPlayer(args[0]);
					
					if(targetPlayer != null) {
						targetPlayer.setFoodLevel(20);
						targetPlayer.sendMessage(Utils.chat("&6Nourished"));
						p.sendMessage(Utils.chat("&6" + targetPlayer.getName() + "&7 nourished"));
					} else {
						p.sendMessage(Utils.chat("&cPlayer " + args[0] + " not found"));
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