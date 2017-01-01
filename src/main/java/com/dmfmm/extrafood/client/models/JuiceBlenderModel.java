package com.dmfmm.extrafood.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class JuiceBlenderModel extends ModelBase
{
    //fields
    ModelRenderer Base;
    ModelRenderer BoxFloor;
    ModelRenderer BoxSide;
    ModelRenderer BoxSide1;
    ModelRenderer BoxSide2;
    ModelRenderer BoxSide3;
    ModelRenderer MixerPole;
    ModelRenderer MixerArm;
    ModelRenderer MixerBar;
    ModelRenderer Mixer;

    public JuiceBlenderModel()
    {
        textureWidth = 128;
        textureHeight = 64;

        Base = new ModelRenderer(this, 0, 0);
        Base.addBox(0F, 0F, 0F, 16, 2, 16);
        Base.setRotationPoint(-8F, 22F, -8F);
        Base.setTextureSize(128, 64);
        Base.mirror = true;
        setRotation(Base, 0F, 0F, 0F);
        BoxFloor = new ModelRenderer(this, 64, 0);
        BoxFloor.addBox(0F, 0F, 0F, 8, 1, 8);
        BoxFloor.setRotationPoint(-4F, 21F, -2F);
        BoxFloor.setTextureSize(128, 64);
        BoxFloor.mirror = true;
        setRotation(BoxFloor, 0F, 0F, 0F);
        BoxSide = new ModelRenderer(this, 0, 20);
        BoxSide.addBox(0F, 0F, 0F, 8, 8, 1);
        BoxSide.setRotationPoint(-4F, 14F, -3F);
        BoxSide.setTextureSize(128, 64);
        BoxSide.mirror = true;
        setRotation(BoxSide, 0F, 0F, 0F);
        BoxSide1 = new ModelRenderer(this, 0, 20);
        BoxSide1.addBox(0F, 0F, 0F, 8, 8, 1);
        BoxSide1.setRotationPoint(-4F, 14F, 6F);
        BoxSide1.setTextureSize(128, 64);
        BoxSide1.mirror = true;
        setRotation(BoxSide1, 0F, 0F, 0F);
        BoxSide2 = new ModelRenderer(this, 18, 20);
        BoxSide2.addBox(0F, 0F, 0F, 1, 8, 10);
        BoxSide2.setRotationPoint(4F, 14F, -3F);
        BoxSide2.setTextureSize(128, 64);
        BoxSide2.mirror = true;
        setRotation(BoxSide2, 0F, 0F, 0F);
        BoxSide3 = new ModelRenderer(this, 18, 20);
        BoxSide3.addBox(0F, 0F, 0F, 1, 8, 10);
        BoxSide3.setRotationPoint(-5F, 14F, -3F);
        BoxSide3.setTextureSize(128, 64);
        BoxSide3.mirror = true;
        setRotation(BoxSide3, 0F, 0F, 0F);
        MixerPole = new ModelRenderer(this, 0, 37);
        MixerPole.addBox(0F, 0F, 0F, 2, 14, 2);
        MixerPole.setRotationPoint(-1F, 8F, -7F);
        MixerPole.setTextureSize(128, 64);
        MixerPole.mirror = true;
        setRotation(MixerPole, 0F, 0F, 0F);
        MixerArm = new ModelRenderer(this, 8, 42);
        MixerArm.addBox(0F, 0F, 0F, 2, 1, 10);
        MixerArm.setRotationPoint(-1F, 7F, -7F);
        MixerArm.setTextureSize(128, 64);
        MixerArm.mirror = true;
        setRotation(MixerArm, 0F, 0F, 0F);
        MixerBar = new ModelRenderer(this, 96, 0);
        MixerBar.addBox(0F, 0F, 0F, 2, 8, 2);
        MixerBar.setRotationPoint(-1F, 8F, 1F);
        MixerBar.setTextureSize(128, 64);
        MixerBar.mirror = true;
        setRotation(MixerBar, 0F, 0F, 0F);
        Mixer = new ModelRenderer(this, 64, 9);
        Mixer.addBox(0F, 0F, 0F, 8, 1, 8);
        Mixer.setRotationPoint(-4F, 8F, -2F);
        Mixer.setTextureSize(128, 64);
        Mixer.mirror = true;
        setRotation(Mixer, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        Base.render(f5);
        BoxFloor.render(f5);
        BoxSide.render(f5);
        BoxSide1.render(f5);
        BoxSide2.render(f5);
        BoxSide3.render(f5);
        MixerPole.render(f5);
        MixerArm.render(f5);
        MixerBar.render(f5);
        Mixer.render(f5);
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

}