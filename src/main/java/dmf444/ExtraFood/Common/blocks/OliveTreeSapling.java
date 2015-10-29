package dmf444.ExtraFood.Common.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dmf444.ExtraFood.Common.WorldGen.BananaWorldGenTrees;
import dmf444.ExtraFood.Common.WorldGen.OliveWorldGenTrees;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

/**
 * Created by dmf444 on 10/18/2015.
 */
public class OliveTreeSapling extends BananaTreeSapling{

    public IIcon symba;

    public OliveTreeSapling(){
    this.setBlockTextureName("extrafood:BlockOliveSapling");
    }

    public void growz(World worldIn, int x, int y, int z, Random rand)
    {
        if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(worldIn, rand, x, y, z)) return;
        Object object = rand.nextInt(14) == 0 ? new WorldGenBigTree(true) :  new OliveWorldGenTrees(true, 6, 3, 3, true);
        int i1 = 0;
        int j1 = 0;
        int l = worldIn.getBlockMetadata(x, y, z) & 7;


        Block iblockstate1 = Blocks.air;
        worldIn.setBlock(x, y, z, iblockstate1);


        if (!((WorldGenerator)object).generate(worldIn, rand, x, y, z))
        {
            worldIn.setBlock(x + i1 , y, z + j1, this, l, 4);
        }
    }
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1)
    {
        symba = par1.registerIcon("extrafood:BlockOliveSapling");

    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2)
    {
        return symba;
    }

    public void func_149879_c(World world, int x, int y, int z, Random rand)
    {
        int l = world.getBlockMetadata(x, y, z);

        if ((l & 8) == 0)
        {
            world.setBlockMetadataWithNotify(x, y, z, l | 8, 4);
        }
        else
        {
            this.growz(world, x, y, z, rand);
        }
    }

}