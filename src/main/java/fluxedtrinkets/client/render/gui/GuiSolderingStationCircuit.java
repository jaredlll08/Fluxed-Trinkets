package fluxedtrinkets.client.render.gui;

import io.netty.util.internal.StringUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import fluxedtrinkets.ModInfo;
import fluxedtrinkets.api.StringUtils;
import fluxedtrinkets.network.MessageCircuitCrafting;
import fluxedtrinkets.network.PacketHandler;
import fluxedtrinkets.tileEntity.TileEntitySolderingStation;

public class GuiSolderingStationCircuit extends GuiContainer {

	private TileEntitySolderingStation tile;

	public GuiSolderingStationCircuit(InventoryPlayer invPlayer, TileEntitySolderingStation solderingStation) {
		super(new ContainerSolderingStation(invPlayer, solderingStation));

		xSize = 175;
		ySize = 165;
		this.tile = solderingStation;

	}

	public void updateScreen() {
		super.updateScreen();
	}


	private static final ResourceLocation texture = new ResourceLocation(ModInfo.modid, "textures/gui/Soldering_Station_Circuit.png");

	@Override
	protected void drawGuiContainerBackgroundLayer(float arg0, int arg1, int arg2) {
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);

		Minecraft.getMinecraft().renderEngine.bindTexture(texture);

		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}
	
	

	public void initGui() {
		super.initGui();
		buttonList.add(new GuiButton(1, guiLeft+113, guiTop+60, 20, 20, StringUtils.translate("tick", false)));
		
	}

	protected void actionPerformed(GuiButton guibutton) {
		switch (guibutton.id) {
		case 1:
			PacketHandler.INSTANCE.sendToServer(new MessageCircuitCrafting(tile.xCoord, tile.yCoord, tile.zCoord));
			break;
		case 2:
		}
	}

}
