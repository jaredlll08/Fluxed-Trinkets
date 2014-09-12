package com.jared.fluxedtrinkets.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;

import com.jared.fluxedtrinkets.tileEntity.TileEntityTrinketAssembler;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageTrinketAssembler implements IMessage, IMessageHandler<MessageTrinketAssembler, IMessage> {
	public MessageTrinketAssembler() {
	}

	private int x, y, z;

	public MessageTrinketAssembler(int x, int y, int z) {
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
	public IMessage onMessage(MessageTrinketAssembler message, MessageContext ctx) {

		TileEntity te = ctx.getServerHandler().playerEntity.worldObj.getTileEntity(message.x, message.y, message.z);
		if (te instanceof TileEntityTrinketAssembler) {
			((TileEntityTrinketAssembler) te).craftTrinket();
		}
		return null;
	}
}