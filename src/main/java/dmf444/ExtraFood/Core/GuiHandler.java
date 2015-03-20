package dmf444.ExtraFood.Core;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import dmf444.ExtraFood.Common.blocks.container.AutoCutterContainer;
import dmf444.ExtraFood.Common.blocks.container.CheesePressContainer;
import dmf444.ExtraFood.Common.blocks.container.ContainerJuiceBlender;
import dmf444.ExtraFood.Common.blocks.container.ContainerOven;
import dmf444.ExtraFood.Common.blocks.guis.AutoCutterGUI;
import dmf444.ExtraFood.Common.blocks.guis.CheesePressGUI;
import dmf444.ExtraFood.Common.blocks.guis.CookBookGUI;
import dmf444.ExtraFood.Common.blocks.guis.GuiJuiceBlender;
import dmf444.ExtraFood.Common.blocks.guis.GuiOven;
import dmf444.ExtraFood.Common.blocks.tileentity.AutoCutterTileEntity;
import dmf444.ExtraFood.Common.blocks.tileentity.CheesePressTileEntity;
import dmf444.ExtraFood.Common.blocks.tileentity.TileEntityJuiceBlender;
import dmf444.ExtraFood.Common.blocks.tileentity.TileEntityOven;

public class GuiHandler implements IGuiHandler {
    //returns an instance of the Container you made earlier
	public void registerKeyBindings () {}
    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) 
    {
            TileEntity tileEntity = world.getTileEntity(x, y, z);
            if(tileEntity instanceof CheesePressTileEntity){
            	
                 return new CheesePressContainer(player.inventory, (CheesePressTileEntity) tileEntity);
            } else if(tileEntity instanceof AutoCutterTileEntity){
            	return new AutoCutterContainer(player.inventory, (AutoCutterTileEntity) tileEntity);
            } else if (tileEntity instanceof TileEntityJuiceBlender){                	
                return new ContainerJuiceBlender( player.inventory, (TileEntityJuiceBlender) tileEntity);
            } else if(tileEntity instanceof TileEntityOven){
            	return new ContainerOven(player.inventory, (TileEntityOven) tileEntity);
            }else if(id == CookBookGUI.GUI_ID){
            		return null;
            }                            
            return null;
    }
       

    

    //returns an instance of the Gui you made earlier
    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
            TileEntity tileEntity = world.getTileEntity(x, y, z);
            
            if(id == CookBookGUI.GUI_ID){
            	//System.out.println("CALLED");       	
            	return new CookBookGUI();           	
            } else{
            if(tileEntity instanceof CheesePressTileEntity){
            	return new CheesePressGUI(player.inventory, (CheesePressTileEntity) tileEntity);
            } else {
            if(tileEntity instanceof AutoCutterTileEntity){            
            	//System.out.println("Cutter- This works!");
                return new AutoCutterGUI(player.inventory, (AutoCutterTileEntity) tileEntity);
            	} else {
            	if (tileEntity instanceof TileEntityJuiceBlender){
            	//System.out.println(" gjksfcckcgrjkgshkdvr");
            	return new GuiJuiceBlender(player.inventory, (TileEntityJuiceBlender) tileEntity);
            	} else if(tileEntity instanceof TileEntityOven){
            		return new GuiOven(player.inventory, (TileEntityOven) tileEntity);
            	}
            }



            }
            
            return null;
      	}
    }
}
