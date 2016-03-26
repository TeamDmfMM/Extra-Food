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
		Fgrapejuice = new EdibleFluid(GRAPE_JUICE.toLowerCase(), rl(still, GRAPE_JUICE), rl(flow, GRAPE_JUICE), 5, 1.6f);
		Fapplegrapejuice = new EdibleFluid(APPLE_GRAPE.toLowerCase(), rl(still, APPLE_GRAPE), rl(flow, APPLE_GRAPE), 7, 3.6f);
		Fcitusjuice = new EdibleFluid(CITRUS_JUICE.toLowerCase(), rl(still, CITRUS_JUICE), rl(flow, CITRUS_JUICE), 6, 4f);
		FpinappleJuice = new EdibleFluid(PINEAPPLE_JUICE.toLowerCase(), rl(still, PINEAPPLE_JUICE), rl(flow, PINEAPPLE_JUICE), 3, 2f);


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
