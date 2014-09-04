package com.jared.electrifiedtrinkets.items.equipment;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ItemAmuletRespiratory extends ModAmulet {

	public ItemAmuletRespiratory(int maxCapacity, int usage) {
		super(maxCapacity, usage);
	}

	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
		if (itemstack.stackTagCompound == null) {
			itemstack.stackTagCompound = new NBTTagCompound();
		}
		if (getEnergyStored(itemstack) > 0 && player.isInWater()) {
			player.setAir(0);
			itemstack.stackTagCompound.setInteger("energy", itemstack.stackTagCompound.getInteger("energy") - 5);
		}

		if (itemstack.stackTagCompound.getInteger("energy") < -1) {
			itemstack.stackTagCompound.setInteger("energy", 0);
		}

		if (itemstack.stackTagCompound.getInteger("energy") <= 0) {
			if (player instanceof EntityPlayer) {
				EntityPlayer play = (EntityPlayer) player;
				if (play.isInWater())
					play.motionY = -0.01;

			}
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
		if (itemstack.stackTagCompound == null) {
			itemstack.stackTagCompound = new NBTTagCompound();
		}
		if (itemstack.stackTagCompound.getInteger("energy") == 0 && player.isInWater()) {

			return false;
		}
		return true;
	}

}
