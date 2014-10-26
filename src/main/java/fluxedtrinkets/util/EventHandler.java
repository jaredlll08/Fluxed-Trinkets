package fluxedtrinkets.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import fluxedtrinkets.client.render.model.RenderAmulet;

public class EventHandler {
	public boolean resetRender;

	public EventHandler() {
		FMLCommonHandler.instance().bus().register(this);
	}

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void render(RenderLivingEvent.Pre event) {
		String s = EnumChatFormatting.getTextWithoutFormattingCodes(event.entity.getCommandSenderName());
		if (s.equals("jaredlll08") && event.entity instanceof EntityPlayer) {
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.50F);
			GL11.glEnable(3042);
			GL11.glBlendFunc(770, 771);
			resetRender = true;
		}
	}

	@SubscribeEvent
	public void entityColorRender(RenderLivingEvent.Post event) {
		if (this.resetRender) {
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glDisable(3042);
		}
	}

}
