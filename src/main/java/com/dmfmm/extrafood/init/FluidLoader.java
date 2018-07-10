package com.dmfmm.extrafood.init;


import com.dmfmm.extrafood.fluids.EdibleFluid;
import com.dmfmm.extrafood.fluids.GeneralFluid;
import com.dmfmm.extrafood.fluids.GlassFluidContainer;
import com.dmfmm.extrafood.library.BlockLib;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.IForgeRegistry;

import java.lang.reflect.Field;

@Mod.EventBusSubscriber
public class FluidLoader {
    //RECIPIES (n=just blender)
    //Apple=n
    //Orange = n
    //Grape = n
    //Apple-Grape= 1000ml Apple, 1000ml Grape
    //Citrus = 500ml Apple, 1000ml Grape, 500ml orange
    //Pinapple = n
    //Fruit = 1000mL Apple, 1000ml Watermelon, 500ml Strawberry, 500ml Grape
    //Mixed berry = 500ml Strawberry, 500ml Grape
    //Watermelon = n
    //Strawberry banana = 500ml Strawberry, 500ml Banana
    //F tropical = (if possible) 500ml Pinapple, 500ml Citrus

    public static Item FLUID_CONTAINER;

    private static final String ORANGE_JUICE = "orangejuice";
    private static final String APPLE_JUICE = "applejuice";
    private static final String WATERMELON_JUICE = "watermelonjuice";
    private static final String DISGUSTING_JUICE = "disgustingmix";
    private static final String EGGNOG = "eggnog";
    private static final String CARROT_JUICE = "carrotjuice";
    private static final String STRAWBERRY_JUICE = "strawberryjuice";
    private static final String BANANA_JUICE = "bananajuice";
    private static final String GRAPE_JUICE = "GrapeJuice";
    private static final String APPLE_GRAPE = "AppleGrapeJuice";
    private static final String CITRUS_JUICE = "CitrusJuice";
    private static final String PINEAPPLE_JUICE = "PineappleJuice";
    private static final String FRUIT_JUICE = "FruitJuice";
    private static final String MIXED_BERRY_JUICE = "MixedBerryJuice";
    private static final String STRAWBERRY_BANANA_JUICE = "StrawberryBananaJuice";
    private static final String TROPICAL_JUICE = "TropicalJuice";

    //Fluids
    public static Fluid FLUID_BANANA_JUICE, FLUID_STRAWBERRY_JUICE, FLUID_CARROT_JUICE, FLUID_APPLE_JUICE, FLUID_ORANGE_JUICE;
    public static Fluid FLUID_EGGNOG, FLUID_DISGUSTING_MIX, FLUID_GRAPE_JUICE, FLUID_APPLE_GRAPE_JUICE, FLUID_CITRUS_JUICE;
    public static Fluid FLUID_PINAPPLE_JUICE, FLUID_FRUIT_JUICE, FLUID_MIXED_BERRY_JUICE, FLUID_WATERMELON_JUICE, FLUID_STRAWBERRY_BANANA_JUICE, FLUID_TROPICAL_JUICE;


