package com.asaskevich.smartcursor;

import com.asaskevich.smartcursor.api.ModuleConnector;
import com.asaskevich.smartcursor.modules.block.BlockChestModule;
import com.asaskevich.smartcursor.modules.block.BlockGrowableModule;
import com.asaskevich.smartcursor.modules.block.BlockHarvestModule;
import com.asaskevich.smartcursor.modules.block.BlockModIdentificatorModule;
import com.asaskevich.smartcursor.modules.drop.*;
import com.asaskevich.smartcursor.modules.entity.*;
import com.asaskevich.smartcursor.modules.player.PlayerScoreModule;
import com.asaskevich.smartcursor.modules.player.PlayerTeamModule;

public class Plugins {
    public static void init() {
        ModuleConnector.connectModule(new BlockHarvestModule());
        ModuleConnector.connectModule(new ItemEnchBookModule());
        ModuleConnector.connectModule(new ItemEnchModule());
        ModuleConnector.connectModule(new ItemFoodModule());
        ModuleConnector.connectModule(new ItemUtilsModule());
        ModuleConnector.connectModule(new com.asaskevich.smartcursor.modules.player.PlayerEquipmentModule());
        ModuleConnector.connectModule(new PlayerScoreModule());
        ModuleConnector.connectModule(new PlayerTeamModule());
        ModuleConnector.connectModule(new EntityAgeableModule());
        ModuleConnector.connectModule(new EntityEquipmentModule());
        ModuleConnector.connectModule(new EntityHorseModule());
        ModuleConnector.connectModule(new EntityTameableModule());
        ModuleConnector.connectModule(new EntityUtilsModule());
        ModuleConnector.connectModule(new EntityVillagerModule());
        ModuleConnector.connectModule(new BlockChestModule());
        ModuleConnector.connectModule(new BlockGrowableModule());
        ModuleConnector.connectModule(new com.asaskevich.smartcursor.modules.block.BlockShearableModule());
        ModuleConnector.connectModule(new EntityShearableModule());
        ModuleConnector.connectModule(new BlockModIdentificatorModule());
        ModuleConnector.connectModule(new ItemModIdentificationModule());
    }
}