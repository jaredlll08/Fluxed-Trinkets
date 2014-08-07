package com.jared.electrifiedtrinkets.items.equipment;

import java.util.Random;

import com.jared.electrifiedtrinkets.potion.BaublesPotionEffect;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import cpw.mods.fml.relauncher.ReflectionHelper;

public class ItemBeltFire extends ModBelt {
	public static final String[] IS_IMMUNE_TO_FIRE = new String[] { "isImmuneToFire", "field_70178_ae", "ag" };

	public ItemBeltFire(int maxCapacity, int usage) {
		super(maxCapacity, usage);
	}

	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
		if (itemstack.stackTagCompound == null) {
			itemstack.stackTagCompound = new NBTTagCompound();
		}

		if (itemstack.stackTagCompound.getInteger("energy") > 0) {
			if (player.isBurning()) {
				player.extinguish();
				setFireImmune(player, true);
				itemstack.stackTagCompound.setInteger("energy", itemstack.stackTagCompound.getInteger("energy") - 250);
			}
			
			if(new Random().nextInt(400)==0){
				setFireImmune(player, false);
			}
			

		}

		if (itemstack.stackTagCompound.getInteger("energy") < -1) {
			itemstack.stackTagCompound.setInteger("energy", 0);
		}

		if (itemstack.stackTagCompound.getInteger("energy") <= 0) {
			if (player instanceof EntityPlayer) {
				EntityPlayer play = (EntityPlayer) player;
				play.setFire(60);
			}
		}

	}

	public void setFireImmune(Entity entity, boolean isImmune) {
		ReflectionHelper.setPrivateValue(Entity.class, entity, isImmune, IS_IMMUNE_TO_FIRE);
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
		if (itemstack.stackTagCompound.getInteger("energy") == 0 && player.isBurning()) {

			return false;
		}
		return true;
	}

}
