package me.dayton.uCommands.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.dayton.uCommands.Config.Utils;

public class FlyCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("fly")) {
			if(p.hasPermission("ucommands.fly")) {
				if(args.length == 0) {
					if(p.getAllowFlight() == false) {
						p.setAllowFlight(true);
						p.sendMessage(Utils.chat("&7Flight &6enabled"));
					} else if(p.getAllowFlight() == true) {
						p.setAllowFlight(false);
						p.sendMessage(Utils.chat("&7Flight &6disabled"));
					}
				} else if((args.length == 1) && p.hasPermission("ucommands.fly.others")) {
					Player targetPlayer = Bukkit.getPlayer(args[0]);
					
					if(targetPlayer.getAllowFlight() == false) {
						targetPlayer.setAllowFlight(true);
						targetPlayer.sendMessage(Utils.chat("&7Flight &6enabled"));
						p.sendMessage(Utils.chat("&7Flight &6enabled &7for &6" + args[0]));
					} else if(targetPlayer.getAllowFlight() == true) {
						targetPlayer.setAllowFlight(false);
						targetPlayer.sendMessage(Utils.chat("&7Flight &6disabled"));
						p.sendMessage(Utils.chat("&7Flight &6disabled &7for &6" + args[0]));
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