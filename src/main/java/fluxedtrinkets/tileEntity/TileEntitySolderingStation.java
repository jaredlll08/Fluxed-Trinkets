package fluxedtrinkets.tileEntity;

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
import fluxedtrinkets.api.SolderingRegistry;
import fluxedtrinkets.items.FTItems;

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
		setInventorySlotContents(i, item);
		return item;
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack stack) {
		if (stack == new ItemStack(FTItems.circuit, 0, OreDictionary.WILDCARD_VALUE)) {
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

		for (int i = 0; i < SolderingRegistry.getRecipes().size(); i++) {
			if (SolderingRegistry.getRecipes().get(i).matches(item[0], item[1], item[2], item[3], item[4])) {
				decrStackSize(3, 1);
				decrStackSize(4, 1);
				decrStackSize(5, 1);
				decrStackSize(6, 1);
				items[0].setItemDamage(items[0].getItemDamage() + 1);
				if (items[0].getItemDamage() >= 50) {
					setInventorySlotContents(0, null);
				}
				decrStackSize(2, 1);
				items[1] = SolderingRegistry.getRecipes().get(i).getOutput();
				for (int j = 7; j < 14; j++) {
					decrStackSize(j, 1);
				}
			}
		}
		//
		// /*
		// * earth circuit
		// */
		// if (item[0].getItem() == FTItems.circuit) {
		// if (item[1].getItem() == Item.getItemFromBlock(Blocks.grass)) {
		// if (item[2].getItem() == Item.getItemFromBlock(Blocks.obsidian)) {
		// if (item[3].getItem() == Item.getItemFromBlock(Blocks.iron_ore)) {
		// if (item[4].getItem() == Item.getItemFromBlock(Blocks.sapling)) {
		// decrStackSize(3, 1);
		// decrStackSize(4, 1);
		// decrStackSize(5, 1);
		// decrStackSize(6, 1);
		// items[0].setItemDamage(items[0].getItemDamage() + 1);
		// if (items[0].getItemDamage() >= 50) {
		// setInventorySlotContents(0, null);
		// }
		// decrStackSize(2, 1);
		// items[1] = new ItemStack(FTItems.circuitEarth);
		// for (int i = 7; i < 14; i++) {
		// decrStackSize(i, 1);
		//
		// }
		// }
		// }
		// }
		// }
		// }
		//
		// /*
		// * Air Circuit
		// */
		// if (item[0].getItem() == FTItems.circuit) {
		// if (item[1].getItem() == Items.ghast_tear) {
		// if (item[2].getItem() == Item.getItemFromBlock(Blocks.leaves)) {
		// if (item[3].getItem() == Item.getItemFromBlock(Blocks.deadbush)) {
		// if (item[4].getItem() == Items.feather) {
		// decrStackSize(3, 1);
		// decrStackSize(4, 1);
		// decrStackSize(5, 1);
		// decrStackSize(6, 1);
		// items[0].setItemDamage(items[0].getItemDamage() + 1);
		// if (items[0].getItemDamage() <= 0) {
		// setInventorySlotContents(0, null);
		// }
		//
		// decrStackSize(2, 1);
		// items[1] = new ItemStack(FTItems.circuitAir);
		// for (int i = 7; i < 14; i++) {
		// decrStackSize(i, 1);
		//
		// }
		// }
		// }
		// }
		// }
		// }
		//
		// /*
		// * Fire Circuit
		// */
		// if (item[0].getItem() == FTItems.circuit) {
		// if (item[1].getItem() == Items.lava_bucket) {
		// if (item[2].getItem() == Item.getItemFromBlock(Blocks.coal_block)) {
		// if (item[3].getItem() == Item.getItemFromBlock(Blocks.log)) {
		// if (item[4].getItem() == Items.flint_and_steel) {
		// decrStackSize(3, 1);
		// decrStackSize(4, 1);
		// decrStackSize(5, 1);
		// decrStackSize(6, 1);
		// items[0].setItemDamage(items[0].getItemDamage() + 1);
		// if (items[0].getItemDamage() <= 0) {
		// setInventorySlotContents(0, null);
		// }
		//
		// decrStackSize(2, 1);
		// items[1] = new ItemStack(FTItems.circuitFire);
		// for (int i = 7; i < 14; i++) {
		// decrStackSize(i, 1);
		//
		// }
		// }
		// }
		// }
		// }
		// }
		//
		// /*
		// * Water Circuit
		// */
		// if (item[0].getItem() == FTItems.circuit) {
		// if (item[1].getItem() == Items.water_bucket) {
		// if (item[2].getItem() == Item.getItemFromBlock(Blocks.ice)) {
		// if (item[3].getItem() == Item.getItemFromBlock(Blocks.waterlily)) {
		// if (item[4].getItem() == Items.dye) {
		// decrStackSize(3, 1);
		// decrStackSize(4, 1);
		// decrStackSize(5, 1);
		// decrStackSize(6, 1);
		// items[0].setItemDamage(items[0].getItemDamage() + 1);
		// if (items[0].getItemDamage() <= 0) {
		// setInventorySlotContents(0, null);
		// }
		//
		// decrStackSize(2, 1);
		// items[1] = new ItemStack(FTItems.circuitWater);
		// for (int i = 7; i < 14; i++) {
		// decrStackSize(i, 1);
		//
		// }
		// }
		// }
		// }
		// }
		// }
		//
		// /*
		// * Chilling Circuit
		// */
		// if (item[0].getItem() == FTItems.circuitWater) {
		// if (item[1].getItem() == Item.getItemFromBlock(Blocks.snow)) {
		// if (item[2].getItem() == new ItemStack(Items.potionitem, 1,
		// 8200).getItem()) {
		// if (item[3].getItem() == Item.getItemFromBlock(Blocks.ice)) {
		// if (item[4].getItem() == Items.cake) {
		// decrStackSize(3, 1);
		// decrStackSize(4, 1);
		// decrStackSize(5, 1);
		// decrStackSize(6, 1);
		// items[0].setItemDamage(items[0].getItemDamage() + 1);
		// if (items[0].getItemDamage() <= 0) {
		// setInventorySlotContents(0, null);
		// }
		//
		// decrStackSize(2, 1);
		// items[1] = new ItemStack(FTItems.advancedCircuitIce);
		// for (int i = 7; i < 14; i++) {
		// decrStackSize(i, 1);
		//
		// }
		// }
		// }
		// }
		// }
		// }
		//
		// /*
		// * Life Circuit
		// */
		// if (item[0].getItem() == FTItems.circuitEarth) {
		// if (item[1].getItem() == Items.speckled_melon) {
		// if (item[2].getItem() == new ItemStack(Items.potionitem, 1,
		// 8197).getItem()) {
		// if (item[3].getItem() == new ItemStack(Items.potionitem, 1,
		// 8257).getItem()) {
		// if (item[4].getItem() == Items.golden_apple) {
		// decrStackSize(3, 1);
		// decrStackSize(4, 1);
		// decrStackSize(5, 1);
		// decrStackSize(6, 1);
		// items[0].setItemDamage(items[0].getItemDamage() + 1);
		// if (items[0].getItemDamage() <= 0) {
		// setInventorySlotContents(0, null);
		// }
		//
		// decrStackSize(2, 1);
		// items[1] = new ItemStack(FTItems.advancedCircuitLife);
		// for (int i = 7; i < 14; i++) {
		// decrStackSize(i, 1);
		//
		// }
		// }
		// }
		// }
		// }
		// }
		//
		// /*
		// * Lightning Circuit
		// */
		// if (item[0].getItem() == FTItems.circuitEarth) {
		// if (item[1].getItem() == Items.glowstone_dust) {
		// if (item[2].getItem() == new ItemStack(Items.redstone).getItem()) {
		// if (item[3].getItem() == new ItemStack(Blocks.iron_bars).getItem()) {
		// if (item[4].getItem() == FTItems.advancedCircuitLava) {
		// decrStackSize(3, 1);
		// decrStackSize(4, 1);
		// decrStackSize(5, 1);
		// decrStackSize(6, 1);
		// items[0].setItemDamage(items[0].getItemDamage() + 1);
		// if (items[0].getItemDamage() <= 0) {
		// setInventorySlotContents(0, null);
		// }
		//
		// decrStackSize(2, 1);
		// items[1] = new ItemStack(FTItems.advancedCircuitLightning);
		// for (int i = 7; i < 14; i++) {
		// decrStackSize(i, 1);
		//
		// }
		// }
		// }
		// }
		// }
		// }
		//
		// /*
		// * Lava Circuit
		// */
		// if (item[0].getItem() == FTItems.circuitFire) {
		// if (item[1].getItem() == new ItemStack(Items.potionitem, 1,
		// 8195).getItem()) {
		// if (item[2].getItem() == Items.blaze_rod) {
		// if (item[3].getItem() == Items.blaze_powder) {
		// if (item[4].getItem() == Item.getItemFromBlock(Blocks.netherrack)) {
		// decrStackSize(3, 1);
		// decrStackSize(4, 1);
		// decrStackSize(5, 1);
		// decrStackSize(6, 1);
		// items[0].setItemDamage(items[0].getItemDamage() + 1);
		// if (items[0].getItemDamage() <= 0) {
		// setInventorySlotContents(0, null);
		// }
		//
		// decrStackSize(2, 1);
		// items[1] = new ItemStack(FTItems.advancedCircuitLava);
		// for (int i = 7; i < 14; i++) {
		// decrStackSize(i, 1);
		//
		// }
		// }
		// }
		// }
		// }
		// }
		return false;
	}
}
