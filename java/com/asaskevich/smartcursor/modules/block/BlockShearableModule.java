package com.asaskevich.smartcursor.modules.block;
import com.asaskevich.smartcursor.api.IBlockProcessor;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
public class BlockShearableModule implements IBlockProcessor
{
  public String getModuleName()
  {
    return "Is block shearable";
  }
  public String getAuthor()
  {
    return "asaskevich";
  }
  public void process(List<String> list, Block block, IBlockState istate, BlockPos pos, World theWorld)
  {
    if ((block instanceof IShearable)) list.add(I18n.translateToLocal("smartcursor.block.shearable"));
  }
}
/* Location:              C:\Users\pokem\Downloads\SmartCursor-1.5.0-MC1.8.jar!\com\asaskevich\smartcursor\modules\block\BlockShearableModule.class
* Java compiler version: 6 (50.0)
* JD-Core Version:       0.7.1
*/