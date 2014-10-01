package fluxedtrinkets.api;

import java.util.ArrayList;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public interface IEffect {

	/**
	 * The name of the effect.
	 * 
	 * @return the effect name
	 */
	public String getName();
	
	/**
	 * @return The amount this effect uses per tick. Does not affect any actual calculations, only used in tooltips.
	 */
	public int getUsage();

	/**
	 * Called once for every instance of the effect on the player, once per
	 * tick.
	 * 
	 * @param stack
	 *            ItemStack with this effect
	 * @param entity
	 *            EntityLivingBase wearing this item
	 * @param item
	 *            {@link ITrinket} with this effect applied
	 */
	public int onWornTick(ItemStack stack, EntityLivingBase entity, ITrinket item);

	/**
	 * Called when an item with the effect is equipped into a bauble slot
	 * 
	 * @param stack
	 *            ItemStack with this effect
	 * @param entity
	 *            EntityLivingBase wearing this item
	 * @param item
	 *            {@link ITrinket} with this effect applied
	 */
	public void onEquipped(ItemStack stack, EntityLivingBase entity, ITrinket item);

	/**
	 * Called when an item with the effect is removed from a bauble slot
	 * 
	 * @param stack
	 *            ItemStack with this effect
	 * @param entity
	 *            EntityLivingBase wearing this item
	 * @param item
	 *            {@link ITrinket} with this effect applied
	 */
	public void onUnequipped(ItemStack stack, EntityLivingBase entity, ITrinket item);

	public boolean canEquip(ItemStack stack, EntityLivingBase entity, ITrinket item);

	public boolean canUnequip(ItemStack stack, EntityLivingBase entity, ITrinket item);
}
