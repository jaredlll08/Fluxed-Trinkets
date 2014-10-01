package fluxedtrinkets.items;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import scala.actors.threadpool.Arrays;
import baubles.api.BaubleType;
import baubles.api.BaublesApi;
import fluxedtrinkets.api.FluxedTrinketsAPI;
import fluxedtrinkets.api.IEffect;
import fluxedtrinkets.api.ITrinket;
import fluxedtrinkets.api.StringUtils;
import fluxedtrinkets.util.NBTHelper;

public class ModularTrinketItem extends Item implements ITrinket {

	private int maxCapacity;
	private BaubleType type;

	public ModularTrinketItem(int maxCapacity, BaubleType type) {
		this.setMaxStackSize(1);
		this.maxCapacity = maxCapacity;
		this.type = type;
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return type;
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

	@SuppressWarnings("rawtypes")
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		int usage = 0;

		if (NBTHelper.getString(stack, "ETEffect") != "" && NBTHelper.getString(stack, "ETEffect") != null) {
			String effects = NBTHelper.getString(stack, "ETEffect");
			for (int i = 0; i < FluxedTrinketsAPI.getEffectAmount(); i++) {
				if (effects.contains(FluxedTrinketsAPI.getEffectNames().get(i))) {
					usage += FluxedTrinketsAPI.getEffects().get(i).getUsage();
				}
			}
			
			addInformation(stack, player, list, par4, effects, usage);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4, String effects, int usage) {
		super.addInformation(stack, player, list, par4);
		if (stack.stackTagCompound == null) {
			stack.stackTagCompound = new NBTTagCompound();
		}
		if (StringUtils.isShiftKeyDown()) {
			list.add(StringUtils.getChargeText(stack.stackTagCompound.getInteger("energy"), maxCapacity));
			list.add(StringUtils.getEnergyUsageText(usage));
			if (effects != null && !effects.equals("[]") && !effects.equals("")) {
				String[] effectList = effects.replace("[", "").replace("]", "").replace(" ", "").split(",");
				if (effectList != null) {
					for (int i = 0; i < effectList.length; i++) {
						IEffect effect = FluxedTrinketsAPI.getEffectFromName(effectList[i]);
						list.add(StringUtils.WHITE + StringUtils.localize("effect." + effect.getName() + ".name"));
						list.addAll(Arrays.asList(formatTooltip(StringUtils.localize("effect." + effect.getName() + ".desc"))));
					}
				}
			}
		} else {
			list.add(StringUtils.getShiftText());
		}
	}

	private static final String lineSplit = "\\|";

	private String[] formatTooltip(String tooltip) {
		return tooltip.split(lineSplit);
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

	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
		if (player instanceof EntityPlayer) {
			String effects = NBTHelper.getString(itemstack, "ETEffect");
			for (int i = 0; i < FluxedTrinketsAPI.getEffectNames().size(); i++) {
				if (effects.contains(FluxedTrinketsAPI.getEffectNames().get(i))) {
					extractEnergy(itemstack, FluxedTrinketsAPI.getEffects().get(i).onWornTick(itemstack, player, (ITrinket) itemstack.getItem()), false);
				}
			}
		}
	}

	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player) {
		String effects = NBTHelper.getString(itemstack, "ETEffect");
		for (int i = 0; i < FluxedTrinketsAPI.getEffectNames().size(); i++) {
			if (effects.contains(FluxedTrinketsAPI.getEffectNames().get(i))) {
				FluxedTrinketsAPI.getEffects().get(i).onEquipped(itemstack, player, (ITrinket) itemstack.getItem());
			}
		}
	}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
		String effects = NBTHelper.getString(itemstack, "ETEffect");
		for (int i = 0; i < FluxedTrinketsAPI.getEffectNames().size(); i++) {
			if (effects.contains(FluxedTrinketsAPI.getEffectNames().get(i))) {
				FluxedTrinketsAPI.getEffects().get(i).onUnequipped(itemstack, player, (ITrinket) itemstack.getItem());
			}

		}
	}

	@Override
	public boolean canEquip(ItemStack itemstack, EntityLivingBase player) {
		String effects = NBTHelper.getString(itemstack, "ETEffect");
		for (int i = 0; i < FluxedTrinketsAPI.getEffectNames().size(); i++) {
			if (effects.contains(FluxedTrinketsAPI.getEffectNames().get(i))) {
				return FluxedTrinketsAPI.getEffects().get(i).canEquip(itemstack, player, (ITrinket) itemstack.getItem());
			}
		}
		return true;
	}

	@Override
	public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
		String effects = NBTHelper.getString(itemstack, "ETEffect");
		for (int i = 0; i < FluxedTrinketsAPI.getEffectNames().size(); i++) {
			if (effects.contains(FluxedTrinketsAPI.getEffectNames().get(i))) {
				return FluxedTrinketsAPI.getEffects().get(i).canUnequip(itemstack, player, (ITrinket) itemstack.getItem());
			}
		}
		return true;
	}

}
