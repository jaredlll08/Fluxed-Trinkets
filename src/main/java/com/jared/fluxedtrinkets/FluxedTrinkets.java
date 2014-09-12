package com.jared.fluxedtrinkets;

import net.minecraftforge.common.MinecraftForge;

import com.jared.fluxedtrinkets.blocks.FTBlocks;
import com.jared.fluxedtrinkets.config.ConfigHandler;
import com.jared.fluxedtrinkets.items.FTItems;
import com.jared.fluxedtrinkets.network.PacketHandler;
import com.jared.fluxedtrinkets.proxy.CommonProxy;
import com.jared.fluxedtrinkets.util.GuiHandler;
import com.jared.fluxedtrinkets.util.RecipeHandler;
import com.jared.fluxedtrinkets.util.version.VersionChecker;
import com.jared.fluxedtrinkets.world.GenerationHandler;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = ModInfo.modid, name = ModInfo.name, version = ModInfo.version, dependencies = "required-after:Baubles;required-after:ThermalFoundation;required-after:CoFHCore")
public class FluxedTrinkets {

	@Instance("fluxedtrinkets")
	public static FluxedTrinkets instance;
	@SidedProxy(clientSide = "com.jared.fluxedtrinkets.proxy.ClientProxy", serverSide = "com.jared.fluxedtrinkets.proxy.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		FTItems.init();
		FTBlocks.init();
		RecipeHandler.init();

		proxy.registerRenderers();
	}

	@EventHandler
	public static void Init(FMLInitializationEvent event) {
		GameRegistry.registerWorldGenerator(new GenerationHandler(), 0);

		new GuiHandler();
		new GenerationHandler();
		PacketHandler.init();
		VersionChecker.init();
		MinecraftForge.EVENT_BUS.register(new com.jared.fluxedtrinkets.util.EventHandler());
	}

	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {

	}
	

}
