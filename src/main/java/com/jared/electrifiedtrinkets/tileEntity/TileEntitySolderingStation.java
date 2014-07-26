package com.jared.electrifiedtrinkets.tileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntitySolderingStation extends TileEntity implements ISidedInventory{

	@Override
	public void closeInventory() {
		
	}

	@Override
	public ItemStack decrStackSize(int arg0, int arg1) {
		return null;
	}

	@Override
	public String getInventoryName() {
		return "Soldering Station";
	}

	@Override
	public int getInventoryStackLimit() {
		return 0;
	}

	@Override
	public int getSizeInventory() {
		return 0;
	}

	@Override
	public ItemStack getStackInSlot(int arg0) {
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int arg0) {
		return null;
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public boolean isItemValidForSlot(int arg0, ItemStack arg1) {
		return false;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer arg0) {
		return false;
	}

	@Override
	public void openInventory() {
		
	}

	@Override
	public void setInventorySlotContents(int arg0, ItemStack arg1) {
		
	}

	@Override
	public boolean canExtractItem(int arg0, ItemStack arg1, int arg2) {
		return false;
	}

	@Override
	public boolean canInsertItem(int arg0, ItemStack arg1, int arg2) {
		return false;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int arg0) {
		return null;
	}

}
