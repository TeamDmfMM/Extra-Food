package dmf444.ExtraFood.Common.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import dmf444.ExtraFood.Common.blocks.tileentity.AutoCutterTileEntity;
import dmf444.ExtraFood.Common.blocks.tileentity.CheesePressTileEntity;
import dmf444.ExtraFood.Common.blocks.tileentity.TileEntityJuiceBlender;
import dmf444.ExtraFood.Common.blocks.tileentity.TileEntityOven;
import dmf444.ExtraFood.Core.lib.BlockLib;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockLoader {

	public static Block bananaBunch;
	public static Block saplingBanana;
	public static Block cheesePress;
	public static Block autoCutter;
	public static Block juiceBlender;
	public static Block oven;
	
	public static boolean Register=false;
	public static void initiateBlocks() {
		bananaBunch = new BananaBlock(BlockLib.idBanana, Material.cactus).setUnlocalizedName(BlockLib.bBB).setTextureName("extrafood:BananaTree");
		saplingBanana = new BananaTreeSapling(BlockLib.idBananaSap).setUnlocalizedName(BlockLib.bBS);
		cheesePress = new CheesePress(BlockLib.idCheesePress).setUnlocalizedName(BlockLib.bCP);
		autoCutter = new AutoCutter(BlockLib.idAutoCutter).setUnlocalizedName(BlockLib.bAC);
		juiceBlender = new BlockJuiceBlender(BlockLib.idJuiceBlender, Material.anvil).setUnlocalizedName(BlockLib.bJB);
		oven = new Oven(BlockLib.idOven).setUnlocalizedName(BlockLib.bO);
		
		
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

