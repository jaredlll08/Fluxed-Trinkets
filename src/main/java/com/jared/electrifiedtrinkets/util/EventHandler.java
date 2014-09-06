package com.jared.electrifiedtrinkets.util;

import net.minecraft.event.ClickEvent;
import net.minecraft.event.ClickEvent.Action;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventHandler {

	public EventHandler() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void onMessageReceived(ClientChatReceivedEvent event) {
		String originalMessage = event.message.getUnformattedText();
		String message = StringUtils.LIGHT_BLUE + originalMessage;

		if (message.isEmpty())
			event.setCanceled(true);
		
		
		if(originalMessage.startsWith("<ForgeDevName>")){
			String name = "<"+EnumChatFormatting.BLUE + "Kucan" + EnumChatFormatting.RESET + ">";
			event.message = new ChatComponentText(name + EnumChatFormatting.AQUA + message.substring(16));
	}
	}

}
