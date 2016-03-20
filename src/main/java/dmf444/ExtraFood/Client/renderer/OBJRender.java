package dmf444.ExtraFood.Client.renderer;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.renderer.vertex.VertexFormatElement;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.crash.CrashReport;
import net.minecraft.util.ReportedException;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.Attributes;
import net.minecraftforge.client.model.IFlexibleBakedModel;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.client.model.obj.OBJModel;
import net.minecraftforge.client.model.pipeline.LightUtil;
import org.lwjgl.opengl.GL11;

import javax.annotation.Nullable;
import java.io.IOException;
import java.util.Map;

/**
 * Created by David on 1/10/2016.
 */
public class OBJRender {
    static Map<String, IFlexibleBakedModel> loadedModels = Maps.newHashMap();

    // A vertex format with normals that doesn't break the OBJ loader.
    // FIXME: Replace with DefaultvertexFormats.POSITION_TEX_COLOR_NORMAL when it works.
    public static final VertexFormat CUSTOM_FORMAT;

    static
    {
        CUSTOM_FORMAT = new VertexFormat();
        CUSTOM_FORMAT.addElement(new VertexFormatElement(0, VertexFormatElement.EnumType.FLOAT, VertexFormatElement.EnumUsage.POSITION, 3));
        CUSTOM_FORMAT.addElement(new VertexFormatElement(0, VertexFormatElement.EnumType.UBYTE, VertexFormatElement.EnumUsage.COLOR, 4));
        CUSTOM_FORMAT.addElement(new VertexFormatElement(0, VertexFormatElement.EnumType.FLOAT, VertexFormatElement.EnumUsage.UV, 2));
        CUSTOM_FORMAT.addElement(new VertexFormatElement(0, VertexFormatElement.EnumType.BYTE, VertexFormatElement.EnumUsage.NORMAL, 3));
        CUSTOM_FORMAT.addElement(new VertexFormatElement(0, VertexFormatElement.EnumType.BYTE, VertexFormatElement.EnumUsage.PADDING, 1));
    }

    public static void init()
    {
        IResourceManager rm = Minecraft.getMinecraft().getResourceManager();
        if (rm instanceof IReloadableResourceManager)
        {
            ((IReloadableResourceManager) rm).registerReloadListener(new IResourceManagerReloadListener()
            {
                @Override
                public void onResourceManagerReload(IResourceManager ignored)
                {
                    loadedModels.clear();
                }
            });
        }
    }

    public static void renderModel(IFlexibleBakedModel model, int color)
    {
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.begin(GL11.GL_QUADS, model.getFormat());
        for (BakedQuad bakedquad : model.getGeneralQuads())
        {
            LightUtil.renderQuadColor(worldrenderer, bakedquad, color);
        }
        tessellator.draw();
    }

    public static IFlexibleBakedModel loadModel(String resourceName)
    {
        IFlexibleBakedModel model = loadedModels.get(resourceName);
        if (model != null)
            return model;

        try
        {
            final TextureMap textures = Minecraft.getMinecraft().getTextureMapBlocks();
            OBJModel modelz = ((OBJModel) OBJLoader.instance.loadModel(new ResourceLocation("extrafood:models/"+resourceName)));
            IModel mod = ModelLoaderRegistry.getModel(new ResourceLocation("extrafood:"+resourceName));
            if(modelz != null){
                modelz.process(ImmutableMap.of("flip-v", "true"));
                model = modelz.bake(modelz.getDefaultState(), Attributes.DEFAULT_BAKED_FORMAT,
                        new Function<ResourceLocation, TextureAtlasSprite>()
                        {
                            @Nullable
                            @Override
                            public TextureAtlasSprite apply(@Nullable ResourceLocation location)
                            {
                                if (location == null)
                                    return null;
                                return textures.getAtlasSprite(location.toString());
                            }
                        });
            }else {
                model = mod.bake(mod.getDefaultState(), Attributes.DEFAULT_BAKED_FORMAT,
                        new Function<ResourceLocation, TextureAtlasSprite>() {
                            @Nullable
                            @Override
                            public TextureAtlasSprite apply(@Nullable ResourceLocation location) {
                                if (location == null)
                                    return null;
                                return textures.getAtlasSprite(location.toString());
                            }
                        });
            }
            return model;
        }
        catch (IOException e)
        {
            throw new ReportedException(new CrashReport("Error loading custom model " + resourceName, e));
        }
    }
}
