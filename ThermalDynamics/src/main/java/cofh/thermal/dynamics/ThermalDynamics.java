package cofh.thermal.dynamics;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static cofh.lib.util.constants.Constants.ID_THERMAL_DYNAMICS;
import static cofh.thermal.core.init.TCoreIDs.ID_DEVICE_COLLECTOR;
import static cofh.thermal.core.init.TCoreIDs.ID_DEVICE_NULLIFIER;
import static cofh.thermal.lib.common.ThermalFlags.FLAG_XP_STORAGE_AUGMENT;
import static cofh.thermal.lib.common.ThermalFlags.setFlag;

@Mod(ID_THERMAL_DYNAMICS)
public class ThermalDynamics {

    public ThermalDynamics() {

        setFeatureFlags();

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    }

    private void setFeatureFlags() {

        setFlag(ID_DEVICE_COLLECTOR, true);
        setFlag(ID_DEVICE_NULLIFIER, true);

        setFlag(FLAG_XP_STORAGE_AUGMENT, true);
    }

}
