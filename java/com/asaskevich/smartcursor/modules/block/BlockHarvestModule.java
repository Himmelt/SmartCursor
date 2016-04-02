package com.asaskevich.smartcursor.modules.block;
import com.asaskevich.smartcursor.api.IBlockProcessor;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
public class BlockHarvestModule implements IBlockProcessor
{
  public void process(List<String> list, Block block, IBlockState istate, BlockPos pos, World theWorld)
  {
    if (block.canHarvestBlock(theWorld, pos, Minecraft.getMinecraft().thePlayer)) list.add(I18n.translateToLocal("smartcursor.block.harvestBlock")); else {
      list.add(I18n.translateToLocal("smartcursor.block.cantHarvestBlock"));
    }
  }
  public String getModuleName() {
    return "Can I harvest block or not?";
  }
  public String getAuthor()
  {
    return "asaskevich";
  }
}
/* Location:              C:\Users\pokem\Downloads\SmartCursor-1.5.0-MC1.8.jar!\com\asaskevich\smartcursor\modules\block\BlockHarvestModule.class
* Java compiler version: 6 (50.0)
* JD-Core Version:       0.7.1
*/