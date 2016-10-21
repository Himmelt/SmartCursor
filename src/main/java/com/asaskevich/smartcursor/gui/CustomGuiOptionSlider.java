package com.asaskevich.smartcursor.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
public class CustomGuiOptionSlider extends GuiButton {
    private final float minValue;
    private final float maxValue;
    public boolean someThing;
    public float value = 0.0F;
    private float currentValue;
    private String label;
    private GuiAdvancedSettings gui;

    public CustomGuiOptionSlider(int id, int posX, int posY) {
        this(id, posX, posY, 0.0F, 1.0F);
    }

    public CustomGuiOptionSlider(int id, int posX, int posY, float minValue, float maxValue) {
        super(id, posX, posY, 150, 20, "");
        currentValue = 1.0F;
        this.minValue = minValue;
        this.maxValue = maxValue;
        displayString = "";
    }

    public CustomGuiOptionSlider(int id, int posX, int posY, int sizeX, int sizeY, String text, float minValue, float maxValue, float step, float initValue, GuiAdvancedSettings gui) {
        super(id, posX, posY, sizeX, sizeY, "");
        this.minValue = minValue;
        this.maxValue = maxValue;
        label = text;
        value = initValue;
        currentValue = ((value - minValue) / (maxValue - minValue));
        displayString = (text + ": " + (int) value);
        someThing = false;
        mouseDragged(Minecraft.getMinecraft(), posX + (int) (sizeX * currentValue), posY);
        this.gui = gui;
    }

    public int getHoverState(boolean p_146114_1_) {
        return 0;
    }

    protected void mouseDragged(Minecraft p_146119_1_, int p_146119_2_, int p_146119_3_) {
        if (someThing) {
            currentValue = ((p_146119_2_ - (xPosition + 4)) / (width - 8));
            if (currentValue < 0.0F) {
                currentValue = 0.0F;
            }
            if (currentValue > 1.0F) {
                currentValue = 1.0F;
            }
            value = ((maxValue - minValue) * currentValue + minValue);
            displayString = (label + ": " + (int) value);
        }
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        drawTexturedModalRect(xPosition + (int) (currentValue * (width - 8)), yPosition, 0, 66, 4, 20);
        drawTexturedModalRect(xPosition + (int) (currentValue * (width - 8)) + 4, yPosition, 196, 66, 4, 20);
    }

    public boolean mousePressed(Minecraft p_146116_1_, int p_146116_2_, int p_146116_3_) {
        if (super.mousePressed(p_146116_1_, p_146116_2_, p_146116_3_)) {
            currentValue = ((p_146116_2_ - (xPosition + 4)) / (width - 8));
            if (currentValue < 0.0F) {
                currentValue = 0.0F;
            }
            if (currentValue > 1.0F) {
                currentValue = 1.0F;
            }
            value = ((maxValue - minValue) * currentValue + minValue);
            displayString = (label + ": " + (int) value);
            someThing = true;
            return true;
        }
        return false;
    }

    public void mouseReleased(int x, int y) {
        someThing = false;
        gui.updateSettings(this);
    }
}