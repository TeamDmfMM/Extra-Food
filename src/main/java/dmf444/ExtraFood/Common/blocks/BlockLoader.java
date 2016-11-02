package dmf444.ExtraFood.Common.blocks;

import dmf444.ExtraFood.Common.blocks.Machines.*;
import dmf444.ExtraFood.Common.blocks.Plants.*;
import dmf444.ExtraFood.Common.blocks.tileentity.*;
import dmf444.ExtraFood.Common.fluids.FluidLoader;
import dmf444.ExtraFood.Common.fluids.GeneralFluid;
import dmf444.ExtraFood.Core.lib.BlockLib;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockLoader {

	public static Block bananaBunch;
	public static Block saplingBanana, saplingOrange;
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
	public static Block lettuceCrop, pineappleCrop, grapeVine;
	public static Block juiceMixer;
	public static Block Chocake;
	public static Block oliveBush;
	public static Block BdiscustingMix, BappleJuice, BorangeJuice, BwatermelonJuice, Bgrapejuice, Bapplegrapejuice, Bcitusjuice, BpinappleJuice, BfruitJuice, BmixedberryJuice, tropicalJuice, strawberryBananaJuice;
	public static Block OrangeBlock;
	
	public static boolean Register=false;
	
	public static void initiateBlocks() {
		bananaBunch = new BananaBlock(Material.CACTUS).setUnlocalizedName(BlockLib.bBB);
		saplingBanana = new BananaTreeSapling().setUnlocalizedName(BlockLib.bBS);
		cheesePress = new CheesePress().setUnlocalizedName(BlockLib.bCP).setHardness(1.5F);
		autoCutter = new AutoCutter().setUnlocalizedName(BlockLib.bAC).setHardness(2.0F);
		juiceBlender = new BlockJuiceBlender().setUnlocalizedName(BlockLib.bJB).setHardness(1.5F);
		oven = new Oven().setUnlocalizedName(BlockLib.bO);
		whiteout = new Whiteout().setUnlocalizedName(BlockLib.bTWB).setHardness(1.5F);
        bananaLeaf = new BananaLeaf().setUnlocalizedName(BlockLib.bBL);
        peanutbush = new PeanutBush(Material.PLANTS).setUnlocalizedName(BlockLib.bPB);
        tomatoCrop = new CropBlock("tomato").setUnlocalizedName(BlockLib.bCT);
        lettuceCrop = new CropBlock("lettuce").setUnlocalizedName(BlockLib.bCL);
        juiceMixer = new BlockJuiceMixer().setUnlocalizedName(BlockLib.bJM);
        Chocake = new ChocolateCake().setUnlocalizedName(BlockLib.bCake);
        strawberryBush = new StrawberryBush(Material.PLANTS).setUnlocalizedName(BlockLib.bSB);
		oliveBush = new OliveTreeSapling().setUnlocalizedName(BlockLib.bOliveBush);
		oliveLeaf = new OliveLeaf().setUnlocalizedName(BlockLib.bOliveLeaf);
		OrangeBlock = new OrangeBlock().setUnlocalizedName(BlockLib.bBlockOrange);
		pineappleCrop = new CropBlock("pineapple").setUnlocalizedName(BlockLib.bPineappleCrop);
		saplingOrange = new OrangeTreeSapling().setUnlocalizedName(BlockLib.ORANGE_SAPLING);
		grapeVine = new GrapeVines().setUnlocalizedName(BlockLib.bGrapeVine);

		Bbananajuice = new GeneralFluid(FluidLoader.Fbananajuice, Material.WATER).setUnlocalizedName(BlockLib.bFluidBan);
		Beggnog = new GeneralFluid(FluidLoader.FEggnog, Material.WATER).setUnlocalizedName(BlockLib.bFluidEgg);
		Bstrawberryjuice = new GeneralFluid(FluidLoader.Fstrawberryjuice, Material.WATER).setUnlocalizedName(BlockLib.bFluidStraw);
		Bcarrotjuice = new GeneralFluid(FluidLoader.Fcarrotjuice, Material.WATER).setUnlocalizedName(BlockLib.bFluidCarrot);
		BdiscustingMix = new GeneralFluid(FluidLoader.FHorribleLiquid, Material.WATER).setUnlocalizedName(BlockLib.bDisgustingMix);
		BappleJuice = new GeneralFluid(FluidLoader.Fapplejuice, Material.WATER).setUnlocalizedName(BlockLib.bAppleJuice);
		BorangeJuice = new GeneralFluid(FluidLoader.Forangejuice, Material.WATER).setUnlocalizedName(BlockLib.bOrangeJuice);
		BwatermelonJuice = new GeneralFluid(FluidLoader.Fwatermelonjuice, Material.WATER).setUnlocalizedName(BlockLib.bMelonJuice);
		Bgrapejuice = new GeneralFluid(FluidLoader.Fgrapejuice, Material.WATER).setUnlocalizedName(BlockLib.GRAPE_JUICE_BLOCK);
		Bapplegrapejuice = new GeneralFluid(FluidLoader.Fapplegrapejuice, Material.WATER).setUnlocalizedName(BlockLib.APPLE_GRAPE_JUICE_BLOCK);
		Bcitusjuice = new GeneralFluid(FluidLoader.Fcitusjuice, Material.WATER).setUnlocalizedName(BlockLib.CITRUS_JUICE_BLOCK);
		BpinappleJuice = new GeneralFluid(FluidLoader.FpinappleJuice, Material.WATER).setUnlocalizedName(BlockLib.PINEAPPLE_JUICE_BLOCK);
		BfruitJuice = new GeneralFluid(FluidLoader.Ffruitjuice, Material.WATER).setUnlocalizedName(BlockLib.FRUIT_JUICE_BLOCK);
		strawberryBananaJuice = new GeneralFluid(FluidLoader.Fstrawberrybanana, Material.WATER).setUnlocalizedName(BlockLib.STRAWBERRY_BANANA_JUICE);
		BmixedberryJuice = new GeneralFluid(FluidLoader.Fmixedberryjuice, Material.WATER).setUnlocalizedName(BlockLib.MIXED_BERRY_JUICE);
		tropicalJuice = new GeneralFluid(FluidLoader.Ftropicaljuice, Material.WATER).setUnlocalizedName(BlockLib.TROPICAL_JUICE);
		
		
		registerBlocks();
	}
	private static void registerBlocks() {
		if(!Register){
			registerBlock(bananaBunch, BlockLib.bBB);
			registerBlock(saplingBanana, BlockLib.bBS);
			registerBlock(cheesePress, BlockLib.bCP);
			registerBlock(autoCutter, BlockLib.bAC);
			registerBlock(juiceBlender, BlockLib.bJB);
			registerBlock(oven, BlockLib.bO);
			registerBlock(whiteout, BlockLib.bTWB);
			registerBlock(Bbananajuice, BlockLib.bFluidBan);
			registerBlock(Bstrawberryjuice, BlockLib.bFluidStraw);
			registerBlock(Beggnog, BlockLib.bFluidEgg);
            registerBlock(Bcarrotjuice, BlockLib.bFluidCarrot);
			registerBlock(strawberryBush, BlockLib.bSB);
			registerBlock(bananaLeaf, BlockLib.bBL);
			registerBlock(peanutbush, BlockLib.bPB);
			registerBlock(tomatoCrop, BlockLib.bCT);
			registerBlock(lettuceCrop, BlockLib.bCL);
			registerBlock(juiceMixer, BlockLib.bJM);
			registerBlock(Chocake, BlockLib.bCake);
			registerBlock(oliveBush, BlockLib.bOliveBush);
			registerBlock(oliveLeaf, BlockLib.bOliveLeaf);
			registerBlock(BdiscustingMix, BlockLib.bDisgustingMix);
			registerBlock(OrangeBlock, BlockLib.bBlockOrange);
			registerBlock(BappleJuice, BlockLib.bAppleJuice);
			registerBlock(BorangeJuice, BlockLib.bOrangeJuice);
			registerBlock(BwatermelonJuice, BlockLib.bMelonJuice);
			registerBlock(pineappleCrop, BlockLib.bPineappleCrop);
			registerBlock(grapeVine, BlockLib.bGrapeVine);
			registerBlock(Bapplegrapejuice, BlockLib.APPLE_GRAPE_JUICE_BLOCK);
			registerBlock(Bgrapejuice, BlockLib.GRAPE_JUICE_BLOCK);
			registerBlock(Bcitusjuice, BlockLib.CITRUS_JUICE_BLOCK);
			registerBlock(BpinappleJuice, BlockLib.PINEAPPLE_JUICE_BLOCK);
			registerBlock(saplingOrange, BlockLib.ORANGE_SAPLING);
			registerBlock(BfruitJuice, BlockLib.FRUIT_JUICE_BLOCK);
			registerBlock(BmixedberryJuice, BlockLib.MIXED_BERRY_JUICE);
			registerBlock(tropicalJuice, BlockLib.TROPICAL_JUICE);
			registerBlock(strawberryBananaJuice, BlockLib.STRAWBERRY_BANANA_JUICE);
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

	private static void registerBlock(Block block, String name){
		block.setRegistryName(name);
		GameRegistry.register(block);
		GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}
}

