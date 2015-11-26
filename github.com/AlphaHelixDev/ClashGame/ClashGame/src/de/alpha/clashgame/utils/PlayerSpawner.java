package de.alpha.clashgame.utils;

import org.bukkit.entity.Player;

import de.alpha.clashgame.Core;

public class PlayerSpawner {

	public static void setSpawn(Player p) {
		
		Core.getInstance().getServer().dispatchCommand(Core.getInstance().getServer().getConsoleSender(), "spawnpoint " + p.getName());
	
	}
	
}
