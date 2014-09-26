package fluxedtrinkets.effects;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import fluxedtrinkets.api.IEffect;
import fluxedtrinkets.config.ConfigProps;
import fluxedtrinkets.util.EffectHelper;

public class EffectFire implements IEffect {

	@Override
	public String getEffectName() {
		return "fire";
	}

	@Override
	public int getUsage() {
		return ConfigProps.energyFire;
	}

	@Override
	public boolean hasEquipEffect() {
		return true;
	}

	@Override
	public void onEquipped(World world, ItemStack stack, EntityLivingBase entity) {

	}

	@Override
	public void onUnEquipped(World world, ItemStack stack, EntityLivingBase entity) {
		EffectHelper.setFireImmune(entity, false);
	}

	@Override
	public boolean onWornTick(World world, ItemStack stack, EntityLivingBase entity) {
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			if (player.isBurning()) {
				player.extinguish();
				EffectHelper.setFireImmune(player, true);
				if (player.worldObj.rand.nextInt(100) == 0) {
					EffectHelper.setFireImmune(player, true);
					return true;
				}
			}
			return false;
		}
		return false;
	}

	@Override
	public boolean canEquip(World world, ItemStack itemstack, EntityLivingBase player) {
		return true;
	}

	@Override
	public boolean canUnequip(World world, ItemStack itemstack, EntityLivingBase player) {
		return true;
	}

	@Override
	public ArrayList<String> getDescription() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Makes the player");
		list.add("immune to heat.");
		return list;
	}
}
