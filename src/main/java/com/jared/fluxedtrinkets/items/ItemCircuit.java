package com.jared.fluxedtrinkets.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemCircuit extends Item {
	String type;
	String effect;
	public ItemCircuit(String type) {
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.type = type;
		this.effect = type;
	}

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		list.add(getEffect());
	}

}
