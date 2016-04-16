package com.asaskevich.smartcursor.modules.block;
import com.asaskevich.smartcursor.api.IBlockProcessor;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
public class BlockGrowableModule implements IBlockProcessor {
    public String getModuleName() {
        return "Is it block growable?";
    }

    public String getAuthor() {
        return "asaskevich";
    }

    static Block crops = Blocks.wheat;
    static Block melon = Blocks.melon_stem;
    static Block pumpkin = Blocks.pumpkin_stem;
    static Block carrot = Blocks.carrots;
    static Block potato = Blocks.potatoes;
    static Block cocoa = Blocks.cocoa;
    static Block wart = Blocks.nether_wart;

    public void process(List<String> list, Block block, IBlockState istate, BlockPos pos, World theWorld) {
        if ((block instanceof IGrowable)) {
            IGrowable glowable = (IGrowable) block;

            list.add(I18n.translateToLocal("smartcursor.block.growable"));

            float growth = 0;
        }
        float growth = -1;
        // Wheat MelonStem PumpkinStem Carrot
        if (crops.getClass().isInstance(block) ||
                block == melon ||
                block == pumpkin ||
                block == carrot) {
            IProperty<?> p = block.getBlockState().getProperty("age");
            if (p instanceof PropertyInteger) {
                PropertyInteger age = (PropertyInteger)p;

            }
        }
    }
}