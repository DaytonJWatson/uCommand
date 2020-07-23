package me.dayton.uCommands.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import me.dayton.uCommands.Config.Utils;
import me.dayton.uCommands.Methods.Spawn;

public class PlayerRespawn implements Listener {
	
	@EventHandler
	public void onPlayerRespawn(PlayerRespawnEvent e) {
		Player p = e.getPlayer();
		
		if(p.getBedSpawnLocation() == null) {
			e.setRespawnLocation(Spawn.getLocation());
			p.sendMessage(Utils.chat("&7Your bed is &6missing &7or &6obstructed!"));
		} else {
			p.sendMessage(Utils.chat("&7Taking you to your &6bed"));
		}
	}
}
