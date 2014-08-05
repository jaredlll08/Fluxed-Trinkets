package com.jared.electrifiedtrinkets.tileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.oredict.OreDictionary;

import com.jared.electrifiedtrinkets.items.ETItems;
import com.jared.electrifiedtrinkets.network.MessageSpeedCircuitCrafting;
import com.jared.electrifiedtrinkets.network.PacketHandler;
import com.jared.electrifiedtrinkets.util.NBTHelper;

import cpw.mods.fml.relauncher.Side;

public class TileEntitySolderingStation extends TileEntity implements ISidedInventory {

	public ItemStack[] items;

	public TileEntitySolderingStation() {
		items = new ItemStack[14];

	}

	@Override
	public void closeInventory() {

	}

	@Override
	public ItemStack decrStackSize(int i, int count) {
		ItemStack itemstack = getStackInSlot(i);

		if (itemstack != null) {
			if (itemstack.stackSize <= count) {
				setInventorySlotContents(i, null);
			} else {
				itemstack = itemstack.splitStack(count);

			}
		}

		return itemstack;
	}

	@Override
	public String getInventoryName() {
		return "Soldering Station";
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public int getSizeInventory() {
		return items.length;
	}

	@Override
	public ItemStack getStackInSlot(int par1) {

		return items[par1];
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		ItemStack item = getStackInSlot(i);
		// setInventorySlotContents(i, null);
		setInventorySlotContents(i, item);
		return item;
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack stack) {
		if (stack == new ItemStack(ETItems.circuit, 0, OreDictionary.WILDCARD_VALUE)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer arg0) {
		return true;
	}

	@Override
	public void openInventory() {

	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		items[i] = itemstack;

		if (itemstack != null && itemstack.stackSize > getInventoryStackLimit()) {
			itemstack.stackSize = getInventoryStackLimit();
		}
	}

	@Override
	public boolean canExtractItem(int arg0, ItemStack arg1, int arg2) {
		return true;
	}

	@Override
	public boolean canInsertItem(int arg0, ItemStack arg1, int arg2) {
		return true;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int arg0) {
		return null;
	}

	/* NBT */
	@Override
	public void readFromNBT(NBTTagCompound tags) {
		super.readFromNBT(tags);
		readInventoryFromNBT(tags);
	}

	public void readInventoryFromNBT(NBTTagCompound tags) {
		NBTTagList nbttaglist = tags.getTagList("Items", Constants.NBT.TAG_COMPOUND);
		for (int iter = 0; iter < nbttaglist.tagCount(); iter++) {
			NBTTagCompound tagList = (NBTTagCompound) nbttaglist.getCompoundTagAt(iter);
			byte slotID = tagList.getByte("Slot");
			if (slotID >= 0 && slotID < items.length) {
				items[slotID] = ItemStack.loadItemStackFromNBT(tagList);
			}
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound tags) {
		super.writeToNBT(tags);
		writeInventoryToNBT(tags);
	}

	public void writeInventoryToNBT(NBTTagCompound tags) {
		NBTTagList nbttaglist = new NBTTagList();
		for (int iter = 0; iter < items.length; iter++) {
			if (items[iter] != null) {
				NBTTagCompound tagList = new NBTTagCompound();
				tagList.setByte("Slot", (byte) iter);
				items[iter].writeToNBT(tagList);
				nbttaglist.appendTag(tagList);
			}
		}

		tags.setTag("Items", nbttaglist);
	}

	public boolean craftCircuit() {
		for (int i = 0; i < items.length; i++) {
			if (this.getStackInSlot(i) == null)
				return false;
		}
		for (int i = 7; i < 14; i++) {
			if (this.getStackInSlot(i).getItem() != ETItems.copperNugget) {
				return false;
			}
		}

		if (this.getStackInSlot(1).getItem() == ETItems.circuit && this.getStackInSlot(0).getItem() == ETItems.solderingIron && this.getStackInSlot(2).getItem() == ETItems.leadWire) {
			for (int i = 3; i < 7; i++) {
				
				
			}
		}

		return false;
	}

	public void craftSpeedCircuit() {
		if (this.getStackInSlot(1) != null && this.getStackInSlot(1).getItem() == ETItems.circuit && this.getStackInSlot(0).getItem() == ETItems.solderingIron) {
			int j = 0;
			for (int i = 7; i < 14; i++) {
				if (this.getStackInSlot(i) != null) {
					this.setInventorySlotContents(i, null);
					j++;
				}
			}

			if (j > 6) {

				this.setInventorySlotContents(1, new ItemStack(ETItems.speedCircuit));
				this.items[0].setItemDamage(items[0].getItemDamage() + 1);
				PacketHandler.INSTANCE.sendToServer(new MessageSpeedCircuitCrafting(xCoord, yCoord, zCoord));

			}
		}
	}
}
