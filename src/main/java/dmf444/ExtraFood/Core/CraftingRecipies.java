package dmf444.ExtraFood.Core;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import cpw.mods.fml.common.registry.GameRegistry;
import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Common.items.ItemLoader;


public class CraftingRecipies {
	
	public static void craftering()
	{
	GameRegistry.addRecipe(new ItemStack(BlockLoader.cheesePress, 1), new Object[] {"ipi", "ibi", "sss", 'i', Items.iron_ingot, 'p', Blocks.planks, 'b', Items.bucket, 's', Blocks.stone_slab});
	GameRegistry.addRecipe(new ItemStack(ItemLoader.knife, 1), new Object[] {"ii ", "ii ", " j ", 'i', Items.iron_ingot, 'j', Items.stick});
	GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.cheeseSlice, 8), new ItemStack(ItemLoader.knife, 1, 32767), new ItemStack(ItemLoader.cheeseWheel, 1) );
	}
	
}
