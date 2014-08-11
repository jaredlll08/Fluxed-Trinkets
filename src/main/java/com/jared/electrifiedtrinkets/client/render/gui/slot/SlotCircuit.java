package com.jared.electrifiedtrinkets.client.render.gui.slot;

import java.util.List;

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
	public boolean isItemValid(ItemStack stack) {
		List<ItemStack> circuit = OreDictionary.getOres("circuit");
		List<ItemStack> advancedCircuit = OreDictionary.getOres("circuitAdvanced");

		for (int i = 0; i < circuit.size(); i++) {
			if (OreDictionary.itemMatches(circuit.get(i), stack, true)) {
				return true;
			}

		}
		for (int i = 0; i < advancedCircuit.size(); i++) {
			if (OreDictionary.itemMatches(advancedCircuit.get(i), stack, true)) {
				return true;
			}

		}

		return false;
	}

}
