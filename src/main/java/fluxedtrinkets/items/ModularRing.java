package fluxedtrinkets.items;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import baubles.api.BaubleType;
import baubles.api.IBauble;
import fluxedtrinkets.api.FluxedTrinketsAPI;
import fluxedtrinkets.util.EffectHelper;
import fluxedtrinkets.util.NBTHelper;

public class ModularRing extends ModularItem implements IBauble {

	private ItemStack stack;

	public ModularRing() {
		super(10000);
		this.setMaxStackSize(1);
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.RING;
	}

	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		int usage = 0;

		if (NBTHelper.getString(stack, "ETEffect") != "" && NBTHelper.getString(stack, "ETEffect") != null) {
			String effects = NBTHelper.getString(stack, "ETEffect");

			for (int i = 0; i < FluxedTrinketsAPI.getEffectNames().size(); i++) {
				if (effects.contains(FluxedTrinketsAPI.getEffectNames().get(i))) {
					usage += FluxedTrinketsAPI.getEffects().get(i).getUsage();
				}
			}
			this.setUsage(usage);

			super.addInformation(stack, player, list, par4, effects);

		}

	}

	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
		stack = itemstack;
		int energy = NBTHelper.getInt(itemstack, "energy");
		if (player instanceof EntityPlayer) {
			EntityPlayer play = (EntityPlayer) player;
			double x = play.posX;
			double y = play.posY;
			double z = play.posZ;

			String effects = NBTHelper.getString(itemstack, "ETEffect");
			if (energy > 0) {

				for (int i = 0; i < FluxedTrinketsAPI.getEffectNames().size(); i++) {
					if (effects.contains(FluxedTrinketsAPI.getEffectNames().get(i))) {
						if (FluxedTrinketsAPI.getEffects().get(i).onWornTick(player.worldObj, itemstack, player)) {
							energy -= FluxedTrinketsAPI.getEffects().get(i).getUsage();
						}

					}
				}

			}
			if (energy < -1) {
				energy = 0;
				for (int i = 0; i < FluxedTrinketsAPI.getEffectNames().size(); i++) {
					if (effects.contains(FluxedTrinketsAPI.getEffectNames().get(i))) {
						if (FluxedTrinketsAPI.getEffects().get(i).hasEquipEffect()) {
							FluxedTrinketsAPI.getEffects().get(i).onUnEquipped(player.worldObj, itemstack, player);
						}

					}
				}
			}
			NBTHelper.setInteger(itemstack, "energy", energy);
		}
	}

	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player) {
		String effects = NBTHelper.getString(itemstack, "ETEffect");
		for (int i = 0; i < FluxedTrinketsAPI.getEffectNames().size(); i++) {
			if (effects.contains(FluxedTrinketsAPI.getEffectNames().get(i))) {
				if (FluxedTrinketsAPI.getEffects().get(i).hasEquipEffect()) {
					FluxedTrinketsAPI.getEffects().get(i).onEquipped(player.worldObj, itemstack, player);
				}

			}
		}
	}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
		String effects = NBTHelper.getString(itemstack, "ETEffect");
		for (int i = 0; i < FluxedTrinketsAPI.getEffectNames().size(); i++) {
			if (effects.contains(FluxedTrinketsAPI.getEffectNames().get(i))) {
				if (FluxedTrinketsAPI.getEffects().get(i).hasEquipEffect()) {
					FluxedTrinketsAPI.getEffects().get(i).onUnEquipped(player.worldObj, itemstack, player);
				}

			}
		}

	}

	@Override
	public boolean canEquip(ItemStack itemstack, EntityLivingBase player) {
		String effects = NBTHelper.getString(itemstack, "ETEffect");
		for (int i = 0; i < FluxedTrinketsAPI.getEffectNames().size(); i++) {
			if (effects.contains(FluxedTrinketsAPI.getEffectNames().get(i))) {
			return	FluxedTrinketsAPI.getEffects().get(i).canEquip(player.worldObj, itemstack, player);
			}
		}
		return true;
	}

	@Override
	public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
		String effects = NBTHelper.getString(itemstack, "ETEffect");
		for (int i = 0; i < FluxedTrinketsAPI.getEffectNames().size(); i++) {
			if (effects.contains(FluxedTrinketsAPI.getEffectNames().get(i))) {
				return FluxedTrinketsAPI.getEffects().get(i).canUnequip(player.worldObj, itemstack, player);
			}
		}
		return true;
	}


}
