package dmf444.ExtraFood.Common.blocks.guis;


import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;


import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;


import net.minecraft.util.StatCollector;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;




import dmf444.ExtraFood.Common.RecipeHandler.JuiceRegistry;
import dmf444.ExtraFood.Common.blocks.container.ContainerJuiceBlender;
import dmf444.ExtraFood.Common.blocks.tileentity.TileEntityJuiceBlender;
import dmf444.ExtraFood.Core.lib.GuiLib;
import dmf444.ExtraFood.util.EFLog;


public class GuiJuiceBlender extends GuiContainer {

	private TileEntityJuiceBlender te;


	private int mousex;
	private int mousey;


	public GuiJuiceBlender(InventoryPlayer player, TileEntityJuiceBlender tilentity) {
		super(new ContainerJuiceBlender(player, tilentity));
		te = tilentity;


		// TODO Auto-generated constructor stub
	}




	public void drawFluid(){
		// Bind textures from liquid.
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		//System.out.println("drawing rebbryrbtwckut");
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_BLEND);
		this.mc.renderEngine.bindTexture(new ResourceLocation(JuiceRegistry.instance.getTextureFromJuice(te.tank.getFluid().getFluid())));
		this.drawTexturedModalRect(x + 147, (int)(y + 11 + (62 - (te.tank.getFluidAmount() * 0.012))), 0, 0, 16, (int)(te.tank.getFluidAmount() * 0.012));
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


		// TODO Auto-generated method stub


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
protected void mouseMovedOrUp(int par1, int par2, int par3){
	super.mouseMovedOrUp(par1, par2, par3);
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
	super.handleMouseInput();
}
}
