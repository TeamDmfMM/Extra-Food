package com.dmfmm.extrafood.client.gui;

import com.dmfmm.extrafood.container.OvenContainer;
import com.dmfmm.extrafood.crafting.Oven.OvenRegistry;
import com.dmfmm.extrafood.crafting.Oven.OvenRegistryRecipe;
import com.dmfmm.extrafood.library.GuiLib;
import com.dmfmm.extrafood.tileentities.OvenTileEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;

import org.lwjgl.opengl.GL11;


public class OvenGUI extends GuiContainer {

    OvenTileEntity tileEntity;
    private OvenRegistryRecipe recipet;
    RenderItem renders;
    ItemStack[] bob = new ItemStack[5];
    public ItemStack output2;

    public OvenGUI(InventoryPlayer player, OvenTileEntity te) {
        super(new OvenContainer(player, te));
        tileEntity = te;
        this.renders = Minecraft.getMinecraft().getRenderItem();


        //bob[4] = null;
        // TODO Auto-generated constructor stub
    }
    @Override
    protected void drawGuiContainerForegroundLayer(int param1, int param2) {
        //draw text and stuff here
        //the parameters for drawString are: string, x, y, color
        fontRendererObj.drawString(I18n.translateToLocal("gui.OV"), 7, 5, 4210752);
        //draws "Inventory" or your regional equivalent
        fontRendererObj.drawString(I18n.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
        this.drawCookItem();
        this.drawProgressBar();
        this.drawInGlass();
    }
    @Override
    protected void drawGuiContainerBackgroundLayer(float f1, int f2, int f3) {

        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.renderEngine.bindTexture(GuiLib.OVEN_GUI);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);

        // TODO Auto-generated method stub

    }

    private void drawProgressBar(){
        //EFLog.fatal(tileEntity.getTime());
        if(tileEntity.getTime() != 0){
            double i = 22 / (tileEntity.getTimeTicks() + 0.0);
            double l = i * tileEntity.getTime();
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glEnable(GL11.GL_BLEND);
            this.mc.renderEngine.bindTexture(GuiLib.OVEN_GUI);
            this.drawTexturedModalRect(76, 42, 202, 0, 26, (int) l); //22
            GL11.glDisable(GL11.GL_BLEND);
        }
    }

    private void drawCookItem(){
        //EFLog.error(bob);
        bob[0] = tileEntity.items[0];
        bob[1] = tileEntity.items[1];
        bob[2] = tileEntity.items[2];
        bob[3] = tileEntity.items[3];
        bob[4] = tileEntity.items[4];
        if(bob != null && bob[0] != null){
            OvenRegistryRecipe output = OvenRegistry.instance.getRecipe(bob);
            try{
                //EFLog.error("ATTEMPT TO PARSE IMAGE");
                ItemStack output2 = output.getRecipeOutput(OvenRegistry.instance.getArrayList(bob));
                if(output2 != null){
                    //EFLog.error("IMAGE MADE");
                    this.renders.renderItemOverlayIntoGUI(this.fontRendererObj, new ItemStack(output2.getItem()), 80, 43, null);
                    this.renders.renderItemIntoGUI(new ItemStack(output2.getItem()), 80, 43);
                }
            } catch(NullPointerException e){}
        }
    }

    private void drawInGlass(){
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glEnable(GL11.GL_BLEND);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        this.mc.renderEngine.bindTexture(GuiLib.OVEN_GUI);
        this.drawTexturedModalRect(76, 42, 176, 0, 26, 22);
        GL11.glDisable(GL11.GL_BLEND);
    }
}