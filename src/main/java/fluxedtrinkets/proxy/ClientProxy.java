package fluxedtrinkets.proxy;

import net.minecraft.client.Minecraft;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import fluxedtrinkets.client.render.block.RenderSolderingStation;
import fluxedtrinkets.client.render.block.RenderTrinketAssembler;
import fluxedtrinkets.client.render.gui.GuiEManual;
import fluxedtrinkets.tileEntity.TileEntitySolderingStation;
import fluxedtrinkets.tileEntity.TileEntityTrinketAssembler;
import fluxedtrinkets.tileEntity.TileEntityWirelessCharger;

public class ClientProxy extends CommonProxy {
	public static int solderingStationID = RenderingRegistry.getNextAvailableRenderId();
	public static int trinketAssemblerID = RenderingRegistry.getNextAvailableRenderId();
	

	@Override
	public void registerRenderers() {


		RenderSolderingStation solderingStation = new RenderSolderingStation();
		RenderTrinketAssembler trinketAssembler = new RenderTrinketAssembler();
		ClientRegistry.registerTileEntity(TileEntitySolderingStation.class, "solderingStation", solderingStation);
		ClientRegistry.registerTileEntity(TileEntityTrinketAssembler.class, "trinketAssembler", trinketAssembler);
		}
	
	public static void openManual() {
		Minecraft.getMinecraft().displayGuiScreen(new GuiEManual());
	}
}
