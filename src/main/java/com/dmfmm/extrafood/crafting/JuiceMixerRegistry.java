package com.dmfmm.extrafood.crafting;

import com.dmfmm.extrafood.init.FluidLoader;
import com.dmfmm.extrafood.utilities.DualObjectLink;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by mincrmatt12. Do not copy this or you will have to face
 * our legal team. (dmf444)
 */
public class JuiceMixerRegistry {

    public class RecipeJuiceMixer {
        ArrayList<DualObjectLink<Integer, Fluid>> inputFluids = new ArrayList<>();
        int outputAmount = 1;
        Fluid outputFluid;

        @SafeVarargs
        public RecipeJuiceMixer(int outputAmount, Fluid outputFluid, DualObjectLink<Integer, Fluid>... inputFluids) {
            this.outputAmount = outputAmount;
            this.outputFluid = outputFluid;
            this.inputFluids = new ArrayList<>(Arrays.asList(inputFluids));
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

    public static JuiceMixerRegistry instance = new JuiceMixerRegistry();

    public ArrayList<RecipeJuiceMixer> recipes;
    public ArrayList<Fluid> validFluids;

    public JuiceMixerRegistry() {
        recipes = new ArrayList<>();
        validFluids = new ArrayList<>();
        addRecipe(4, FluidLoader.FLUID_APPLE_GRAPE_JUICE, dl(2, FluidLoader.FLUID_APPLE_JUICE), dl(2, FluidLoader.FLUID_GRAPE_JUICE));
        addRecipe(4, FluidLoader.FLUID_CITRUS_JUICE, dl(1, FluidLoader.FLUID_APPLE_JUICE), dl(2, FluidLoader.FLUID_GRAPE_JUICE), dl(1, FluidLoader.FLUID_ORANGE_JUICE));
        addRecipe(6, FluidLoader.FLUID_FRUIT_JUICE, dl(2, FluidLoader.FLUID_APPLE_JUICE), dl(2, FluidLoader.FLUID_WATERMELON_JUICE), dl(1, FluidLoader.FLUID_STRAWBERRY_JUICE), dl(1, FluidLoader.FLUID_GRAPE_JUICE));
        addRecipe(2, FluidLoader.FLUID_MIXED_BERRY_JUICE, dl(1, FluidLoader.FLUID_STRAWBERRY_JUICE), dl(1, FluidLoader.FLUID_GRAPE_JUICE));
        addRecipe(2, FluidLoader.FLUID_STRAWBERRY_BANANA_JUICE, dl(1, FluidLoader.FLUID_BANANA_JUICE), dl(1, FluidLoader.FLUID_STRAWBERRY_JUICE));
        addRecipe(2, FluidLoader.FLUID_TROPICAL_JUICE, dl(1, FluidLoader.FLUID_PINAPPLE_JUICE), dl(1, FluidLoader.FLUID_CITRUS_JUICE));
        // Test recipe
        //addRecipe(3, FluidLoader.FLUID_STRAWBERRY_JUICE, dl(1, FluidLoader.FLUID_BANANA_JUICE), dl(2, FluidLoader.FLUID_CARROT_JUICE));
    }

    public void addRecipe(int output, Fluid outputFluid, DualObjectLink<Integer, Fluid>... fluids) {
        RecipeJuiceMixer recipe = new RecipeJuiceMixer(output, outputFluid, fluids);
        for (DualObjectLink<Integer, Fluid> dualObjectLink : fluids) {
            if (!validFluids.contains(dualObjectLink.getB())) {
                validFluids.add(dualObjectLink.getB());
            }
        }
        recipes.add(recipe);
    }

    public DualObjectLink<Integer, Fluid> dl(Integer i, Fluid f) {
        return new DualObjectLink<>(i, f);
    }

    public FluidStack getOutputForCurrent(ArrayList<FluidStack> fluidStacks) {
        if (fluidStacks.size() == 1) {
            return fluidStacks.get(0).copy();
        }
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
        return new FluidStack(FluidLoader.FLUID_DISGUSTING_MIX, total);
    }

    public boolean validFluid(Fluid f) {
        return validFluids.contains(f);
    }




}