package com.asaskevich.smartcursor.modules.entity;
import com.asaskevich.smartcursor.api.IEntityProcessor;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.util.text.translation.I18n;
public class EntityAgeableModule implements IEntityProcessor {
    public void process(List<String> list, Entity entity) {
        if ((entity instanceof EntityAgeable)) {
            EntityAgeable age = (EntityAgeable) entity;
            if (age.getGrowingAge() < 0) {
                list.add(I18n.translateToLocal("smartcursor.mob.child") + Math.abs(age.getGrowingAge() / 20) + I18n.translateToLocal("smartcursor.mob.seconds"));
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