package com.jared.electrifiedtrinkets.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.BonemealEvent;

import com.jared.electrifiedtrinkets.network.MessageSolderingStation;
import com.jared.electrifiedtrinkets.network.PacketHandler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class ETTickHandler {
	private double posX = 0, posZ = 0;
	private Map<String, Integer> counters = new HashMap<String, Integer>();
	private int ticksSinceLastCheck = 0;

	

	private class Coord {
		public int x, y, z;

		public Coord(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	private void sendPacket(int x, int y, int z) {
		PacketHandler.INSTANCE.sendToAll(new MessageSolderingStation(x, y, z));
	}

	

}