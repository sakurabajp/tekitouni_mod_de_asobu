package net.cherry_leaves.asobu.client;

import net.cherry_leaves.asobu.client.gui.ManyManyButton;
import net.cherry_leaves.asobu.client.gui.WhiteBackgroundScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class AsobuClient implements ClientModInitializer {

    private static KeyBinding showWhiteGuiKey;
    private static KeyBinding showWhiteGuiKey2;

    @Override
    public void onInitializeClient() {
        String Category1 = "好きにします！！！！！れ！！！！！！！！！！";
        // キーバインド登録
        showWhiteGuiKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "これは...なんだっけ...",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_G,
                Category1
        ));
        // にこめ
        showWhiteGuiKey2 = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "ここ日本語に変えても良いの？",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_K,
                Category1
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (showWhiteGuiKey.wasPressed()) {
                if (client.currentScreen == null) {
                    client.setScreen(new WhiteBackgroundScreen());
                }
            }
            while (showWhiteGuiKey2.wasPressed()) {
                if (client.currentScreen == null) {
                    client.setScreen(new ManyManyButton());
                }
            }
        });

    }
}