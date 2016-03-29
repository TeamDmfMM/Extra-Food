package dmf444.ExtraFood.Common.fluids;

import dmf444.ExtraFood.Core.lib.ItemLib;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class FluidLoader {
	/*
	 * This class only loads the fluids
	 * The block & tile are registered in the Block loader
	 * 
	 * This will act quite like the "BlockLoader" though
	 */
	
	public static Fluid Fbananajuice;
	public static Fluid Fstrawberryjuice;
	public static Fluid Fcarrotjuice;
	public static Fluid FEggnog;
	public static Fluid FHorribleLiquid;
	public static Fluid Fapplejuice, Forangejuice, Fgrapejuice, Fapplegrapejuice, Fcitusjuice, FpinappleJuice, Ffruitjuice, Fmixedberryjuice, Fwatermelonjuice, Fstrawberrybanana, Ftropicaljuice;

	public static Item FluidContainer;
    private static final String pre = "extrafood:blocks/fluid/";
    private static final String still = "Fluid_%s_Still";
    private static final String flow = "Fluid_%s_Flow";

	//Fluid Names for Convinience
	private static final String GRAPE_JUICE = "GrapeJuice";
	private static final String APPLE_GRAPE = "AppleGrapeJuice";
	private static final String CITRUS_JUICE = "CitrusJuice";
	private static final String PINEAPPLE_JUICE = "PineappleJuice";
	private static final String FRUIT_JUICE = "FruitJuice";
	private static final String MIXED_BERRY_JUICE = "MixedBerryJuice";
	private static final String STRAWBERRY_BANANA_JUICE = "StrawberryBananaJuice";
	private static final String TROPICAL_JUICE = "TropicalJuice";


	
	public static boolean Registate=false;
	
	public static void initiateFluids() {
		Fbananajuice = new EdibleFluid("bananajuice", new ResourceLocation(pre + localize(still, "BananaJuice")), new ResourceLocation(pre + localize(flow, "BananaJuice")), 4, 0.6F).setViscosity(3000);
		Fstrawberryjuice = new EdibleFluid("strawberryjuice", new ResourceLocation(pre + localize(still, "StrawberryJuice")), new ResourceLocation(pre + localize(flow, "StrawberryJuice")), 4, 0.8F);
		Fcarrotjuice = new EdibleFluid("carrotjuice", new ResourceLocation(pre + localize(still, "CarrotJuice")), new ResourceLocation(pre + localize(flow, "CarrotJuice")), 5, 0.9F);
		FEggnog = new EdibleFluid("Eggnog", new ResourceLocation(pre + localize(still, "Eggnog")), new ResourceLocation(pre + localize(flow, "Eggnog")), 9, 5.0F).setViscosity(2000);
		FHorribleLiquid = new EdibleFluid("disgustingmix", new ResourceLocation(pre + localize(still, "disgustingMix")), new ResourceLocation(pre + localize(still, "disgustingMix")), -5, 0.6F).setViscosity(3500);
		Fwatermelonjuice = new EdibleFluid("watermelonjuice", new ResourceLocation(pre+"Fluid_WatermelonJuice"), new ResourceLocation(pre+"Fluid_WatermelonJuice"), 4, 2.0f).setViscosity(1200);
		Fapplejuice = new EdibleFluid("applejuice", new ResourceLocation(pre+localize(still, "AppleJuice")), new ResourceLocation(pre+localize(flow, "AppleJuice")), 4, 1.0f);
		Forangejuice = new EdibleFluid("orangejuice", new ResourceLocation(pre+localize(still, "OrangeJuice")), new ResourceLocation(pre+localize(flow, "OrangeJuice")), 4, 1.5f);
		Fgrapejuice = new EdibleFluid(GRAPE_JUICE, rl(still, GRAPE_JUICE), rl(flow, GRAPE_JUICE), 5, 1.6f);
		Fapplegrapejuice = new EdibleFluid(APPLE_GRAPE, rl(still, APPLE_GRAPE), rl(flow, APPLE_GRAPE), 7, 3.6f);
		Fcitusjuice = new EdibleFluid(CITRUS_JUICE, rl(still, CITRUS_JUICE), rl(flow, CITRUS_JUICE), 6, 4f);
		FpinappleJuice = new EdibleFluid(PINEAPPLE_JUICE, rl(still, PINEAPPLE_JUICE), rl(flow, PINEAPPLE_JUICE), 3, 2f);
		Ffruitjuice = new EdibleFluid(FRUIT_JUICE, rl(still, FRUIT_JUICE), rl(flow, FRUIT_JUICE), 6, 2.0f);
		Fmixedberryjuice = new EdibleFluid(MIXED_BERRY_JUICE, rl(still, MIXED_BERRY_JUICE), rl(flow, MIXED_BERRY_JUICE), 6, 7.0f);
		Fstrawberrybanana = new EdibleFluid(STRAWBERRY_BANANA_JUICE, rl(still, STRAWBERRY_BANANA_JUICE), rl(flow, STRAWBERRY_BANANA_JUICE), 3, 4.0f);
		Ftropicaljuice = new EdibleFluid(TROPICAL_JUICE, rl(still, TROPICAL_JUICE), rl(flow, TROPICAL_JUICE), 7, 2.0f);


		FluidContainer = new GlassFluidContainer().setUnlocalizedName(ItemLib.glassContainer);
		
		registerFluid();
	}
	private static void registerFluid(){
		if(!Registate){
			FluidRegistry.registerFluid(Fbananajuice);
			FluidRegistry.registerFluid(Fstrawberryjuice);
			FluidRegistry.registerFluid(Fcarrotjuice);
			FluidRegistry.registerFluid(FEggnog);
			FluidRegistry.registerFluid(FHorribleLiquid);
			FluidRegistry.registerFluid(Fwatermelonjuice);
			FluidRegistry.registerFluid(Fapplejuice);
			FluidRegistry.registerFluid(Forangejuice);
			FluidRegistry.registerFluid(Fgrapejuice);
			FluidRegistry.registerFluid(Fapplegrapejuice);
			FluidRegistry.registerFluid(Fcitusjuice);
			FluidRegistry.registerFluid(FpinappleJuice);
			FluidRegistry.registerFluid(Ffruitjuice);
			FluidRegistry.registerFluid(Fmixedberryjuice);
			FluidRegistry.registerFluid(Fstrawberrybanana);
			FluidRegistry.registerFluid(Ftropicaljuice);


			GameRegistry.registerItem(FluidContainer, ItemLib.glassContainer);
			GlassFluidContainer.createGlassBottles();

		}
		Registate = true;
	}
    private static String localize(String type, String fluid){
        return String.format(type, fluid);
    }

	private static ResourceLocation rl(String type, String name){
		return new ResourceLocation(pre + localize(type, name));
	}
}
