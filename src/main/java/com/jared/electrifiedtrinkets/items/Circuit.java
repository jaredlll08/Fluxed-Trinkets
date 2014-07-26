package com.jared.electrifiedtrinkets.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class Circuit extends Item {

	public Circuit() {
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	
}
