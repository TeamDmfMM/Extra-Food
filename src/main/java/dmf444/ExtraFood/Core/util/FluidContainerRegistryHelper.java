package dmf444.ExtraFood.Core.util;

import dmf444.ExtraFood.Common.fluids.FluidLoader;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidContainerItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mincrmatt12. Do not copy this or you will have to face
 * our legal team. (dmf444)
 */
public class FluidContainerRegistryHelper {

    public static Map<Item, ArrayList<IFluidContainerItem>> specialCases = new HashMap<>();


    static {
        specialCases.put(Items.GLASS_BOTTLE, new ArrayList() {{ add(FluidLoader.FluidContainer); }});
    }

    public static boolean isFilledContainer(ItemStack stackInSlot) {
        if (stackInSlot.getItem() instanceof IFluidContainerItem) {
            FluidStack fluidStack = ((IFluidContainerItem) stackInSlot.getItem()).getFluid(stackInSlot);
            if (fluidStack != null) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return FluidContainerRegistry.isFilledContainer(stackInSlot);
        }

    }

    public static FluidStack getFluidForFilledItem(ItemStack stackInSlot) {
        if (stackInSlot.getItem() instanceof IFluidContainerItem) {
            return ((IFluidContainerItem) stackInSlot.getItem()).getFluid(stackInSlot);
        }
        else {
            return FluidContainerRegistry.getFluidForFilledItem(stackInSlot);
        }
    }

    public static ItemStack drainFluidContainer(ItemStack stackInSlot) {
        if (stackInSlot.getItem() instanceof IFluidContainerItem) {
            ItemStack working = stackInSlot.copy();
            ((IFluidContainerItem) stackInSlot.getItem()).drain(working, ((IFluidContainerItem) stackInSlot.getItem()).getCapacity(stackInSlot), true);
            return working;
        }
        else {
            return FluidContainerRegistry.drainFluidContainer(stackInSlot);
        }
    }

    public static boolean isEmptyContainer(ItemStack stackInSlot) {
        if (stackInSlot.getItem() instanceof IFluidContainerItem) {
            FluidStack fluidStack = ((IFluidContainerItem) stackInSlot.getItem()).getFluid(stackInSlot);
            if (fluidStack != null) {
                return false;
            }
            else {
                return true;
            }
        }
        else {
            return FluidContainerRegistry.isEmptyContainer(stackInSlot);
        }

    }

    public static int getContainerCapacity(FluidStack fluidStack, ItemStack stackInSlot) {
        if (specialCases.containsKey(stackInSlot.getItem())) {
            ArrayList<IFluidContainerItem> iFluidContainerItems = specialCases.get(stackInSlot.getItem());
            int result = 0;
            for (IFluidContainerItem iFluidContainerItem : iFluidContainerItems) {
                result = Math.max(iFluidContainerItem.fill(stackInSlot, fluidStack, false), result);
            }
            if (result > 0) {
                return result;
            }
        }
        if (stackInSlot.getItem() instanceof IFluidContainerItem) {
            return ((IFluidContainerItem) stackInSlot.getItem()).getCapacity(stackInSlot);
        }
        else {
            return FluidContainerRegistry.getContainerCapacity(fluidStack, stackInSlot);
        }
    }

    public static ItemStack fillFluidContainer(FluidStack fluidStack, ItemStack stackInSlot) {
        if (specialCases.containsKey(stackInSlot.getItem())) {
            ArrayList<IFluidContainerItem> iFluidContainerItems = specialCases.get(stackInSlot.getItem());
            ItemStack working = stackInSlot.copy();
            for (IFluidContainerItem iFluidContainerItem : iFluidContainerItems) {
                int amt = iFluidContainerItem.fill(working, fluidStack, true);
                if (amt != 0) {
                    return working;
                }
            }
        }
        if (stackInSlot.getItem() instanceof IFluidContainerItem) {
            ItemStack working = stackInSlot.copy();
            ((IFluidContainerItem) stackInSlot.getItem()).fill(working, fluidStack, true);
            return working;
        }
        else {
            return FluidContainerRegistry.fillFluidContainer(fluidStack, stackInSlot);
        }
    }
}
