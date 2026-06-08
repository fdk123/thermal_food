package fdk123.ThermalFood.init;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;

import static net.minecraft.world.effect.MobEffects.CONFUSION;
import static net.minecraft.world.effect.MobEffects.DAMAGE_BOOST;
import static net.minecraft.world.effect.MobEffects.DAMAGE_RESISTANCE;
import static net.minecraft.world.effect.MobEffects.DIG_SPEED;
import static net.minecraft.world.effect.MobEffects.FIRE_RESISTANCE;
import static net.minecraft.world.effect.MobEffects.HEALTH_BOOST;
import static net.minecraft.world.effect.MobEffects.LUCK;
import static net.minecraft.world.effect.MobEffects.MOVEMENT_SLOWDOWN;
import static net.minecraft.world.effect.MobEffects.MOVEMENT_SPEED;
import static net.minecraft.world.effect.MobEffects.REGENERATION;

public class TFoodFoods {

    public static final FoodProperties SULGUNI_CHEESE_FOOD = food(3, 0.3F).build();
    public static final FoodProperties ADYGHE_CHEESE_FOOD = food(3, 0.3F).build();
    public static final FoodProperties FETA_CHEESE_FOOD = food(3, 0.3F).build();
    public static final FoodProperties MOZZARELLA_CHEESE_FOOD = food(3, 0.3F).build();
    public static final FoodProperties SOUR_CREAM_FOOD = food(2, 0.1F).build();
    public static final FoodProperties MAYONNAISE_FOOD = food(2, 0.1F)
            .effect(() -> new MobEffectInstance(CONFUSION, 100, 1), 1.0F)
            .build();

    public static final FoodProperties KHACHAPURI_FOOD = food(8, 0.8F)
            .effect(() -> new MobEffectInstance(HEALTH_BOOST, 1000, 1), 1.0F)
            .alwaysEat().build();
    public static final FoodProperties KULEBYAKA_WITH_MEAT_FOOD = food(10, 0.8F)
            .effect(() -> new MobEffectInstance(HEALTH_BOOST, 1000, 1), 1.0F)
            .alwaysEat().build();
    public static final FoodProperties KULEBYAKA_WITH_COD_FOOD = food(8, 0.8F)
            .effect(() -> new MobEffectInstance(HEALTH_BOOST, 1000, 1), 1.0F)
            .alwaysEat().build();
    public static final FoodProperties KULEBYAKA_WITH_SALMON_FOOD = food(8, 0.8F)
            .effect(() -> new MobEffectInstance(HEALTH_BOOST, 1000, 1), 1.0F)
            .alwaysEat().build();

    public static final FoodProperties ICECREAM_FOOD = food(2, 0.2F)
            .effect(() -> new MobEffectInstance(FIRE_RESISTANCE, 150, 1), 1.0F)
            .alwaysEat().build();
    public static final FoodProperties ICECREAM_WITH_SWEET_BERRIES_FOOD = food(4, 0.3F)
            .effect(() -> new MobEffectInstance(FIRE_RESISTANCE, 300, 2), 1.0F)
            .alwaysEat().build();
    public static final FoodProperties ICECREAM_WITH_STRAWBERRY_FOOD = food(4, 0.3F)
            .effect(() -> new MobEffectInstance(FIRE_RESISTANCE, 300, 2), 1.0F)
            .alwaysEat().build();
    public static final FoodProperties ICECREAM_WITH_CHOCOLATE_FOOD = food(4, 0.3F)
            .effect(() -> new MobEffectInstance(FIRE_RESISTANCE, 300, 2), 1.0F)
            .alwaysEat().build();

    public static final FoodProperties JULIENNE_FOOD = food(3, 0.6F)
            .effect(() -> new MobEffectInstance(HEALTH_BOOST, 1000, 1), 1.0F)
            .alwaysEat().build();
    public static final FoodProperties SALAD_FOOD = food(3, 0.4F).alwaysEat().build();
    public static final FoodProperties RICE_SALAD_FOOD = food(5, 0.7F).alwaysEat().build();

