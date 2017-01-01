package com.dmfmm.extrafood.client.models;

import com.dmfmm.extrafood.tileentities.AutoCutterTileEntity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class AutoCutterModel extends ModelBase
{
    //fields
    ModelRenderer Back_base;
    ModelRenderer Front_Base;
    ModelRenderer Leg_1;
    ModelRenderer Leg_2;
    ModelRenderer Leg_3;
    ModelRenderer Leg_4;
    ModelRenderer Crossleg_1;
    ModelRenderer Crossleg2;
    ModelRenderer TableTop;
    ModelRenderer Sidea;
    ModelRenderer sideb;
    ModelRenderer sidec;
    ModelRenderer sided;
    ModelRenderer Cornera;
    ModelRenderer cornerb;
    ModelRenderer cuttingboard;
    public ModelRenderer KnifehandleANIMATE;
    ModelRenderer knifebar;
    public ModelRenderer knifeANIMATE;

    public AutoCutterModel()
    {
        textureWidth = 64;
        textureHeight = 64;

        Back_base = new ModelRenderer(this, 0, 0);
        Back_base.addBox(-8F, 0F, 0F, 16, 2, 2);
        Back_base.setRotationPoint(0F, 22F, 4F);
        Back_base.setTextureSize(64, 64);
        Back_base.mirror = true;
        setRotation(Back_base, 0F, 0F, 0F);
        Front_Base = new ModelRenderer(this, 0, 0);
        Front_Base.addBox(-8F, 0F, 0F, 16, 2, 2);
        Front_Base.setRotationPoint(0F, 22F, -6F);
        Front_Base.setTextureSize(64, 64);
        Front_Base.mirror = true;
        setRotation(Front_Base, 0F, 0F, 0F);
        Leg_1 = new ModelRenderer(this, 0, 4);
        Leg_1.addBox(0F, 0F, 0F, 2, 6, 2);
        Leg_1.setRotationPoint(4F, 16F, -6F);
        Leg_1.setTextureSize(64, 64);
        Leg_1.mirror = true;
        setRotation(Leg_1, 0F, 0F, 0F);
        Leg_2 = new ModelRenderer(this, 0, 4);
        Leg_2.addBox(0F, 0F, 0F, 2, 6, 2);
        Leg_2.setRotationPoint(-6F, 16F, -6F);
        Leg_2.setTextureSize(64, 64);
        Leg_2.mirror = true;
        setRotation(Leg_2, 0F, 0F, 0F);
        Leg_3 = new ModelRenderer(this, 0, 4);
        Leg_3.addBox(0F, 0F, 0F, 2, 6, 2);
        Leg_3.setRotationPoint(-6F, 16F, 4F);
        Leg_3.setTextureSize(64, 64);
        Leg_3.mirror = true;
        setRotation(Leg_3, 0F, 0F, 0F);
        Leg_4 = new ModelRenderer(this, 0, 4);
        Leg_4.addBox(0F, 0F, 0F, 2, 6, 2);
        Leg_4.setRotationPoint(4F, 16F, 4F);
        Leg_4.setTextureSize(64, 64);
        Leg_4.mirror = true;
        setRotation(Leg_4, 0F, 0F, 0F);
        Crossleg_1 = new ModelRenderer(this, 0, 29);
        Crossleg_1.addBox(0F, 0F, 0F, 1, 1, 8);
        Crossleg_1.setRotationPoint(5F, 19F, -4F);
        Crossleg_1.setTextureSize(64, 64);
        Crossleg_1.mirror = true;
        setRotation(Crossleg_1, 0F, 0F, 0F);
        Crossleg2 = new ModelRenderer(this, 0, 29);
        Crossleg2.addBox(0F, 0F, 0F, 1, 1, 8);
        Crossleg2.setRotationPoint(-6F, 19F, -4F);
        Crossleg2.setTextureSize(64, 64);
        Crossleg2.mirror = true;
        setRotation(Crossleg2, 0F, 0F, 0F);
        TableTop = new ModelRenderer(this, 0, 12);
        TableTop.addBox(-8F, 0F, -8F, 16, 1, 16);
        TableTop.setRotationPoint(0F, 15F, 0F);
        TableTop.setTextureSize(64, 64);
        TableTop.mirror = true;
        setRotation(TableTop, 0F, 0F, 0F);
        Sidea = new ModelRenderer(this, 0, 38);
        Sidea.addBox(0F, 0F, 0F, 1, 2, 14);
        Sidea.setRotationPoint(-7F, 16F, -7F);
        Sidea.setTextureSize(64, 64);
        Sidea.mirror = true;
        setRotation(Sidea, 0F, 0F, 0F);
        sideb = new ModelRenderer(this, 0, 38);
        sideb.addBox(0F, 0F, 0F, 1, 2, 14);
        sideb.setRotationPoint(6F, 16F, -7F);
        sideb.setTextureSize(64, 64);
        sideb.mirror = true;
        setRotation(sideb, 0F, 0F, 0F);
        sidec = new ModelRenderer(this, 8, 9);
        sidec.addBox(0F, 0F, 0F, 12, 2, 1);
        sidec.setRotationPoint(-6F, 16F, -7F);
        sidec.setTextureSize(64, 64);
        sidec.mirror = true;
        setRotation(sidec, 0F, 0F, 0F);
        sided = new ModelRenderer(this, 8, 9);
        sided.addBox(0F, 0F, 0F, 12, 2, 1);
        sided.setRotationPoint(-6F, 16F, 6F);
        sided.setTextureSize(64, 64);
        sided.mirror = true;
        setRotation(sided, 0F, 0F, 0F);
        Cornera = new ModelRenderer(this, 37, 0);
        Cornera.addBox(0F, 0F, 0F, 1, 4, 3);
        Cornera.setRotationPoint(7F, 11F, 5F);
        Cornera.setTextureSize(64, 64);
        Cornera.mirror = true;
        setRotation(Cornera, 0F, 0F, 0F);
        cornerb = new ModelRenderer(this, 37, 0);
        cornerb.addBox(0F, 0F, 0F, 1, 4, 3);
        cornerb.setRotationPoint(-8F, 11F, 5F);
        cornerb.setTextureSize(64, 64);
        cornerb.mirror = true;
        setRotation(cornerb, 0F, 0F, 0F);
        cuttingboard = new ModelRenderer(this, 0, 55);
        cuttingboard.addBox(0F, 0F, 0F, 10, 1, 8);
        cuttingboard.setRotationPoint(-5F, 14F, -5F);
        cuttingboard.setTextureSize(64, 64);
        cuttingboard.mirror = true;
        setRotation(cuttingboard, 0F, 0F, 0F);
        KnifehandleANIMATE = new ModelRenderer(this, 47, 0);
        KnifehandleANIMATE.addBox(0F, -1F, -6F, 2, 1, 6);
        KnifehandleANIMATE.setRotationPoint(-1F, 13F, 7F);
        KnifehandleANIMATE.setTextureSize(64, 64);
        KnifehandleANIMATE.mirror = true;
        setRotation(KnifehandleANIMATE, 0F, 0F, 0F);
        knifebar = new ModelRenderer(this, 32, 29);
        knifebar.addBox(0F, 0F, 0F, 14, 1, 1);
        knifebar.setRotationPoint(-7F, 12F, 6F);
        knifebar.setTextureSize(64, 64);
        knifebar.mirror = true;
        setRotation(knifebar, 0F, 0F, 0F);
        knifeANIMATE = new ModelRenderer(this, 19, 31);
        knifeANIMATE.addBox(0F, 0F, -9F, 0, 2, 5);
        knifeANIMATE.setRotationPoint(0F, 12F, 7F);
        knifeANIMATE.setTextureSize(64, 64);
        knifeANIMATE.mirror = true;
        setRotation(knifeANIMATE, 0F, 0F, 0F);
    }

    public void renderEnt(AutoCutterTileEntity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(null, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, null);
  /*  if (entity.complete > 0){
    	ArrayList<Float> bob = Lists.newArrayList(5.0F,5.1F,5.2F,5.3F,5.4F,5.5F,5.6F,5.7F,5.8F,5.9F,18.0F,18.1F,18.2F,18.3F,18.4F,18.5F,6.0F,6.1F,6.2F,0.0F);
    	EFLog.error(entity.ttime);
    	//int ticks = entity.complete * 20 + entity.ttime;
    	//if (ticks % 2 == 0){
    	//float degrees = (float) (ticks * 3.6);

    	//float rotation = (float) ((float) Math.sin(degrees) * 10);
    	//EFLog.fatal(rotation);
    	//if (rotation < 0){rotation = -rotation;}
    	this.knifeANIMATE.rotateAngleX =  bob.get(entity.ttime);
        this.KnifehandleANIMATE.rotateAngleX = bob.get(entity.ttime);
    	//this.knifeANIMATE.rotateAngleX = -rotation -4.48F;
    	//this.KnifehandleANIMATE.rotateAngleX = -rotation -4.48F;

    }*/
        //this.knifeANIMATE.rotateAngleX = 0F;
        //this.KnifehandleANIMATE.rotateAngleX = 0F;
        Back_base.render(f5);
        Front_Base.render(f5);
        Leg_1.render(f5);
        Leg_2.render(f5);
        Leg_3.render(f5);
        Leg_4.render(f5);
        Crossleg_1.render(f5);
        Crossleg2.render(f5);
        TableTop.render(f5);
        Sidea.render(f5);
        sideb.render(f5);
        sidec.render(f5);
        sided.render(f5);
        Cornera.render(f5);
        cornerb.render(f5);
        cuttingboard.render(f5);
        KnifehandleANIMATE.render(f5);
        knifebar.render(f5);
        knifeANIMATE.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        Back_base.render(f5);
        Front_Base.render(f5);
        Leg_1.render(f5);
        Leg_2.render(f5);
        Leg_3.render(f5);
        Leg_4.render(f5);
        Crossleg_1.render(f5);
        Crossleg2.render(f5);
        TableTop.render(f5);
        Sidea.render(f5);
        sideb.render(f5);
        sidec.render(f5);
        sided.render(f5);
        Cornera.render(f5);
        cornerb.render(f5);
        cuttingboard.render(f5);
        KnifehandleANIMATE.render(f5);
        knifebar.render(f5);
        knifeANIMATE.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }

}