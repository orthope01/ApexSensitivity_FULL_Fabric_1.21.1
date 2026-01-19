
package dev.apex.sensitivity.input;

import dev.apex.sensitivity.profile.ProfileManager;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;

public final class ProfileKeybindHandler {

    private static KeyBinding cycle;

    public static void initialize() {
        cycle = KeyBindingHelper.registerKeyBinding(
                new KeyBinding(
                        "Cycle Sensitivity Profile",
                        GLFW.GLFW_KEY_C,
                        "Apex Sensitivity"
                )
        );
    }

    public static void handle() {
        while (cycle.wasPressed()) {
            ProfileManager.cycleManually();
        }
    }
}
