package com.asaskevich.smartcursor.modules.player;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

import java.util.List;

public class PlayerTeamModule implements com.asaskevich.smartcursor.api.IPlayerProcessor {
    public void process(List<String> list, EntityPlayer player) {
        if (player.getTeam() != null) {
            list.add(StatCollector.translateToLocal("smartcursor.player.team") + EnumChatFormatting.RED + player.getTeam().getRegisteredName());
        }
    }

    public String getModuleName() {
        return "Team of Player";
    }

    public String getAuthor() {
        return "asaskevich";
    }
}