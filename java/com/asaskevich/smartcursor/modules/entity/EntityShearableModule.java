package com.asaskevich.smartcursor.modules.entity;
import com.asaskevich.smartcursor.api.IEntityProcessor;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.common.IShearable;
public class EntityShearableModule implements IEntityProcessor {
    public String getModuleName() {
        return "Is entity shearable";
    }
    public String getAuthor() {
        return "asaskevich";
    }
    public void process(List<String> list, Entity entity) {
        if ((entity instanceof IShearable)) {
            list.add(I18n.translateToLocal("smartcursor.block.shearable"));
        }
    }
}