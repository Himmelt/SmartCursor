package com.asaskevich.smartcursor.modules.entity;

import com.asaskevich.smartcursor.api.IEntityProcessor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

import java.util.ArrayList;
import java.util.List;

public class EntityEquipmentModule implements IEntityProcessor {
    public void process(List<String> list, Entity entity) {
        if ((entity instanceof EntityCreature)) {
            EntityCreature creature = (EntityCreature) entity;
            //Iterable<ItemStack> items = creature.getEquipmentAndArmor();
            List<ItemStack> equips = new ArrayList<ItemStack>();
            equips.add(creature.getEquipmentInSlot(0));
            equips.add(creature.getEquipmentInSlot(1));
            equips.add(creature.getEquipmentInSlot(2));
            equips.add(creature.getEquipmentInSlot(3));
            equips.add(creature.getEquipmentInSlot(4));
            boolean h = false;
            for (ItemStack item : equips) {
                if (item != null) {
                    h = true;
                }
            }
            if (h) {
                list.add(EnumChatFormatting.GRAY + StatCollector.translateToLocal("smartcursor.player.equipment"));
                for (ItemStack item : equips) {
                    if (item != null) {
                        list.add(" * " + item.getDisplayName() + EnumChatFormatting.GOLD + (item.isItemEnchanted() ? StatCollector.translateToLocal("smartcursor.player.ench") : ""));
                    }
                }
            }
        }
    }

    public String getModuleName() {
        return "Equipment of mob";
    }

    public String getAuthor() {
        return "asaskevich";
    }
}