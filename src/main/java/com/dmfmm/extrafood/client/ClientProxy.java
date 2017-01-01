package com.dmfmm.extrafood.client;

import com.dmfmm.extrafood.client.modelbake.GlassBottle.ModelDynGlassBottle;
import com.dmfmm.extrafood.client.modelbake.NBTFood.NBTFoodModel;
import com.dmfmm.extrafood.client.renderer.AutoCutterRender;
import com.dmfmm.extrafood.client.renderer.CheesePressRender;
import com.dmfmm.extrafood.client.renderer.JuiceBlenderRender;
import com.dmfmm.extrafood.client.renderer.OvenRender;
import com.dmfmm.extrafood.crafting.JuiceRegistry;
import com.dmfmm.extrafood.fluids.GeneralFluid;
import com.dmfmm.extrafood.init.BlockLoader;
import com.dmfmm.extrafood.tileentities.AutoCutterTileEntity;
import com.dmfmm.extrafood.tileentities.CheesePressTileEntity;
import com.dmfmm.extrafood.tileentities.JuiceBlenderTileEntity;
import com.dmfmm.extrafood.tileentities.OvenTileEntity;
import com.dmfmm.extrafood.utilities.proxy.CommonProxy;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.BiomeColorHelper;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.RenderBlockOverlayEvent;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


/**
 * Created by TeamDMFMM on 12/31/2016. Code originally written
 * for ExtraFood1.9TEST. Do not copy without permission,
 * because that is just mean. Code is VISIBLE SOURCE, therfore
 * credit us, just don't steal large portions of this.
 */
public class ClientProxy extends CommonProxy{

    @Override
    public void registerRenderers(){

        ClientRegistry.bindTileEntitySpecialRenderer(CheesePressTileEntity.class, new CheesePressRender());
        ClientRegistry.bindTileEntitySpecialRenderer(AutoCutterTileEntity.class, new AutoCutterRender());
        ClientRegistry.bindTileEntitySpecialRenderer(JuiceBlenderTileEntity.class, new JuiceBlenderRender());
        ClientRegistry.bindTileEntitySpecialRenderer(OvenTileEntity.class, new OvenRender());
        Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler(new IBlockColor()
        {
            public int colorMultiplier(IBlockState state, IBlockAccess p_186720_2_, BlockPos pos, int tintIndex)
            {
                return p_186720_2_ != null && pos != null ? BiomeColorHelper.getFoliageColorAtPos(p_186720_2_, pos) : ColorizerFoliage.getFoliageColorBasic();
            }
        }, BlockLoader.BANANA_LEAF);
        Minecraft.getMinecraft().getItemColors().registerItemColorHandler(new IItemColor() {
            @Override
            public int getColorFromItemstack(ItemStack stack, int tintIndex) {
                return 4557568;
            }
        }, BlockLoader.BANANA_LEAF);




    }
    @Override
    public void intermodComm(){
        //FMLInterModComms.sendMessage("Waila", "register", WailaConfig.class.getName() + ".callbackRegister");
    }


    public void preInit() {
        //OBJLoader.INSTANCE.addDomain(ModInfo.MId);
        //ModelLoaderRegistry.registerLoader(ModelLoaderz.INSTANCE);
        ModelLoaderRegistry.registerLoader(ModelDynGlassBottle.LoaderDynBucketz.instance);
        ModelLoaderRegistry.registerLoader(NBTFoodModel.ModelLodaer.instance);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void renderzoverlay(RenderBlockOverlayEvent e){
        if(e.getOverlayType() == RenderBlockOverlayEvent.OverlayType.WATER && (Minecraft.getMinecraft().theWorld.getBlockState(e.getBlockPos()).getBlock() instanceof GeneralFluid)) {
            float[] nums = JuiceRegistry.instance.getColor(((GeneralFluid)Minecraft.getMinecraft().theWorld.getBlockState(e.getBlockPos()).getBlock()).getFluid());
            if (nums == null) {
                return;
            }
            e.setCanceled(true);
            Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("textures/misc/underwater.png"));
            Tessellator tessellator = Tessellator.getInstance();
            VertexBuffer worldrenderer = tessellator.getBuffer();
            float f = e.getPlayer().getBrightness(e.getRenderPartialTicks());
            GlStateManager.color(f, f, f, 0.5F);
            //float[] nums = JuiceRegistry.instance.getColor(((GeneralFluid)Minecraft.getMinecraft().theWorld.getBlockState(e.blockPos).getBlock()).getFluid());
            GlStateManager.color(nums[0], nums[1], nums[2], 0.5f);


            GlStateManager.setFog(GlStateManager.FogMode.EXP);

            if (((EntityLivingBase)e.getPlayer()).isPotionActive(MobEffects.WATER_BREATHING))
            {
                GlStateManager.setFogDensity(0.01F);
            }
            else
            {
                GlStateManager.setFogDensity(0.1F - (float)EnchantmentHelper.getRespirationModifier((EntityLivingBase)e.getPlayer()) * 0.03F);
            }
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            GlStateManager.pushMatrix();
            float f7 = -e.getPlayer().rotationYaw / 64.0F;
            float f8 = e.getPlayer().rotationPitch / 64.0F;
            worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
            worldrenderer.pos(-1.0D, -1.0D, -0.5D).tex((double) (4.0F + f7), (double) (4.0F + f8)).endVertex();
            worldrenderer.pos(1.0D, -1.0D, -0.5D).tex((double) (0.0F + f7), (double) (4.0F + f8)).endVertex();
            worldrenderer.pos(1.0D, 1.0D, -0.5D).tex((double) (0.0F + f7), (double) (0.0F + f8)).endVertex();
            worldrenderer.pos(-1.0D, 1.0D, -0.5D).tex((double) (4.0F + f7), (double) (0.0F + f8)).endVertex();
            tessellator.draw();
            GlStateManager.popMatrix();
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.disableBlend();
        }
    }
    public class ModelInjector{

        @SubscribeEvent
        public void bakeModels(ModelBakeEvent event){
            event.getModelManager().getBlockModelShapes().registerBuiltInBlocks(BlockLoader.AUTO_CUTTER);
        }
    }
}

