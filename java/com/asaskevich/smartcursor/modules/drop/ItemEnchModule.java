package com.asaskevich.smartcursor.modules.drop;
import com.asaskevich.smartcursor.api.IDropProcessor;
import java.util.List;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
public class ItemEnchModule implements IDropProcessor
{
  public void process(List<String> list, ItemStack stack)
  {
    if (stack.isItemEnchanted()) {
      list.add(TextFormatting.GRAY + I18n.translateToLocal("smartcursor.item.enchItem"));
      NBTTagList enchs = stack.getEnchantmentTagList();
      if (enchs != null) {
        for (int i = 0; i < enchs.tagCount(); i++) {
          NBTTagCompound tag = enchs.getCompoundTagAt(i);
          short id = tag.getShort("id");
          short lvl = tag.getShort("lvl");
          Enchantment e = Enchantment.getEnchantmentByID(id);
          String enStr = e.getTranslatedName(lvl);
          list.add(" * " + enStr);
        }
      }
    }
  }
  public String getModuleName()
  {
    return "Display all enchantments for item";
  }
  public String getAuthor()
  {
    return "asaskevich";
  }
}
/* Location:              C:\Users\pokem\Downloads\SmartCursor-1.5.0-MC1.8.jar!\com\asaskevich\smartcursor\modules\drop\ItemEnchModule.class
* Java compiler version: 6 (50.0)
* JD-Core Version:       0.7.1
*/