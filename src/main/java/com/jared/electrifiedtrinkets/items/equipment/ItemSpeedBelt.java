package com.jared.electrifiedtrinkets.items.equipment;

import com.jared.electrifiedtrinkets.util.NBTHelper;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ItemSpeedBelt extends ModBelt {

	public ItemSpeedBelt(int maxCapacity) {
		super(maxCapacity);
	}

	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
		NBTHelper.setBoolean(itemstack, "Battery", true);
			if (player instanceof EntityPlayer) {
				EntityPlayer play = (EntityPlayer) player;
				if ((play.onGround || play.capabilities.isFlying) && play.moveForward > 0F)
					play.moveFlying(0F, 1F, play.capabilities.isFlying ? 0.050F : 0.07F);
				if (play.motionX != 0 || play.motionZ != 0)
					NBTHelper.setInteger(itemstack, "energy", NBTHelper.getInt(itemstack, "energy") - 10);
			}
		if (NBTHelper.getInt(itemstack, "energy") < -1) {
			NBTHelper.setInteger(itemstack, "energy", 0);
		}

		if (NBTHelper.getInt(itemstack, "energy") <= 0) {
			if (NBTHelper.getBoolean(itemstack, "Speed")) {
				if (player instanceof EntityPlayer) {
					EntityPlayer play = (EntityPlayer) player;
					if ((play.onGround || play.capabilities.isFlying) && play.moveForward > 0F)
						play.moveFlying(0F, 1F, play.capabilities.isFlying ? -0.01F : -0.03F);

				}
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
