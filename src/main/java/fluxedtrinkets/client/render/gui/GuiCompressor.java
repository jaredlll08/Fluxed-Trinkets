package fluxedtrinkets.client.render.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import fluxedtrinkets.ModInfo;
import fluxedtrinkets.api.StringUtils;
import fluxedtrinkets.network.MessageTrinketAssembler;
import fluxedtrinkets.network.PacketHandler;
import fluxedtrinkets.tileEntity.TileEntityCompressor;
import fluxedtrinkets.tileEntity.TileEntityTrinketAssembler;

public class GuiCompressor extends GuiContainer {

	private TileEntityCompressor tile;

	public GuiCompressor(InventoryPlayer invPlayer, TileEntityCompressor tile2) {
		super(new ContainerCompressor(invPlayer, tile2));

		xSize = 175;
		ySize = 175;
		this.tile = tile2;
		
	}

	public void updateScreen() {
		super.updateScreen();
	}

	private static final ResourceLocation texture = new ResourceLocation(ModInfo.modid, "textures/gui/Compressor.png");


	@Override
	protected void drawGuiContainerBackgroundLayer(float arg0, int arg1, int arg2) {
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);

		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
	}

	public void initGui() {
		super.initGui();
	}

}