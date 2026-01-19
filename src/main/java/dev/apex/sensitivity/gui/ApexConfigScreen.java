
package dev.apex.sensitivity.gui;

import dev.apex.sensitivity.config.ConfigService;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public final class ApexConfigScreen {

    public static Screen create(Screen parent) {
        var cfg = ConfigService.get();
        var builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(Text.literal("Apex Sensitivity"));

        var profiles = builder.getOrCreateCategory(Text.literal("Profiles"));
        ConfigEntryBuilder e = builder.entryBuilder();

        profiles.addEntry(e.startDoubleField(Text.literal("Default Profile"), cfg.defaultSensitivity)
                .setMin(0.1).setMax(5).setSaveConsumer(v -> cfg.defaultSensitivity = v).build());

        profiles.addEntry(e.startDoubleField(Text.literal("Precision Profile"), cfg.precisionSensitivity)
                .setMin(0.05).setMax(3).setSaveConsumer(v -> cfg.precisionSensitivity = v).build());

        profiles.addEntry(e.startDoubleField(Text.literal("Fast Profile"), cfg.fastSensitivity)
                .setMin(0.5).setMax(10).setSaveConsumer(v -> cfg.fastSensitivity = v).build());

        var ui = builder.getOrCreateCategory(Text.literal("Interface"));
        ui.addEntry(e.startBooleanToggle(Text.literal("HUD Indicator"), cfg.showHud)
                .setSaveConsumer(v -> cfg.showHud = v).build());

        builder.setSavingRunnable(ConfigService::save);
        return builder.build();
    }
}
