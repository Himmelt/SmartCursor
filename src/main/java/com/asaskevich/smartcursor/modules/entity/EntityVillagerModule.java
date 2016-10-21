package com.asaskevich.smartcursor.modules.entity;

import com.asaskevich.smartcursor.api.IEntityProcessor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.util.StatCollector;

import java.util.List;

public class EntityVillagerModule implements IEntityProcessor {
    public void process(List<String> list, Entity entity) {
        if ((entity instanceof EntityVillager)) {
            EntityVillager villager = (EntityVillager) entity;
            switch (villager.getProfession()) {
                case 0:
                    list.add(StatCollector.translateToLocal("smartcursor.mob.profession_0"));
                    break;
                case 1:
                    list.add(StatCollector.translateToLocal("smartcursor.mob.profession_1"));
                    break;
                case 2:
                    list.add(StatCollector.translateToLocal("smartcursor.mob.profession_2"));
                    break;
                case 3:
                    list.add(StatCollector.translateToLocal("smartcursor.mob.profession_3"));
                    break;
                case 4:
                    list.add(StatCollector.translateToLocal("smartcursor.mob.profession_4"));
                    break;
                default:
                    list.add(StatCollector.translateToLocal("smartcursor.mob.profession"));
            }
            if (villager.isTrading()) {
                list.add(StatCollector.translateToLocal("smartcursor.mob.trade"));
            }
        }
    }

    public String getModuleName() {
        return "Villager's profession";
    }

    public String getAuthor() {
        return "asaskevich";
    }
}