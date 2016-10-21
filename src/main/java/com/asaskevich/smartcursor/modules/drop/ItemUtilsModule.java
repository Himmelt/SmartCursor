package com.asaskevich.smartcursor.modules.drop;

import com.asaskevich.smartcursor.api.IDropProcessor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import java.util.List;

public class ItemUtilsModule implements IDropProcessor {
    public void process(List<String> list, ItemStack stack) {
        if (stack.isStackable()) {
            list.add(StatCollector.translateToLocal("smartcursor.item.stackable")
                    + (stack.getMaxStackSize() > 1 ? StatCollector.translateToLocal("smartcursor.item.in")
                    + stack.getMaxStackSize() + StatCollector.translateToLocal("smartcursor.item.items") : ""));
        }
        if (stack.isItemDamaged()) list.add(StatCollector.translateToLocal("smartcursor.item.isDamaged"));
        if (stack.isItemEnchantable()) list.add(StatCollector.translateToLocal("smartcursor.item.enchantable"));
        if (stack.getHasSubtypes()) list.add(StatCollector.translateToLocal("smartcursor.item.hasSubtypes"));
        if (stack.hasEffect()) list.add(StatCollector.translateToLocal("smartcursor.item.hasEffect"));
    }

    public String getModuleName() {
        return "Advanced information about items";
    }

    public String getAuthor() {
        return "asaskevich";
    }
}