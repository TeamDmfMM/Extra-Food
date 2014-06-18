package dmf444.ExtraFood.Core;
import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Common.items.ItemLoader;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.common.AchievementPage;
public class AchieveLoad {


	public static Achievement cheesePress;
	public static Achievement getCheese;
	public static Achievement obtainKnife;


	public static AchievementPage extraPage;


	public static void loadAc(){
		cheesePress = new Achievement(50, "GetPress", 0, 0, BlockLoader.cheesePress, null).registerAchievement();
		getCheese = new Achievement(51, "GetCheese", 3, 1, ItemLoader.cheeseWheel, cheesePress).registerAchievement();
		obtainKnife = new Achievement(52, "ObtainKnife", -2, 0, ItemLoader.knife, null).registerAchievement();


		extraPage = new AchievementPage("Extra Food", cheesePress, getCheese, obtainKnife);
		extraPage.registerAchievementPage(extraPage);


	}


}
