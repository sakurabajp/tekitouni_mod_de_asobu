package net.cherry_leaves.asobu.client.gui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Objects;

public class WhiteBackgroundScreen extends Screen {

    public WhiteBackgroundScreen() {
        super(Text.literal("White Background Screen"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        Identifier texture2 = new Identifier("asobu", "textures/background.png");
        context.drawGuiTexture(texture2, 0, this.height / 8, this.width, this.height - (this.height / 8));
        context.drawText(Objects.requireNonNull(client).textRenderer, "Hello, world!", 10, 200, 0xFFFFFFFF, false);
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return true;
    }
}