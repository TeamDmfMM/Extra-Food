package dmf444.ExtraFood.Common.RecipeHandler;


import dmf444.ExtraFood.Common.blocks.guis.ClickTab;
import dmf444.ExtraFood.Common.blocks.guis.CookBookGUI;
import dmf444.ExtraFood.Core.lib.GuiLib;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;


public class CookbookTab {
	public ArrayList<ClickTab> buttons;
	public String name;

	public ItemStack display;
	public String render;
	public RenderItem rinder;


	public CookbookTab(String name){
		this.name = name;
		this.buttons = new ArrayList<ClickTab>();
		this.rinder = Minecraft.getMinecraft().getRenderItem();
	}
	
	public void addButton(ClickTab tabby){
		this.buttons.add(tabby);
	}
	
	public void drawButton(Minecraft m, int p1, int p2, CookBookGUI gui){


		m.getTextureManager().bindTexture(GuiLib.CBborder);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glColor4d(1, 1, 1, 1);
		if (render == null) {
			if (gui.tab != this.name) {
				gui.drawTexturedModalRect(p1 - 8, p2 + 2, 92, 202, 37, 26); // 2,
																			// 204,
																			// 22,
																			// 22
																			// ``54``
                this.rinder.renderItemIntoGUI(this.display, p1 + 11, p2 + 2 + 4);
            } else {
				gui.drawTexturedModalRect(p1 - 8, p2 + 2, 54, 202, 37, 26);
				this.rinder.renderItemIntoGUI(this.display, p1 + 5, p2 + 2 + 4);
			}
		} else {
			if (gui.tab != this.name) {
				gui.drawTexturedModalRect(p1 - 8, p2 + 2, 92, 202, 37, 26); // 2,
																			// 204,
																			// 22,
				m.getTextureManager().bindTexture(new ResourceLocation(this.render));												// 22
																			// ``54``
				gui.drawTexturedModalRect(p1 + 11, p2 + 2 +6, 0, 0, 16, 16);
			} else {
				gui.drawTexturedModalRect(p1 - 8, p2 + 2, 54, 202, 37, 26);
				m.getTextureManager().bindTexture(new ResourceLocation(this.render));
				gui.drawTexturedModalRect(p1 + 5, p2 + 2 +6, 0, 0, 16, 16);
			}
		}

		
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_BLEND);

	}
}
