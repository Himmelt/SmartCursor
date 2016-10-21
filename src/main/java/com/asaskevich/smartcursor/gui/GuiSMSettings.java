package com.asaskevich.smartcursor.gui;

import com.asaskevich.smartcursor.RenderHandler;
import com.asaskevich.smartcursor.SmartCursor;
import com.asaskevich.smartcursor.utils.Setting;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiOptionButton;
import net.minecraft.util.StatCollector;

public class GuiSMSettings extends net.minecraft.client.gui.GuiScreen {
    private RenderHandler renderHandler;
    private int w;
    private int h;
    private int btnW;
    private int btnH;
    private int fH;

    public GuiSMSettings(RenderHandler renderHandler) {
        this.renderHandler = renderHandler;
    }

    public void initGui() {
        w = width;
        h = height;
        btnW = (w / 4);
        btnH = (fontRendererObj.FONT_HEIGHT * 2);
        fH = fontRendererObj.FONT_HEIGHT;
        buttonList.clear();
        buttonList.add(new GuiOptionButton(0, w / 2 + btnW / 2, h / 7 - 60 + 50 - btnH / 2, btnW, btnH, Setting.isEnabled ? "ON" : "OFF"));
        buttonList.add(new GuiOptionButton(1, w / 2 + btnW / 2, h / 7 - 60 + 50 - btnH / 2 + (btnH + fH / 4) * 1, btnW, btnH, renderHandler.getStyleName()));
        buttonList.add(new GuiOptionButton(2, w / 2 + btnW / 2, h / 7 - 60 + 50 - btnH / 2 + (btnH + fH / 4) * 2, btnW, btnH, renderHandler.getMobStyleName()));
        buttonList.add(new GuiOptionButton(3, w / 2 + btnW / 2, h / 7 - 60 + 50 - btnH / 2 + (btnH + fH / 4) * 3, btnW, btnH, Setting.showDropInformation ? "ON" : "OFF"));
        buttonList.add(new GuiOptionButton(4, w / 2 + btnW / 2, h / 7 - 60 + 50 - btnH / 2 + (btnH + fH / 4) * 4, btnW, btnH, Setting.showEnchantments ? "ON" : "OFF"));
        buttonList.add(new GuiOptionButton(5, w / 2 + btnW / 2, h / 7 - 60 + 50 - btnH / 2 + (btnH + fH / 4) * 5, btnW, btnH, Setting.showDurability ? "ON" : "OFF"));
        buttonList.add(new GuiOptionButton(6, w / 2 + btnW / 2, h / 7 - 60 + 50 - btnH / 2 + (btnH + fH / 4) * 6, btnW, btnH, Setting.showXPOrb ? "ON" : "OFF"));
        buttonList.add(new GuiOptionButton(8, w / 2 + btnW / 2, h / 7 - 60 + 50 - btnH / 2 + (btnH + fH / 4) * 7, btnW, btnH, Setting.showPlayerInformation ? "ON" : "OFF"));
        buttonList.add(new GuiOptionButton(9, w / 2 + btnW / 2, h / 7 - 60 + 50 - btnH / 2 + (btnH + fH / 4) * 8, btnW, btnH, Setting.showBlockInformation ? "ON" : "OFF"));
        buttonList.add(new GuiOptionButton(7, w - btnW - 5, h - btnH - 5, btnW, btnH, StatCollector.translateToLocal("smartcursor.gui.advanced")));
        buttonList.add(new GuiOptionButton(10, 5, h - btnH - 5, btnW, btnH, StatCollector.translateToLocal("smartcursor.gui.moduleList")));
        for (int i = 1; i < buttonList.size(); i++) {
            GuiOptionButton btn = (GuiOptionButton) buttonList.get(i);
            btn.enabled = Setting.isEnabled;
        }
        if (Setting.isEnabled) {
            GuiOptionButton btn = (GuiOptionButton) buttonList.get(4);
            btn.enabled = Setting.showDropInformation;
            btn = (GuiOptionButton) buttonList.get(5);
            btn.enabled = Setting.showDropInformation;
        }
    }

