package com.jared.electrifiedtrinkets.items.equipment;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;

import com.jared.electrifiedtrinkets.potion.BaublesPotionEffect;

public class ItemRingMiningSpeed extends ModRing {

	public ItemRingMiningSpeed(int maxCapacity, int usage) {
		super(maxCapacity, usage);
	}

	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
		if (itemstack.stackTagCompound == null) {
			itemstack.stackTagCompound = new NBTTagCompound();
		}

		if (itemstack.stackTagCompound.getInteger("energy") > 0 && !player.isPotionActive(Potion.digSpeed.id)) {
			if (player instanceof EntityPlayer) {
				EntityPlayer play = (EntityPlayer) player;

//				BaublePotionHelper.addPotionEffect(play, new BaublesPotionEffect(Potion.digSlowdown.id, 1));
				player.addPotionEffect(new BaublesPotionEffect(Potion.digSpeed.id, 1));
				itemstack.stackTagCompound.setInteger("energy", itemstack.stackTagCompound.getInteger("energy") - 10);
			}
		}
		if (itemstack.stackTagCompound.getInteger("energy") < -1) {
			itemstack.stackTagCompound.setInteger("energy", 0);
		}

		if (itemstack.stackTagCompound.getInteger("energy") <= 0) {
			player.addPotionEffect(new BaublesPotionEffect(Potion.digSlowdown.id, 2));
			player.removePotionEffect(Potion.digSpeed.id);
		}

	}

	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player) {

	}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
		player.removePotionEffect(Potion.digSlowdown.id);
		player.removePotionEffect(Potion.digSpeed.id);
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
