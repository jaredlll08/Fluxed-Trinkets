package com.jared.electrifiedtrinkets.client.render.gui.slot;

import java.util.List;

import baubles.api.IBauble;

import com.jared.electrifiedtrinkets.items.ETItems;
import com.jared.electrifiedtrinkets.items.ItemCircuit;
import com.jared.electrifiedtrinkets.items.equipment.ModAmulet;
import com.jared.electrifiedtrinkets.items.equipment.ModBelt;
import com.jared.electrifiedtrinkets.items.equipment.ModRing;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class SlotTrinket extends Slot {

	public SlotTrinket(IInventory arg0, int arg1, int arg2, int arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	@Override
	public boolean isItemValid(ItemStack stack) {

		if (stack.getItem() instanceof ModBelt || stack.getItem() instanceof ModAmulet || stack.getItem() instanceof ModRing) {
			return true;
		}
		
		if(stack.getItem() == ETItems.beltEmpty){
			return true;
		}

		return false;
	}

}
