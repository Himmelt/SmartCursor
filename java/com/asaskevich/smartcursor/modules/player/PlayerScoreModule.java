package com.asaskevich.smartcursor.modules.player;
import com.asaskevich.smartcursor.api.IPlayerProcessor;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
public class PlayerScoreModule implements IPlayerProcessor {
    public void process(List<String> list, EntityPlayer player) {
        list.add(I18n.translateToLocal("smartcursor.player.score") + TextFormatting.GREEN + player.getScore());
    }
    public String getModuleName() {
        return "Score of player";
    }
    public String getAuthor() {
        return "asaskevich";
    }
}