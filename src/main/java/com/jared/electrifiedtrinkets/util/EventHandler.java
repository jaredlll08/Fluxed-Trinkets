package com.jared.electrifiedtrinkets.util;

import com.jared.electrifiedtrinkets.items.ETItems;

import baubles.api.BaublesApi;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.BonemealEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventHandler {

	public EventHandler() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void boneMeal(BonemealEvent event) {
		if (!event.world.isRemote) {
			ItemStack[] baubles = new ItemStack[4];
			for (int i = 0; i < baubles.length; i++) {
				if (BaublesApi.getBaubles(event.entityPlayer).getStackInSlot(i) != null) {
					baubles[i] = BaublesApi.getBaubles(event.entityPlayer).getStackInSlot(i);
				}
			}

			if (baubles[1] != null && baubles[1].getItem() == ETItems.ringFarming) {
				if (baubles[1].stackTagCompound == null) {
					baubles[1].stackTagCompound = new NBTTagCompound();
				}

				if (baubles[1].stackTagCompound.getInteger("energy") <= 0) {
					event.setResult(Result.ALLOW);
				}

				if (baubles[1].stackTagCompound.getInteger("energy") > 0) {
					event.setResult(Result.DENY);
					applyBonemeal(baubles[1], event.world, event.x, event.y, event.z, event.entityPlayer);
					
					baubles[1].stackTagCompound.setInteger("energy", baubles[1].stackTagCompound.getInteger("energy") - 500);
				}
			}

			if (baubles[2] != null && baubles[2].getItem() == ETItems.ringFarming) {
				if (baubles[2].stackTagCompound == null) {
					baubles[2].stackTagCompound = new NBTTagCompound();
				}

				if (baubles[2].stackTagCompound.getInteger("energy") <= 0) {
					event.setResult(Result.ALLOW);
				}

				if (baubles[2].stackTagCompound.getInteger("energy") > 0) {
					event.setResult(Result.DENY);
					applyBonemeal(baubles[2], event.world, event.x, event.y, event.z, event.entityPlayer);
					baubles[2].stackTagCompound.setInteger("energy", baubles[2].stackTagCompound.getInteger("energy") - 500);
				}
			}
		}
	}

	public static boolean applyBonemeal(ItemStack p_150919_0_, World p_150919_1_, int p_150919_2_, int p_150919_3_, int p_150919_4_, EntityPlayer player) {
		Block block = p_150919_1_.getBlock(p_150919_2_, p_150919_3_, p_150919_4_);

		if (block instanceof IGrowable) {
			IGrowable igrowable = (IGrowable) block;

			if (igrowable.func_149851_a(p_150919_1_, p_150919_2_, p_150919_3_, p_150919_4_, p_150919_1_.isRemote)) {
				if (!p_150919_1_.isRemote) {
					if (igrowable.func_149852_a(p_150919_1_, p_150919_1_.rand, p_150919_2_, p_150919_3_, p_150919_4_)) {
						igrowable.func_149853_b(p_150919_1_, p_150919_1_.rand, p_150919_2_, p_150919_3_, p_150919_4_);
						igrowable.func_149853_b(p_150919_1_, p_150919_1_.rand, p_150919_2_, p_150919_3_, p_150919_4_);
						igrowable.func_149853_b(p_150919_1_, p_150919_1_.rand, p_150919_2_, p_150919_3_, p_150919_4_);

					}

					// --p_150919_0_.stackSize;
				}

				return true;
			}
		}

		return false;
	}

}
