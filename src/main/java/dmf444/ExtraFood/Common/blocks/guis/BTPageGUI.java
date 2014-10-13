package dmf444.ExtraFood.Common.blocks.guis;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.print.attribute.standard.Sides;


import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;


import org.lwjgl.opengl.GL11;


import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import dmf444.ExtraFood.ExtraFood;
import dmf444.ExtraFood.Common.RecipeHandler.CookbookButtonLoader;
import dmf444.ExtraFood.Core.lib.GuiLib;
import dmf444.ExtraFood.Core.lib.ItemLib;
import dmf444.ExtraFood.util.EFLog;


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
int p3 = 9999;

ArrayList<Object> ris;
ArrayList<ArrayList<Object>> p3r = new ArrayList<ArrayList<Object>>();





 public BTPageGUI(String pagename, Boolean multipg, int multiplePG) {


	 //This will be used to call the name of the page from the .lang file
	pageTextLeft = StatCollector.translateToLocal("cookbookL." + pagename);
	pageTextRight = StatCollector.translateToLocal("cookbookR." + pagename);
	this.items = ExtraFood.crafterPage.getArray(pagename);
	this.irender = new RenderItem();
	pagen = pagename;


	ris = (ArrayList<Object>) this.digestString(StatCollector.translateToLocal("cookbook." + pagename));
	this.pagesAllowed = multiplePG; //CookbookButtonLoader.bookButton.NumOfPages(pagename);
	this.Morethanone = multipg; //(CookbookButtonLoader.bookButton.NumOfPages(pagename) > 1 ? true : false);


}


 public void drawScreen(int par1, int par2, float par3) {


	this.drawDefaultBackground();	
	this.drawBookBackground();
/*	this.drawTextLeftSide();
	this.drawTextRightSide();*/
	this.draw();
    GL11.glDisable(GL11.GL_LIGHTING);
    GL11.glDisable(GL11.GL_DEPTH_TEST);
    GL11.glEnable(GL11.GL_LIGHTING);
    GL11.glEnable(GL11.GL_DEPTH_TEST);
    super.drawScreen(par1, par2, par3);
 }
 
/* protected void drawTextRightSide() {
	 //parts = string.split("-")
     int i = (this.width - CookBookGUI.getAchievementsPaneWidth()) / 2;
     int j = (this.height - CookBookGUI.achievementsPaneHeight) / 2;
     this.fontRendererObj.setUnicodeFlag(true);
	 this.fontRendererObj.drawSplitString(pageTextRight, i + 140, j + 19, 93, 0x0000000);
     this.fontRendererObj.setUnicodeFlag(false);
	 }


 protected void drawTextLeftSide() {
	 //parts = string.split("-")
     int i = (this.width - CookBookGUI.getAchievementsPaneWidth()) / 2;
     int j = (this.height - CookBookGUI.achievementsPaneHeight) / 2;
     this.fontRendererObj.setUnicodeFlag(true);
	 this.fontRendererObj.drawSplitString(pageTextLeft, i + 28, j + 19, 93, 0x0000000);
     this.fontRendererObj.setUnicodeFlag(false);
	 }*/


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
    
 }


