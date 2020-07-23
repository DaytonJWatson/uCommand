package me.dayton.uCommands;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.dayton.uCommands.Commands.BackCMD;
import me.dayton.uCommands.Commands.BedCMD;
import me.dayton.uCommands.Commands.CoordsCMD;
import me.dayton.uCommands.Commands.EnderchestCMD;
import me.dayton.uCommands.Commands.FeedCMD;
import me.dayton.uCommands.Commands.FlyCMD;
import me.dayton.uCommands.Commands.GamemodeCMD;
import me.dayton.uCommands.Commands.GiveCMD;
import me.dayton.uCommands.Commands.GodCMD;
import me.dayton.uCommands.Commands.HealCMD;
import me.dayton.uCommands.Commands.HomeCMD;
import me.dayton.uCommands.Commands.InvseeCMD;
import me.dayton.uCommands.Commands.NightVisionCMD;
import me.dayton.uCommands.Commands.PrivateMessageCMD;
import me.dayton.uCommands.Commands.SpawnCMD;
import me.dayton.uCommands.Commands.SuicideCMD;
import me.dayton.uCommands.Commands.TeleportCMD;
import me.dayton.uCommands.Commands.TimeCMD;
import me.dayton.uCommands.Commands.TopCMD;
import me.dayton.uCommands.Commands.TpaCMD;
import me.dayton.uCommands.Commands.VanishCMD;
import me.dayton.uCommands.Commands.WeatherCMD;
import me.dayton.uCommands.Commands.WorkbenchCMD;
import me.dayton.uCommands.Config.Config;
import me.dayton.uCommands.Events.PlayerChat;
import me.dayton.uCommands.Events.PlayerJoin;
import me.dayton.uCommands.Events.PlayerQuit;
import me.dayton.uCommands.Events.PlayerRespawn;

public class Main extends JavaPlugin {
	
	private File spawnFile = new File(getDataFolder(), "spawn.yml");
	public YamlConfiguration spawn = YamlConfiguration.loadConfiguration(this.spawnFile);
	
	private File homesFile = new File(getDataFolder(), "homes.yml");
	public YamlConfiguration homes = YamlConfiguration.loadConfiguration(this.homesFile);
	
	private static Main instance;
	
	public void onEnable() {
		instance = this;
		
		loadCommands();
		loadEvents();
		loadFiles();
	}
	
	public void onDisable() {
		
	}
	
	public void loadCommands() {
		getCommand("back").setExecutor(new BackCMD());
		getCommand("bed").setExecutor(new BedCMD());
		getCommand("coords").setExecutor(new CoordsCMD());
		getCommand("day").setExecutor(new TimeCMD());
		getCommand("enderchest").setExecutor(new EnderchestCMD());
		getCommand("feed").setExecutor(new FeedCMD());
		getCommand("fly").setExecutor(new FlyCMD());
		getCommand("give").setExecutor(new GiveCMD());
		getCommand("gm").setExecutor(new GamemodeCMD());
		getCommand("god").setExecutor(new GodCMD());
		getCommand("heal").setExecutor(new HealCMD());
		getCommand("home").setExecutor(new HomeCMD());
		getCommand("invsee").setExecutor(new InvseeCMD());
		getCommand("midnight").setExecutor(new TimeCMD());
		getCommand("pm").setExecutor(new PrivateMessageCMD());
		getCommand("nightvision").setExecutor(new NightVisionCMD());
		getCommand("night").setExecutor(new TimeCMD());
		getCommand("noon").setExecutor(new TimeCMD());
		getCommand("sethome").setExecutor(new HomeCMD());
		getCommand("setspawn").setExecutor(new SpawnCMD());
		getCommand("spawn").setExecutor(new SpawnCMD());
		getCommand("suicide").setExecutor(new SuicideCMD());
		getCommand("teleport").setExecutor(new TeleportCMD());
		getCommand("top").setExecutor(new TopCMD());
		getCommand("tpa").setExecutor(new TpaCMD());
		getCommand("tpaccept").setExecutor(new TpaCMD());
		getCommand("vanish").setExecutor(new VanishCMD());
		getCommand("weather").setExecutor(new WeatherCMD());
		getCommand("workbench").setExecutor(new WorkbenchCMD());
	}
	
	public void loadEvents() {
		PluginManager pm = getServer().getPluginManager();
		
		pm.registerEvents(new BackCMD(), this);
		pm.registerEvents(new PlayerChat(), this);
		pm.registerEvents(new PlayerJoin(), this);
		pm.registerEvents(new PlayerQuit(), this);
		pm.registerEvents(new PlayerRespawn(), this);
	}
	
	public void loadFiles() {
		Config c = new Config(this);
		c.createConfig();
		
		if (!spawnFile.exists()) {
			saveSpawnFile();
			getLogger().warning("spawn.yml not found, creating one for you!");
		}
		
		if (!homesFile.exists()) {
			saveHomesFile();
			getLogger().warning("homes.yml not found, creating one for you!");
		}
	}
	
	public void saveSpawnFile() {
		try {
			this.spawn.save(this.spawnFile);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void saveHomesFile() {
	    try {
	    	this.homes.save(this.homesFile);
	    }
	    catch (IOException e) {
	    	e.printStackTrace();
	    }
	}
	
	public static FileConfiguration getConfiguration() {
		return getInstance().getConfig();
	}
	
	public static Main getInstance() {
		return instance;
	}
}