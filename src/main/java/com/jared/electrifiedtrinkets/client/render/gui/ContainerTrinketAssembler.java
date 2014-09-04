package com.jared.electrifiedtrinkets.client.render.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.jared.electrifiedtrinkets.client.render.gui.slot.SlotCircuit;
import com.jared.electrifiedtrinkets.client.render.gui.slot.SlotTrinket;
import com.jared.electrifiedtrinkets.tileEntity.TileEntityTrinketAssembler;

public class ContainerTrinketAssembler extends Container {

	public ContainerTrinketAssembler(InventoryPlayer invPlayer, TileEntityTrinketAssembler tile) {
		for (int x = 0; x < 9; x++) {
			addSlotToContainer(new Slot(invPlayer, x, 36 + 18 * x, 195));
		}
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 9; x++) {
				addSlotToContainer(new Slot(invPlayer, x + y * 9 + 9, 36 + 18 * x, 137 + y * 18));
			}
		}
		addSlotToContainer(new SlotTrinket(tile, 0, 109, 48));
		addSlotToContainer(new SlotCircuit(tile, 1, 18, 13));
		addSlotToContainer(new SlotCircuit(tile, 2, 196, 13));
		addSlotToContainer(new SlotCircuit(tile, 3, 196, 79));
		addSlotToContainer(new SlotCircuit(tile, 4, 18, 79));
		
		
	}

	@Override
	public boolean canInteractWith(EntityPlayer arg0) {
		return true;

	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
		return null;
	}

}