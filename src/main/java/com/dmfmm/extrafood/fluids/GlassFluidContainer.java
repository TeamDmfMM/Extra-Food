package com.dmfmm.extrafood.fluids;


import com.dmfmm.extrafood.init.FluidLoader;
import com.dmfmm.extrafood.library.ItemLib;
import com.dmfmm.extrafood.utilities.EFLog;
import com.dmfmm.extrafood.utilities.tabs.ExtraFoodTab;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.capability.templates.FluidHandlerItemStackSimple;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by dmf444 on 3/12/2016. Code originally written
 * for ExtraFood. Do not copy without permission,
 * because that is just mean. Code is VISIBLE SOURCE, therfore
 * credit us, just don't steal large portions of this.
 */
public class GlassFluidContainer extends Item{

    protected int capacity = 1000;
    public static ArrayList<Fluid> list = new ArrayList();

    public GlassFluidContainer(){
        this.RnR();
        this.setRegistryName(ItemLib.GLASS_CONTAINER);
        this.setCreativeTab(ExtraFoodTab.INSTANCE);
    }



    public static ItemStack createFluidFilledBottle(Fluid fluid){
        ItemStack itemStack = new ItemStack(FluidLoader.FLUID_CONTAINER);
        NBTTagCompound tagCompound = new NBTTagCompound();
        tagCompound.setString("fluid", fluid.getName());
        itemStack.setTagCompound(tagCompound);
        return itemStack;
    }

    public String getItemStackDisplayName(ItemStack stack)
    {
        if(stack.hasTagCompound() && stack.getTagCompound().hasKey("fluid")){
            return (I18n.translateToLocal("item.EFbottle." + stack.getTagCompound().getString("fluid") + ".name"));
        }else {
            return "BOTTLE ERROR, REPORT IMMEDIATELY!";
        }
    }

    @SideOnly(Side.CLIENT)
    public void getSubItems(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> subItems)
    {
        for (Fluid fluid : list){
            subItems.add(createFluidFilledBottle(fluid));
        }
    }

    public static void createGlassBottles(){
        for (Fluid fluid : list){
            //FluidContainerRegistry.registerFluidContainer(fluid, createFluidFilledBottle(fluid), FluidContainerRegistry.EMPTY_BOTTLE);
            EFLog.fatal("Added " + fluid.getName() + " to the Registry");
        }

    }

    private void RnR(){
        Field[] fields = FluidLoader.class.getDeclaredFields();

        for (Field dec : fields){
            if(Modifier.isStatic(dec.getModifiers())){
                try{
                    Object obj = dec.get(null);
                    if(obj instanceof Fluid){
                        list.add((Fluid) obj);
                    }
                } catch (IllegalAccessException e) {}
            }
        }
    }

    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.DRINK;
    }

    public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand){
        if (stack.getItem() == this && player.canEat(false)){
            player.setActiveHand(hand);
            return new ActionResult<>(EnumActionResult.SUCCESS, stack);
        }
        else {
            return new ActionResult<>(EnumActionResult.FAIL, stack);
        }
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World world, EntityLivingBase entityLiving)
    {
        if(stack.hasTagCompound() && stack.getTagCompound().hasKey("fluid")) {
            if(FluidRegistry.getFluid(stack.getTagCompound().getString("fluid")) instanceof EdibleFluid) {
                EdibleFluid edibleFluid = (EdibleFluid) FluidRegistry.getFluid(stack.getTagCompound().getString("fluid"));

                stack.setCount(stack.getCount() - 1);

                if (entityLiving instanceof EntityPlayer)
                {
                    EntityPlayer player = (EntityPlayer)entityLiving;
                    player.getFoodStats().addStats(edibleFluid.hunger, edibleFluid.starve);
                    world.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
                    if (!player.capabilities.isCreativeMode)
                    {
                        if (stack.getCount() <= 0)
                        {
                            return new ItemStack(Items.GLASS_BOTTLE);
                        }
                        player.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE));
                    }

                }

            }
        }
        return stack;

    }
    @Override
    public int getMaxItemUseDuration(ItemStack p_77626_1_)
    {
        return 32;
    }

    @Override
    public ICapabilityProvider initCapabilities(@Nonnull ItemStack stack, @Nullable NBTTagCompound nbt)
    {
        return new FluidHandlerItemStackSimple(stack, capacity);
    }
}
