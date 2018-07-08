package com.dmfmm.extrafood.init;


import com.dmfmm.extrafood.blocks.ChocolateCake;
import com.dmfmm.extrafood.blocks.ICustomItemBlock;
import com.dmfmm.extrafood.blocks.Machines.*;
import com.dmfmm.extrafood.blocks.Plants.*;
import com.dmfmm.extrafood.blocks.Whiteout;
import com.dmfmm.extrafood.fluids.GeneralFluid;
import com.dmfmm.extrafood.library.BlockLib;
import com.dmfmm.extrafood.utilities.EFLog;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.IForgeRegistry;

import java.lang.reflect.Field;

@Mod.EventBusSubscriber
public class BlockLoader {


    public static final Block BANANA_BUNCH = new BananaBlock(Material.CACTUS, BlockLib.BANANA_BUNCH);
    public static final Block BANANA_SAPLING = new BananaTreeSapling(BlockLib.BANANA_SAPLING);
    public static final Block CHEESE_PRESS = new CheesePress(BlockLib.CHEESE_PRESS).setHardness(1.5F);
    public static final Block AUTO_CUTTER = new AutoCutter(BlockLib.AUTO_CUTTER).setHardness(2.0F);
    public static final Block JUICE_BLENDER = new BlockJuiceBlender(BlockLib.JUICE_BLENDER).setHardness(1.5F);
    public static final Block OVEN = new Oven(BlockLib.OVEN).setHardness(1.2F);
    public static final Block JUICE_MIXER = new BlockJuiceMixer(BlockLib.JUICE_MIXER).setHardness(1.2F);
    public static final Block WHITEOUT = new Whiteout(BlockLib.WHITE_BLOCK).setHardness(1.5F);
    public static final Block BANANA_LEAF = new BananaLeaf(BlockLib.BANANA_LEAF);
    public static final Block PEANUT_BUSH = new PeanutBush(BlockLib.PEANUT_BUSH);
    public static final Block TOMATO_CROP = new CropBlock("tomato", BlockLib.TOMATO_CROP);
    public static final Block LETTUCE_CROP = new CropBlock("lettuce", BlockLib.LETTUCE_CROP);
    public static final Block PINEAPPLE_CROP = new CropBlock("pineapple", BlockLib.PINEAPPLE_CROP);
    public static final Block STRAWBERRY_BUSH = new StrawberryBush(BlockLib.STRAWBERRY_BUSH);
    public static final Block OLIVE_BUSH = new OliveTreeSapling(BlockLib.OLIVE_TREE_SAPLING);
    public static final Block OLIVE_LEAF = new OliveLeaf(BlockLib.OLIVE_TREE_LEAF);
    public static final Block ORANGE_CROP = new OrangeBlock(BlockLib.ORANGE_CROP);
    public static final Block ORANGE_SAPLING = new OrangeTreeSapling(BlockLib.ORANGE_SAPLING);
    public static final Block GRAPE_VINE = new GrapeVines(BlockLib.GRAPE_VINE);
    public static final Block CHOCOLATE_CAKE_BLOCK = new ChocolateCake(BlockLib.CAKE);



    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        IForgeRegistry registry = event.getRegistry();
        Field[] fields = null;

        try {
            fields = BlockLoader.class.getDeclaredFields();
        }catch (SecurityException e) {}

        for(Field field : fields){
            try {
                if (field.get(null) instanceof Block) {
                    registry.register(((Block) field.get(null)));
                }
            } catch (IllegalAccessException e){
                EFLog.fatal("unable to register " + field.toString());
            }
        }
    }

    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
        IForgeRegistry registry = event.getRegistry();
        try{
            for(Field field : BlockLoader.class.getDeclaredFields()){
                if(field.get(null) instanceof Block){
                    Block block = ((Block) field.get(null));
                    if(block instanceof ICustomItemBlock){
                        registry.register(((ICustomItemBlock) block).getCustomItemBlock());
                    } else {
                        registry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
                    }
                }
            }
        }catch (Exception e){}
    }

}