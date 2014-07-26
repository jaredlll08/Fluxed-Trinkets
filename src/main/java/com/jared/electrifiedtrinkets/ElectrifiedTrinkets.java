package com.jared.electrifiedtrinkets;

import net.minecraftforge.common.MinecraftForge;

import com.jared.electrifiedtrinkets.blocks.ETBlocks;
import com.jared.electrifiedtrinkets.items.ETItems;
import com.jared.electrifiedtrinkets.proxy.CommonProxy;
import com.jared.electrifiedtrinkets.util.GuiHandler;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ModInfo.modid, name = ModInfo.name, version = ModInfo.version)
public class ElectrifiedTrinkets {

	@Instance("electrifiedtrinkets")
	public static ElectrifiedTrinkets instance;
	@SidedProxy(clientSide = "com.jared.electrifiedtrinkets.proxy.ClientProxy", serverSide = "com.jared.electrifiedtrinkets.proxy.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		ETItems.init();
		ETBlocks.init();
		proxy.registerRenderers();
		MinecraftForge.EVENT_BUS.register(new com.jared.electrifiedtrinkets.util.EventHandler());
	}

	@EventHandler
	public static void Init(FMLInitializationEvent event) {
		new GuiHandler();

	}

	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {

	}

}
