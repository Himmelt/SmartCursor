package com.asaskevich.smartcursor.keyboard;

import com.asaskevich.smartcursor.RenderHandler;
import com.asaskevich.smartcursor.gui.GuiSMSettings;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

public class KeyInputHandler {
    private Minecraft mc = Minecraft.getMinecraft();
    private GuiSMSettings gui;

    public KeyInputHandler(RenderHandler r) {
        gui = new GuiSMSettings(r);
    }

    @SubscribeEvent
    public void onKeyInput(KeyInputEvent event) {
        if (KeyBindler.renderBlockDamage.isPressed()) {
            mc.displayGuiScreen(gui);
        }
    }
}
