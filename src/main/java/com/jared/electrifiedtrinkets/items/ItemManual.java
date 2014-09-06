package com.jared.electrifiedtrinkets.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.jared.electrifiedtrinkets.proxy.ClientProxy;
import com.jared.electrifiedtrinkets.util.GuiHandler;

public class ItemManual extends Item {

	public ItemManual() {
		this.setMaxStackSize(1);
		this.setFull3D();
	}

	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if(!world.isRemote){
			ClientProxy.openManual();
		}
		
		return stack;
	}

}
