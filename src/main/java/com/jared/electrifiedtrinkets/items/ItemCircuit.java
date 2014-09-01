package com.jared.electrifiedtrinkets.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.jared.electrifiedtrinkets.util.NBTHelper;
import com.jared.electrifiedtrinkets.util.StringUtils;

public class ItemCircuit extends Item {
	String type;
	public ItemCircuit(String type) {
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.type = type;
	}

	public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5)
	{
		NBTHelper.setString(stack, "ETEffect", type);
	}
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
			if (NBTHelper.getString(stack, "ETEffect") == "air") {
				list.add(StringUtils.GRAY + "-Air");
			}
			if (NBTHelper.getString(stack, "ETEffect") == "ground") {

			}
			if (NBTHelper.getString(stack, "ETEffect") == "") {

			}
			if (NBTHelper.getString(stack, "ETEffect") == "") {

			}
			if (NBTHelper.getString(stack, "ETEffect") == "") {

			}

	}

}
