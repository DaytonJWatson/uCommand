package me.dayton.uCommands.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.dayton.uCommands.Config.Utils;

public class WorkbenchCMD implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
		Player p = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("workbench")) {
			if (sender.hasPermission("ucommands.workbench")) {
				p.openWorkbench(null, true);
				p.sendMessage(Utils.chat("&7Opening a virtual &6workbench"));
			} else {
				p.sendMessage(Utils.chat("&cPermission denied"));
			}
		}
		return false;
	}
}