package com.jared.electrifiedtrinkets.client.render.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

import com.jared.electrifiedtrinkets.tileEntity.TileEntitySolderingStation;

public class ContainerSolderingStation extends Container {

	public ContainerSolderingStation(InventoryPlayer invPlayer, TileEntitySolderingStation solderingStation) {
		for(int x = 0; x < 9; x++){
			addSlotToContainer(new Slot(invPlayer, x, 8+18 * x, 130));
			
		}
		
		for(int x = 0; x < 3; x++){
			addSlotToContainer(new Slot(solderingStation, x, 8+18*x, 17));
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer arg0) {
		return true;
	}

}
