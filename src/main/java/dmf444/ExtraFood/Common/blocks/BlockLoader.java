package dmf444.ExtraFood.Common.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import dmf444.ExtraFood.Common.blocks.tileentity.AutoCutterTileEntity;
import dmf444.ExtraFood.Common.blocks.tileentity.CheesePressTileEntity;
import dmf444.ExtraFood.Common.blocks.tileentity.TileEntityJuiceBlender;
import dmf444.ExtraFood.Common.blocks.tileentity.TileEntityOven;
import dmf444.ExtraFood.Common.fluids.BananaJuice;
import dmf444.ExtraFood.Common.fluids.CarrotJuice;
import dmf444.ExtraFood.Common.fluids.FluidLoader;
import dmf444.ExtraFood.Common.fluids.StrawberryJuice;
import dmf444.ExtraFood.Common.items.ItemLoader;
import dmf444.ExtraFood.Core.lib.BlockLib;
import dmf444.ExtraFood.Core.lib.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockLoader {

	public static Block bananaBunch;
	public static Block saplingBanana;
	public static Block cheesePress;
	public static Block autoCutter;
	public static Block juiceBlender;
	public static Block oven;
	public static Block whiteout;
	public static Block Bbananajuice;
	public static Block Bstrawberryjuice;
	public static Block strawberryBush;
	public static Block Bcarrotjuice;
	public static Block bananaLeaf;
	public static Block peanutbush;
	public static Block tomatoCrop;
	public static Block lettuceCrop;
	
	public static boolean Register=false;
	
	public static void initiateBlocks() {
		bananaBunch = new BananaBlock(Material.cactus).setBlockName(BlockLib.bBB).setBlockTextureName("extrafood:BananaBunch");
		saplingBanana = new BananaTreeSapling().setBlockName(BlockLib.bBS);
		cheesePress = new CheesePress().setBlockName(BlockLib.bCP).setHardness(1.5F);
		autoCutter = new AutoCutter().setBlockName(BlockLib.bAC).setHardness(2.0F);
		juiceBlender = new BlockJuiceBlender().setBlockName(BlockLib.bJB).setHardness(1.5F);
		oven = new Oven().setBlockName(BlockLib.bO);
		whiteout = new Whiteout().setBlockName("TheWhiteBlock").setBlockTextureName("extrafood:The whiteout").setHardness(1.5F);
		Bbananajuice = new BananaJuice(FluidLoader.Fbananajuice, Material.water).setBlockName("Fbananajuice");
		Bstrawberryjuice = new StrawberryJuice(FluidLoader.Fstrawberryjuice, Material.water).setBlockName("StrawberryJuice");
		strawberryBush = new StrawberryBush(Material.plants).setBlockName(BlockLib.bSB);
		Bcarrotjuice = new CarrotJuice(FluidLoader.Fcarrotjuice, Material.water).setBlockName("Fcarrotjuice");
		bananaLeaf = new BananaLeaf().setBlockName("BananaLeaf");
		peanutbush = new PeanutBush(Material.plants).setBlockName(BlockLib.bPB);
		tomatoCrop = new CropBlock("tomato").setBlockName(BlockLib.bCT);
		lettuceCrop = new CropBlock("lettuce").setBlockName(BlockLib.bCL);
		
		
		registerBlocks();
	}
	private static void registerBlocks() {
		if(!Register){
			GameRegistry.registerBlock(bananaBunch, BlockLib.bBB);
			GameRegistry.registerBlock(saplingBanana, BlockLib.bBS);
			GameRegistry.registerBlock(cheesePress, BlockLib.bCP);
			GameRegistry.registerBlock(autoCutter, BlockLib.bAC);
			GameRegistry.registerBlock(juiceBlender, BlockLib.bJB);
			GameRegistry.registerBlock(oven, BlockLib.bO);
			GameRegistry.registerBlock(whiteout, "TheWhiteBlock");
			GameRegistry.registerBlock(Bbananajuice, ModInfo.MId + "_" + Bbananajuice.getUnlocalizedName().substring(5));
			GameRegistry.registerBlock(Bstrawberryjuice, ModInfo.MId + "_" + Bstrawberryjuice.getUnlocalizedName().substring(5));
			GameRegistry.registerBlock(strawberryBush, BlockLib.bSB);
			GameRegistry.registerBlock(Bcarrotjuice, ModInfo.MId + "_" + Bcarrotjuice.getUnlocalizedName().substring(5));
			GameRegistry.registerBlock(bananaLeaf, "BananaLeaf");
			GameRegistry.registerBlock(peanutbush, BlockLib.bPB);
			GameRegistry.registerBlock(tomatoCrop, BlockLib.bCT);
			GameRegistry.registerBlock(lettuceCrop, BlockLib.bCL);
			
		}
		Register=true;
	}
	
	public static void initTileEntity() {
		GameRegistry.registerTileEntity(CheesePressTileEntity.class, BlockLib.bCP);
		GameRegistry.registerTileEntity(AutoCutterTileEntity.class, BlockLib.bAC);
		GameRegistry.registerTileEntity(TileEntityJuiceBlender.class, BlockLib.bJB);
		GameRegistry.registerTileEntity(TileEntityOven.class, BlockLib.bO);
	}
	
}

