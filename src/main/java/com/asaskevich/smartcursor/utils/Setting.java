package com.asaskevich.smartcursor.utils;

import net.minecraftforge.common.config.Configuration;

public class Setting {
    public static boolean isEnabled = true;
    public static boolean showDropInformation = true;
    public static boolean showEnchantments = true;
    public static boolean showDurability = true;
    public static boolean showXPOrb = true;
    public static boolean displayAdvInfoMob = true;
    public static boolean showPlayerInformation = true;
    public static boolean showBlockInformation = true;
    public static boolean showTooltipInRightCorner = false;
    public static int blockDamageStyle = 0;
    public static int mobStyle = 0;
    public static int dropStyle = 0;
    public static int playerStyle = 0;
    public static int transparent = 100;
    public static int delta = 1000;
    public static double lookDistance = 20.0D;
    public static double maxHeartCount = 15.0D;

    public static void syncConfig(Configuration config) {
        blockDamageStyle = config.getInt("Block Damage Style", "general", blockDamageStyle, 0, 2, "Block Damage Style");
        delta = config.getInt("Display Time", "general", delta, 0, 5000, "Display Time");
        transparent = config.getInt("Tooltip Transparent", "general", transparent, 0, 255, "Transparent Of Tooltip");
        mobStyle = config.getInt("Style Of Mob Indicator", "general", mobStyle, 0, 3, "Style Of Mob Indicator");
        playerStyle = config.getInt("Style Of Player Indicator", "general", playerStyle, 0, 3, "Style Of Player Indicator");
        lookDistance = config.getFloat("Look Distance", "general", (float) lookDistance, 1.0F, 100.0F, "Look Distance");
        dropStyle = config.getInt("Style Of Drop Indicator", "general", dropStyle, 0, 1, "Style Of Drop Indicator");
        maxHeartCount = config.getFloat("Max Heart Count", "general", (float) maxHeartCount, 5.0F, 50.0F, "Max Heart Count");
        isEnabled = config.getBoolean("Is Enabled", "general", isEnabled, "Is Enabled");
        showDropInformation = config.getBoolean("Is Drop Indicator Enabled", "general", showDropInformation, "Is Drop Indicator Enabled");
        showEnchantments = config.getBoolean("Is Ench Indicator Enabled", "general", showEnchantments, "Is Ench Indicator Enabled");
        showDurability = config.getBoolean("Is Durability Indicator Enabled", "general", showDurability, "Is Durability Indicator Enabled");
        showXPOrb = config.getBoolean("Is XPorb Indicator Enabled", "general", showXPOrb, "Is XPorb Indicator Enabled");
        displayAdvInfoMob = config.getBoolean("Is Advanced Mob Indicator Enabled", "general", displayAdvInfoMob, "Is Advanced Mob Indicator Enabled");
        showPlayerInformation = config.getBoolean("Is Player Indicator Enabled", "general", showPlayerInformation, "Is Player Indicator Enabled");
        showBlockInformation = config.getBoolean("Is Block Indicator Enabled", "general", showBlockInformation, "Is Block Indicator Enabled");
        showTooltipInRightCorner = config.getBoolean("Show Tooltip In Right Corner", "general", showTooltipInRightCorner, "Show Tooltip In Right Corner");
        if (config.hasChanged()) config.save();
    }

    public static void updateSettings(Configuration config) {
        config.load();
        config.get("general", "Block Damage Style", blockDamageStyle).set(blockDamageStyle);
        config.get("general", "Tooltip Transparent", transparent).set(transparent);
        config.get("general", "Style Of Mob Indicator", mobStyle).set(mobStyle);
        config.get("general", "Style Of Player Indicator", playerStyle).set(playerStyle);
        config.get("general", "Look Distance", lookDistance).set(lookDistance);
        config.get("general", "Style Of Drop Indicator", dropStyle).set(dropStyle);
        config.get("general", "Max Heart Count", maxHeartCount).set(maxHeartCount);
        config.get("general", "Is Enabled", isEnabled).set(isEnabled);
        config.get("general", "Is Drop Indicator Enabled", showDropInformation).set(showDropInformation);
        config.get("general", "Is Ench Indicator Enabled", showEnchantments).set(showEnchantments);
        config.get("general", "Is Durability Indicator Enabled", showDurability).set(showDurability);
        config.get("general", "Is XPorb Indicator Enabled", showXPOrb).set(showXPOrb);
        config.get("general", "Is Advanced Mob Indicator Enabled", displayAdvInfoMob).set(displayAdvInfoMob);
        config.get("general", "Is Player Indicator Enabled", showPlayerInformation).set(showPlayerInformation);
        config.get("general", "Is Block Indicator Enabled", showBlockInformation).set(showBlockInformation);
        config.get("general", "Show Tooltip In Right Corner", showTooltipInRightCorner).set(showTooltipInRightCorner);
        config.get("general", "Display Time", delta).set(delta);
        config.save();
    }
}