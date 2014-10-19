package fluxedtrinkets.tileEntity;

import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.oredict.OreDictionary;
import fluxedtrinkets.api.SolderingRecipe;
import fluxedtrinkets.items.FTItems;
import fluxedtrinkets.tileEntity.energy.TileEnergyBase;

public class TileEntityHeatGenerator extends TileEnergyBase implements IInventory {
	private int percentage = 0;

	public TileEntityHeatGenerator() {
		super(200000);
		items = new ItemStack[1];
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	public void addPercentage(int amount) {
		this.percentage += amount;
	}

	public EntityPlayer player;

	public ItemStack[] items;

	public void updateEntity() {
		pushEnergy();
		if (getStackInSlot(0) == null) {
			setPercentage(0);
		}
		if (getStackInSlot(0) != null) {
			if (TileEntityFurnace.getItemBurnTime(getStackInSlot(0)) > 0) {
				int energy = TileEntityFurnace.getItemBurnTime(getStackInSlot(0));
				if (getPercentage() == TileEntityFurnace.getItemBurnTime(getStackInSlot(0))) {
					setPercentage(0);
					decrStackSize(0, 1);
					// receiveEnergy(ForgeDirection.DOWN,
					// TileEntityFurnace.getItemBurnTime(getStackInSlot(0)),
					// false);
					storage.receiveEnergy(energy, false);
					// storage.receiveEnergy(TileEntityFurnace.getItemBurnTime(getStackInSlot(0))
					// * (worldObj.rand.nextInt(6) + 1), false);
				} else {
					if (getStackInSlot(0) != null) {
						addPercentage(1);
					}

				}
			}
		}
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

	@Override
	public ForgeDirection[] getValidOutputs() {
		return new ForgeDirection[] { ForgeDirection.DOWN, ForgeDirection.UP, ForgeDirection.EAST, ForgeDirection.NORTH, ForgeDirection.SOUTH, ForgeDirection.WEST };
	}

	@Override
	public ForgeDirection[] getValidInputs() {
		return null;
	}

	public EnergyStorage getStorage() {
		return storage;
	}
}
