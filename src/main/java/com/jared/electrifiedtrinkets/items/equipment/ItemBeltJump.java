package com.jared.electrifiedtrinkets.items.equipment;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import baubles.api.BaublesApi;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ItemBeltJump extends ModBelt {

	public ItemBeltJump(int maxCapacity, int usage) {
		super(maxCapacity, usage);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void onPlayerJump(LivingJumpEvent event) {
		if (event.entityLiving instanceof EntityPlayer) {

			EntityPlayer player = (EntityPlayer) event.entityLiving;
			ItemStack belt = BaublesApi.getBaubles(player).getStackInSlot(3);

			

			if (belt != null && belt.getItem() == this && belt.stackTagCompound.getInteger("energy") > 0) {
				if (belt.stackTagCompound == null) {
					belt.stackTagCompound = new NBTTagCompound();
				}
				player.motionY += 0.3;
				player.fallDistance = -1F;
				belt.stackTagCompound.setInteger("energy", belt.stackTagCompound.getInteger("energy") - 20);
			}
			if (belt != null && belt.getItem() == this && belt.stackTagCompound.getInteger("energy") == 0) {
				player.motionY -= 0.41999998688697815D;
			}
		}
	}

	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
		if (itemstack.stackTagCompound == null) {
			itemstack.stackTagCompound = new NBTTagCompound();
		}
		if (itemstack.stackTagCompound.getInteger("energy") < 0) {
			itemstack.stackTagCompound.setInteger("energy", 0);
		}
	}

	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player) {

	}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {

	}

	@Override
	public boolean canEquip(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}

	@Override
	public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}

}
