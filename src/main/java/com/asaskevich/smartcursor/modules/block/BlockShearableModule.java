package com.asaskevich.smartcursor.modules.block;

import com.asaskevich.smartcursor.api.IBlockProcessor;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

import java.util.List;

public class BlockShearableModule implements IBlockProcessor {
    public String getModuleName() {
        return "Is block shearable";
    }

    public String getAuthor() {
        return "asaskevich";
    }

    public void process(List<String> list, Block block, IBlockState istate, BlockPos pos, World theWorld) {
        if ((block instanceof IShearable)) list.add(StatCollector.translateToLocal("smartcursor.block.shearable"));
    }
}
