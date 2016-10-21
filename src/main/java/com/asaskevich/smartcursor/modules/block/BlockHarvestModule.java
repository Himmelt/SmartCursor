package com.asaskevich.smartcursor.modules.block;

import com.asaskevich.smartcursor.api.IBlockProcessor;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.util.BlockPos;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public class BlockHarvestModule implements IBlockProcessor {
    public void process(List<String> list, Block block, IBlockState blockState, BlockPos blockPos, World world) {
        if (block.canHarvestBlock(world, blockPos, Minecraft.getMinecraft().thePlayer))
            list.add(StatCollector.translateToLocal("smartcursor.block.harvestBlock"));
        else {
            list.add(StatCollector.translateToLocal("smartcursor.block.cantHarvestBlock"));
        }
    }

    public String getModuleName() {
        return "Can I harvest block or not?";
    }

    public String getAuthor() {
        return "asaskevich";
    }
}
