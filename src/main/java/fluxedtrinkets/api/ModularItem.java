package fluxedtrinkets.api;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import baubles.api.BaublesApi;
import baubles.api.IBauble;
import cofh.api.energy.IEnergyContainerItem;

public abstract class ModularItem extends Item implements IBauble, IEnergyContainerItem {

	private int maxCapacity;
	private int usage;

	public ModularItem(int maxCapacity) {
		this.setMaxStackSize(1);
		this.maxCapacity = maxCapacity;
	}

	public int getUsage() {
		return usage;
	}

	public void setUsage(int usage) {
		this.usage = usage;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		if (!par2World.isRemote) {
			IInventory baubles = BaublesApi.getBaubles(par3EntityPlayer);
			for (int i = 0; i < baubles.getSizeInventory(); i++)
				if (baubles.getStackInSlot(i) == null && baubles.isItemValidForSlot(i, par1ItemStack)) {
					baubles.setInventorySlotContents(i, par1ItemStack.copy());
					if (!par3EntityPlayer.capabilities.isCreativeMode) {
						par3EntityPlayer.inventory.setInventorySlotContents(par3EntityPlayer.inventory.currentItem, null);
					}
					onEquipped(par1ItemStack, par3EntityPlayer);
					break;
				}
		}
		return par1ItemStack;
	}

	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4, String effects) {
		super.addInformation(stack, player, list, par4);
		if (stack.stackTagCompound == null) {
			stack.stackTagCompound = new NBTTagCompound();
		}
		if (StringUtils.isShiftKeyDown()) {
			list.add(stack.stackTagCompound.getInteger("energy") + "/"+maxCapacity );
			list.add(StringUtils.getChargeText(stack.stackTagCompound.getInteger("energy"), maxCapacity));
			list.add(StringUtils.getEnergyUsageText(usage));
			if (effects != null && !effects.equals("[]") && !effects.equals("")) {
				// list.add(StringUtils.GRAY + effects);
				String[] effectList = effects.replace("[", "").replace("]", "").replace(" ", "").split(",");
				if (effectList != null) {
					for (int i = 0; i < effectList.length; i++) {
						list.add(StringUtils.GRAY + FluxedTrinketsAPI.getEffectFromName(effectList[i]).getEffectName());
						for (int j = 0; j < FluxedTrinketsAPI.getEffectFromName(effectList[i]).getDescription().size(); j++) {
							list.add(FluxedTrinketsAPI.getEffectFromName(effectList[i]).getDescription().get(j));
						}
					}
				}
			}
		} else {
			list.add(StringUtils.getShiftText());
		}

	}

	@Override
	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {
		if (par1ItemStack.stackTagCompound == null)
			par1ItemStack.stackTagCompound = new NBTTagCompound();
	}

	@Override
	public int receiveEnergy(ItemStack container, int maxReceive, boolean simulate) {
		if (container.stackTagCompound == null) {
			container.stackTagCompound = new NBTTagCompound();
		}
		int energy = container.stackTagCompound.getInteger("energy");
		int energyReceived = Math.min(maxCapacity - energy, Math.min(100, maxReceive));
		if (!simulate) {
			energy += energyReceived;
			container.stackTagCompound.setInteger("energy", energy);
		}
		return energyReceived;
	}

	private int getDamageFromEnergy(NBTTagCompound tag, int max) {
		return ((int) (Math.abs(((float) tag.getInteger("energy") / maxCapacity) - 1) * max) + 1);
	}

	@Override
	public int extractEnergy(ItemStack container, int maxExtract, boolean simulate) {
		if (container == null || container.getTagCompound() == null)
			return 0;

		int available = container.stackTagCompound.getInteger("energy");
		int removed;
		if (maxExtract < available) {
			if (!simulate)
				container.stackTagCompound.setInteger("energy", available - maxExtract);
			removed = maxExtract;
		} else {
			if (!simulate)
				container.stackTagCompound.setInteger("energy", 0);
			removed = available;
		}
		if (!simulate)
			container.setItemDamage(getDamageFromEnergy(container.stackTagCompound, container.getMaxDamage()));

		return removed;
	}

	@Override
	public int getEnergyStored(ItemStack container) {
		if (container == null || container.stackTagCompound == null || !container.stackTagCompound.hasKey("energy"))
			return 0;
		return container.stackTagCompound.getInteger("energy");
	}

	@Override
	public int getMaxEnergyStored(ItemStack container) {
		return maxCapacity;
	}

}
