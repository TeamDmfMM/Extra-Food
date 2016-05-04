package dmf444.ExtraFood.Core.init;

import dmf444.ExtraFood.Common.items.ItemLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ItemTextureRegistry {


    public static void registerItemTextures(){
        register(ItemLoader.cheeseWheel, 0);
        register(ItemLoader.bacon, 0);
        register(ItemLoader.banana, 0);
        register(ItemLoader.bucketbanana, 0);
        register(ItemLoader.bucketcarrot, 0);
        register(ItemLoader.bucketpurifiedwater, 0);
        register(ItemLoader.slicedBread, 0);
        register(ItemLoader.bucketstrawberry, 0);
        register(ItemLoader.bucketseaWater, 0);
        register(ItemLoader.butter,0);
        register(ItemLoader.butterMilk, 0);
        register(ItemLoader.cookBook, 0);
        register(ItemLoader.cookedBacon, 0);
        register(ItemLoader.cookedHamburger, 0);
        register(ItemLoader.chocolate, 0);
        register(ItemLoader.chocolateIceCream, 0);
        register(ItemLoader.sandwichC, 0);
        register(ItemLoader.chocolateSpread, 0);
        register(ItemLoader.uselettuceSeeds, 0);
        register(ItemLoader.chineseFood, 0);
        register(ItemLoader.cookedpasta, 0);
        register(ItemLoader.cheeseSlice, 0);
        //register(ItemLoader.cheeseWheel, 0);
        register(ItemLoader.egg,0);
        register(ItemLoader.fishpieces, 0);
        register(ItemLoader.frenchToast, 0);
        register(ItemLoader.grater,0);
        register(ItemLoader.jelly, 0);
        register(ItemLoader.knife, 0);
        register(ItemLoader.lettuce, 0);
        register(ItemLoader.meatballs, 0);
        register(ItemLoader.meatballpasta, 0);
        register(ItemLoader.neoIceCream, 0);
        register(ItemLoader.peanut, 0);
        register(ItemLoader.rawpasta, 0);
        register(ItemLoader.peanutButter, 0);
        register(ItemLoader.pancakes, 0);
        register(ItemLoader.pork_kebab, 0);
        register(ItemLoader.icePop, 0);
        register(ItemLoader.rawHamburger, 0);
        register(ItemLoader.sausage, 0);
        register(ItemLoader.sandwichBLT, 0);
        register(ItemLoader.sandwhichCB, 0);
        register(ItemLoader.sandwichCheeseburger, 0);
        register(ItemLoader.sandwhichGC, 0);
        register(ItemLoader.sandwhichHamburger, 0);
        register(ItemLoader.sandwichPBJ, 0);
        register(ItemLoader.sandwichPBN, 0);
        register(ItemLoader.sandwichPB, 0);
        register(ItemLoader.sandwhichS, 0);
        register(ItemLoader.sandwichSupremeBurger, 0);
        register(ItemLoader.steak_kebab, 0);
        register(ItemLoader.strawberry, 0);
        register(ItemLoader.strawberryIceCream, 0);
        register(ItemLoader.stawberryYogurt, 0);
        register(ItemLoader.sushi, 0);
        register(ItemLoader.toast, 0);
        register(ItemLoader.tomato, 0);
        register(ItemLoader.tomatoSeeds, 0);
        register(ItemLoader.rawlettuceSeeds, 0);
        register(ItemLoader.veal, 0);
        register(ItemLoader.vanillaIceCream, 0);
        register(ItemLoader.veal_kebab, 0);
        register(ItemLoader.yogurt, 0);
        register(ItemLoader.frenchFries, 0);
        register(ItemLoader.bucketeggnog, 0);
        register(ItemLoader.shortbread, 0);
        register(ItemLoader.fruitcake, 0);
        register(ItemLoader.gingerbread, 0);
        register(ItemLoader.chestnuts, 0);
        register(ItemLoader.dough, 0);
        register(ItemLoader.olive, 0);

        register(ItemLoader.muffinPan, 0);
        // TODO: Fixme
        register(ItemLoader.ChocolateCake, 0);
        register(ItemLoader.orange, 0);
        register(ItemLoader.pineapple, 0);
        register(ItemLoader.pineappleSlice, 0);
        register(ItemLoader.grapes, 0);

    }



    private static void register(Item item, int meta){
        ItemModelMesher modelRegistry = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
        //EFLog.fatal((ResourceLocation) Item.itemRegistry.getNameForObject(item));
        modelRegistry.register(item, 0, new ModelResourceLocation((ResourceLocation) Item.itemRegistry.getNameForObject(item), "inventory"));
    }


}
