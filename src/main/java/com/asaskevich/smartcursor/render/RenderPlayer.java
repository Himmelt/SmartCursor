package com.asaskevich.smartcursor.render;

import com.asaskevich.smartcursor.Modules;
import com.asaskevich.smartcursor.RenderHandler;
import com.asaskevich.smartcursor.api.IPlayerProcessor;
import com.asaskevich.smartcursor.utils.Setting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

public class RenderPlayer {
    public Minecraft mc;
    public int width;
    public int height;

    public RenderPlayer() {
        mc = Minecraft.getMinecraft();
        width = mc.displayWidth;
        height = mc.displayHeight;
    }

    public void render(EntityPlayer player, RenderHandler render) {
        ScaledResolution res = new ScaledResolution(mc);
        FontRenderer fontRender = mc.fontRendererObj;
        width = res.getScaledWidth();
        height = res.getScaledHeight();
        mc.entityRenderer.setupOverlayRendering();
        int color = 0xFFFFFF;
        if (Setting.playerStyle == 0) {
            int x = 4;
            int y = 4;
            List<String> list = new ArrayList();
            list.add("");
            for (IPlayerProcessor module : Modules.playerModules) {
                if (Modules.isActiveModule(module.getClass().getCanonicalName())) module.process(list, player);
            }
            String text = String.format(EnumChatFormatting.BOLD + "" + EnumChatFormatting.GOLD + "%s:" + EnumChatFormatting.RESET + " %d/%d", player.getDisplayNameString(), Integer.valueOf((int) player.getHealth()), Integer.valueOf((int) player.getMaxHealth()));
            int maxW = fontRender.getStringWidth(text) + 16;
            for (int i = 1; i < list.size(); i++)
                maxW = Math.max(maxW, fontRender.getStringWidth(list.get(i)) + 8);
            if (Setting.showTooltipInRightCorner) x = width - maxW;
            //RenderHelper.drawRect(x - 5, 0, x + maxW + 1, 8 + fontRender.FONT_HEIGHT * list.size() + 1, 5592405, Setting.transparent);
            //RenderHelper.drawRect(x - 4, 0, x + maxW, 8 + fontRender.FONT_HEIGHT * list.size(), 65825, Setting.transparent);
            mc.entityRenderer.setupOverlayRendering();
            GL11.glPushMatrix();
            GL11.glEnable(3042);
            mc.getTextureManager().bindTexture(render.iconSheet);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glScalef(fontRender.FONT_HEIGHT / 8, fontRender.FONT_HEIGHT / 8, fontRender.FONT_HEIGHT / 8);
            mc.ingameGUI.drawTexturedModalRect(x + 4 + fontRender.getStringWidth(text), 4, 34, 0, 9, 9);
            mc.ingameGUI.drawTexturedModalRect(x + 4 + fontRender.getStringWidth(text), 4, 52, 0, 8, 8);
            GL11.glDisable(3042);
            GL11.glPopMatrix();
            for (int i = 1; i < list.size(); i++)
                fontRender.drawStringWithShadow(list.get(i), x, y + fontRender.FONT_HEIGHT * i, color);
            fontRender.drawStringWithShadow(text, x, y, color);
        }
        if (Setting.playerStyle == 1) {
            color = 0xFFFFFF;
            int x = width / 2 + 4;
            int y = height / 2 - 2 - fontRender.FONT_HEIGHT;
            String text = String.format("%.0fx", Float.valueOf(player.getHealth()));
            String mobName = player.getName();
            fontRender.drawStringWithShadow(text, x, y, color);
            fontRender.drawStringWithShadow(mobName, width / 2 + 4, height / 2 + 2, color);
            GL11.glPushMatrix();
            GL11.glEnable(3042);
            mc.getTextureManager().bindTexture(render.iconSheet);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glScalef(fontRender.FONT_HEIGHT / 8, fontRender.FONT_HEIGHT / 8, fontRender.FONT_HEIGHT / 8);
            mc.ingameGUI.drawTexturedModalRect(x + 4 + fontRender.getStringWidth(text), y, 52, 0, 8, 8);
            GL11.glDisable(3042);
            GL11.glPopMatrix();
        } else if (Setting.playerStyle == 2) {
            float f = player.getMaxHealth();
            float d = player.getHealth();
            String mobName = player.getName();
            int x = width / 2 - 25;
            int y = height / 2 + fontRender.FONT_HEIGHT * 2 + 4;
            Gui.drawRect(x - 1, y - 1, x + 52, y + fontRender.FONT_HEIGHT / 2 + 1, -16720640);
            Gui.drawRect(x, y, x + (int) (d / f * 50.0F), y + fontRender.FONT_HEIGHT / 2, -2293760);
            fontRender.drawStringWithShadow(mobName, width / 2 - fontRender.getStringWidth(mobName) / 2, height / 2 + fontRender.FONT_HEIGHT + 2, 0xFFFFFF);
        } else if (Setting.playerStyle == 3) {
            int cnt = (int) player.getHealth();
            int cntMax = (int) player.getMaxHealth();
            if (player.getMaxHealth() > Setting.maxHeartCount) {
                float d = player.getMaxHealth() / (float) Setting.maxHeartCount;
                cnt = (int) (player.getHealth() / d);
                cntMax = (int) (player.getMaxHealth() / d);
            }
            String mobName = player.getName();
            int x = width / 2 - cntMax * 5 / 2;
            int y = height / 2 + fontRender.FONT_HEIGHT * 2 + 4;
            fontRender.drawStringWithShadow(mobName, width / 2 - fontRender.getStringWidth(mobName) / 2, height / 2 + fontRender.FONT_HEIGHT + 2, 0xFFFFFF);
            GL11.glPushMatrix();
            GL11.glEnable(3042);
            mc.getTextureManager().bindTexture(render.iconSheet);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glScalef(fontRender.FONT_HEIGHT / 8, fontRender.FONT_HEIGHT / 8, fontRender.FONT_HEIGHT / 8);
            for (int i = 0; i < cntMax; i++) {
                mc.ingameGUI.drawTexturedModalRect(x + i * 5, y, 34, 0, 9, 9);
                if (i < cnt) mc.ingameGUI.drawTexturedModalRect(x + i * 5, y, 52, 0, 8, 8);
            }
            GL11.glDisable(3042);
            GL11.glPopMatrix();
        }
    }
}