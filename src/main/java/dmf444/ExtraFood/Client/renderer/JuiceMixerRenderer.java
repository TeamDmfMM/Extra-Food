package dmf444.ExtraFood.Client.renderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.model.IFlexibleBakedModel;
import org.lwjgl.opengl.GL11;

public class JuiceMixerRenderer extends TileEntitySpecialRenderer {
	 

	
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

        IFlexibleBakedModel model = OBJRender.loadModel("block/juiceMixer2.obj");
            Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.locationBlocksTexture);
            GlStateManager.pushMatrix();
            GlStateManager.translate(0f, 0.5f, 0f);
            GlStateManager.scale(00.01F, 00.01F, 00.01F);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            //GlStateManager.enableBlend();
            GlStateManager.enableLighting();
            OBJRender.renderModel(model, -1);
            //GlStateManager.disableBlend();
         GlStateManager.disableLighting();
            GlStateManager.popMatrix();
        GL11.glPopMatrix();
}

}
