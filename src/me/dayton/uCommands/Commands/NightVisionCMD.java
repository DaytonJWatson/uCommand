package me.dayton.uCommands.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.dayton.uCommands.Config.Utils;

public class NightVisionCMD implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
		Player p = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("nightvision")) {
			if (sender.hasPermission("ucommands.nightvision")) {
				if (p.hasPotionEffect(PotionEffectType.NIGHT_VISION) == false) {
					p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 400000, 100));
					p.sendMessage(Utils.chat("&7Night Vision &6enabled"));
				} else if (p.hasPotionEffect(PotionEffectType.NIGHT_VISION) == true) {
					p.removePotionEffect(PotionEffectType.NIGHT_VISION);
					p.sendMessage(Utils.chat("&7Night Vision &6disabled"));
				}
			} else {
				p.sendMessage(Utils.chat("&cPermission denied"));
			}
		}
		return false;
	}
}