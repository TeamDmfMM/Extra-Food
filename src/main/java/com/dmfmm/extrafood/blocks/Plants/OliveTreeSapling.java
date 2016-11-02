package com.dmfmm.extrafood.blocks.Plants;

import dmf444.ExtraFood.Common.WorldGen.OliveWorldGenTrees;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;


public class OliveTreeSapling extends BananaTreeSapling {



    public OliveTreeSapling(){
        this.setBlockBounds(0.2F, 0.0F, 0.2F, 0.8F, 0.7F, 0.8F);
    }

    @Override
    public void generateTree(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(worldIn, rand, pos)) return;
        Object object = rand.nextInt(14) == 0 ? new WorldGenBigTree(true) :  new OliveWorldGenTrees(false, 6, 3, 3, true);
        int i1 = 0;
        int j1 = 0;



        IBlockState iblockstate1 = Blocks.air.getDefaultState();
        worldIn.setBlockState(pos, iblockstate1, 4);


        if (!((WorldGenerator)object).generate(worldIn, rand, pos.add(i1, 0, j1)))
        {
            worldIn.setBlockState(pos, state, 4);
        }
    }


}
