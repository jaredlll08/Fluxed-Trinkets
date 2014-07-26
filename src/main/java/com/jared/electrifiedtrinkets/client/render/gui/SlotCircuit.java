package com.jared.electrifiedtrinkets.client.render.gui;

import com.jared.electrifiedtrinkets.items.ETItems;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class SlotCircuit extends Slot {

	public SlotCircuit(IInventory arg0, int arg1, int arg2, int arg3) {
		super(arg0, arg1, arg2, arg3);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack){
		ItemStack circuit = new ItemStack(ETItems.circuit, 1, OreDictionary.WILDCARD_VALUE);
	if(stack == circuit){
		return true;
	}
		
		if(stack.getItem() == ETItems.circuit || stack.getItem() == ETItems.speedCircuit){
			return true;
		}
		return stack.getItem() == ETItems.circuit;
	}

}
