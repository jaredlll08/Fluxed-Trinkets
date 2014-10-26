package fluxedtrinkets.nei;

import scala.reflect.api.Quasiquotes.Quasiquote.api;
import net.minecraft.item.ItemStack;
import codechicken.nei.SearchField.ISearchProvider;
import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import codechicken.nei.api.ItemFilter;
import fluxedtrinkets.CreativeTabFluxedTrinkets;
import fluxedtrinkets.ModInfo;
import fluxedtrinkets.items.FTItems;
import fluxedtrinkets.items.ModularTrinketItem;

public class NEIFluxedTrinketsConfig implements IConfigureNEI {

	@Override
	public void loadConfig() {
		// API.registerRecipeHandler();
		// if (Config.cheatMode) {
		// }
		// API.addSearchProvider(new ThaumItemFilter());TODO
		API.registerRecipeHandler(new SolderingHandler());
		API.registerUsageHandler(new SolderingHandler());

	}

	@Override
	public String getName() {
		return "Fluxed-Trinkets-NEI";
	}

	@Override
	public String getVersion() {
		return "0.1";
	}
}