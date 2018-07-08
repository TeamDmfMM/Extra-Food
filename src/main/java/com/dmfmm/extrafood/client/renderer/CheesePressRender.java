package com.dmfmm.extrafood.client.renderer;

import com.dmfmm.extrafood.client.models.CheesePressModel;
import com.dmfmm.extrafood.tileentities.CheesePressTileEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class CheesePressRender extends TileEntitySpecialRenderer {

    //The model of your block
    private static final CheesePressModel model = new CheesePressModel();

    public CheesePressRender() {
    }



    @Override
    public void render(TileEntity te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        CheesePressTileEntity cheesePressTileEntity = (CheesePressTileEntity) te;
        //The PushMatrix tells the renderer to "start" doing something.
        GL11.glPushMatrix();
        //This is setting the initial location.
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        int i = te.getBlockMetadata();

        short short1 = 0;

        if (i == 2)
        {
            short1 = 90;
        }

        if (i == 3)
        {
            short1 = -90;
        }

        if (i == 4)
        {
            short1 = 180; //-90
        }

        if (i == 5)
        {
            short1 = 360; //90
        }
        GL11.glRotatef((float)short1, 0.0F, 1.0F, 0.0F);
        //Use in 1.6.2  this
        ResourceLocation textures = (new ResourceLocation("extrafood:textures/blocks/blockcheesepress.png"));
        //the ':' is very important
        //binding the textures
        Minecraft.getMinecraft().renderEngine.bindTexture(textures);

        //This rotation part is very important! Without it, your model will render upside-down! And for some reason you DO need PushMatrix again!
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        //A reference to your Model file. Again, very important.
        this.model.Shape4.offsetY = cheesePressTileEntity.AnimationAngle;
        this.model.Shape4dot1.offsetY = cheesePressTileEntity.AnimationAngle;
        this.model.renderEnt((CheesePressTileEntity) te, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        //Tell it to stop rendering for both the PushMatrix's
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

}