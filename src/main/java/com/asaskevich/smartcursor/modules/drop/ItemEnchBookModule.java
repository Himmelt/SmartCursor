package com.asaskevich.smartcursor.modules.drop;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemEnchantedBook;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

import java.util.List;

public class ItemEnchBookModule implements com.asaskevich.smartcursor.api.IDropProcessor {
    public void process(List<String> list, ItemStack stack) {
        if ((stack.getItem() instanceof ItemEnchantedBook)) {
            ItemEnchantedBook book = (ItemEnchantedBook) stack.getItem();
            list.add(EnumChatFormatting.GRAY + StatCollector.translateToLocal("smartcursor.item.enchBook")
                    + EnumChatFormatting.RESET);
            NBTTagList nbttaglist = book.getEnchantments(stack);
            if (nbttaglist != null) {
                for (int i = 0; i < nbttaglist.tagCount(); i++) {
                    short short1 = nbttaglist.getCompoundTagAt(i).getShort("id");
                    short short2 = nbttaglist.getCompoundTagAt(i).getShort("lvl");
                    if (Enchantment.getEnchantmentById(short1) != null) {
                        list.add(" * " + Enchantment.getEnchantmentById(short1).getTranslatedName(short2));
                    }
                }
            }
        }
    }

    public String getModuleName() {
        return "Display all enchantments for enchanted book";
    }

    public String getAuthor() {
        return "asaskevich";
    }
}