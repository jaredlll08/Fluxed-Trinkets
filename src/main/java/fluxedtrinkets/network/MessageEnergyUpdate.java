package fluxedtrinkets.network;

import fluxedtrinkets.tileEntity.TileEntityKineticGenerator;
import fluxedtrinkets.tileEntity.TileEntitySolderingStation;
import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageEnergyUpdate implements IMessage, IMessageHandler<MessageEnergyUpdate, IMessage> {
	public MessageEnergyUpdate() {
	}

	private int x, y, z, energy;

	public MessageEnergyUpdate(int x, int y, int z, int energy) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.energy = energy;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.x = buf.readInt();
		this.y = buf.readInt();
		this.z = buf.readInt();
		this.energy = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(x);
		buf.writeInt(y);
		buf.writeInt(z);
		buf.writeInt(energy);
	}

	@Override
	public IMessage onMessage(MessageEnergyUpdate message, MessageContext ctx) {

		TileEntity te = ctx.getServerHandler().playerEntity.worldObj.getTileEntity(message.x, message.y, message.z);
		if (te instanceof TileEntityKineticGenerator) {
			((TileEntityKineticGenerator) te).generateEnergy(energy);
		}
		return null;
	}
}