package fluxedtrinkets.items;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;

public class ItemJetpack extends ItemArmor implements ISpecialArmor {

	public ItemJetpack() {
		super(ArmorMaterial.DIAMOND, 0, 1);
	}

	public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
	}

	@Override
	public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot) {
		return null;
	}

	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
		return 0;
	}

	@Override
	public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot) {
	}

}
