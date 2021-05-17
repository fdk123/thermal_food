package cofh.thermal.lib.util.managers;

import net.minecraft.item.crafting.RecipeManager;

public interface IManager {

    void config();

    void refresh(RecipeManager recipeManager);

}
