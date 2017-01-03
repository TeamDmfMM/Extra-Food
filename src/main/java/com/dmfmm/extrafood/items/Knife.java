package com.dmfmm.extrafood.items;

import com.dmfmm.extrafood.init.ItemLoader;
import com.dmfmm.extrafood.library.ItemLib;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Knife extends GenericItem {



    public Knife()
    {
        super(ItemLib.KNIFE, true);
        this.maxStackSize = 1;
        this.setMaxDamage(10);
        //this.setTextureName("extrafood:knife");
        this.setContainerItem(this);
    }

    public Item setNoRepair() {
        boolean canRepairng = false;
        return this;
    }

    @Override
    public boolean isRepairable() {
        return false;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemstack) {
        ItemStack copiedStack = itemstack.copy();

        copiedStack.setItemDamage(copiedStack.getItemDamage() + 1);
        copiedStack.stackSize = 1;
        return copiedStack;
    }


    public boolean hasContainerItem(ItemStack itemstack)
    {
        return true;
    }

    public boolean getShareTag()
    {
        return true;
    }


    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }


    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity){
        if(!entity.worldObj.isRemote){
            if(entity instanceof EntityPig){
                int PigDropA = MathHelper.getRandomIntegerInRange(itemRand, 3, 6);
                ItemStack item = new ItemStack(ItemLoader.BACON, PigDropA);
                //EFLog.debug("BACON SPAWN2");
                Entity Ientity = new EntityItem(entity.worldObj, entity.posX, entity.posY, entity.posZ, item);
                entity.worldObj.spawnEntityInWorld(Ientity);
                ((EntityPig) entity).setHealth(0);
                stack.damageItem(2, player);
                return false;
            } else if (entity instanceof EntityCow){
                if(((EntityCow) entity).isChild()){
                    int BabyCowDropA = MathHelper.getRandomIntegerInRange(itemRand, 1, 3);
                    ItemStack item = new ItemStack(ItemLoader.VEAL, BabyCowDropA);
                    //EFLog.debug("BACON SPAWN2");
                    Entity Ientity = new EntityItem(entity.worldObj, entity.posX, entity.posY, entity.posZ, item);
                    entity.worldObj.spawnEntityInWorld(Ientity);
                    ((EntityCow) entity).setHealth(0);
                    stack.damageItem(2, player);
                    return false;
                }
            }
        }
        return false;
    }

}
