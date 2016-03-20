package dmf444.ExtraFood.Client.modelbake;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import dmf444.ExtraFood.Common.items.nbt.NBTFoodRegistry;
import dmf444.ExtraFood.Common.items.nbt.NBTFoodSpecs;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.*;
import org.apache.commons.lang3.tuple.Pair;

import javax.vecmath.Matrix4f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

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
    public IFlexibleBakedModel bake(IModelState state, VertexFormat format, Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter) {
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

        IFlexibleBakedModel model = new ItemLayerModel(objectBuilder.build()).bake(state, format, bakedTextureGetter);
        builder.addAll(model.getGeneralQuads());

        return new ModelNBTFoodInner(this, builder.build(), base, format, transformMap);
    }

    @Override
    public IModelState getDefaultState() {
        return TRSRTransformation.identity();
    }

    @Override
    public IModel retexture(ImmutableMap<String, String> textures) {
        return this;
    }

    public static class ModelNBTFoodInner extends ItemLayerModel.BakedModel implements ISmartItemModel, IPerspectiveAwareModel {

        private final ImmutableMap<ItemCameraTransforms.TransformType, TRSRTransformation> transforms;
        private final NBTFoodModel parent;
        private final Map<ArrayList<String>, IFlexibleBakedModel> cache;

        public ModelNBTFoodInner(NBTFoodModel parent, ImmutableList<BakedQuad> quads, TextureAtlasSprite particle, VertexFormat fmt, ImmutableMap<ItemCameraTransforms.TransformType, TRSRTransformation> transforms) {
            super(quads, particle, fmt);
            this.parent = parent;
            this.transforms = transforms;
            this.cache = Maps.newHashMap();
        }

        @Override
        public Pair<? extends IFlexibleBakedModel, Matrix4f> handlePerspective(ItemCameraTransforms.TransformType cameraTransformType) {
            return MapWrapper.handlePerspective(this, transforms, cameraTransformType);
        }

        @Override
        public IBakedModel handleItemState(ItemStack stack) {

            ArrayList<String> dtat = new ArrayList<>();
            for (String key : stack.getTagCompound().getKeySet()){
                if (stack.getTagCompound().hasKey(key, 1)) {
                    if (stack.getTagCompound().getBoolean(key)){
                        dtat.add(key);
                    }
                }
            }

            if (!cache.containsKey(dtat)) {
                Joiner joiner = Joiner.on(";");
                IModel model = parent.process(ImmutableMap.of("food", parent.nbtFood.name, "data", joiner.join(dtat)));
                Function<ResourceLocation, TextureAtlasSprite> textureGetter;
                textureGetter = new Function<ResourceLocation, TextureAtlasSprite>()
                {
                    public TextureAtlasSprite apply(ResourceLocation location)
                    {
                        return Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(location.toString());
                    }
                };

                IFlexibleBakedModel bakedModel = model.bake(new SimpleModelState(transforms), this.getFormat(), textureGetter);
                cache.put(dtat, bakedModel);
                return bakedModel;
            }

            return cache.get(dtat);
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
