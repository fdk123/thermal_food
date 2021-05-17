package cofh.thermal.core.init;

import cofh.thermal.core.util.recipes.device.PotionDiffuserBoostSerializer;
import cofh.thermal.core.util.recipes.device.RockGenMappingSerializer;
import cofh.thermal.core.util.recipes.device.TreeExtractorBoostSerializer;
import cofh.thermal.core.util.recipes.device.TreeExtractorMappingSerializer;

import static cofh.thermal.core.ThermalCore.RECIPE_SERIALIZERS;
import static cofh.thermal.core.init.TCoreRecipeTypes.*;

public class TCoreRecipeSerializers {

    private TCoreRecipeSerializers() {

    }

    public static void register() {

        RECIPE_SERIALIZERS.register(ID_BOOST_TREE_EXTRACTOR, TreeExtractorBoostSerializer::new);
        RECIPE_SERIALIZERS.register(ID_MAPPING_TREE_EXTRACTOR, TreeExtractorMappingSerializer::new);
        RECIPE_SERIALIZERS.register(ID_MAPPING_ROCK_GEN, RockGenMappingSerializer::new);
        RECIPE_SERIALIZERS.register(ID_BOOST_POTION_DIFFUSER, PotionDiffuserBoostSerializer::new);
    }

}
