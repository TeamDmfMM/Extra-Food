package dmf444.ExtraFood.Core;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import cpw.mods.fml.common.registry.GameRegistry;
import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Common.items.ItemLoader;


public class CraftingRecipies {
	
	public static void craftering()
	{
	GameRegistry.addRecipe(new ItemStack(BlockLoader.cheesePress, 1), new Object[] {"ipi", "ibi", "sss", 'i', Item.ingotIron, 'p', Block.planks, 'b', Item.bucketEmpty, 's', Block.stoneSingleSlab});
	GameRegistry.addRecipe(new ItemStack(ItemLoader.knife, 1), new Object[] {"ii ", "ii ", " j ", 'i', Item.ingotIron, 'j', Item.stick});
	GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.cheeseSlice, 8), new ItemStack(ItemLoader.knife, 1, 32767), new ItemStack(ItemLoader.cheeseWheel, 1) );
	}
	
}
