package com.jared.electrifiedtrinkets.client.render.gui.slot;

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

		ItemStack[] addons = new ItemStack[5];

		addons[0] = new ItemStack(Items.sugar, 1, OreDictionary.WILDCARD_VALUE);
		addons[1] = new ItemStack(Items.feather, 1, OreDictionary.WILDCARD_VALUE);
		addons[2] = new ItemStack(Items.clay_ball, 1, OreDictionary.WILDCARD_VALUE);
		addons[3] = new ItemStack(Items.blaze_powder, 1, OreDictionary.WILDCARD_VALUE);
		addons[4] = new ItemStack(Items.fish, 1, OreDictionary.WILDCARD_VALUE);

		int i = 0;
		while (i < addons.length) {
			if (stack.getItem() == addons[i].getItem()) {
				return true;
			}
			i++;

		}

		return true;
	}
}
