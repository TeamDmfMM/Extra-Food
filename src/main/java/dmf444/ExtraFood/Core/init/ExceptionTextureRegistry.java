package dmf444.ExtraFood.Core.init;

import dmf444.ExtraFood.Common.blocks.BlockLoader;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;

/**
 * Created by DMF444 for Starvation Ahoy. All rights
 * reserved. Code may be copied if credit is given to
 * source. Any code derived code is under their respective
 * licences.
 */
public class ExceptionTextureRegistry {

    public static void registerExceptiions(){
        ModelBakery.addVariantName(Item.getItemFromBlock(BlockLoader.Bstrawberryjuice));
        ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(BlockLoader.Bstrawberryjuice), new ItemMeshDefinition() {
            @Override
            public ModelResourceLocation getModelLocation(ItemStack p_178113_1_) {
                return new ModelResourceLocation("extrafood:StrawberryJuice", "fluid");
            }
        });
        ModelLoader.setCustomStateMapper(BlockLoader.Bstrawberryjuice, new StateMapperBase() {
            @Override
            protected ModelResourceLocation getModelResourceLocation(IBlockState p_178132_1_) {
                return new ModelResourceLocation("extrafood:StrawberryJuice", "fluid");
            }
        });

    }
}
