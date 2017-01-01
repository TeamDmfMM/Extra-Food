package com.dmfmm.extrafood.events;


import com.dmfmm.extrafood.init.BlockLoader;
import com.dmfmm.extrafood.init.ItemLoader;
import com.dmfmm.extrafood.utilities.ConfigHandler;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.HashMap;
import java.util.Map;

/*
 * @authour SpaceToad
 *
 * Modified version of the bucket handler publicly available from BuildCraft's Repositories on Github
 *
 * If you own this an would like it removed, please ask!
 */

public class BucketEvent {


    public static BucketEvent INSTANCE = new BucketEvent();
    public Map<Block, Item> buckets = new HashMap<Block, Item>();


    private BucketEvent() {
        buckets.put(BlockLoader.BANANA_JUICE_BLOCK, ItemLoader.BUCKET_BANANA);
        buckets.put(BlockLoader.STRAWBERRY_JUICE_BLOCK, ItemLoader.BUCKET_STRAWBERRY);
        buckets.put(BlockLoader.CARROT_JUICE_BLOCK, ItemLoader.BUCKET_CARROT);
        if(ConfigHandler.overrideWater){
            buckets.put(Blocks.WATER, ItemLoader.BUCKET_SEA_WATER);
        }
    }


    @SubscribeEvent
    public void onBucketFill(FillBucketEvent event) {
        if (event.getTarget() == null) {
            return;
        }
        ItemStack result = fillCustomBucket(event.getWorld(), event.getTarget());


        if (result == null)
            return;


        event.setFilledBucket(result);
        event.setResult(Result.ALLOW);
    }


    private ItemStack fillCustomBucket(World world, RayTraceResult pos) {


        IBlockState state = world.getBlockState(pos.getBlockPos());
        Item bucket = buckets.get(state.getBlock());

        if (bucket != null && state.getBlock().getMetaFromState(state) == 0) {
            world.setBlockToAir(pos.getBlockPos());
            return new ItemStack(bucket);
        } else
            return null;


    }
}