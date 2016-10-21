package com.asaskevich.smartcursor.api;

import net.minecraft.item.ItemStack;

import java.util.List;

public interface IDropProcessor
        extends IModule {
    void process(List<String> paramList, ItemStack paramItemStack);
}