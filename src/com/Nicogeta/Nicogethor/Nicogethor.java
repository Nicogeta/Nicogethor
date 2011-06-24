package com.Nicogeta.Nicogethor;

import java.util.logging.Logger;

import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.Nicogeta.Nicogethor.NicogethorPlayerListener;
import com.Nicogeta.Nicogethor.Nicogethor;
import com.nijiko.permissions.PermissionHandler;
import com.nijikokun.bukkit.Permissions.Permissions;

public class Nicogethor extends JavaPlugin {
	private static final Logger log = Logger.getLogger("Minecraft");
	public static PermissionHandler Permissions;
	private final NicogethorPlayerListener playerListener = new NicogethorPlayerListener(this);
	public static String currentFilter;


	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvent(Event.Type.PLAYER_CHAT, playerListener, Priority.Normal, this);
		pm.registerEvent(Event.Type.ENTITY_DAMAGE, playerListener, Priority.Normal, this);
		setupPermissions();
		log.info("Nicogethor ENABLE (by Nicogeta)");
		log.info("Nicogethor ver 0.7");
	}

	private void setupPermissions() {
		Plugin test = this.getServer().getPluginManager().getPlugin("Permissions");

		if (Nicogethor.Permissions == null) 
		{
			if (test != null) {
				Nicogethor.Permissions = ((Permissions)test).getHandler();
				log.info("Nicogethor has detected Permissions!");
			} else {
				log.info("Nicogethor has not detected Permissions.");
			}
		}
	}

	public void onDisable() {
		log.info("Nicogethor DISABLE");
	}
}
