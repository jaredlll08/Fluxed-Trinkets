package com.jared.electrifiedtrinkets.client.render.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerBeacon;
import net.minecraft.inventory.ContainerEnchantment;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.jared.electrifiedtrinkets.client.render.gui.slot.SlotAddon;
import com.jared.electrifiedtrinkets.client.render.gui.slot.SlotCircuit;
import com.jared.electrifiedtrinkets.client.render.gui.slot.SlotCircuitContainer;
import com.jared.electrifiedtrinkets.client.render.gui.slot.SlotCopperNugget;
import com.jared.electrifiedtrinkets.client.render.gui.slot.SlotLeadWire;
import com.jared.electrifiedtrinkets.client.render.gui.slot.SlotSolderingIron;
import com.jared.electrifiedtrinkets.client.render.gui.slot.SlotTrinket;
import com.jared.electrifiedtrinkets.items.ETItems;
import com.jared.electrifiedtrinkets.tileEntity.TileEntitySolderingStation;
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

		
		addSlotToContainer(new SlotTrinket(tile, 0, 107, 14));
		addSlotToContainer(new SlotCircuitContainer(tile, 1, 14, 110));
		addSlotToContainer(new SlotCircuitContainer(tile, 2, 32, 110));
		addSlotToContainer(new SlotCircuitContainer(tile, 3, 50, 110));
		addSlotToContainer(new SlotCircuitContainer(tile, 4, 68, 110));
		addSlotToContainer(new SlotCircuitContainer(tile, 5, 86, 110));
		addSlotToContainer(new SlotCircuitContainer(tile, 6, 128, 110));
		addSlotToContainer(new SlotCircuitContainer(tile, 7, 146, 110));
		addSlotToContainer(new SlotCircuitContainer(tile, 8, 164, 110));
		addSlotToContainer(new SlotCircuitContainer(tile, 9, 182, 110));
		addSlotToContainer(new SlotCircuitContainer(tile, 10, 200, 110));
		
		
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
