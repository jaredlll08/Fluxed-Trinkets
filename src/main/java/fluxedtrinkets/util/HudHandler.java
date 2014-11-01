package fluxedtrinkets.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.command.CommandTime;
import net.minecraft.item.ItemStack;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.RenderTickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fluxedtrinkets.items.ItemPocketWatch;

@SideOnly(Side.CLIENT)
public class HudHandler {

	private static Minecraft mc = Minecraft.getMinecraft();

	@SubscribeEvent
	public void onRenderTick(RenderTickEvent evt) {
		tickEnd();
	}

	private static void tickEnd() {
		if (mc.thePlayer != null) {
			mc.entityRenderer.setupOverlayRendering();

			long time = mc.theWorld.getWorldTime();
			mc.fontRenderer.drawString(String.valueOf(time), 5, 5, 0);
			if ((mc.currentScreen == null || mc.currentScreen instanceof GuiChat) && !mc.gameSettings.hideGUI && !mc.gameSettings.showDebugInfo) {
				// if (stopWatch != null && stopWatch.getItem() instanceof
				// ItemPocketWatch) {

				// }
			}
		}
	}
}