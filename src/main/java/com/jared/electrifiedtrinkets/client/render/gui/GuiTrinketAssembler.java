package com.jared.electrifiedtrinkets.client.render.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;

import org.lwjgl.opengl.GL11;

import com.jared.electrifiedtrinkets.ModInfo;
import com.jared.electrifiedtrinkets.items.ETItems;
import com.jared.electrifiedtrinkets.tileEntity.TileEntityTrinketAssembler;

public class GuiTrinketAssembler extends GuiContainer {

	private TileEntityTrinketAssembler tile;
	private boolean singleEffect = true;

	public GuiTrinketAssembler(InventoryPlayer invPlayer, TileEntityTrinketAssembler tile2) {
		super(new ContainerTrinketAssembler(invPlayer, tile2));

		xSize = 230;
		ySize = 219;
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

	public void renderToolTip(ItemStack stack, int x, int y) {
	}

	public void initGui() {
		super.initGui();
		
	}
	public void drawScreen(int par1, int par2, float par3) {

		super.drawScreen(par1, par2, par3);
		buttonList.clear();
		buttonList.add(new GuiButton(0, guiLeft + 105, guiTop + 108, 21, 20, "✔"));
		if (singleEffect) {
			buttonList.add(new GuiButtonInvisible(1, guiLeft + 155, guiTop + 10, 21, 20, "Single", false));
		}
		if (!singleEffect) {
			buttonList.add(new GuiButtonInvisible(2, guiLeft + 155, guiTop + 10, 21, 20, "Combination", false));
		}
	}


	protected void actionPerformed(GuiButton guibutton) {
		switch (guibutton.id) {
		case 0:
			tile.craftTrinket();
			break;
		case 1:
			buttonList.remove(new GuiButtonInvisible(2, guiLeft + 155, guiTop + 10, 21, 20, "Combination", false));
			singleEffect = false;
			break;
		case 2:
			buttonList.remove(new GuiButtonInvisible(1, guiLeft + 155, guiTop + 10, 21, 20, "Single", false));
			singleEffect = true;
			break;
		}
	}

}
