package com.asaskevich.smartcursor.api;
import java.util.List;
import net.minecraft.item.ItemStack;
public abstract interface IDropProcessor
 extends IModule {
   public abstract void process(List<String> paramList, ItemStack paramItemStack);
}