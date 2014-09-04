package com.jared.electrifiedtrinkets.items.equipment;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ItemBeltStep extends ModBelt {

	public ItemBeltStep(int maxCapacity, int usage) {
		super(maxCapacity);
	}

	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
		if (itemstack.stackTagCompound == null) {
			itemstack.stackTagCompound = new NBTTagCompound();
		}

		if (itemstack.stackTagCompound.getInteger("energy") <= 0) {
			player.stepHeight = 0.7F;
			itemstack.stackTagCompound.setInteger("energy", 0);
		}
		if (itemstack.stackTagCompound.getInteger("energy") > 0) {
			if (new Random().nextInt(1200) == 0) {
				itemstack.stackTagCompound.setInteger("energy", itemstack.stackTagCompound.getInteger("energy") - 20);
			}
		}
	}

	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player) {
		player.stepHeight = 1.0F;
	}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
		player.stepHeight = 0.7F;
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
