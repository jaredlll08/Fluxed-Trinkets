package fluxedtrinkets;

import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import fluxedtrinkets.api.FluxedTrinketsAPI;
import fluxedtrinkets.blocks.FTBlocks;
import fluxedtrinkets.config.ConfigHandler;
import fluxedtrinkets.effects.EffectAdvancedEmpty;
import fluxedtrinkets.effects.EffectAdvancedIce;
import fluxedtrinkets.effects.EffectAdvancedLava;
import fluxedtrinkets.effects.EffectAdvancedLightning;
import fluxedtrinkets.effects.EffectAir;
import fluxedtrinkets.effects.EffectEarth;
import fluxedtrinkets.effects.EffectEmpty;
import fluxedtrinkets.effects.EffectFall;
import fluxedtrinkets.effects.EffectFeed;
import fluxedtrinkets.effects.EffectFire;
import fluxedtrinkets.effects.EffectHaste;
import fluxedtrinkets.effects.EffectRespiratory;
import fluxedtrinkets.effects.EffectWater;
import fluxedtrinkets.items.FTItems;
import fluxedtrinkets.network.PacketHandler;
import fluxedtrinkets.proxy.CommonProxy;
import fluxedtrinkets.tileEntity.TileEntitySolderingStation;
import fluxedtrinkets.tileEntity.TileEntityTrinketAssembler;
import fluxedtrinkets.util.GuiHandler;
import fluxedtrinkets.util.KeyInputEventHandler;
import fluxedtrinkets.util.RecipeHandler;
import fluxedtrinkets.util.version.VersionChecker;

@Mod(modid = ModInfo.modid, name = ModInfo.name, version = ModInfo.version, dependencies = "required-after:Baubles;required-after:ThermalFoundation;required-after:CoFHCore")
public class FluxedTrinkets {

	@Instance("fluxedtrinkets")
	public static FluxedTrinkets instance;
	@SidedProxy(clientSide = "fluxedtrinkets.proxy.ClientProxy", serverSide = "fluxedtrinkets.proxy.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		FluxedTrinketsAPI.addEffect(new EffectAir());
		FluxedTrinketsAPI.addEffect(new EffectEarth());
		FluxedTrinketsAPI.addEffect(new EffectFire());
		FluxedTrinketsAPI.addEffect(new EffectWater());
		FluxedTrinketsAPI.addEffect(new EffectAdvancedIce());
		FluxedTrinketsAPI.addEffect(new EffectAdvancedLava());
		FluxedTrinketsAPI.addEffect(new EffectAdvancedLightning());
		FluxedTrinketsAPI.addEffect(new EffectHaste());
		FluxedTrinketsAPI.addEffect(new EffectRespiratory());
		FluxedTrinketsAPI.addEffect(new EffectFall());
		FluxedTrinketsAPI.addEffect(new EffectFeed());
		FluxedTrinketsAPI.addEffect(new EffectEmpty());
		FluxedTrinketsAPI.addEffect(new EffectAdvancedEmpty());

		ConfigHandler.init(event.getSuggestedConfigurationFile());
		FTItems.init();
		FTBlocks.init();
		RecipeHandler.init();
		proxy.registerRenderers();
//		proxy.registerKeyBinding();
		GameRegistry.registerTileEntity(TileEntitySolderingStation.class, "solderingStation");
		GameRegistry.registerTileEntity(TileEntityTrinketAssembler.class, "trinketAssembler");
	}

	@EventHandler
	public static void Init(FMLInitializationEvent event) {
		FMLCommonHandler.instance().bus().register(new KeyInputEventHandler());
		new GuiHandler();
		PacketHandler.init();
		VersionChecker.init();
		MinecraftForge.EVENT_BUS.register(new fluxedtrinkets.util.EventHandler());
	}

	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {

	}

}
