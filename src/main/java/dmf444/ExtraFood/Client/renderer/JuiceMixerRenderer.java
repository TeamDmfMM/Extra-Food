package dmf444.ExtraFood.Client.renderer;

import dmf444.ExtraFood.Core.lib.GuiLib;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;


import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.obj.OBJModel;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;

public class JuiceMixerRenderer extends TileEntitySpecialRenderer {
	 
	private final JuiceMixerModel JMmodel = new JuiceMixerModel();
	
	public JuiceMixerRenderer(){
	}
	
	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale, int hitx) {
		   //The PushMatrix tells the renderer to "start" doing something.
        GL11.glPushMatrix();
//This is setting the initial location.
        GL11.glTranslatef((float) x + 0.5F, (float) y , (float) z + 0.5F);
        int i = te.getBlockMetadata();
		
		short short1 = 0;
		
		if (i == 2)
        {
            short1 = 360;
        }

        if (i == 3)
        {
            short1 = 180;
        }

        if (i == 4)
        {
            short1 = 90; //-90
        }

        if (i == 5)
        {
            short1 = -90; //90
        }
        GL11.glRotatef((float)short1, 0.0F, 1.0F, 0.0F);

//Use in 1.6.2  this
       ResourceLocation textures = (GuiLib.TextureJM);
//the ':' is very important
//binding the textures
            Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.locationBlocksTexture);
            GlStateManager.pushMatrix();
            GlStateManager.scale(0.5F, 0.5F, 0.5F);
            //GlStateManager.enableBlend();
            GlStateManager.disableLighting();
            JMmodel.renderModel();
            //GlStateManager.disableBlend();
            GlStateManager.enableLighting();
            GlStateManager.popMatrix();
        GL11.glPopMatrix();
}

}
