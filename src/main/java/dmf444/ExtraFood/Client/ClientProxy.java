package dmf444.ExtraFood.Client;

import dmf444.ExtraFood.Client.renderer.AutoCutterRenderer;
import dmf444.ExtraFood.Client.renderer.CheesePressRenderer;
import dmf444.ExtraFood.Client.renderer.JuiceBlenderRenderer;
import dmf444.ExtraFood.Client.renderer.OvenRenderer;
import dmf444.ExtraFood.Common.CommonProxy;
import dmf444.ExtraFood.Common.RecipeHandler.JuiceRegistry;
import dmf444.ExtraFood.Common.blocks.tileentity.AutoCutterTileEntity;
import dmf444.ExtraFood.Common.blocks.tileentity.CheesePressTileEntity;
import dmf444.ExtraFood.Common.blocks.tileentity.TileEntityJuiceBlender;
import dmf444.ExtraFood.Common.blocks.tileentity.TileEntityOven;
import dmf444.ExtraFood.Common.fluids.GeneralFluid;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
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
	//	ClientRegistry.bindTileEntitySpecialRenderer(JuiceMixerTileEntity.class, new JuiceMixerRenderer());
		//JuiceRegistry.instance = new JuiceRegistry();

		
		
		
	}
	@Override
	public void intermodComm(){
		//FMLInterModComms.sendMessage("Waila", "register", WailaConfig.class.getName() + ".callbackRegister");
	}

	public void preInit() {
		//OBJLoader.instance.addDomain(ModInfo.MId);
		MinecraftForge.EVENT_BUS.register(this);
	//	OBJRender.init();
	}

	/*@SubscribeEvent
	public void onTextureStitchEvent(TextureStitchEvent event){
		event.map.registerSprite(new ResourceLocation("extrafood:model/JuiceMixer1"));
	}*/

	@SubscribeEvent
	public void renderzoverlay(RenderBlockOverlayEvent e){
		if(e.overlayType == RenderBlockOverlayEvent.OverlayType.WATER && (Minecraft.getMinecraft().theWorld.getBlockState(e.blockPos).getBlock() instanceof GeneralFluid)) {
			float[] nums = JuiceRegistry.instance.getColor(((GeneralFluid)Minecraft.getMinecraft().theWorld.getBlockState(e.blockPos).getBlock()).getFluid());
			if (nums == null) {
				return;
			}
			e.setCanceled(true);
			Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("textures/misc/underwater.png"));
			Tessellator tessellator = Tessellator.getInstance();
			VertexBuffer worldrenderer = tessellator.getWorldRenderer();
			float f = e.player.getBrightness(e.renderPartialTicks);
			GlStateManager.color(f, f, f, 0.5F);
			float[] nums = JuiceRegistry.instance.getColor(((GeneralFluid)Minecraft.getMinecraft().theWorld.getBlockState(e.blockPos).getBlock()).getFluid());
			GlStateManager.color(nums[0], nums[1], nums[2], 0.5f);
			GlStateManager.setFog(2048);

			if (e.player instanceof EntityLivingBase && ((EntityLivingBase)e.player).isPotionActive(Potion.waterBreathing))
			{
				GlStateManager.setFogDensity(0.01F);
			}
			else
			{
				GlStateManager.setFogDensity(0.1F - (float) EnchantmentHelper.getRespiration(e.player) * 0.03F);
			}
			GlStateManager.enableBlend();
			GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
			GlStateManager.pushMatrix();
			float f7 = -e.player.rotationYaw / 64.0F;
			float f8 = e.player.rotationPitch / 64.0F;
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
}

