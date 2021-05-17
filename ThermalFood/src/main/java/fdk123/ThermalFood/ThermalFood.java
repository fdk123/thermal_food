package fdk123.ThermalFood;

import fdk123.ThermalFood.init.TFoodItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import static fdk123.ThermalFood.init.TFoodItems.ITEM;


@Mod("thermal_food")
public class ThermalFood {


    public ThermalFood() {

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);

//        ITEM.register(modEventBus);
        TFoodItems.register();

    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void clientSetup(final FMLClientSetupEvent event) {


    }
}
