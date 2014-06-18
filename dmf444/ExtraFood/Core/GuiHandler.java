package dmf444.ExtraFood.Core;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import dmf444.ExtraFood.Common.blocks.container.AutoCutterContainer;
import dmf444.ExtraFood.Common.blocks.container.CheesePressContainer;
import dmf444.ExtraFood.Common.blocks.guis.AutoCutterGUI;
import dmf444.ExtraFood.Common.blocks.guis.CRPageGUI;
import dmf444.ExtraFood.Common.blocks.guis.CheesePressGUI;
import dmf444.ExtraFood.Common.blocks.guis.CookBookGUI;
import dmf444.ExtraFood.Common.blocks.tileentity.AutoCutterTileEntity;
import dmf444.ExtraFood.Common.blocks.tileentity.CheesePressTileEntity;
import dmf444.ExtraFood.Common.items.ItemLoader;

public class GuiHandler implements IGuiHandler {
    //returns an instance of the Container you made earlier
	public void registerKeyBindings () {}
    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world,
                    int x, int y, int z) 
    {
            TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
            if(tileEntity instanceof CheesePressTileEntity){
                    return new CheesePressContainer(player.inventory, (CheesePressTileEntity) tileEntity);
            } else {
            if(tileEntity instanceof AutoCutterTileEntity)
            {
            		return new AutoCutterContainer(player.inventory, (AutoCutterTileEntity) tileEntity);
            } else {
            	if(id == 2)
            	{
            		return null;
            	}
            }
            
            return null;
            }
    }

    //returns an instance of the Gui you made earlier
    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world,
                    int x, int y, int z) {
            TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
            if(id == CookBookGUI.GUI_ID){
            	System.out.println("CALLED");
            	//return CookBookGUI.currentOpenBook;
            	
            	return new CookBookGUI();
            	
            	} else {
            if(tileEntity instanceof CheesePressTileEntity){
                    return new CheesePressGUI(player.inventory, (CheesePressTileEntity) tileEntity);
            } else {
            if(tileEntity instanceof AutoCutterTileEntity)
            	{
            	System.out.println("Cutter- This works!");
                return new AutoCutterGUI(player.inventory, (AutoCutterTileEntity) tileEntity);
            	} 
            }
            return null;
      	}
    }
}