package fluxedtrinkets.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import baubles.api.BaubleType;
import baubles.api.IBauble;
import cofh.api.energy.IEnergyContainerItem;
import fluxedtrinkets.api.StringUtils;
import fluxedtrinkets.util.NBTHelper;

public class ItemKineticEnergyBelt extends Item implements IBauble, IEnergyContainerItem {

	private int maxCapacity = 25000;

	public ItemKineticEnergyBelt() {
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setMaxStackSize(1);
		this.setMaxDamage(2501);
		this.setDamage(new ItemStack(this), 2500);
	}

	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {

		if (StringUtils.isShiftKeyDown()) {
			if (NBTHelper.getBoolean(stack, "Battery")) {

				list.add(StringUtils.getChargeText(NBTHelper.getInt(stack, "energy"), maxCapacity));
				list.add(StringUtils.getEnergyUsageText(10));
				list.add("Current Addons:");
			} else {
				list.add(StringUtils.ORANGE + "No battery installed!");
			}
			if (NBTHelper.getBoolean(stack, "Speed")) {
				list.add("-Speed");
			}

		} else {
			list.add(StringUtils.getShiftText());
		}

	}

	@Override
	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {
		if (par1ItemStack.stackTagCompound == null)
			NBTHelper.setBoolean(par1ItemStack, "hasNBT", true);
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.BELT;
	}

	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {

		NBTTagCompound nbt = itemstack.getTagCompound();
		if (NBTHelper.getInt(itemstack, "energy") > 0) {
			if (NBTHelper.getBoolean(itemstack, "Speed")) {
				if (player instanceof EntityPlayer) {
					EntityPlayer play = (EntityPlayer) player;
					if ((play.onGround || play.capabilities.isFlying) && play.moveForward > 0F)
						play.moveFlying(0F, 1F, play.capabilities.isFlying ? 0.050F : 0.07F);
					if (play.motionX != 0 || play.motionZ != 0)
						NBTHelper.setInteger(itemstack, "energy", NBTHelper.getInt(itemstack, "energy") - 10);
				}
			}
		}
		if (NBTHelper.getInt(itemstack, "energy") < -1) {
			NBTHelper.setInteger(itemstack, "energy", 0);
		}

		if (NBTHelper.getInt(itemstack, "energy") <= 0) {
			if (NBTHelper.getBoolean(itemstack, "Speed")) {
				if (player instanceof EntityPlayer) {
					EntityPlayer play = (EntityPlayer) player;
					if ((play.onGround || play.capabilities.isFlying) && play.moveForward > 0F)
						play.moveFlying(0F, 1F, play.capabilities.isFlying ? -0.01F : -0.03F);

				}
			}
		}

	}

	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player) {

	}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {

	}

	@Override
	public boolean canEquip(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}

	@Override
	public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}

	@Override
	public int receiveEnergy(ItemStack container, int maxReceive, boolean simulate) {
		if (container.stackTagCompound == null) {
			container.stackTagCompound = new NBTTagCompound();
		}
		int energy = container.stackTagCompound.getInteger("energy");
		int energyReceived = Math.min(maxCapacity - energy, Math.min(250, maxReceive));
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
