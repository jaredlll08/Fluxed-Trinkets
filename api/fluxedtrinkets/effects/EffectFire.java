package fluxedtrinkets.effects;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import fluxedtrinkets.api.IEffect;
import fluxedtrinkets.util.EffectHelper;

public class EffectFire implements IEffect {

	@Override
	public String getEffectName() {
		return "fire";
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
	public int getUsage() {
		return 40;
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

}
