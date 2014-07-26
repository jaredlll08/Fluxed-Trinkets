package com.jared.electrifiedtrinkets.util;

import net.minecraft.item.Item;
import net.minecraft.server.management.ItemInWorldManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventHandler {

	public EventHandler() {
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	
}
