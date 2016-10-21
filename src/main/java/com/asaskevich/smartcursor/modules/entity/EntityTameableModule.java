package com.asaskevich.smartcursor.modules.entity;

import com.asaskevich.smartcursor.api.IEntityProcessor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.util.StatCollector;

import java.util.List;

public class EntityTameableModule implements IEntityProcessor {
    public void process(List<String> list, Entity entity) {
        if ((entity instanceof EntityTameable)) {
            EntityTameable tame = (EntityTameable) entity;
            if (tame.isTamed()) {
                if (tame.getOwner() != null)
                    list.add(StatCollector.translateToLocal("smartcursor.mob.tamedBy") + tame.getOwner().getName());
                else
                    list.add(StatCollector.translateToLocal("smartcursor.mob.tamed"));
            } else list.add(StatCollector.translateToLocal("smartcursor.mob.notTamed"));
            if (tame.isSitting()) {
                list.add(StatCollector.translateToLocal("smartcursor.mob.isSitting"));
            }
        }
    }

    public String getModuleName() {
        return "Tameable mobs";
    }

    public String getAuthor() {
        return "asaskevich";
    }
}