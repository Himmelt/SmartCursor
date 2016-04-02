package com.asaskevich.smartcursor.gui;
import java.util.Set;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.client.IModGuiFactory.RuntimeOptionCategoryElement;
import net.minecraftforge.fml.client.IModGuiFactory.RuntimeOptionGuiHandler;
public class GUIFactory implements IModGuiFactory {
    public void initialize(Minecraft minecraftInstance) {
    }
    public Class<? extends GuiScreen> mainConfigGuiClass() {
        return ConfigGUI.class;
    }
    public Set<IModGuiFactory.RuntimeOptionCategoryElement> runtimeGuiCategories() {
        return null;
    }
    public IModGuiFactory.RuntimeOptionGuiHandler getHandlerFor(IModGuiFactory.RuntimeOptionCategoryElement element) {
        return null;
    }
}