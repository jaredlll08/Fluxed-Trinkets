package com.jared.electrifiedtrinkets.client.render.gui.slot;

import com.jared.electrifiedtrinkets.api.recipes.SolderingRegistry;
import com.jared.electrifiedtrinkets.items.ETItems;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class SlotAddon extends Slot {

	public SlotAddon(IInventory arg0, int arg1, int arg2, int arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		return true;
	}
}
