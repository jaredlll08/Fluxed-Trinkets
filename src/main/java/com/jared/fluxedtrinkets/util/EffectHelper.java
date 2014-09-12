package com.jared.fluxedtrinkets.util;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.ReflectionHelper;

public class EffectHelper {
	public static final String[] IS_IMMUNE_TO_FIRE = new String[] { "isImmuneToFire", "field_70178_ae", "ag" };
	
	public static void setFireImmune(Entity entity, boolean isImmune){
		ReflectionHelper.setPrivateValue(Entity.class, entity, isImmune, IS_IMMUNE_TO_FIRE);
	}

	
	public static boolean applyBonemeal(ItemStack p_150919_0_, World p_150919_1_, int p_150919_2_, int p_150919_3_, int p_150919_4_, EntityPlayer player) {
		Block block = p_150919_1_.getBlock(p_150919_2_, p_150919_3_, p_150919_4_);

		if (block instanceof IGrowable) {
			IGrowable igrowable = (IGrowable) block;

			if (igrowable.func_149851_a(p_150919_1_, p_150919_2_, p_150919_3_, p_150919_4_, p_150919_1_.isRemote)) {
				if (!p_150919_1_.isRemote) {
					if (igrowable.func_149852_a(p_150919_1_, p_150919_1_.rand, p_150919_2_, p_150919_3_, p_150919_4_)) {

						if (StringUtils.isShiftKeyDown()) {
							igrowable.func_149853_b(p_150919_1_, p_150919_1_.rand, p_150919_2_, p_150919_3_, p_150919_4_);
							igrowable.func_149853_b(p_150919_1_, p_150919_1_.rand, p_150919_2_ - 1, p_150919_3_, p_150919_4_);

							igrowable.func_149853_b(p_150919_1_, p_150919_1_.rand, p_150919_2_ + 1, p_150919_3_, p_150919_4_);

							igrowable.func_149853_b(p_150919_1_, p_150919_1_.rand, p_150919_2_, p_150919_3_, p_150919_4_ - 1);

							igrowable.func_149853_b(p_150919_1_, p_150919_1_.rand, p_150919_2_, p_150919_3_, p_150919_4_ + 1);

						} else {
							igrowable.func_149853_b(p_150919_1_, p_150919_1_.rand, p_150919_2_, p_150919_3_, p_150919_4_);
							igrowable.func_149853_b(p_150919_1_, p_150919_1_.rand, p_150919_2_, p_150919_3_, p_150919_4_);
							igrowable.func_149853_b(p_150919_1_, p_150919_1_.rand, p_150919_2_, p_150919_3_, p_150919_4_);
							igrowable.func_149853_b(p_150919_1_, p_150919_1_.rand, p_150919_2_, p_150919_3_, p_150919_4_);
							igrowable.func_149853_b(p_150919_1_, p_150919_1_.rand, p_150919_2_, p_150919_3_, p_150919_4_);
						}
					}

					// --p_150919_0_.stackSize;
				}

				return true;
			}
		}

		return false;
	}
}
