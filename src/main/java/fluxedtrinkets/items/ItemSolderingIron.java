package fluxedtrinkets.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cofh.api.energy.IEnergyContainerItem;
import fluxedtrinkets.util.NBTHelper;

public class ItemSolderingIron extends Item implements IEnergyContainerItem{

	public ItemSolderingIron(){
		NBTHelper.setInteger(new ItemStack(this),  "energy", 0);
		this.setMaxDamage(50);
		this.setMaxStackSize(1);
	}
	
	@Override
	public int receiveEnergy(ItemStack container, int maxReceive, boolean simulate) {
		return 0;
	}

	@Override
	public int extractEnergy(ItemStack container, int maxExtract, boolean simulate) {
		return 0;
	}

	@Override
	public int getEnergyStored(ItemStack container) {
		return NBTHelper.getInt(container, "energy");
	}

	@Override
	public int getMaxEnergyStored(ItemStack container) {
		return 10000;
	}

}
