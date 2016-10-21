package com.asaskevich.smartcursor.modules.block;

import com.asaskevich.smartcursor.api.IBlockProcessor;
import com.asaskevich.smartcursor.utils.ModIdentification;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

public class BlockModIdentificatorModule implements IBlockProcessor {
    public String getModuleName() {
        return "Mod Identification for Blocks";
    }

    public String getAuthor() {
        return "modmuss50";
    }

    public void process(List<String> list, Block block, IBlockState blockState, BlockPos blockPos, World world) {
        Item item = block.getItem(world, blockPos);
        ItemStack stack = new ItemStack(block);
        if (item != null) stack = new ItemStack(item);
        list.add(EnumChatFormatting.AQUA + "" + EnumChatFormatting.ITALIC
                + ModIdentification.nameFromStack(stack) + EnumChatFormatting.RESET);
    }
}