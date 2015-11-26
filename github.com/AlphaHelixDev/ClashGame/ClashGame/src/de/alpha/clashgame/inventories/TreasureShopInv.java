package de.alpha.clashgame.inventories;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.alpha.clashgame.Core;
import de.alpha.clashgame.utils.itemcreator.ItemCreator;

public class TreasureShopInv {
	
	private static Inventory inv = Core.getInstance().getServer().createInventory(null, 9, "§aSchätze");
	
	public static void fillTreasureShop() {
		
		for(int i = 0; i < 9; i++) {
			
			ItemStack is = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
			ItemMeta meta = is.getItemMeta();
			meta.setDisplayName(" ");
			is.setItemMeta(meta);
			
			inv.setItem(i, is);
			
		}
		inv.setItem(3, new ItemCreator(Material.GOLD_INGOT).setName("§610k Gold").setLore(new String[]{
				"", "§864 Emeralds" //Preis mit Dennis bereden!
		}).build());
		
		inv.setItem(5, new ItemCreator(Material.DIAMOND).setName("§a10k Elexir").setLore(new String[]{
				"", "§864 Emeralds"	//Preis mit Dennis bereden!
		}).build());
		
		
		
		
	}
	
	public static void openTreasureShop(Player p) {
		p.openInventory(inv);
	}

}
