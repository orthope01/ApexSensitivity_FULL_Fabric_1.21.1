
package dev.apex.sensitivity.config;

import dev.apex.sensitivity.profile.SensitivityProfile;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = "apexsensitivity")
public final class SensitivityConfig implements ConfigData {

    public double defaultSensitivity = 1.0;
    public double precisionSensitivity = 0.45;
    public double fastSensitivity = 1.9;

    public boolean showHud = true;

    public SensitivityProfile activeProfile = SensitivityProfile.DEFAULT;
}
