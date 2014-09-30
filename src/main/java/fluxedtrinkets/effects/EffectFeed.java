package fluxedtrinkets.effects;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import fluxedtrinkets.api.ITrinket;

public class EffectFeed extends BaseEffect {

	public EffectFeed() {
		super("feed");
	}

	@Override
	public int onWornTick(ItemStack stack, EntityLivingBase entity, ITrinket item) {
		if (!entity.worldObj.isRemote && entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			for (int i = 0; i < player.inventory.getSizeInventory(); i++) {
				ItemStack foodStack = player.inventory.getStackInSlot(i);
				if (player.getFoodStats().getFoodLevel() < 20 && foodStack != null && foodStack.getItem() instanceof ItemFood) {
					ItemFood food = (ItemFood) foodStack.getItem();

					if (player.getFoodStats().getFoodLevel() + food.func_150905_g(player.inventory.getStackInSlot(i)) <= 20) {
						food.onEaten(new ItemStack(food), entity.worldObj, player);
						player.inventory.getStackInSlot(i).stackSize--;
						if (player.inventory.getStackInSlot(i).stackSize == 0) {
							player.inventory.setInventorySlotContents(i, null);
						}
					}
				}
			}
		}
		return 0;
	}

//	@Override
//	public ArrayList<String> getDescription() {
//		ArrayList<String> list = new ArrayList<String>();
//		list.add("If the wearer is");
//		list.add("low on hunger");
//		list.add("food from the inventory");
//		list.add("is automaticaly consumed.");
//		return list;
//	}
}
