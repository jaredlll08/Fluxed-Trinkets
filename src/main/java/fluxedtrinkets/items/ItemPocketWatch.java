package fluxedtrinkets.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import baubles.api.BaubleType;
import fluxedtrinkets.api.ITrinket;

public class ItemPocketWatch extends Item implements ITrinket{

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
		return 0;
	}

	@Override
	public int getMaxEnergyStored(ItemStack container) {
		return 0;
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return null;
	}

	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
		
	}

	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player) {
		
	}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
		
	}

	@Override
	public boolean canEquip(ItemStack itemstack, EntityLivingBase player) {
		return false;
	}

	@Override
	public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
		return false;
	}

}
