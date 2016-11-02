package com.dmfmm.extrafood.init;


import com.dmfmm.extrafood.blocks.ChocolateCake;
import com.dmfmm.extrafood.blocks.Machines.*;
import com.dmfmm.extrafood.blocks.Plants.*;
import com.dmfmm.extrafood.blocks.Whiteout;
import com.dmfmm.extrafood.fluids.GeneralFluid;
import com.dmfmm.extrafood.library.BlockLib;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.lang.reflect.Field;

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
    public static final Block CHOCOLATE_CAKE_BLOCK = new ChocolateCake(BlockLib.CAKE);
    public static final Block STRAWBERRY_BUSH = new StrawberryBush(BlockLib.STRAWBERRY_BUSH);
    public static final Block OLIVE_BUSH = new OliveTreeSapling(BlockLib.OLIVE_TREE_SAPLING);
    public static final Block OLIVE_LEAF = new OliveLeaf(BlockLib.OLIVE_TREE_LEAF);
    public static final Block ORANGE_CROP = new OrangeBlock(BlockLib.ORANGE_CROP);
    public static final Block ORANGE_SAPLING = new OrangeTreeSapling(BlockLib.ORANGE_SAPLING);
    public static final Block GRAPE_VINE = new GrapeVines(BlockLib.GRAPE_VINE);

    //JUICE BLOCKS
    public static final Block BANANA_JUICE_BLOCK = new GeneralFluid(FluidLoader.Fbananajuice, Material.WATER, BlockLib.FLUID_BLOCK_BANANA);
    public static final Block EGGNOG_FLUID_BLOCK = new GeneralFluid(FluidLoader.FEggnog, Material.WATER, BlockLib.FLUID_BLOCK_EGGNOG);
    public static final Block STRAWBERRY_JUICE_BLOCK = new GeneralFluid(FluidLoader.Fstrawberryjuice, Material.WATER, BlockLib.FLUID_BLOCK_STRAWBERRY);
    public static final Block CARROT_JUICE_BLOCK = new GeneralFluid(FluidLoader.Fcarrotjuice, Material.WATER, BlockLib.FLUID_BLOCK_CARROT);
    public static final Block DISCUSTING_MIX_FLUID_BLOCK = new GeneralFluid(FluidLoader.FHorribleLiquid, Material.WATER, BlockLib.FLUID_BLOCK_DISCUSTING_MIX);
    public static final Block APPLE_JUICE_BLOCK = new GeneralFluid(FluidLoader.Fapplejuice, Material.WATER, BlockLib.APPLE_JUICE_BLOCK);
    public static final Block ORANGE_JUICE_BLOCK = new GeneralFluid(FluidLoader.Forangejuice, Material.WATER, BlockLib.ORANGE_JUICE_BLOCK);
    public static final Block WATERMELON_JUICE_BLOCK = new GeneralFluid(FluidLoader.Fwatermelonjuice, Material.WATER, BlockLib.MELON_JUICE_BLOCK);
    public static final Block GRAPE_JUICE_BLOCK = new GeneralFluid(FluidLoader.Fgrapejuice, Material.WATER, BlockLib.GRAPE_JUICE_BLOCK);
    public static final Block APPLE_GRAPE_JUICE_BLOCK = new GeneralFluid(FluidLoader.Fapplegrapejuice, Material.WATER, BlockLib.APPLE_GRAPE_JUICE_BLOCK);
    public static final Block CITRUS_JUICE_BLOCK = new GeneralFluid(FluidLoader.Fcitusjuice, Material.WATER, BlockLib.CITRUS_JUICE_BLOCK);
    public static final Block PINEAPPLE_JUICE_BLOCK = new GeneralFluid(FluidLoader.FpinappleJuice, Material.WATER, BlockLib.PINEAPPLE_JUICE_BLOCK);
    public static final Block FRUIT_JUICE_BLOCK = new GeneralFluid(FluidLoader.Ffruitjuice, Material.WATER, BlockLib.FRUIT_JUICE_BLOCK);
    public static final Block STRAWBERRY_BANANA_JUICE_BLOCK = new GeneralFluid(FluidLoader.Fstrawberrybanana, Material.WATER, BlockLib.STRAWBERRY_BANANA_JUICE);
    public static final Block MIXED_BERRY_JUICE_BLOCK = new GeneralFluid(FluidLoader.Fmixedberryjuice, Material.WATER, BlockLib.MIXED_BERRY_JUICE);
    public static final Block TROPICAL_JUICE_BLOCK = new GeneralFluid(FluidLoader.Ftropicaljuice, Material.WATER, BlockLib.TROPICAL_JUICE);


    private static void registerBlocks() {
        try{
            for(Field field : BlockLoader.class.getDeclaredFields()){
                if(field.get(null) instanceof Block){
                    registerBlock((Block)field.get(null));

                }
            }
        }catch (Exception e){

        }
    }


    private static void registerBlock(Block block){
        GameRegistry.register(block);
        GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
    }
}