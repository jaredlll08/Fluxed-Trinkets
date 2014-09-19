package fluxedtrinkets.items.equipment;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import baubles.api.BaubleType;
import baubles.api.BaublesApi;
import baubles.api.IBauble;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import fluxedtrinkets.util.EffectHelper;
import fluxedtrinkets.util.NBTHelper;

public class ItemBeltEmpty extends ModBelt implements IBauble {

	private ItemStack stack;

	public ItemBeltEmpty() {
		super(25000);
		this.setMaxStackSize(1);
		MinecraftForge.EVENT_BUS.register(this);
		}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.BELT;
	}

	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		int usage = 0;

		if (NBTHelper.getString(stack, "ETEffect") != "" && NBTHelper.getString(stack, "ETEffect") != null) {
			String effects = NBTHelper.getString(stack, "ETEffect");

			if (effects.contains("air"))
				usage += 10;
			if (effects.contains("water"))
				usage += 10;
			if (effects.contains("earth"))
				usage += 25;
			if (effects.contains("fire"))
				usage += 40;

			if (effects.contains("advancedIce"))
				usage += 30;
			if (effects.contains("advancedLava"))
				usage += 30;
			if (effects.contains("advancedLife"))
				usage += 30;
			if (effects.contains("advancedLightning"))
				usage += 30;

			if (effects.contains("haste"))
				usage += 20;
			if (effects.contains("step"))
				usage += 10;
			if (effects.contains("jump"))
				usage += 15;
			if (effects.contains("respiratory"))
				usage += 10;

			this.setUsage(usage);

			super.addInformation(stack, player, list, par4, effects);

		}

	}

	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
		stack = itemstack;
		int energy = NBTHelper.getInt(itemstack, "energy");
		if (player instanceof EntityPlayer) {
			EntityPlayer play = (EntityPlayer) player;
			double x = play.posX;
			double y = play.posY;
			double z = play.posZ;

			String effects = NBTHelper.getString(itemstack, "ETEffect");
			if (energy > 0) {

				if (effects.contains("haste")) {
					if ((play.onGround || play.capabilities.isFlying) && play.moveForward > 0F) {
						play.moveFlying(0F, 1F, play.capabilities.isFlying ? 0.050F : 0.07F);
						energy -= 20;
					}
				}
				if (effects.contains("respiratory")) {
					if(play.isInWater()){
						play.setAir(0);
						energy -=5;
					}
				}
				if (effects.contains("step")) {
						if(play.moveForward > 0F){
							energy -=5;
							play.stepHeight=1F;
						}
						
						
				}

				if (effects.contains("air")) {
					if (!play.onGround && play.moveForward > 0F && !play.isInWater() && !play.isInsideOfMaterial(Material.web) && !play.isInsideOfMaterial(Material.lava))
						play.moveFlying(0F, 1F, play.capabilities.isFlying ? 0.02F : 0.02F * 2);
					energy -= 10;
				}
				if (effects.contains("fire")) {
					if (play.isBurning()) {
						play.extinguish();
						EffectHelper.setFireImmune(play, true);
						if (play.worldObj.rand.nextInt(100) == 0) {
							EffectHelper.setFireImmune(play, true);

						}
						energy -= 40;
					}
				}
				if (effects.contains("water")) {
					if (play.isBurning()) {
						play.extinguish();
					}
					for (int rangeX = -5; rangeX < 5; rangeX++) {
						for (int rangeY = -5; rangeY < 5; rangeY++) {
							for (int rangeZ = -5; rangeZ < 5; rangeZ++) {
								if (play.worldObj.getBlock((int) x + rangeX, (int) y + rangeY, (int) z + rangeZ) == Blocks.fire) {
									play.worldObj.setBlockToAir((int) x + rangeX, (int) y + rangeY, (int) z + rangeZ);

									energy -= 10;
								}
							}
						}
					}
				}
				if (effects.contains("earth")) {
					if (y < 32) {
						if (play.worldObj.rand.nextInt(600) == 0) {
							play.addPotionEffect(new PotionEffect(Potion.resistance.id, 400, 1));
							play.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 400, 1));
						}
					}
				}

				if (effects.contains("advancedIce")) {

					List<EntityCreature> entities = play.worldObj.getEntitiesWithinAABB(EntityCreature.class, AxisAlignedBB.getBoundingBox(x - 8, y - 8, z - 8, x + 8, y + 8, z + 8));
					for (EntityCreature entity : entities) {
						if (!player.worldObj.isRemote) {
							if (!entity.isPotionActive(Potion.weakness)) {

								entity.addPotionEffect(new PotionEffect(Potion.weakness.id, 400, 1));
								energy -= 30;
							}
						}
					}
					play.removePotionEffect(Potion.weakness.id);
				}

				if (effects.contains("advancedLava")) {

					List<EntityCreature> entities = play.worldObj.getEntitiesWithinAABB(EntityCreature.class, AxisAlignedBB.getBoundingBox(x - 8, y - 8, z - 8, x + 8, y + 8, z + 8));
					for (EntityCreature entity : entities) {
						if (!player.worldObj.isRemote) {
							entity.setFire(80);
							energy -= 30;
						}
					}
					play.removePotionEffect(Potion.weakness.id);
				}

				if (effects.contains("advancedLife")) {
					List<EntityTameable> entities = play.worldObj.getEntitiesWithinAABB(EntityTameable.class, AxisAlignedBB.getBoundingBox(x - 8, y - 8, z - 8, x + 8, y + 8, z + 8));
					for (EntityTameable entity : entities) {
						if (!player.worldObj.isRemote) {
							if(play.worldObj.rand.nextInt(60)==0 && entity.isTamed()){
							entity.heal(1);
							energy -= 30;
						}
					}
					play.removePotionEffect(Potion.weakness.id);
				}
				if (effects.contains("advancedLightning")) {

					List<EntityLightningBolt> bolts = play.worldObj.getEntitiesWithinAABB(EntityLightningBolt.class, AxisAlignedBB.getBoundingBox(x - 48, y - 48, z - 48, x + 48, y + 48, z + 48));
					for (EntityLightningBolt bolt : bolts) {
						if (!player.worldObj.isRemote) {
							play.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 600, 1, true));
							play.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 600, 1, true));
							energy -= 30;
						}
					}
				}

			}
			if (energy < -1) {
				energy = 0;
				if (effects.contains("fire")) {
					EffectHelper.setFireImmune(play, false);
				}
				if (effects.contains("step")) {
					play.stepHeight = 0.50001F;
				}
			}
			NBTHelper.setInteger(itemstack, "energy", energy);
		}
		}
	}

	@SubscribeEvent
	public void onPlayerJump(LivingJumpEvent event) {
		
		if (event.entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entityLiving;
			ItemStack belt = BaublesApi.getBaubles(player).getStackInSlot(0);
			
			if(belt.stackTagCompound == null){
				belt.stackTagCompound = new NBTTagCompound();
			}
			String effects = NBTHelper.getString(belt, "ETEffect");
			
			if (effects.contains("jump") && NBTHelper.getInt(stack, "energy")>0) {
				player.motionY += 0.2;
				player.fallDistance = -1;
				NBTHelper.setInteger(stack, "energy", NBTHelper.getInt(stack, "energy")-30);
			}
		}
	}

	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player) {
		

	}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
		String effects = NBTHelper.getString(itemstack, "ETEffect");
		if (effects.contains("advancedLightning")) {
			player.removePotionEffect(Potion.damageBoost.id);
		}
		if (effects.contains("step")) {
			player.stepHeight = 0.50001F;
		}
	}

	@Override
	public boolean canEquip(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}

	@Override
	public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}

	private int countEffects(ItemStack itemstack, String keyValue) {
		int index = NBTHelper.getString(itemstack, "ETEffect").indexOf(keyValue);
		int count = 0;
		while (index != -1) {
			count++;
			keyValue = keyValue.substring(index + 1);
			index = keyValue.indexOf(keyValue);
		}
		return count;
	}

}
