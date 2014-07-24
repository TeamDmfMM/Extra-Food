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
	
	public static boolean Register=false;
	public static void initiateBlocks() {
		bananaBunch = new BananaBlock(Material.cactus).setBlockName(BlockLib.bBB).setBlockTextureName("extrafood:BananaBunch");
		saplingBanana = new BananaTreeSapling().setBlockName(BlockLib.bBS);
		cheesePress = new CheesePress().setBlockName(BlockLib.bCP);
		autoCutter = new AutoCutter().setBlockName(BlockLib.bAC);
		juiceBlender = new BlockJuiceBlender(Material.anvil).setBlockName(BlockLib.bJB);
		oven = new Oven().setBlockName(BlockLib.bO);
		whiteout = new Whiteout().setBlockName("TheWhiteBlock").setBlockTextureName("extrafood:The whiteout");
		Bbananajuice = new BananaJuice(FluidLoader.Fbananajuice, Material.water).setBlockName("Fbananajuice");
		Bstrawberryjuice = new StrawberryJuice(FluidLoader.Fstrawberryjuice, Material.water).setBlockName("StrawberryJuice");
		strawberryBush = new StrawberryBush(Material.plants).setBlockName(BlockLib.bSB);
		Bcarrotjuice = new CarrotJuice(FluidLoader.Fcarrotjuice, Material.water).setBlockName("Fcarrotjuice");
		bananaLeaf = new BananaLeaf().setBlockName("BananaLeaf");
		
		
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

