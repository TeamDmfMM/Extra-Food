package com.dmfmm.extrafood.init;

import com.dmfmm.extrafood.events.AchievementsEvent;
import com.dmfmm.extrafood.events.BucketEvent;
import com.dmfmm.extrafood.events.ConfigChangeEvent;
import com.dmfmm.extrafood.utilities.EFAchievementPage;
import com.dmfmm.extrafood.worldgen.spawn.BushSpawner;
import com.dmfmm.extrafood.worldgen.spawn.TreeSpawner;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by TeamDMFMM on 12/31/2016. Code originally written
 * for ExtraFood1.9TEST. Do not copy without permission,
 * because that is just mean. Code is VISIBLE SOURCE, therfore
 * credit us, just don't steal large portions of this.
 */
public class EventsLoader {

    public static void loadEvents() {

        //Config Change Event
        MinecraftForge.EVENT_BUS.register(new ConfigChangeEvent());

        //Generate Bushes
        GameRegistry.registerWorldGenerator(BushSpawner.INSTANCE, 0);
        GameRegistry.registerWorldGenerator(TreeSpawner.INSTANCE, 0);

        //Bucket Pickup Handler
        MinecraftForge.EVENT_BUS.register(BucketEvent.INSTANCE);

        //Add Seeds to the grass list
        MinecraftForge.addGrassSeed(new ItemStack(ItemLoader.TOMATO_SEEDS), 20);
        MinecraftForge.addGrassSeed(new ItemStack(ItemLoader.RAW_LETTUCE_SEEDS), 25);

        //Chest Generation
        //ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ItemLoader.cookBook), 1, 1, 50));
        //ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ItemLoader.cookBook), 1, 1, 50));
        //ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(ItemLoader.pineapple), 1, 1, 50));

        //Load the Achivements
        EFAchievementPage.loadAc();
        MinecraftForge.EVENT_BUS.register(new AchievementsEvent());

    }
}
