package com.asaskevich.smartcursor.modules.drop;
import com.asaskevich.smartcursor.api.IDropProcessor;
import java.util.List;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;
public class ItemUtilsModule implements IDropProcessor
{
  public void process(List<String> list, ItemStack stack)
  {
    if (stack.isStackable()) {
      list.add(I18n.translateToLocal("smartcursor.item.stackable") + (stack.getMaxStackSize() > 1 ? I18n.translateToLocal("smartcursor.item.in") + stack.getMaxStackSize() + I18n.translateToLocal("smartcursor.item.items") : ""));
    }
    if (stack.isItemDamaged()) list.add(I18n.translateToLocal("smartcursor.item.isDamaged"));
    if (stack.isItemEnchantable()) list.add(I18n.translateToLocal("smartcursor.item.enchantable"));
    if (stack.getHasSubtypes()) list.add(I18n.translateToLocal("smartcursor.item.hasSubtypes"));
    if (stack.hasEffect()) list.add(I18n.translateToLocal("smartcursor.item.hasEffect"));
  }
  public String getModuleName()
  {
    return "Advanced information about items";
  }
  public String getAuthor()
  {
    return "asaskevich";
  }
}
/* Location:              C:\Users\pokem\Downloads\SmartCursor-1.5.0-MC1.8.jar!\com\asaskevich\smartcursor\modules\drop\ItemUtilsModule.class
* Java compiler version: 6 (50.0)
* JD-Core Version:       0.7.1
*/