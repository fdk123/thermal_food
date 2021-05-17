package cofh.thermal.expansion.compat.crt.machine;

import cofh.thermal.expansion.init.TExpRecipeTypes;
import cofh.thermal.expansion.util.recipes.machine.BrewerRecipe;
import cofh.thermal.lib.compat.crt.actions.ActionRemoveThermalRecipeByOutput;
import cofh.thermal.lib.compat.crt.base.CRTRecipe;
import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker.api.fluid.IFluidStack;
import com.blamejared.crafttweaker.api.item.IIngredient;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker.api.managers.IRecipeManager;
import com.blamejared.crafttweaker.impl.actions.recipes.ActionAddRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@ZenCodeType.Name("mods.thermal.Brewer")
public class CRTBrewerManager implements IRecipeManager {

    @ZenCodeType.Method
    public void addRecipe(String name, IFluidStack output, IIngredient ingredient, IFluidStack fluidInput, int energy) {

        name = fixRecipeName(name);
        ResourceLocation resourceLocation = new ResourceLocation("crafttweaker", name);

        CRTRecipe crtRecipe = new CRTRecipe(resourceLocation).energy(energy).input(ingredient).input(fluidInput).output(output);
        CraftTweakerAPI.apply(new ActionAddRecipe(this, crtRecipe.recipe(BrewerRecipe::new), ""));
    }

    @Override
    public IRecipeType<BrewerRecipe> getRecipeType() {

        return TExpRecipeTypes.RECIPE_BREWER;
    }

    @Override
    public void removeRecipe(IItemStack output) {

        throw new IllegalArgumentException("The Brewer only outputs fluids! Please provide an IFluidStack");
    }

    @ZenCodeType.Method
    public void removeRecipe(IFluidStack output) {

        CraftTweakerAPI.apply(new ActionRemoveThermalRecipeByOutput(this, new IFluidStack[]{output}));
    }

}
