package com.asaskevich.smartcursor.modules.player;

import com.asaskevich.smartcursor.api.IPlayerProcessor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

import java.util.ArrayList;
import java.util.List;

public class PlayerEquipmentModule implements IPlayerProcessor {
    public void process(List<String> list, EntityPlayer player) {

        //Iterable<ItemStack> items = player.getEquipmentAndArmor();
        List<ItemStack> equips = new ArrayList<ItemStack>();
        equips.add(player.getCurrentArmor(0));
        equips.add(player.getCurrentArmor(1));
        equips.add(player.getCurrentArmor(2));
        equips.add(player.getCurrentArmor(3));
        equips.add(player.getCurrentEquippedItem());

        boolean h = player.getHeldItem() != null;
        for (ItemStack item : equips)
            if (item != null) h = true;
        if (h) {
            list.add(EnumChatFormatting.GRAY + StatCollector.translateToLocal("smartcursor.player.equipment"));
            if (player.getHeldItem() != null)
                list.add(" * " + player.getHeldItem().getDisplayName() + EnumChatFormatting.GOLD
                        + (player.getHeldItem().isItemEnchanted() ? StatCollector.translateToLocal("smartcursor.player.ench") : ""));
            //if (player.getHeldItem(EnumHand.OFF_HAND) != null)
            //    list.add(" * " + player.getHeldItem(EnumHand.OFF_HAND).getDisplayName() + EnumChatFormatting.GOLD + (player.getHeldItem(EnumHand.OFF_HAND).isItemEnchanted() ? StatCollector.translateToLocal("smartcursor.player.ench") : ""));
            for (ItemStack item : equips) {
                if ((item != null) && (item != player.getHeldItem()))
                    list.add(" * " + item.getDisplayName() + EnumChatFormatting.GOLD + (item.isItemEnchanted() ? StatCollector.translateToLocal("smartcursor.player.ench") : ""));
            }
        }
    }

    public String getModuleName() {
        return "Equipment of Player";
    }

    public String getAuthor() {
        return "asaskevich";
    }
}