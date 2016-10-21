package com.asaskevich.smartcursor.keyboard;

import net.minecraft.client.settings.KeyBinding;

public class KeyBindler {
    public static KeyBinding renderBlockDamage;

    public static void init() {
        renderBlockDamage = new KeyBinding("Smart Cursor Enable/Disable", 33, "SmartCursor");
        net.minecraftforge.fml.client.registry.ClientRegistry.registerKeyBinding(renderBlockDamage);
    }
}