public int drawElementTextBlock(ArrayList<Object> args, int x, int y, int flag){
	//System.out.println(args.size());
	 this.fontRendererObj.setUnicodeFlag(true);
	//System.out.println("Magical Calling");
	 int i = (this.width - CookBookGUI.getAchievementsPaneWidth()) / 2;
	    int j = (this.height - CookBookGUI.achievementsPaneHeight) / 2;
   // Check height of block
    int w = 93;
    int h = this.fontRendererObj.splitStringWidth((String) args.get(0), w);
    if (h + y > j + 155){
    	//System.out.println("render" + args.get(0));
    	// do splitting stuff
    	this.fontRendererObj.setUnicodeFlag(true);
    	String p1 = (String) args.get(0);
    	
    	StringBuilder p2 = new StringBuilder();
    	int ii = p1.length() - 2;
    	//EFLog.fatal(p1 + "test + " + p2);
    	while (h + y > j + 155){
    		
    		p2.insert(0, p1.charAt(ii));
    		p1 = p1.substring(0, p1.length() - 1
    				);
    		ii--;
    		h = this.fontRendererObj.splitStringWidth((String) p1, w);
    	}
    		h = this.fontRendererObj.splitStringWidth((String) p1, w);
    		
    		if (flag == 0){
    			this.fontRendererObj.drawSplitString(p1, x, y, 93, 0x0000000);
    			this.fontRendererObj.setUnicodeFlag(false);
    			return h;
    		}
    		else {
    			String p2r = p2.substring(1, p2.length());
    			this.fontRendererObj.drawSplitString(p2r, x, y, 93, 0x0000000);
    			return -h;
    		}
    	}


    	
    			
    
    else {
    	//System.out.println("render" + args.get(0));
    	this.fontRendererObj.drawSplitString((String) args.get(0), x, y, 93, 0x0000000);
    	this.fontRendererObj.setUnicodeFlag(false);
    	return -h;
    }
    
    
    
}
public int drawElementImage(ArrayList<Object> args, int x, int y, int flag){
	int i = (this.width - CookBookGUI.getAchievementsPaneWidth()) / 2;
    int j = (this.height - CookBookGUI.achievementsPaneHeight) / 2;
    //System.out.println(y + 0 + ":" + j);
	if (y + (int)args.get(2) < j  + 155){
		ResourceLocation image = (ResourceLocation) args.get(0);
		int w = (int) args.get(1);
		int h = (int) args.get(2);
		int xx = (int) args.get(3);
		int yy = (int) args.get(4);
		this.mc.renderEngine.bindTexture(image);
		this.drawTexturedModalRect(x, y, xx, yy, w, h);
		return -h;
	}
	else {
		return 1;
	}


}
public int drawElementCrafting(ArrayList<Object> args, int x, int y, int flag){
	int j1 = (this.height - CookBookGUI.achievementsPaneHeight) / 2;
	int i1 = (this.width - CookBookGUI.getAchievementsPaneWidth()) / 2;
	//EFLog.fatal("y : " + y + " j1 : " + j1 + " check : " +(j1 +19));
	if ((y > j1 + 19)){//args.size() > 1
		return 1;
	}
	int x1 = x + 22;
    int y1 = y + 58;
    this.mc.getTextureManager().bindTexture(GuiLib.CBcraftgrid);
    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    GL11.glEnable(GL11.GL_BLEND);
    this.drawTexturedModalRect(x1 - 14, y1 - 51, 0, 0,  CookBookGUI.getAchievementsPaneWidth(), CookBookGUI.achievementsPaneHeight);
    GL11.glDisable(GL11.GL_BLEND);
	ItemStack[] items = ExtraFood.instance.crafterPage.getArray((String) args.get(0).toString());
	for (ItemStack i : ExtraFood.instance.crafterPage.getArray((String) args.get(0).toString())){
		if (i != null){


				/* Items 0-2 Render in top row
				 * Items 3-5 Render in middle row
				 * Items 6-8 Render in final row
				*/




			if (items[0] != null){				
		    GL11.glDisable(GL11.GL_LIGHTING);					
			this.irender.renderItemIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), items[0], x1 - 3, y1 + 1);
			GL11.glEnable(GL11.GL_LIGHTING);			
			}	
			if (items[1] != null){
			    GL11.glDisable(GL11.GL_LIGHTING);	
			this.irender.renderItemIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), items[1], x1 + 18, y1 + 1);
				GL11.glEnable(GL11.GL_LIGHTING);	
			}
			if (items[2] != null){
			    GL11.glDisable(GL11.GL_LIGHTING);	
			this.irender.renderItemIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), items[2], x1 + 40, y1 + 1);
			GL11.glEnable(GL11.GL_LIGHTING);	
			}
			if (items[3] != null){
			    GL11.glDisable(GL11.GL_LIGHTING);	
			this.irender.renderItemIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), items[3], x1 - 3, y1 + 22);
			GL11.glEnable(GL11.GL_LIGHTING);	
			}
			if (items[4] != null){
			    GL11.glDisable(GL11.GL_LIGHTING);	
			this.irender.renderItemIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), items[4], x1 + 18, y1 + 22);
			GL11.glEnable(GL11.GL_LIGHTING);	
			}
			if (items[5] != null){
			    GL11.glDisable(GL11.GL_LIGHTING);	
			this.irender.renderItemIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), items[5], x1 + 40, y1 + 22);
			GL11.glEnable(GL11.GL_LIGHTING);	
			}
			if (items[6] != null){
			    GL11.glDisable(GL11.GL_LIGHTING);	
			this.irender.renderItemIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), items[6], x1 - 3, y1 + 44);
			GL11.glEnable(GL11.GL_LIGHTING);	
			}
			if (items[7] != null){
			    GL11.glDisable(GL11.GL_LIGHTING);	
			this.irender.renderItemIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), items[7], x1 + 18, y1 + 44);
			GL11.glEnable(GL11.GL_LIGHTING);	
			}
			if (items[8] != null){
			    GL11.glDisable(GL11.GL_LIGHTING);	
			this.irender.renderItemIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), items[8], x1 + 40, y1 + 44);
			GL11.glEnable(GL11.GL_LIGHTING);	
			}
			   //Itemstack 9 is the output slot
			if (items[9] != null){
				GL11.glDisable(GL11.GL_LIGHTING);
				this.irender.renderItemIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), items[9], x1 + 19, y1 - 44);
				this.irender.renderItemOverlayIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), items[9], x1 + 19, y1 - 44);
			GL11.glEnable(GL11.GL_LIGHTING);	
			}


			GL11.glEnable(GL11.GL_LIGHTING);
		}




	}
	return -150;
}


