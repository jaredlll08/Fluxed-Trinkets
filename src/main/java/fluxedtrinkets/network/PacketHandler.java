package fluxedtrinkets.network;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import fluxedtrinkets.ModInfo;

public class PacketHandler {
	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(ModInfo.channel);

	public static void init() {
		INSTANCE.registerMessage(MessageCircuitCrafting.class, MessageCircuitCrafting.class, 0, Side.SERVER);
		INSTANCE.registerMessage(MessageTrinketAssembler.class, MessageTrinketAssembler.class, 1, Side.SERVER);
		
	}
}