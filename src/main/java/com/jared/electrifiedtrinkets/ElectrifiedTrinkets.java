package com.jared.electrifiedtrinkets;

import net.minecraftforge.common.MinecraftForge;

import com.jared.electrifiedtrinkets.blocks.ETBlocks;
import com.jared.electrifiedtrinkets.client.render.gui.Pages;
import com.jared.electrifiedtrinkets.config.ConfigHandler;
import com.jared.electrifiedtrinkets.items.ETItems;
import com.jared.electrifiedtrinkets.network.PacketHandler;
import com.jared.electrifiedtrinkets.proxy.CommonProxy;
import com.jared.electrifiedtrinkets.util.GuiHandler;
import com.jared.electrifiedtrinkets.util.RecipeHandler;
import com.jared.electrifiedtrinkets.world.GenerationHandler;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = ModInfo.modid, name = ModInfo.name, version = ModInfo.version)
public class ElectrifiedTrinkets {

	@Instance("electrifiedtrinkets")
	public static ElectrifiedTrinkets instance;
	@SidedProxy(clientSide = "com.jared.electrifiedtrinkets.proxy.ClientProxy", serverSide = "com.jared.electrifiedtrinkets.proxy.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		ETItems.init();
		ETBlocks.init();
		RecipeHandler.init();
		

		proxy.registerRenderers();

	}

	@EventHandler
	public static void Init(FMLInitializationEvent event) {
		GameRegistry.registerWorldGenerator(new GenerationHandler(), 0);
		
		new GuiHandler();
		new GenerationHandler();
		PacketHandler.init();
		MinecraftForge.EVENT_BUS.register(new com.jared.electrifiedtrinkets.util.EventHandler());
	}

	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {

	}

}
