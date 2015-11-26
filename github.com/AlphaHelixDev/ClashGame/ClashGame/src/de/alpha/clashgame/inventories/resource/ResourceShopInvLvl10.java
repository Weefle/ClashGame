package de.alpha.clashgame.inventories.resource;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.alpha.clashgame.Core;
import de.alpha.clashgame.buildingsmanagers.ElexirSammlerManager;
import de.alpha.clashgame.buildingsmanagers.ElexirlagerManager;
import de.alpha.clashgame.buildingsmanagers.GoldLagerManager;
import de.alpha.clashgame.buildingsmanagers.GoldMineManager;
import de.alpha.clashgame.buildingsmanagers.RatHausManager;
import de.alpha.clashgame.listener.PlayerClickListener;
import de.alpha.clashgame.utils.itemcreator.ItemCreator;

public class ResourceShopInvLvl10 {
	
	private static Player p = PlayerClickListener.p; 
	private static Inventory inv = Core.getInstance().getServer().createInventory(null, 27, "§6Resourcen");
	
	public static void fillResourceShop() {
		
		for(int i = 0; i < 27; i++) {
			
			ItemStack is = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
			ItemMeta meta = is.getItemMeta();
			meta.setDisplayName(" ");
			is.setItemMeta(meta);
			
			inv.setItem(i, is);
			
		}
		
		if(RatHausManager.getRatHausLvL(p) == 10){
			
			{	if(ElexirlagerManager.getAmount(p) <= 3) {
					inv.setItem(10, new ItemCreator(Material.DIAMOND_BLOCK).setName("§bElexirlager").setLore(new String[]{
							"", "§71 max. in Level 1"
					}).build());
				} else {
					inv.setItem(10, new ItemCreator(Material.DIAMOND_BLOCK).setName("§8Elexirlager").setLore(new String[]{
							"", "§cDu hast schon 1 ElexirLager!"
					}).build());
				}
			}
			
			{	if(ElexirSammlerManager.getAmount(p) <= 6) {
					inv.setItem(12, new ItemCreator(Material.DIAMOND).setName("§bElexiersammler").setLore(new String[]{
							"", "§71 max. On Level 1"
					}).build());
				} else {
					inv.setItem(12, new ItemCreator(Material.DIAMOND).setName("§8Elexiersammler").setLore(new String[]{
							"", "§cDu hast schon 1 ElexirSammler!"
					}).build());
				}
			}
			
			{	if(GoldMineManager.getAmount(p)<= 6) {
			
					inv.setItem(14, new ItemCreator(Material.GOLD_INGOT).setName("§6Goldmine").setLore(new String[]{
							"", "§71 max. On Level 1"
					}).build());
				} else {
					inv.setItem(14, new ItemCreator(Material.GOLD_INGOT).setName("§6Goldmine").setLore(new String[]{
							"", "§cDu hast schon 1 GoldMine!"
					}).build());
				}
			}
			{	if(GoldLagerManager.getAmount(p) <= 3) {
					inv.setItem(16, new ItemCreator(Material.GOLD_BLOCK).setName("§6Goldlager").setLore(new String[]{
							"", "§71 max. On Level 1"
					}).build());
				}else {
					inv.setItem(16, new ItemCreator(Material.GOLD_BLOCK).setName("§6Goldlager").setLore(new String[]{
							"", "§cDu hast schon 1 GoldLager!"
					}).build());
				}
			}
			
			
			
		}
		
		inv.setItem(13, new ItemCreator(Material.EMERALD).setName("§aBauhütte").setLore(new String[]{
				"", "§75 max."
		}).build());
		
	}
	
	public static void openResourceShop(Player p) {
		p.openInventory(inv);
	}

}
