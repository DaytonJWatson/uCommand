package me.dayton.uCommands.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.dayton.uCommands.Config.Utils;

public class PrivateMessageCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("msg")) {
			if(p.hasPermission("ucommands.msg")) {
				Player targetPlayer = Bukkit.getPlayer(args[0]);
				StringBuilder sb = new StringBuilder();
				
				if(args[0].equalsIgnoreCase(p.getName())) {
					p.sendMessage(Utils.chat("&7You cant &6private message &7yourself!"));
				} else {
					if(targetPlayer != null) {
						for(int i = 1; i < args.length; i++) {
							sb.append(args[i]);
							if(i < args.length) {
								sb.append(" ");
							}
							
							targetPlayer.sendMessage(Utils.chat("&6" + p.getName() + " &8: &6" + targetPlayer.getName() + "&7 >> &f" + sb.toString()));
							p.sendMessage(Utils.chat("&6" + p.getName() + " &8: &6" + targetPlayer.getName() + "&7 >> &f" + sb.toString()));
						}
					} else {
						p.sendMessage(Utils.chat("&cPlayer " + args[0] + " not found"));
					}	
				}
			}
		}
		return false;
	}
}