package dmf444.ExtraFood.Common.blocks.guis;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import dmf444.ExtraFood.ExtraFood;
import dmf444.ExtraFood.Core.lib.GuiLib;

public class CRPageGUI extends GuiScreen {


String pageTextFrom;
private ItemStack[] items;
RenderItem irender;
GuiButton next;
int page = 0;
String pagen;
GuiButton backpage;
GuiButton backGUI;
boolean Morethanone;
int pagesAllowed;




 public CRPageGUI(String pagename, Boolean multipg, int multiplePG) {

	 //This will be used to call the name of the page from the .lang file
	pageTextFrom = StatCollector.translateToLocal("cookbook." + pagename);
	this.items = ExtraFood.crafterPage.getArray(pagename);
	this.irender = new RenderItem();
	pagen = pagename;
	this.Morethanone = multipg;
	this.pagesAllowed = multiplePG;
}

 public void drawScreen(int par1, int par2, float par3) {
	 
	this.drawDefaultBackground();	
	this.drawBookBackground();
	this.drawTextSide();
	this.renderItems();
    GL11.glDisable(GL11.GL_LIGHTING);
    GL11.glDisable(GL11.GL_DEPTH_TEST);
    GL11.glEnable(GL11.GL_LIGHTING);
    GL11.glEnable(GL11.GL_DEPTH_TEST);
    super.drawScreen(par1, par2, par3);
 }

 protected void drawTextSide() {
	 //parts = string.split("-")
     int i = (this.width - CookBookGUI.getAchievementsPaneWidth()) / 2;
     int j = (this.height - CookBookGUI.achievementsPaneHeight) / 2;
     this.fontRendererObj.setUnicodeFlag(true);
	 this.fontRendererObj.drawSplitString(pageTextFrom, i + 28, j + 19, 93, 0x0000000);
     this.fontRendererObj.setUnicodeFlag(false);
	 }

 public void initGui(){
     int i = (this.width - CookBookGUI.getAchievementsPaneWidth()) / 2;
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
	int i1 = (this.width - CookBookGUI.getAchievementsPaneWidth()) / 2;
    int j1 = (this.height - CookBookGUI.achievementsPaneHeight) / 2;
    
    int k1 = j1 - 32;
	
    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
	this.mc.getTextureManager().bindTexture(GuiLib.CBopen);
    this.drawTexturedModalRect(i1, j1, 0, 0, CookBookGUI.getAchievementsPaneWidth(), CookBookGUI.achievementsPaneHeight + 50);


    this.mc.getTextureManager().bindTexture(GuiLib.CBcraftgrid);
    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    GL11.glEnable(GL11.GL_BLEND);
    this.drawTexturedModalRect(i1 + 145, j1 + 26, 0, 0, CookBookGUI.getAchievementsPaneWidth(), CookBookGUI.achievementsPaneHeight);
    GL11.glDisable(GL11.GL_BLEND);
 }

public void renderItems() {
	// Render code: this.irender.renderItemAndEffectIntoGUI(fontRendererObj, this.mc.getTextureManager(), items[0], 100, 100);
	int x = ((this.width - CookBookGUI.getAchievementsPaneWidth()) / 2) + 155 + 4;
    int y = ((this.height - CookBookGUI.achievementsPaneHeight) / 2) + 35 + 43;
    
	
	for (ItemStack i : this.items){
		if (i != null){
			
				/* Items 0-2 Render in top row
				 * Items 3-5 Render in middle row
				 * Items 6-8 Render in final row
				*/
		
				
			if (items[0] != null){				
		    GL11.glDisable(GL11.GL_LIGHTING);					
			this.irender.renderItemIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), items[0], x - 3, y);
			GL11.glEnable(GL11.GL_LIGHTING);			
			}	
			if (items[1] != null){
			    GL11.glDisable(GL11.GL_LIGHTING);	
			this.irender.renderItemIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), items[1], x + 18, y);
				GL11.glEnable(GL11.GL_LIGHTING);	
			}
			if (items[2] != null){
			    GL11.glDisable(GL11.GL_LIGHTING);	
			this.irender.renderItemIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), items[2], x + 40, y);
			GL11.glEnable(GL11.GL_LIGHTING);	
			}
			if (items[3] != null){
			    GL11.glDisable(GL11.GL_LIGHTING);	
			this.irender.renderItemIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), items[3], x - 3, y + 21);
			GL11.glEnable(GL11.GL_LIGHTING);	
			}
			if (items[4] != null){
			    GL11.glDisable(GL11.GL_LIGHTING);	
			this.irender.renderItemIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), items[4], x + 18, y + 21);
			GL11.glEnable(GL11.GL_LIGHTING);	
			}
			if (items[5] != null){
			    GL11.glDisable(GL11.GL_LIGHTING);	
			this.irender.renderItemIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), items[5], x + 40, y + 21);
			GL11.glEnable(GL11.GL_LIGHTING);	
			}
			if (items[6] != null){
			    GL11.glDisable(GL11.GL_LIGHTING);	
			this.irender.renderItemIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), items[6], x - 3, y + 43);
			GL11.glEnable(GL11.GL_LIGHTING);	
			}
			if (items[7] != null){
			    GL11.glDisable(GL11.GL_LIGHTING);	
			this.irender.renderItemIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), items[7], x + 18, y + 43);
			GL11.glEnable(GL11.GL_LIGHTING);	
			}
			if (items[8] != null){
			    GL11.glDisable(GL11.GL_LIGHTING);	
			this.irender.renderItemIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), items[8], x + 40, y + 43);
			GL11.glEnable(GL11.GL_LIGHTING);	
			}
			   //Itemstack 9 is the output slot
			if (items[9] != null){
				GL11.glDisable(GL11.GL_LIGHTING);
				this.irender.renderItemIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), items[9], x + 19, y - 44);
				this.irender.renderItemOverlayIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), items[9], x + 19, y - 44);
			GL11.glEnable(GL11.GL_LIGHTING);	
			}

			GL11.glEnable(GL11.GL_LIGHTING);
		}

	}

	}
 public void actionPerformed(GuiButton button){
	if (button.id == 0){
		if(page < pagesAllowed){
		page++;
		//if (StatCollector.translateToLocal("cookbook." + pagen + page) != "cookbook." + pagen + page){
		this.pageTextFrom = StatCollector.translateToLocal(StatCollector.translateToLocal("cookbook." + pagen + page));
		}
		//else {
		//	page--;
		//}
	}
	if (button.id == 1){
		page--;
		if (StatCollector.translateToLocal("cookbook." + pagen + page) != "cookbook." + pagen + page && page > 0){
		this.pageTextFrom = StatCollector.translateToLocal("cookbook." + pagen + page);
		}
		else if (page <= 0){
			this.pageTextFrom = StatCollector.translateToLocal("cookbook." + pagen);
			page = 0;
		}
	}	
	if (button.id == 2){

		this.mc.displayGuiScreen(new CookBookGUI());

	}

	}
 
}


