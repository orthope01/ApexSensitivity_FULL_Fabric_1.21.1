
package dev.apex.sensitivity.integration;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import dev.apex.sensitivity.gui.ApexConfigScreen;

public final class ModMenuEntry implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return ApexConfigScreen::create;
    }
}
