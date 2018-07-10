package com.dmfmm.extrafood.client.modelbake.GlassBottle;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.model.*;
import net.minecraftforge.client.model.pipeline.UnpackedBakedQuad;
import net.minecraftforge.common.model.IModelPart;
import net.minecraftforge.common.model.IModelState;
import net.minecraftforge.common.model.TRSRTransformation;
import net.minecraftforge.fluids.*;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.commons.lang3.tuple.Pair;

import javax.vecmath.Matrix4f;
import javax.vecmath.Quat4f;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static net.minecraftforge.client.model.ItemTextureQuadConverter.genQuad;

@SideOnly(Side.CLIENT)
public final class ModelDynGlassBottle implements IModel, IModelCustomData, IRetexturableModel
{
    // minimal Z offset to prevent depth-fighting
    private static final float NORTH_Z_BASE = 7.496f / 16f;
    private static final float SOUTH_Z_BASE = 8.504f / 16f;
    private static final float NORTH_Z_FLUID = 7.498f / 16f;
    private static final float SOUTH_Z_FLUID = 8.502f / 16f;

    public static final IModel MODEL = new ModelDynGlassBottle();

    private final ResourceLocation baseLocation;
    private final ResourceLocation liquidLocation;
    private final ResourceLocation coverLocation;

    private final Fluid fluid;
    private final boolean flipGas;
    private final QuadConverter qc;

    private IModel empty;

    public ModelDynGlassBottle()
    {
        this(null, null, null, null, false, QuadConverter.NONE);
    }

    public ModelDynGlassBottle(ResourceLocation baseLocation, ResourceLocation liquidLocation, ResourceLocation coverLocation, Fluid fluid, boolean flipGas, QuadConverter qc)
    {
        this.baseLocation = baseLocation;
        this.liquidLocation = liquidLocation;
        this.coverLocation = coverLocation;
        this.fluid = fluid;
        this.flipGas = flipGas;
        this.qc = qc == null ? QuadConverter.ONE : qc;
    }

    @Override
    public Collection<ResourceLocation> getDependencies()
    {
        return ImmutableList.of(new ResourceLocation("extrafood:item/glassbottle"));
    }

    @Override
    public Collection<ResourceLocation> getTextures()
    {
        ImmutableSet.Builder<ResourceLocation> builder = ImmutableSet.builder();
        if (baseLocation != null)
            builder.add(baseLocation);
        if (liquidLocation != null)
            builder.add(liquidLocation);
        if (coverLocation != null)
            builder.add(coverLocation);

        return builder.build();
    }

    @Override
    public IBakedModel bake(IModelState state, VertexFormat format,
                            Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter)
    {

        ImmutableMap<TransformType, TRSRTransformation> transformMap = IPerspectiveAwareModel.MapWrapper.getTransforms(state);

        // if the fluid is a gas wi manipulate the initial state to be rotated 180? to turn it upside down
        if (flipGas && fluid != null && fluid.isGaseous())
        {
            state = new ModelStateComposition(state, TRSRTransformation.blockCenterToCorner(new TRSRTransformation(null, new Quat4f(0, 0, 1, 0), null, null)));
        }

        TRSRTransformation transform = state.apply(Optional.<IModelPart>absent()).or(TRSRTransformation.identity());
        TextureAtlasSprite fluidSprite = null;
        ImmutableList.Builder<BakedQuad> builder = ImmutableList.builder();
        if (fluid != null) {
            fluidSprite = bakedTextureGetter.apply(fluid.getStill());
        }
        if (baseLocation != null) {
            // build base (insidest)
            IBakedModel model = (new ItemLayerModel(ImmutableList.of(baseLocation))).bake(state, format, bakedTextureGetter);
            builder.addAll(model.getQuads(null, null, 0));
        }
        if (liquidLocation != null && fluidSprite != null) {
            TextureAtlasSprite liquid = bakedTextureGetter.apply(liquidLocation);
            // build liquid layer (inside)
            builder.addAll(qc.convertTextureHorizontal(format, transform, liquid, fluidSprite, NORTH_Z_FLUID, EnumFacing.NORTH, fluid.getColor()));
            builder.addAll(qc.convertTextureHorizontal(format, transform, liquid, fluidSprite, SOUTH_Z_FLUID, EnumFacing.SOUTH, fluid.getColor()));
        }
        if (coverLocation != null) {
            // cover (the actual item around the other two)
            TextureAtlasSprite base = bakedTextureGetter.apply(coverLocation);
            builder.add(genQuad(format, transform, 0, 0, 16, 16, NORTH_Z_BASE, base, EnumFacing.NORTH, 0xffffffff));
            builder.add(genQuad(format, transform, 0, 0, 16, 16, SOUTH_Z_BASE, base, EnumFacing.SOUTH, 0xffffffff));
        }


        return new BakedBottle(this, builder.build(), fluidSprite, format, Maps.immutableEnumMap(transformMap), Maps.<String, IBakedModel>newHashMap());
    }

