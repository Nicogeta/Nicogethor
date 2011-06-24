package com.Nicogeta.Nicogethor;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerListener;


public class NicogethorPlayerListener extends PlayerListener {

	final Nicogethor plugin;

	boolean thor = false;

	public NicogethorPlayerListener(Nicogethor instance){
		plugin = instance;
	}
	public void onPlayerChat(PlayerChatEvent event){
		Player player = event.getPlayer();
		player.setDisplayName(player.getName());
		String playername = event.getPlayer().getDisplayName();
		Player target = null;
		boolean isExempt = false;

		if(Nicogethor.Permissions != null && Nicogethor.Permissions.has(player, "Nicogethor.exempt"))
			isExempt = true;

		String temp = event.getMessage();
		temp = temp.toLowerCase();

		if(!isExempt) {
			if(temp.contains("thor") || temp.contains("tor") || temp.contains("tohr") || temp.contains("thohr")){
				player.getWorld();
				target = player;
				event.getPlayer().getLocation();
				player.getServer().broadcastMessage(ChatColor.RED + "THOR: " + ChatColor.GREEN + "BAAAAAM :D");
				player.getServer().broadcastMessage(ChatColor.RED + "THOR: " + ChatColor.GREEN + "HAHAHAHA THOR IS WATCHING YOU " + playername + " :D");	
				if(target != null){
					target.getWorld().strikeLightning(target.getLocation()).setFireTicks(0);
				}
			}
		}
	}
}
