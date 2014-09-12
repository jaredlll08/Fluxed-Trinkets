package com.jared.fluxedtrinkets.client.render.gui.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.jared.fluxedtrinkets.items.FTItems;

public class SlotSolderingIron extends Slot {

	public SlotSolderingIron(IInventory arg0, int arg1, int arg2, int arg3) {
		super(arg0, arg1, arg2, arg3);
	}
	public int getSlotStackLimit() {
		return 1;
	}
	@Override
	public boolean isItemValid(ItemStack stack) {
		if (stack.getItem() == new FTItems().solderingIron) {
			return true;
		}

		return false;
	}

}
