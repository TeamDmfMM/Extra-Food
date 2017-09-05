package com.dmfmm.extrafood.items;


import com.dmfmm.extrafood.ExtraFood;
import com.dmfmm.extrafood.utilities.tabs.ExtraFoodTab;
import javax.annotation.Nonnull;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.capability.templates.FluidHandlerItemStackSimple;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

import java.util.ArrayList;

public class BucketEdible extends ItemBucket {

    private int FoodStat;
    private float SaturationLvl;
    private Block containedBlock;


    public BucketEdible(int foodBar, float saturation, Block fluidBlock, String localName){
        super(fluidBlock);
        this.setCreativeTab(ExtraFoodTab.INSTANCE);
        this.setRegistryName(localName);
        this.setUnlocalizedName(localName);

        this.FoodStat = foodBar;
        this.SaturationLvl = saturation;
        this.containedBlock = fluidBlock;

        /*try {
            FluidContainerRegistryHelper.specialCases.get(Items.BUCKET).add(this);
        } catch (NullPointerException e) {
            FluidContainerRegistryHelper.specialCases.put(Items.BUCKET, new ArrayList<IFluidContainerItem>());
            FluidContainerRegistryHelper.specialCases.get(Items.BUCKET).add(this);
        }*/

        GameRegistry.register(this);
        if(ExtraFood.side == Side.CLIENT){
            ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(this.getRegistryName().toString(), "inventory"));
        }
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World world, EntityLivingBase entityLiving)
    {
        stack.shrink(1);

        if (entityLiving instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer)entityLiving;
            player.getFoodStats().addStats(FoodStat, SaturationLvl);
            world.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
        }

        return stack.getCount() <= 0 ? new ItemStack(Items.BUCKET) : stack;

    }
    @Override
    public int getMaxItemUseDuration(ItemStack p_77626_1_)
    {
        return 32;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    @Override
    public EnumAction getItemUseAction(ItemStack p_77661_1_)
    {
        return EnumAction.DRINK;
    }


    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand){
        ItemStack t = super.onItemRightClick(world, player, hand).getResult();
        if (t.getItem() == this){
            player.setActiveHand(hand);
            return new ActionResult<>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
        }
        else {
            return new ActionResult<>(EnumActionResult.FAIL, t);
        }
    }


    public static class EFFluidHandlerItemStackSimple extends FluidHandlerItemStackSimple{

        public EFFluidHandlerItemStackSimple(@Nonnull ItemStack container, int capacity) {
            super(container, 1000);
        }


    }
}