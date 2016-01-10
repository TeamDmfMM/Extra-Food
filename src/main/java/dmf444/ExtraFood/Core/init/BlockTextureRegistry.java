package dmf444.ExtraFood.Core.init;

import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Core.lib.BlockLib;
import dmf444.ExtraFood.Core.lib.ModInfo;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockTextureRegistry {


    @SideOnly(Side.CLIENT)
    public static void RegisterBlockTextures(){
        registerBlock(BlockLib.bBB, 0, "extrafood:Banana_Bunch");
        registerBlock(BlockLib.bBL, 0, "extrafood:BananaLeaf");
        registerBlock(BlockLib.bTWB, 0, "extrafood:TheWhiteBlock");
        registerBlock(BlockLib.bBS, 0, "extrafood:Bannana_Sapling");
        registerBlock(BlockLib.bCP, 0, "extrafood:CheesePress");
        registerBlock(BlockLib.bAC, 0);
        registerBlock(BlockLib.bSB, 0);
        registerBlock(BlockLib.bPB, 0);
        registerBlock(BlockLib.bJB, 0);
        registerBlock(BlockLib.bO, 0);
        registerBlock(BlockLib.bJM, 0);
        registerBlock(BlockLib.bOliveLeaf, 0);
        registerBlock(BlockLib.bOliveBush, 0);

        //ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockLoader.juiceMixer), 0, new ModelResourceLocation("extrafood:" + BlockLib.bJM, "inventory"));

    }

    private static void registerBlock(String blockName, int meta, String resource){
        RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
        Item itemB = GameRegistry.findItem("extrafood", blockName);
        renderItem.getItemModelMesher().register(itemB, meta, new ModelResourceLocation(resource, "inventory"));
    }
    private static void registerBlock(String blockName, int meta){
        RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
        Item itemB = GameRegistry.findItem("extrafood", blockName);
        renderItem.getItemModelMesher().register(itemB, meta, new ModelResourceLocation("extrafood:"+ blockName, "inventory"));
    }
}
