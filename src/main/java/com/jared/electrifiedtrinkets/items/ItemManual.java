package com.jared.electrifiedtrinkets.items;

import com.jared.electrifiedtrinkets.ElectrifiedTrinkets;
import com.jared.electrifiedtrinkets.ModInfo;

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

	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		player.openGui(ElectrifiedTrinkets.instance, 1, world, (int)player.posX, (int)player.posY, (int) player.posZ);
		return stack;
	}

}
