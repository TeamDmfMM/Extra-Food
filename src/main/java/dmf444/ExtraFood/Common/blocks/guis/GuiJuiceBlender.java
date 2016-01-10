package dmf444.ExtraFood.Common.blocks.guis;


import dmf444.ExtraFood.Common.RecipeHandler.JuiceRegistry;
import dmf444.ExtraFood.Common.blocks.container.ContainerJuiceBlender;
import dmf444.ExtraFood.Common.blocks.tileentity.TileEntityJuiceBlender;
import dmf444.ExtraFood.Core.lib.GuiLib;
import dmf444.ExtraFood.Core.util.EFLog;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fluids.Fluid;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class GuiJuiceBlender extends GuiContainer {

	private TileEntityJuiceBlender te;


	private int mousex;
	private int mousey;


	public GuiJuiceBlender(InventoryPlayer player, TileEntityJuiceBlender tilentity) {
		super(new ContainerJuiceBlender(player, tilentity));
		te = tilentity;


	}




	public void drawFluid(){
		// Bind textures from liquid.
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		//System.out.println("drawing rebbryrbtwckut");
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_BLEND);
		this.mc.renderEngine.bindTexture(TextureMap.locationBlocksTexture);
		this.drawTexturedModalRect(x + 147, (int) (y + 11 + (62 - (te.tank.getFluidAmount() * 0.012))), this.getFluidTexture(te.tank.getFluid().getFluid(), false), 16, (int) (te.tank.getFluidAmount() * 0.012));
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_BLEND);
	}
    @Override
    protected void drawGuiContainerForegroundLayer(int param1, int param2) {
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
            //draw text and stuff here
            //the parameters for drawString are: string, x, y, color
            fontRendererObj.drawString(StatCollector.translateToLocal("gui.JB"), 8, 6, 4210752);
            //draws "Inventory" or your regional equivalent
            fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
    }

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {

		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.renderEngine.bindTexture(GuiLib.JBgui);
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
		if (this.te.complete > 0){
			int bar = (int) (1.85 * te.complete);
			if (this.te.items[0] != null){
				float[] color = JuiceRegistry.instance.getColor(this.te.items[0]);
				float r = color[0];
				float g = color[1];
				float b = color[2];
				float a = 1.0f;
				GL11.glColor4f(r, g, b, a);
				this.drawTexturedModalRect(x + 103, y + 64, 176, 0, bar, 4);
				GL11.glColor4f(1f, 1f, 1f, 1f);
			}

		}
		if (te.tank.getFluid() != null){
			this.drawFluid();


		}
		GL11.glDisable(GL11.GL_LIGHTING);
		this.mc.renderEngine.bindTexture(GuiLib.JBgui);
		this.drawTexturedModalRect(x + 147, y + 18, 217, 0, 16, 49);
		GL11.glEnable(GL11.GL_LIGHTING);
		
		if (this.shouldShowToolTip()){
			List<String> list = new ArrayList<String>();
			list.add("Fluid: " + this.te.tank.getFluid().getFluid().getLocalizedName(this.te.tank.getFluid()));
			list.add("Amount: " + te.tank.getFluidAmount() + "mB");
			this.drawHoveringText(list, x + this.mousex, y + this.mousey, fontRendererObj);
		}



	}
	private boolean shouldShowToolTip(){
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		//System.out.println("X: " + this.mousex + " X:X: " + x + 146 + " Y: " + this.mousey + " Y:Y: " + y + 11);
		Rectangle rect = new Rectangle(146, 11, 16, 61);
	
	
		if (rect.contains(this.mousex, this.mousey) && te.tank.getFluid() != null){
			return true;
		}
		return false;
	}


	public void updateScreen(){
	
	
	}
	protected void mouseReleased(int par1, int par2, int par3){
		super.mouseReleased(par1, par2, par3);
		if (par3 == 0){
			this.mousex = par1;
			this.mousey = par2;
		}
	}
	public void handleMouseInput(){
		int x = Mouse.getEventX() * width / mc.displayWidth;
		int y = height - (Mouse.getEventY() * height) / mc.displayHeight - 1;
		this.mousex = x - guiLeft;
		this.mousey = y - guiTop;
        try {
            super.handleMouseInput();
        } catch (IOException e) {}
    }
	
	//Taken from BuildCraft... If you own it, ask and I'll remove it
	public static TextureAtlasSprite getFluidTexture(Fluid fluid, boolean flowing) {
		if (fluid == null) {
			return null;
		}
		TextureAtlasSprite icon = flowing ? Minecraft.getMinecraft().getTextureMapBlocks().getTextureExtry(fluid.getFlowing().toString()) : Minecraft.getMinecraft().getTextureMapBlocks().getTextureExtry(fluid.getStill().toString());
		if (icon == null) {
			icon = ((TextureMap) Minecraft.getMinecraft().getTextureManager().getTexture(TextureMap.locationBlocksTexture)).getAtlasSprite("missingno");
		}
		return icon;
	}

    public void drawHoveringText(List textLines, int x, int y, FontRenderer font)
    {
        if (!textLines.isEmpty())
        {
			//EFLog.fatal((int)((Character)('耺')).charValue());
            GL11.glDisable(32826);
            RenderHelper.disableStandardItemLighting();
            GL11.glDisable(2896);
            GL11.glDisable(2929);
            int k = 0;
            Iterator iterator = textLines.iterator();

            while (iterator.hasNext())
            {
                String s = (String)iterator.next();
                int l = font.getStringWidth(s);

                if (l > k)
                {
                    k = l;
                }
            }

            int j2 = x + 12;
            int k2 = y - 12;
            int i1 = 8;

            if (textLines.size() > 1)
            {
                i1 += 2 + (textLines.size() - 1) * 10;
            }

            if (j2 + k > this.width)
            {
                j2 -= 28 + k;
            }

            if (k2 + i1 + 6 > this.height)
            {
                k2 = this.height - i1 - 6;
            }

            this.zLevel = 300.0F;
            this.itemRender.zLevel = 300.0F;
            int j1 = -267386864;
            this.drawGradientRect(j2 - 3, k2 - 4, j2 + k + 3, k2 - 3, j1, j1);
            this.drawGradientRect(j2 - 3, k2 + i1 + 3, j2 + k + 3, k2 + i1 + 4, j1, j1);
            this.drawGradientRect(j2 - 3, k2 - 3, j2 + k + 3, k2 + i1 + 3, j1, j1);
            this.drawGradientRect(j2 - 4, k2 - 3, j2 - 3, k2 + i1 + 3, j1, j1);
            this.drawGradientRect(j2 + k + 3, k2 - 3, j2 + k + 4, k2 + i1 + 3, j1, j1);
            int k1 = 1347420415;
            int l1 = (k1 & 16711422) >> 1 | k1 & -16777216;
            this.drawGradientRect(j2 - 3, k2 - 3 + 1, j2 - 3 + 1, k2 + i1 + 3 - 1, k1, l1);
            this.drawGradientRect(j2 + k + 2, k2 - 3 + 1, j2 + k + 3, k2 + i1 + 3 - 1, k1, l1);
            this.drawGradientRect(j2 - 3, k2 - 3, j2 + k + 3, k2 - 3 + 1, k1, k1);
            this.drawGradientRect(j2 - 3, k2 + i1 + 2, j2 + k + 3, k2 + i1 + 3, l1, l1);

            for (int i2 = 0; i2 < textLines.size(); ++i2)
            {
                String s1 = (String)textLines.get(i2);
                font.drawStringWithShadow(s1, j2, k2, -1);

                if (i2 == 0)
                {
                    k2 += 2;
                }

                k2 += 10;
            }

            this.zLevel = 0.0F;
            this.itemRender.zLevel = 0.0F;
            GL11.glEnable(2896);
            GL11.glEnable(2929);
            RenderHelper.enableStandardItemLighting();
            GL11.glEnable(32826);
        }
    }

}
