package de.alpha.clashgame.listener;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import de.alpha.clashcore.mysqlapi.MySQLManager;
import de.alpha.clashgame.Core;
import de.alpha.clashgame.buildingsmanagers.RatHausManager;
import de.alpha.clashgame.utils.PlayerSpawner;

public class JoinListener implements Listener {
	
	private static ArrayList<String> players = new ArrayList<>();
	
	@EventHandler(priority = EventPriority.HIGH)
	public void onJoin(PlayerJoinEvent e) {
		
		final Player p = e.getPlayer();
		
//		p.teleport(PlayerLoginListener.getPlayerWorld());
		if(Bukkit.getWorld(p.getName()) == null) {
			players.add(p.getName());
			if(isInTutorial(p) == true) {
				MySQLManager.exInsertQry("Doerfer", p.getName(), p.getUniqueId().toString(), "1", "0", "0", "0", "0", "0", "0");
				RatHausManager.setRatHausLvL("1", p);
				for(Player all : Bukkit.getOnlinePlayers()) {
					p.hidePlayer(all);
				}

				Core.getInstance().getServer().getScheduler().scheduleSyncDelayedTask(Core.getInstance(), new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						p.teleport(PlayerLoginListener.getPlayerWorld());
						
						PlayerSpawner.setSpawn(p);
					}
				}, 20);
				
				
			} else {
				for(Player all : Bukkit.getOnlinePlayers()) {
					p.showPlayer(all);
				}
			}
		}
		
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		
		Player p = e.getPlayer();
		
		Core.getInstance().getServer().unloadWorld(p.getDisplayName(), true);
		if(isInTutorial(p) == true) {
			players.remove(p.getName());
		}
		
	}
	
	public static boolean isInTutorial(Player p) {
		if(players.contains(p.getName())) {
			return true;
		} else {
			return false;
		}
	}
	
}
