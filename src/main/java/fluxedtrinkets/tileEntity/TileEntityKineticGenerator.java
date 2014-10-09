package fluxedtrinkets.tileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.util.ForgeDirection;
import cofh.api.energy.IEnergyHandler;
import fluxedtrinkets.tileEntity.energy.TileEnergyBase;

public class TileEntityKineticGenerator extends TileEnergyBase implements IEnergyHandler {
	public EntityPlayer player;

	public TileEntityKineticGenerator() {
		super(500000);
	}
	
	public void updateEntity() {
		pushEnergy();
	}

	public void generateEnergy(int energy) {

		if (getEnergyStored() < getMaxStorage()) {
			storage.receiveEnergy(energy, false);
		}
	}
	
	@Override
	public ForgeDirection[] getValidOutputs() {
		return new ForgeDirection[] { ForgeDirection.DOWN, ForgeDirection.EAST, ForgeDirection.NORTH, ForgeDirection.SOUTH, ForgeDirection.WEST };
	}

	@Override
	public ForgeDirection[] getValidInputs() {
		return new ForgeDirection[] { ForgeDirection.UP };
	}

}