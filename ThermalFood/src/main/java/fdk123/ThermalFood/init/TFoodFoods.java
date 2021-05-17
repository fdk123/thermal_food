package fdk123.ThermalFood.init;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;

import static net.minecraft.potion.Effects.*;
import static net.minecraft.potion.Effects.HEALTH_BOOST;

public class TFoodFoods {

    //fdk123 food
    //TODO check effects please
    //public static final Food  = new Food.Builder().hunger(7).saturation(0.8F).setAlwaysEdible().build();
    //CHEESE
    public static final Food SULGUNI_CHEESE = new Food.Builder().hunger(3).saturation(0.3F).build();
    public static final Food ADYGHE_CHEESE = new Food.Builder().hunger(3).saturation(0.3F).build();
    public static final Food FETA_CHEESE = new Food.Builder().hunger(3).saturation(0.3F).build();
    public static final Food MOZZARELLA_CHEESE = new Food.Builder().hunger(3).saturation(0.3F).build();
    public static final Food SOUR_CREAM = new Food.Builder().hunger(2).saturation(0.1F).build();
    public static final Food MAYONNAISE = new Food.Builder().hunger(2).saturation(0.1F)
            .effect(() -> new EffectInstance(NAUSEA, 100, 1), 1.0F)
            .build();

    //PIE
    public static final Food KHACHAPURI = new Food.Builder().hunger(8).saturation(0.8F)
            .effect(() -> new EffectInstance(HEALTH_BOOST, 1000, 1), 1.0F)
            .setAlwaysEdible().build();
    public static final Food KULEBYAKA_WITH_MEAT = new Food.Builder().hunger(10).saturation(0.8F)
            .effect(() -> new EffectInstance(HEALTH_BOOST, 1000, 1), 1.0F)
            .setAlwaysEdible().build();
    public static final Food KULEBYAKA_WITH_COD = new Food.Builder().hunger(8).saturation(0.8F)
            .effect(() -> new EffectInstance(HEALTH_BOOST, 1000, 1), 1.0F)
            .setAlwaysEdible().build();
    public static final Food KULEBYAKA_WITH_SALMON = new Food.Builder().hunger(8).saturation(0.8F)
            .effect(() -> new EffectInstance(HEALTH_BOOST, 1000, 1), 1.0F)
            .setAlwaysEdible().build();

    //ICECREAM
    public static final Food ICECREAM = new Food.Builder().hunger(2).saturation(0.2F)
            .effect(() -> new EffectInstance(FIRE_RESISTANCE, 150, 1), 1.0F)
            .setAlwaysEdible().build();
    public static final Food ICECREAM_WITH_SWEET_BERRIES = new Food.Builder().hunger(4).saturation(0.3F)
            .effect(() -> new EffectInstance(FIRE_RESISTANCE, 300, 2), 1.0F)
            .setAlwaysEdible().build();
    public static final Food ICECREAM_WITH_STRAWBERRY = new Food.Builder().hunger(4).saturation(0.3F)
            .effect(() -> new EffectInstance(FIRE_RESISTANCE, 300, 2), 1.0F)
            .setAlwaysEdible().build();
    public static final Food ICECREAM_WITH_CHOCOLATE = new Food.Builder().hunger(4).saturation(0.3F)
            .effect(() -> new EffectInstance(FIRE_RESISTANCE, 300, 2), 1.0F)
            .setAlwaysEdible().build();

    //french
    public static final Food JULIENNE = new Food.Builder().hunger(3).saturation(0.6F)
            .effect(() -> new EffectInstance(HEALTH_BOOST, 1000, 1), 1.0F)
            .setAlwaysEdible().build();
    public static final Food SALAD = new Food.Builder().hunger(3).saturation(0.4F).setAlwaysEdible().build();
    public static final Food RICE_SALAD = new Food.Builder().hunger(5).saturation(0.7F).setAlwaysEdible().build();

    //italian
    public static final Food PIZZA = new Food.Builder().hunger(8).saturation(0.6F)
            .effect(() -> new EffectInstance(STRENGTH, 1000, 1), 1.0F)
            .setAlwaysEdible().build();
    public static final Food PASTA = new Food.Builder().hunger(8).saturation(0.8F).setAlwaysEdible().build();

    //asian
    public static final Food PITA = new Food.Builder().hunger(1).saturation(0.8F).build();
    public static final Food RICE_WITH_RABBIT = new Food.Builder().hunger(10).saturation(0.8F).setAlwaysEdible().build();
    public static final Food RICE_WITH_CHICKEN = new Food.Builder().hunger(10).saturation(0.8F).setAlwaysEdible().build();
    public static final Food SHAVERMA = new Food.Builder().hunger(14).saturation(0.8F)
            .effect(() -> new EffectInstance(HEALTH_BOOST, 1000, 5), 1.0F)
            .effect(() -> new EffectInstance(REGENERATION, 1000, 2), 1.0F)
            .effect(() -> new EffectInstance(RESISTANCE, 1000, 10), 1.0F)
            .setAlwaysEdible().build();
    public static final Food PILAF = new Food.Builder().hunger(20).saturation(1F)
            .effect(() -> new EffectInstance(HEALTH_BOOST, 1000, 2), 1.0F)
            .effect(() -> new EffectInstance(REGENERATION, 1000, 3), 1.0F)
            .effect(() -> new EffectInstance(SLOWNESS, 1000, 0), 1.0F)
            .effect(() -> new EffectInstance(STRENGTH, 1000, 1), 1.0F)
            .setAlwaysEdible().build();
    public static final Food SUSHI_ROLL = new Food.Builder().hunger(1).saturation(0.5F)
            .effect(() -> new EffectInstance(LUCK, 200, 1), 1.0F)
            .setAlwaysEdible().build();

    //drinks
    public static final Food BLACK_TEA = new Food.Builder().hunger(2).saturation(0.2F).setAlwaysEdible().build();
    public static final Food BLACK_TEA_WITH_BERRIES = new Food.Builder().hunger(2).saturation(0.2F).setAlwaysEdible().build();
    public static final Food COLD_TEA = new Food.Builder().hunger(2).saturation(0.2F)
            .effect(() -> new EffectInstance(FIRE_RESISTANCE, 150, 1), 1.0F)
            .setAlwaysEdible().build();
    public static final Food COFFEE_CUP = new Food.Builder().hunger(1).saturation(0.1F)
            .effect(() -> new EffectInstance(SPEED, 3000, 1), 1.0F)
            .effect(() -> new EffectInstance(HASTE, 3000, 1), 1.0F)
            .setAlwaysEdible().build();
    public static final Food ICED_COFFEE = new Food.Builder().hunger(1).saturation(0.1F)
            .effect(() -> new EffectInstance(FIRE_RESISTANCE, 660, 1), 1.0F)
            .effect(() -> new EffectInstance(SPEED, 1000, 1), 1.0F)
            .effect(() -> new EffectInstance(HASTE, 1000, 1), 1.0F)
            .setAlwaysEdible().build();
    public static final Food CAPPUCCINO = new Food.Builder().hunger(1).saturation(0.1F)
            .effect(() -> new EffectInstance(SPEED, 2000, 1), 1.0F)
            .effect(() -> new EffectInstance(HASTE, 2000, 1), 1.0F)
            .setAlwaysEdible().build();
    public static final Food CACAO = new Food.Builder().hunger(1).saturation(0.1F)
            .effect(() -> new EffectInstance(SPEED, 2000, 1), 1.0F)
            .effect(() -> new EffectInstance(HEALTH_BOOST, 1000, 1), 1.0F)
            .setAlwaysEdible().build();
}
