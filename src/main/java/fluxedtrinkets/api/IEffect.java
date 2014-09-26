package fluxedtrinkets.api;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface IEffect {

	/**
	 * The name of the effect.
	 * 
	 * @return the effect name
	 */

	public String getEffectName();

	/**
	 * What happens on world tick.
	 * 
	 * Return false if it shouldnt use power.
	 * 
	 * @param world
	 * @param stack
	 * @param entity
	 * @return boolean if it was successful.
	 */
	public boolean onWornTick(World world, ItemStack stack, EntityLivingBase entity);

	/**
	 * How much RF does the effect use?
	 * 
	 * @return
	 */
	public int getUsage();

	/**
	 * Does something happen when you equip/unequip it?
	 * 
	 * @return
	 */
	public boolean hasEquipEffect();

	/**
	 * what happens when you equip it?
	 * 
	 * @param world
	 * @param stack
	 * @param entity
	 */
	public void onEquipped(World world, ItemStack stack, EntityLivingBase entity);

	/**
	 * What happens when you unequip it.
	 * 
	 * @param world
	 * @param stack
	 * @param entity
	 */
	public void onUnEquipped(World world, ItemStack stack, EntityLivingBase entity);

	public boolean canEquip(World world, ItemStack itemstack, EntityLivingBase player);

	public boolean canUnequip(World world, ItemStack itemstack, EntityLivingBase player);

	public ArrayList<String> getDescription();
}
