package com.dmfmm.extrafood.client.models;

import com.dmfmm.extrafood.tileentities.CheesePressTileEntity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class CheesePressModel extends ModelBase
{
    //fields
    ModelRenderer Shape1;
    ModelRenderer Base;
    ModelRenderer Piece1;
    ModelRenderer Shape2dot2;
    ModelRenderer Shape2;
    ModelRenderer Shape2dot3;
    ModelRenderer Shape2dot4;
    ModelRenderer Shape3;
    ModelRenderer Shape3dot1;
    public ModelRenderer Shape4;
    public ModelRenderer Shape4dot1;

    public CheesePressModel()
    {
        textureWidth = 64;
        textureHeight = 32;
        setTextureOffset("Base.base", 0, 0);

        Shape1 = new ModelRenderer(this, 0, 17);
        Shape1.addBox(-3F, 0F, -3F, 6, 1, 6);
        Shape1.setRotationPoint(0F, 22F, 0F);
        Shape1.setTextureSize(64, 32);
        Shape1.mirror = true;
        setRotation(Shape1, 0F, 0F, 0F);
        Base = new ModelRenderer(this, "Base");
        Base.setRotationPoint(-8F, 23F, -8F);
        setRotation(Base, 0F, 0F, 0F);
        Base.mirror = true;
        Base.addBox("base", 0F, 0F, 0F, 16, 1, 16);
        Piece1 = new ModelRenderer(this, "Piece1");
        Piece1.setRotationPoint(-8F, 21F, -4F);
        setRotation(Piece1, -2.788396F, 0.0371786F, 3.141593F);
        Piece1.mirror = true;
        //Shape2dot2.mirror = true;
        Shape2dot2 = new ModelRenderer(this, 0, 0);
        Shape2dot2.addBox(3F, -5F, -3F, 1, 6, 6);
        Shape2dot2.setRotationPoint(0F, 22F, 0F);
        Shape2dot2.setTextureSize(64, 32);
        Shape2dot2.mirror = true;
        setRotation(Shape2dot2, 0F, 0F, 0F);
        Shape2dot2.mirror = false;
        Shape2 = new ModelRenderer(this, 0, 24);
        Shape2.addBox(-4F, -5F, -4F, 8, 6, 1);
        Shape2.setRotationPoint(0F, 22F, 0F);
        Shape2.setTextureSize(64, 32);
        Shape2.mirror = true;
        setRotation(Shape2, 0F, 0F, 0F);
        Shape2dot3 = new ModelRenderer(this, 18, 24);
        Shape2dot3.addBox(-4F, -5F, 3F, 8, 6, 1);
        Shape2dot3.setRotationPoint(0F, 22F, 0F);
        Shape2dot3.setTextureSize(64, 32);
        Shape2dot3.mirror = true;
        setRotation(Shape2dot3, 0F, 0F, 0F);
        Shape2dot4 = new ModelRenderer(this, 0, 0);
        Shape2dot4.addBox(-4F, -5F, -3F, 1, 6, 6);
        Shape2dot4.setRotationPoint(0F, 22F, 0F);
        Shape2dot4.setTextureSize(64, 32);
        Shape2dot4.mirror = true;
        setRotation(Shape2dot4, 0F, 0F, 0F);
        Shape3 = new ModelRenderer(this, 59, 0);
        Shape3.addBox(0F, 0F, 0F, 1, 15, 1);
        Shape3.setRotationPoint(0F, 8F, -7F);
        Shape3.setTextureSize(64, 32);
        Shape3.mirror = true;
        setRotation(Shape3, 0F, 0F, 0F);
        Shape3dot1 = new ModelRenderer(this, 59, 0);
        Shape3dot1.addBox(0F, 0F, 0F, 1, 15, 1);
        Shape3dot1.setRotationPoint(0F, 8F, 6F);
        Shape3dot1.setTextureSize(64, 32);
        Shape3dot1.mirror = true;
        setRotation(Shape3dot1, 0F, 0F, 0F);
        Shape4 = new ModelRenderer(this, 25, 15);
        Shape4.addBox(0F, 0F, 0F, 3, 1, 16);
        Shape4.setRotationPoint(-1F, 12F, -8F);
        Shape4.setTextureSize(64, 32);
        Shape4.mirror = true;
        setRotation(Shape4, 0F, 0F, 0F);
        Shape4dot1 = new ModelRenderer(this, 25, 15);
        Shape4dot1.addBox(0F, 0F, 0F, 3, 1, 16);
        Shape4dot1.setRotationPoint(-1F, 9F, -8F);
        Shape4dot1.setTextureSize(64, 32);
        Shape4dot1.mirror = true;
        setRotation(Shape4dot1, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5){

        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        Shape1.render(f5);
        Base.render(f5);
        Piece1.render(f5);
        Shape2dot2.render(f5);
        Shape2.render(f5);
        Shape2dot3.render(f5);
        Shape2dot4.render(f5);
        Shape3.render(f5);
        Shape3dot1.render(f5);
        Shape4.render(f5);
        Shape4dot1.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }

    public void renderEnt(CheesePressTileEntity entity, float f, float f1, float f2, float f3, float f4, float f5){
	  	/*if (entity.complete > 0){
	  		int ticks = entity.complete * 10 + entity.ttime;
	  		if (ticks % 2 == 0){
	  		int degrees = (int) (ticks * 1.5);
	  		float trans = (float) ((float) Math.sin(degrees) * 0.25);
	  		if (trans < 0){trans = -trans;}
	  		this.Shape4.offsetY = trans;
	  		this.Shape4dot1.offsetY =trans;

	  		}

	  	}
	  	else {
	  		this.Shape4.offsetY = 0;
	  		this.Shape4dot1.offsetY = 0;
	  	}*/
        super.render(null, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, null);
        Shape1.render(f5);
        Base.render(f5);
        Piece1.render(f5);
        Shape2dot2.render(f5);
        Shape2.render(f5);
        Shape2dot3.render(f5);
        Shape2dot4.render(f5);
        Shape3.render(f5);
        Shape3dot1.render(f5);
        Shape4.render(f5);
        Shape4dot1.render(f5);
    }

}