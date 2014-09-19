package fluxedtrinkets.api;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface IEffect {
	/**
	 * 
	 * @return the effect name
	 */

	public String getEffectName();

	public boolean onWornTick(World world, ItemStack stack, EntityLivingBase entity);

	public int getUsage();

	public boolean hasEquipEffect();

	public void onEquipped(World world, ItemStack stack, EntityLivingBase entity);

	public void onUnEquipped(World world, ItemStack stack, EntityLivingBase entity);
}
