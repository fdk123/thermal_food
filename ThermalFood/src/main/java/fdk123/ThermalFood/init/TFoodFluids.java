package fdk123.ThermalFood.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static fdk123.ThermalFood.ThermalFood.MOD_ID;
import static fdk123.ThermalFood.init.TFoodIDs.*;

public class TFoodFluids {

    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, MOD_ID);
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, MOD_ID);

    public static final RegistryObject<FluidType> BLACK_TEA_TYPE = drinkType(ID_BLACK_TEA);
    public static final RegistryObject<FlowingFluid> BLACK_TEA = source(ID_BLACK_TEA, BLACK_TEA_TYPE);
    public static final RegistryObject<FlowingFluid> FLOWING_BLACK_TEA = flowing("flowing_" + ID_BLACK_TEA, BLACK_TEA_TYPE, ID_BLACK_TEA);

    public static final RegistryObject<FluidType> BLACK_TEA_WITH_BERRIES_TYPE = drinkType(ID_BLACK_TEA_WITH_BERRIES);
    public static final RegistryObject<FlowingFluid> BLACK_TEA_WITH_BERRIES = source(ID_BLACK_TEA_WITH_BERRIES, BLACK_TEA_WITH_BERRIES_TYPE);
    public static final RegistryObject<FlowingFluid> FLOWING_BLACK_TEA_WITH_BERRIES = flowing("flowing_" + ID_BLACK_TEA_WITH_BERRIES, BLACK_TEA_WITH_BERRIES_TYPE, ID_BLACK_TEA_WITH_BERRIES);

    public static final RegistryObject<FluidType> COLD_TEA_TYPE = drinkType(ID_COLD_TEA);
    public static final RegistryObject<FlowingFluid> COLD_TEA = source(ID_COLD_TEA, COLD_TEA_TYPE);
    public static final RegistryObject<FlowingFluid> FLOWING_COLD_TEA = flowing("flowing_" + ID_COLD_TEA, COLD_TEA_TYPE, ID_COLD_TEA);

    public static final RegistryObject<FluidType> COFFEE_CUP_TYPE = drinkType(ID_COFFEE_CUP);
    public static final RegistryObject<FlowingFluid> COFFEE_CUP = source(ID_COFFEE_CUP, COFFEE_CUP_TYPE);
    public static final RegistryObject<FlowingFluid> FLOWING_COFFEE_CUP = flowing("flowing_" + ID_COFFEE_CUP, COFFEE_CUP_TYPE, ID_COFFEE_CUP);

    public static final RegistryObject<FluidType> ICED_COFFEE_TYPE = drinkType(ID_ICED_COFFEE);
    public static final RegistryObject<FlowingFluid> ICED_COFFEE = source(ID_ICED_COFFEE, ICED_COFFEE_TYPE);
    public static final RegistryObject<FlowingFluid> FLOWING_ICED_COFFEE = flowing("flowing_" + ID_ICED_COFFEE, ICED_COFFEE_TYPE, ID_ICED_COFFEE);

    public static final RegistryObject<FluidType> CAPPUCCINO_TYPE = drinkType(ID_CAPPUCCINO);
    public static final RegistryObject<FlowingFluid> CAPPUCCINO = source(ID_CAPPUCCINO, CAPPUCCINO_TYPE);
    public static final RegistryObject<FlowingFluid> FLOWING_CAPPUCCINO = flowing("flowing_" + ID_CAPPUCCINO, CAPPUCCINO_TYPE, ID_CAPPUCCINO);

    public static final RegistryObject<FluidType> CACAO_TYPE = drinkType(ID_CACAO);
    public static final RegistryObject<FlowingFluid> CACAO = source(ID_CACAO, CACAO_TYPE);
    public static final RegistryObject<FlowingFluid> FLOWING_CACAO = flowing("flowing_" + ID_CACAO, CACAO_TYPE, ID_CACAO);

    public static void register(IEventBus modEventBus) {
        FLUID_TYPES.register(modEventBus);
        FLUIDS.register(modEventBus);
    }

    private static RegistryObject<FluidType> drinkType(String name) {
        return FLUID_TYPES.register(name, () -> new FluidType(FluidType.Properties.create()
                .descriptionId("fluid_type." + MOD_ID + "." + name)
                .canSwim(false)
                .canDrown(false)
                .density(1000)
                .viscosity(1000)
                .temperature(300)));
    }

    private static RegistryObject<FlowingFluid> source(String name, RegistryObject<FluidType> type) {
        return FLUIDS.register(name, () -> new ForgeFlowingFluid.Source(properties(type, name, "flowing_" + name)));
    }

    private static RegistryObject<FlowingFluid> flowing(String name, RegistryObject<FluidType> type, String sourceName) {
        return FLUIDS.register(name, () -> new ForgeFlowingFluid.Flowing(properties(type, sourceName, name)));
    }

    private static ForgeFlowingFluid.Properties properties(RegistryObject<FluidType> type, String still, String flowing) {
        return new ForgeFlowingFluid.Properties(type, fluid(still), fluid(flowing))
                .slopeFindDistance(2)
                .levelDecreasePerBlock(2)
                .tickRate(20);
    }

    private static java.util.function.Supplier<? extends Fluid> fluid(String name) {
        return () -> ForgeRegistries.FLUIDS.getValue(new ResourceLocation(MOD_ID, name));
    }
}
