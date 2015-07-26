package dmf444.ExtraFood.Client.modelbake;

import com.google.common.primitives.Ints;
import dmf444.ExtraFood.Common.items.nbt.NBTFood;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemTransformVec3f;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.client.model.ISmartItemModel;

import javax.vecmath.Vector3f;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mincrmatt12. Do not copy this or you will have to face
 * our legal team. (dmf444)
 */
@SuppressWarnings("deprecation")
public class NBTFoodSmartItemModel implements ISmartItemModel {

    String baseFood = "minecraft:blocks/diamond_block"; // Again, placeholders that will never be seen
    ArrayList<String> tex = new ArrayList<>();

    IBakedModel exist;

    public NBTFoodSmartItemModel(IBakedModel e){


        exist = e;

    }

    @Override
    public IBakedModel handleItemState(ItemStack stack) {

        String b = ((NBTFood) stack.getItem()).getBase();
        ArrayList<String> t = ((NBTFood) stack.getItem()).getIconNames(stack);

        baseFood = b;
        tex = t;

        return this;

    }

    @Override
    public List getFaceQuads(EnumFacing p_177551_1_) {

        return getQuadsForTextures(tex);
    }

    @Override
    public List getGeneralQuads() {
        return exist.getGeneralQuads();
    }

    @Override
    public boolean isAmbientOcclusion() {
        return true;
    }

    @Override
    public boolean isGui3d() {
        return false;
    }

    @Override
    public boolean isBuiltInRenderer() {
        return false;
    }

    @Override
    public TextureAtlasSprite getTexture() {
        return Minecraft.getMinecraft().getTextureMapBlocks()
                .getAtlasSprite("minecraft:blocks/diamond_block"); // Yes, this is silly, but it is a placeholder so the game doesn't crash
    }

    private static final ItemCameraTransforms cameraTransforms = new ItemCameraTransforms(
            new ItemTransformVec3f(new Vector3f(90.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, -0.2F), new Vector3f(-1.0F, -1.0F, 1.0F)),//tp
            new ItemTransformVec3f(new Vector3f(10F, -40F, -5.0F), new Vector3f(-0.35F, 0.2F, 0.15F), new Vector3f(1.0F, 1.0F, 1.0F)),//fp
            new ItemTransformVec3f(new Vector3f(0F, 0F, 0.0F), new Vector3f(), new Vector3f(1.0F, 1.0F, 1.0F)),//head
            new ItemTransformVec3f(new Vector3f(0F, 0F, 0.0F), new Vector3f(0.0F, -0.05F, 0.F), new Vector3f(1.0F, 1.0F, 1.0F))//gui
    );

    @Override
    public ItemCameraTransforms getItemCameraTransforms()
    {
        return cameraTransforms;
    }

    private static ItemCameraTransforms SCALED;

    public List<BakedQuad> getQuadsForTextures( ArrayList<String> texLocations) {

        TextureAtlasSprite t = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(baseFood);

        ArrayList<BakedQuad> extras = new ArrayList<>();



        final float center1 = 0.5f;
        final float center2 = 0.5f;
        final float size = 1.0f;

        final float BUILTIN_GEN_ITEM_THICKNESS = 1/16.0F;
        final float BUILTIN_GEN_ITEM_Z_CENTRE = 0.5F;
        final float BUILTIN_GEN_ITEM_Z_MAX = BUILTIN_GEN_ITEM_Z_CENTRE + BUILTIN_GEN_ITEM_THICKNESS / 2.0F;
        final float BUILTIN_GEN_ITEM_Z_MIN = BUILTIN_GEN_ITEM_Z_CENTRE - BUILTIN_GEN_ITEM_THICKNESS / 2.0F;
        final float SOUTH_FACE_POSITION = 1.0F;  // the south face of the cube is at z = 1.0F
        final float NORTH_FACE_POSITION = 0.0F;  // the north face of the cube is at z = 0.0F

        final float DISTANCE_BEHIND_SOUTH_FACE = SOUTH_FACE_POSITION - BUILTIN_GEN_ITEM_Z_MAX;
        final float DISTANCE_BEHIND_NORTH_FACE = BUILTIN_GEN_ITEM_Z_MIN - NORTH_FACE_POSITION;

        int r0 = 0;

        float delta = 0.000f;





        delta += 0.001f;



        for (String i : texLocations) {
            TextureAtlasSprite t2 = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(i);

            BakedQuad front = createBakedQuadForFace(center1- 0.031f, size,
                    center2, size, -DISTANCE_BEHIND_SOUTH_FACE + delta,
                    r0,
                    t2,
                    EnumFacing.SOUTH);

            BakedQuad back = createBakedQuadForFace(center1, size,
                    center2, size,
                    -DISTANCE_BEHIND_NORTH_FACE + delta,
                    r0, t2, EnumFacing.NORTH);

            delta += 0.001f;

            extras.add(front);
            extras.add(back);
        }

        return extras;

    }

