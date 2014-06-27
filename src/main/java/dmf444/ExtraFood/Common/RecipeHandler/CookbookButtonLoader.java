package dmf444.ExtraFood.Common.RecipeHandler;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;
import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Common.blocks.guis.ClickTab;
import dmf444.ExtraFood.Common.items.ItemLoader;

public class CookbookButtonLoader {

	public ArrayList<ClickTab> buttons;
	public static CookbookButtonLoader bookButton = new CookbookButtonLoader();

	public CookbookButtonLoader() {
		// TODO Auto-generated constructor stub
		this.buttons = new ArrayList<ClickTab>();
		// TODO Add buttons here
		buttons.add(new ClickTab(0, 0, 0, 22, 22, "", 1, 1, new ItemStack(BlockLoader.cheesePress), "cheesepress"));
		buttons.add(new ClickTab(0, 0, 0, 22, 22, "", 6, 5, new ItemStack(ItemLoader.cheeseSlice), "cheeseslice", "cheesepress", "knife" ));
		buttons.add(new ClickTab(0, 0, 0, 22, 22, "", 1, 5, new ItemStack(ItemLoader.knife), "knife"));


	}




}
