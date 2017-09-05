package com.dmfmm.extrafood.blocks.Plants;


import com.dmfmm.extrafood.worldgen.gen.OrangeTreeGenerator;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

/**
 * Created by TeamDMFMM on 3/25/2016. Code originally written
 * for ExtraFood1.7. Do not copy without permission,
 * because that is just mean. Code is VISIBLE SOURCE, therfore
 * credit us, just don't steal large portions of this.
 */
public class OrangeTreeSapling extends BananaTreeSapling{

    public OrangeTreeSapling(String name){
        super(name);
    }

    @Override
    public void generateTree(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(worldIn, rand, pos)) return;
        Object object = new OrangeTreeGenerator();
        int i1 = 0;
        int j1 = 0;



        IBlockState iblockstate1 = Blocks.AIR.getDefaultState();
        worldIn.setBlockState(pos, iblockstate1, 4);


        if (!((WorldGenerator)object).generate(worldIn, rand, pos.add(i1, 0, j1)))
        {
            worldIn.setBlockState(pos, state, 4);
        }
    }


}
