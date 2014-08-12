package com.jared.electrifiedtrinkets.api.recipes;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.jared.electrifiedtrinkets.tileEntity.TileEntitySolderingStation;

public class SolderingRecipe implements ISolder {

	private ItemStack input = null;
	private ItemStack[] addons = new ItemStack[5];
	private ItemStack material = null;
	private ItemStack output = null;

	public void registerRecipe() {

	}

	@Override
	public boolean matches(TileEntitySolderingStation tile, World world) {
		return false;
	}

	@Override
	public ItemStack getCraftingResult(TileEntitySolderingStation tile) {
		return null;
	}

	@Override
	public ItemStack getRecipeOutput() {
		return null;
	}

}
