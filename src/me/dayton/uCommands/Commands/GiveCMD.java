package me.dayton.uCommands.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.dayton.uCommands.Config.Utils;

public class GiveCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("give")) {
			if(p.hasPermission("ucommands.give")) {
				if(args.length == 0) {
					p.sendMessage(Utils.chat("&7/give [&6player&7] <&6item&7> <&6amount&7>"));
				} else if(args.length == 1) {
					Material itemType = Material.matchMaterial(args[0]);
					ItemStack item = new ItemStack(itemType);
					
					if(itemType != null) {
						p.getInventory().addItem(item);
						p.sendMessage(Utils.chat("&7Adding &6" + itemType + "&7 to your inventory"));
					} else {
						p.sendMessage(Utils.chat("&7Material &c" + itemType + "&7 doesnt exist"));
					}
				} else if(args.length == 2) {
					Material itemType = Material.matchMaterial(args[0]);
					ItemStack item = new ItemStack(itemType);
					Integer amt = Integer.parseInt(args[1]);
					
					if(itemType != null) {
						item.setAmount(amt);
						p.getInventory().addItem(item);
						p.sendMessage(Utils.chat("&7Adding &6" + itemType + "&7 to your inventory"));
					} else {
						p.sendMessage(Utils.chat("&7Material &c" + itemType + "&7 doesnt exist"));
					}
				} else if((args.length == 3) && p.hasPermission("ucommands.give.others")) {
					if(Bukkit.getPlayer(args[0]) != null) {
						Material itemType = Material.matchMaterial(args[1]);
						ItemStack item = new ItemStack(itemType);
						Integer amt = Integer.parseInt(args[2]);
						Player targetPlayer = Bukkit.getPlayer(args[0]);
						
						if(itemType != null) {
							item.setAmount(amt);
							targetPlayer.getInventory().addItem(item);
							targetPlayer.sendMessage(Utils.chat("&7Adding &6" + itemType + "&7 to your inventory"));
							p.sendMessage(Utils.chat("&7Adding &6" + itemType + "&7 to &6" + targetPlayer.getName() + "'s &7inventory"));
						} else {
							p.sendMessage(Utils.chat("&7Material &c" + itemType + "&7 doesnt exist"));
						}
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