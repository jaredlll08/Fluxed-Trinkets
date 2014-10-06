package fluxedtrinkets.tileEntity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.util.ForgeDirection;
import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyHandler;

public class TileEntityKineticGenerator extends TileEntity implements IEnergyHandler {

	public EnergyStorage storage;
	protected int capacity = 500000;

	public TileEntityKineticGenerator() {
		init(capacity);
	}

	public void updateEntity() {
		worldObj.getPlayerEntityByName("ForgeDevName").addChatComponentMessage(new ChatComponentText(String.valueOf(getEnergyStored())));
	}

	private void init(int cap) {
		storage = new EnergyStorage(cap);
	}

	@Override
	public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate) {
		int ret = storage.extractEnergy(maxExtract, true);
		if (!simulate) {
			storage.extractEnergy(ret, false);
		}
		return ret;
	}

	@Override
	public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate) {
		int ret = storage.receiveEnergy(maxReceive, true);
		if (!simulate) {
			storage.receiveEnergy(ret, false);
		}
		return ret;
	}

	@Override
	public final boolean canConnectEnergy(ForgeDirection from) {
		if (!(from == from.UP)) {
			return false;
		}
		return true;
	}

	@Override
	public final int getEnergyStored(ForgeDirection from) {
		return getEnergyStored();
	}

	@Override
	public final int getMaxEnergyStored(ForgeDirection from) {
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

	public int getOutputSpeed() {
		return storage.getMaxExtract();
	}

	public int getMaxOutputSpeed() {
		return getOutputSpeed();
	}

	public void setOutputSpeed(int outputSpeed) {
		this.storage.setMaxExtract(outputSpeed);
	}

	public int getInputSpeed() {
		return storage.getMaxReceive();
	}

	public void setInputSpeed(int inputSpeed) {
		this.storage.setMaxReceive(inputSpeed);
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		storage.writeToNBT(nbt);
		super.writeToNBT(nbt);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		storage.readFromNBT(nbt);
		super.readFromNBT(nbt);
	}
}
