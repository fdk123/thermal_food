package fdk123.ThermalFood.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static fdk123.ThermalFood.ThermalFood.MOD_ID;
import static fdk123.ThermalFood.init.TFoodFoods.*;
import static fdk123.ThermalFood.init.TFoodIDs.*;

public class TFoodItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public static final RegistryObject<Item> SULGUNI_CHEESE = ITEMS.register(ID_SULGUNI_CHEESE, () -> food(SULGUNI_CHEESE_FOOD));
    public static final RegistryObject<Item> ADYGHE_CHEESE = ITEMS.register(ID_ADYGHE_CHEESE, () -> food(ADYGHE_CHEESE_FOOD));
    public static final RegistryObject<Item> FETA_CHEESE = ITEMS.register(ID_FETA_CHEESE, () -> food(FETA_CHEESE_FOOD));
    public static final RegistryObject<Item> MOZZARELLA_CHEESE = ITEMS.register(ID_MOZZARELLA_CHEESE, () -> food(MOZZARELLA_CHEESE_FOOD));
    public static final RegistryObject<Item> SOUR_CREAM = ITEMS.register(ID_SOUR_CREAM, () -> food(SOUR_CREAM_FOOD));
    public static final RegistryObject<Item> MAYONNAISE = ITEMS.register(ID_MAYONNAISE, () -> food(MAYONNAISE_FOOD));

    public static final RegistryObject<Item> KHACHAPURI = ITEMS.register(ID_KHACHAPURI, () -> food(KHACHAPURI_FOOD));
    public static final RegistryObject<Item> KULEBYAKA_WITH_MEAT = ITEMS.register(ID_KULEBYAKA_WITH_MEAT, () -> food(KULEBYAKA_WITH_MEAT_FOOD));
    public static final RegistryObject<Item> KULEBYAKA_WITH_COD = ITEMS.register(ID_KULEBYAKA_WITH_COD, () -> food(KULEBYAKA_WITH_COD_FOOD));
    public static final RegistryObject<Item> KULEBYAKA_WITH_SALMON = ITEMS.register(ID_KULEBYAKA_WITH_SALMON, () -> food(KULEBYAKA_WITH_SALMON_FOOD));

    public static final RegistryObject<Item> ICECREAM = ITEMS.register(ID_ICECREAM, () -> food(ICECREAM_FOOD));
    public static final RegistryObject<Item> ICECREAM_WITH_SWEET_BERRIES = ITEMS.register(ID_ICECREAM_WITH_SWEET_BERRIES, () -> food(ICECREAM_WITH_SWEET_BERRIES_FOOD));
    public static final RegistryObject<Item> ICECREAM_WITH_STRAWBERRY = ITEMS.register(ID_ICECREAM_WITH_STRAWBERRY, () -> food(ICECREAM_WITH_STRAWBERRY_FOOD));
    public static final RegistryObject<Item> ICECREAM_WITH_CHOCOLATE = ITEMS.register(ID_ICECREAM_WITH_CHOCOLATE, () -> food(ICECREAM_WITH_CHOCOLATE_FOOD));

    public static final RegistryObject<Item> JULIENNE = ITEMS.register(ID_JULIENNE, () -> bowlFood(JULIENNE_FOOD));
    public static final RegistryObject<Item> SALAD = ITEMS.register(ID_SALAD, () -> bowlFood(SALAD_FOOD));
    public static final RegistryObject<Item> RICE_SALAD = ITEMS.register(ID_RICE_SALAD, () -> bowlFood(RICE_SALAD_FOOD));

    public static final RegistryObject<Item> PIZZA = ITEMS.register(ID_PIZZA, () -> food(PIZZA_FOOD));
    public static final RegistryObject<Item> PASTA = ITEMS.register(ID_PASTA, () -> bowlFood(PASTA_FOOD));

    public static final RegistryObject<Item> PITA = ITEMS.register(ID_PITA, () -> food(PITA_FOOD));
    public static final RegistryObject<Item> RICE_WITH_RABBIT = ITEMS.register(ID_RICE_WITH_RABBIT, () -> bowlFood(RICE_WITH_RABBIT_FOOD));
    public static final RegistryObject<Item> RICE_WITH_CHICKEN = ITEMS.register(ID_RICE_WITH_CHICKEN, () -> bowlFood(RICE_WITH_CHICKEN_FOOD));
    public static final RegistryObject<Item> SHAVERMA = ITEMS.register(ID_SHAVERMA, () -> food(SHAVERMA_FOOD));
    public static final RegistryObject<Item> PILAF = ITEMS.register(ID_PILAF, () -> bowlFood(PILAF_FOOD));
    public static final RegistryObject<Item> SUSHI_ROLL = ITEMS.register(ID_SUSHI_ROLL, () -> food(SUSHI_ROLL_FOOD));

    public static final RegistryObject<Item> BLACK_TEA = ITEMS.register(ID_BLACK_TEA, () -> food(BLACK_TEA_FOOD));
    public static final RegistryObject<Item> BLACK_TEA_WITH_BERRIES = ITEMS.register(ID_BLACK_TEA_WITH_BERRIES, () -> food(BLACK_TEA_WITH_BERRIES_FOOD));
    public static final RegistryObject<Item> COLD_TEA = ITEMS.register(ID_COLD_TEA, () -> food(COLD_TEA_FOOD));
    public static final RegistryObject<Item> COFFEE_CUP = ITEMS.register(ID_COFFEE_CUP, () -> food(COFFEE_CUP_FOOD));
    public static final RegistryObject<Item> ICED_COFFEE = ITEMS.register(ID_ICED_COFFEE, () -> food(ICED_COFFEE_FOOD));
    public static final RegistryObject<Item> CAPPUCCINO = ITEMS.register(ID_CAPPUCCINO, () -> food(CAPPUCCINO_FOOD));
    public static final RegistryObject<Item> CACAO = ITEMS.register(ID_CACAO, () -> food(CACAO_FOOD));

    public static final RegistryObject<CreativeModeTab> THERMAL_FOODS = CREATIVE_TABS.register("thermal_food", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.thermal_food"))
            .icon(() -> new ItemStack(SHAVERMA.get()))
            .displayItems((parameters, output) -> {
                output.accept(SULGUNI_CHEESE.get());
                output.accept(ADYGHE_CHEESE.get());
                output.accept(FETA_CHEESE.get());
                output.accept(MOZZARELLA_CHEESE.get());
                output.accept(SOUR_CREAM.get());
                output.accept(MAYONNAISE.get());
                output.accept(KHACHAPURI.get());
                output.accept(KULEBYAKA_WITH_MEAT.get());
                output.accept(KULEBYAKA_WITH_COD.get());
                output.accept(KULEBYAKA_WITH_SALMON.get());
                output.accept(ICECREAM.get());
                output.accept(ICECREAM_WITH_SWEET_BERRIES.get());
                output.accept(ICECREAM_WITH_STRAWBERRY.get());
                output.accept(ICECREAM_WITH_CHOCOLATE.get());
                output.accept(JULIENNE.get());
                output.accept(SALAD.get());
                output.accept(RICE_SALAD.get());
                output.accept(PIZZA.get());
                output.accept(PASTA.get());
                output.accept(PITA.get());
                output.accept(RICE_WITH_RABBIT.get());
                output.accept(RICE_WITH_CHICKEN.get());
                output.accept(SHAVERMA.get());
                output.accept(PILAF.get());
                output.accept(SUSHI_ROLL.get());
                output.accept(BLACK_TEA.get());
                output.accept(BLACK_TEA_WITH_BERRIES.get());
                output.accept(COLD_TEA.get());
                output.accept(COFFEE_CUP.get());
                output.accept(ICED_COFFEE.get());
                output.accept(CAPPUCCINO.get());
                output.accept(CACAO.get());
            })
            .build());

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
        CREATIVE_TABS.register(modEventBus);
    }

    private static Item food(net.minecraft.world.food.FoodProperties food) {
        return new Item(new Item.Properties().food(food).rarity(Rarity.UNCOMMON));
    }

    private static Item bowlFood(net.minecraft.world.food.FoodProperties food) {
        return new BowlFoodItem(new Item.Properties().stacksTo(1).food(food).rarity(Rarity.UNCOMMON));
    }

    private static class BowlFoodItem extends Item {

        private BowlFoodItem(Properties properties) {
            super(properties);
        }

        @Override
        public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
            ItemStack result = super.finishUsingItem(stack, level, entity);
            return entity instanceof Player player && player.getAbilities().instabuild ? result : new ItemStack(Items.BOWL);
        }
    }
}
