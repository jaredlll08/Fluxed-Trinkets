package com.jared.electrifiedtrinkets.tileEntity;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;

import com.jared.electrifiedtrinkets.items.ETItems;
import com.jared.electrifiedtrinkets.items.ItemCircuit;
import com.jared.electrifiedtrinkets.network.MessageTrinketAssembler;
import com.jared.electrifiedtrinkets.network.PacketHandler;
import com.jared.electrifiedtrinkets.util.NBTHelper;

public class TileEntityTrinketAssembler extends TileEntity implements ISidedInventory {

	public ItemStack[] items;

	public TileEntityTrinketAssembler() {
		items = new ItemStack[5];
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
		return "Trinket Assembler";
	}

	@Override
	public int getInventoryStackLimit() {
		return 1;
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
		setInventorySlotContents(i, item);
		return item;
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack stack) {
		return true;
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

	public boolean craftTrinket() {
		ItemStack[] item = new ItemStack[5];
		item[0] = getStackInSlot(0);
		item[1] = getStackInSlot(1);
		item[2] = getStackInSlot(2);
		item[3] = getStackInSlot(3);
		item[4] = getStackInSlot(4);
		String effects = "";
		ArrayList<String> totalEffects = new ArrayList<String>();
		for (int i = 1; i < item.length; i++) {
			if (item[i] != null) {
				if (item[i].getItem() instanceof ItemCircuit) {
					ItemCircuit circuit = (ItemCircuit) item[i].getItem();

					totalEffects.add(circuit.getEffect());

					if (totalEffects.contains("earth")) {
						if (totalEffects.contains("empty")) {
							totalEffects.remove("empty");
							totalEffects.remove("earth");
							totalEffects.add("step");
						}
						if (totalEffects.contains("advancedEmpty") && totalEffects.contains("air")) {
							totalEffects.remove("advancedEmpty");
							totalEffects.remove("air");
							totalEffects.remove("earth");
							totalEffects.add("jump");
						}
						if (totalEffects.contains("air") && !totalEffects.contains("advancedEmpty")) {
							totalEffects.remove("air");
							totalEffects.remove("earth");
							totalEffects.add("haste");
						}
						if (totalEffects.contains("water")) {
							if (totalEffects.contains("advancedLife")) {
								totalEffects.remove("water");
								totalEffects.remove("advancedLife");
								totalEffects.add("growth");
							}
						}
					}
					

					if (totalEffects.contains("air")) {
						if (totalEffects.contains("water")) {
							totalEffects.remove("air");
							totalEffects.remove("water");
							totalEffects.add("respiratory");
						}
					}

					if (totalEffects.contains("fire") && totalEffects.contains("advancedLava")) {
						totalEffects.remove("fire");
						totalEffects.remove("advancedLava");
						totalEffects.add("Scorched");
					}
					if (totalEffects.contains("water") && totalEffects.contains("advancedIce")) {
						totalEffects.remove("water");
						totalEffects.remove("advancedIce");
						totalEffects.add("Freezing");
					}

				}
			}
		}

		if (item[0] != null) {
			ItemStack result = item[0].copy();
			NBTHelper.setString(result, "ETEffect", totalEffects.toString());
			setInventorySlotContents(0, result);
			decrStackSize(1, 1);
			decrStackSize(2, 1);
			decrStackSize(3, 1);
			decrStackSize(4, 1);

			// PacketHandler.INSTANCE.sendToServer(new
			// MessageTrinketAssembler(xCoord, yCoord, zCoord));
			return true;
		}

		return false;
	}

}
