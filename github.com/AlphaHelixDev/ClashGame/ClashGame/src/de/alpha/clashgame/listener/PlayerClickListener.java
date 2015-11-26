package de.alpha.clashgame.listener;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import de.alpha.clashgame.buildingsmanagers.ElexirlagerManager;
import de.alpha.clashgame.buildingsmanagers.RatHausManager;
import de.alpha.clashgame.buildingsmanagers.ResourceManager;
import de.alpha.clashgame.inventories.BasicShopInv;
import de.alpha.clashgame.inventories.TreasureShopInv;
import de.alpha.clashgame.inventories.resource.ResourceShopInvLvL1;
import de.alpha.clashgame.inventories.resource.ResourceShopInvLvl10;
import de.alpha.clashgame.inventories.resource.ResourceShopInvLvl2;
import de.alpha.clashgame.inventories.resource.ResourceShopInvLvl3;
import de.alpha.clashgame.inventories.resource.ResourceShopInvLvl4;
import de.alpha.clashgame.inventories.resource.ResourceShopInvLvl5;
import de.alpha.clashgame.inventories.resource.ResourceShopInvLvl6;
import de.alpha.clashgame.inventories.resource.ResourceShopInvLvl7;
import de.alpha.clashgame.inventories.resource.ResourceShopInvLvl8;
import de.alpha.clashgame.inventories.resource.ResourceShopInvLvl9;
import de.alpha.clashgame.utils.itemcreator.ItemCreator;

public class PlayerClickListener implements Listener {
	
