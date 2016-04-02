package com.asaskevich.smartcursor.modules.entity;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.scoreboard.Team;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
public class EntityUtilsModule implements com.asaskevich.smartcursor.api.IEntityProcessor {
    public void process(List<String> list, Entity e) {
        EntityLiving entity = (EntityLiving) e;
        if (entity.getTeam() != null)
            list.add(I18n.translateToLocal("smartcursor.player.team") + entity.getTeam().getRegisteredName());
        if (entity.isWet()) list.add(I18n.translateToLocal("smartcursor.mob.isWet"));
        if (entity.isSprinting()) list.add(I18n.translateToLocal("smartcursor.mob.isSprinting"));
        if (entity.isRiding()) list.add(I18n.translateToLocal("smartcursor.mob.isRiding"));
        if (entity.isBurning()) {
            list.add(I18n.translateToLocal("smartcursor.mob.isBurning"));
        }
        if (entity.isEntityUndead()) list.add(I18n.translateToLocal("smartcursor.mob.isUndead"));
        if (entity.isImmuneToFire()) list.add(I18n.translateToLocal("smartcursor.mob.isImmuneToFire"));
        if (((entity instanceof EntityMob)) || ((entity instanceof IMob))) {
            list.add(TextFormatting.RED + I18n.translateToLocal("smartcursor.mob.isAgressive"));
        } else if ((entity instanceof EntityAnimal)) {
            list.add(TextFormatting.GREEN + I18n.translateToLocal("smartcursor.mob.isPassive"));
        }
    }
    public String getModuleName() {
        return "Some utilitary info for mobs";
    }
    public String getAuthor() {
        return "asaskevich";
    }
}