
package dev.apex.sensitivity.client;

import dev.apex.sensitivity.config.ConfigService;
import dev.apex.sensitivity.hud.ActiveProfileHud;
import dev.apex.sensitivity.input.ProfileKeybindHandler;
import dev.apex.sensitivity.profile.ProfileManager;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public final class ApexSensitivityClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ConfigService.initialize();
        ProfileManager.initialize();
        ProfileKeybindHandler.initialize();
        ActiveProfileHud.initialize();

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player != null) {
                ProfileManager.resolveContext(client.player);
                ProfileKeybindHandler.handle();
            }
        });
    }
}
