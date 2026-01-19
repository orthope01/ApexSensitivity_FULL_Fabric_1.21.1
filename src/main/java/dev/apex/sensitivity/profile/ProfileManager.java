
package dev.apex.sensitivity.profile;

import dev.apex.sensitivity.config.ConfigService;
import net.minecraft.client.network.ClientPlayerEntity;

public final class ProfileManager {

    private static SensitivityProfile active;

    public static void initialize() {
        active = ConfigService.get().activeProfile;
    }

    public static SensitivityProfile getActive() {
        return active;
    }

    public static void cycleManually() {
        active = SensitivityProfile.values()[(active.ordinal() + 1) % SensitivityProfile.values().length];
        persist();
    }

    public static void resolveContext(ClientPlayerEntity player) {
        SensitivityProfile resolved =
                player.isFallFlying() ? SensitivityProfile.FAST :
                player.isSneaking()   ? SensitivityProfile.PRECISION :
                                        SensitivityProfile.DEFAULT;

        if (resolved != active) {
            active = resolved;
        }
    }

    private static void persist() {
        ConfigService.get().activeProfile = active;
        ConfigService.save();
    }

    public static double getEffectiveSensitivity() {
        return switch (active) {
            case DEFAULT -> ConfigService.get().defaultSensitivity;
            case PRECISION -> ConfigService.get().precisionSensitivity;
            case FAST -> ConfigService.get().fastSensitivity;
        };
    }
}
