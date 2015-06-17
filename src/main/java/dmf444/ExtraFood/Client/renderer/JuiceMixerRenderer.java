package dmf444.ExtraFood.Client.renderer;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

/*
import org.lwjgl.opengl.GL11;

import dmf444.ExtraFood.Core.lib.GuiLib;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class JuiceMixerRenderer extends TileEntitySpecialRenderer {
	 
	private final JuiceMixerModel JMmodel = new JuiceMixerModel();
	
	public JuiceMixerRenderer(){
	}
	
	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
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
        Minecraft.getMinecraft().renderEngine.bindTexture(textures);
               
        GL11.glPushMatrix();
        GL11.glScalef(0.5F, 0.5F, 0.5F);
//A reference to your Model file. Again, very important.
        this.JMmodel.render();
//Tell it to stop rendering for both the PushMatrix's
        GL11.glPopMatrix();
        GL11.glPopMatrix();
}

}
*/