package me.dayton.uCommands.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.dayton.uCommands.Config.Utils;

public class HealCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("heal")) {
			if(p.hasPermission("ucommands.heal")) {
				if(args.length == 0) {
					p.setHealth(20);
					p.setFoodLevel(20);
					p.setFireTicks(0);
					p.sendMessage(Utils.chat("&6Healed"));
				} else if((args.length == 1) && p.hasPermission("ucommands.heal.others")) {
					Player targetPlayer = Bukkit.getPlayer(args[0]);
					
					if(targetPlayer != null) {
						targetPlayer.setHealth(20);
						targetPlayer.setFoodLevel(20);
						targetPlayer.setFireTicks(0);
						targetPlayer.sendMessage(Utils.chat("&6Healed"));
						p.sendMessage(Utils.chat("&6" + targetPlayer.getName() + "&7 healed"));
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