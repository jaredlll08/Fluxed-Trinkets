package com.jared.electrifiedtrinkets.items;

import com.jared.electrifiedtrinkets.util.NBTHelper;

import cofh.api.energy.IEnergyContainerItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemSolderingIron extends Item implements IEnergyContainerItem{

	public ItemSolderingIron(){
		NBTHelper.setInteger(new ItemStack(this),  "energy", 0);
		this.setMaxStackSize(1);
	}
	
	@Override
	public int receiveEnergy(ItemStack container, int maxReceive, boolean simulate) {
		return 0;
	}

	@Override
	public int extractEnergy(ItemStack container, int maxExtract, boolean simulate) {
		return 0;
	}

	@Override
	public int getEnergyStored(ItemStack container) {
		return NBTHelper.getInt(container, "energy");
	}

	@Override
	public int getMaxEnergyStored(ItemStack container) {
		return 10000;
	}

}
