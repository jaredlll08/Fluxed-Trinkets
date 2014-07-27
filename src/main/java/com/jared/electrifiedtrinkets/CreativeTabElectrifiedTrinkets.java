package com.jared.electrifiedtrinkets;

import com.jared.electrifiedtrinkets.items.ETItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabElectrifiedTrinkets extends CreativeTabs{

	public CreativeTabElectrifiedTrinkets() {
		super("Electrified Trinkets");
	}

	@Override
	public Item getTabIconItem() {
		return ETItems.solderingIron;
	}

}
