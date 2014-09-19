package fluxedtrinkets.effects;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import fluxedtrinkets.api.IEffect;

public class EffectRespiratory implements IEffect{

	@Override
	public String getEffectName() {
		return "respiratory";
	}

	@Override
	public boolean onWornTick(World world, ItemStack stack, EntityLivingBase entity) {
		if(entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer)entity;
			if (player.isInWater()) {
				player.setAir(0);
				return true;
			}
		}
		
		return false;
	}

	@Override
	public int getUsage() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public boolean hasEquipEffect() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onEquipped(World world, ItemStack stack, EntityLivingBase entity) {
		
	}

	@Override
	public void onUnEquipped(World world, ItemStack stack, EntityLivingBase entity) {
		
	}

}