public int drawElementHungerStats(ArrayList<Object> args, int x, int y, int flag){
	int i1 = (this.width - CookBookGUI.getAchievementsPaneWidth()) / 2;
    int j1 = (this.height - CookBookGUI.achievementsPaneHeight) / 2;
	if ((y > j1 + 19)){
		return 1;
	}
	else {
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glColor4f(1f, 1f, 1f, 1f);


		this.mc.renderEngine.bindTexture(new ResourceLocation("extrafood:textures/gui/cookbookimages/BookIcons.png"));
		this.drawTexturedModalRect(x + 3, y + 30, 0, 0, 12, 24);
		this.drawTexturedModalRect(x + 3, y + 50, 12, 0, 12, 24);
		GL11.glPopMatrix();
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_BLEND);
		//FontRenderer fontr = this.fontRendererObj;
		fontRendererObj.setUnicodeFlag(true);
		fontRendererObj.drawStringWithShadow("Hunger Stats:", x + 19, y, 0x3333FF);
		fontRendererObj.setUnicodeFlag(false);
		if (args.size() > 2){
			if(args.get(2).toString().length() > 5){
				if(args.get(2).toString().length() > 12){
				fontRendererObj.drawString((String) args.get(2), x + (fontRendererObj.getStringWidth((String) args.get(2)) / 5 -4), y + 15, 0x0000000);
				} else {
				fontRendererObj.drawString((String) args.get(2), x + (fontRendererObj.getStringWidth((String) args.get(2)) / 5), y + 15, 0x0000000);
				}
			} else {
				fontRendererObj.drawString((String) args.get(2), x + (fontRendererObj.getStringWidth((String) args.get(2)) / 1), y + 15, 0x0000000);
			}
		}
		fontRendererObj.drawString(String.valueOf(args.get(0)), x + 16 + 50, y + 32, 0x0000000);
		fontRendererObj.drawString(String.valueOf(args.get(1)), x + 16 + 50, y + 52, 0x0000000);
		
		return -150;
	}
}


 public void actionPerformed(GuiButton button){
	if (button.id == 0){
		if(page < pagesAllowed){
			page+= 2;
		//if (StatCollector.translateToLocal("cookbook." + pagen + page) != "cookbook." + pagen + page){
		this.pageTextLeft = StatCollector.translateToLocal(StatCollector.translateToLocal("cookbook." + pagen + page));
		}
		//else {
		//	page--;
		//}
	}
	if (button.id == 1){
		page-= 2;
		if (StatCollector.translateToLocal("cookbook." + pagen + page) != "cookbook." + pagen + page && page > 0){
		this.pageTextLeft = StatCollector.translateToLocal("cookbook." + pagen + page);
		}
		else if (page <= 0){
			this.pageTextLeft = StatCollector.translateToLocal("cookbook." + pagen);
			page = 0;
		}
	}	
	if (button.id == 2){

		this.fontRendererObj.setUnicodeFlag(false);
		this.mc.displayGuiScreen(new CookBookGUI());


	}


	}
 // Begin new render code
 // This will fuse both pages together by parsing strings and rendering stuff!
 // YAY!
 public List<Object> digestString(String in){
	 List<Object> instruct = new ArrayList<Object>();
	 boolean typetest = false;
	 String type = "";


	 int argpos = 0;


	 String currword = "";


	 ArrayList<Object> typeargs = new ArrayList<Object>();
	 for (char star : in.toCharArray()){
		 //System.err.println(star);
		 if (star == '<'){
			 typetest = true;
			 //System.out.println("t" + currword);
			 continue;
		 }
		 if (star == '|' && typetest == true){
			 typetest = false;
			 //System.out.println("t" + currword);
			 if (this.types().contains(currword)){
				 //System.out.println(currword.trim());
				 type = currword;
				 currword = "";
			 }


			 continue;
		 }


		 else if (star == '|' && typetest == false){
			 //System.err.println("argpos (for dumudums): " + argpos);
			 switch (argpos){
			 case 0:
				 typeargs.add(Integer.parseInt(currword));
				 break;


			 case 1:
				 typeargs.add(Integer.parseInt(currword));
				 break;


			 case 2:
				 typeargs.add(Integer.parseInt(currword));
				 break;


			 case 3:


				 if (type.equals( "TextBlock") || type.equals("Crafting")){
					 typeargs.add(currword);
				 }
				 else if (type.equals("Image")){
					 typeargs.add(new ResourceLocation(currword));
				 }
				 else if (type.equals("HungerStats")){
					 typeargs.add(Float.parseFloat(currword));
				 }
				 break;
			 case 4:
				 if (type.equals("Image")){
				 typeargs.add(Integer.parseInt(currword));
				 }
				 else {
					 typeargs.add(Float.parseFloat(currword));
				 }
				 break;


			 case 5:
				 if (type.equals("Image")){
					 typeargs.add(Integer.parseInt(currword));
				 } else if (type.equals("HungerStats")){
					 typeargs.add(currword);
				 }
				 break;
			 case 6:
				 typeargs.add(Integer.parseInt(currword));
				 break;
			 case 7:
				 typeargs.add(Integer.parseInt(currword));
				 break;
			 }
			 currword = "";
			 argpos += 1;
			 continue;
		 }
		 if (star == '>'){


			 switch (argpos){
			 case 0:
				 typeargs.add(Integer.parseInt(currword));
				 break;


			 case 1:
				 typeargs.add(Integer.parseInt(currword));
				 break;


			 case 2:
				 typeargs.add(Integer.parseInt(currword));
				 break;


			 case 3:


				 if (type.equals( "TextBlock") || type.equals("Crafting")){
					 typeargs.add(currword);
				 }
				 else if (type.equals("Image")){
					 typeargs.add(new ResourceLocation(currword));
				 }
				 else if (type.equals("HungerStats")){
					 typeargs.add(Float.parseFloat(currword));
				 }
				 break;
			 case 4:
				 if (type.equals("Image")){
				 typeargs.add(Integer.parseInt(currword));
				 }
				 else {
					 typeargs.add(Float.parseFloat(currword));
				 }
				 break;


			 case 5:
				 if (type.equals("Image")){
					 typeargs.add(Integer.parseInt(currword));
				 } else if (type.equals("HungerStats")){
					 typeargs.add(currword);
				 }
				 break;
			 case 6:
				 typeargs.add(Integer.parseInt(currword));
				 break;
			 case 7:
				 typeargs.add(Integer.parseInt(currword));
				 break;


			 }
			 currword = "";
			 argpos = 0;
			 instruct.add(type);
			 instruct.add(typeargs);
			 typeargs = new ArrayList<Object>();
			 continue;
		 }
			 currword += star;
			 //System.out.println(currword);
			 continue;




	 }
	 for (Object o : instruct){
		 //System.out.println(o);
	 }
	 return instruct;
 }
 public List<String> types(){
	 ArrayList<String> types = new ArrayList<String>();
	 // Put all valid thingies here
	 types.add("TextBlock");
	 types.add("Image");
	 types.add("Crafting");
	 types.add("HungerStats");
	 return types;
 }
 public Map<String, Integer> acount(){
	 HashMap<String, Integer> types = new HashMap<String, Integer>();
	 // Put all valid thingies here
	 types.put("TextBlock", 4);
	 types.put("Image", 8);
	 types.put("Crafting", 4);
	 types.put("HungerStats", 7);
	 return types;
 }
 
 public Method getFunctionForType(String type){
	 String mname = "drawElement" + type;
	 try {
		if (this.getClass().getMethod(mname, ArrayList.class, int.class, int.class, int.class) != null){
			 return this.getClass().getMethod(mname, ArrayList.class, int.class, int.class, int.class);
		 }
	} catch (NoSuchMethodException | SecurityException e) {
		//e.printStackTrace();
	}
	return null;
 }
 // The longest function we've made (Actually by me) Edition 3!
 public void drawold(){
	 int i = (this.width - CookBookGUI.getAchievementsPaneWidth()) / 2;
     int j = (this.height - CookBookGUI.achievementsPaneHeight) / 2;
     //EFLog.fatal("fatality = " + j);
     // Attempt 2 :(
     // Define "cursor" position
     int renderpage = page;
     int xpos = i + 28;
     int ypos = j + 19;
     // Define current page we are rendering
     
     
     // Create pairs for everythin' (oh, and define the list of pairs)
     ArrayList<ArrayList<Object>> pairs = new ArrayList<ArrayList<Object>>();
     ArrayList<ArrayList<Object>> page1 = new ArrayList<ArrayList<Object>>();
     if (this.page > p3){page1.addAll(p3r);p3r.clear();}
     ArrayList<ArrayList<Object>> page2 = new ArrayList<ArrayList<Object>>();
     
     // Start pairin' them up!
     
     // Temp pair array
     ArrayList<Object> pair = new ArrayList<Object>();
     for (Object pairbuddy : ris){
    	 if (pair.size() == 0){
    		 pair.add(pairbuddy);
    	 }
    	 else {
    		 pair.add(pairbuddy);
    		 pairs.add(pair);
    		 pair = new ArrayList<Object>();
    	 }
     }
  // Attempt to figure out what is NOT going to be rendered, and remove it from the list
     for (ArrayList<Object> pa : pairs){
    	 ArrayList<Object> pat = (ArrayList<Object>) ((ArrayList<Object>) pa.get(1)).clone();
    	 if (pat instanceof ArrayList){
    		 int page = (int) pat.get(2);
    		 if (page < this.page * 2){
    			 pairs.remove(pa);
    			 continue;
    		 }
    		 else if (page > (this.page + 1) * 2){
    			 pairs.remove(pa);
    			 continue; 
    		 }
    		 switch (page - (this.page * 2)){
    		 case 0:
    			 page1.add(pa);
    			 break;
    		 case 1:
    			 page2.add(pa);
    			 break;
    		 }
    	 }
     }
     for (ArrayList<Object> ptt : page1){
    	 ArrayList<Object> args = (ArrayList<Object>) ptt.get(1);
    	 int rval;
    	 String type = (String) ptt.get(0);
    	 try {
			rval = (int) this.getFunctionForType(type).invoke(this, args, xpos, ypos, (ptt.size() > 2 ? 1 : 0));
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			rval = 0;
		}
    	 if (rval < 0){
    		 ypos += -rval;
    	 }
    	 else {
    		 ypos += rval;
    		 ArrayList<Object> ptata = (ArrayList<Object>) ptt.clone();
    		 ptata.add("f");
    		 page2.add(ptata);
    	 }
    	 if (ypos > j + 150){
    		 break;
    	 }
    	 
    	 
    	 
    	 
     }
     for (ArrayList<Object> ptta : page2){
    	 ArrayList<Object> args = (ArrayList<Object>) ptta.get(1);
    	 int rval;
    	 String type = (String) ptta.get(0);
    	 try {
			rval = (int) this.getFunctionForType(type).invoke(this, args, xpos, ypos, (ptta.size() > 2 ? 1 : 0));
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			rval = 0;
		}
    	 if (rval < 0){
    		 ypos += -rval;
    	 }
    	 else {
    		 ypos += rval;
    		 p3 = this.page;
    		 p3r.add(ptta);
    	 }
    	 if (ypos > j + 150){
    		 break;
    	 }
     }
     
     
     
 }
 public void draw(){
	 int i = (this.width - CookBookGUI.getAchievementsPaneWidth()) / 2;
     int j = (this.height - CookBookGUI.achievementsPaneHeight) / 2;
     //EFLog.fatal("fatality = " + j);
     // Attempt 2 :(
     // Define "cursor" position
     int renderpage = page;
     int xpos = (renderpage % 2 == 0 ? i + 28 : i + 140);
     int ypos = j + 19;
     // Define current page we are rendering
     
     // Define function to be called
     Method drawFunc;
     // Define list of functions I need to call on next page
     ArrayList<Method> call = new ArrayList<Method>();
     // Arguments for those methods
     ArrayList<ArrayList<Object>> callargs = new ArrayList<ArrayList<Object>>();
     // Create pairs for everythin' (oh, and define the list of pairs)
     ArrayList<ArrayList<Object>> pairs = new ArrayList<ArrayList<Object>>();
     
     // Start pairin' them up!
     
     // Temp pair array
     ArrayList<Object> pair = new ArrayList<Object>();
     for (Object pairbuddy : ris){
    	 if (pair.size() == 0){
    		 pair.add(pairbuddy);
    	 }
    	 else {
    		 pair.add(pairbuddy);
    		 pairs.add(pair);
    		 pair = new ArrayList<Object>();
    	 }
     }
     
     // Ok, now iterate over all of the pairs and render them based on stuff!
     for (ArrayList<Object> pair1 : pairs){
    	 // Get type
    	 //System.err.println("at pair thingie" + pair1);
    	 //EFLog.info("Here");
    	 String typename = (String) pair1.get(0);
    	 // Extract arguments
    	 ArrayList<Object> args = new ArrayList<Object>();
    	 args.addAll(((ArrayList<Object>) pair1.get(1)));
    	 drawFunc = this.getFunctionForType(typename);
    	 // Process the xpos and ypos, we might need to calculate them!
    	 if (!(((int)args.get(2) < ((this.page + 1) * 2)))){
    		 //System.out.println("breakin free!");
    		 continue;
    	 }
    	 
    	 int x = (int) args.get(0);
    	 
    	 
    	 int y = (int) args.get(1);
    	 int bx = x;
    	 int by = y;
    	 if (x == -1){
    		 x = (renderpage % 2 == 0 ? i + 28 : i + 140);
    		 
    	 }
    	 else {
    		 x = xpos + x;
    	 }
    	 if (y == -1){
    		 y = ypos;
    	 }
    	 else {
    		 y = ypos + y;
    	 }
    	 // Remove the from the list of arguents (so I can pass them directly to the function)
    	 args.remove(0);
    	 args.remove(0);
    	 //EFLog.error("Here: xpos = " + x + "ypos = " + y);
    	 // Process pages
    	 if (((int)args.get(0) < renderpage || (int)args.get(0) > renderpage + 1)){
//    		 ArrayList<Object> ttargs = new ArrayList<Object>();
//    		 ttargs.add(bx);
//    		 ttargs.add(by);
//    		 ttargs.add(renderpage);
//    		 ttargs.add(args);
//    		 call.add(drawFunc);
//    		 callargs.add(ttargs);
    		 
    		 continue;
    		 
    	 }
    	 if ((int)args.get(0) != renderpage && (int)args.get(0) < this.page + 2){
    		 // Process page change
    		 renderpage++;
    		 xpos = (renderpage % 2 == 0 ? i + 28 : i + 140);
    		 //FMLLog.info("This is extrafood speaking, not fml. Anyways the data i eany is: " + xpos, xpos);
    	     ypos = j + 19;
    	     int i1 = 0;
    	     for (Method tocall : call){
    	    	 
    	    	 int tx;
    	    	 int ty;
    	    	 @SuppressWarnings("unused")
				int pg;
    	    	 int rval;
    	    	 ArrayList<Object> unpack = callargs.get(i1);
    	    	 tx = (int) unpack.get(0);
    	    	 ty = (int) unpack.get(1);
    	    	 pg = (int) unpack.get(2);
    	    	 
    	    	 
    	    	 tx = xpos + tx;
    	    	 ty = ypos + ty;
    	    	 ArrayList<Object> targs = (ArrayList<Object>) unpack.get(3);
    	    	 //System.out.println("targ" + targs);
    	    	 try {
					rval = (int) tocall.invoke(this, targs, tx, ty, 1);
				} catch (IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					rval = 0;
					
				}
    	    	 ypos += -rval;
    	    	 y += -rval;
    	    	 i1 += 1;
    	    	 
    	     }
    	     if (bx == -1){
        		 x = (renderpage % 2 == 0 ? i + 28 : i + 140);
        	 }
        	 else {
        		 x = xpos + x;
        	 }
        	 if (by == -1){
        		 y = ypos;
        	 }
        	 else {
        		 y = ypos + y;
        	 }
    		 
    	 }
    	 
    	 if (((int)args.get(0) < renderpage || (int)args.get(0) > renderpage + 1)){
//    		 ArrayList<Object> ttargs = new ArrayList<Object>();
//    		 ttargs.add(bx);
//    		 ttargs.add(by);
//    		 ttargs.add(renderpage);
//    		 ttargs.add(args);
//    		 call.add(drawFunc);
//    		 callargs.add(ttargs);
    		 
    		 continue;
    		 
    	 }
    	 args.remove(0);
    	 int rval;
    	 try {
    		//System.err.println("drawfunc is preparing to invoke STAND BY!!!");
			rval = (int) drawFunc.invoke(this, args, x, y, 0);
			//System.err.println("drawfunc has invoked sucessfully STAND BY!!!");
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			rval = 0;
		}
    	 if (rval > 0){
    		 ypos += rval;
    		 ArrayList<Object> ttargs = new ArrayList<Object>();
    		 ttargs.add(bx);
    		 ttargs.add(by);
    		 ttargs.add(renderpage);
    		 ttargs.add(args);
    		 call.add(drawFunc);
    		 callargs.add(ttargs);
    		 
    	 }
    	 else {
    		 ypos -= rval;
    	 }
    	 if (ypos > j + 155){
    		 ypos = j + 19;
    		 renderpage++;
    		 xpos = (renderpage % 2 == 0 ? i + 28 : i + 140);
    		 //FMLLog.info("This is extrafood speaking, not fml. Anyways the data i eany is: " + xpos, xpos);
    	     ypos = j + 19;
    	     int i1 = 0;
    	     for (Method tocall : call){
    	    	 
    	    	 int tx;
    	    	 int ty;
    	    	 @SuppressWarnings("unused")
				int pg;

    	    	 ArrayList<Object> unpack = callargs.get(i1);
    	    	 tx = (int) unpack.get(0);
    	    	 ty = (int) unpack.get(1);
    	    	 pg = (int) unpack.get(2);
    	    	 tx = xpos + tx;
    	    	 ty = ypos + ty;
    	    	 ArrayList<Object> targs = (ArrayList<Object>) unpack.get(3);
    	    	 //System.out.println("targ" + targs);
    	    	 try {
					rval = (int) tocall.invoke(this, targs, tx, ty, 1);
				} catch (IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					rval = 0;
					
				}
    	    	 ypos += -rval;
    	    	 y += -rval;
    	    	 i1 += 1;
    	    	 
    	     }
    	     if (bx == -1){
        		 x = (renderpage % 2 == 0 ? i + 28 : i + 140);
        	 }
        	 else {
        		 x = xpos + x;
        	 }
        	 if (by == -1){
        		 y = ypos;
        	 }
        	 else {
        		 y = ypos + y;
        	 }
    		 
    	 }
    	
    	 }
    	 
     
     renderpage++;
	 xpos = (renderpage % 2 == 0 ? i + 28 : i + 140);
     ypos = j + 19;
     int i1 = 0;
     if (renderpage - 1 % 2 == 0){
     for (Method tocall : call){
    	 int tx;
    	 int ty;
    	 @SuppressWarnings("unused")
		 int pg;
    	 int rval;
    	 	ArrayList<Object> unpack = callargs.get(i1);
    	 	tx = (int) unpack.get(0);
    	 	ty = (int) unpack.get(1);
    	 	pg = (int) unpack.get(2);
    	 	tx = xpos + tx;
    	 	ty = ypos + ty;
    	 	ArrayList<Object> targs = (ArrayList<Object>) unpack.get(3);
    	 	//System.out.println("targ" + targs);
    	 	try {
    	 		rval = (int) tocall.invoke(this, targs, tx, ty, 1);
    	 	} catch (IllegalAccessException | IllegalArgumentException| InvocationTargetException e) {
			//e.printStackTrace();
			rval = 0;
    	 	}
    	 ypos += -rval;
    	 i1 += 1;
     	}
    }
  }
     
 public int moreThanOne(){
	 ArrayList<ArrayList<Object>> pairs = new ArrayList<ArrayList<Object>>();
     
     // Start pairin' them up!
     int tp = 0;
     // Temp pair array
     ArrayList<Object> pair = new ArrayList<Object>();
     for (Object pairbuddy : ris){
    	 if (pair.size() == 0){
    		 pair.add(pairbuddy);
    	 }
    	 else {
    		 pair.add(pairbuddy);
    		 pairs.add(pair);
    		 pair = new ArrayList<Object>();
    	 }
     }
     for (ArrayList<Object> apair : pairs){
    	 int page = (int) ((ArrayList<Object>)apair.get(1)).get(2);
    	 if (page > tp){
    		 tp = page;
    	 }
     }
     return tp;
 }
 
 @Override
 protected void keyTyped(char p_73869_1_, int p_73869_2_)
 {
     if (p_73869_2_ == 1)
     {
         this.fontRendererObj.setUnicodeFlag(false);
         this.mc.displayGuiScreen((GuiScreen)null);
         this.mc.setIngameFocus();
     }
 }
 @Override
 public boolean doesGuiPauseGame()
 {
     return false;
 }

  
}