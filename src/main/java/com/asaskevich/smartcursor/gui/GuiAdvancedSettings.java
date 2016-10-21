package com.asaskevich.smartcursor.gui;

import com.asaskevich.smartcursor.RenderHandler;
import com.asaskevich.smartcursor.SmartCursor;
import com.asaskevich.smartcursor.utils.Setting;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiOptionButton;
import net.minecraft.util.StatCollector;

public class GuiAdvancedSettings extends net.minecraft.client.gui.GuiScreen {
    private RenderHandler renderHandler;
    private int w;
    private int h;
    private int btnW;
    private int btnH;
    private int fH;

    public GuiAdvancedSettings(RenderHandler r) {
        renderHandler = r;
    }

    @SuppressWarnings("unchecked")
    public void initGui() {
        w = width;
        h = height;
        btnW = (w / 4);
        btnH = (fontRendererObj.FONT_HEIGHT * 2);
        fH = fontRendererObj.FONT_HEIGHT;
        buttonList.clear();
        buttonList.add(new GuiOptionButton(0, w / 2 + btnW / 2, h / 4 - 60 + 50 - btnH / 2 + (btnH + fH / 2) * 0, btnW, btnH, Setting.displayAdvInfoMob ? "ON" : "OFF"));
        buttonList.add(new CustomGuiOptionSlider(1, w / 2 + btnW / 2, h / 4 - 60 + 50 - btnH / 2 + (btnH + fH / 2) * 1, btnW, btnH, StatCollector.translateToLocal("smartcursor.gui.heartCount"), 5.0F, 50.0F, 1.0F, (float) Setting.maxHeartCount, this));
        buttonList.add(new GuiOptionButton(2, w / 2 + btnW / 2, h / 4 - 60 + 50 - btnH / 2 + (btnH + fH / 2) * 2, btnW, btnH, renderHandler.getDropStyleName()));
        buttonList.add(new CustomGuiOptionSlider(3, w / 2 + btnW / 2, h / 4 - 60 + 50 - btnH / 2 + (btnH + fH / 2) * 3, btnW, btnH, StatCollector.translateToLocal("smartcursor.gui.distance"), 1.0F, 100.0F, 1.0F, (float) Setting.lookDistance, this));
        buttonList.add(new CustomGuiOptionSlider(4, w / 2 + btnW / 2, h / 4 - 60 + 50 - btnH / 2 + (btnH + fH / 2) * 4, btnW, btnH, StatCollector.translateToLocal("smartcursor.gui.transparent"), 0.0F, 255.0F, 1.0F, Setting.transparent, this));
        buttonList.add(new GuiOptionButton(5, w / 2 + btnW / 2, h / 4 - 60 + 50 - btnH / 2 + (btnH + fH / 2) * 5, btnW, btnH, renderHandler.getPlayerStyleName()));
        buttonList.add(new GuiOptionButton(6, w / 2 + btnW / 2, h / 4 - 60 + 50 - btnH / 2 + (btnH + fH / 2) * 6, btnW, btnH, Setting.showTooltipInRightCorner ? StatCollector.translateToLocal("smartcursor.gui.rightCorner") : StatCollector.translateToLocal("smartcursor.gui.leftCorner")));
        buttonList.add(new CustomGuiOptionSlider(7, w / 2 + btnW / 2, h / 4 - 60 + 50 - btnH / 2 + (btnH + fH / 2) * 7, btnW, btnH, StatCollector.translateToLocal("smartcursor.gui.tooltipDelta"), 0.0F, 5000.0F, 1.0F, Setting.delta, this));
    }

    protected void actionPerformed(GuiButton button) {
        if (button.id == 0) {
            renderHandler.invertMobInfo();
            button.displayString = (Setting.displayAdvInfoMob ? "ON" : "OFF");
        }
        if (button.id == 2) {
            renderHandler.setDropNextStyle();
            button.displayString = renderHandler.getDropStyleName();
        }
        if (button.id == 5) {
            renderHandler.setPlayerNextStyle();
            button.displayString = renderHandler.getPlayerStyleName();
        }
        if (button.id == 6) {
            renderHandler.invertTooltipPlaceInfo();
            button.displayString = (Setting.showTooltipInRightCorner ? StatCollector.translateToLocal("smartcursor.gui.rightCorner") : StatCollector.translateToLocal("smartcursor.gui.leftCorner"));
        }
        Setting.updateSettings(SmartCursor.config);
        Setting.syncConfig(SmartCursor.config);
    }

    protected void keyTyped(char par1, int par2) {
        if (par2 == 1) {
            mc.thePlayer.closeScreen();
        }
    }

    public void drawScreen(int par1, int par2, float par3) {
        drawDefaultBackground();
        drawCenteredString(fontRendererObj, StatCollector.translateToLocal("smartcursor.gui.advancedTitle"), w / 2, h / 4 - 60 + 20, 0xFFFFFF);
        drawCenteredString(fontRendererObj, StatCollector.translateToLocal("smartcursor.gui.showAdvancedInfoMobs"), w / 4, h / 4 - 60 + 50 + (btnH + fH / 2) * 0, 0xFFFFFF);
        drawCenteredString(fontRendererObj, StatCollector.translateToLocal("smartcursor.gui.maxHeartCount"), w / 4, h / 4 - 60 + 50 + (btnH + fH / 2) * 1, 0xFFFFFF);
        drawCenteredString(fontRendererObj, StatCollector.translateToLocal("smartcursor.gui.showAdvancedDropInfo"), w / 4, h / 4 - 60 + 50 + (btnH + fH / 2) * 2, 0xFFFFFF);
        drawCenteredString(fontRendererObj, StatCollector.translateToLocal("smartcursor.gui.lookingDistance"), w / 4, h / 4 - 60 + 50 + (btnH + fH / 2) * 3, 0xFFFFFF);
        drawCenteredString(fontRendererObj, StatCollector.translateToLocal("smartcursor.gui.transparent"), w / 4, h / 4 - 60 + 50 + (btnH + fH / 2) * 4, 0xFFFFFF);
        drawCenteredString(fontRendererObj, StatCollector.translateToLocal("smartcursor.gui.styleOfPlayerInfo"), w / 4, h / 4 - 60 + 50 + (btnH + fH / 2) * 5, 0xFFFFFF);
        drawCenteredString(fontRendererObj, StatCollector.translateToLocal("smartcursor.gui.tooltipPosition"), w / 4, h / 4 - 60 + 50 + (btnH + fH / 2) * 6, 0xFFFFFF);
        drawCenteredString(fontRendererObj, StatCollector.translateToLocal("smartcursor.gui.displayTime"), w / 4, h / 4 - 60 + 50 + (btnH + fH / 2) * 7, 0xFFFFFF);
        super.drawScreen(par1, par2, par3);
    }

    public void updateSettings(CustomGuiOptionSlider slider) {
        if (slider.id == 1) Setting.maxHeartCount = slider.value;
        if (slider.id == 3) Setting.lookDistance = slider.value;
        if (slider.id == 4) Setting.transparent = (int) slider.value;
        if (slider.id == 7) Setting.delta = (int) slider.value;
        Setting.updateSettings(SmartCursor.config);
        Setting.syncConfig(SmartCursor.config);
    }
}