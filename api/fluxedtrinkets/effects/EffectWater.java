package fluxedtrinkets.effects;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import fluxedtrinkets.api.IEffect;

public class EffectWater implements IEffect {

	@Override
	public String getEffectName() {
		return "water";
	}

	@Override
	public boolean onWornTick(World world, ItemStack stack, EntityLivingBase entity) {
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;

			if (!player.onGround && player.moveForward > 0F && !player.isInWater() && !player.isInsideOfMaterial(Material.web) && !player.isInsideOfMaterial(Material.lava)) {
				player.moveFlying(0F, 1F, player.capabilities.isFlying ? 0.02F : 0.02F * 2);
				return true;
			}
		}
		return false;
	}

	@Override
	public int getUsage() {
		return 10;
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

}
