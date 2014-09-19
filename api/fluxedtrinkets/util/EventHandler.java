package fluxedtrinkets.util;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import fluxedtrinkets.ModInfo;
import fluxedtrinkets.util.version.VersionChecker;

public class EventHandler {

	public static boolean checked = false;
	public static boolean doneChecked = false;
	

	public EventHandler() {
		MinecraftForge.EVENT_BUS.register(this);
		FMLCommonHandler.instance().bus().register(this);
	}

//	@SubscribeEvent
//	public void onTick(ClientTickEvent event) {
//		if (event.phase == Phase.END && doneChecked &&Minecraft.getMinecraft().thePlayer != null && !checked) {
//			if (!VersionChecker.releaseVersion.isEmpty()) {
//				EntityPlayer player = Minecraft.getMinecraft().thePlayer;
//				if (!VersionChecker.releaseVersion.equals(ModInfo.version)) {
//					player.addChatComponentMessage(new ChatComponentTranslation(StringUtils.LIGHT_RED + "New Fluxed Trinkets version found! [" + VersionChecker.releaseVersion + "]"));
//				}
//			}
//
//			checked = true;
//		}
//	}
}
