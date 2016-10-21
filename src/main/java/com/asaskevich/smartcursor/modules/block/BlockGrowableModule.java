package com.asaskevich.smartcursor.modules.block;

import com.asaskevich.smartcursor.api.IBlockProcessor;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public class BlockGrowableModule implements IBlockProcessor {

    static Block crops = Blocks.wheat;
    static Block melon = Blocks.melon_stem;
    static Block pumpkin = Blocks.pumpkin_stem;
    static Block carrot = Blocks.carrots;
    static Block potato = Blocks.potatoes;
    static Block cocoa = Blocks.cocoa;
    static Block wart = Blocks.nether_wart;

    public String getModuleName() {
        return "Is it block growable?";
    }

    public String getAuthor() {
        return "asaskevich";
    }

    @Override
    public void process(List<String> list, Block block, IBlockState blockState, BlockPos blockPos, World world) {
        if (block instanceof IGrowable)
            list.add(StatCollector.translateToLocal("smartcursor.block.growable"));
        /*
        if ((block instanceof IGrowable)) {
            IGrowable glowable = (IGrowable) block;

            list.add(StatCollector.translateToLocal("smartcursor.block.growable"));

            float growth = 0;
        }
        float growth = -1;
        Wheat MelonStem PumpkinStem Carrot
        if (crops.getClass().isInstance(block) || block == melon || block == pumpkin || block == carrot) {
            IProperty<?> p = block.getBlockState().getProperties().get(0);//.getProperty("age");
            if (p instanceof PropertyInteger) {
                PropertyInteger age = (PropertyInteger) p;
                ///
            }
        }
        */
    }
}