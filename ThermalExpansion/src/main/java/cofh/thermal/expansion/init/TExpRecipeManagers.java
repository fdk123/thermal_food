package cofh.thermal.expansion.init;

import cofh.thermal.expansion.util.managers.dynamo.*;
import cofh.thermal.expansion.util.managers.machine.*;

import static cofh.thermal.lib.common.ThermalRecipeManagers.registerManager;

public class TExpRecipeManagers {

    private TExpRecipeManagers() {

    }

    public static void register() {

        registerManager(FurnaceRecipeManager.instance());
        registerManager(SawmillRecipeManager.instance());
        registerManager(PulverizerRecipeManager.instance());
        registerManager(SmelterRecipeManager.instance());
        registerManager(InsolatorRecipeManager.instance());
        registerManager(CentrifugeRecipeManager.instance());
        registerManager(PressRecipeManager.instance());
        registerManager(CrucibleRecipeManager.instance());
        registerManager(ChillerRecipeManager.instance());
        registerManager(RefineryRecipeManager.instance());
        registerManager(PyrolyzerRecipeManager.instance());
        registerManager(BrewerRecipeManager.instance());
        registerManager(BottlerRecipeManager.instance());
        registerManager(CrafterRecipeManager.instance());

        registerManager(StirlingFuelManager.instance());
        registerManager(CompressionFuelManager.instance());
        registerManager(MagmaticFuelManager.instance());
        registerManager(NumismaticFuelManager.instance());
        registerManager(LapidaryFuelManager.instance());
    }

}
