package fluxedtrinkets;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import fluxedtrinkets.items.FTItems;

public class CreativeTabFluxedTrinkets extends CreativeTabs {

	public CreativeTabFluxedTrinkets() {
		super("Fluxed Trinkets");
		
	}



	@Override
	public Item getTabIconItem() {
		return FTItems.solderingIron;
	}

}
