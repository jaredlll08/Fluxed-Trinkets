package fluxedtrinkets.nei;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;

public class NEIFluxedTrinketsConfig implements IConfigureNEI {

	@Override
	public void loadConfig(){
		//API.registerRecipeHandler();
		//if (Config.cheatMode) {
		//}
			//API.addSearchProvider(new ThaumItemFilter());TODO
		API.registerRecipeHandler(new SolderingHandler());
		API.registerUsageHandler(new SolderingHandler());


		//OverlayHandler overlayHandler = new OverlayHandler(14, 4, ArcaneWorkbenchHelper.slotCraftMatrix);FIXME
		//API.registerGuiOverlayHandler(ArcaneWorkbenchHelper.guiArcaneTable, overlayHandler, "crafting");FIXME
		//API.registerGuiOverlayHandler(ArcaneWorkbenchHelper.guiArcaneTable, overlayHandler, "arcane");FIXME
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