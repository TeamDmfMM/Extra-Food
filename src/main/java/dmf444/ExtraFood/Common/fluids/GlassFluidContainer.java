package dmf444.ExtraFood.Common.fluids;

import dmf444.ExtraFood.Core.util.Tabs.EFTabs;
import dmf444.ExtraFood.Core.util.EFLog;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmf444 on 3/12/2016. Code originally written
 * for ExtraFood. Do not copy without permission,
 * because that is just mean. Code is VISIBLE SOURCE, therfore
 * credit us, just don't steal large portions of this.
 */
public class GlassFluidContainer extends Item{

    private static ArrayList<Fluid> list = new ArrayList();

    public GlassFluidContainer(){
        this.RnR();
        this.setCreativeTab(EFTabs.INSTANCE);
    }



    public static ItemStack createFluidFilledBottle(Fluid fluid){
        ItemStack itemStack = new ItemStack(FluidLoader.FluidContainer);
        NBTTagCompound tagCompound = new NBTTagCompound();
        tagCompound.setString("fluid", fluid.getName());
        itemStack.setTagCompound(tagCompound);
        return itemStack;
    }

    public String getItemStackDisplayName(ItemStack stack)
    {
        if(stack.hasTagCompound() && stack.getTagCompound().hasKey("fluid")){
            return (StatCollector.translateToLocal("item.EFbottle."+ stack.getTagCompound().getString("fluid") + ".name"));
        }else {
            return "BOTTLE ERROR, REPORT IMMEDIATELY!";
        }
    }

    @SideOnly(Side.CLIENT)
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems)
    {
        for (Fluid fluid : list){
            subItems.add(createFluidFilledBottle(fluid));
        }
    }

    public static void createGlassBottles(){
        for (Fluid fluid : list){
            FluidContainerRegistry.registerFluidContainer(fluid, createFluidFilledBottle(fluid), FluidContainerRegistry.EMPTY_BOTTLE);
            EFLog.fatal("Added "+fluid.getName() +" to the Registry");
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

    public EnumAction getItemUseAction(ItemStack p_77661_1_)
    {
        return EnumAction.DRINK;
    }

    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
        if (stack.getItem() == this){
            player.setItemInUse(stack, 32);
            return stack;
        }
        else {
            return stack;
        }
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World world, EntityPlayer Player)
    {
        if(stack.hasTagCompound() && stack.getTagCompound().hasKey("fluid")) {
            if(FluidRegistry.getFluid(stack.getTagCompound().getString("fluid")) instanceof EdibleFluid) {
                EdibleFluid edibleFluid = (EdibleFluid) FluidRegistry.getFluid(stack.getTagCompound().getString("fluid"));
                --stack.stackSize;
                Player.getFoodStats().addStats(edibleFluid.getHunger(), edibleFluid.getSaturation());
                world.playSoundAtEntity(Player, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
                return stack.stackSize <= 0 ? new ItemStack(Items.glass_bottle) : stack;
            }
        }
        return stack;

    }
    @Override
    public int getMaxItemUseDuration(ItemStack p_77626_1_)
    {
        return 32;
    }

}
