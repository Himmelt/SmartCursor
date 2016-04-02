package com.asaskevich.smartcursor.gui;
import java.util.LinkedList;
import net.minecraft.client.gui.GuiMainMenu;
public class NewYearGuiMainMenu extends GuiMainMenu {
    LinkedList<Snow> snow = new LinkedList();
    public int posX;
    public int color;
    public void initGui() {
        super.initGui();
        snow.clear();
        posX = -100;
        color = ((int) (21474.0D * Math.random()) + 100000);
    }
    public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
        super.drawScreen(p_73863_1_, p_73863_2_, p_73863_3_);
        for (int i = 0; i < (1000 - snow.size()) * Math.random(); i++)
            snow.add(new Snow(width));
        for (int i = 0; i < snow.size(); i++) {
            Snow s = snow.get(i);
            s.moveDraw(height);
            drawString(fontRendererObj, "*", s.x, s.y, -1);
        }
        for (int i = snow.size() - 1; i >= 0; i--)
            if ((snow.get(i).lifeTime > 500) || (Math.random() < 0.015D)) snow.remove(i);
        drawString(fontRendererObj, "Happy New Year!", posX, 10, color);
        posX += 1;
        if (posX > width + 5) {
            posX = -40;
            color = ((int) (21474.0D * Math.random()));
        }
    }
}