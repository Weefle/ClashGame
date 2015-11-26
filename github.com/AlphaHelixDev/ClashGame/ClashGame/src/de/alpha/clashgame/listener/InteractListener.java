package de.alpha.clashgame.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import de.alpha.clashgame.buildingsmanagers.ResourceManager;
import de.alpha.clashgame.inventories.EnchInv;

public class InteractListener implements Listener {
	
	@EventHandler
	public void onClickOnEnchTable(PlayerInteractEvent e) {
		
		Player p = e.getPlayer();
		
		if(e.getClickedBlock() == null) return;
		
		if(e.getClickedBlock().getType().equals(Material.ENCHANTMENT_TABLE)) {
			e.setCancelled(true);
			EnchInv.openEnchTable(p);
		}
		
		if(e.getClickedBlock().getType().equals(Material.GOLD_ORE)) {
			e.setCancelled(true);
			ResourceManager.addGold(50000, p);
		}
		
	}

}
