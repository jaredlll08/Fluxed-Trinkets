package com.jared.electrifiedtrinkets.client.render.gui.slot;

import java.util.List;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class SlotLeadWire extends Slot {

	public SlotLeadWire(IInventory arg0, int arg1, int arg2, int arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		List<ItemStack> list = OreDictionary.getOres("wireLead");
		int i = 0;
		while (list.iterator().hasNext()) {
			if (stack.getItem() == list.get(i).getItem()) {
				return true;
			} else {
				i++;
				return false;
			}

		}

		return false;
	}

}
