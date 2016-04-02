package com.asaskevich.smartcursor.modules.block;
import com.asaskevich.smartcursor.api.IBlockProcessor;
import com.asaskevich.smartcursor.utils.ModIdentification;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
public class BlockModIdentificatorModule implements IBlockProcessor {
    public String getModuleName() {
        return "Mod Identification for Blocks";
    }
    public String getAuthor() {
        return "modmuss50";
    }
    public void process(List<String> list, Block block, IBlockState istate, BlockPos pos, World theWorld) {
    /*Item item = block.func_180665_b(theWorld, pos);
    ItemStack stack = new ItemStack(block);
    if (item != null) stack = new ItemStack(block.func_180665_b(theWorld, pos));
    */
        ItemStack stack = block.getItem(theWorld, pos, theWorld.getBlockState(pos));
        list.add(TextFormatting.AQUA + "" + TextFormatting.ITALIC + ModIdentification.nameFromStack(stack) + TextFormatting.RESET);
    }
}