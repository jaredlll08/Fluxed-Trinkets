package com.jared.electrifiedtrinkets.client.render.gui.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.jared.electrifiedtrinkets.items.ETItems;

public class SlotSolderingIron extends Slot {

	public SlotSolderingIron(IInventory arg0, int arg1, int arg2, int arg3) {
		super(arg0, arg1, arg2, arg3);
	}
	public int getSlotStackLimit() {
		return 1;
	}
	@Override
	public boolean isItemValid(ItemStack stack) {
		if (stack.getItem() == new ETItems().solderingIron) {
			return true;
		}

		return false;
	}

}