    protected void actionPerformed(GuiButton button) {
        if (button.id == 0) {
            renderHandler.invertRender();
            button.displayString = (Setting.isEnabled ? "ON" : "OFF");
            for (int i = 1; i < buttonList.size(); i++) {
                GuiOptionButton btn = (GuiOptionButton) buttonList.get(i);
                btn.enabled = Setting.isEnabled;
            }
            if (Setting.isEnabled) {
                GuiOptionButton btn = (GuiOptionButton) buttonList.get(4);
                btn.enabled = Setting.showDropInformation;
                btn = (GuiOptionButton) buttonList.get(5);
                btn.enabled = Setting.showDropInformation;
            }
        }
        if (button.id == 1) {
            renderHandler.setNextStyle();
            button.displayString = renderHandler.getStyleName();
        }
        if (button.id == 2) {
            renderHandler.setMobNextStyle();
            button.displayString = renderHandler.getMobStyleName();
        }
        if (button.id == 3) {
            renderHandler.invertDropInfo();
            if (Setting.isEnabled) {
                GuiOptionButton btn = (GuiOptionButton) buttonList.get(4);
                btn.enabled = Setting.showDropInformation;
                btn = (GuiOptionButton) buttonList.get(5);
                btn.enabled = Setting.showDropInformation;
            }
            button.displayString = (Setting.showDropInformation ? "ON" : "OFF");
        }
        if (button.id == 4) {
            renderHandler.invertEnchInfo();
            button.displayString = (Setting.showEnchantments ? "ON" : "OFF");
        }
        if (button.id == 5) {
            renderHandler.invertDurInfo();
            button.displayString = (Setting.showDurability ? "ON" : "OFF");
        }
        if (button.id == 6) {
            renderHandler.invertXPInfo();
            button.displayString = (Setting.showXPOrb ? "ON" : "OFF");
        }
        if (button.id == 8) {
            renderHandler.invertPlayerInfo();
            button.displayString = (Setting.showPlayerInformation ? "ON" : "OFF");
        }
        if (button.id == 9) {
            renderHandler.invertBlockInfo();
            button.displayString = (Setting.showBlockInformation ? "ON" : "OFF");
        }
        if (button.id == 7) mc.displayGuiScreen(new GuiAdvancedSettings(renderHandler));
        if (button.id == 10) mc.displayGuiScreen(new GuiLoadedModules());
        Setting.updateSettings(SmartCursor.config);
        Setting.syncConfig(SmartCursor.config);
    }

    protected void keyTyped(char par1, int par2) {
        if (par2 == 1) {
            this.mc.thePlayer.closeScreen();
        }
    }

    public void drawScreen(int par1, int par2, float par3) {
        drawDefaultBackground();
        drawCenteredString(fontRendererObj, StatCollector.translateToLocal("smartcursor.gui.title"), w / 2, (h / 7 - 10) / 2, 0xFFFFFF);
        drawCenteredString(fontRendererObj, StatCollector.translateToLocal("smartcursor.gui.isEnabled"), w / 4, h / 7 - 60 + 50, 0xFFFFFF);
        drawCenteredString(fontRendererObj, StatCollector.translateToLocal("smartcursor.gui.showBlockDamage"), w / 4, h / 7 - 60 + 50 + (btnH + fH / 4) * 1, 0xFFFFFF);
        drawCenteredString(fontRendererObj, StatCollector.translateToLocal("smartcursor.gui.showMobHealth"), w / 4, h / 7 - 60 + 50 + (btnH + fH / 4) * 2, 0xFFFFFF);
        drawCenteredString(fontRendererObj, StatCollector.translateToLocal("smartcursor.gui.showDropInfo"), w / 4, h / 7 - 60 + 50 + (btnH + fH / 4) * 3, 0xFFFFFF);
        drawCenteredString(fontRendererObj, StatCollector.translateToLocal("smartcursor.gui.showDropEnchantments"), w / 4, h / 7 - 60 + 50 + (btnH + fH / 4) * 4, 0xFFFFFF);
        drawCenteredString(fontRendererObj, StatCollector.translateToLocal("smartcursor.gui.showDurability"), w / 4, h / 7 - 60 + 50 + (btnH + fH / 4) * 5, 0xFFFFFF);
        drawCenteredString(fontRendererObj, StatCollector.translateToLocal("smartcursor.gui.showXPorbInfo"), w / 4, h / 7 - 60 + 50 + (btnH + fH / 4) * 6, 0xFFFFFF);
        drawCenteredString(fontRendererObj, StatCollector.translateToLocal("smartcursor.gui.showPlayerInfo"), w / 4, h / 7 - 60 + 50 + (btnH + fH / 4) * 7, 0xFFFFFF);
        drawCenteredString(fontRendererObj, StatCollector.translateToLocal("smartcursor.gui.showBlockInfo"), w / 4, h / 7 - 60 + 50 + (btnH + fH / 4) * 8, 0xFFFFFF);
        super.drawScreen(par1, par2, par3);
    }
}