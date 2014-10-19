package fluxedtrinkets.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.opengl.GL11;

import fluxedtrinkets.ModInfo;
import fluxedtrinkets.tileEntity.TileEntityHeatGenerator;

public class GuiHeatGenerator extends GuiContainer {

	private TileEntityHeatGenerator tile;

	public GuiHeatGenerator(InventoryPlayer invPlayer, TileEntityHeatGenerator tile2) {
		super(new ContainerHeatGenerator(invPlayer, tile2));

		xSize = 175;
		ySize = 175;
		this.tile = tile2;

	}

	public void updateScreen() {
		super.updateScreen();

	}

	private static final ResourceLocation texture = new ResourceLocation(ModInfo.modid, "textures/gui/Heat_Generator.png");

	public void initGui() {
		super.initGui();
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);

		Minecraft.getMinecraft().renderEngine.bindTexture(texture);

		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

//		fontRendererObj.drawString(String.valueOf(tile.getStorage().getEnergyStored() + "/" + tile.getStorage().getMaxEnergyStored()), guiLeft + (xSize / 2) - 30, guiTop + 60, 0);

		if (tile.getStackInSlot(0) != null) {
			fontRendererObj.drawString(String.valueOf((tile.getPercentage() / 20) + "/" + TileEntityFurnace.getItemBurnTime(tile.getStackInSlot(0)) / 20), guiLeft + (xSize / 2) - 25, guiTop + 50, 0);
		}

	}

}