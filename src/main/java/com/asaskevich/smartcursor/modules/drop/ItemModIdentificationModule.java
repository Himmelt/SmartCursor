package com.asaskevich.smartcursor.modules.drop;

import com.asaskevich.smartcursor.api.IDropProcessor;
import com.asaskevich.smartcursor.utils.ModIdentification;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

public class ItemModIdentificationModule implements IDropProcessor {
    public String getModuleName() {
        return "Mod Identification for Blocks";
    }

    public String getAuthor() {
        return "modmuss50";
    }

    public void process(List<String> list, ItemStack stack) {
        list.add(EnumChatFormatting.AQUA + "" + EnumChatFormatting.ITALIC
                + ModIdentification.nameFromStack(stack) + EnumChatFormatting.RESET);
    }
}