    //JUICE BLOCKS
    public static Block BANANA_JUICE_BLOCK;
    public static Block EGGNOG_FLUID_BLOCK;
    public static Block STRAWBERRY_JUICE_BLOCK;
    public static Block CARROT_JUICE_BLOCK;
    public static Block DISCUSTING_MIX_FLUID_BLOCK;
    public static Block APPLE_JUICE_BLOCK;
    public static Block ORANGE_JUICE_BLOCK;
    public static Block WATERMELON_JUICE_BLOCK;
    public static Block GRAPE_JUICE_BLOCK;
    public static Block APPLE_GRAPE_JUICE_BLOCK;
    public static Block CITRUS_JUICE_BLOCK;
    public static Block PINEAPPLE_JUICE_BLOCK;
    public static Block FRUIT_JUICE_BLOCK;
    public static Block STRAWBERRY_BANANA_JUICE_BLOCK;
    public static Block MIXED_BERRY_JUICE_BLOCK;
    public static Block TROPICAL_JUICE_BLOCK;


    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        IForgeRegistry registry = event.getRegistry();
        initiateFluids();
        initiateFluidBlocks();
        try{
            for(Field field : FluidLoader.class.getDeclaredFields()){
                if(field.get(null) instanceof Block){
                    registry.register((Block)field.get(null));
                }
            }

        }catch (Exception e){ }
        FLUID_BANANA_JUICE.setBlock(BANANA_JUICE_BLOCK);
    }

    private static void initiateFluidBlocks() {
        BANANA_JUICE_BLOCK = new GeneralFluid(FluidLoader.FLUID_BANANA_JUICE, Material.WATER, BlockLib.FLUID_BLOCK_BANANA);
        EGGNOG_FLUID_BLOCK = new GeneralFluid(FluidLoader.FLUID_EGGNOG, Material.WATER, BlockLib.FLUID_BLOCK_EGGNOG);
        STRAWBERRY_JUICE_BLOCK = new GeneralFluid(FluidLoader.FLUID_STRAWBERRY_JUICE, Material.WATER, BlockLib.FLUID_BLOCK_STRAWBERRY);
        CARROT_JUICE_BLOCK = new GeneralFluid(FluidLoader.FLUID_CARROT_JUICE, Material.WATER, BlockLib.FLUID_BLOCK_CARROT);
        DISCUSTING_MIX_FLUID_BLOCK = new GeneralFluid(FluidLoader.FLUID_DISGUSTING_MIX, Material.WATER, BlockLib.FLUID_BLOCK_DISCUSTING_MIX);
        APPLE_JUICE_BLOCK = new GeneralFluid(FluidLoader.FLUID_APPLE_JUICE, Material.WATER, BlockLib.APPLE_JUICE_BLOCK);
        ORANGE_JUICE_BLOCK = new GeneralFluid(FluidLoader.FLUID_ORANGE_JUICE, Material.WATER, BlockLib.ORANGE_JUICE_BLOCK);
        WATERMELON_JUICE_BLOCK = new GeneralFluid(FluidLoader.FLUID_WATERMELON_JUICE, Material.WATER, BlockLib.MELON_JUICE_BLOCK);
        GRAPE_JUICE_BLOCK = new GeneralFluid(FluidLoader.FLUID_GRAPE_JUICE, Material.WATER, BlockLib.GRAPE_JUICE_BLOCK);
        APPLE_GRAPE_JUICE_BLOCK = new GeneralFluid(FluidLoader.FLUID_APPLE_GRAPE_JUICE, Material.WATER, BlockLib.APPLE_GRAPE_JUICE_BLOCK);
        CITRUS_JUICE_BLOCK = new GeneralFluid(FluidLoader.FLUID_CITRUS_JUICE, Material.WATER, BlockLib.CITRUS_JUICE_BLOCK);
        PINEAPPLE_JUICE_BLOCK = new GeneralFluid(FluidLoader.FLUID_PINAPPLE_JUICE, Material.WATER, BlockLib.PINEAPPLE_JUICE_BLOCK);
        FRUIT_JUICE_BLOCK = new GeneralFluid(FluidLoader.FLUID_FRUIT_JUICE, Material.WATER, BlockLib.FRUIT_JUICE_BLOCK);
        STRAWBERRY_BANANA_JUICE_BLOCK = new GeneralFluid(FluidLoader.FLUID_STRAWBERRY_BANANA_JUICE, Material.WATER, BlockLib.STRAWBERRY_BANANA_JUICE);
        MIXED_BERRY_JUICE_BLOCK = new GeneralFluid(FluidLoader.FLUID_MIXED_BERRY_JUICE, Material.WATER, BlockLib.MIXED_BERRY_JUICE);
        TROPICAL_JUICE_BLOCK = new GeneralFluid(FluidLoader.FLUID_TROPICAL_JUICE, Material.WATER, BlockLib.TROPICAL_JUICE);
    }



    public static void initiateFluids() {
        FLUID_BANANA_JUICE = new EdibleFluid(BANANA_JUICE, 4, 0.6F).setViscosity(3000);
        FLUID_STRAWBERRY_JUICE = new EdibleFluid(STRAWBERRY_JUICE, 4, 0.8F);
        FLUID_CARROT_JUICE = new EdibleFluid(CARROT_JUICE, 5, 0.9F);
        FLUID_EGGNOG = new EdibleFluid(EGGNOG, 9, 5.0F).setViscosity(2000);
        FLUID_DISGUSTING_MIX = new EdibleFluid(DISGUSTING_JUICE, -5, 0.6F).setViscosity(3500);
        FLUID_WATERMELON_JUICE = new EdibleFluid(WATERMELON_JUICE, 4, 2.0f).setViscosity(1200);
        FLUID_APPLE_JUICE = new EdibleFluid(APPLE_JUICE, 4, 1.0f);
        FLUID_ORANGE_JUICE = new EdibleFluid(ORANGE_JUICE, 4, 1.5f);
        FLUID_GRAPE_JUICE = new EdibleFluid(GRAPE_JUICE, 5, 1.6f);
        FLUID_APPLE_GRAPE_JUICE = new EdibleFluid( APPLE_GRAPE, 7, 3.6f);
        FLUID_CITRUS_JUICE = new EdibleFluid(CITRUS_JUICE, 6, 4f);
        FLUID_PINAPPLE_JUICE = new EdibleFluid(PINEAPPLE_JUICE, 3, 2f);
        FLUID_FRUIT_JUICE = new EdibleFluid(FRUIT_JUICE, 6, 2.0f);
        FLUID_MIXED_BERRY_JUICE = new EdibleFluid(MIXED_BERRY_JUICE, 6, 7.0f);
        FLUID_STRAWBERRY_BANANA_JUICE = new EdibleFluid(STRAWBERRY_BANANA_JUICE, 3, 4.0f);
        FLUID_TROPICAL_JUICE = new EdibleFluid(TROPICAL_JUICE, 7, 2.0f);

        FLUID_CONTAINER = new GlassFluidContainer();

        registerFluid();
    }
    private static void registerFluid(){
            FluidRegistry.addBucketForFluid(FLUID_BANANA_JUICE);
            FluidRegistry.addBucketForFluid(FLUID_STRAWBERRY_JUICE);
            FluidRegistry.addBucketForFluid(FLUID_CARROT_JUICE);
            FluidRegistry.addBucketForFluid(FLUID_EGGNOG);
            FluidRegistry.registerFluid(FLUID_DISGUSTING_MIX);
            FluidRegistry.addBucketForFluid(FLUID_WATERMELON_JUICE);
            FluidRegistry.addBucketForFluid(FLUID_APPLE_JUICE);
            FluidRegistry.addBucketForFluid(FLUID_ORANGE_JUICE);
            FluidRegistry.addBucketForFluid(FLUID_GRAPE_JUICE);
            FluidRegistry.addBucketForFluid(FLUID_APPLE_GRAPE_JUICE);
            FluidRegistry.addBucketForFluid(FLUID_CITRUS_JUICE);
            FluidRegistry.addBucketForFluid(FLUID_PINAPPLE_JUICE);
            FluidRegistry.addBucketForFluid(FLUID_FRUIT_JUICE);
            FluidRegistry.addBucketForFluid(FLUID_MIXED_BERRY_JUICE);
            FluidRegistry.addBucketForFluid(FLUID_STRAWBERRY_BANANA_JUICE);
            FluidRegistry.addBucketForFluid(FLUID_TROPICAL_JUICE);
     
            GameRegistry.register(FLUID_CONTAINER);
    }

}
