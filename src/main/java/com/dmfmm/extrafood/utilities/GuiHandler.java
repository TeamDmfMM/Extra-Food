package com.dmfmm.extrafood.utilities;


import com.dmfmm.extrafood.client.gui.*;
import com.dmfmm.extrafood.client.gui.cookbook.CookBookGUI;
import com.dmfmm.extrafood.container.*;
import com.dmfmm.extrafood.tileentities.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
    //returns an instance of the Container you made earlier
    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));
        if(tileEntity instanceof CheesePressTileEntity){

            return new CheesePressContainer(player.inventory, (CheesePressTileEntity) tileEntity);
        } else if(tileEntity instanceof AutoCutterTileEntity){
            return new AutoCutterContainer(player.inventory, (AutoCutterTileEntity) tileEntity);
        } else if (tileEntity instanceof JuiceBlenderTileEntity){
            return new JuiceBlenderContainer( player.inventory, (JuiceBlenderTileEntity) tileEntity);
        } else if(tileEntity instanceof OvenTileEntity) {
            return new OvenContainer(player.inventory, (OvenTileEntity) tileEntity);
        }else if(tileEntity instanceof JuiceMixerTileEntity){
            return new JuiceMixerContainer(player.inventory, (JuiceMixerTileEntity) tileEntity);
        }else if(id == CookBookGUI.GUI_ID){
            return null;
        }
        return null;
    }




    //returns an instance of the Gui you made earlier
    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));

        if(id == CookBookGUI.GUI_ID){
            return new CookBookGUI();
        } else{
            if(tileEntity instanceof CheesePressTileEntity){
                return new CheesePressGUI(player.inventory, (CheesePressTileEntity) tileEntity);
            } else if(tileEntity instanceof AutoCutterTileEntity){
                return new AutoCutterGUI(player.inventory, (AutoCutterTileEntity) tileEntity);
            } else if (tileEntity instanceof JuiceBlenderTileEntity){
                return new JuiceBlenderGUI(player.inventory, (JuiceBlenderTileEntity) tileEntity);
            } else if(tileEntity instanceof OvenTileEntity){
                return new OvenGUI(player.inventory, (OvenTileEntity) tileEntity);
            } else if(tileEntity instanceof JuiceMixerTileEntity){
                return new JuiceMixerGUI(player.inventory, (JuiceMixerTileEntity) tileEntity);
            }
        }
        return null;
    }
}