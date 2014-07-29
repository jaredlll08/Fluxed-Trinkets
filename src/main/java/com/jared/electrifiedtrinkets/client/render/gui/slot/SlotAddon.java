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

		ItemStack[] addons = new ItemStack[3];
		{
			addons[0] = new ItemStack(Items.sugar, 1, OreDictionary.WILDCARD_VALUE);
			addons[1] = new ItemStack(Blocks.wool, 1, OreDictionary.WILDCARD_VALUE);
			addons[2] = new ItemStack(Items.slime_ball, 1, OreDictionary.WILDCARD_VALUE);

		}
		
		if (stack.getItem() == addons[0].getItem() || stack.getItem() == addons[1].getItem() || stack.getItem() == addons[2].getItem()) {
			return true;
		}

		return false;
	}
}
