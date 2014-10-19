package fluxedtrinkets.effects;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import fluxedtrinkets.api.BaseEffect;
import fluxedtrinkets.api.ITrinket;
import fluxedtrinkets.config.EffectProps;

public class EffectFeed extends BaseEffect {

	public EffectFeed() {
		super("feed", EffectProps.energyFeed);
	}

	@Override
	public int onWornTick(ItemStack stack, EntityLivingBase entity, ITrinket item) {
		if (!entity.worldObj.isRemote && entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			for (int i = 0; i < player.inventory.getSizeInventory(); i++) {
				ItemStack foodStack = player.inventory.getStackInSlot(i);
				if (player.getFoodStats().getFoodLevel() < 20 && foodStack != null && foodStack.getItem() instanceof ItemFood) {
					ItemFood food = (ItemFood) foodStack.getItem();

					if (hasEnergy(item, foodStack, getUsage()) && player.getFoodStats().getFoodLevel() + food.func_150905_g(player.inventory.getStackInSlot(i)) <= 20) {
						food.onEaten(new ItemStack(food), entity.worldObj, player);
						player.inventory.getStackInSlot(i).stackSize--;
						if (player.inventory.getStackInSlot(i).stackSize == 0) {
							player.inventory.setInventorySlotContents(i, null);
						}
						return getUsage();
					}
				}
			}
		}
		return 0;
	}
	@Override
	public void onPowerEmpty(ItemStack stack, EntityLivingBase entity, ITrinket item) {
		entity.addPotionEffect(new PotionEffect(Potion.hunger.id, 5, 5, false));
	}

}
