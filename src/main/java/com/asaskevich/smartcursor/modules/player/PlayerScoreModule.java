package com.asaskevich.smartcursor.modules.player;

import com.asaskevich.smartcursor.api.IPlayerProcessor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

import java.util.List;

public class PlayerScoreModule implements IPlayerProcessor {
    public void process(List<String> list, EntityPlayer player) {
        list.add(StatCollector.translateToLocal("smartcursor.player.score") + EnumChatFormatting.GREEN + player.getScore());
    }

    public String getModuleName() {
        return "Score of player";
    }

    public String getAuthor() {
        return "asaskevich";
    }
}