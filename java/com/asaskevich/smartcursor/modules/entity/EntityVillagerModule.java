package com.asaskevich.smartcursor.modules.entity;
import com.asaskevich.smartcursor.api.IEntityProcessor;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.util.text.translation.I18n;
public class EntityVillagerModule implements IEntityProcessor {
    public void process(List<String> list, Entity entity) {
        if ((entity instanceof EntityVillager)) {
            EntityVillager villager = (EntityVillager) entity;
            switch (villager.getProfession()) {
                case 0:
                    list.add(I18n.translateToLocal("smartcursor.mob.profession_0"));
                    break;
                case 1:
                    list.add(I18n.translateToLocal("smartcursor.mob.profession_1"));
                    break;
                case 2:
                    list.add(I18n.translateToLocal("smartcursor.mob.profession_2"));
                    break;
                case 3:
                    list.add(I18n.translateToLocal("smartcursor.mob.profession_3"));
                    break;
                case 4:
                    list.add(I18n.translateToLocal("smartcursor.mob.profession_4"));
                    break;
                default:
                    list.add(I18n.translateToLocal("smartcursor.mob.profession"));
            }
            if (villager.isTrading()) {
                list.add(I18n.translateToLocal("smartcursor.mob.trade"));
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