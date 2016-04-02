package com.asaskevich.smartcursor.api;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
public abstract interface IBlockProcessor
 extends IModule {
   public abstract void process(List<String> paramList, Block paramBlock, IBlockState paramIBlockState, BlockPos paramBlockPos, World paramWorld);
}