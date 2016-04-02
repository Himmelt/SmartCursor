package com.asaskevich.smartcursor.modules.block;
import com.asaskevich.smartcursor.api.IBlockProcessor;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
public class BlockChestModule implements IBlockProcessor
{
  public String getModuleName()
  {
    return "Display chest information";
  }
  public String getAuthor()
  {
    return "asaskevich";
  }
  public void process(List<String> list, Block block, IBlockState istate, BlockPos pos, World theWorld)
  {
    if (block.hasTileEntity(istate)) {
      TileEntity tileEntity = theWorld.getTileEntity(pos);
      if ((tileEntity instanceof IInventory)) {
        IInventory inv = (IInventory)tileEntity;
        String name = I18n.translateToLocal(inv.getName());
        int size = inv.getSizeInventory();
        list.add(name + " - " + I18n.translateToLocal("smartcursor.block.inventorySize") + size);
      }
    }
  }
}
/* Location:              C:\Users\pokem\Downloads\SmartCursor-1.5.0-MC1.8.jar!\com\asaskevich\smartcursor\modules\block\BlockChestModule.class
* Java compiler version: 6 (50.0)
* JD-Core Version:       0.7.1
*/