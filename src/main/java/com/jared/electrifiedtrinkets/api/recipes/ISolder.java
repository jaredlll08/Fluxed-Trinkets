package com.jared.electrifiedtrinkets.api.recipes;

import com.jared.electrifiedtrinkets.tileEntity.TileEntitySolderingStation;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface ISolder
{
    /**
     * Used to check if a recipe matches current crafting inventory
     */
    boolean matches(TileEntitySolderingStation tile, World world);

    /**
     * Returns an Item that is the result of this recipe
     */
    ItemStack getCraftingResult(TileEntitySolderingStation tile);


    ItemStack getRecipeOutput();
}