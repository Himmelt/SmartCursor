package com.asaskevich.smartcursor;

import com.asaskevich.smartcursor.keyboard.KeyBindler;
import com.asaskevich.smartcursor.keyboard.KeyInputHandler;
import com.asaskevich.smartcursor.proxy.CommonProxy;
import com.asaskevich.smartcursor.utils.Setting;
import com.asaskevich.smartcursor.utils.UpdateManager;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(
        modid = "SmartCursor",
        name = "SmartCursor",
        version = "1.5.1",
        canBeDeactivated = true,
        guiFactory = "com.asaskevich.smartcursor.gui.GUIFactory",
        acceptedMinecraftVersions = "[1.8.9]"
)
@SideOnly(Side.CLIENT)
public class SmartCursor {
    public static CommonProxy proxy;
    public static RenderHandler renderHandler;
    public static KeyInputHandler keyInputHandler;
    public static Minecraft mc;
    public static Configuration config;
    @Mod.Instance("SmartCursor")
    public static SmartCursor instance;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        config = new Configuration(event.getSuggestedConfigurationFile());
        Setting.syncConfig(config);
        mc = Minecraft.getMinecraft();
        renderHandler = new RenderHandler(mc);
        keyInputHandler = new KeyInputHandler(renderHandler);
        KeyBindler.init();
        MinecraftForge.EVENT_BUS.register(renderHandler);
        MinecraftForge.EVENT_BUS.register(new Modules());
        MinecraftForge.EVENT_BUS.register(new UpdateManager());
        MinecraftForge.EVENT_BUS.register(keyInputHandler);
        MinecraftForge.EVENT_BUS.register(instance);
        Plugins.init();
        Modules.loadConfig(config);
    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event) {
    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event) {
    }

    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
        if (eventArgs.modID.equals("SmartCursor")) Setting.syncConfig(config);
    }
}