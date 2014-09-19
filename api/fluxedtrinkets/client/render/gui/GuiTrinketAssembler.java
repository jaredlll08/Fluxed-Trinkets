package fluxedtrinkets.client.render.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import fluxedtrinkets.ModInfo;
import fluxedtrinkets.network.MessageTrinketAssembler;
import fluxedtrinkets.network.PacketHandler;
import fluxedtrinkets.tileEntity.TileEntityTrinketAssembler;
import fluxedtrinkets.util.StringUtils;

public class GuiTrinketAssembler extends GuiContainer {

	private TileEntityTrinketAssembler tile;

	public GuiTrinketAssembler(InventoryPlayer invPlayer, TileEntityTrinketAssembler tile2) {
		super(new ContainerTrinketAssembler(invPlayer, tile2));

		xSize = 175;
		ySize = 165;
		this.tile = tile2;

	}

	public void updateScreen() {
		super.updateScreen();
	}

	private static final ResourceLocation texture = new ResourceLocation(ModInfo.modid, "textures/gui/Trinket_Assembler.png");

	@Override
	protected void drawGuiContainerBackgroundLayer(float arg0, int arg1, int arg2) {
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);

		Minecraft.getMinecraft().renderEngine.bindTexture(texture);

		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

	public void initGui() {
		super.initGui();
		buttonList.add(new GuiButton(1, guiLeft + 78, guiTop + 60, 20, 20, StringUtils.translate("✓", false)));

	}

	protected void actionPerformed(GuiButton guibutton) {
		switch (guibutton.id) {
		case 1:
			tile.craftTrinket();
			PacketHandler.INSTANCE.sendToServer(new MessageTrinketAssembler(tile.xCoord, tile.yCoord, tile.zCoord));
			break;
		}
	}

}