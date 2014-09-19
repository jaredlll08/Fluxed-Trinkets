package fluxedtrinkets.effects;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import fluxedtrinkets.api.IEffect;

public class EffectStep implements IEffect{

	@Override
	public String getEffectName() {
		return "step";
	}

	@Override
	public int getUsage() {
		return 0;
	}

	@Override
	public boolean hasEquipEffect() {
		return true;
	}

	@Override
	public void onEquipped(World world, ItemStack stack, EntityLivingBase entity) {
		if(entity instanceof EntityPlayer){
			((EntityPlayer)entity).stepHeight=1.0F;
		}
	}

	@Override
	public void onUnEquipped(World world, ItemStack stack, EntityLivingBase entity) {
		if(entity instanceof EntityPlayer){
			((EntityPlayer)entity).stepHeight=0.50001F;
		}
	}

	@Override
	public boolean onWornTick(World world, ItemStack stack, EntityLivingBase entity) {
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
}
