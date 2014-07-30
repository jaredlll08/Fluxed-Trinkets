package com.jared.electrifiedtrinkets.items;

import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemManual extends Item {

	public ItemManual() {
		this.setMaxStackSize(1);
		this.setFull3D();
	}

	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
				

		return itemstack;
	}
}
