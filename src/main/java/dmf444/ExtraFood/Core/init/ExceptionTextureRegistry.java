package dmf444.ExtraFood.Core.init;

//import dmf444.ExtraFood.Client.modelbake.ModelBakeInjector;
import dmf444.ExtraFood.Client.modelbake.TextureInjector;
import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Common.blocks.Plants.OliveLeaf;
import dmf444.ExtraFood.Common.fluids.FluidLoader;
import dmf444.ExtraFood.Common.items.nbt.NBTFoodLoader;
import dmf444.ExtraFood.Core.lib.ModInfo;
import net.minecraft.block.Block;
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
        registerItemModel(FluidLoader.FluidContainer, 0, "EFglassBottle");
        registerItemModel(NBTFoodLoader.getItem("pizza"), 0, "NBTpizza");
        registerItemModel(NBTFoodLoader.getItem("muffin"), 0, "NBTmuffin");
        registerItemModel(Item.getItemFromBlock(BlockLoader.juiceMixer), 0, "JuiceMixer", "inventory");

        registerJuiceTexutre(BlockLoader.Bstrawberryjuice, 0);
        registerJuiceTexutre(BlockLoader.Bbananajuice, 1);
        registerJuiceTexutre(BlockLoader.Bcarrotjuice, 2);
        registerJuiceTexutre(BlockLoader.Beggnog, 3);
        registerJuiceTexutre(BlockLoader.BdiscustingMix, 4);
        registerJuiceTexutre(BlockLoader.BappleJuice, 5);
        registerJuiceTexutre(BlockLoader.BorangeJuice, 6);
        registerJuiceTexutre(BlockLoader.BwatermelonJuice, 7);


        ModelLoader.setCustomStateMapper(BlockLoader.bananaLeaf, new StateMapperBase() {
            @Override
            protected ModelResourceLocation getModelResourceLocation(IBlockState p_178132_1_) {
                return new ModelResourceLocation("extrafood:BananaLeaf", "normal");
            }
        });

        ModelLoader.setCustomStateMapper(BlockLoader.oliveLeaf, new StateMapperBase() {
            @Override
            protected ModelResourceLocation getModelResourceLocation(IBlockState p_178132_1_) {
                return new ModelResourceLocation("extrafood:OliveLeaf", getGrowthLVL(p_178132_1_));
            }
            private String getGrowthLVL(IBlockState state){
                int lvl = ((Integer)state.getValue(OliveLeaf.METALVL)).intValue();
                return "growth=" + lvl;
            }
        });

       // MinecraftForge.EVENT_BUS.register(new ModelBakeInjector());
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

    public static void registerItemModel(final Item item, int meta, final String itemName)
    {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(ModInfo.MId + ":" + itemName, "inventory"));
    }

    public static void registerJuiceTexutre(Block block, int numInJson){
        ModelBakery.registerItemVariants(Item.getItemFromBlock(block));
        ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(block), new cSM(numInJson));
        ModelLoader.setCustomStateMapper(block, new cSM(numInJson));
    }

    public static void registerItemModel(final Item item, int meta, final String jsonName, final String variantName)
    {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(ModInfo.MId + ":" + jsonName, variantName));
    }


}
