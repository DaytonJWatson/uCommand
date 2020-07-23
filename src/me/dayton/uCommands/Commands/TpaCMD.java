package me.dayton.uCommands.Commands;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.dayton.uCommands.Config.Utils;

public class TpaCMD implements CommandExecutor {
	
	private HashMap<Player, Player> tpa = new HashMap<Player, Player>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("tpa")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (args.length == 1) {
					Player player2 = Bukkit.getPlayer(args[0]);
					if (player2 != null && player2.isOnline()) {
						if (!player.getName().equals(player2.getName())) {
							if (!tpa.containsKey(player)) {
								tpa.put(player2, player);
								player2.sendMessage(Utils.chat("&7" + player.getName() + " has requested to &6teleport &7to you, &6accept &7it using /tpaccept"));
								player.sendMessage(Utils.chat("&7You requested to &6teleport &7to " + player2.getName()));
							} else {
								player.sendMessage(Utils.chat("&7You have already requested to &6teleport &7to " + player2.getName()));
							}
						} else {
							player.sendMessage(Utils.chat("&cPlayer not found"));
						}

					} else {
						player.sendMessage(Utils.chat("&cPlayer not found"));
					}
				} else {
					player.sendMessage(Utils.chat("&7/tpa <&6player&7>"));
				}
			}
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("tpaccept")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (tpa.containsKey(player)) {
					Player player1 = tpa.get(player);
					if (player1 != null && player1.isOnline()) {
						player1.teleport(player.getLocation());
						player1.sendMessage(Utils.chat("&7" + player.getName() + " accepted your &6teleport &7request!"));
						player.sendMessage(Utils.chat("&7You accepted " + player1.getName() + "'s &6teleport &7request!"));
						tpa.remove(player);
					} else {
						player.sendMessage(Utils.chat("&cPlayer not found"));

						tpa.remove(player);
					}
				} else {
					player.sendMessage(Utils.chat("&7You dont have a &6pending&7 teleport request"));
				}
			}
			return true;
		}		
		return false;
	}
}	