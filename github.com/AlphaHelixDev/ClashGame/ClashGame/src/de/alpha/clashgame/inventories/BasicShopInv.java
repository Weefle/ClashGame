package de.alpha.clashgame.inventories;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.alpha.clashgame.Core;
import de.alpha.clashgame.utils.itemcreator.ItemCreator;

public class BasicShopInv {
	
	private static Inventory inv = Core.getInstance().getServer().createInventory(null, 54, "§6Shop");
	
	public static void fillBasicShop() {
		
		for(int i = 0; i < 54; i++) {
			
			ItemStack is = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
			ItemMeta meta = is.getItemMeta();
			meta.setDisplayName(" ");
			is.setItemMeta(meta);
			
			inv.setItem(i, is);
			
		}
		
		inv.setItem(10, new ItemCreator(Material.CHEST).setName("§aSchätze").build());
		inv.setItem(13, new ItemCreator(Material.GOLD_NUGGET).setName("§6Resourcen").build());
		inv.setItem(16, new ItemCreator(Material.BEACON).setName("§bDeco").build());
		inv.setItem(37, new ItemCreator(Material.IRON_SWORD).setName("§cArmee").build());
		inv.setItem(40, new ItemCreator(Material.BOW).setName("§4Verteidigung").build());
		inv.setItem(43, new ItemCreator(Material.LEATHER_CHESTPLATE).setName("§eSchild").build());
		
		
	}
	
	public static void openBasicShop(Player p) {
		p.openInventory(inv);
	}

}
