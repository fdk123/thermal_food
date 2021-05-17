package cofh.thermal.expansion.util.managers.machine;

import cofh.lib.fluid.IFluidStackAccess;
import cofh.lib.inventory.FalseIInventory;
import cofh.lib.inventory.IItemStackAccess;
import cofh.lib.util.ComparableItemStack;
import cofh.thermal.expansion.init.TExpRecipeTypes;
import cofh.thermal.lib.util.managers.AbstractManager;
import cofh.thermal.lib.util.managers.IRecipeManager;
import cofh.thermal.lib.util.recipes.IThermalInventory;
import cofh.thermal.lib.util.recipes.ThermalCatalyst;
import cofh.thermal.lib.util.recipes.ThermalRecipe;
import cofh.thermal.lib.util.recipes.internal.BaseMachineCatalyst;
import cofh.thermal.lib.util.recipes.internal.CatalyzedMachineRecipe;
import cofh.thermal.lib.util.recipes.internal.IMachineRecipe;
import cofh.thermal.lib.util.recipes.internal.IRecipeCatalyst;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.RecipeManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidStack;

import javax.annotation.Nullable;
import java.util.*;

import static java.util.Arrays.asList;

public class SmelterRecipeManager extends AbstractManager implements IRecipeManager {

    private static final SmelterRecipeManager INSTANCE = new SmelterRecipeManager();
    protected static final int DEFAULT_ENERGY = 3200;

    protected Object2ObjectOpenHashMap<SmelterMapWrapper, IMachineRecipe> recipeMap = new Object2ObjectOpenHashMap<>();
    protected Map<ComparableItemStack, IRecipeCatalyst> catalystMap = new Object2ObjectOpenHashMap<>();
    protected Set<ComparableItemStack> validItems = new ObjectOpenHashSet<>();

    protected int maxInputItems;
    protected int maxOutputItems;
    protected int maxOutputFluids;

    public static SmelterRecipeManager instance() {

        return INSTANCE;
    }

    private SmelterRecipeManager() {

        super(DEFAULT_ENERGY);
        this.maxInputItems = 3;
        this.maxOutputItems = 4;
        this.maxOutputFluids = 0;
    }

    public void addRecipe(ThermalRecipe recipe) {

        switch (recipe.getInputItems().size()) {
            case 1:
                for (ItemStack firstInput : recipe.getInputItems().get(0).getMatchingStacks()) {
                    addRecipe(recipe.getEnergy(), recipe.getXp(), Collections.singletonList(firstInput), recipe.getInputFluids(), recipe.getOutputItems(), recipe.getOutputItemChances(), recipe.getOutputFluids());
                }
                return;
            case 2:
                for (ItemStack firstInput : recipe.getInputItems().get(0).getMatchingStacks()) {
                    for (ItemStack secondInput : recipe.getInputItems().get(1).getMatchingStacks()) {
                        addRecipe(recipe.getEnergy(), recipe.getXp(), asList(firstInput, secondInput), recipe.getInputFluids(), recipe.getOutputItems(), recipe.getOutputItemChances(), recipe.getOutputFluids());
                    }
                }
                return;
            case 3:
                for (ItemStack firstInput : recipe.getInputItems().get(0).getMatchingStacks()) {
                    for (ItemStack secondInput : recipe.getInputItems().get(1).getMatchingStacks()) {
                        for (ItemStack thirdInput : recipe.getInputItems().get(2).getMatchingStacks()) {
                            addRecipe(recipe.getEnergy(), recipe.getXp(), asList(firstInput, secondInput, thirdInput), recipe.getInputFluids(), recipe.getOutputItems(), recipe.getOutputItemChances(), recipe.getOutputFluids());
                        }
                    }
                }
                return;
            default:
        }
    }

    public boolean validItem(ItemStack item) {

        return validItems.contains(convert(item));
    }

    protected void clear() {

        recipeMap.clear();
        catalystMap.clear();
        validItems.clear();
    }

    // region RECIPES
    protected IMachineRecipe getRecipe(List<? extends IItemStackAccess> inputSlots, List<? extends IFluidStackAccess> inputTanks) {

        if (inputSlots.isEmpty()) {
            return null;
        }
        List<ComparableItemStack> convertedItems = new ArrayList<>(maxInputItems);
        for (int i = 0; i < maxInputItems; ++i) {
            if (!inputSlots.get(i).isEmpty()) {
                ComparableItemStack compStack = convert(inputSlots.get(i).getItemStack());
                convertedItems.add(compStack);
            }
        }
        if (convertedItems.isEmpty()) {
            return null;
        }
        return recipeMap.get(new SmelterMapWrapper(convertedItems));
    }

