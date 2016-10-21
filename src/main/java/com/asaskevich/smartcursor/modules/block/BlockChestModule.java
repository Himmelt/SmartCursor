package com.asaskevich.smartcursor.modules.block;

import com.asaskevich.smartcursor.api.IBlockProcessor;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public class BlockChestModule implements IBlockProcessor {
    public String getModuleName() {
        return "Display chest information";
    }

    public String getAuthor() {
        return "asaskevich";
    }

    @Override
    public void process(List<String> list, Block block, IBlockState blockState, BlockPos blockPos, World world) {
        if (block.hasTileEntity(blockState)) {
            TileEntity tileEntity = world.getTileEntity(blockPos);
            if ((tileEntity instanceof IInventory)) {
                IInventory inv = (IInventory) tileEntity;
                String name = StatCollector.translateToLocal(inv.getName());
                int size = inv.getSizeInventory();
                list.add(name + " - " + StatCollector.translateToLocal("smartcursor.block.inventorySize") + size);
            }
        }
    }
}
