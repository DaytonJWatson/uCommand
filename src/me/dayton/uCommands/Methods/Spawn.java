package me.dayton.uCommands.Methods;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.dayton.uCommands.Main;
import me.dayton.uCommands.Config.Utils;

public class Spawn {
	public static void setLocation(Location l) {
		Main.getInstance().spawn.set("spawn.world", l.getWorld().getName());
		Main.getInstance().spawn.set("spawn.x", l.getX());
		Main.getInstance().spawn.set("spawn.y", l.getY());
		Main.getInstance().spawn.set("spawn.z", l.getZ());
		Main.getInstance().spawn.set("spawn.yaw", (float) l.getYaw());
		Main.getInstance().spawn.set("spawn.pitch", (float) l.getPitch());
		Main.getInstance().saveSpawnFile();
	}

	public static Location getLocation() {
		String world = Main.getInstance().spawn.getString("spawn.world");

		if (world == null || world.equalsIgnoreCase("")) {
			return null;
		} else {
			World w = Bukkit.getServer().getWorld(world);
			double x = Main.getInstance().spawn.getDouble("spawn.x");
			double y = Main.getInstance().spawn.getDouble("spawn.y");
			double z = Main.getInstance().spawn.getDouble("spawn.z");
			float yaw = Main.getInstance().spawn.getInt("spawn.yaw");
			float pitch = Main.getInstance().spawn.getInt("spawn.pitch");

			return new Location(w, x, y, z, yaw, pitch);
		}
	}

	public static void teleport(Player p, boolean message, CommandSender sender) {
		Location location = getLocation();

		if (location == null) {
			Main.getInstance().getLogger().warning("Spawn not set!");

			p.sendMessage(Utils.chat("&7Spawn location not &6set"));
		} else {
			if (!location.getChunk().isLoaded())
				location.getChunk().load();

			p.teleport(location);
		}
	}

	public static void spawn(final Player p) {
		p.sendMessage(Utils.chat("&7Taking you to &6spawn"));
		Spawn.teleport(p, true, null);
	}
}