package com.jared.electrifiedtrinkets;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.jared.electrifiedtrinkets.items.ETItems;

public class CreativeTabElectrifiedTrinkets extends CreativeTabs{

	public CreativeTabElectrifiedTrinkets() {
		super("Electrified Trinkets");
	}

	@Override
	public Item getTabIconItem() {
		return ETItems.solderingIron;
	}

}
