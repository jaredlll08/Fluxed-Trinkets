package fluxedtrinkets.blocks;

import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;
import fluxedtrinkets.ModInfo;
import fluxedtrinkets.items.FTItems;

public class FTBlocks {

	public static void init() {
		registerBlocks();
	}

	public static Block solderingStation = new BlockSolderingStation();
	public static Block trinketAssembler = new BlockTrinketAssembler();
	public static Block kineticGenerator = new BlockKineticGenerator();
	public static Block machineCube = new BlockMachineCube();
	public static Block heatGenerator = new BlockHeatGenerator();

	// public static Block compressor = new BlockCompressor();

	private static void registerBlocks() {
		registerBlock(solderingStation, "Soldering Station", "Soldering_Station");
		registerBlock(trinketAssembler, "Trinket Assembler", "Trinket_Assembler");
		// registerBlock(compressor, "Compressor", "Machine_Compressor");
		registerBlock(kineticGenerator, "Kinetic Generator", "Kinetic_Generator");
		registerBlock(machineCube, "Machine Cube", "Machine_Cube");
		registerBlock(heatGenerator, "Heat Generator", "Heat_Generator");
	}

	private static void registerBlock(Block block, String name, String key) {
		block.setBlockName(name).setBlockTextureName(ModInfo.modid + ":" + key).setCreativeTab(FTItems.tab);
		GameRegistry.registerBlock(block, key);
	}

}