    private int[] vertexToInts(float x, float y, float z, int color, TextureAtlasSprite texture, float u, float v)
    {
        return new int[] {
                Float.floatToRawIntBits(x),
                Float.floatToRawIntBits(y),
                Float.floatToRawIntBits(z),
                color,
                Float.floatToRawIntBits(texture.getInterpolatedU(u)),
                Float.floatToRawIntBits(texture.getInterpolatedV(v)),
                0
        };
    }

    private BakedQuad createBakedQuadForFace(float centreLR, float width, float centreUD, float height, float forwardDisplacement,
                                             int itemRenderLayer,
                                             TextureAtlasSprite texture, EnumFacing face)
    {
        float x1, x2, x3, x4;
        float y1, y2, y3, y4;
        float z1, z2, z3, z4;
        final float CUBE_MIN = 0.0F;
        final float CUBE_MAX = 1.0F;

        switch (face) {
            case UP: {
                x1 = x2 = centreLR + width/2.0F;
                x3 = x4 = centreLR - width/2.0F;
                z1 = z4 = centreUD + height/2.0F;
                z2 = z3 = centreUD - height/2.0F;
                y1 = y2 = y3 = y4 = CUBE_MAX + forwardDisplacement;
                break;
            }
            case DOWN: {
                x1 = x2 = centreLR + width/2.0F;
                x3 = x4 = centreLR - width/2.0F;
                z1 = z4 = centreUD - height/2.0F;
                z2 = z3 = centreUD + height/2.0F;
                y1 = y2 = y3 = y4 = CUBE_MIN - forwardDisplacement;
                break;
            }
            case WEST: {
                z1 = z2 = centreLR + width/2.0F;
                z3 = z4 = centreLR - width/2.0F;
                y1 = y4 = centreUD - height/2.0F;
                y2 = y3 = centreUD + height/2.0F;
                x1 = x2 = x3 = x4 = CUBE_MIN - forwardDisplacement;
                break;
            }
            case EAST: {
                z1 = z2 = centreLR - width/2.0F;
                z3 = z4 = centreLR + width/2.0F;
                y1 = y4 = centreUD - height/2.0F;
                y2 = y3 = centreUD + height/2.0F;
                x1 = x2 = x3 = x4 = CUBE_MAX + forwardDisplacement;
                break;
            }
            case NORTH: {
                x1 = x2 = centreLR - width/2.0F;
                x3 = x4 = centreLR + width/2.0F;
                y1 = y4 = centreUD - height/2.0F;
                y2 = y3 = centreUD + height/2.0F;
                z1 = z2 = z3 = z4 = CUBE_MIN - forwardDisplacement;
                break;
            }
            case SOUTH: {
                x1 = x2 = centreLR + width/2.0F;
                x3 = x4 = centreLR - width/2.0F;
                y1 = y4 = centreUD - height/2.0F;
                y2 = y3 = centreUD + height/2.0F;
                z1 = z2 = z3 = z4 = CUBE_MAX + forwardDisplacement;
                break;
            }
            default: {
                assert false : "Unexpected facing in createBakedQuadForFace:" + face;
                return null;
            }
        }

        return new BakedQuad(Ints.concat(vertexToInts(x1, y1, z1, Color.WHITE.getRGB(), texture, 16, 16),
                vertexToInts(x2, y2, z2, Color.WHITE.getRGB(), texture, 16, 0),
                vertexToInts(x3, y3, z3, Color.WHITE.getRGB(), texture, 0, 0),
                vertexToInts(x4, y4, z4, Color.WHITE.getRGB(), texture, 0, 16)),
                itemRenderLayer, face);
    }
}
