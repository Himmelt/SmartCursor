package com.asaskevich.smartcursor;
import com.asaskevich.smartcursor.api.IBlockProcessor;
import com.asaskevich.smartcursor.api.IDropProcessor;
import com.asaskevich.smartcursor.api.IEntityProcessor;
import com.asaskevich.smartcursor.api.IModule;
import com.asaskevich.smartcursor.api.IPlayerProcessor;
import com.asaskevich.smartcursor.api.ModuleConnector;
import java.util.ArrayList;
import java.util.HashMap;
import net.minecraftforge.common.config.Configuration;
public class Modules {
    public static ArrayList<IEntityProcessor> entityModules = new ArrayList();
    public static ArrayList<IPlayerProcessor> playerModules = new ArrayList();
    public static ArrayList<IBlockProcessor> blockModules = new ArrayList();
    public static ArrayList<IDropProcessor> dropModules = new ArrayList();
    public static HashMap<String, Boolean> moduleStatus = new HashMap();
    public static void registerModule(IEntityProcessor module) {
        entityModules.add(module);
        moduleStatus.put(module.getClass().getCanonicalName(), Boolean.valueOf(true));
    }
    public static void registerModule(IPlayerProcessor module) {
        playerModules.add(module);
        moduleStatus.put(module.getClass().getCanonicalName(), Boolean.valueOf(true));
    }
    public static void registerModule(IBlockProcessor module) {
        blockModules.add(module);
        moduleStatus.put(module.getClass().getCanonicalName(), Boolean.valueOf(true));
    }
    public static void registerModule(IDropProcessor module) {
        dropModules.add(module);
        moduleStatus.put(module.getClass().getCanonicalName(), Boolean.valueOf(true));
    }
    public static void switchModule(String canonicalName) {
        if (!moduleStatus.containsKey(canonicalName)) moduleStatus.put(canonicalName, Boolean.valueOf(true));
        boolean status = ((Boolean) moduleStatus.get(canonicalName)).booleanValue();
        moduleStatus.put(canonicalName, Boolean.valueOf(!status));
        syncConfig(SmartCursor.config);
    }
    public static boolean isActiveModule(String canonicalName) {
        if (!moduleStatus.containsKey(canonicalName)) moduleStatus.put(canonicalName, Boolean.valueOf(true));
        return (moduleStatus.containsKey(canonicalName)) && (((Boolean) moduleStatus.get(canonicalName)).booleanValue());
    }
    public static void syncConfig(Configuration config) {
        config.load();
        for (String key : moduleStatus.keySet()) {
            boolean status = isActiveModule(key);
            config.get("modules", key, status).set(status);
        }
        config.save();
    }
    public static void loadConfig(Configuration config) {
        for (String key : moduleStatus.keySet()) {
            boolean status = config.getBoolean(key, "modules", true, key);
            moduleStatus.put(key, Boolean.valueOf(status));
        }
    }
    @net.minecraftforge.fml.common.eventhandler.SubscribeEvent
    public void onRegisterModule(ModuleConnector event) {
        IModule module = event.getModule();
        switch (event.getType()) {
            case 0:
                registerModule((IEntityProcessor) module);
                break;
            case 3:
                registerModule((IBlockProcessor) module);
                break;
            case 2:
                registerModule((IDropProcessor) module);
                break;
            case 1:
                registerModule((IPlayerProcessor) module);
        }
    }
}