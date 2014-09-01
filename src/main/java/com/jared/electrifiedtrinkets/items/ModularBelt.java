package com.jared.electrifiedtrinkets.items;

import java.util.List;

import com.jared.electrifiedtrinkets.util.NBTHelper;
import com.jared.electrifiedtrinkets.util.StringUtils;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import baubles.api.BaubleType;
import baubles.api.IBauble;
import cofh.api.energy.IEnergyContainerItem;

public class ModularBelt extends Item implements IBauble, IEnergyContainerItem {

	private int maxCapacity;
	private int baseUsage;
	private int usageModifier = 0;

	public ModularBelt(int maxCapacity, int usage) {
		this.setMaxStackSize(1);
		this.maxCapacity = maxCapacity;
		this.baseUsage = usage;
	}

	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {

		if (StringUtils.isShiftKeyDown()) {
			list.add(StringUtils.getChargeText(NBTHelper.getInt(stack, "energy"), maxCapacity));
			list.add(StringUtils.getEnergyUsageText(baseUsage*usageModifier));
			if (NBTHelper.getString(stack, "ETEffect") == "air") {
				usageModifier+=20;
				list.add(StringUtils.GRAY + "-Atmospheric");
			}
			if (NBTHelper.getString(stack, "ETEffect") == "ground") {

			}
			if (NBTHelper.getString(stack, "ETEffect") == "") {

			}
			if (NBTHelper.getString(stack, "ETEffect") == "") {

			}
			if (NBTHelper.getString(stack, "ETEffect") == "") {

			}
		} else {
			list.add(StringUtils.getShiftText());
		}

	}

	@Override
	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {
		if (par1ItemStack.stackTagCompound == null)
			NBTHelper.setBoolean(par1ItemStack, "hasNBT", true);
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.BELT;
	}

	@Override
	public int receiveEnergy(ItemStack container, int maxReceive, boolean simulate) {
		if (container.stackTagCompound == null) {
			container.stackTagCompound = new NBTTagCompound();
		}
		int energy = container.stackTagCompound.getInteger("energy");
		int energyReceived = Math.min(maxCapacity - energy, Math.min(100, maxReceive));
		if (!simulate) {
			energy += energyReceived;
			container.stackTagCompound.setInteger("energy", energy);
		}
		return energyReceived;
	}

	private int getDamageFromEnergy(NBTTagCompound tag, int max) {
		return ((int) (Math.abs(((float) tag.getInteger("energy") / maxCapacity) - 1) * max) + 1);
	}

	@Override
	public int extractEnergy(ItemStack container, int maxExtract, boolean simulate) {
		if (container == null || container.getTagCompound() == null)
			return 0;

		int available = container.stackTagCompound.getInteger("energy");
		int removed;
		if (maxExtract < available) {
			if (!simulate)
				container.stackTagCompound.setInteger("energy", available - maxExtract);
			removed = maxExtract;
		} else {
			if (!simulate)
				container.stackTagCompound.setInteger("energy", 0);
			removed = available;
		}
		if (!simulate)
			container.setItemDamage(getDamageFromEnergy(container.stackTagCompound, container.getMaxDamage()));

		return removed;
	}

	@Override
	public int getEnergyStored(ItemStack container) {
		if (container == null || container.stackTagCompound == null || !container.stackTagCompound.hasKey("energy"))
			return 0;
		return container.stackTagCompound.getInteger("energy");
	}

	@Override
	public int getMaxEnergyStored(ItemStack container) {
		return maxCapacity;
	}

	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
		if(NBTHelper.getString(itemstack, "ETEffect")=="air"){
			if(!player.onGround && !player.isInWater() && !player.isRiding() && player.moveForward>0 && !player.isInsideOfMaterial(Material.lava) && !player.isInsideOfMaterial(Material.water)){
				player.moveFlying(0F, 1F,0.05F);
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
		if(NBTHelper.getBoolean(itemstack, "equipable")){
			return true;
		}
		return false;
	}

	@Override
	public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
		if(NBTHelper.getBoolean(itemstack, "unEquipable")){
			return true;
		}
		return false;
	}

}
