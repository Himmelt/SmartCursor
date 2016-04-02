package com.asaskevich.smartcursor.modules.entity;
import com.asaskevich.smartcursor.api.IEntityProcessor;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
public class EntityEquipmentModule implements IEntityProcessor {
    public void process(List<String> list, Entity entity) {
        if ((entity instanceof EntityCreature))
        {
            EntityCreature cre = (EntityCreature)entity;
            Iterable<ItemStack> items = cre.getEquipmentAndArmor();
            boolean h = false;
            for (ItemStack item : items) {
                if (item != null) {
                    h = true;
                }
            }
            if (h)
            {
                list.add(TextFormatting.GRAY + I18n.translateToLocal("smartcursor.player.equipment"));
                for (ItemStack item : items) {
                    if (item != null) {
                        list.add(" * " + item.getDisplayName() + TextFormatting.GOLD + (item.isItemEnchanted() ? I18n.translateToLocal("smartcursor.player.ench") : ""));
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