    public static final FoodProperties PIZZA_FOOD = food(8, 0.6F)
            .effect(() -> new MobEffectInstance(DAMAGE_BOOST, 1000, 1), 1.0F)
            .alwaysEat().build();
    public static final FoodProperties PASTA_FOOD = food(8, 0.8F).alwaysEat().build();

    public static final FoodProperties PITA_FOOD = food(1, 0.8F).build();
    public static final FoodProperties RICE_WITH_RABBIT_FOOD = food(10, 0.8F).alwaysEat().build();
    public static final FoodProperties RICE_WITH_CHICKEN_FOOD = food(10, 0.8F).alwaysEat().build();
    public static final FoodProperties SHAVERMA_FOOD = food(14, 0.8F)
            .effect(() -> new MobEffectInstance(HEALTH_BOOST, 1000, 5), 1.0F)
            .effect(() -> new MobEffectInstance(REGENERATION, 1000, 2), 1.0F)
            .effect(() -> new MobEffectInstance(DAMAGE_RESISTANCE, 1000, 10), 1.0F)
            .alwaysEat().build();
    public static final FoodProperties PILAF_FOOD = food(20, 1.0F)
            .effect(() -> new MobEffectInstance(HEALTH_BOOST, 1000, 2), 1.0F)
            .effect(() -> new MobEffectInstance(REGENERATION, 1000, 3), 1.0F)
            .effect(() -> new MobEffectInstance(MOVEMENT_SLOWDOWN, 1000, 0), 1.0F)
            .effect(() -> new MobEffectInstance(DAMAGE_BOOST, 1000, 1), 1.0F)
            .alwaysEat().build();
    public static final FoodProperties SUSHI_ROLL_FOOD = food(1, 0.5F)
            .effect(() -> new MobEffectInstance(LUCK, 200, 1), 1.0F)
            .alwaysEat().build();

    public static final FoodProperties BLACK_TEA_FOOD = food(2, 0.2F).alwaysEat().build();
    public static final FoodProperties BLACK_TEA_WITH_BERRIES_FOOD = food(2, 0.2F).alwaysEat().build();
    public static final FoodProperties COLD_TEA_FOOD = food(2, 0.2F)
            .effect(() -> new MobEffectInstance(FIRE_RESISTANCE, 150, 1), 1.0F)
            .alwaysEat().build();
    public static final FoodProperties COFFEE_CUP_FOOD = food(1, 0.1F)
            .effect(() -> new MobEffectInstance(MOVEMENT_SPEED, 3000, 1), 1.0F)
            .effect(() -> new MobEffectInstance(DIG_SPEED, 3000, 1), 1.0F)
            .alwaysEat().build();
    public static final FoodProperties ICED_COFFEE_FOOD = food(1, 0.1F)
            .effect(() -> new MobEffectInstance(FIRE_RESISTANCE, 660, 1), 1.0F)
            .effect(() -> new MobEffectInstance(MOVEMENT_SPEED, 1000, 1), 1.0F)
            .effect(() -> new MobEffectInstance(DIG_SPEED, 1000, 1), 1.0F)
            .alwaysEat().build();
    public static final FoodProperties CAPPUCCINO_FOOD = food(1, 0.1F)
            .effect(() -> new MobEffectInstance(MOVEMENT_SPEED, 2000, 1), 1.0F)
            .effect(() -> new MobEffectInstance(DIG_SPEED, 2000, 1), 1.0F)
            .alwaysEat().build();
    public static final FoodProperties CACAO_FOOD = food(1, 0.1F)
            .effect(() -> new MobEffectInstance(MOVEMENT_SPEED, 2000, 1), 1.0F)
            .effect(() -> new MobEffectInstance(HEALTH_BOOST, 1000, 1), 1.0F)
            .alwaysEat().build();

    private static FoodProperties.Builder food(int nutrition, float saturation) {
        return new FoodProperties.Builder().nutrition(nutrition).saturationMod(saturation);
    }
}
