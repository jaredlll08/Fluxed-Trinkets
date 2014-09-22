package fluxedtrinkets.util;

import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import fluxedtrinkets.util.key.Key;

public class KeyInputEventHandler {
	private static Key getPressedKeybinding() {
		if (Keybindings.activate.isPressed()) {
			return Key.ACTIVATE;
		}

		return Key.UNKNOWN;
	}

}
