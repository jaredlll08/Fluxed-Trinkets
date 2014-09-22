package fluxedtrinkets.tileEntity;

import java.util.List;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemLead;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.util.ForgeDirection;
import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyHandler;

public class TileEntityLavaGenerator extends TileEntity implements IEnergyHandler {
	protected EnergyStorage storage;
	public EntityPlayer player;
	

	public TileEntityLavaGenerator() {
		init(500000);
		setInputSpeed(10000);
	}

	public void updateEntity() {
	}
	
	public void generateLava(){
		if (getEnergyStored() >= 120000) {
			if (worldObj.isAirBlock(xCoord, yCoord + 1, zCoord)) {
				worldObj.setBlock(xCoord, yCoord + 1, zCoord, Blocks.lava);
				setEnergyStored(getEnergyStored() - 120000);
			}
		}
	}

	@Override
	public boolean canConnectEnergy(ForgeDirection from) {
		return true;
	}

	@Override
	public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate) {
		int ret = storage.receiveEnergy(maxReceive, true);
		if (!simulate) {
			storage.receiveEnergy(ret, false);
		}
		return ret;
	}

	private void init(int cap) {
		storage = new EnergyStorage(cap);
	}

	@Override
	public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate) {
		return 0;
	}

	@Override
	public int getEnergyStored(ForgeDirection from) {
		return getEnergyStored();
	}

	@Override
	public int getMaxEnergyStored(ForgeDirection from) {
		return getMaxStorage();
	}

	public int getEnergyStored() {
		return storage.getEnergyStored();
	}

	public void setEnergyStored(int energy) {
		storage.setEnergyStored(energy);
	}

	public int getMaxStorage() {
		return storage.getMaxEnergyStored();
	}

	public void setMaxStorage(int storage) {
		this.storage.setCapacity(storage);
	}

	public int getInputSpeed() {
		return storage.getMaxReceive();
	}

	public void setInputSpeed(int inputSpeed) {
		this.storage.setMaxReceive(inputSpeed);
	}

}
