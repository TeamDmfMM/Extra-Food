package com.dmfmm.extrafood.blocks.Plants;

import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Common.items.ItemLoader;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class PeanutBush extends StrawberryBush {



	public PeanutBush(Material material){
		super(material);
	}

    @Override
    protected Item getSeed()
    {
        return Item.getItemFromBlock(BlockLoader.peanutbush);
    }

    @Override
    protected void output(IBlockState state, World world, BlockPos pos){
        int meta = state.getBlock().getMetaFromState(state);
        switch (meta) {
            case 7:
            case 8:
                if (!world.isRemote) {
                    ItemStack item1 = new ItemStack(ItemLoader.peanut, 4);
                    Entity Ientity1 = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), item1);
                    world.spawnEntityInWorld(Ientity1);
                    world.setBlockState(pos, state.getBlock().getStateFromMeta(0), 2);
                    break;
                }
            default:
                break;
        }
    }

}
