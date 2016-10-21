package com.asaskevich.smartcursor.api;

public class ModuleConnector extends net.minecraftforge.fml.common.eventhandler.Event {
    public static final int ENTITY_PROCESSOR = 0;
    public static final int PLAYER_PROCESSOR = 1;
    public static final int DROP_PROCESSOR = 2;
    public static final int BLOCK_PROCESSOR = 3;
    private IModule module;
    private int type;

    public ModuleConnector(IEntityProcessor module) {
        this.module = module;
        type = 0;
    }

    public ModuleConnector(IPlayerProcessor module) {
        this.module = module;
        type = 1;
    }

    public ModuleConnector(IDropProcessor module) {
        this.module = module;
        type = 2;
    }

    public ModuleConnector(IBlockProcessor module) {
        this.module = module;
        type = 3;
    }

    public static void connectModule(IEntityProcessor module) {
        net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new ModuleConnector(module));
    }

    public static void connectModule(IPlayerProcessor module) {
        net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new ModuleConnector(module));
    }

    public static void connectModule(IDropProcessor module) {
        net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new ModuleConnector(module));
    }

    public static void connectModule(IBlockProcessor module) {
        net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new ModuleConnector(module));
    }

    public IModule getModule() {
        return module;
    }

    public int getType() {
        return type;
    }
}