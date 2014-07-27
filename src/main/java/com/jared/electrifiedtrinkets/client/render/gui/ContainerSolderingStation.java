package com.jared.electrifiedtrinkets.client.render.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerBeacon;
import net.minecraft.inventory.ContainerEnchantment;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.jared.electrifiedtrinkets.tileEntity.TileEntitySolderingStation;

public class ContainerSolderingStation extends Container {

	public ContainerSolderingStation(InventoryPlayer invPlayer, TileEntitySolderingStation solderingStation) {

		for (int x = 0; x < 9; x++) {
			addSlotToContainer(new Slot(invPlayer, x, 36 + 18 * x, 195));

		}

		// for (int y = 0; y < 3; y++) {
		// for (int x = 0; x < 9; x++) {
		// addSlotToContainer(new Slot(invPlayer, x + y * 9 + 9, 36 + 18 * x,
		// 137 + y * 20));
		// }
		// }
		//
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 9; x++) {
				addSlotToContainer(new Slot(invPlayer, x + y * 9 + 9, 36 + 18 * x, 137 + y * 18));
			}
		}

		addSlotToContainer(new SlotCircuit(solderingStation, 1, 108, 110));
	}

	@Override
	public boolean canInteractWith(EntityPlayer arg0) {
		return true;
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int par2) {
		return null;
	}

}
