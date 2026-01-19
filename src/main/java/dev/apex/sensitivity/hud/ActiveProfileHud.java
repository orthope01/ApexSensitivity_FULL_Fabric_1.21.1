package dev.apex.sensitivity.hud;

import dev.apex.sensitivity.config.ConfigService;
import dev.apex.sensitivity.profile.ProfileManager;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter; // Добавлен новый импорт

public final class ActiveProfileHud {

    public static void initialize() {
        // Теперь здесь не будет ошибки, так как сигнатура метода render совпадает
        HudRenderCallback.EVENT.register(ActiveProfileHud::render);
    }

    // Изменен второй параметр с float на RenderTickCounter
    private static void render(DrawContext ctx, RenderTickCounter tickCounter) {
        if (!ConfigService.get().showHud) return;

        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.textRenderer == null) return;

        String label = ProfileManager.getActive().displayName();

        // В 1.21.1 DrawContext работает так же, поэтому здесь изменений не требуется
        ctx.drawText(mc.textRenderer, "Sensitivity: " + label, 8, 8, 0xE0E0E0, true);
    }
}