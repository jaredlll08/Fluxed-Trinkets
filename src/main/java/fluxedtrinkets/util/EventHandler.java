package fluxedtrinkets.util;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderLivingEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import fluxedtrinkets.items.FTItems;

public class EventHandler {

	public boolean resetRender;

	public EventHandler() {
		FMLCommonHandler.instance().bus().register(this);
	}

}
