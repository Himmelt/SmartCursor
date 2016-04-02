package com.asaskevich.smartcursor.gui;
import com.asaskevich.smartcursor.SmartCursor;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;
public class ConfigGUI extends GuiConfig {
    public ConfigGUI(GuiScreen parent) {
        super(parent, new ConfigElement(SmartCursor.config.getCategory("general")).getChildElements(), "SmartCursor", false, false, GuiConfig.getAbridgedConfigPath(SmartCursor.config.toString()));
    }
}