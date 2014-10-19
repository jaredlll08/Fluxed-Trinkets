package fluxedtrinkets;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;

public class NEIConfig implements IConfigureNEI {

	@Override
	public String getName() {
		return "Fluxed-Trinkets-NEI";
	}

	@Override
	public String getVersion() {
		return "0.1";
	}

	@Override
	public void loadConfig() {
		API.registerUsageHandler(new RecipeHandlerSoldering());
		API.registerRecipeHandler(new RecipeHandlerSoldering());
	}

}
