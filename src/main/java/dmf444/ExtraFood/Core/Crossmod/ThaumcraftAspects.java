package dmf444.ExtraFood.Core.Crossmod;

import net.minecraft.item.ItemStack;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Common.items.ItemLoader;

public class ThaumcraftAspects {
	
	//ThaumcraftApi.registerObjectTag(new ItemStack(Blocks.cobblestone), (new AspectList()).add(Aspect.ENTROPY, 1).add(Aspect.EARTH, 1));
	
	public static void registerThaumAspect() {
		ThaumcraftApi.registerObjectTag(new ItemStack(BlockLoader.strawberryBush), (new AspectList()).add(Aspect.PLANT, 2).add(Aspect.ORDER, 1));
		ThaumcraftApi.registerObjectTag(new ItemStack(BlockLoader.peanutbush), (new AspectList()).add(Aspect.CROP, 3).add(Aspect.ENTROPY, 1));
		ThaumcraftApi.registerObjectTag(new ItemStack(BlockLoader.bananaLeaf), (new AspectList()).add(Aspect.PLANT, 1));
		ThaumcraftApi.registerObjectTag(new ItemStack(BlockLoader.bananaBunch), (new AspectList()).add(Aspect.CROP, 1).add(Aspect.HUNGER, 1).add(Aspect.ORDER, 2));
		ThaumcraftApi.registerObjectTag(new ItemStack(BlockLoader.saplingBanana), (new AspectList()).add(Aspect.TREE, 1).add(Aspect.PLANT, 2).add(Aspect.HUNGER, 1));
		ThaumcraftApi.registerObjectTag(new ItemStack(BlockLoader.whiteout), (new AspectList()).add(Aspect.SENSES, 9));
		ThaumcraftApi.registerObjectTag(new ItemStack(BlockLoader.autoCutter), (new AspectList()).add(Aspect.METAL, 7).add(Aspect.TREE, 7));
		ThaumcraftApi.registerObjectTag(new ItemStack(BlockLoader.cheesePress), (new AspectList()).add(Aspect.METAL, 20).add(Aspect.TREE, 1).add(Aspect.EARTH, 3).add(Aspect.VOID, 1));
		ThaumcraftApi.registerObjectTag(new ItemStack(BlockLoader.juiceBlender), (new AspectList()).add(Aspect.EARTH, 7).add(Aspect.TREE, 1));
		ThaumcraftApi.registerObjectTag("itemKnife", (new AspectList()).add(Aspect.METAL, 16).add(Aspect.TREE, 1));
		ThaumcraftApi.registerObjectTag(new ItemStack(ItemLoader.cookBook), (new AspectList()).add(Aspect.MIND, 4).add(Aspect.PLANT, 2));
		ThaumcraftApi.registerObjectTag("itemGrater", (new AspectList()).add(Aspect.METAL, 24).add(Aspect.TREE, 2));
		ThaumcraftApi.registerObjectTag("foodStrawberry", (new AspectList()).add(Aspect.CROP, 2).add(Aspect.HUNGER, 1).add(Aspect.PLANT, 1));
		ThaumcraftApi.registerObjectTag(new ItemStack(BlockLoader.Bstrawberryjuice), (new AspectList()).add(Aspect.CROP, 2).add(Aspect.HUNGER, 1).add(Aspect.PLANT, 1).add(Aspect.WATER, 4));
		ThaumcraftApi.registerObjectTag(new ItemStack(BlockLoader.Bcarrotjuice), (new AspectList()).add(Aspect.CROP, 1).add(Aspect.HUNGER, 1).add(Aspect.SENSES, 1).add(Aspect.WATER, 4));
		ThaumcraftApi.registerObjectTag(new ItemStack(BlockLoader.Bbananajuice), (new AspectList()).add(Aspect.CROP, 1).add(Aspect.HUNGER, 1).add(Aspect.ORDER, 2).add(Aspect.WATER, 4));
		ThaumcraftApi.registerObjectTag(new ItemStack(ItemLoader.tomato), (new AspectList()).add(Aspect.CROP, 1).add(Aspect.HUNGER, 1).add(Aspect.LIFE, 1));
		ThaumcraftApi.registerObjectTag(new ItemStack(ItemLoader.lettuce), (new AspectList()).add(Aspect.CROP, 1).add(Aspect.HUNGER, 1).add(Aspect.HEAL, 1));
		
		
	}

}
