package dmf444.ExtraFood.Common.blocks.guis;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import dmf444.ExtraFood.ExtraFood;
import dmf444.ExtraFood.Core.lib.GuiLib;

public class BTPageGUI extends GuiScreen {


String pageTextLeft;
String pageTextRight;
private ItemStack[] items;
RenderItem irender;
GuiButton next;
int page = 0;
String pagen;
GuiButton backpage;
GuiButton backGUI;
boolean Morethanone;
int pagesAllowed;




 public BTPageGUI(String pagename, Boolean multipg, int multiplePG) {

	 //This will be used to call the name of the page from the .lang file
	pageTextLeft = StatCollector.translateToLocal("cookbookL." + pagename);
	pageTextRight = StatCollector.translateToLocal("cookbookR." + pagename);
	this.items = ExtraFood.crafterPage.getArray(pagename);
	this.irender = new RenderItem();
	pagen = pagename;
	this.Morethanone = multipg;
	this.pagesAllowed = multiplePG;
}

 public void drawScreen(int par1, int par2, float par3) {
	 
	this.drawDefaultBackground();	
	this.drawBookBackground();
	this.drawTextLeftSide();
	this.drawTextRightSide();
    GL11.glDisable(GL11.GL_LIGHTING);
    GL11.glDisable(GL11.GL_DEPTH_TEST);
    GL11.glEnable(GL11.GL_LIGHTING);
    GL11.glEnable(GL11.GL_DEPTH_TEST);
    super.drawScreen(par1, par2, par3);
 }
 
 protected void drawTextRightSide() {
	 //parts = string.split("-")
     int i = (this.width - CookBookGUI.achievementsPaneWidth) / 2;
     int j = (this.height - CookBookGUI.achievementsPaneHeight) / 2;
     this.fontRendererObj.setUnicodeFlag(true);
	 this.fontRendererObj.drawSplitString(pageTextRight, i + 140, j + 19, 93, 0x0000000);
     this.fontRendererObj.setUnicodeFlag(false);
	 }

 protected void drawTextLeftSide() {
	 //parts = string.split("-")
     int i = (this.width - CookBookGUI.achievementsPaneWidth) / 2;
     int j = (this.height - CookBookGUI.achievementsPaneHeight) / 2;
     this.fontRendererObj.setUnicodeFlag(true);
	 this.fontRendererObj.drawSplitString(pageTextLeft, i + 28, j + 19, 93, 0x0000000);
     this.fontRendererObj.setUnicodeFlag(false);
	 }

 public void initGui(){
     int i = (this.width - CookBookGUI.achievementsPaneWidth) / 2;
     int j = (this.height - CookBookGUI.achievementsPaneHeight) / 2;
     if (StatCollector.translateToLocal("cookbook." + pagen + "2") != "cookbook." + pagen + "2"){
    	 if(Morethanone){
     this.buttonList.add(this.next = new ButtonNextPageGUI(0, i + 221, j + 160, true));
	 this.buttonList.add(this.backpage = new ButtonNextPageGUI(1, i + 13, j + 160, false));
    	}
	 this.buttonList.add(this.backGUI = new ButtonBackGUI(2, i + 6, j + 2, false));
     }
 }

protected void drawBookBackground() {
	//I decided to use the achivement size, because it kinda just worked!
	int i1 = (this.width - CookBookGUI.achievementsPaneWidth) / 2;
    int j1 = (this.height - CookBookGUI.achievementsPaneHeight) / 2;
    
    int k1 = j1 - 32;
	
    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
	this.mc.getTextureManager().bindTexture(GuiLib.CBopen);
    this.drawTexturedModalRect(i1, j1, 0, 0, CookBookGUI.achievementsPaneWidth, CookBookGUI.achievementsPaneHeight + 50);
    
 }


 public void actionPerformed(GuiButton button){
	if (button.id == 0){
		if(page < pagesAllowed){
		page++;
		//if (StatCollector.translateToLocal("cookbook." + pagen + page) != "cookbook." + pagen + page){
		this.pageTextLeft = StatCollector.translateToLocal(StatCollector.translateToLocal("cookbook." + pagen + page));
		}
		//else {
		//	page--;
		//}
	}
	if (button.id == 1){
		page--;
		if (StatCollector.translateToLocal("cookbook." + pagen + page) != "cookbook." + pagen + page && page > 0){
		this.pageTextLeft = StatCollector.translateToLocal("cookbook." + pagen + page);
		}
		else if (page <= 0){
			this.pageTextLeft = StatCollector.translateToLocal("cookbook." + pagen);
			page = 0;
		}
	}	
	if (button.id == 2){

		this.mc.displayGuiScreen(new CookBookGUI());

	}

	}
 
}
