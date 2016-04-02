package com.asaskevich.smartcursor.modules.player;
import com.asaskevich.smartcursor.api.IPlayerProcessor;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
public class PlayerEquipmentModule implements IPlayerProcessor {
    public void process(List<String> list, EntityPlayer player) {
        Iterable<ItemStack> items = player.getEquipmentAndArmor();
        boolean h = player.getHeldItem(EnumHand.MAIN_HAND) != null || player.getHeldItem(EnumHand.OFF_HAND) != null;
        for (ItemStack item : items)
            if (item != null) h = true;
        if (h) {
            list.add(TextFormatting.GRAY + I18n.translateToLocal("smartcursor.player.equipment"));
            if (player.getHeldItem(EnumHand.MAIN_HAND) != null)
                list.add(" * " + player.getHeldItem(EnumHand.MAIN_HAND).getDisplayName() + TextFormatting.GOLD + (player.getHeldItem(EnumHand.MAIN_HAND).isItemEnchanted() ? I18n.translateToLocal("smartcursor.player.ench") : ""));
            if (player.getHeldItem(EnumHand.OFF_HAND) != null)
                list.add(" * " + player.getHeldItem(EnumHand.OFF_HAND).getDisplayName() + TextFormatting.GOLD + (player.getHeldItem(EnumHand.OFF_HAND).isItemEnchanted() ? I18n.translateToLocal("smartcursor.player.ench") : ""));
            for (ItemStack item : items) {
                if ((item != null) && (item != player.getHeldItem(EnumHand.MAIN_HAND)) && (item != player.getHeldItem(EnumHand.OFF_HAND)))
                    list.add(" * " + item.getDisplayName() + TextFormatting.GOLD + (item.isItemEnchanted() ? I18n.translateToLocal("smartcursor.player.ench") : ""));
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