package com.asaskevich.smartcursor.api;

import net.minecraft.entity.Entity;

import java.util.List;

public interface IEntityProcessor
        extends IModule {
    void process(List<String> paramList, Entity paramEntity);
}