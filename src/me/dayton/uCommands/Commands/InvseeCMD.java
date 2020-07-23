package me.dayton.uCommands.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.dayton.uCommands.Config.Utils;

public class InvseeCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("invsee")) {
			if(sender.hasPermission("ucommands.invsee")) {
				if(args.length == 0) {
					p.sendMessage(Utils.chat("&7/invsee <&6player&7>"));
				} else if(args.length == 1) {
					Player targetPlayer = Bukkit.getServer().getPlayer(args[0]);
					if(targetPlayer == null) {
						p.sendMessage(Utils.chat("&cPlayer " + args[0] + " not found"));
					} else {
						p.openInventory(targetPlayer.getInventory());
						p.sendMessage(Utils.chat("&7Viewing &6" + args[0] + "'s &7inventory"));
					}
				}
			} else {
				p.sendMessage(Utils.chat("&cPermission denied"));
			}
		}
		return false;
	}
}