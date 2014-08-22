package com.jared.electrifiedtrinkets.items;

import com.jared.electrifiedtrinkets.ElectrifiedTrinkets;
import com.jared.electrifiedtrinkets.ModInfo;
import com.jared.electrifiedtrinkets.client.render.gui.GuiEManual;
import com.jared.electrifiedtrinkets.util.GuiHandler;

import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.client.Minecraft;
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
		if(!world.isRemote){
			GuiHandler.openManual();
		}
		
		return stack;
	}

}
