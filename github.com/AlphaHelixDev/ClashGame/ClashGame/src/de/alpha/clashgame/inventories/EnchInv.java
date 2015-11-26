package de.alpha.clashgame.inventories;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.alpha.clashgame.Core;
import de.alpha.clashgame.utils.itemcreator.ItemCreator;

public class EnchInv {
	
	private static Inventory inv = Core.getInstance().getServer().createInventory(null, 27, "§cVerwaltung");
	
	public static void fillEnchTable() {
		
		for(int i = 0; i < 27; i++) {
			
			ItemStack is = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
			ItemMeta meta = is.getItemMeta();
			meta.setDisplayName(" ");
			is.setItemMeta(meta);
			
			inv.setItem(i, is);
			
		}
		
		inv.setItem(10, new ItemCreator(Material.IRON_SWORD).setName("§cAngreifen").build());
		inv.setItem(12, new ItemCreator(Material.CHEST).setName("§6Shop").build());
		inv.setItem(14, new ItemCreator(Material.NETHER_STAR).setName("§bReaktivieren §7[Alles]").build());
		inv.setItem(16, new ItemCreator(Material.WORKBENCH).setName("§aUpgrade §7[Rathaus]").build());
		
		
	}
	
	public static void openEnchTable(Player p) {
		p.openInventory(inv);
	}

}
