package com.dmfmm.extrafood.utilities;

import com.dmfmm.extrafood.init.BlockLoader;
import com.dmfmm.extrafood.init.ItemLoader;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

/**
 * Created by TeamDMFMM on 12/31/2016. Code originally written
 * for ExtraFood1.9TEST. Do not copy without permission,
 * because that is just mean. Code is VISIBLE SOURCE, therfore
 * credit us, just don't steal large portions of this.
 */
public class EFAchievementPage {


    public static Achievement MAKE_CHEESE_PRESS;
    public static Achievement AQUIRE_CHEESE;
    public static Achievement OBTAIN_CHEESE;


    public static AchievementPage extraPage;


    public static void loadAc(){
        MAKE_CHEESE_PRESS = new Achievement("getpress", "GetPress", 0, 0, BlockLoader.CHEESE_PRESS, null);
        AQUIRE_CHEESE = new Achievement("getcheese", "GetCheese", 3, 1, ItemLoader.CHEESE_WHEEL, MAKE_CHEESE_PRESS);
        OBTAIN_CHEESE = new Achievement("obtainknife", "ObtainKnife", -2, 0, ItemLoader.KNIFE, null);

        MAKE_CHEESE_PRESS.registerStat();
        AQUIRE_CHEESE.registerStat();
        OBTAIN_CHEESE.registerStat();

        extraPage = new AchievementPage("Extra Food", MAKE_CHEESE_PRESS, AQUIRE_CHEESE, OBTAIN_CHEESE);
        extraPage.registerAchievementPage(extraPage);




    }


}