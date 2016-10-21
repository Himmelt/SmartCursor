package com.asaskevich.smartcursor.modules.entity;

import com.asaskevich.smartcursor.api.IEntityProcessor;
import net.minecraft.entity.Entity;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.IShearable;

import java.util.List;

public class EntityShearableModule implements IEntityProcessor {
    public String getModuleName() {
        return "Is entity shearable";
    }

    public String getAuthor() {
        return "asaskevich";
    }

    public void process(List<String> list, Entity entity) {
        if ((entity instanceof IShearable)) {
            list.add(StatCollector.translateToLocal("smartcursor.block.shearable"));
        }
    }
}