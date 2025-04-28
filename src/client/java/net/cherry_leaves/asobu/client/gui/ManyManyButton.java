package net.cherry_leaves.asobu.client.gui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.SliderWidget;
import net.minecraft.text.Text;

public class ManyManyButton extends Screen {

    public ManyManyButton() {
        super(Text.literal("？"));
    }

    @Override
    protected void init() {
        // 1つめのボタン
        if( MinecraftClient.getInstance().player != null && MinecraftClient.getInstance().player.getAbilities().allowFlying) {
            this.addDrawableChild(ButtonWidget.builder(
                            Text.literal("飛べなくなるボタン"),
                            button -> {
                                if (MinecraftClient.getInstance().player != null) {
                                    MinecraftClient.getInstance().player.getAbilities().allowFlying = false;
                                    MinecraftClient.getInstance().player.sendAbilitiesUpdate();
                                }
                                MinecraftClient.getInstance().setScreen(new ManyManyButton());

                            })
                    .dimensions(this.width / 2 - 150, this.height / 2 - 30, 300, 20)
                    .build()
            );
        }
        else {
            this.addDrawableChild(ButtonWidget.builder(
                            Text.literal("飛べるようになるボタン"),
                            button -> {
                                if (MinecraftClient.getInstance().player != null) {
                                    MinecraftClient.getInstance().player.getAbilities().allowFlying = true;
                                    MinecraftClient.getInstance().player.sendAbilitiesUpdate();
                                }
                                MinecraftClient.getInstance().setScreen(new ManyManyButton());
                            })
                    .dimensions(this.width / 2 - 150, this.height / 2 - 30, 300, 20)
                    .build()
            );
        }
        // ふたつめはスライドバー！
        Float PFS = MinecraftClient.getInstance().player.getAbilities().getFlySpeed();
        this.addDrawableChild(new SliderWidget(this.width / 2 - 150, this.height / 2, 300, 20, Text.literal("ふらいすぴーど！ : " + Math.round(PFS * 100)), PFS) {
            @Override
            protected void updateMessage() {
                // Update text to display current value
                setMessage(Text.literal("ふらいすぴーど！ : " + Math.round(value * 100)));
            }
            @Override
            protected void applyValue() {
                // Apply the slider's value
                System.out.println("Slider value applied: " + value);
                MinecraftClient.getInstance().player.getAbilities().setFlySpeed((float) value);
            }
        });
        this.addDrawableChild(ButtonWidget.builder(
                        Text.literal("GUIを閉じる"),
                        button -> {
                            System.out.println("GUIを閉じる処理を実行");
                            MinecraftClient.getInstance().setScreen(null);
                        })
                .dimensions(this.width / 2 - 150, this.height / 2 + 30, 300, 20)
                .build()
        );
    }


    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return true;
    }
}