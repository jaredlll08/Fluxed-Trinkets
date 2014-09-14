package fluxedtrinkets;

import sun.security.krb5.internal.ETypeInfo;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import fluxedtrinkets.api.SolderingRecipe;
import fluxedtrinkets.blocks.FTBlocks;
import fluxedtrinkets.config.ConfigHandler;
import fluxedtrinkets.items.FTItems;
import fluxedtrinkets.network.PacketHandler;
import fluxedtrinkets.proxy.CommonProxy;
import fluxedtrinkets.util.GuiHandler;
import fluxedtrinkets.util.RecipeHandler;
import fluxedtrinkets.util.version.VersionChecker;
import fluxedtrinkets.world.GenerationHandler;

@Mod(modid = ModInfo.modid, name = ModInfo.name, version = ModInfo.version, dependencies = "required-after:Baubles;required-after:ThermalFoundation;required-after:CoFHCore")
public class FluxedTrinkets {

	@Instance("fluxedtrinkets")
	public static FluxedTrinkets instance;
	@SidedProxy(clientSide = "fluxedtrinkets.proxy.ClientProxy", serverSide = "fluxedtrinkets.proxy.CommonProxy")
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

		new GuiHandler();
		PacketHandler.init();
		VersionChecker.init();
		MinecraftForge.EVENT_BUS.register(new fluxedtrinkets.util.EventHandler());
	}

	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {

	}

}
