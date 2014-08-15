package com.jared.electrifiedtrinkets.items;

import com.jared.electrifiedtrinkets.ModInfo;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemCircuit extends Item {

	public ItemCircuit() {
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}

}