    @Override
    public IModelState getDefaultState()
    {
        return TRSRTransformation.identity();
    }

    /**
     * Sets the liquid in the model.
     * fluid - Name of the fluid in the FluidRegistry
     * flipGas - If "true" the model will be flipped upside down if the liquid is a gas. If "false" it wont
     * <p/>
     * If the fluid can't be found, water is used
     */
    @Override
    public ModelDynGlassBottle process(ImmutableMap<String, String> customData)
    {
        String fluidName = customData.get("fluid");
        Fluid fluid = FluidRegistry.getFluid(fluidName);

        if (fluid == null) fluid = this.fluid;

        boolean flip = flipGas;
        if (customData.containsKey("flipGas"))
        {
            String flipStr = customData.get("flipGas");
            if (flipStr.equals("true")) flip = true;
            else if (flipStr.equals("false")) flip = false;
            else
                throw new IllegalArgumentException(String.format("DynBucket custom data \"flipGas\" must have value \'true\' or \'false\' (was \'%s\')", flipStr));
        }

        QuadConverter qc = QuadConverter.FULL;

        if (customData.containsKey("amt")) {
            int amt = Integer.parseInt(customData.get("amt"));
            if (amt >= 1000) qc = QuadConverter.FULL;
            else if (amt >= 665) qc = QuadConverter.MID;
            else if (amt != 0) qc = QuadConverter.ONE;
            else {
                qc = QuadConverter.NONE;
            }
        }

        // create new model with correct liquid
        return new ModelDynGlassBottle(baseLocation, liquidLocation, coverLocation, fluid, flip, qc);
    }

    /**
     * Allows to use different textures for the model.
     * There are 3 layers:
     * base - The empty bucket/container
     * fluid - A texture representing the liquid portion. Non-transparent = liquid
     * cover - An overlay that's put over the liquid (optional)
     * <p/>
     * If no liquid is given a hardcoded variant for the bucket is used.
     */
    @Override
    public ModelDynGlassBottle retexture(ImmutableMap<String, String> textures)
    {

        ResourceLocation base = baseLocation;
        ResourceLocation liquid = liquidLocation;
        ResourceLocation cover = coverLocation;

        if (textures.containsKey("base"))
            base = new ResourceLocation(textures.get("base"));
        if (textures.containsKey("fluid"))
            liquid = new ResourceLocation(textures.get("fluid"));
        if (textures.containsKey("cover"))
            cover = new ResourceLocation(textures.get("cover"));

        return new ModelDynGlassBottle(base, liquid, cover, fluid, flipGas, qc);
    }

    private enum QuadConverter {
        FULL(1),
        MID(127),
        ONE(200),
        NONE(300);

        private int thresh;

        QuadConverter(int thresh) {
            this.thresh = thresh;
        }

        private boolean isVisible(int color) {
            return (color >> 24 & 255) >= thresh;
        }

        public List<UnpackedBakedQuad> convertTextureHorizontal(VertexFormat format, TRSRTransformation transform, TextureAtlasSprite template, TextureAtlasSprite sprite, float z, EnumFacing facing, int color)
        {
            int w = template.getIconWidth();
            int h = template.getIconHeight();
            float wScale = 16f / (float)w;
            float hScale = 16f / (float)h;
            int[] data = template.getFrameTextureData(0)[0];
            List<UnpackedBakedQuad> quads = Lists.newArrayList();

            // the upper left x-position of the current quad
            int start = -1;
            for (int y = 0; y < h; y++)
            {
                for (int x = 0; x < w; x++)
                {
                    // current pixel
                    int pixel = data[y * w + x];

                    // no current quad but found a new one
                    if (start < 0 && isVisible(pixel))
                    {
                        start = x;
                    }
                    // got a current quad, but it ends here
                    if (start >= 0 && !isVisible(pixel))
                    {
                        // we now check if the visibility of the next row matches the one fo the current row
                        // if they are, we can extend the quad downwards
                        int endY = y + 1;
                        boolean sameRow = true;
                        while (sameRow)
                        {
                            for (int i = 0; i < w; i++)
                            {
                                int px1 = data[y * w + i];
                                int px2 = data[endY * w + i];
                                if (isVisible(px1) != isVisible(px2))
                                {
                                    sameRow = false;
                                    break;
                                }
                            }
                            if (sameRow)
                            {
                                endY++;
                            }
                        }

                        // create the quad
                        quads.add(genQuad(format, transform,
                                (float)start * wScale,
                                (float)y * hScale,
                                (float)x * wScale,
                                (float)endY * hScale,
                                z, sprite, facing, color));

                        // update Y if all the rows match. no need to rescan
                        if (endY - y > 1)
                        {
                            y = endY - 1;
                        }
                        // clear current quad
                        start = -1;
                    }
                }
            }

            return quads;
        }
    }

