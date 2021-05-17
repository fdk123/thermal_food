package cofh.thermal.expansion.compat.crt.machine;

import cofh.thermal.expansion.init.TExpRecipeTypes;
import cofh.thermal.expansion.util.recipes.machine.SmelterRecipe;
import cofh.thermal.lib.compat.crt.actions.ActionRemoveThermalRecipeByOutput;
import cofh.thermal.lib.compat.crt.base.CRTRecipe;
import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker.api.item.IIngredient;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker.api.managers.IRecipeManager;
import com.blamejared.crafttweaker.impl.actions.recipes.ActionAddRecipe;
import com.blamejared.crafttweaker.impl.item.MCWeightedItemStack;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@ZenCodeType.Name("mods.thermal.Smelter")
public class CRTSmelterManager implements IRecipeManager {

    @ZenCodeType.Method
    public void addRecipe(String name, MCWeightedItemStack[] outputs, IIngredient[] ingredients, float experience, int energy) {

        name = fixRecipeName(name);
        ResourceLocation resourceLocation = new ResourceLocation("crafttweaker", name);

        CRTRecipe crtRecipe = new CRTRecipe(resourceLocation).energy(energy).input(ingredients).output(outputs).experience(experience);
        CraftTweakerAPI.apply(new ActionAddRecipe(this, crtRecipe.recipe(SmelterRecipe::new), ""));
    }

    @Override
    public IRecipeType<SmelterRecipe> getRecipeType() {

        return TExpRecipeTypes.RECIPE_SMELTER;
    }

    @Override
    public void removeRecipe(IItemStack output) {

        removeRecipe(new IItemStack[]{output});
    }

    @ZenCodeType.Method
    public void removeRecipe(IItemStack... output) {

        CraftTweakerAPI.apply(new ActionRemoveThermalRecipeByOutput(this, output));
    }

}
