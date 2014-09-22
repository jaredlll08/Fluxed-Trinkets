package fluxedtrinkets.effects;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionHealth;
import net.minecraft.potion.PotionHealthBoost;
import net.minecraft.world.World;
import fluxedtrinkets.api.IEffect;

public class EffectFall implements IEffect {

	@Override
	public String getEffectName() {
		return "fall";
	}

	@Override
	public boolean onWornTick(World world, ItemStack stack, EntityLivingBase entity) {
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;

			if (!player.onGround && player.motionY < 0) {
				if (!player.isSneaking()) {
					player.motionY = -0.1;
					player.fallDistance = -1;
					return true;
				}

			}
		}

		return false;
	}

	@Override
	public int getUsage() {
		return 5;
	}

	@Override
	public boolean hasEquipEffect() {
		return false;
	}

	@Override
	public void onEquipped(World world, ItemStack stack, EntityLivingBase entity) {

	}

	@Override
	public void onUnEquipped(World world, ItemStack stack, EntityLivingBase entity) {

	}

	@Override
	public boolean canEquip(World world, ItemStack itemstack, EntityLivingBase player) {
		return true;
	}

	@Override
	public boolean canUnequip(World world, ItemStack itemstack, EntityLivingBase player) {
		return true;
	}

}
