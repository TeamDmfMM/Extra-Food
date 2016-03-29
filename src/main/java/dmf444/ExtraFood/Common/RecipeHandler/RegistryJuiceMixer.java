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

    public static RegistryJuiceMixer instance = new RegistryJuiceMixer();

    public ArrayList<RecipeJuiceMixer> recipes;
    public ArrayList<Fluid> validFluids;

    public RegistryJuiceMixer() {
        recipes = new ArrayList<>();
        validFluids = new ArrayList<>();

        addRecipe(4, FluidLoader.Fapplegrapejuice, dl(2, FluidLoader.Fapplejuice), dl(2, FluidLoader.Fgrapejuice));
        addRecipe(4, FluidLoader.Fcitusjuice, dl(1, FluidLoader.Fapplejuice), dl(2, FluidLoader.Fgrapejuice), dl(1, FluidLoader.Forangejuice));
        addRecipe(6, FluidLoader.Ffruitjuice, dl(2, FluidLoader.Fapplejuice), dl(2, FluidLoader.Fwatermelonjuice), dl(1, FluidLoader.Fstrawberryjuice), dl(1, FluidLoader.Fgrapejuice));
        addRecipe(2, FluidLoader.Fmixedberryjuice, dl(1, FluidLoader.Fstrawberryjuice), dl(1, FluidLoader.Fgrapejuice));
        addRecipe(2, FluidLoader.Fstrawberrybanana, dl(1, FluidLoader.Fbananajuice), dl(1, FluidLoader.Fstrawberryjuice));
        addRecipe(2, FluidLoader.Ftropicaljuice, dl(1, FluidLoader.FpinappleJuice), dl(1, FluidLoader.Fcitusjuice));

        //Apple-Grape= 1000ml Apple, 1000ml Grape
        //Citrus = 500ml Apple, 1000ml Grape, 500ml orange
        //Fruit = 1000mL Apple, 1000ml Watermelon, 500ml Strawberry, 500ml Grape
        //Mixed berry = 500ml Strawberry, 500ml Grape
        //Strawberry banana = 500ml Strawberry, 500ml Banana
        //F tropical = (if possible) 500ml Pinapple, 500ml Citrus
        // Test recipe
        //addRecipe(3, FluidLoader.Fstrawberryjuice, dl(1, FluidLoader.Fbananajuice), dl(2, FluidLoader.Fcarrotjuice));
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
        return new FluidStack(FluidLoader.FHorribleLiquid, total);
    }

    public boolean validFluid(Fluid f) {
        return validFluids.contains(f);
    }




}
