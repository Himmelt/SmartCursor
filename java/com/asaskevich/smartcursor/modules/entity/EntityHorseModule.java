package com.asaskevich.smartcursor.modules.entity;
import com.asaskevich.smartcursor.api.IEntityProcessor;
import com.asaskevich.smartcursor.utils.Utils;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.util.text.translation.I18n;
public class EntityHorseModule implements IEntityProcessor {
    public void process(List<String> list, Entity entity) {
        if ((entity instanceof EntityHorse)) {
            EntityHorse horse = (EntityHorse) entity;
            list.add(I18n.translateToLocal("smartcursor.mob.jumpStrength") + String.format("%.3f", new Object[]{Double.valueOf(Utils.round(horse.getHorseJumpStrength(), 4))}));
            list.add(I18n.translateToLocal("smartcursor.mob.horseSpeed") + String.format("%.3f", new Object[]{Double.valueOf(Utils.round(horse.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue(), 4))}));
            if (horse.isTame()) list.add(I18n.translateToLocal("smartcursor.mob.tamed"));
            else {
                list.add(I18n.translateToLocal("smartcursor.mob.notTamed"));
            }
        }
    }
    public String getModuleName() {
        return "Horses - speed, jump strength etc";
    }
    public String getAuthor() {
        return "asaskevich";
    }
}