package dmf444.ExtraFood.Common.EventHandler;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Common.items.ItemLoader;
import dmf444.ExtraFood.util.ConfigHandler;

/*
 * @authour SpaceToad
 * 
 * Modified version of the bucket handler publicly available from BuildCraft's Repositories on Github
 * 
 * If you own this an would like it removed, please ask!
 */

public class BucketHandler {


    public static BucketHandler INSTANCE = new BucketHandler();
    public Map<Block, Item> buckets = new HashMap<Block, Item>();


    private BucketHandler() {
    	buckets.put(BlockLoader.Bbananajuice, ItemLoader.bucketbanana);
    	buckets.put(BlockLoader.Bstrawberryjuice, ItemLoader.bucketstrawberry);
    	buckets.put(BlockLoader.Bcarrotjuice, ItemLoader.bucketcarrot);
    	if(ConfigHandler.overrideWater){
    		buckets.put(Blocks.water, ItemLoader.bucketseaWater);
    	}
    }


    @SubscribeEvent
    public void onBucketFill(FillBucketEvent event) {


            ItemStack result = fillCustomBucket(event.world, event.target);


            if (result == null)
                    return;


            event.result = result;
            event.setResult(Result.ALLOW);
    }


    private ItemStack fillCustomBucket(World world, MovingObjectPosition pos) {


            Block block = world.getBlock(pos.blockX, pos.blockY, pos.blockZ);


            Item bucket = buckets.get(block);
            if (bucket != null && world.getBlockMetadata(pos.blockX, pos.blockY, pos.blockZ) == 0) {
                    world.setBlockToAir(pos.blockX, pos.blockY, pos.blockZ);
                    return new ItemStack(bucket);
            } else
                    return null;


    }
}
