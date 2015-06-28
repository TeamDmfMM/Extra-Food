
package dmf444.ExtraFood.Core.Crossmod.NEI;

import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import dmf444.ExtraFood.Common.blocks.guis.AutoCutterGUI;
import dmf444.ExtraFood.Common.items.ItemLoader;
import dmf444.ExtraFood.ExtraFood;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import java.awt.*;

public class NEIAutoCutterHandler extends TemplateRecipeHandler{
	public class AutoCutterRecipe extends CachedRecipe{

		private PositionedStack output;
		private PositionedStack input;
		private PositionedStack knife;
		
		@Override
		public PositionedStack getResult() {
			return output;
		}
		@Override
        public PositionedStack getIngredient()
        {
            return input;
        }
		@Override
		public PositionedStack getOtherStack(){
			return knife;
		}
		
		public AutoCutterRecipe(ItemStack input, ItemStack output){
			
			if(input != null){
				this.input = new PositionedStack(input, 80 - 5, 24 - 11);
			}
			if (output != null){
				this.output = new PositionedStack(output, 80- 5, 56 - 11);
			}
			this.knife = new PositionedStack(new ItemStack(ItemLoader.knife), 147 - 5, 24 - 11);
		}

}

	@Override
	public String getRecipeName() {
		return StatCollector.translateToLocal("tile.Auto_Cutter.name");
	}

	@Override
	public String getGuiTexture() {
		return new ResourceLocation("extrafood", "textures/gui/Auto_Cutter.png").toString();
	}
	  @Override
	  public Class<? extends GuiContainer> getGuiClass() {
		  return AutoCutterGUI.class;
	  }
	  @Override
	  public String getOverlayIdentifier() {
		  return "EFAutoCutter";
	  }
	  
	  @Override
	  public void loadTransferRects() {
		  transferRects.add(new TemplateRecipeHandler.RecipeTransferRect(new Rectangle(112,24,7,26), "EFAutoCutter", new Object[0]));
	  }
	  //FROM GUI
	  @Override 
	  public void loadCraftingRecipes(String outputId, Object... results){
		  if(outputId.equals("EFAutoCutter") && getClass() == NEIAutoCutterHandler.class){
			  
			  for(int x = 0; x < ExtraFood.registryCutter.getLength(); x++){
				  AutoCutterRecipe res = new AutoCutterRecipe(ExtraFood.registryCutter.getItemInput(x), ExtraFood.registryCutter.getItemOutput(ExtraFood.registryCutter.getItemInput(x)));
				  arecipes.add(res); 
			  }
		  } else {
			  super.loadCraftingRecipes(outputId, results);
		  }
	  }
	  
	  //FROM "R" or Recipies
	  @Override
	  public void loadCraftingRecipes(ItemStack result){
		  for(int x = 0; x < ExtraFood.registryCutter.getLength(); x++){
			  if(NEIServerUtils.areStacksSameTypeCrafting(result, ExtraFood.registryCutter.getItemOutput(ExtraFood.registryCutter.getItemInput(x)))){
			  AutoCutterRecipe res = new AutoCutterRecipe(ExtraFood.registryCutter.getItemInput(x), ExtraFood.registryCutter.getItemOutput(ExtraFood.registryCutter.getItemInput(x)));
			  arecipes.add(res);
			  }
		  }
	  }	 
	  //FROM CLICK ON "U"
	  @Override
	  public void loadUsageRecipes(ItemStack ingredients){
		  for(int x = 0; x < ExtraFood.registryCutter.getLength(); x++){
			  if(NEIServerUtils.areStacksSameTypeCrafting(ExtraFood.registryCutter.getItemInput(x), ingredients)){
			  AutoCutterRecipe res = new AutoCutterRecipe(ExtraFood.registryCutter.getItemInput(x), ExtraFood.registryCutter.getItemOutput(ExtraFood.registryCutter.getItemInput(x)));
			  arecipes.add(res);
			  }
		  }
	  }	  
	  @Override
	  public void drawExtras(int recipeI){
		  drawProgressBar(116 - 5, 34 - 11, 176, 0, 10, 28, 100, 1);
		  AutoCutterRecipe recipe = (AutoCutterRecipe) arecipes.get(recipeI);
	  }
}

