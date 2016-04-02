package com.asaskevich.smartcursor;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import org.lwjgl.opengl.GL11;
import scala.tools.nsc.doc.model.Def;
public class RenderHelper {
    public static void drawRect(int x, int y, int p_73734_2_, int p_73734_3_, int p_73734_4_, int transparent) {
        if (x < p_73734_2_) {
            int j1 = x;
            x = p_73734_2_;
            p_73734_2_ = j1;
        }
        if (y < p_73734_3_) {
            int j1 = y;
            y = p_73734_3_;
            p_73734_3_ = j1;
        }
        float f3 = transparent / 255.0F;
        float f = (p_73734_4_ >> 16 & 0xFF) / 255.0F;
        float f1 = (p_73734_4_ >> 8 & 0xFF) / 255.0F;
        float f2 = (p_73734_4_ & 0xFF) / 255.0F;
        Tessellator tessellator = Tessellator.getInstance();
        VertexBuffer renderer = tessellator.getBuffer();
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        GL11.glColor4f(f, f1, f2, f3);
        renderer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        renderer.pos(x, p_73734_3_, 0.0D);
        renderer.pos(p_73734_2_, p_73734_3_, 0.0D);
        renderer.pos(p_73734_2_, y, 0.0D);
        renderer.pos(x, y, 0.0D);
        tessellator.draw();
        GL11.glEnable(3553);
        GL11.glDisable(3042);
    }
}