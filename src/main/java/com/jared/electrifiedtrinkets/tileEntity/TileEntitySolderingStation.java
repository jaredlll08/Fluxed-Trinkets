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
import com.jared.electrifiedtrinkets.network.MessageCircuitCrafting;
import com.jared.electrifiedtrinkets.network.PacketHandler;
import com.jared.electrifiedtrinkets.network.message.MessageCircuitCraftingSpeed;

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
		ItemStack result = null;

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
			int j = 0;

			for (int k = 7; k < 14; k++) {
				if (this.getStackInSlot(k) != null) {
					this.decrStackSize(k, 1);

					j++;
				}
			}

			int m = 0;
			;
			for (int l = 3; l < 7; l++) {
				if (this.getStackInSlot(l).getItem() == ETItems.addons[0].getItem() && getStackInSlot(l) != null) {
					result = new ItemStack(ETItems.speedCircuit);
					m++;
					j++;
				}
				if (this.getStackInSlot(l).getItem() == ETItems.addons[1].getItem() && getStackInSlot(l) != null) {
					result = new ItemStack(ETItems.jumpCircuit);
					m++;
					j++;
				}
				if (m > 3) {
					this.decrStackSize(3, 1);
					this.decrStackSize(4, 1);
					this.decrStackSize(5, 1);
					this.decrStackSize(6, 1);

				}
			}
			if (j > 10) {
				if (getStackInSlot(2).getItem() == null) {
					return false;
				} else {
					decrStackSize(2, 1);
				}

				this.setInventorySlotContents(1, result);
				this.items[0].setItemDamage(items[0].getItemDamage() + 1);
				PacketHandler.INSTANCE.sendToServer(new MessageCircuitCrafting(xCoord, yCoord, zCoord));

			}
			return true;
		}

		return false;
	}

	public boolean craftSpeedCircuit() {
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
			int j = 0;

			for (int k = 7; k < 14; k++) {
				if (this.getStackInSlot(k) != null) {
					this.decrStackSize(k, 1);
					j++;
				}
			}

			for (int l = 3; l < 7; l++) {
				if (this.getStackInSlot(l).getItem() == ETItems.addons[0].getItem()) {
					this.decrStackSize(l, 1);
					j++;
				}

			}
			if (j > 10) {
				if (getStackInSlot(2).getItem() == null) {
					return false;
				} else {
					decrStackSize(2, 1);
				}
				this.setInventorySlotContents(1, new ItemStack(ETItems.speedCircuit));
				this.items[0].setItemDamage(items[0].getItemDamage() + 1);
				PacketHandler.INSTANCE.sendToServer(new MessageCircuitCraftingSpeed(xCoord, yCoord, zCoord));

			}
			return true;
		}

		return false;
	}

	public boolean craftJumpCircuit() {
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
			int j = 0;

			for (int k = 7; k < 14; k++) {
				if (this.getStackInSlot(k) != null) {

					this.decrStackSize(k, 1);
					j++;
				}
			}

			for (int l = 3; l < 7; l++) {
				if (this.getStackInSlot(l).getItem() == ETItems.addons[1].getItem()) {
					this.decrStackSize(l, 1);
					j++;
				}

			}
			if (j > 10) {
				if (getStackInSlot(2).getItem() == null) {
					return false;
				} else {
					decrStackSize(2, 1);
				}
				this.setInventorySlotContents(1, new ItemStack(ETItems.speedCircuit));
				this.items[0].setItemDamage(items[0].getItemDamage() + 1);
				PacketHandler.INSTANCE.sendToServer(new MessageCircuitCraftingSpeed(xCoord, yCoord, zCoord));

			}
			return true;
		}

		return false;
	}

}