    protected IMachineRecipe addRecipe(int energy, float experience, List<ItemStack> inputItems, List<FluidStack> inputFluids, List<ItemStack> outputItems, List<Float> chance, List<FluidStack> outputFluids) {

        if (inputItems.isEmpty() || outputItems.isEmpty() && outputFluids.isEmpty() || outputItems.size() > maxOutputItems || outputFluids.size() > maxOutputFluids || energy <= 0) {
            return null;
        }
        for (ItemStack stack : inputItems) {
            if (stack.isEmpty()) {
                return null;
            }
        }
        for (ItemStack stack : outputItems) {
            if (stack.isEmpty()) {
                return null;
            }
        }
        for (FluidStack stack : outputFluids) {
            if (stack.isEmpty()) {
                return null;
            }
        }
        energy = (int) (energy * getDefaultScale());

        List<ComparableItemStack> convertedItems = new ArrayList<>(inputItems.size());
        for (ItemStack stack : inputItems) {
            if (!inputItems.isEmpty()) {
                ComparableItemStack compStack = convert(stack);
                validItems.add(compStack);
                convertedItems.add(compStack);
            }
        }
        InternalSmelterRecipe recipe = new InternalSmelterRecipe(energy, experience, inputItems, inputFluids, outputItems, chance, outputFluids);
        recipeMap.put(new SmelterMapWrapper(convertedItems), recipe);
        return recipe;
    }
    // endregion

    public List<ItemStack> getCatalysts() {

        List<ItemStack> ret = new ArrayList<>(catalystMap.size());
        catalystMap.keySet().forEach(stack -> ret.add(stack.toItemStack()));
        return ret;
    }

    // region CATALYSTS
    public IRecipeCatalyst getCatalyst(IItemStackAccess input) {

        return catalystMap.get(convert(input.getItemStack()));
    }

    public IRecipeCatalyst getCatalyst(ItemStack input) {

        return catalystMap.get(convert(input));
    }

    public void addCatalyst(ThermalCatalyst catalyst) {

        for (ItemStack ingredient : catalyst.getIngredient().getMatchingStacks()) {
            addCatalyst(ingredient, catalyst.getPrimaryMod(), catalyst.getSecondaryMod(), catalyst.getEnergyMod(), catalyst.getMinChance(), catalyst.getUseChance());
        }
    }

    public IRecipeCatalyst addCatalyst(ItemStack input, float primaryMod, float secondaryMod, float energyMod, float minChance, float useChance) {

        if (input == null || input.isEmpty()) {
            return null;
        }
        BaseMachineCatalyst catalyst = new BaseMachineCatalyst(primaryMod, secondaryMod, energyMod, minChance, useChance);
        catalystMap.put(convert(input), catalyst);
        return catalyst;
    }

    public boolean validCatalyst(ItemStack input) {

        return getCatalyst(input) != null;
    }

    public IRecipeCatalyst removeCatalyst(ItemStack input) {

        return catalystMap.remove(convert(input));
    }
    // endregion

    // region IRecipeManager
    @Override
    public IMachineRecipe getRecipe(IThermalInventory inventory) {

        return getRecipe(inventory.inputSlots(), inventory.inputTanks());
    }

    @Override
    public List<IMachineRecipe> getRecipeList() {

        return new ArrayList<>(recipeMap.values());
    }
    // endregion

    // region IManager
    @Override
    public void config() {

    }

    @Override
    public void refresh(RecipeManager recipeManager) {

        clear();
        Map<ResourceLocation, IRecipe<FalseIInventory>> recipes = recipeManager.getRecipes(TExpRecipeTypes.RECIPE_SMELTER);
        for (Map.Entry<ResourceLocation, IRecipe<FalseIInventory>> entry : recipes.entrySet()) {
            addRecipe((ThermalRecipe) entry.getValue());
        }
        Map<ResourceLocation, IRecipe<FalseIInventory>> catalysts = recipeManager.getRecipes(TExpRecipeTypes.CATALYST_SMELTER);
        for (Map.Entry<ResourceLocation, IRecipe<FalseIInventory>> entry : catalysts.entrySet()) {
            addCatalyst((ThermalCatalyst) entry.getValue());
        }
    }
    // endregion

    // region WRAPPER CLASS
    protected static class SmelterMapWrapper {

        Set<Integer> itemHashes;
        int hashCode;

        SmelterMapWrapper(List<ComparableItemStack> itemStacks) {

            this.itemHashes = new ObjectOpenHashSet<>(itemStacks.size());
            for (ComparableItemStack itemStack : itemStacks) {
                if (itemStack.hashCode() != 0) {
                    this.itemHashes.add(itemStack.hashCode());
                    hashCode += itemStack.hashCode();
                }
            }
        }

        @Override
        public boolean equals(Object o) {

            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            SmelterMapWrapper that = (SmelterMapWrapper) o;
            return itemHashes.size() == that.itemHashes.size() && itemHashes.containsAll(that.itemHashes);
        }

        @Override
        public int hashCode() {

            return hashCode;
        }

    }
    // endregion

    // region CATALYZED RECIPE
    protected static class InternalSmelterRecipe extends CatalyzedMachineRecipe {

        public InternalSmelterRecipe(int energy, float experience, @Nullable List<ItemStack> inputItems, @Nullable List<FluidStack> inputFluids, @Nullable List<ItemStack> outputItems, @Nullable List<Float> chance, @Nullable List<FluidStack> outputFluids) {

            super(3, energy, experience, inputItems, inputFluids, outputItems, chance, outputFluids);
        }

        @Override
        public IRecipeCatalyst getCatalyst(ItemStack input) {

            return instance().getCatalyst(input);
        }

    }
    // endregion
}