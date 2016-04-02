package com.asaskevich.smartcursor.api;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
public abstract interface IPlayerProcessor
 extends IModule {
   public abstract void process(List<String> paramList, EntityPlayer paramEntityPlayer);
}