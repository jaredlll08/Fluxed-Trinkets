package fluxedtrinkets.client.render.model;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import fluxedtrinkets.ModInfo;

public class RenderAmulet {

	private ModelAmulet modelAmulet = new ModelAmulet();

	public RenderAmulet() {
		super();
	}

	public void doRender(EntityLivingBase entity, float partialTicks) {
		GL11.glPushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(ModInfo.modid + ":textures/models/Trinket_Assembler.png"));
		this.modelAmulet.render(entity, 0, 0, 500, 500, 0, partialTicks);
		GL11.glPopMatrix();
	}


}