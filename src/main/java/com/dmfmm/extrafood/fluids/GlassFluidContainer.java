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
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.*;
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

    public static class CapabilityImpl implements IFluidHandlerItem, ICapabilityProvider {

        ItemStack containerItem = ItemStack.EMPTY;

        public CapabilityImpl(ItemStack initial) {
            this.containerItem = initial;
        }

        @Nonnull
        @Override
        public ItemStack getContainer() {
            return containerItem;
        }

        private int getAmountOrZero() {
            return (containerItem.hasTagCompound() && containerItem.getTagCompound().hasKey("amt")) ? containerItem.getTagCompound().getInteger("amt") : 0;
        }

        private String getFluidOrNone() {
            return (containerItem.hasTagCompound() && containerItem.getTagCompound().hasKey("fluid")) ? containerItem.getTagCompound().getString("fluid") : "";
        }

        @Override
        public IFluidTankProperties[] getTankProperties() {
            if (getAmountOrZero() != 0 && !getFluidOrNone().equals("")) {
                Fluid f = FluidRegistry.getFluid(getFluidOrNone());
                return new IFluidTankProperties[] {
                        new FluidTankProperties(new FluidStack(f, getAmountOrZero()), 1000)
                };
            }
            else {
                return new IFluidTankProperties[] {
                        new FluidTankProperties(new FluidStack(FluidRegistry.WATER, getAmountOrZero()), 1000)
                };
            }
        }

        @Override
        public int fill(FluidStack resource, boolean doFill) {
            NBTTagCompound modify = this.containerItem.getTagCompound();
            if (modify == null) modify = new NBTTagCompound();
            if (getAmountOrZero() == 0) {
                int amount = Math.min(1000, resource.amount);
                if (doFill) {
                    modify.setInteger("amt", amount);
                    modify.setString("fluid", resource.getFluid().getName());
                }
                this.containerItem.setTagCompound(modify);
                return amount;
            }
            else {
                if (getFluidOrNone().equals(resource.getFluid().getName())) {
                    int fill = Math.min(1000, resource.amount + getAmountOrZero());
                    int amount = getAmountOrZero() - fill;
                    if (doFill) {
                        modify.setInteger("amt", amount);
                    }
                    this.containerItem.setTagCompound(modify);
                    return amount;
                }
                return 0;
            }
        }

        @Nullable
        @Override
        public FluidStack drain(FluidStack resource, boolean doDrain) {
            if (getFluidOrNone().equals(resource.getFluid().getName())) {
                return drain(resource.amount, doDrain);
            }
            return null;
        }

        @Nullable
        @Override
        public FluidStack drain(int maxDrain, boolean doDrain) {
            int toDrain = Math.min(maxDrain, this.getAmountOrZero());
            if (toDrain == 0) {
                return new FluidStack(FluidRegistry.WATER, 0);
            }
            else {
                int newAmt = this.getAmountOrZero() - toDrain;
                if (!doDrain) {
                    return new FluidStack(FluidRegistry.getFluid(getFluidOrNone()), toDrain);
                }
                else {
                    FluidStack f = new FluidStack(FluidRegistry.getFluid(getFluidOrNone()), toDrain);
                    NBTTagCompound nbt = containerItem.getTagCompound();
                    if (newAmt == 0) {
                        nbt.removeTag("fluid");
                        nbt.removeTag("amt");
                    }
                    else {
                        nbt.setInteger("amt", newAmt);
                    }
                    containerItem.setTagCompound(nbt);
                    return f;
                }
            }
        }

        @Override
        public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
            return capability == CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY;
        }

        @Nullable
        @Override
        public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
            return (capability == CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY) ? (T) this : null;
        }
    }

    protected int capacity = 1000;
    public static ArrayList<Fluid> list = new ArrayList();

    public GlassFluidContainer(){
        this.initializeFluidsFromLoader();
        this.setRegistryName(ItemLib.GLASS_CONTAINER);
        this.setCreativeTab(ExtraFoodTab.INSTANCE);
        this.setUnlocalizedName("item.EFbottle");
        this.setMaxStackSize(1);
    }

    public static ItemStack createFluidFilledBottle(Fluid fluid){
        ItemStack itemStack = new ItemStack(FluidLoader.FLUID_CONTAINER);
        NBTTagCompound tagCompound = new NBTTagCompound();
        tagCompound.setString("fluid", fluid.getName());
        tagCompound.setInteger("amt", 1000);
        itemStack.setTagCompound(tagCompound);
        return itemStack;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        if(stack.hasTagCompound() && stack.getTagCompound().hasKey("fluid")){
            return "item.EFbottle." + stack.getTagCompound().getString("fluid");
        }
        else {
            return "item.EFbottle";
        }
    }

    @SideOnly(Side.CLIENT)
    public void getSubItems(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> subItems)
    {
        for (Fluid fluid : list){
            subItems.add(createFluidFilledBottle(fluid));
        }

        subItems.add(new ItemStack(this));
    }

    private void initializeFluidsFromLoader(){
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
        if (stack.hasTagCompound() && ((stack.getTagCompound().hasKey("amt") && stack.getTagCompound().getInteger("amt") >= 333) || !stack.getTagCompound().hasKey("amt"))) {
            return EnumAction.NONE;
        }
        return EnumAction.DRINK;
    }

    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand){
        ItemStack stack = player.getHeldItem(hand);
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
        if (stack.hasCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null)) {
            IFluidHandlerItem ifhi = stack.getCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null);
            if (ifhi == null) return stack;
            FluidStack cont;
            if (ifhi.getTankProperties().length > 0 && (cont = ifhi.getTankProperties()[0].getContents()) != null && cont.getFluid() instanceof EdibleFluid) {
                int amt = (cont.amount == 1000 ? 334 : 333);
                FluidStack drained;
                if ((drained = ifhi.drain(amt, false)) != null && drained.amount == amt) {
                    EdibleFluid edibleFluid = (EdibleFluid) drained.getFluid();
                    if (entityLiving instanceof EntityPlayer) {
                        EntityPlayer player = (EntityPlayer) entityLiving;
                        player.getFoodStats().addStats(edibleFluid.hunger, edibleFluid.starve);
                        world.playSound(null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
                        if (!player.capabilities.isCreativeMode) {
                            ifhi.drain(drained, true);
                            return ifhi.getContainer();
                        }
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
        return new CapabilityImpl(stack);
    }
}
