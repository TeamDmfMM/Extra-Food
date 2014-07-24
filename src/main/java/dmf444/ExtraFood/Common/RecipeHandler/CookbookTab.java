package dmf444.ExtraFood.Common.RecipeHandler;


import java.util.ArrayList;


import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;


import org.lwjgl.opengl.GL11;


import dmf444.ExtraFood.Common.blocks.guis.ClickTab;
import dmf444.ExtraFood.Common.blocks.guis.CookBookGUI;
import dmf444.ExtraFood.Core.lib.GuiLib;


public class CookbookTab {
	public ArrayList<ClickTab> buttons;
	public String name;

	public ItemStack display;
	public RenderItem rinder;


	public CookbookTab(String name){
		this.name = name;
		this.buttons = new ArrayList<ClickTab>();
		this.rinder = new RenderItem();
	}
	
	public void addButton(ClickTab tabby){
		this.buttons.add(tabby);
	}
	
	public void drawButton(Minecraft m, int p1, int p2, CookBookGUI gui){


		m.getTextureManager().bindTexture(GuiLib.CBborder);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_BLEND);
		if(gui.tab != this.name){
			gui.drawTexturedModalRect(p1 - 8, p2 + 2, 92, 202, 37, 26); //2, 204, 22, 22     ``54``
			this.rinder.renderItemIntoGUI(m.fontRenderer, m.getTextureManager(), this.display,p1 + 11, p2 + 2 + 4);
		} else{
			gui.drawTexturedModalRect(p1 - 8, p2 + 2, 54, 202, 37, 26);
			this.rinder.renderItemIntoGUI(m.fontRenderer, m.getTextureManager(), this.display,p1 + 5, p2 + 2 + 4);
		}
		
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_BLEND);

	}
}
