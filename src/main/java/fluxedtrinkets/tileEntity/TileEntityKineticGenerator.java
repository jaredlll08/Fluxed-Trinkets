package fluxedtrinkets.tileEntity;

import java.util.ArrayList;
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
import fluxedtrinkets.tileEntity.energy.TileEnergyBase;

public class TileEntityKineticGenerator extends TileEnergyBase implements IEnergyHandler {
	public EntityPlayer player;

	public TileEntityKineticGenerator() {
		super(500000);
		setInputSpeed(10000);
	}

	

	@Override
	protected void pushEnergy() {
		super.pushEnergy();
	}

	public void updateEntity() {
		pushEnergy();
		if (!worldObj.isRemote && worldObj.getWorldTime() % 10 == 0) {
			if (worldObj.getPlayerEntityByName("ForgeDevName") != null)
				worldObj.getPlayerEntityByName("ForgeDevName").addChatComponentMessage(new ChatComponentText(String.valueOf(getEnergyStored())));
		}
	}

	public void generateEnergy(int energy) {

		if (getEnergyStored() < getMaxStorage()) {
			storage.receiveEnergy(energy, false);
		}
	}

	private void init(int cap) {
		storage = new EnergyStorage(cap);
	}

	@Override
	public ForgeDirection[] getValidOutputs() {
		return new ForgeDirection[] { ForgeDirection.DOWN, ForgeDirection.EAST, ForgeDirection.NORTH, ForgeDirection.SOUTH, ForgeDirection.WEST };
	}

	@Override
	public ForgeDirection[] getValidInputs() {
		return null;
	}

}