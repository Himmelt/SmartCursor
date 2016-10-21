package com.asaskevich.smartcursor.modules.entity;

import com.asaskevich.smartcursor.api.IEntityProcessor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.util.StatCollector;

import java.util.List;

public class EntityAgeableModule implements IEntityProcessor {
    public void process(List<String> list, Entity entity) {
        if ((entity instanceof EntityAgeable)) {
            EntityAgeable age = (EntityAgeable) entity;
            if (age.getGrowingAge() < 0) {
                list.add(StatCollector.translateToLocal("smartcursor.mob.child") + Math.abs(age.getGrowingAge() / 20) + StatCollector.translateToLocal("smartcursor.mob.seconds"));
            }
        }
    }

    public String getModuleName() {
        return "Add growing time for entities";
    }

    public String getAuthor() {
        return "asaskevich";
    }
}