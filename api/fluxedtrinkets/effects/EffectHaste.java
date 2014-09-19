package fluxedtrinkets.effects;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import fluxedtrinkets.api.IEffect;

public class EffectHaste implements IEffect{

	@Override
	public String getEffectName() {
		return "haste";
	}

	@Override
	public boolean onWornTick(World world, ItemStack stack, EntityLivingBase entity) {
		if(entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer)entity;
			if ((player.onGround || player.capabilities.isFlying) && player.moveForward > 0F) {
				player.moveFlying(0F, 1F, player.capabilities.isFlying ? 0.050F : 0.07F);
				return true;
			}
		}
		return false;
	}

	@Override
	public int getUsage() {
		return 20;
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
