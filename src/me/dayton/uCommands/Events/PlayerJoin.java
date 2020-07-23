package me.dayton.uCommands.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.dayton.uCommands.Config.Utils;
import me.dayton.uCommands.Methods.Spawn;

public class PlayerJoin implements Listener {
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		if(!p.hasPlayedBefore()) {
			Spawn.spawn(p);
			p.sendMessage(Utils.chat("&7Taking you to &6spawn"));
		}
	}
}
