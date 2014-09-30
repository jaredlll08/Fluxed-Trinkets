package fluxedtrinkets.effects;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import fluxedtrinkets.api.IEffect;
import fluxedtrinkets.config.ConfigProps;

public class EffectFeed extends BaseEffect {

	@Override
	public String getName() {
		return "feed";
	}

	@Override
	public boolean onWornTick(World world, ItemStack stack, EntityLivingBase entity) {
		if (!world.isRemote) {
			if (entity instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer) entity;
				for (int i = 0; i < player.inventory.getSizeInventory(); i++) {
					if (player.getFoodStats().getFoodLevel() != 20 && player.inventory.getStackInSlot(i) != null && player.inventory.getStackInSlot(i).getItem() instanceof ItemFood) {
						ItemFood food = (ItemFood) player.inventory.getStackInSlot(i).getItem();

						if (player.getFoodStats().getFoodLevel() + food.func_150905_g(player.inventory.getStackInSlot(i)) <= 20) {
							food.onEaten(new ItemStack(food), world, player);
							player.inventory.getStackInSlot(i).stackSize--;
							if (player.inventory.getStackInSlot(i).stackSize == 0) {
								player.inventory.setInventorySlotContents(i, null);
							}
						}

					}
				}
			}
		}
		return false;
	}

	@Override
	public int getUsage() {
		return ConfigProps.energyFeed;
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
		list.add("If the wearer is");
		list.add("low on hunger");
		list.add("food from the inventory");
		list.add("is automaticaly consumed.");
		return list;
	}
}
