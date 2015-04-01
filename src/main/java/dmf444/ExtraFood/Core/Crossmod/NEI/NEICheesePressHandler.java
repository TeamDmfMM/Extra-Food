package dmf444.ExtraFood.Core.Crossmod.NEI;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import codechicken.nei.recipe.TemplateRecipeHandler.CachedRecipe;
import dmf444.ExtraFood.Common.blocks.guis.CheesePressGUI;
import dmf444.ExtraFood.Common.items.ItemLoader;

//THIS Class was made at the request of guygames123.
//Everyone who uses it should thank him for it.
public class NEICheesePressHandler extends TemplateRecipeHandler{
	public class CheesePressRecipe extends CachedRecipe{
		private PositionedStack output;
		private ArrayList<PositionedStack> finished;
		
		@Override
		public PositionedStack getResult() {
			return output;
		}
		@Override
		public List<PositionedStack> getIngredients()
		{
			return getCycledIngredients(cycleticks / 20, finished);
		}
		public CheesePressRecipe(ItemStack output, ItemStack inputs){
			this.finished = new ArrayList<PositionedStack>();
			if(inputs != null){
				this.finished.add(new PositionedStack(inputs, 54 - 5, 20 - 11));
				this.finished.add(new PositionedStack(inputs, 78 - 5, 20 - 11));
				this.finished.add(new PositionedStack(inputs, 102 - 5, 20 - 11));
			}
			if(output != null){
				this.output = new PositionedStack(output, 78 - 5, 54 - 11);
			}
		}
}

	@Override
	public String getRecipeName() {
		return StatCollector.translateToLocal("tile.CheesePress.name");
	}

	@Override
	public String getGuiTexture() {
		return new ResourceLocation("extrafood", "textures/gui/cheese_press.png").toString();
	}
	  @Override
	  public Class<? extends GuiContainer> getGuiClass() {
		  return CheesePressGUI.class;
	  }
	  @Override
	  public String getOverlayIdentifier() {
		  return "EFCheesePress";
	  }
	  @Override
	  public void loadTransferRects() {
		  transferRects.add(new TemplateRecipeHandler.RecipeTransferRect(new Rectangle(128,19,3,26), "EFCheesePress", new Object[0]));
	  }
	  
	//From GUI
	  @Override 
	  public void loadCraftingRecipes(String outputId, Object... results){
		  if(outputId.equals("EFCheesePress") && getClass() == NEICheesePressHandler.class){
			  CheesePressRecipe res = new CheesePressRecipe(new ItemStack(ItemLoader.cheeseWheel), new ItemStack(Items.milk_bucket));
				  arecipes.add(res); 
		  } else {
			  super.loadCraftingRecipes(outputId, results);
		  }
	  }
	//FROM "R"
	  @Override
	  public void loadCraftingRecipes(ItemStack result){
		if(NEIServerUtils.areStacksSameTypeCrafting(result, new ItemStack(ItemLoader.cheeseWheel))){
			 CheesePressRecipe res = new CheesePressRecipe(new ItemStack(ItemLoader.cheeseWheel), new ItemStack(Items.milk_bucket));
			 arecipes.add(res);
		  }
	  }
	  //FROM CLICK ON "U"
	  @Override
	  public void loadUsageRecipes(ItemStack ingredients){
		  if(NEIServerUtils.areStacksSameTypeCrafting(new ItemStack(Items.milk_bucket), ingredients)){
			  CheesePressRecipe res = new CheesePressRecipe(new ItemStack(ItemLoader.cheeseWheel), new ItemStack(Items.milk_bucket));
			  arecipes.add(res);
		  }
	  }	
	  @Override
	  public void drawExtras(int recipeI){
		  drawProgressBar(128, 19, 176, 0, 3, 26, 125, 1);
	  }
	
}
