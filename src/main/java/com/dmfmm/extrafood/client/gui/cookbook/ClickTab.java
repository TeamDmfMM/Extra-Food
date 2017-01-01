package com.dmfmm.extrafood.client.gui.cookbook;


import com.dmfmm.extrafood.library.GuiLib;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;


public class ClickTab extends GuiButton{


    public Item item;
    public ItemStack stack;
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
        this.stack = itemStack;
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

        //Box Background
        GL11.glPushMatrix();
        m.getTextureManager().bindTexture(GuiLib.COOKBOOK_BORDER);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_BLEND);
        this.drawTexturedModalRect(xPosition, yPosition, 2, 204, 22, 22);
        GL11.glPopMatrix();

        GL11.glPushMatrix();
        //GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        RenderHelper.enableStandardItemLighting();
        RenderHelper.enableGUIStandardItemLighting();
        if (stack == null){
            this.rinder.renderItemIntoGUI(new ItemStack(this.item), xPosition + 3, yPosition + 2);
        }else{
            this.rinder.renderItemIntoGUI(stack, xPosition + 3, yPosition + 2);
        }

        GL11.glPopMatrix();
    }


}