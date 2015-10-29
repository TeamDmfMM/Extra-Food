package dmf444.ExtraFood.Common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.registry.GameRegistry;
import dmf444.ExtraFood.Common.blocks.tileentity.AutoCutterTileEntity;
import dmf444.ExtraFood.Common.blocks.tileentity.CheesePressTileEntity;
import dmf444.ExtraFood.Common.blocks.tileentity.JuiceMixerTileEntity;
import dmf444.ExtraFood.Common.blocks.tileentity.TileEntityJuiceBlender;
import dmf444.ExtraFood.Common.blocks.tileentity.TileEntityOven;
import dmf444.ExtraFood.Common.fluids.FluidLoader;
import dmf444.ExtraFood.Common.fluids.GeneralFluid;
import dmf444.ExtraFood.Core.lib.BlockLib;
import dmf444.ExtraFood.Core.lib.ModInfo;

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
	public static Block Beggnog;
	public static Block strawberryBush;
	public static Block Bcarrotjuice;
	public static Block bananaLeaf, oliveLeaf;
	public static Block peanutbush;
	public static Block tomatoCrop;
	public static Block lettuceCrop;
	public static Block juiceMixer;
	public static Block Chocake;
	public static Block oliveBush;
	
	public static boolean Register=false;
	
	public static void initiateBlocks() {
		bananaBunch = new BananaBlock(Material.cactus).setBlockName(BlockLib.bBB).setBlockTextureName("extrafood:BananaBunch");
		saplingBanana = new BananaTreeSapling().setBlockName(BlockLib.bBS);
		cheesePress = new CheesePress().setBlockName(BlockLib.bCP).setHardness(1.5F);
		autoCutter = new AutoCutter().setBlockName(BlockLib.bAC).setHardness(2.0F);
		juiceBlender = new BlockJuiceBlender().setBlockName(BlockLib.bJB).setHardness(1.5F);
		oven = new Oven().setBlockName(BlockLib.bO);
		whiteout = new Whiteout().setBlockName("TheWhiteBlock").setBlockTextureName("extrafood:The whiteout").setHardness(1.5F);
		Bbananajuice = new GeneralFluid("BananaJuice", FluidLoader.Fbananajuice, Material.water).setBlockName("Fbananajuice");
		Beggnog = new GeneralFluid("Eggnog",FluidLoader.FEggnog, Material.water).setBlockName("FEggnog");
		Bstrawberryjuice = new GeneralFluid("StrawberryJuice", FluidLoader.Fstrawberryjuice, Material.water).setBlockName("StrawberryJuice");
		strawberryBush = new StrawberryBush(Material.plants).setBlockName(BlockLib.bSB);
		Bcarrotjuice = new GeneralFluid("CarrotJuice", FluidLoader.Fcarrotjuice, Material.water).setBlockName("Fcarrotjuice");
		bananaLeaf = new BananaLeaf().setBlockName("BananaLeaf");
		peanutbush = new PeanutBush(Material.plants).setBlockName(BlockLib.bPB);
		tomatoCrop = new CropBlock("tomato").setBlockName(BlockLib.bCT);
		lettuceCrop = new CropBlock("lettuce").setBlockName(BlockLib.bCL);
		juiceMixer = new BlockJuiceMixer().setBlockName(BlockLib.bJM);
		Chocake = new ChocolateCake().setBlockName("Cake");
		oliveBush = new OliveTreeSapling().setBlockName(BlockLib.bOliveBush);
		oliveLeaf = new OliveLeaf().setBlockName(BlockLib.bOliveLeaf);
		
		
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
			GameRegistry.registerBlock(Beggnog, ModInfo.MId + "_" + Beggnog.getUnlocalizedName().substring(5));
			GameRegistry.registerBlock(strawberryBush, BlockLib.bSB);
			GameRegistry.registerBlock(Bcarrotjuice, ModInfo.MId + "_" + Bcarrotjuice.getUnlocalizedName().substring(5));
			GameRegistry.registerBlock(bananaLeaf, "BananaLeaf");
			GameRegistry.registerBlock(peanutbush, BlockLib.bPB);
			GameRegistry.registerBlock(tomatoCrop, BlockLib.bCT);
			GameRegistry.registerBlock(lettuceCrop, BlockLib.bCL);
			GameRegistry.registerBlock(juiceMixer, BlockLib.bJM);
			GameRegistry.registerBlock(Chocake, "Cake");
			GameRegistry.registerBlock(oliveBush, BlockLib.bOliveBush);
			GameRegistry.registerBlock(oliveLeaf, BlockLib.bOliveLeaf);
			
		}
		Register=true;
	}
	
	public static void initTileEntity() {
		GameRegistry.registerTileEntity(CheesePressTileEntity.class, BlockLib.bCP);
		GameRegistry.registerTileEntity(AutoCutterTileEntity.class, BlockLib.bAC);
		GameRegistry.registerTileEntity(TileEntityJuiceBlender.class, BlockLib.bJB);
		GameRegistry.registerTileEntity(TileEntityOven.class, BlockLib.bO);
		GameRegistry.registerTileEntity(JuiceMixerTileEntity.class, BlockLib.bJM);
	}
	
}

