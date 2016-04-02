package com.asaskevich.smartcursor.render;
import com.asaskevich.smartcursor.Modules;
import com.asaskevich.smartcursor.RenderHandler;
import com.asaskevich.smartcursor.RenderHelper;
import com.asaskevich.smartcursor.api.IEntityProcessor;
import com.asaskevich.smartcursor.utils.Setting;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.text.TextFormatting;
import org.lwjgl.opengl.GL11;
public class RenderEntity {
    public Minecraft mc;
    public int width;
    public int height;
    public RenderEntity() {
        mc = Minecraft.getMinecraft();
        width = mc.displayWidth;
        height = mc.displayHeight;
    }
    public void render(EntityLiving entity, RenderHandler render) {
        ScaledResolution res = new ScaledResolution(mc);
        FontRenderer fontRender = mc.fontRendererObj;
        width = res.getScaledWidth();
        height = res.getScaledHeight();
        mc.entityRenderer.setupOverlayRendering();
        if ((Setting.mobStyle != 3) && (Setting.displayAdvInfoMob)) {
            int color = 0xFFFFFF;
            int x = 4;
            int y = 4;
            List<String> list = new ArrayList();
            list.add("");
            for (IEntityProcessor module : Modules.entityModules) {
                if (Modules.isActiveModule(module.getClass().getCanonicalName())) module.process(list, entity);
            }
            String text = String.format(TextFormatting.BOLD + "" + TextFormatting.GOLD + "%s:" + TextFormatting.RESET + " %d/%d", new Object[]{entity.getName(), Integer.valueOf((int) entity.getHealth()), Integer.valueOf((int) entity.getMaxHealth())});
            int maxW = fontRender.getStringWidth(text) + 16;
            for (int i = 1; i < list.size(); i++)
                maxW = Math.max(maxW, fontRender.getStringWidth((String) list.get(i)) + 8);
            if (Setting.showTooltipInRightCorner) {
                x = width - maxW;
            }
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
                fontRender.drawStringWithShadow((String) list.get(i), x, y + fontRender.FONT_HEIGHT * i, color);
            fontRender.drawStringWithShadow(text, x, y, color);
        }
        if (Setting.mobStyle == 0) {
            int color = 0xFFFFFF;
            int x = width / 2 + 4;
            int y = height / 2 - 2 - fontRender.FONT_HEIGHT;
            String text = String.format("%.0fx", new Object[]{Float.valueOf(entity.getHealth())});
            String mobName = entity.getName();
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
        } else if (Setting.mobStyle == 1) {
            float f = entity.getMaxHealth();
            float d = entity.getHealth();
            String mobName = entity.getName();
            int x = width / 2 - 25;
            int y = height / 2 + fontRender.FONT_HEIGHT * 2 + 4;
            Gui.drawRect(x - 1, y - 1, x + 52, y + fontRender.FONT_HEIGHT / 2 + 1, -16720640);
            Gui.drawRect(x, y, x + (int) (d / f * 50.0F), y + fontRender.FONT_HEIGHT / 2, -2293760);
            fontRender.drawStringWithShadow(mobName, width / 2 - fontRender.getStringWidth(mobName) / 2, height / 2 + fontRender.FONT_HEIGHT + 2, 0xFFFFFF);
        } else if (Setting.mobStyle == 2) {
            int cnt = (int) entity.getHealth();
            int cntMax = (int) entity.getMaxHealth();
            if (entity.getMaxHealth() > Setting.maxHeartCount) {
                float d = entity.getMaxHealth() / (float) Setting.maxHeartCount;
                cnt = (int) (entity.getHealth() / d);
                cntMax = (int) (entity.getMaxHealth() / d);
            }
            String mobName = entity.getName();
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