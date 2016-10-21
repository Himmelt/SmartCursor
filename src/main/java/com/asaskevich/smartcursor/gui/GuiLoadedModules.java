package com.asaskevich.smartcursor.gui;

import com.asaskevich.smartcursor.Modules;
import com.asaskevich.smartcursor.SmartCursor;
import com.asaskevich.smartcursor.api.*;
import com.google.common.collect.Lists;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.*;
import net.minecraft.util.StatCollector;

public class GuiLoadedModules extends GuiScreen {
    private List field_146450_f;
    private int w;
    private int h;
    private int btnW;
    private int btnH;

    public GuiLoadedModules() {
        initGui();
    }

    public void initGui() {
        field_146450_f = new List();
        field_146450_f.registerScrollButtons(7, 8);
        buttonList.clear();
        w = width;
        h = height;
        btnW = (w / 8);
        btnH = (Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT * 2);
        buttonList.add(new GuiOptionButton(100, w - btnW - 25, h - 5 - btnH, btnW, btnH, StatCollector.translateToLocal("smartcursor.gui.switch")));
    }

    protected void actionPerformed(GuiButton button) {
        if (button.id == 100) {
            Modules.switchModule(field_146450_f.modules.get(field_146450_f.lastClickId).getClass().getCanonicalName());
            Modules.syncConfig(SmartCursor.config);
        }
        field_146450_f.drawScreen(w, h, zLevel);
        field_146450_f.updateSlots(button.id);
        this.mc.displayGuiScreen(this);
    }

    protected void keyTyped(char par1, int par2) {
        if (par2 == 1) {
            this.mc.thePlayer.closeScreen();
        }
    }

    public void func_73863_a(int width, int height, float zLevel) {
        field_146450_f.drawScreen(width, height, zLevel);
        int fh = fontRendererObj.FONT_HEIGHT;
        drawCenteredString(fontRendererObj, StatCollector.translateToLocal("smartcursor.gui.loadedModules"), this.width / 2, 16, 0xFFFFFF);
        drawString(fontRendererObj, StatCollector.translateToLocal("smartcursor.gui.class") + ": " + field_146450_f.moduleClass, 25, height - fh * 3 - 5, 0xFFFFFF);
        drawString(fontRendererObj, StatCollector.translateToLocal("smartcursor.gui.name") + ": " + field_146450_f.moduleName, 25, height - fh * 2 - 5, 0xFFFFFF);
        drawString(fontRendererObj, StatCollector.translateToLocal("smartcursor.gui.author") + ": " + field_146450_f.moduleAuthor, 25, height - fh - 5, 0xFFFFFF);
        super.drawScreen(width, height, zLevel);
    }

    @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
    class List
            extends GuiSlot {
        private final java.util.List moduleNames = Lists.newArrayList();
        private final java.util.List moduleClasses = Lists.newArrayList();
        private final java.util.List modules = Lists.newArrayList();
        public int lastClickId = 0;
        public String moduleClass = "";
        public String moduleName = "";
        public String moduleAuthor = "";

        @SuppressWarnings({"unchecked", "static-access"})
        public List() {
            super(GuiLoadedModules.this.mc, GuiLoadedModules.this.width, GuiLoadedModules.this.height, 32, GuiLoadedModules.this.height - Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT * 4, 18);
            for (IEntityProcessor module : Modules.entityModules) {
                moduleClasses.add(module.getClass().getSimpleName());
                moduleNames.add(module.getModuleName());
                modules.add(module);
            }
            for (IBlockProcessor module : Modules.blockModules) {
                moduleClasses.add(module.getClass().getSimpleName());
                moduleNames.add(module.getModuleName());
                modules.add(module);
            }
            for (IDropProcessor module : Modules.dropModules) {
                moduleClasses.add(module.getClass().getSimpleName());
                moduleNames.add(module.getModuleName());
                modules.add(module);
            }
            for (IPlayerProcessor module : Modules.playerModules) {
                moduleClasses.add(module.getClass().getSimpleName());
                moduleNames.add(module.getModuleName());
                modules.add(module);
            }
            IModule m = Modules.entityModules.get(0);
            moduleClass = m.getClass().getSimpleName();
            moduleName = m.getModuleName();
            moduleAuthor = m.getAuthor();
        }

        protected int getSize() {
            return moduleNames.size();
        }

        protected void elementClicked(int id, boolean flag, int x, int y) {
            lastClickId = id;
            IModule m = (IModule) modules.get(id);
            moduleClass = m.getClass().getSimpleName();
            moduleName = m.getModuleName();
            moduleAuthor = m.getAuthor();
        }

        protected boolean isSelected(int id) {
            return id == lastClickId;
        }

        public void updateSlots(int slot) {
            if (lastClickId == -1) {
            }
        }

        protected int getContentHeight() {
            return getSize() * 18;
        }

        @Override
        public int getListWidth() {
            return GuiLoadedModules.this.width - 40;
        }

        @Override
        protected int getScrollBarX() {
            return GuiLoadedModules.this.width - 20;
        }

        protected void drawBackground() {
            GuiLoadedModules.this.drawDefaultBackground();
        }

        protected void drawSlot(int id, int p_148126_2_, int yPosition, int p_148126_4_, int p_148126_5_, int p_148126_6_) {
            try {
                FontRenderer fontRenderer = GuiLoadedModules.this.fontRendererObj;
                fontRenderer.setBidiFlag(true);
                String name = (String) moduleClasses.get(id);
                int w = GuiLoadedModules.this.fontRendererObj.getStringWidth(name);
                GuiLoadedModules.this.drawCenteredString(fontRenderer, name, 25 + w / 2, yPosition + 1, Modules.isActiveModule(modules.get(id).getClass().getCanonicalName()) ? 0xFFFFFF : 9408399);
                name = Modules.isActiveModule(modules.get(id).getClass().getCanonicalName()) ? "ON" : "OFF";
                w = GuiLoadedModules.this.fontRendererObj.getStringWidth(name);
                GuiLoadedModules.this.drawCenteredString(fontRenderer, name, this.width - w / 2 - 25, yPosition + 1, Modules.isActiveModule(modules.get(id).getClass().getCanonicalName()) ? 0xFFFFFF : 9408399);
                fontRenderer.setBidiFlag(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
