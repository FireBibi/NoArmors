package fr.bibifire.noarmors;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class NoArmorsClient implements ClientModInitializer {
	private KeyBinding toggle;
	private boolean shouldRenderArmor;
	private static NoArmorsClient INSTANCE;

	@Override
	public void onInitializeClient() {
		INSTANCE = this;
		this.toggle = KeyBindingHelper.registerKeyBinding(new KeyBinding("noarmors.toggle", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_H, "noarmors.keymenu"));
		this.shouldRenderArmor = true;

		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while (this.toggle.wasPressed()) {
				shouldRenderArmor = !shouldRenderArmor;
			}
		});
	}

	public static NoArmorsClient getInstance() {
		return INSTANCE;
	}

	public boolean shouldRenderArmor() {
		return shouldRenderArmor;
	}
}