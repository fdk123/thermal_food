package cofh.thermal.core.init;

import cofh.thermal.core.util.managers.device.PotionDiffuserManager;
import cofh.thermal.core.util.managers.device.RockGenManager;
import cofh.thermal.core.util.managers.device.TreeExtractorManager;

import static cofh.thermal.lib.common.ThermalRecipeManagers.registerManager;

public class TCoreRecipeManagers {

    private TCoreRecipeManagers() {

    }

    public static void register() {

        registerManager(TreeExtractorManager.instance());
        registerManager(RockGenManager.instance());
        registerManager(PotionDiffuserManager.instance());
    }

}
