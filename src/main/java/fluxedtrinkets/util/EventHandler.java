package fluxedtrinkets.util;

import java.util.UUID;

import net.minecraftforge.client.event.RenderPlayerEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import fluxedtrinkets.client.render.model.ModelAmulet;
import fluxedtrinkets.client.render.model.RenderAmulet;

public class EventHandler {

	public boolean resetRender;

	public EventHandler() {
		FMLCommonHandler.instance().bus().register(this);
	}

}
