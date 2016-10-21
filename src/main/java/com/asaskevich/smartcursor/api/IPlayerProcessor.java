package com.asaskevich.smartcursor.api;

import net.minecraft.entity.player.EntityPlayer;

import java.util.List;

public interface IPlayerProcessor
        extends IModule {
    void process(List<String> paramList, EntityPlayer paramEntityPlayer);
}