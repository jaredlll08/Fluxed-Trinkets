package com.jared.electrifiedtrinkets.items;

import java.util.List;

import com.jared.electrifiedtrinkets.util.StringUtils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

public class ItemBattery extends Item {

	public ItemBattery() {
		this.setMaxStackSize(1);
	}

	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, Boolean par4) {
		list.add(StringUtils.ORANGE + "adds 5000 RF to an item.");
	}

}
