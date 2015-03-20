package dmf444.ExtraFood.Common.fluids;

import cpw.mods.fml.common.registry.GameRegistry;
import dmf444.ExtraFood.Core.lib.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

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

	
	public static boolean Registate=false;
	
	public static void initiateFluids() {
		Fbananajuice = new Fluid("bananajuice").setViscosity(3000);
		Fstrawberryjuice = new Fluid("strawberryjuice");
		Fcarrotjuice = new Fluid("carrotjuice");
		FEggnog = new Fluid("Eggnog").setViscosity(2000);
		
		
		
		registerFluid();
	}
	private static void registerFluid(){
		if(!Registate){
		FluidRegistry.registerFluid(Fbananajuice);
		FluidRegistry.registerFluid(Fstrawberryjuice);
		FluidRegistry.registerFluid(Fcarrotjuice);
		FluidRegistry.registerFluid(FEggnog);

		}
		Registate = true;
	}
	
}
