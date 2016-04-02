package com.asaskevich.smartcursor.api;
import java.util.List;
import net.minecraft.entity.Entity;
public abstract interface IEntityProcessor
 extends IModule {
   public abstract void process(List<String> paramList, Entity paramEntity);
}