	public static Player p;
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		
		if(e.getWhoClicked() instanceof Player) {
			p = (Player) e.getWhoClicked();
			if(e.getClickedInventory() != null) {
				if(e.getClickedInventory().getName().equalsIgnoreCase("§6Shop")) {
					e.setCancelled(true);
					
					if(e.getCurrentItem().getType().equals(Material.CHEST)) {
						TreasureShopInv.openTreasureShop(p);
					}
					
					if(e.getCurrentItem().getType().equals(Material.GOLD_NUGGET)) {
						if(RatHausManager.getRatHausLvL(p) == 1) {
							ResourceShopInvLvL1.fillResourceShop();
							ResourceShopInvLvL1.openResourceShop(p);
						}
						
						if(RatHausManager.getRatHausLvL(p) == 2) {
							ResourceShopInvLvl2.fillResourceShop();
							ResourceShopInvLvl2.openResourceShop(p);
						}
						
						if(RatHausManager.getRatHausLvL(p) == 3) {
							ResourceShopInvLvl3.fillResourceShop();
							ResourceShopInvLvl3.openResourceShop(p);
						}
						
						if(RatHausManager.getRatHausLvL(p) == 4) {
							ResourceShopInvLvl4.fillResourceShop();
							ResourceShopInvLvl4.openResourceShop(p);
						}
						
						if(RatHausManager.getRatHausLvL(p) == 5) {
							ResourceShopInvLvl5.fillResourceShop();
							ResourceShopInvLvl5.openResourceShop(p);
						}
						
						if(RatHausManager.getRatHausLvL(p) == 6) {
							ResourceShopInvLvl6.fillResourceShop();
							ResourceShopInvLvl6.openResourceShop(p);
						}
						
						if(RatHausManager.getRatHausLvL(p) == 7) {
							ResourceShopInvLvl7.fillResourceShop();
							ResourceShopInvLvl7.openResourceShop(p);
						}
						
						if(RatHausManager.getRatHausLvL(p) == 8) {
							ResourceShopInvLvl8.fillResourceShop();
							ResourceShopInvLvl8.openResourceShop(p);
						}
						
						if(RatHausManager.getRatHausLvL(p) == 9) {
							ResourceShopInvLvl9.fillResourceShop();
							ResourceShopInvLvl9.openResourceShop(p);
						}
						
						if(RatHausManager.getRatHausLvL(p) == 10) {
							ResourceShopInvLvl10.fillResourceShop();
							ResourceShopInvLvl10.openResourceShop(p);
						}
					}
					
				}
				
				if(e.getClickedInventory().getName().equalsIgnoreCase("§cVerwaltung")) {
					e.setCancelled(true);
					
					if(e.getCurrentItem().getType().equals(Material.IRON_SWORD)) {
						//Open Angreifen
					}
					
					if(e.getCurrentItem().getType().equals(Material.CHEST)) {
						BasicShopInv.openBasicShop(p);
					}
					
					if(e.getCurrentItem().getType().equals(Material.NETHER_STAR)) {
						//Reparieren
					}
					
					if(e.getCurrentItem().getType().equals(Material.WORKBENCH)) {
						if(RatHausManager.getRatHausLvL(p) == 1) {
							if(ResourceManager.getGold(p) >= 1000) {
								ResourceManager.removeGold(1000, p);
								
								int current = RatHausManager.getRatHausLvL(p);
								int newlvl = current + 1;
								String newLvL = Integer.toString(newlvl);
								
								RatHausManager.upgrade(p, newLvL);
								return;
							}
						}
						
						if(RatHausManager.getRatHausLvL(p) == 2) {
							if(ResourceManager.getGold(p) >= 4000) {
								ResourceManager.removeGold(4000, p);
								
								int current = RatHausManager.getRatHausLvL(p);
								int newlvl = current + 1;
								String newLvL = Integer.toString(newlvl);
								
								RatHausManager.upgrade(p, newLvL);
								return;
							}
						}
						
						if(RatHausManager.getRatHausLvL(p) == 3) {
							if(ResourceManager.getGold(p) >= 25000) {
								ResourceManager.removeGold(25000, p);
								
								int current = RatHausManager.getRatHausLvL(p);
								int newlvl = current + 1;
								String newLvL = Integer.toString(newlvl);
								
								RatHausManager.upgrade(p, newLvL);
								return;
							}
						}
						
						if(RatHausManager.getRatHausLvL(p) == 4) {
							if(ResourceManager.getGold(p) >= 150000) {
								ResourceManager.removeGold(150000, p);
								
								int current = RatHausManager.getRatHausLvL(p);
								int newlvl = current + 1;
								String newLvL = Integer.toString(newlvl);
								
								RatHausManager.upgrade(p, newLvL);
								return;
							}
						}
						
						if(RatHausManager.getRatHausLvL(p) == 5) {
							if(ResourceManager.getGold(p) >= 750000) {
								ResourceManager.removeGold(750000, p);
								
								int current = RatHausManager.getRatHausLvL(p);
								int newlvl = current + 1;
								String newLvL = Integer.toString(newlvl);
								
								RatHausManager.upgrade(p, newLvL);
								return;
							}
						}
						
						if(RatHausManager.getRatHausLvL(p) == 6) {
							if(ResourceManager.getGold(p) >= 1200000) {
								ResourceManager.removeGold(1200000, p);
								
								int current = RatHausManager.getRatHausLvL(p);
								int newlvl = current + 1;
								String newLvL = Integer.toString(newlvl);
								
								RatHausManager.upgrade(p, newLvL);
								return;
							}
						}
						
						if(RatHausManager.getRatHausLvL(p) == 7) {
							if(ResourceManager.getGold(p) >= 2000000) {
								ResourceManager.removeGold(2000000, p);
								
								int current = RatHausManager.getRatHausLvL(p);
								int newlvl = current + 1;
								String newLvL = Integer.toString(newlvl);
								
								RatHausManager.upgrade(p, newLvL);
								return;
							}
						}
						
						if(RatHausManager.getRatHausLvL(p) == 8) {
							if(ResourceManager.getGold(p) >= 3000000) {
								ResourceManager.removeGold(3000000, p);
								
								int current = RatHausManager.getRatHausLvL(p);
								int newlvl = current + 1;
								String newLvL = Integer.toString(newlvl);
								
								RatHausManager.upgrade(p, newLvL);
								return;
							}
						}
						
						if(RatHausManager.getRatHausLvL(p) == 9) {
							if(ResourceManager.getGold(p) >= 4000000) {
								ResourceManager.removeGold(4000000, p);
								
								int current = RatHausManager.getRatHausLvL(p);
								int newlvl = current + 1;
								String newLvL = Integer.toString(newlvl);
								
								RatHausManager.upgrade(p, newLvL);
								return;
							}
						}
						
					}
					
				}
				
				if(e.getClickedInventory().getName().equalsIgnoreCase("§aSchätze")) {
					e.setCancelled(true);
					
					ItemStack eme = new ItemStack(Material.EMERALD);
					
					if(e.getCurrentItem().getType().equals(Material.GOLD_INGOT)) {
						
						if(p.getInventory().containsAtLeast(eme, 64)) {
							p.getInventory().removeItem(new ItemStack[]{
									new ItemCreator(Material.EMERALD).setAmount(64).build()
							});
							p.getInventory().addItem(new ItemCreator(Material.GOLD_INGOT).setName("§6Gold").setAmount(30).build());
							p.playSound(p.getLocation(), Sound.NOTE_PLING, 10, 10);
						} else {
							p.sendMessage("§7Du hast nicht genug §aSmaragde§7!");
						}
					}
					
					if(e.getCurrentItem().getType().equals(Material.DIAMOND)) {
						if(p.getInventory().containsAtLeast(eme, 64)) {
							p.getInventory().removeItem(new ItemStack[]{
									new ItemCreator(Material.EMERALD).setAmount(64).build()
							});
							p.getInventory().addItem(new ItemCreator(Material.DIAMOND).setName("§bDiamant").setAmount(16).build()); //Crafting Event machen!
							p.playSound(p.getLocation(), Sound.NOTE_PLING, 10, 10);
						} else {
							p.sendMessage("§7Du hast nicht genug §aSmaragde§7!");
						}
					}
					
				}
				
				
				if(e.getClickedInventory().getName().equalsIgnoreCase("§6Resourcen")) {
					e.setCancelled(true);
					
					ItemStack gold = new ItemCreator(Material.GOLD_INGOT).setAmount(5).build();
					
					if(e.getCurrentItem().getType().equals(Material.DIAMOND_BLOCK)) {
						if(RatHausManager.getRatHausLvL(p) == 1) {
							if(ElexirlagerManager.getAmount(p) == 0) {
								if(p.getInventory().containsAtLeast(gold, 1)) {
									p.getInventory().removeItem(gold);
									p.getInventory().addItem(new ItemCreator(Material.DIAMOND_BLOCK).setLore(new String[]{
											"", "Plaziere den Block wo das Elexirlager gebaut werden soll!"
									}).setName("§bElexirlager §7[LvL:1]").build());
									ElexirlagerManager.addAmount(1, p);
									ResourceShopInvLvL1.fillResourceShop();
									ResourceShopInvLvL1.openResourceShop(p);
									
								}
							}
						}

						if(RatHausManager.getRatHausLvL(p) == 2) {
							if(ElexirlagerManager.getAmount(p) == 0) {
								if(p.getInventory().containsAtLeast(gold, 1)) {
									p.getInventory().removeItem(gold);
									p.getInventory().addItem(new ItemCreator(Material.DIAMOND_BLOCK).setLore(new String[]{
											"", "Plaziere den Block wo das Elexirlager gebaut werden soll!"
									}).setName("§bElexirlager §7[LvL:1]").build());
									ElexirlagerManager.addAmount(1, p);
									ResourceShopInvLvl2.fillResourceShop();
									ResourceShopInvLvl2.openResourceShop(p);
									
								}
							}
						}
						
						if(RatHausManager.getRatHausLvL(p) == 3) {
							if(ElexirlagerManager.getAmount(p) <= 1) {
								if(p.getInventory().containsAtLeast(gold, 1)) {
									p.getInventory().removeItem(gold);
									p.getInventory().addItem(new ItemCreator(Material.DIAMOND_BLOCK).setLore(new String[]{
											"", "Plaziere den Block wo das Elexirlager gebaut werden soll!"
									}).setName("§bElexirlager §7[LvL:1]").build());
									ElexirlagerManager.addAmount(1, p);
									ResourceShopInvLvl3.fillResourceShop();
									ResourceShopInvLvl3.openResourceShop(p);
									
								}
							}
						}
						
						if(RatHausManager.getRatHausLvL(p) == 4) {
							if(ElexirlagerManager.getAmount(p) <= 1) {
								if(p.getInventory().containsAtLeast(gold, 1)) {
									p.getInventory().removeItem(gold);
									p.getInventory().addItem(new ItemCreator(Material.DIAMOND_BLOCK).setLore(new String[]{
											"", "Plaziere den Block wo das Elexirlager gebaut werden soll!"
									}).setName("§bElexirlager §7[LvL:1]").build());
									ElexirlagerManager.addAmount(1, p);
									ResourceShopInvLvl4.fillResourceShop();
									ResourceShopInvLvl4.openResourceShop(p);
									
								}
							}
						}
						
						if(RatHausManager.getRatHausLvL(p) == 5) {
							if(ElexirlagerManager.getAmount(p) <= 1) {
								if(p.getInventory().containsAtLeast(gold, 1)) {
									p.getInventory().removeItem(gold);
									p.getInventory().addItem(new ItemCreator(Material.DIAMOND_BLOCK).setLore(new String[]{
											"", "Plaziere den Block wo das Elexirlager gebaut werden soll!"
									}).setName("§bElexirlager §7[LvL:1]").build());
									ElexirlagerManager.addAmount(1, p);
									ResourceShopInvLvl5.fillResourceShop();
									ResourceShopInvLvl5.openResourceShop(p);
									
								}
							}
						}
						
						if(RatHausManager.getRatHausLvL(p) == 6) {
							if(ElexirlagerManager.getAmount(p) <= 1) {
								if(p.getInventory().containsAtLeast(gold, 1)) {
									p.getInventory().removeItem(gold);
									p.getInventory().addItem(new ItemCreator(Material.DIAMOND_BLOCK).setLore(new String[]{
											"", "Plaziere den Block wo das Elexirlager gebaut werden soll!"
									}).setName("§bElexirlager §7[LvL:1]").build());
									ElexirlagerManager.addAmount(1, p);
									ResourceShopInvLvl6.fillResourceShop();
									ResourceShopInvLvl6.openResourceShop(p);
									
								}
							}
						}
						
						if(RatHausManager.getRatHausLvL(p) == 7) {
							if(ElexirlagerManager.getAmount(p) <= 1) {
								if(p.getInventory().containsAtLeast(gold, 1)) {
									p.getInventory().removeItem(gold);
									p.getInventory().addItem(new ItemCreator(Material.DIAMOND_BLOCK).setLore(new String[]{
											"", "Plaziere den Block wo das Elexirlager gebaut werden soll!"
									}).setName("§bElexirlager §7[LvL:1]").build());
									ElexirlagerManager.addAmount(1, p);
									ResourceShopInvLvl7.fillResourceShop();
									ResourceShopInvLvl7.openResourceShop(p);
									
								}
							}
						}
						
						if(RatHausManager.getRatHausLvL(p) == 8) {
							if(ElexirlagerManager.getAmount(p) <= 2) {
								if(p.getInventory().containsAtLeast(gold, 1)) {
									p.getInventory().removeItem(gold);
									p.getInventory().addItem(new ItemCreator(Material.DIAMOND_BLOCK).setLore(new String[]{
											"", "Plaziere den Block wo das Elexirlager gebaut werden soll!"
									}).setName("§bElexirlager §7[LvL:1]").build());
									ElexirlagerManager.addAmount(1, p);
									ResourceShopInvLvl8.fillResourceShop();
									ResourceShopInvLvl8.openResourceShop(p);
									
								}
							}
						}
						
						if(RatHausManager.getRatHausLvL(p) == 9) {
							if(ElexirlagerManager.getAmount(p) <= 3) {
								if(p.getInventory().containsAtLeast(gold, 1)) {
									p.getInventory().removeItem(gold);
									p.getInventory().addItem(new ItemCreator(Material.DIAMOND_BLOCK).setLore(new String[]{
											"", "Plaziere den Block wo das Elexirlager gebaut werden soll!"
									}).setName("§bElexirlager §7[LvL:1]").build());
									ElexirlagerManager.addAmount(1, p);
									ResourceShopInvLvl9.fillResourceShop();
									ResourceShopInvLvl9.openResourceShop(p);
									
								}
							}
						}
						
						if(RatHausManager.getRatHausLvL(p) == 10) {
							if(ElexirlagerManager.getAmount(p) <= 3) {
								if(p.getInventory().containsAtLeast(gold, 1)) {
									p.getInventory().removeItem(gold);
									p.getInventory().addItem(new ItemCreator(Material.DIAMOND_BLOCK).setLore(new String[]{
											"", "Plaziere den Block wo das Elexirlager gebaut werden soll!"
									}).setName("§bElexirlager §7[LvL:1]").build());
									ElexirlagerManager.addAmount(1, p);
									ResourceShopInvLvl10.fillResourceShop();
									ResourceShopInvLvl10.openResourceShop(p);
									
								}
							}
						}
					}
					
					if(e.getCurrentItem().getType().equals(Material.DIAMOND)) {
						
					}
					
				}
				
			}
		}
		
	}
	
	
	
	
	
	
	
	
	@EventHandler
	public void onBlockTransform(CraftItemEvent e) {
		e.setCancelled(true);
	}

}
