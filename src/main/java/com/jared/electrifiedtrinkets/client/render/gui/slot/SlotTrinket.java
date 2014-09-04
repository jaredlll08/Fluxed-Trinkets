package com.jared.electrifiedtrinkets.client.render.gui.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.jared.electrifiedtrinkets.items.equipment.ModAmulet;
import com.jared.electrifiedtrinkets.items.equipment.ModBelt;
import com.jared.electrifiedtrinkets.items.equipment.ModRing;

public class SlotTrinket extends Slot {

	public SlotTrinket(IInventory arg0, int arg1, int arg2, int arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	@Override
	public boolean isItemValid(ItemStack stack) {

		if (stack.getItem() instanceof ModBelt || stack.getItem() instanceof ModAmulet || stack.getItem() instanceof ModRing) {
			return true;
		}
		

		return false;
	}

}
