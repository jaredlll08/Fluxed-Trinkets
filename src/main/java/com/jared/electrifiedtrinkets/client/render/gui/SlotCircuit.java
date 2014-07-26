package com.jared.electrifiedtrinkets.client.render.gui;

import com.jared.electrifiedtrinkets.items.ETItems;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotCircuit extends Slot {

	public SlotCircuit(IInventory arg0, int arg1, int arg2, int arg3) {
		super(arg0, arg1, arg2, arg3);
	}
	
	public boolean isItemValid(ItemStack stack){
		return stack.getItem() == ETItems.circuit;
	}

}
