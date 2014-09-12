package com.jared.fluxedtrinkets;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.jared.fluxedtrinkets.items.FTItems;

public class CreativeTabFluxedTrinkets extends CreativeTabs {

	public CreativeTabFluxedTrinkets() {
		super("Fluxed Trinkets");
		
	}



	@Override
	public Item getTabIconItem() {
		return FTItems.solderingIron;
	}

}
