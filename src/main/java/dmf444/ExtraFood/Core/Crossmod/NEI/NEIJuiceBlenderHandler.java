package dmf444.ExtraFood.Core.Crossmod.NEI;

import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import dmf444.ExtraFood.Common.RecipeHandler.JuiceRegistry;
import dmf444.ExtraFood.Common.blocks.guis.GuiJuiceBlender;
import dmf444.ExtraFood.Common.items.ItemLoader;
import dmf444.ExtraFood.Core.lib.GuiLib;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.ArrayList;

import static codechicken.lib.gui.GuiDraw.gui;
import static codechicken.lib.gui.GuiDraw.renderEngine;

public class NEIJuiceBlenderHandler extends TemplateRecipeHandler{
	public class JuiceBlenderRecipe extends CachedRecipe{

		private PositionedStack input;
		private PositionedStack output;
		private PositionedStack bucket;
		
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
			return bucket;
		}

		public JuiceBlenderRecipe(ItemStack input, ItemStack output){
			if(input != null){
				this.input = new PositionedStack(input, 80 - 5, 20 - 11);
			}
			if (output != null){
				this.output = new PositionedStack(output, 126 - 5, 34 - 11);
			}
			this.bucket = new PositionedStack(new ItemStack(Items.bucket), 126 - 5, 12 - 11);
		}
		
	}

	/*
	 * ADD ALL THE ITEMS FOR EACH RECIPE HERE!!!
	 */
	ArrayList<Item> InputItems = new ArrayList<Item>(){{
		add(ItemLoader.banana);
		add(ItemLoader.strawberry);
		add(Items.carrot);
		}};
	ArrayList<Item> OutputBuckets = new ArrayList<Item>(){{
		add(ItemLoader.bucketbanana);
		add(ItemLoader.bucketstrawberry);
		add(ItemLoader.bucketcarrot);
		}};
	
	@Override
	public String getRecipeName() {
		return StatCollector.translateToLocal("tile.Juice_Blender.name");
	}

	@Override
	public String getGuiTexture() {
		return new ResourceLocation("extrafood", "textures/gui/Juice_Blender.png").toString();
	}
	  @Override
	  public Class<? extends GuiContainer> getGuiClass() {
		  return GuiJuiceBlender.class;
	  }
	  @Override
	  public String getOverlayIdentifier() {
		  return "EFJuiceBlender";
	  }
	  @Override
	  public void loadTransferRects() {
		  transferRects.add(new TemplateRecipeHandler.RecipeTransferRect(new Rectangle(98,53,39,4), "EFJuiceBlender", new Object[0]));
	  }
	  //From GUI
	  @Override 
	  public void loadCraftingRecipes(String outputId, Object... results){
		  if(outputId.equals("EFJuiceBlender") && getClass() == NEIJuiceBlenderHandler.class){
			  
			  for(int x = 0; x < InputItems.size(); x++){
				  JuiceBlenderRecipe res = new JuiceBlenderRecipe(new ItemStack(InputItems.get(x), 10), new ItemStack(OutputBuckets.get(x)));
				  arecipes.add(res); 
			  }
		  } else {
			  super.loadCraftingRecipes(outputId, results);
		  }
	  }
	  //FROM "R"
	  @Override
	  public void loadCraftingRecipes(ItemStack result){
		  for(int x = 0; x < InputItems.size(); x++){
			  if(NEIServerUtils.areStacksSameTypeCrafting(result, new ItemStack(OutputBuckets.get(x)))){
			  JuiceBlenderRecipe res = new JuiceBlenderRecipe(new ItemStack(InputItems.get(x), 10), new ItemStack(OutputBuckets.get(x)));
			  arecipes.add(res);
			  }
		  }
	  }
	  //FROM CLICK ON "U"
	  @Override
	  public void loadUsageRecipes(ItemStack ingredients){
		  for(int x = 0; x < InputItems.size(); x++){
			  if(NEIServerUtils.areStacksSameTypeCrafting(new ItemStack(InputItems.get(x)), ingredients)){
				  JuiceBlenderRecipe res = new JuiceBlenderRecipe(new ItemStack(InputItems.get(x), 10), new ItemStack(OutputBuckets.get(x)));
			  arecipes.add(res);
			  }
		  }
	  }	  
	  @Override
	  public void drawExtras(int recipeI){
		 
		  IIcon juice = GuiJuiceBlender.getFluidTexture(JuiceRegistry.instance.getJuiceFromItemStack(arecipes.get(recipeI).getIngredient().item), false);
		  renderEngine.bindTexture(TextureMap.locationBlocksTexture);
		  gui.drawTexturedModelRectFromIcon(147 - 5, (int)((62 - (1000 * 0.012)) - 1), juice, 16, (int)(1000 * 0.012));
		  renderEngine.bindTexture(GuiLib.JBgui);
		  gui.drawTexturedModalRect(147 - 5, 17 - 11, 217, 0, 16, 49);
		  float[] color = JuiceRegistry.instance.getColor(arecipes.get(recipeI).getIngredient().item);
			float r = color[0];
			float g = color[1];
			float b = color[2];
			float a = 1.0f;
			GL11.glColor4f(r, g, b, a);
			 drawProgressBar(103 - 5, 64 - 11, 176, 0, 39, 4, 100, 0);
			GL11.glColor4f(1f, 1f, 1f, 1f);
			//List<String> list = new ArrayList<String>();
			//list.add("Amount: 1000mB");
			
		  //JuiceBlenderRecipe recipe = (JuiceBlenderRecipe) arecipes.get(recipeI);
	  }
	  
}
