package cofh.thermal.core.init;

import cofh.lib.util.recipes.SerializableRecipeType;
import cofh.thermal.core.util.recipes.device.PotionDiffuserBoost;
import cofh.thermal.core.util.recipes.device.RockGenMapping;
import cofh.thermal.core.util.recipes.device.TreeExtractorBoost;
import cofh.thermal.core.util.recipes.device.TreeExtractorMapping;
import net.minecraft.util.ResourceLocation;

import static cofh.lib.util.constants.Constants.ID_THERMAL;

public class TCoreRecipeTypes {

    private TCoreRecipeTypes() {

    }

    public static void register() {

        // TODO: Convert when a ForgeRegistry is added.
        // Recipes are self-registered as they do not currently have a proper Forge Registry.
        MAPPING_TREE_EXTRACTOR.register();
        BOOST_TREE_EXTRACTOR.register();
        MAPPING_ROCK_GEN.register();
        BOOST_POTION_DIFFUSER.register();
    }

    // region RECIPES
    public static final ResourceLocation ID_MAPPING_TREE_EXTRACTOR = new ResourceLocation(ID_THERMAL, "tree_extractor");
    public static final ResourceLocation ID_BOOST_TREE_EXTRACTOR = new ResourceLocation(ID_THERMAL, "tree_extractor_boost");
    public static final ResourceLocation ID_MAPPING_ROCK_GEN = new ResourceLocation(ID_THERMAL, "rock_gen");
    public static final ResourceLocation ID_BOOST_POTION_DIFFUSER = new ResourceLocation(ID_THERMAL, "potion_diffuser_boost");

    public static final SerializableRecipeType<TreeExtractorMapping> MAPPING_TREE_EXTRACTOR = new SerializableRecipeType<>(ID_MAPPING_TREE_EXTRACTOR);
    public static final SerializableRecipeType<TreeExtractorBoost> BOOST_TREE_EXTRACTOR = new SerializableRecipeType<>(ID_BOOST_TREE_EXTRACTOR);
    public static final SerializableRecipeType<RockGenMapping> MAPPING_ROCK_GEN = new SerializableRecipeType<>(ID_MAPPING_ROCK_GEN);
    public static final SerializableRecipeType<PotionDiffuserBoost> BOOST_POTION_DIFFUSER = new SerializableRecipeType<>(ID_BOOST_POTION_DIFFUSER);
    // endregion
}
