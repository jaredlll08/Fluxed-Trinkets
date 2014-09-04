package com.jared.electrifiedtrinkets.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.jared.electrifiedtrinkets.util.NBTHelper;

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

	public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5) {
		NBTHelper.setString(stack, "ETEffect", type);
	}

	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		list.add(NBTHelper.getString(stack, "ETEffect"));
	}

}
