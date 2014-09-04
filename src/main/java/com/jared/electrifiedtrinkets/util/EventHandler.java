package com.jared.electrifiedtrinkets.util;

import net.minecraftforge.common.MinecraftForge;

public class EventHandler {

	public EventHandler() {
		MinecraftForge.EVENT_BUS.register(this);
	}


}
