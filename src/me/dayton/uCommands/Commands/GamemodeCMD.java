package me.dayton.uCommands.Commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.dayton.uCommands.Config.Utils;

public class GamemodeCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("gm")) {
			if(p.hasPermission("ucommands.gamemode")) {
				if(args.length == 0) {
					if(p.getGameMode().equals(GameMode.SURVIVAL)) {
						p.setGameMode(GameMode.CREATIVE);
						p.sendMessage(Utils.chat("&7Gamemode set to &6Creative"));
					} else if(p.getGameMode().equals(GameMode.CREATIVE)) {
						p.setGameMode(GameMode.SURVIVAL);
						p.sendMessage(Utils.chat("&7Gamemode set to &6Survival"));
					}
				} else if(args.length == 1) {
					if(args[0].equals("1") || args[0].equalsIgnoreCase("creative")) {
						p.setGameMode(GameMode.CREATIVE);
						p.sendMessage(Utils.chat("&7Gamemode set to &6Creative"));
					}
					if(args[0].equals("2") || args[0].equalsIgnoreCase("survival")) {
						p.setGameMode(GameMode.SURVIVAL);
						p.sendMessage(Utils.chat("&7Gamemode set to &6Survival"));
					}
					if(args[0].equals("3") || args[0].equalsIgnoreCase("spectator")) {
						p.setGameMode(GameMode.SPECTATOR);
						p.sendMessage(Utils.chat("&7Gamemode set to &6Spectator"));
					}
					if(args[0].equals("4") || args[0].equalsIgnoreCase("adventure")) {
						p.setGameMode(GameMode.ADVENTURE);
						p.sendMessage(Utils.chat("&7Gamemode set to &6Adventure"));
					}
				} else if((args.length == 2) && p.hasPermission("ucommands.gamemode.others")) {
					Player targetPlayer = Bukkit.getPlayer(args[0]);
					
					if(args[1].equals("1") || args[0].equalsIgnoreCase("creative")) {
						targetPlayer.setGameMode(GameMode.CREATIVE);
						targetPlayer.sendMessage(Utils.chat("&7Gamemode set to &6Creative"));
						p.sendMessage(Utils.chat("&6" + targetPlayer.getName() + " &7gamemode set to &6Creative"));
					}
					if(args[1].equals("2") || args[0].equalsIgnoreCase("survival")) {
						targetPlayer.setGameMode(GameMode.SURVIVAL);
						targetPlayer.sendMessage(Utils.chat("&7Gamemode set to &6Survival"));
						p.sendMessage(Utils.chat("&6" + targetPlayer.getName() + " &7gamemode set to &6Survival"));
					}
					if(args[1].equals("3") || args[0].equalsIgnoreCase("spectator")) {
						targetPlayer.setGameMode(GameMode.SPECTATOR);
						targetPlayer.sendMessage(Utils.chat("&7Gamemode set to &6Spectator"));
						p.sendMessage(Utils.chat("&6" + targetPlayer.getName() + " &7gamemode set to &6Spectator"));
					}
					if(args[1].equals("4") || args[0].equalsIgnoreCase("adventure")) {
						targetPlayer.setGameMode(GameMode.ADVENTURE);
						targetPlayer.sendMessage(Utils.chat("&7Gamemode set to &6Adventure"));
						p.sendMessage(Utils.chat("&6" + targetPlayer.getName() + " &7gamemode set to &6Adventure"));
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