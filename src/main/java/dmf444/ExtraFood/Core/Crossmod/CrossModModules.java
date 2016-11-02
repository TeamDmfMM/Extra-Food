package dmf444.ExtraFood.Core.Crossmod;

import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Core.Crossmod.Forestry.ForestryFarming;
import dmf444.ExtraFood.Core.Crossmod.Waila.WailaConfig;
import dmf444.ExtraFood.Core.lib.ModInfo;
import dmf444.ExtraFood.Core.util.EFLog;
import dmfmm.StarvationAhoy.api.StarvationAhoyRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInterModComms;

public class CrossModModules{
	
	private static boolean thaumcraft = false;
	private static boolean versionCheck = false;
	private static boolean forestry = false;
	private static boolean SA = false;
	private static boolean Waila = false;
	
	
	public static void load(){
	if (Loader.isModLoaded("Thaumcraft")){
		thaumcraft = true;
		//ThaumcraftAspects.registerThaumAspect();
		FMLInterModComms.sendMessage("Thaumcraft", "harvestStandardCrop", new ItemStack(BlockLoader.tomatoCrop,1,7));
		FMLInterModComms.sendMessage("Thaumcraft", "harvestStandardCrop", new ItemStack(BlockLoader.lettuceCrop,1,7));
		FMLInterModComms.sendMessage("Thaumcraft", "harvestClickableCrop", new ItemStack(BlockLoader.strawberryBush,1,7));
		FMLInterModComms.sendMessage("Thaumcraft", "harvestClickableCrop", new ItemStack(BlockLoader.peanutbush,1,7));
	}
	if(Loader.isModLoaded("VersionChecker")){
		versionCheck = true;
		NBTTagCompound info = new NBTTagCompound();
		info.setString("curseProjectName", "222348-extra-food");
		info.setString("curseFilenameParser", "ExtraFood-[].jar");
		info.setString("modDisplayName", "Extra Food");
		FMLInterModComms.sendRuntimeMessage(ModInfo.MId, "VersionChecker", "addCurseCheck", info);
	}
	if(Loader.isModLoaded("forestry")){
		forestry = true;
		ForestryFarming.addFarms();
		ForestryFarming.registerCircut();
	}
	if(Loader.isModLoaded("Waila")){
		Waila = true;
		FMLInterModComms.sendMessage("Waila", "register", WailaConfig.class.getName() + ".callbackRegister");
	}

	EFLog.info("Mods Loaded:");
	EFLog.info("Waila=" + Waila);
	EFLog.info("Thaumcraft=" + thaumcraft);
	EFLog.info("VersionChecker=" + versionCheck);
	EFLog.info("Forestry=" + forestry);
	
	
	}
	
	public static void preInit(){
		if(Loader.isModLoaded("StarvationAhoy")){
			SA = true;
			StarvationAhoyRegistry.getInstance().registerModule(StarvationAhoy.class);
		}
		EFLog.info("Starvation Ahoy= " + SA);
	}

}
