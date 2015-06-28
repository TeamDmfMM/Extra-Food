package dmf444.ExtraFood.Common.blocks.guis;


import dmf444.ExtraFood.Core.lib.GuiLib;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;


public class ClickTab extends GuiButton{


public Item item;
public RenderItem rinder = Minecraft.getMinecraft().getRenderItem();

public int x;
public int y;

public String pagename;
public String[] pre;
public int type = 0;

	public ClickTab(int par1, int par2, int par3, int par4, int par5, String par6Str, int par7, int par8, Item is, String name, int t, String... pre) {
		super(par1, par2, par3, par4, par5, par6Str);
		x = par7;
		y = par8;
		item = is;
		this.pagename = name;
		this.pre = pre;
		this.type = t;

	}

	public ClickTab(int par1, int par2, int par3, int par4, int par5, String par6Str, int par7, int par8, Item is, String name, String... pre){
	super(par1, par2, par3, par4, par5, par6Str);
	x = par7;
	y = par8;
	item = is;
	this.pagename = name;
	this.pre = pre;
	}
	
	public ClickTab(int xPOS, int yPOS, Item itemStack, String page_name, String... pres){
		super(0, 0, 0, 22, 22, "");
		x = xPOS;
		y = yPOS;
		item = itemStack;
		this.pagename = page_name;
		this.pre = pres;
	}
	public ClickTab(int xPOS, int yPOS, ItemStack itemStack, String page_name, String... pres){
		super(0, 0, 0, 22, 22, "");
		x = xPOS;
		y = yPOS;
		item = itemStack.getItem();
		this.pagename = page_name;
		this.pre = pres;
	}

	
	public ClickTab(int par1, int par2, int par3, int par4, int par5, String par6Str, int par7, int par8, ItemStack is, String name, String... pre){
	super(par1, par2, par3, par4, par5, par6Str);
	x = par7;
	y = par8;
	item = is.getItem();
	this.pagename = name;
	this.pre = pre;

}
	public ClickTab(int par1, int par2, int par3, int par4, int par5, String par6Str, int par7, int par8, ItemStack is, String name, int t, String... pre) {
		super(par1, par2, par3, par4, par5, par6Str);
		x = par7;
		y = par8;
		item = is.getItem();
		this.pagename = name;
		this.pre = pre;
		this.type = t;

	}


	public void drawButton(Minecraft m, int p1, int p2){
			GL11.glPushMatrix();
			m.getTextureManager().bindTexture(GuiLib.CBborder);
			GL11.glDisable(GL11.GL_LIGHTING);
			GL11.glEnable(GL11.GL_BLEND);
			this.drawTexturedModalRect(xPosition, yPosition, 2, 204, 22, 22);
			//if (rloc == null){
				this.rinder.renderItemIntoGUI(new ItemStack(this.item), xPosition + 3, yPosition + 2);
			//	}else{
			//		this.rinder.renderIcon(xPosition + 3, yPosition + 2, rloc, 16, 16);
					
			//	}

			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glPopMatrix();
	}


}
