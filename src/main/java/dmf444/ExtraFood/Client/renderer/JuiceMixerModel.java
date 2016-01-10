package dmf444.ExtraFood.Client.renderer;


import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import dmf444.ExtraFood.Core.lib.GuiLib;
import dmf444.ExtraFood.Core.util.EFLog;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.crash.CrashReport;
import net.minecraft.util.ReportedException;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.Attributes;
import net.minecraftforge.client.model.IFlexibleBakedModel;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.obj.OBJModel;
import net.minecraftforge.client.model.pipeline.LightUtil;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

import java.io.IOException;
import java.util.List;

@SideOnly(Side.CLIENT)
public class JuiceMixerModel {

	private IFlexibleBakedModel oven;

	private static final Function<ResourceLocation, TextureAtlasSprite> TEXTUREGETTER = new Function<ResourceLocation, TextureAtlasSprite>() {
		@Override
		public TextureAtlasSprite apply(ResourceLocation input) {
			EFLog.fatal(input.toString() +" ::::" +Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(input.toString()));
			return Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(input.toString());
		}
	};

	public JuiceMixerModel() {
		try {
			// Load the OBJ
			OBJModel model = ((OBJModel) OBJLoader.instance.loadModel(new ResourceLocation("extrafood:models/block/juiceMixer.obj")));

			// Apply the texture and flip the v's of the model
			IModel ovenModel = ((OBJModel) model.retexture(ImmutableMap.of("#Material", "extrafood:models/JuiceMixer1.png"))).process(ImmutableMap.of("flip-v", "true"));

			oven = ovenModel.bake(new OBJModel.OBJState(ImmutableList.of("Cube"), false), Attributes.DEFAULT_BAKED_FORMAT, TEXTUREGETTER);


		} catch (IOException e) {
			throw new ReportedException(new CrashReport("Error making OVEN for TESR!", e));
		}
	}


	public void renderModel()
	{
		renderModel(oven, -1);
	}

	private void renderModel(IFlexibleBakedModel model, int color)
	{
		Tessellator tessellator = Tessellator.getInstance();
		WorldRenderer worldrenderer = tessellator.getWorldRenderer();
		worldrenderer.begin(GL11.GL_QUADS, model.getFormat());

		this.renderQuads(worldrenderer, model.getGeneralQuads(), color);
		tessellator.draw();
	}

	private void renderQuads(WorldRenderer renderer, List<BakedQuad> quads, int color)
	{
		for (BakedQuad bakedquad : quads)
			LightUtil.renderQuadColor(renderer, bakedquad, color);
	}

}

