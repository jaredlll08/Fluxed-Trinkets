package com.jared.electrifiedtrinkets.items.equipment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import baubles.api.BaubleType;

public class ItemBeltIce extends ModBelt {

	public ItemBeltIce(int maxCapacity, int usage) {
		super(maxCapacity);
	}

	public static Map<String, List<IceRemover>> playerIceBlocks = new HashMap();

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.BELT;
	}

	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
		if (itemstack.stackTagCompound == null) {
			itemstack.stackTagCompound = new NBTTagCompound();
		}

		if (itemstack.stackTagCompound.getInteger("energy") < -1) {
			itemstack.stackTagCompound.setInteger("energy", 0);
		}

		if (itemstack.stackTagCompound.getInteger("energy") <= 0) {

			if (player instanceof EntityPlayer) {
				EntityPlayer play = (EntityPlayer) player;
				if ((play.onGround || play.capabilities.isFlying) && play.moveForward > 0F)
					play.moveFlying(0F, 1F, play.capabilities.isFlying ? -0.03F : -0.05F);
			}
		}
		if (player instanceof EntityPlayer) {
			EntityPlayer play = (EntityPlayer) player;

			if (!player.worldObj.isRemote)
				tickIceRemovers(play, itemstack);

			if (!player.isSneaking() && !player.isInsideOfMaterial(Material.water) && !player.worldObj.isRemote && itemstack.stackTagCompound.getInteger("energy") > 0) {
				int x = MathHelper.floor_double(player.posX);
				int y = MathHelper.floor_double(player.posY - (player.isInWater() ? 0 : 1));
				int z = MathHelper.floor_double(player.posZ);

				int range = 2;
				for (int i = -range; i < range + 1; i++)
					for (int j = -range; j < range + 1; j++) {
						int x1 = x + i;
						int z1 = z + j;
						addIceBlock(play, new ChunkCoordinates(x1, y, z1), itemstack);
					}
			}
		}
	}

	private void addIceBlock(EntityPlayer player, ChunkCoordinates coords, ItemStack itemstack) {
		String user = player.getCommandSenderName();
		if (!playerIceBlocks.containsKey(user)) {
			playerIceBlocks.put(user, new ArrayList());
			
		}
		List<IceRemover> ice = playerIceBlocks.get(user);
		if (player.worldObj.getBlock(coords.posX, coords.posY, coords.posZ) == Blocks.water && player.worldObj.getBlockMetadata(coords.posX, coords.posY, coords.posZ) == 0) {
			player.worldObj.setBlock(coords.posX, coords.posY, coords.posZ, Blocks.ice);
			itemstack.stackTagCompound.setInteger("energy", itemstack.stackTagCompound.getInteger("energy") - 5);
			if (!player.worldObj.isRemote)
				ice.add(new IceRemover(coords));
		}
	}

	private void tickIceRemovers(EntityPlayer player, ItemStack itemstack) {
		String user = player.getCommandSenderName();
		if (!playerIceBlocks.containsKey(user))
			return;

		List<IceRemover> removers = playerIceBlocks.get(user);
		for (IceRemover ice : new ArrayList<IceRemover>(removers))
			ice.tick(player.worldObj, removers, itemstack);
	}

	class IceRemover {

		int time = 30;
		final ChunkCoordinates coords;

		public IceRemover(ChunkCoordinates coords) {
			this.coords = coords;
		}

		public void tick(World world, List<IceRemover> list, ItemStack itemstack) {
			if (world.getBlock(coords.posX, coords.posY, coords.posZ) == Blocks.ice) {
				if (time-- == 0) {
					world.setBlock(coords.posX, coords.posY, coords.posZ, Blocks.water, 0, 1 | 2);

				} else
					return;
				list.remove(this);
			}
		}
	}

	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player) {

	}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {

	}

	@Override
	public boolean canEquip(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}

	@Override
	public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}
}