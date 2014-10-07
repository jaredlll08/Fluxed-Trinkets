package fluxedtrinkets.tileEntity;

import java.util.List;
import java.util.Random;

import com.jcraft.jogg.Packet;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemLead;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.util.ForgeDirection;
import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyHandler;
import fluxedtrinkets.network.MessageEnergyUpdate;
import fluxedtrinkets.network.PacketHandler;

public class TileEntityKineticGenerator extends TileEntity implements IEnergyHandler {
	protected EnergyStorage storage;
	public EntityPlayer player;

	public TileEntityKineticGenerator() {
		init(500000);
		setInputSpeed(10000);
	}

	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		storage.writeToNBT(nbt);
	}

	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
//		storage = storage.readFromNBT(nbt);
	}

	public void updateEntity() {
		if (!worldObj.isRemote && worldObj.getWorldTime() % 10 == 0) {
			if (worldObj.getPlayerEntityByName("ForgeDevName") != null)
				worldObj.getPlayerEntityByName("ForgeDevName").addChatComponentMessage(new ChatComponentText(String.valueOf(getEnergyStored())));
		}
	}

	public void generateEnergy(int energy) {

		if (getEnergyStored() < getMaxStorage()) {
			receiveEnergy(ForgeDirection.UNKNOWN, energy, false);

		}
	}

	@Override
	public boolean canConnectEnergy(ForgeDirection from) {
		if (from != from.UP) {
			return true;
		}
		return false;
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