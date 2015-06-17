package dmf444.ExtraFood.Core;
import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Common.items.ItemLoader;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
public class AchieveLoad {


	public static Achievement cheesePress;
	public static Achievement getCheese;
	public static Achievement obtainKnife;


	public static AchievementPage extraPage;


	public static void loadAc(){
		cheesePress = new Achievement("getpress", "GetPress", 0, 0, BlockLoader.cheesePress, null);
		getCheese = new Achievement("getcheese", "GetCheese", 3, 1, ItemLoader.cheeseWheel, cheesePress);
		obtainKnife = new Achievement("obtainknife", "ObtainKnife", -2, 0, ItemLoader.knife, null);

        cheesePress.registerStat();
        getCheese.registerStat();
        obtainKnife.registerStat();

		extraPage = new AchievementPage("Extra Food", cheesePress, getCheese, obtainKnife);
		extraPage.registerAchievementPage(extraPage);




	}


}
