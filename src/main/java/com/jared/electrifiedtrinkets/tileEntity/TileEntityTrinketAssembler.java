package com.jared.electrifiedtrinkets.tileEntity;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.text.DateFormatter;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.oredict.OreDictionary;

import com.jared.electrifiedtrinkets.items.ETItems;
import com.jared.electrifiedtrinkets.network.MessageCircuitCrafting;
import com.jared.electrifiedtrinkets.network.MessageTrinketAssembler;
import com.jared.electrifiedtrinkets.network.PacketHandler;
import com.jared.electrifiedtrinkets.util.NBTHelper;

public class TileEntityTrinketAssembler extends TileEntity implements ISidedInventory {

	public ItemStack[] items;

	public TileEntityTrinketAssembler() {
		items = new ItemStack[6];
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

	public boolean craftTrinket() {
		ItemStack[] item = new ItemStack[5];
		item[0] = getStackInSlot(0);
		item[1] = getStackInSlot(1);
		item[2] = getStackInSlot(2);
		item[3] = getStackInSlot(3);
		item[4] = getStackInSlot(4);

		String[] effects = new String[4];

		
		
		if(item[1] !=null && item[1].stackTagCompound!=null){
			effects[0] = NBTHelper.getString(item[1], "ETEffect");
		}
		
		if(item[2] !=null && item[2].stackTagCompound!=null){
			effects[1] = NBTHelper.getString(item[2], "ETEffect");
		}
		
		if(item[3] !=null && item[3].stackTagCompound!=null){
			effects[2] = NBTHelper.getString(item[3], "ETEffect");
		}
		if(item[4] !=null && item[4].stackTagCompound!=null){
			effects[3] = NBTHelper.getString(item[4], "ETEffect");
		}
		
		if(item[0]!=null){
			ItemStack result = getStackInSlot(0);
			for(int i = 0; i < effects.length; i ++){
				if(effects[i]!=null){
					NBTHelper.setString(result, "ETEffect"+i, effects[i]);
				}	
			}
			setInventorySlotContents(1, result);
			PacketHandler.INSTANCE.sendToServer(new MessageTrinketAssembler(xCoord, yCoord, zCoord));
			
		}
		
		return false;
	}

}
