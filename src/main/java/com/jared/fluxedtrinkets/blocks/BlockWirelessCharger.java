package com.jared.fluxedtrinkets.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.jared.fluxedtrinkets.tileEntity.TileEntityWirelessCharger;

public class BlockWirelessCharger extends BlockContainer{

	public BlockWirelessCharger(){
		super(Material.iron);
	}


	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityWirelessCharger();
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float par7, float par8, float par9){
		TileEntityWirelessCharger tile = (TileEntityWirelessCharger)world.getTileEntity(x, y, z);
		player.addChatComponentMessage(new ChatComponentText(String.valueOf(tile.getEnergyStored(ForgeDirection.NORTH))));
		return true;
	}
}
