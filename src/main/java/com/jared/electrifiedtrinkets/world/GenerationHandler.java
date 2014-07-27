package com.jared.electrifiedtrinkets.world;

import java.util.Random;

import com.jared.electrifiedtrinkets.blocks.ETBlocks;
import com.jared.electrifiedtrinkets.config.ConfigHandler;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class GenerationHandler implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
		case -1:
			generateNether(world, random, chunkX * 16, chunkZ * 16);
			break;
		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
			break;
		case 1:
			generateEnd(world, random, chunkX * 16, chunkZ * 16);
			break;
		}
	}

	private void generateEnd(World world, Random rand, int chunkX, int chunkZ) {
	}

	private void generateSurface(World world, Random rand, int chunkX, int chunkZ) {
		if(ConfigHandler.copperGeneration){
			for (int k = 0; k < 3; k++) {
				int oreXCoord = chunkX + rand.nextInt(16);
				int oreYCoord = rand.nextInt(64);
				int oreZCoord = chunkZ + rand.nextInt(16);
				(new WorldGenMinable(ETBlocks.copperOre, 4)).generate(world, rand, oreXCoord, oreYCoord, oreZCoord);
			}
		}
		if(ConfigHandler.leadGeneration){
			for (int k = 0; k < 3; k++) {
				int oreXCoord = chunkX + rand.nextInt(16);
				int oreYCoord = rand.nextInt(64);
				int oreZCoord = chunkZ + rand.nextInt(16);
				(new WorldGenMinable(ETBlocks.leadOre, 4)).generate(world, rand, oreXCoord, oreYCoord, oreZCoord);
			}
		}
	}

	private void generateNether(World world, Random rand, int chunkX, int chunkZ) {
	}
}