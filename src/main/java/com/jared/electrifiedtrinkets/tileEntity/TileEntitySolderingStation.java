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
import com.jared.electrifiedtrinkets.network.PacketHandler;

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

	// public boolean craftCircuit() {
	// ItemStack result = null;
	// ItemStack[] items = new ItemStack[5];
	//
	// for (int i = 0; i < items.length; i++) {
	// if (this.getStackInSlot(i) == null)
	// return false;
	// }
	// for (int i = 7; i < 14; i++) {
	// if (this.getStackInSlot(i).getItem() == null) {
	// return false;
	// }
	// }
	//
	// if (this.getStackInSlot(1).getItem() == ETItems.circuit &&
	// this.getStackInSlot(0).getItem() == ETItems.solderingIron &&
	// this.getStackInSlot(2).getItem() == ETItems.leadWire) {
	// int j = 0;
	//
	// for (int k = 7; k < 14; k++) {
	// if (this.getStackInSlot(k) != null) {
	// this.decrStackSize(k, 1);
	//
	// j++;
	// }
	// }
	//
	// items[0] = getStackInSlot(1);
	// items[1] = getStackInSlot(3);
	// items[2] = getStackInSlot(4);
	// items[3] = getStackInSlot(5);
	// items[4] = getStackInSlot(6);
	//
	// if (items[0].getItem() == ETItems.circuit) {
	//
	// if (items[1].getItem() == Item.getItemFromBlock(Blocks.coal_block)) {
	// if (items[2].getItem() == Item.getItemFromBlock(Blocks.iron_ore)) {
	// if (items[3].getItem() == Item.getItemFromBlock(Blocks.sapling)) {
	// if(items[4].getItem() == Item.getItemFromBlock(Blocks.grass)){
	// decrStackSize(3, 1);
	// decrStackSize(4, 1);
	// decrStackSize(5, 1);
	// decrStackSize(6, 1);
	// setInventorySlotContents(1, new ItemStack(ETItems.circuitEarth));
	// }
	// }
	// }
	// }
	//
	// }
	//
	// int m = 0;
	// for (int l = 3; l < 7; l++) {
	// if (this.getStackInSlot(l).getItem() == ETItems.addons[0].getItem() &&
	// getStackInSlot(l) != null) {
	// result = new ItemStack(ETItems.speedCircuit);
	// m++;
	// j++;
	// }
	// if (this.getStackInSlot(l).getItem() == ETItems.addons[1].getItem() &&
	// getStackInSlot(l) != null) {
	// result = new ItemStack(ETItems.jumpCircuit);
	// m++;
	// j++;
	// }
	// if (this.getStackInSlot(l).getItem() == ETItems.addons[2].getItem() &&
	// getStackInSlot(l) != null) {
	// result = new ItemStack(ETItems.circtuitStep);
	// m++;
	// j++;
	// }
	//
	// if (m > 3) {
	// this.decrStackSize(3, 1);
	// this.decrStackSize(4, 1);
	// this.decrStackSize(5, 1);
	// this.decrStackSize(6, 1);
	//
	// }
	// }
	// if (j > 10) {
	// if (getStackInSlot(2).getItem() == null) {
	// return false;
	// } else {
	// decrStackSize(2, 1);
	// }
	//
	// this.setInventorySlotContents(1, result);
	// this.items[0].setItemDamage(items[0].getItemDamage() + 1);
	// PacketHandler.INSTANCE.sendToServer(new MessageCircuitCrafting(xCoord,
	// yCoord, zCoord));
	//
	// }
	// return true;
	// }
	//
	// if (this.getStackInSlot(1).getItem() == ETItems.advancedCircuit &&
	// this.getStackInSlot(0).getItem() == ETItems.solderingIron &&
	// this.getStackInSlot(2).getItem() == ETItems.leadWire) {
	// int j = 0;
	//
	// for (int k = 7; k < 14; k++) {
	// if (this.getStackInSlot(k) != null) {
	// this.decrStackSize(k, 1);
	//
	// j++;
	// }
	// }
	//
	// int m = 0;
	// for (int l = 3; l < 7; l++) {
	// if (this.getStackInSlot(l).getItem() == ETItems.addons[4].getItem() &&
	// getStackInSlot(l) != null) {
	// result = new ItemStack(ETItems.circuitAdvancedFire);
	// m++;
	// j++;
	// }
	// if (this.getStackInSlot(l).getItem() == ETItems.addons[5].getItem() &&
	// getStackInSlot(l) != null) {
	// result = new ItemStack(ETItems.circuitAdvancedWater);
	// m++;
	// j++;
	// }
	// if (m > 3) {
	// this.decrStackSize(3, 1);
	// this.decrStackSize(4, 1);
	// this.decrStackSize(5, 1);
	// this.decrStackSize(6, 1);
	//
	// }
	// }
	// if (j > 10) {
	// if (getStackInSlot(2).getItem() == null) {
	// return false;
	// } else {
	// decrStackSize(2, 1);
	// }
	//
	// this.setInventorySlotContents(1, result);
	// this.items[0].setItemDamage(items[0].getItemDamage() + 1);
	// PacketHandler.INSTANCE.sendToServer(new MessageCircuitCrafting(xCoord,
	// yCoord, zCoord));
	//
	// }
	// return true;
	// }
	//
	// return false;
	// }

	public boolean craftCircuit() {
		ItemStack[] item = new ItemStack[5];
		for (int i = 0; i < items.length; i++) {
			if (items[i] == null) {
				return false;
			}
		}
		item[0] = getStackInSlot(1);
		item[1] = getStackInSlot(3);
		item[2] = getStackInSlot(4);
		item[3] = getStackInSlot(5);
		item[4] = getStackInSlot(6);
		/*
		 * earth circuit
		 */
		if (item[0].getItem() == ETItems.circuit) {
			if (item[1].getItem() == Item.getItemFromBlock(Blocks.dirt)) {
				if (item[2].getItem() == Item.getItemFromBlock(Blocks.coal_block)) {
					if (item[3].getItem() == Item.getItemFromBlock(Blocks.iron_ore)) {
						if (item[4].getItem() == Item.getItemFromBlock(Blocks.sapling)) {
							decrStackSize(3, 1);
							decrStackSize(4, 1);
							decrStackSize(5, 1);
							decrStackSize(6, 1);
							items[0].setItemDamage(items[0].getItemDamage() + 10);
							if (items[0].getItemDamage() >= 50) {
								setInventorySlotContents(0, null);
							}
							decrStackSize(2, 1);
							items[1] = new ItemStack(ETItems.circuitEarth);
							PacketHandler.INSTANCE.sendToServer(new MessageCircuitCrafting(xCoord, yCoord, zCoord));
							for (int i = 7; i < 14; i++) {
								decrStackSize(i, 1);

							}
						}
					}
				}
			}
		}

		/*
		 * Air Circuit
		 */
		if (item[0].getItem() == ETItems.circuit) {
			if (item[1].getItem() == Items.ghast_tear) {
				if (item[2].getItem() == Item.getItemFromBlock(Blocks.leaves)) {
					if (item[3].getItem() == Item.getItemFromBlock(Blocks.deadbush)) {
						if (item[4].getItem() == Items.feather) {
							decrStackSize(3, 1);
							decrStackSize(4, 1);
							decrStackSize(5, 1);
							decrStackSize(6, 1);
							items[0].setItemDamage(items[0].getItemDamage() + 1);
							if (items[0].getItemDamage() <= 0) {
								setInventorySlotContents(0, null);
							}

							decrStackSize(2, 1);
							items[1] = new ItemStack(ETItems.circuitAir);
							PacketHandler.INSTANCE.sendToServer(new MessageCircuitCrafting(xCoord, yCoord, zCoord));
							for (int i = 7; i < 14; i++) {
								decrStackSize(i, 1);

							}
						}
					}
				}
			}
		}

		/*
		 * Fire Circuit
		 */
		if (item[0].getItem() == ETItems.circuit) {
			if (item[1].getItem() == Items.lava_bucket) {
				if (item[2].getItem() == Item.getItemFromBlock(Blocks.coal_block)) {
					if (item[3].getItem() == Item.getItemFromBlock(Blocks.log)) {
						if (item[4].getItem() == Items.flint_and_steel) {
							decrStackSize(3, 1);
							decrStackSize(4, 1);
							decrStackSize(5, 1);
							decrStackSize(6, 1);
							items[0].setItemDamage(items[0].getItemDamage() + 1);
							if (items[0].getItemDamage() <= 0) {
								setInventorySlotContents(0, null);
							}

							decrStackSize(2, 1);
							items[1] = new ItemStack(ETItems.circuitFire);
							PacketHandler.INSTANCE.sendToServer(new MessageCircuitCrafting(xCoord, yCoord, zCoord));
							for (int i = 7; i < 14; i++) {
								decrStackSize(i, 1);

							}
						}
					}
				}
			}
		}

		/*
		 * Water Circuit
		 */
		if (item[0].getItem() == ETItems.circuit) {
			if (item[1].getItem() == Items.water_bucket) {
				if (item[2].getItem() == Item.getItemFromBlock(Blocks.ice)) {
					if (item[3].getItem() == Item.getItemFromBlock(Blocks.waterlily)) {
						if (item[4].getItem() == Items.dye) {
							decrStackSize(3, 1);
							decrStackSize(4, 1);
							decrStackSize(5, 1);
							decrStackSize(6, 1);
							items[0].setItemDamage(items[0].getItemDamage() + 1);
							if (items[0].getItemDamage() <= 0) {
								setInventorySlotContents(0, null);
							}

							decrStackSize(2, 1);
							items[1] = new ItemStack(ETItems.circuitWater);
							PacketHandler.INSTANCE.sendToServer(new MessageCircuitCrafting(xCoord, yCoord, zCoord));
							for (int i = 7; i < 14; i++) {
								decrStackSize(i, 1);

							}
						}
					}
				}
			}
		}

		/*
		 * Chilling Circuit
		 */
		if (item[0].getItem() == ETItems.circuitWater) {
			if (item[1].getItem() == Item.getItemFromBlock(Blocks.snow)) {
				if (item[2].getItem() == new ItemStack(Items.potionitem, 1, 8200).getItem()) {
					if (item[3].getItem() == Item.getItemFromBlock(Blocks.ice)) {
						if (item[4].getItem() == Items.cake) {
							decrStackSize(3, 1);
							decrStackSize(4, 1);
							decrStackSize(5, 1);
							decrStackSize(6, 1);
							items[0].setItemDamage(items[0].getItemDamage() + 1);
							if (items[0].getItemDamage() <= 0) {
								setInventorySlotContents(0, null);
							}

							decrStackSize(2, 1);
							items[1] = new ItemStack(ETItems.advancedCircuitIce);
							PacketHandler.INSTANCE.sendToServer(new MessageCircuitCrafting(xCoord, yCoord, zCoord));
							for (int i = 7; i < 14; i++) {
								decrStackSize(i, 1);

							}
						}
					}
				}
			}
		}

		/*
		 * Life Circuit
		 */
		if (item[0].getItem() == ETItems.circuitEarth) {
			if (item[1].getItem() == Items.speckled_melon) {
				if (item[2].getItem() == new ItemStack(Items.potionitem, 1, 8197).getItem()) {
					if (item[3].getItem() == new ItemStack(Items.potionitem, 1, 8257).getItem()) {
						if (item[4].getItem() == Items.golden_apple) {
							decrStackSize(3, 1);
							decrStackSize(4, 1);
							decrStackSize(5, 1);
							decrStackSize(6, 1);
							items[0].setItemDamage(items[0].getItemDamage() + 1);
							if (items[0].getItemDamage() <= 0) {
								setInventorySlotContents(0, null);
							}

							decrStackSize(2, 1);
							items[1] = new ItemStack(ETItems.advancedCircuitLife);
							PacketHandler.INSTANCE.sendToServer(new MessageCircuitCrafting(xCoord, yCoord, zCoord));
							for (int i = 7; i < 14; i++) {
								decrStackSize(i, 1);

							}
						}
					}
				}
			}
		}

		/*
		 * Life Circuit
		 */
		if (item[0].getItem() == ETItems.circuitAir) {
			if (item[1].getItem() == Items.redstone) {
				if (item[2].getItem() == Item.getItemFromBlock(Blocks.glowstone)) {
					if (item[3].getItem() == Item.getItemFromBlock(Blocks.iron_bars)) {
						if (item[4].getItem() == Items.sugar) {
							decrStackSize(3, 1);
							decrStackSize(4, 1);
							decrStackSize(5, 1);
							decrStackSize(6, 1);
							items[0].setItemDamage(items[0].getItemDamage() + 1);
							if (items[0].getItemDamage() <= 0) {
								setInventorySlotContents(0, null);
							}

							decrStackSize(2, 1);
							items[1] = new ItemStack(ETItems.advancedCircuitLife);
							PacketHandler.INSTANCE.sendToServer(new MessageCircuitCrafting(xCoord, yCoord, zCoord));
							for (int i = 7; i < 14; i++) {
								decrStackSize(i, 1);

							}
						}
					}
				}
			}
		}

		/*
		 * Lava Circuit
		 */
		if (item[0].getItem() == ETItems.circuitFire) {
			if (item[1].getItem() == new ItemStack(Items.potionitem, 1, 8195).getItem()) {
				if (item[2].getItem() == Items.blaze_rod) {
					if (item[3].getItem() == Items.blaze_powder) {
						if (item[4].getItem() == Item.getItemFromBlock(Blocks.netherrack)) {
							decrStackSize(3, 1);
							decrStackSize(4, 1);
							decrStackSize(5, 1);
							decrStackSize(6, 1);
							items[0].setItemDamage(items[0].getItemDamage() + 1);
							if (items[0].getItemDamage() <= 0) {
								setInventorySlotContents(0, null);
							}

							decrStackSize(2, 1);
							items[1] = new ItemStack(ETItems.advancedCircuitLava);
							PacketHandler.INSTANCE.sendToServer(new MessageCircuitCrafting(xCoord, yCoord, zCoord));
							for (int i = 7; i < 14; i++) {
								decrStackSize(i, 1);

							}
						}
					}
				}
			}
		}
		return false;
	}
}
