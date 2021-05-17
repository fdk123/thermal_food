package cofh.thermal.expansion.util.recipes.machine;

import cofh.thermal.expansion.init.TExpRecipeTypes;
import cofh.thermal.lib.util.recipes.ThermalCatalyst;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

import static cofh.thermal.core.ThermalCore.RECIPE_SERIALIZERS;
import static cofh.thermal.expansion.init.TExpRecipeTypes.ID_CATALYST_INSOLATOR;

public class InsolatorCatalyst extends ThermalCatalyst {

    public InsolatorCatalyst(ResourceLocation recipeId, Ingredient ingredient, float primaryMod, float secondaryMod, float energyMod, float minChance, float useChance) {

        super(recipeId, ingredient, primaryMod, secondaryMod, energyMod, minChance, useChance);
    }

    @Nonnull
    @Override
    public IRecipeSerializer<?> getSerializer() {

        return RECIPE_SERIALIZERS.get(ID_CATALYST_INSOLATOR);
    }

    @Nonnull
    @Override
    public IRecipeType<?> getType() {

        return TExpRecipeTypes.CATALYST_INSOLATOR;
    }

}
