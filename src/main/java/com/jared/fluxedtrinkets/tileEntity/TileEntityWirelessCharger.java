package com.jared.fluxedtrinkets.tileEntity;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.util.ForgeDirection;
import baubles.api.BaublesApi;
import cofh.api.energy.IEnergyContainerItem;
import cofh.api.energy.IEnergyHandler;

import com.jared.fluxedtrinkets.util.NBTHelper;

public class TileEntityWirelessCharger extends TileEntity implements IEnergyHandler {
	public int timer;

	public TileEntityWirelessCharger() {
		timer = 0;
	}

	public void updateEntity() {
		super.updateEntity();
		ItemStack block = new ItemStack(worldObj.getBlock(xCoord, yCoord, zCoord));
		if (timer == 0 && !worldObj.isRemote) {
			timer = 1;
			if(NBTHelper.getInt(block, "energy")>0){
				worldObj.spawnParticle("flame", xCoord, yCoord, zCoord, 1, 1, 1);
			}
			List<EntityPlayer> players = worldObj.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.getBoundingBox(xCoord - 5, yCoord - 5, zCoord - 5, xCoord + 5, yCoord + 5, zCoord + 5));
			for (EntityPlayer player : players) {
				for (int i = 0; i < 4; i++) {
					if (BaublesApi.getBaubles(player).getStackInSlot(i) != null) {
						ItemStack bauble = BaublesApi.getBaubles(player).getStackInSlot(i);
						if (bauble.getItem() instanceof IEnergyContainerItem) {
							IEnergyContainerItem energyContainer = (IEnergyContainerItem) bauble.getItem();
							if (energyContainer.getEnergyStored(bauble) < energyContainer.getMaxEnergyStored(bauble)) {
								NBTHelper.setInteger(bauble, "energy", energyContainer.getEnergyStored(bauble) + energyContainer.receiveEnergy(bauble, energyContainer.getMaxEnergyStored(bauble), false));
								if (NBTHelper.getInt(bauble, "energy") > energyContainer.getMaxEnergyStored(bauble)) {
									NBTHelper.setInteger(bauble, "energy", energyContainer.getMaxEnergyStored(bauble));
								}
							}
						}
					}
				}

				for (int i = 0; i < player.inventory.getSizeInventory(); i++) {
					if (player.inventory.getStackInSlot(i) != null && player.inventory.getStackInSlot(i).getItem() instanceof IEnergyContainerItem) {
						IEnergyContainerItem energyItem = (IEnergyContainerItem) player.inventory.getStackInSlot(i).getItem();
						energyItem.receiveEnergy(player.inventory.getStackInSlot(i), energyItem.getMaxEnergyStored(player.inventory.getStackInSlot(i)), false);
					}
				}
			}
		}
		timer--;
	}

	@Override
	public boolean canConnectEnergy(ForgeDirection from) {
		return true;
	}

	@Override
	public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate) {
		ItemStack block = new ItemStack(worldObj.getBlock(xCoord, yCoord, zCoord));
		if (!simulate) {
			
			NBTHelper.setInteger(block, "energy", NBTHelper.getInt(block, "energy") + maxReceive);
			
		}
		return NBTHelper.getInt(block, "energy");
	}

	@Override
	public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate) {
		return 0;
	}

	@Override
	public int getEnergyStored(ForgeDirection from) {
		ItemStack block = new ItemStack(worldObj.getBlock(xCoord, yCoord, zCoord));
		return NBTHelper.getInt(block, "energy");
	}

	@Override
	public int getMaxEnergyStored(ForgeDirection from) {
		return 50000;
	}
}
