package me.dayton.uCommands.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.dayton.uCommands.Config.Utils;

public class TeleportCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("teleport")) {
			if(p.hasPermission("ucommands.teleport")) {
				if(args.length == 0) {
					p.sendMessage(Utils.chat("&7/teleport <&6player1&7> <&6player2&7> | &6X Y Z"));
				} else if((args.length == 1) && (Bukkit.getPlayerExact(args[0]) != null)) {
					Player targetPlayer = p.getServer().getPlayer(args[0]);
					Location targetPlayerLoc = targetPlayer.getLocation();
					
					p.teleport(targetPlayerLoc);
					p.sendMessage(Utils.chat("&7Player &6" + p.getName() + " &7teleported to &6" + targetPlayer.getName()));
				} else if((args.length == 2) && (Bukkit.getPlayerExact(args[0]) != null) && (Bukkit.getPlayerExact(args[1]) != null) && p.hasPermission("ucommands.teleport.others")) {
					Player targetPlayer1 = p.getServer().getPlayer(args[0]);
					Player targetPlayer2 = p.getServer().getPlayer(args[1]);
					Location targetPlayer2Loc = targetPlayer2.getLocation();
					
					targetPlayer1.teleport(targetPlayer2Loc);
					targetPlayer1.sendMessage(Utils.chat("&7You Have been teleported to &6" + targetPlayer1.getName()));
					p.sendMessage(Utils.chat("&7Teleported &6" + targetPlayer1.getName() + " &7to &6" + targetPlayer2.getName()));
				} else if((args.length == 3) && p.hasPermission("ucommands.teleport.coords")) {
					if(args[1].equalsIgnoreCase("~")) {
						Integer x1 = Integer.parseInt((args[0]));
						Integer z1 = Integer.parseInt((args[2]));
						int y1 = p.getWorld().getHighestBlockYAt(x1, z1);
						Location teleportLoc1 = new Location(p.getWorld(), x1, y1 + 1, z1);
						
						p.teleport(teleportLoc1);
						p.sendMessage(Utils.chat("&7Teleported to &6" + x1 + "&7,&6 " + y1 + "&7,&6 " + z1));
					} else {
						Integer x = Integer.parseInt((args[0]));
						Integer y = Integer.parseInt((args[1]));
						Integer z = Integer.parseInt((args[2]));
						Location teleportLoc = new Location(p.getWorld(), x, y, z);
						
						p.teleport(teleportLoc);
						p.sendMessage(Utils.chat("&7Teleported to &6" + x + "&7,&6 " + y + "&7,&6 " + z));
					}
				} else {
					p.sendMessage(Utils.chat("&7/teleport <&6player1&7> <&6player2&7> | &6X Y Z"));
				}
			} else {
				p.sendMessage(Utils.chat("&cPermission denied"));
			}
		}	
		return false;
	}
}