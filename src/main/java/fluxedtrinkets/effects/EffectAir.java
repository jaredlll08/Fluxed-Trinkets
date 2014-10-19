package fluxedtrinkets.effects;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import fluxedtrinkets.api.BaseEffect;
import fluxedtrinkets.api.ITrinket;
import fluxedtrinkets.config.EffectProps;

public class EffectAir extends BaseEffect {

	public EffectAir() {
		super("air", EffectProps.energyAir);
	}

	@Override
	public int onWornTick(ItemStack stack, EntityLivingBase entity, ITrinket item) {
		if (entity instanceof EntityPlayer && !entity.worldObj.isRemote) {
			EntityPlayer player = (EntityPlayer) entity;
			if (hasEnergy(item, stack, getUsage()) && isPlayerInAir(player)) {
				player.moveFlying(0F, 1F, player.capabilities.isFlying ? 0.02F : 0.02F * 2);
				return getUsage();
			}
		}
		return 0;
	}

	private boolean isPlayerInAir(EntityPlayer player) {
		return !player.onGround && player.moveForward > 0F && !player.isInWater() && !player.isInsideOfMaterial(Material.web) && !player.isInsideOfMaterial(Material.lava);
	}

	@Override
	public void onPowerEmpty(ItemStack stack, EntityLivingBase entity, ITrinket item) {
		entity.setJumping(false);
	}

}
