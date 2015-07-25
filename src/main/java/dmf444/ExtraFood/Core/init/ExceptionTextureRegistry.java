package dmf444.ExtraFood.Core.init;

import dmf444.ExtraFood.Client.modelbake.ModelBakeInjector;
import dmf444.ExtraFood.Client.modelbake.TextureInjector;
import dmf444.ExtraFood.Common.blocks.BlockLoader;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;


public class ExceptionTextureRegistry {

    public static void registerExceptiions(){
        ModelBakery.addVariantName(Item.getItemFromBlock(BlockLoader.Bstrawberryjuice));
        ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(BlockLoader.Bstrawberryjuice), new cSM(0));
        ModelLoader.setCustomStateMapper(BlockLoader.Bstrawberryjuice, new cSM(0));

        ModelBakery.addVariantName(Item.getItemFromBlock(BlockLoader.Bbananajuice));
        ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(BlockLoader.Bbananajuice), new cSM(1));
        ModelLoader.setCustomStateMapper(BlockLoader.Bbananajuice, new cSM(1));

        ModelBakery.addVariantName(Item.getItemFromBlock(BlockLoader.Bcarrotjuice));
        ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(BlockLoader.Bcarrotjuice), new cSM(2));
        ModelLoader.setCustomStateMapper(BlockLoader.Bcarrotjuice, new cSM(2));

        ModelBakery.addVariantName(Item.getItemFromBlock(BlockLoader.Beggnog));
        ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(BlockLoader.Beggnog), new cSM(3));
        ModelLoader.setCustomStateMapper(BlockLoader.Beggnog, new cSM(3));

        ModelBakery.addVariantName(Item.getItemFromBlock(BlockLoader.bananaLeaf));
        ModelLoader.setCustomStateMapper(BlockLoader.bananaLeaf, new StateMapperBase() {
            @Override
            protected ModelResourceLocation getModelResourceLocation(IBlockState p_178132_1_) {
                return new ModelResourceLocation("extrafood:BananaLeaf", "normal");
            }
        });
        ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(BlockLoader.bananaLeaf), new ItemMeshDefinition() {
            @Override
            public ModelResourceLocation getModelLocation(ItemStack stack) {
                return new ModelResourceLocation("extrafood:BananaLeaf", "inventory");
            }
        });

        MinecraftForge.EVENT_BUS.register(new ModelBakeInjector());
        MinecraftForge.EVENT_BUS.register(new TextureInjector());

    }

    public static class cSM extends StateMapperBase implements ItemMeshDefinition{

        private int fn;

        public cSM(int fluidNum){
            this.fn = fluidNum;
        }

        @Override
        protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
            String number = "fluid" + Integer.toString(this.fn);
            return new ModelResourceLocation("extrafood:FluidModels", number);
        }

        @Override
        public ModelResourceLocation getModelLocation(ItemStack stack) {
            String number = "fluid" + Integer.toString(this.fn);
            return new ModelResourceLocation("extrafood:FluidModels", number);
        }
    }

}
