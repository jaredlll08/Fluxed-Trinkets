package com.jared.electrifiedtrinkets.items.equipment;

import java.util.List;

import com.jared.electrifiedtrinkets.util.NBTHelper;
import com.jared.electrifiedtrinkets.util.StringUtils;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import baubles.api.BaubleType;
import baubles.api.IBauble;

public class ItemBeltEmpty extends Item implements IBauble {

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.BELT;
	}

	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {

		if (StringUtils.isShiftKeyDown()) {
			for (int i = 0; i < 4; i++) {
				if(NBTHelper.getString(stack, "ETEffect"+i)!=""){
					list.add(NBTHelper.getString(stack, "ETEffect" + i));
				}
			}
			if (NBTHelper.getString(stack, "ETEffect") == "air") {
				list.add(StringUtils.GRAY + "-Air");
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
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {

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
