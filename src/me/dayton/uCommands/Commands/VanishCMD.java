package me.dayton.uCommands.Commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.dayton.uCommands.Config.Utils;

public class VanishCMD implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("Vanish")) {
			if(sender.hasPermission("ucommands.vanish")) {
				if(p.getGameMode() != GameMode.SPECTATOR) {
					p.setGameMode(GameMode.SPECTATOR);
					p.sendMessage(Utils.chat("&7You are now &6vanished"));
				} else if(p.getGameMode() == GameMode.SPECTATOR) {
					p.setGameMode(GameMode.SURVIVAL);
					p.sendMessage(Utils.chat("&7You are no longer &6vanished"));
				}
			} else {
				p.sendMessage(Utils.chat("&cPermission denied"));
			}
		}
		return false;
	}
}