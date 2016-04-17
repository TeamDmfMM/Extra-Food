package dmf444.ExtraFood.Client;

import dmf444.ExtraFood.Client.renderer.AutoCutterRenderer;
import dmf444.ExtraFood.Client.renderer.CheesePressRenderer;
import dmf444.ExtraFood.Client.renderer.JuiceBlenderRenderer;
import dmf444.ExtraFood.Client.renderer.OvenRenderer;
import dmf444.ExtraFood.Common.CommonProxy;
import dmf444.ExtraFood.Common.RecipeHandler.JuiceRegistry;
import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Common.blocks.tileentity.AutoCutterTileEntity;
import dmf444.ExtraFood.Common.blocks.tileentity.CheesePressTileEntity;
import dmf444.ExtraFood.Common.blocks.tileentity.TileEntityJuiceBlender;
import dmf444.ExtraFood.Common.blocks.tileentity.TileEntityOven;
import dmf444.ExtraFood.Common.fluids.GeneralFluid;
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
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ClientProxy extends CommonProxy{

	
	public void registerRenderers(){

		ClientRegistry.bindTileEntitySpecialRenderer(CheesePressTileEntity.class, new CheesePressRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(AutoCutterTileEntity.class, new AutoCutterRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityJuiceBlender.class, new JuiceBlenderRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityOven.class, new OvenRenderer());
		//ForgeHooksClient.registerTESRItemStack(Item.getItemFromBlock(BlockLoader.autoCutter), 0, AutoCutterTileEntity.class);
		Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler(new IBlockColor()
		{
			public int colorMultiplier(IBlockState state, IBlockAccess p_186720_2_, BlockPos pos, int tintIndex)
			{
				return p_186720_2_ != null && pos != null ? BiomeColorHelper.getFoliageColorAtPos(p_186720_2_, pos) : ColorizerFoliage.getFoliageColorBasic();
			}
		}, BlockLoader.bananaLeaf);
		Minecraft.getMinecraft().getItemColors().registerItemColorHandler(new IItemColor() {
			@Override
			public int getColorFromItemstack(ItemStack stack, int tintIndex) {
				return 4557568;
			}
		}, BlockLoader.bananaLeaf);

		
		
		
	}
	@Override
	public void intermodComm(){
		//FMLInterModComms.sendMessage("Waila", "register", WailaConfig.class.getName() + ".callbackRegister");
	}

	public void preInit() {
		//MinecraftForge.EVENT_BUS.register(new ModelInjector());
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

			if (((EntityLivingBase)e.getPlayer()).isPotionActive(MobEffects.waterBreathing))
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
			event.getModelManager().getBlockModelShapes().registerBuiltInBlocks(BlockLoader.autoCutter);
		}
	}
}

