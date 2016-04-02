package com.asaskevich.smartcursor.modules.drop;
import com.asaskevich.smartcursor.api.IDropProcessor;
import java.util.List;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;
public class ItemFoodModule implements IDropProcessor {
    public void process(List<String> list, ItemStack stack) {
        if ((stack.getItem() instanceof ItemFood)) {
            ItemFood food = (ItemFood) stack.getItem();
            list.add(I18n.translateToLocal("smartcursor.item.healAmount") + food.getHealAmount(stack));
            if (food.isWolfsFavoriteMeat()) list.add(I18n.translateToLocal("smartcursor.item.wolfsMeat"));
        }
        //if (stack.getItem().isPotionIngredient(stack)) list.add(I18n.translateToLocal("smartcursor.item.useInPotions"));
    }
    public String getModuleName() {
        return "Expanded information about food";
    }
    public String getAuthor() {
        return "asaskevich";
    }
}