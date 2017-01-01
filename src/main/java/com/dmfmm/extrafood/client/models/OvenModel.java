package com.dmfmm.extrafood.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class OvenModel extends ModelBase
{
    //fields
    ModelRenderer Base;
    ModelRenderer RightWooden;
    ModelRenderer LeftWooden;
    ModelRenderer LeftWall;
    ModelRenderer RightWall;
    ModelRenderer BackWall;
    ModelRenderer TopDivider;
    ModelRenderer RackInside;
    ModelRenderer FrontGlass;
    ModelRenderer Top;
    ModelRenderer Lowertop;
    ModelRenderer Midlowtop;
    ModelRenderer midtoptop;
    ModelRenderer button1;
    ModelRenderer Weirdname;
    ModelRenderer Button2;

    public OvenModel()
    {
        textureWidth = 64;
        textureHeight = 128;

        Base = new ModelRenderer(this, 0, 0);
        Base.addBox(-8F, 0F, -8F, 16, 1, 16);
        Base.setRotationPoint(0F, 23F, 0F);
        Base.setTextureSize(64, 128);
        Base.mirror = true;
        setRotation(Base, 0F, 0F, 0F);
        RightWooden = new ModelRenderer(this, 0, 0);
        RightWooden.addBox(0F, 0F, 0F, 2, 10, 2);
        RightWooden.setRotationPoint(6F, 13F, -8F);
        RightWooden.setTextureSize(64, 128);
        RightWooden.mirror = true;
        setRotation(RightWooden, 0F, 0F, 0F);
        LeftWooden = new ModelRenderer(this, 0, 0);
        LeftWooden.addBox(0F, 0F, 0F, 2, 10, 2);
        LeftWooden.setRotationPoint(-8F, 13F, -8F);
        LeftWooden.setTextureSize(64, 128);
        LeftWooden.mirror = true;
        setRotation(LeftWooden, 0F, 0F, 0F);
        LeftWall = new ModelRenderer(this, 0, 17);
        LeftWall.addBox(0F, 0F, 0F, 1, 10, 14);
        LeftWall.setRotationPoint(-8F, 13F, -6F);
        LeftWall.setTextureSize(64, 128);
        LeftWall.mirror = true;
        setRotation(LeftWall, 0F, 0F, 0F);
        RightWall = new ModelRenderer(this, 0, 17);
        RightWall.addBox(0F, 0F, 0F, 1, 10, 14);
        RightWall.setRotationPoint(7F, 13F, -6F);
        RightWall.setTextureSize(64, 128);
        RightWall.mirror = true;
        setRotation(RightWall, 0F, 0F, 0F);
        BackWall = new ModelRenderer(this, 18, 17);
        BackWall.addBox(0F, 0F, 0F, 14, 10, 1);
        BackWall.setRotationPoint(-7F, 13F, 7F);
        BackWall.setTextureSize(64, 128);
        BackWall.mirror = true;
        setRotation(BackWall, 0F, 0F, 0F);
        TopDivider = new ModelRenderer(this, 0, 47);
        TopDivider.addBox(-8F, 0F, -8F, 16, 1, 16);
        TopDivider.setRotationPoint(0F, 12F, 0F);
        TopDivider.setTextureSize(64, 128);
        TopDivider.mirror = true;
        setRotation(TopDivider, 0F, 0F, 0F);
        RackInside = new ModelRenderer(this, 19, 29);
        RackInside.addBox(-8F, 0F, -8F, 14, 0, 14);
        RackInside.setRotationPoint(1F, 19F, 1F);
        RackInside.setTextureSize(64, 128);
        RackInside.mirror = true;
        setRotation(RackInside, 0F, 0F, 0F);
        FrontGlass = new ModelRenderer(this, 0, 83);
        FrontGlass.addBox(0F, 0F, 0F, 12, 10, 1);
        FrontGlass.setRotationPoint(-6F, 13F, -8F);
        FrontGlass.setTextureSize(64, 128);
        FrontGlass.mirror = true;
        setRotation(FrontGlass, 0F, 0F, 0F);
        Top = new ModelRenderer(this, 0, 74);
        Top.addBox(0F, 0F, 0F, 16, 1, 1);
        Top.setRotationPoint(-8F, 8F, -6F);
        Top.setTextureSize(64, 128);
        Top.mirror = true;
        setRotation(Top, 0F, 0F, 0F);
        Lowertop = new ModelRenderer(this, 0, 74);
        Lowertop.addBox(0F, 0F, 0F, 16, 1, 4);
        Lowertop.setRotationPoint(-8F, 11F, -6F);
        Lowertop.setTextureSize(64, 128);
        Lowertop.mirror = true;
        setRotation(Lowertop, 0F, 0F, 0F);
        Midlowtop = new ModelRenderer(this, 0, 74);
        Midlowtop.addBox(0F, 0F, 0F, 16, 1, 3);
        Midlowtop.setRotationPoint(-8F, 10F, -6F);
        Midlowtop.setTextureSize(64, 128);
        Midlowtop.mirror = true;
        setRotation(Midlowtop, 0F, 0F, 0F);
        midtoptop = new ModelRenderer(this, 0, 74);
        midtoptop.addBox(0F, 0F, 0F, 16, 1, 2);
        midtoptop.setRotationPoint(-8F, 9F, -6F);
        midtoptop.setTextureSize(64, 128);
        midtoptop.mirror = true;
        setRotation(midtoptop, 0F, 0F, 0F);
        button1 = new ModelRenderer(this, 0, 79);
        button1.addBox(0F, 0F, 0F, 2, 2, 1);
        button1.setRotationPoint(4F, 9F, -7F);
        button1.setTextureSize(64, 128);
        button1.mirror = true;
        setRotation(button1, 0F, 0F, 0F);
        Weirdname = new ModelRenderer(this, 0, 42);
        Weirdname.addBox(0F, 0F, 0F, 2, 1, 1);
        Weirdname.setRotationPoint(-1F, 9F, -7F);
        Weirdname.setTextureSize(64, 128);
        Weirdname.mirror = true;
        setRotation(Weirdname, 0F, 0F, 0F);
        Button2 = new ModelRenderer(this, 0, 79);
        Button2.addBox(0F, 0F, 0F, 2, 2, 1);
        Button2.setRotationPoint(-6F, 9F, -7F);
        Button2.setTextureSize(64, 128);
        Button2.mirror = true;
        setRotation(Button2, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        Base.render(f5);
        RightWooden.render(f5);
        LeftWooden.render(f5);
        LeftWall.render(f5);
        RightWall.render(f5);
        BackWall.render(f5);
        TopDivider.render(f5);
        RackInside.render(f5);
        FrontGlass.render(f5);
        Top.render(f5);
        Lowertop.render(f5);
        Midlowtop.render(f5);
        midtoptop.render(f5);
        button1.render(f5);
        Weirdname.render(f5);
        Button2.render(f5);
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