package com.asaskevich.smartcursor.modules.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

import java.util.List;

public class EntityUtilsModule implements com.asaskevich.smartcursor.api.IEntityProcessor {
    public void process(List<String> list, Entity e) {
        EntityLiving entity = (EntityLiving) e;
        if (entity.getTeam() != null)
            list.add(StatCollector.translateToLocal("smartcursor.player.team") + entity.getTeam().getRegisteredName());
        if (entity.isWet()) list.add(StatCollector.translateToLocal("smartcursor.mob.isWet"));
        if (entity.isSprinting()) list.add(StatCollector.translateToLocal("smartcursor.mob.isSprinting"));
        if (entity.isRiding()) list.add(StatCollector.translateToLocal("smartcursor.mob.isRiding"));
        if (entity.isBurning()) {
            list.add(StatCollector.translateToLocal("smartcursor.mob.isBurning"));
        }
        if (entity.isEntityUndead()) list.add(StatCollector.translateToLocal("smartcursor.mob.isUndead"));
        if (entity.isImmuneToFire()) list.add(StatCollector.translateToLocal("smartcursor.mob.isImmuneToFire"));
        if (((entity instanceof EntityMob)) || ((entity instanceof IMob))) {
            list.add(EnumChatFormatting.RED + StatCollector.translateToLocal("smartcursor.mob.isAgressive"));
        } else if ((entity instanceof EntityAnimal)) {
            list.add(EnumChatFormatting.GREEN + StatCollector.translateToLocal("smartcursor.mob.isPassive"));
        }
    }

    public String getModuleName() {
        return "Some utilitary info for mobs";
    }

    public String getAuthor() {
        return "asaskevich";
    }
}