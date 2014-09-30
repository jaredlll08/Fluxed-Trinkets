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
import fluxedtrinkets.config.ConfigProps;

public class EffectFall extends BaseEffect {

	@Override
	public String getName() {
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
		return ConfigProps.energyFall;
	}

	@Override
	public boolean hasEquipEffect() {
		return false;
	}

	@Override
	public void onEquipped(World world, ItemStack stack, EntityLivingBase entity) {

	}

	@Override
	public void onRemoved(World world, ItemStack stack, EntityLivingBase entity) {

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
		list.add("while the player is not");
		list.add("holding shift, the player");
		list.add("will fall slower than normal.");
		return list;
	}
}
