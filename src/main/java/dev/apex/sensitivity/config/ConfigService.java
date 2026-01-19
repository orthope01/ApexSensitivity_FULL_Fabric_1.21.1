
package dev.apex.sensitivity.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;

public final class ConfigService {

    private static SensitivityConfig config;

    public static void initialize() {
        AutoConfig.register(SensitivityConfig.class, GsonConfigSerializer::new);
        config = AutoConfig.getConfigHolder(SensitivityConfig.class).getConfig();
    }

    public static SensitivityConfig get() {
        return config;
    }

    public static void save() {
        AutoConfig.getConfigHolder(SensitivityConfig.class).save();
    }

    public static void load() {
        AutoConfig.getConfigHolder(SensitivityConfig.class).load();
        config = AutoConfig.getConfigHolder(SensitivityConfig.class).getConfig();
    }
}
