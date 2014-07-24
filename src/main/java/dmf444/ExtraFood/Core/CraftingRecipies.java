package dmf444.ExtraFood.Core;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import cpw.mods.fml.common.registry.GameRegistry;
import dmf444.ExtraFood.ExtraFood;
import dmf444.ExtraFood.Common.RecipeHandler.RecipeAutoCutter;
import dmf444.ExtraFood.Common.RecipeHandler.RegistryAutoCutter;
import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Common.items.ItemLoader;


public class CraftingRecipies {
	
	public static void craftering()
	{
	GameRegistry.addRecipe(new ItemStack(BlockLoader.cheesePress, 1), new Object[] {"ipi", "ibi", "sss", 'i', Items.iron_ingot, 'p', Blocks.planks, 'b', Items.bucket, 's', Blocks.stone_slab});
	GameRegistry.addRecipe(new ItemStack(ItemLoader.knife, 1), new Object[] {"ii ", "ii ", " j ", 'i', Items.iron_ingot, 'j', Items.stick});
	Cutting(new ItemStack(ItemLoader.cheeseWheel, 1), new ItemStack(ItemLoader.cheeseSlice, 8));
	Cutting(new ItemStack(Items.bread, 1), new ItemStack(ItemLoader.slicedBread, 6));
	Cutting(new ItemStack(Items.porkchop, 1), new ItemStack(ItemLoader.sausage, 2));
	}
	public static void furnacing()
	{
		GameRegistry.addSmelting(ItemLoader.bacon, new ItemStack(ItemLoader.cookedBacon, 1), 0.2F);
		GameRegistry.addSmelting(ItemLoader.slicedBread, new ItemStack(ItemLoader.toast, 1), 0.1F);
		GameRegistry.addSmelting(ItemLoader.bucketseaWater, new ItemStack(ItemLoader.bucketpurifiedwater, 1), 0.5F);
	}
	
	/*
	 *  Adds in recipies that can be cut by the knife and cutt by the Auto Cutter.
	 * 
	 */
	public static void Cutting(ItemStack input, ItemStack output){
		ExtraFood.instance.registryCutter.registerRecipe(new RecipeAutoCutter(input, output));
		GameRegistry.addShapelessRecipe(output, new ItemStack(ItemLoader.knife, 1, 32767), input);
	}
}
