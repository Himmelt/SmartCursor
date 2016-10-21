package com.asaskevich.smartcursor.utils;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameData;

public class ModIdentification {
    public static String nameFromStack(ItemStack stack) {
        try {
            ResourceLocation location = GameData.getItemRegistry().getNameForObject(stack.getItem());
            String mod = location.getResourceDomain();
            return (mod == null) || (!Loader.isModLoaded(mod)) || (mod.equalsIgnoreCase("Minecraft")) ? "Minecraft" : mod;
        } catch (NullPointerException e) {
        }
        return "";
    }
}