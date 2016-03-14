package dmf444.ExtraFood.Common.RecipeHandler;

import dmf444.ExtraFood.Common.fluids.FluidLoader;
import dmf444.ExtraFood.Core.util.DualObjectLink;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by mincrmatt12. Do not copy this or you will have to face
 * our legal team. (dmf444)
 */
public class RegistryJuiceMixer {

    public class RecipeJuiceMixer {
        ArrayList<DualObjectLink<Integer, Fluid>> inputFluids = new ArrayList<>();
        int outputAmount = 1;
        Fluid outputFluid;

        @SafeVarargs
        public RecipeJuiceMixer(int outputAmount, Fluid outputFluid, DualObjectLink<Integer, Fluid>... inputFluids) {
            this.outputAmount = outputAmount;
            this.outputFluid = outputFluid;
            this.inputFluids = (ArrayList<DualObjectLink<Integer, Fluid>>) Arrays.asList(inputFluids);
        }

        public boolean matches(ArrayList<FluidStack> fluidStacks) {
            if (fluidStacks.size() != inputFluids.size()) {
                return false;
            }
            int ratio_amount = -1;
            ArrayList<FluidStack> fluidStacksCopy = (ArrayList<FluidStack>) fluidStacks.clone();
            for (DualObjectLink<Integer, Fluid> inputFluid : inputFluids) {
                FluidStack target = null;
                for (FluidStack candidate : fluidStacksCopy) {
                    if (candidate.getFluid() == inputFluid.getB()) {
                        target = candidate;
                        break;
                    }
                }
                if (target == null) {
                    return false;
                }
                fluidStacksCopy.remove(target);
                if (ratio_amount == -1) {
                    ratio_amount = (target.amount / 500) / inputFluid.getA();
                } else {
                    if ((target.amount / 500) / inputFluid.getA() != ratio_amount) {
                        return false;
                    }
                }
            }
            return true;

        }

        public int output(ArrayList<FluidStack> fluidStacks) {
            if (fluidStacks.size() != inputFluids.size()) {
                return 0;
            }
            int ratio_amount = -1;
            ArrayList<FluidStack> fluidStacksCopy = (ArrayList<FluidStack>) fluidStacks.clone();
            for (DualObjectLink<Integer, Fluid> inputFluid : inputFluids) {
                FluidStack target = null;
                for (FluidStack candidate : fluidStacksCopy) {
                    if (candidate.getFluid() == inputFluid.getB()) {
                        target = candidate;
                        break;
                    }
                }
                if (target == null) {
                    return 0;
                }
                fluidStacksCopy.remove(target);
                if (ratio_amount == -1) {
                    ratio_amount = (target.amount / 500) / inputFluid.getA();
                } else {
                    if ((target.amount / 500) / inputFluid.getA() != ratio_amount) {
                        return 0;
                    }
                }
            }

            return this.outputAmount * ratio_amount;
        }
    }

    public static RegistryJuiceMixer instance = new RegistryJuiceMixer();

    public ArrayList<RecipeJuiceMixer> recipes;

    public RegistryJuiceMixer() {
        recipes = new ArrayList<>();
        // TODO: Add recipes
    }

    public FluidStack getOutputForCurrent(ArrayList<FluidStack> fluidStacks) {
        for (RecipeJuiceMixer recipe : recipes) {
            if (recipe.matches(fluidStacks)) {
                int millis = 500 * recipe.output(fluidStacks);
                return new FluidStack(recipe.outputFluid, millis);
            }
        }
        int total = 0;
        for (FluidStack fluidStack : fluidStacks) {
            total += fluidStack.amount;
        }
        return new FluidStack(FluidLoader.FHorribleLiquid, total);
    }




}
