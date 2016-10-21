package com.asaskevich.smartcursor.api;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public interface IBlockProcessor
        extends IModule {
    void process(List<String> paramList, Block paramBlock, IBlockState paramIBlockState, BlockPos paramBlockPos, World paramWorld);
}