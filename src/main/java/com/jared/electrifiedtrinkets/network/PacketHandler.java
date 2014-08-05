package com.jared.electrifiedtrinkets.network;


import com.jared.electrifiedtrinkets.ModInfo;

import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class PacketHandler
{
    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(ModInfo.channel);

    public static void init()
    {
       INSTANCE.registerMessage(MessageSolderingStation.class, MessageSolderingStation.class, 0, Side.SERVER);
       INSTANCE.registerMessage(MessageSpeedCircuitCrafting.class, MessageSpeedCircuitCrafting.class, 1, Side.SERVER);
       
    }
}