    public enum LoaderBottle implements ICustomModelLoader
    {
        instance;

        @Override
        public boolean accepts(ResourceLocation modelLocation)
        {
            return modelLocation.getResourceDomain().equals("extrafood") && modelLocation.getResourcePath().contains("glassbottles");
        }

        @Override
        public IModel loadModel(ResourceLocation modelLocation)
        {
            return MODEL;
        }

        @Override
        public void onResourceManagerReload(IResourceManager resourceManager)
        {
            // no need to clear cache since we create a new model instance
        }
    }

    private static final class BakedBottleOverrideHandler extends ItemOverrideList
    {
        public static final BakedBottleOverrideHandler INSTANCE = new BakedBottleOverrideHandler();
        private IBakedModel empty= null;

        private BakedBottleOverrideHandler()
        {
            super(ImmutableList.<ItemOverride>of());
        }

        @Override
        public IBakedModel handleItemState(IBakedModel originalModel, ItemStack stack, World world, EntityLivingBase entity)
        {
            FluidStack fluidStack = null;
            if(stack.hasCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, EnumFacing.UP)){
                fluidStack = (FluidStack) stack.getCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, EnumFacing.UP).getTankProperties()[0].getContents();
            }
            if (fluidStack == null)
            {
                return originalModel;
            }

            BakedBottle model = (BakedBottle)originalModel;

            Fluid fluid = fluidStack.getFluid();
            String name = fluid.getName();

            if (!model.cache.containsKey(name + String.valueOf(fluidStack.amount)))
            {
                IModel parent = model.parent.process(ImmutableMap.of("fluid", name, "amt", String.valueOf(fluidStack.amount)));
                Function<ResourceLocation, TextureAtlasSprite> textureGetter;
                textureGetter = new Function<ResourceLocation, TextureAtlasSprite>()
                {
                    public TextureAtlasSprite apply(ResourceLocation location)
                    {
                        return Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(location.toString());
                    }
                };

                IBakedModel bakedModel = parent.bake(new SimpleModelState(model.transforms), model.format, textureGetter);
                model.cache.put(name + String.valueOf(fluidStack.amount), bakedModel);
                return bakedModel;
            }

            return model.cache.get(name + String.valueOf(fluidStack.amount));
        }
    }

    // the dynamic bucket is based on the empty bucket
    private static final class BakedBottle implements IPerspectiveAwareModel
    {

        private final ModelDynGlassBottle parent;
        // FIXME: guava cache?
        private final Map<String, IBakedModel> cache; // contains all the baked models since they'll never change
        private final ImmutableMap<TransformType, TRSRTransformation> transforms;
        private final ImmutableList<BakedQuad> quads;
        private final TextureAtlasSprite particle;
        private final VertexFormat format;

        public BakedBottle(ModelDynGlassBottle parent,
                           ImmutableList<BakedQuad> quads, TextureAtlasSprite particle, VertexFormat format, ImmutableMap<ItemCameraTransforms.TransformType, TRSRTransformation> transforms,
                           Map<String, IBakedModel> cache)
        {
            this.quads = quads;
            this.particle = particle;
            this.format = format;
            this.parent = parent;
            this.transforms = transforms;
            this.cache = cache;
        }

        @Override
        public ItemOverrideList getOverrides()
        {
            return BakedBottleOverrideHandler.INSTANCE;
        }

        @Override
        public Pair<? extends IBakedModel, Matrix4f> handlePerspective(TransformType cameraTransformType)
        {
            return IPerspectiveAwareModel.MapWrapper.handlePerspective(this, transforms, cameraTransformType);
        }

        @Override
        public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, long rand)
        {
            if(side == null) return quads;
            return ImmutableList.of();
        }

        public boolean isAmbientOcclusion() { return true;  }
        public boolean isGui3d() { return false; }
        public boolean isBuiltInRenderer() { return false; }
        public TextureAtlasSprite getParticleTexture() { return particle; }
        public ItemCameraTransforms getItemCameraTransforms() { return ItemCameraTransforms.DEFAULT; }
    }
}
