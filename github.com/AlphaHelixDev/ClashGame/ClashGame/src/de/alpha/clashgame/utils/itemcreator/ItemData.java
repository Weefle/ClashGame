package de.alpha.clashgame.utils.itemcreator;

import org.bukkit.inventory.ItemStack;

public abstract class ItemData {
	public abstract void applyOn(ItemStack applyOn) throws WrongDataException;
}
