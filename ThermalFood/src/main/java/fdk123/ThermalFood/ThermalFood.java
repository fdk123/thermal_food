package fdk123.ThermalFood;

import fdk123.ThermalFood.init.TFoodItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


@Mod("thermal_food")
public class ThermalFood {

    public static final String MOD_ID = "thermal_food";

    public ThermalFood() {

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        TFoodItems.register(modEventBus);

    }
}
