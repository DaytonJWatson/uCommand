package me.dayton.uCommands.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.dayton.uCommands.Config.Utils;

public class EnderchestCMD implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
		Player p = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("enderchest")) {
			if (sender.hasPermission("ucommands.enderchest")) {
				if (args.length == 0) {
					p.openInventory(p.getEnderChest());
					p.sendMessage(Utils.chat("&7Opening your &6enderchest"));
				} else if((args.length == 1) && Bukkit.getPlayerExact(args[0]) != null && p.hasPermission("ucommands.enderchest.others")) {
					Player targetPlayer = p.getServer().getPlayer(args[0]);
					
					if(targetPlayer != null) {
						p.openInventory(targetPlayer.getEnderChest());
						p.sendMessage(Utils.chat("&7Opening &6" + targetPlayer.getName() + "'s &7Enderchest"));
					} else {
						p.sendMessage("&cPlayer " + args[0] + " not found");
					}
				}
			} else {
				p.sendMessage(Utils.chat("&cPermission denied"));
			}
		}
		return false;
	}
}