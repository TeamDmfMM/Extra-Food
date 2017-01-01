package com.dmfmm.extrafood.client.modelbake.NBTFood;

import com.dmfmm.extrafood.items.nbt.NBTFoodRegistry;
import com.dmfmm.extrafood.items.nbt.NBTFoodSpecs;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.model.*;
import net.minecraftforge.common.model.IModelPart;
import net.minecraftforge.common.model.IModelState;
import net.minecraftforge.common.model.TRSRTransformation;
import org.apache.commons.lang3.tuple.Pair;

import javax.vecmath.Matrix4f;
import java.io.IOException;
import java.util.*;

/**
 * Created by mincrmatt12. Do not copy this or you will have to face
 * our legal team. (dmf444)
 */
public class NBTFoodModel implements IModel, IModelCustomData, IRetexturableModel {

    NBTFoodSpecs nbtFood;
    ArrayList<String> nbtFoodAddivites;

    static NBTFoodModel MODEL = new NBTFoodModel();

    public NBTFoodModel() {
        this("pizza", new ArrayList<String>());
    }

    public NBTFoodModel(String nbtFood, ArrayList<String> strings) {
        this.nbtFood = NBTFoodRegistry.food.getSpecs(nbtFood);
        this.nbtFoodAddivites = strings;
    }

    @Override
    public IModel process(ImmutableMap<String, String> customData) {

        ArrayList<String> strings = new ArrayList<>();

        if (customData.containsKey("data")) {
            strings.addAll(Arrays.asList(customData.get("data").split(";")));
        }
        String namey = "";
        namey = customData.get("food").replaceAll("^\"+", "").replaceAll("\"+$", "");

        return new NBTFoodModel(namey, strings);
    }

    @Override
    public Collection<ResourceLocation> getDependencies() {
        return ImmutableList.of();
    }

    @Override
    public Collection<ResourceLocation> getTextures() {
        ImmutableList.Builder<ResourceLocation> builder = ImmutableList.builder();
        builder.add(new ResourceLocation(nbtFood.defualtIcon));
        for (String nbtFoodAddivite : nbtFoodAddivites) {
            builder.add(new ResourceLocation(nbtFood.additives.get(nbtFoodAddivite)));
        }
        return builder.build();
    }

    @Override
    public IBakedModel bake(IModelState state, VertexFormat format, Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter) {
        ImmutableMap<ItemCameraTransforms.TransformType, TRSRTransformation> transformMap = IPerspectiveAwareModel.MapWrapper.getTransforms(state);
        TRSRTransformation transform = state.apply(Optional.<IModelPart>absent()).or(TRSRTransformation.identity());

        TextureAtlasSprite base = bakedTextureGetter.apply(new ResourceLocation(nbtFood.defualtIcon));
        ImmutableList.Builder<BakedQuad> builder = ImmutableList.builder();

        ImmutableList.Builder<ResourceLocation> objectBuilder = ImmutableList.builder();
        objectBuilder.add(new ResourceLocation(nbtFood.defualtIcon));
        for (String a : nbtFoodAddivites) {
            try {
                ResourceLocation r = new ResourceLocation(nbtFood.additives.get(a));
                objectBuilder.add(r);
            }
            catch (NullPointerException e) {

            }
        }

        IBakedModel model = new ItemLayerModel(objectBuilder.build()).bake(state, format, bakedTextureGetter);
        builder.addAll(model.getQuads(null, null, 0));

        return new BakedNBTFoodModel(this, builder.build(), base, format, transformMap);
    }

    @Override
    public IModelState getDefaultState() {
        return TRSRTransformation.identity();
    }

    @Override
    public IModel retexture(ImmutableMap<String, String> textures) {
        return this;
    }

    private static final class BakedNBTFoodOverrideHandler extends ItemOverrideList {

        public static final BakedNBTFoodOverrideHandler INSTANCE = new BakedNBTFoodOverrideHandler();

        public BakedNBTFoodOverrideHandler() {
            super (ImmutableList.<ItemOverride>of());
        }

        @Override
        public IBakedModel handleItemState(IBakedModel originalModel, ItemStack stack, World world, EntityLivingBase entity) {

            BakedNBTFoodModel model = (BakedNBTFoodModel) originalModel;

            ArrayList<String> dtat = new ArrayList<>();
            for (String key : stack.getTagCompound().getKeySet()){
                if (stack.getTagCompound().hasKey(key, 1)) {
                    if (stack.getTagCompound().getBoolean(key)){
                        dtat.add(key);
                    }
                }
            }

            if (!model.cache.containsKey(dtat)) {
                Joiner joiner = Joiner.on(";");
                IModel model2 = model.parent.process(ImmutableMap.of("food", model.parent.nbtFood.name, "data", joiner.join(dtat)));
                Function<ResourceLocation, TextureAtlasSprite> textureGetter;
                textureGetter = new Function<ResourceLocation, TextureAtlasSprite>()
                {
                    public TextureAtlasSprite apply(ResourceLocation location)
                    {
                        return Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(location.toString());
                    }
                };

                IBakedModel bakedModel = model2.bake(new SimpleModelState(model.transforms), model.format, textureGetter);
                model.cache.put(dtat, bakedModel);
                return bakedModel;
            }

            return model.cache.get(dtat);

        }
    }

    public static class BakedNBTFoodModel implements IPerspectiveAwareModel {

        private final ImmutableMap<ItemCameraTransforms.TransformType, TRSRTransformation> transforms;
        private final NBTFoodModel parent;
        private final Map<ArrayList<String>, IBakedModel> cache;
        private final ImmutableList<BakedQuad> quads;
        private final TextureAtlasSprite particle;
        private final VertexFormat format;

        public BakedNBTFoodModel(NBTFoodModel parent, ImmutableList<BakedQuad> quads, TextureAtlasSprite particle, VertexFormat fmt, ImmutableMap<ItemCameraTransforms.TransformType, TRSRTransformation> transforms) {
            this.quads = quads;
            this.particle = particle;
            this.format = fmt;
            this.parent = parent;
            this.transforms = transforms;
            this.cache = Maps.newHashMap();
        }

        @Override
        public Pair<? extends IBakedModel, Matrix4f> handlePerspective(ItemCameraTransforms.TransformType cameraTransformType) {
            return MapWrapper.handlePerspective(this, transforms, cameraTransformType);
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

        @Override
        public ItemOverrideList getOverrides() {
            return BakedNBTFoodOverrideHandler.INSTANCE;
        }
    }
    public enum ModelLodaer implements ICustomModelLoader
    {
        instance;

        @Override
        public boolean accepts(ResourceLocation modelLocation)
        {
            return modelLocation.getResourceDomain().equals("extrafood") && modelLocation.getResourcePath().contains("nbtfood");
        }

        @Override
        public IModel loadModel(ResourceLocation modelLocation) throws IOException
        {
            return MODEL;
        }

        @Override
        public void onResourceManagerReload(IResourceManager resourceManager)
        {
            // no need to clear cache since we create a new model instance
        }
    }
}