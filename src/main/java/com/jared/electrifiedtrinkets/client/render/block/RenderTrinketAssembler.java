package com.jared.electrifiedtrinkets.client.render.block;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.jared.electrifiedtrinkets.ModInfo;
import com.jared.electrifiedtrinkets.tileEntity.TileEntityTrinketAssembler;

public class RenderTrinketAssembler extends TileEntitySpecialRenderer {

	private ModelTrinketAssembler model = new ModelTrinketAssembler();
	private Random random = new Random();
	private RenderBlocks renderBlock = new RenderBlocks();
	private Minecraft mc = Minecraft.getMinecraft();
	private final float size = 0.0625f;
	private float angle = 1;


	@Override
	public void renderTileEntityAt(TileEntity var1, double var2, double var4, double var6, float var8) {
		if (var1 instanceof TileEntityTrinketAssembler)
			render((TileEntityTrinketAssembler) var1, var2, var4, var6);
	}

	public void render(TileEntityTrinketAssembler tile, double x, double y, double z) {
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_LIGHTING);

		GL11.glTranslatef((float) x + 0.5f, (float) y + 1.50f, (float) z + 0.5f);
		GL11.glRotatef(180f, 1f, 0f, 0f);
		GL11.glScaled(1, 1, 1);


		mc.renderEngine.bindTexture(new ResourceLocation(ModInfo.modid + ":textures/models/Trinket_Assembler.png"));
		model.render(size);
		 GL11.glColor3f(1f, 1f, 1f);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glPopMatrix();

		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glTranslatef((float) x+0.5f, (float) y + 1.50f, (float) z + 0.5f);

		if (angle < 360)
			angle += 0.4f;
		if (angle >= 360)
			angle = 0;

		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glPopMatrix();

	}

}