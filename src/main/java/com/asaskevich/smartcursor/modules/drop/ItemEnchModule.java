package com.asaskevich.smartcursor.modules.drop;

import com.asaskevich.smartcursor.api.IDropProcessor;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

import java.util.List;

public class ItemEnchModule implements IDropProcessor {
    public void process(List<String> list, ItemStack stack) {
        if (stack.isItemEnchanted()) {
            list.add(EnumChatFormatting.GRAY + StatCollector.translateToLocal("smartcursor.item.enchItem"));
            NBTTagList enchs = stack.getEnchantmentTagList();
            if (enchs != null) {
                for (int i = 0; i < enchs.tagCount(); i++) {
                    NBTTagCompound tag = enchs.getCompoundTagAt(i);
                    short id = tag.getShort("id");
                    short lvl = tag.getShort("lvl");
                    Enchantment e = Enchantment.getEnchantmentById(id);
                    String enStr = e.getTranslatedName(lvl);
                    list.add(" * " + enStr);
                }
            }
        }
    }

    public String getModuleName() {
        return "Display all enchantments for item";
    }

    public String getAuthor() {
        return "asaskevich";
    }
}