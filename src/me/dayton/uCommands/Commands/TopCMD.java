package me.dayton.uCommands.Commands;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.dayton.uCommands.Config.Utils;

public class TopCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] arg) {
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("top")) {
			if(sender.hasPermission("ucommands.top")) {
				World world = p.getWorld();
				int x = p.getLocation().getBlockX();
				int z = p.getLocation().getBlockZ();
				int y = p.getWorld().getHighestBlockYAt(x, z);
				Location topBlock = (new Location(world, x + .5, y + 1, z + .5));
				
				p.teleport(topBlock);
				p.sendMessage(Utils.chat("&7Taking you to the &6top"));
			} else {
				p.sendMessage(Utils.chat("&cPermission denied"));
			}
		}
		return false;
	}
}