package com.jared.electrifiedtrinkets.items.equipment;

import java.util.ArrayList;
import java.util.List;

import com.jared.electrifiedtrinkets.util.NBTHelper;
import com.jared.electrifiedtrinkets.util.StringUtils;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import baubles.api.BaubleType;
import baubles.api.IBauble;

public class ItemBeltEmpty extends Item implements IBauble {

	public ArrayList<String> totalEffects = new ArrayList<String>();
	public ArrayList<String> effects = new ArrayList<String>();

	public ItemBeltEmpty() {
		super();
		this.setMaxStackSize(1);
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.BELT;
	}

	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		int fireAmmount, waterAmmount, airAmmount, earthAmmount, advancedEmptyAmmount, emptyAmmount = 0;

		for (int i = 0; i < 3; i++) {
			totalEffects.add(NBTHelper.getString(stack, "ETEffect." + i));
			effects.add(NBTHelper.getString(stack, "ETEffect." + i));
		}
		if (StringUtils.isShiftKeyDown()) {

			if (NBTHelper.getString(stack, "ETEffect") != "" && NBTHelper.getString(stack, "ETEffect") != null) {
				String effects = NBTHelper.getString(stack, "ETEffect");
				

				if (effects.contains("fire")) {
					totalEffects.add("fire");
					list.add(StringUtils.GRAY + "-" + "Fire");
				}
				if (effects.contains("air") && !effects.contains("earth") && !effects.contains("empty")) {
					totalEffects.add("air");
					list.add(StringUtils.GRAY + "-" + "Air");
				}
				if (effects.contains("earth") && !effects.contains("air") && !effects.contains("empty")) {
					totalEffects.add("earth");
					list.add(StringUtils.GRAY + "-" + "Earth");
				}
				if (effects.contains("water")) {
					totalEffects.add("water");
					list.add(StringUtils.GRAY + "-" + "Water");
				}
				if (effects.contains("air") && effects.contains("earth") && totalEffects.contains("jump")) {
					totalEffects.add("haste");
					list.add(StringUtils.BRIGHT_BLUE + "-Haste");
				}
				if (effects.contains("air") && effects.contains("earth") && effects.contains("empty") && !totalEffects.contains("haste")) {
					totalEffects.add("jump");
					list.add(StringUtils.BRIGHT_GREEN + "-Jump");
				}
				if (effects.contains("air") && effects.contains("earth") && effects.contains("advancedEmpty") && !totalEffects.contains("haste")) {
					totalEffects.add("jump");
					list.add(StringUtils.BRIGHT_GREEN + "-Jump");
				}

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

	private int countEffects(ItemStack itemstack,  String keyValue) {
		int index = NBTHelper.getString(itemstack, "ETEffect").indexOf(keyValue);
		int count = 0;
		while(index !=-1){
			count++;
			keyValue = keyValue.substring(index+1);
			index = keyValue.indexOf(keyValue);
		}
		return count;
	}

}
