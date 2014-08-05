package com.jared.electrifiedtrinkets.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

import com.jared.electrifiedtrinkets.items.ETItems;
import com.jared.electrifiedtrinkets.tileEntity.TileEntitySolderingStation;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageSpeedCircuitCrafting implements IMessage, IMessageHandler<MessageSpeedCircuitCrafting, IMessage> {
	public MessageSpeedCircuitCrafting() {
	}

	private int x, y, z;

	public MessageSpeedCircuitCrafting(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.x = buf.readInt();
		this.y = buf.readInt();
		this.z = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(x);
		buf.writeInt(y);
		buf.writeInt(z);
	}

	@Override
	public IMessage onMessage(MessageSpeedCircuitCrafting message, MessageContext ctx) {
		
		TileEntity te = ctx.getServerHandler().playerEntity.worldObj.getTileEntity(message.x, message.y, message.z);
		if (te instanceof TileEntitySolderingStation) {
		    ((TileEntitySolderingStation) te).craftSpeedCircuit();
		}
		return null;
	}
}