package com.asaskevich.smartcursor.modules.drop;
import com.asaskevich.smartcursor.api.IDropProcessor;
import com.asaskevich.smartcursor.utils.ModIdentification;
import java.util.List;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
public class ItemModIdentificationModule implements IDropProcessor
{
  public String getModuleName()
  {
    return "Mod Identification for Blocks";
  }
  public String getAuthor()
  {
    return "modmuss50";
  }
  public void process(List<String> list, ItemStack stack)
  {
    list.add(TextFormatting.AQUA + "" + TextFormatting.ITALIC + ModIdentification.nameFromStack(stack) + TextFormatting.RESET);
  }
}
/* Location:              C:\Users\pokem\Downloads\SmartCursor-1.5.0-MC1.8.jar!\com\asaskevich\smartcursor\modules\drop\ItemModIdentificationModule.class
* Java compiler version: 6 (50.0)
* JD-Core Version:       0.7.1
*/