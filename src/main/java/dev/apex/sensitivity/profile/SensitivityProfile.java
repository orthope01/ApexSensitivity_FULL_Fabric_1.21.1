
package dev.apex.sensitivity.profile;

public enum SensitivityProfile {
    DEFAULT("Default"),
    PRECISION("Precision"),
    FAST("Fast");

    private final String displayName;

    SensitivityProfile(String displayName) {
        this.displayName = displayName;
    }

    public String displayName() {
        return displayName;
    }
}
