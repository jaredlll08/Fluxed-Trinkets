package fluxedtrinkets.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;

public class ItemJadedLungs extends ItemArmor implements ISpecialArmor {

	public ItemJadedLungs() {
		super(ArmorMaterial.CHAIN, 1, 1);
	}

	public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5) {
		if(entity instanceof EntityPlayer){
			
		if(!"jadedcat".equals(((EntityPlayer)entity).getCommandSenderName())){
			((EntityPlayer)entity).inventory.setInventorySlotContents(par4, null);
			
		}
		}
	}

	public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
		if (player.getAir() == 0) {
			player.setAir(300);
		}
	}

	@Override
	public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot) {
		return new ArmorProperties(0, 0, 0);
	}

	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
		return 0;
	}

	@Override
	public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot) {

	}

}
