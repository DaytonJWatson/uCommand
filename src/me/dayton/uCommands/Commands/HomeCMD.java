package me.dayton.uCommands.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import me.dayton.uCommands.Config.Utils;
import me.dayton.uCommands.Methods.Homes;

public class HomeCMD implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("sethome")) {
			if(sender.hasPermission("ucommands.sethome")) {
				if ((sender instanceof ConsoleCommandSender)) {
					
				} else if ((sender instanceof Player)) {
					Homes.setHome(p);
					p.sendMessage(Utils.chat("&7Home location &6set"));
				} else {
					p.sendMessage(Utils.chat("&cError! Contact developer"));
				}
			} else {
				p.sendMessage(Utils.chat("&cPermission denied"));
			}
		} else if (cmd.getName().equalsIgnoreCase("home")) {
			if(sender.hasPermission("ucommands.home")) {
				if ((sender instanceof ConsoleCommandSender)) {
					
				} else if ((sender instanceof Player)) {
					if (Homes.homeIsNull(p)) {
						p.sendMessage(Utils.chat("&7Home location not &6set"));
					} else {
						Homes.goHome(p);
						p.sendMessage(Utils.chat("&7Taking you to your &6home"));
					}
				}
			} else {
				p.sendMessage(Utils.chat("&cPermission denied"));
			}
		}
		return false;
	}
}