package me.dayton.uCommands.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.dayton.uCommands.Config.Utils;

public class GodCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("god")) {
			if(p.hasPermission("ucommands.god")) {
				if(args.length == 0) {
					if(p.isInvulnerable() == false) {
						p.setInvulnerable(true);
						p.sendMessage(Utils.chat("&7Godmode &6enabled"));
					} else if(p.isInvulnerable() == true) {
						p.setInvulnerable(false);
						p.sendMessage(Utils.chat("&7Godmode &6disabled"));
					}
				} else if((args.length == 1) && p.hasPermission("ucommands.god.others")) {
					Player targetPlayer = Bukkit.getPlayer(args[0]);
					
					if(targetPlayer.isInvulnerable() == false) {
						targetPlayer.setInvulnerable(true);
						targetPlayer.sendMessage(Utils.chat("&7Godmode &6enabled"));
						p.sendMessage(Utils.chat("&7Godmode &6enabled &7for &6" + args[0]));
					} else if(targetPlayer.isInvulnerable() == true) {
						targetPlayer.setInvulnerable(false);
						targetPlayer.sendMessage(Utils.chat("&7Godmode &6disabled"));
						p.sendMessage(Utils.chat("&7Godmode &6disabled &7for &6" + args[0]));
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