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
	public static Item FluidContainer;
    private static final String pre = "extrafood:blocks/fluid/";
    private static final String still = "Fluid_%s_Still";
    private static final String flow = "Fluid_%s_Flow";

	
	public static boolean Registate=false;
	
	public static void initiateFluids() {
		Fbananajuice = new EdibleFluid("bananajuice", new ResourceLocation(pre + localize(still, "BananaJuice")), new ResourceLocation(pre + localize(flow, "BananaJuice")), 6, 0.6F).setViscosity(3000);
		Fstrawberryjuice = new EdibleFluid("strawberryjuice", new ResourceLocation(pre + localize(still, "StrawberryJuice")), new ResourceLocation(pre + localize(flow, "StrawberryJuice")), 6, 0.8F);
		Fcarrotjuice = new EdibleFluid("carrotjuice", new ResourceLocation(pre + localize(still, "CarrotJuice")), new ResourceLocation(pre + localize(flow, "CarrotJuice")), 6, 0.9F);
		FEggnog = new EdibleFluid("Eggnog", new ResourceLocation(pre + localize(still, "Eggnog")), new ResourceLocation(pre + localize(flow, "Eggnog")), 9, 5.0F).setViscosity(2000);
		FHorribleLiquid = new EdibleFluid("disgustingMix", new ResourceLocation(pre + localize(still, "disgustingMix")), new ResourceLocation(pre + localize(flow, "disgustingMix")), -5, 0.6F).setViscosity(3500);

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
			GameRegistry.registerItem(FluidContainer, ItemLib.glassContainer);
			GlassFluidContainer.createGlassBottles();

		}
		Registate = true;
	}

    private static String localize(String type, String fluid){
        return String.format(type, fluid);
    }
}
