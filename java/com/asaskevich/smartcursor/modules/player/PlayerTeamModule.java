package com.asaskevich.smartcursor.modules.player;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.scoreboard.Team;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
public class PlayerTeamModule implements com.asaskevich.smartcursor.api.IPlayerProcessor {
    public void process(List<String> list, EntityPlayer player) {
        if (player.getTeam() != null) {
            list.add(I18n.translateToLocal("smartcursor.player.team") + TextFormatting.RED + player.getTeam().getRegisteredName());
        }
    }
    public String getModuleName() {
        return "Team of Player";
    }
    public String getAuthor() {
        return "asaskevich";
    }
}