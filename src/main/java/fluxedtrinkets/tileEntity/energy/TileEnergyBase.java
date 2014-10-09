package fluxedtrinkets.tileEntity.energy;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

import org.apache.commons.lang3.ArrayUtils;

import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyHandler;
import fluxedtrinkets.network.MessageEnergyUpdate;
import fluxedtrinkets.network.PacketHandler;

public abstract class TileEnergyBase extends TileEntity implements IEnergyHandler
{
    protected EnergyStorage storage;
    protected int capacity;
    
    private int lastStored = 0;

    public TileEnergyBase(int cap)
    {
        super();
        init(cap);
    }

    private void init(int cap)
    {
        storage = new EnergyStorage(cap);
    }

    public abstract ForgeDirection[] getValidOutputs();

    public abstract ForgeDirection[] getValidInputs();

    @Override
    public void updateEntity()
    {
        super.updateEntity();
        if (!worldObj.isRemote)
        {
            pushEnergy();
            
            if (getEnergyStored() != lastStored)
            {
                sendPacket();
                lastStored = getEnergyStored();
            }
        }
    }

    private void sendPacket()
    {
        PacketHandler.INSTANCE.sendToDimension(new MessageEnergyUpdate(xCoord, yCoord, zCoord, getEnergyStored()), worldObj.provider.dimensionId);
    }

    protected void pushEnergy()
    {
        for (ForgeDirection dir : getValidOutputs())
        {
            TileEntity tile = worldObj.getTileEntity(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ);
            if (tile instanceof IEnergyHandler)
            {
                IEnergyHandler ieh = (IEnergyHandler) tile;
                int toExtract = ieh.receiveEnergy(dir, getMaxOutputSpeed(), true);
                ieh.receiveEnergy(dir, storage.extractEnergy(toExtract, false), false);
            }
        }
    }

    /* I/O Handling */

    @Override
    public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate)
    {
        if (ArrayUtils.contains(getValidOutputs(), from))
        {
            int ret = storage.extractEnergy(maxExtract, true);
            if (!simulate)
            {
                storage.extractEnergy(ret, false);
            }
            return ret;
        }
        return 0;
    }

    @Override
    public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate)
    {
        if (ArrayUtils.contains(getValidInputs(), from))
        {
            int ret = storage.receiveEnergy(maxReceive, true);
            if (!simulate)
            {
                storage.receiveEnergy(ret, false);
            }
            return ret;
        }
        return 0;
    }

    @Override
    public final boolean canConnectEnergy(ForgeDirection from)
    {
        return ArrayUtils.contains(getValidInputs(), from) || ArrayUtils.contains(getValidOutputs(), from);
    }

    /* IEnergyHandler basic impl */

    @Override
    public final int getEnergyStored(ForgeDirection from)
    {
        return getEnergyStored();
    }

    @Override
    public final int getMaxEnergyStored(ForgeDirection from)
    {
        return getMaxStorage();
    }
    

    
    /* getters & setters */

    public int getEnergyStored()
    {
        return storage.getEnergyStored();
    }

    public void setEnergyStored(int energy)
    {
        storage.setEnergyStored(energy);
    }

    public int getMaxStorage()
    {
        return storage.getMaxEnergyStored();
    }

    public void setMaxStorage(int storage)
    {
        this.storage.setCapacity(storage);
    }

    public int getOutputSpeed()
    {
        return storage.getMaxExtract();
    }

    public int getMaxOutputSpeed()
    {
        return getOutputSpeed();
    }

    public void setOutputSpeed(int outputSpeed)
    {
        this.storage.setMaxExtract(outputSpeed);
    }

    public int getInputSpeed()
    {
        return storage.getMaxReceive();
    }

    public void setInputSpeed(int inputSpeed)
    {
        this.storage.setMaxReceive(inputSpeed);
    }
    
    /* Read/Write NBT */
    
    @Override
    public void writeToNBT(NBTTagCompound nbt)
    {
        storage.writeToNBT(nbt);
        super.writeToNBT(nbt);
    }
    
    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        storage.readFromNBT(nbt);
        super.readFromNBT(nbt);
    }
}