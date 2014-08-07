package com.jared.electrifiedtrinkets.items.equipment;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import com.jared.electrifiedtrinkets.util.NBTHelper;

public class ItemBeltSpeed extends ModBelt {

	public ItemBeltSpeed(int maxCapacity, int usage) {
		super(maxCapacity, usage);
	}

	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
		if (itemstack.stackTagCompound == null) {
			itemstack.stackTagCompound = new NBTTagCompound();
		}

		if (itemstack.stackTagCompound.getInteger("energy") > 0) {
			if (player instanceof EntityPlayer) {
				EntityPlayer play = (EntityPlayer) player;
				if ((play.onGround || play.capabilities.isFlying) && play.moveForward > 0F)
					play.moveFlying(0F, 1F, play.capabilities.isFlying ? 0.050F : 0.07F);
				if (play.motionX != 0 || play.motionZ != 0)
					itemstack.stackTagCompound.setInteger("energy", itemstack.stackTagCompound.getInteger("energy") - 10);
			}
		}
		if (itemstack.stackTagCompound.getInteger("energy") < -1) {
			itemstack.stackTagCompound.setInteger("energy", 0);
		}

		if (itemstack.stackTagCompound.getInteger("energy") <= 0) {

			if (player instanceof EntityPlayer) {
				EntityPlayer play = (EntityPlayer) player;
				if ((play.onGround || play.capabilities.isFlying) && play.moveForward > 0F)
					play.moveFlying(0F, 1F, play.capabilities.isFlying ? -0.01F : -0.03F);

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
		return true;
	}

}
