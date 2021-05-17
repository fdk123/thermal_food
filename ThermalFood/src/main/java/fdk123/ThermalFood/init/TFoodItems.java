package fdk123.ThermalFood.init;
import static cofh.thermal.core.ThermalCore.ITEMS;
import static cofh.thermal.core.util.RegistrationHelper.registerCropAndSeed;
import static cofh.thermal.cultivation.init.TCulFoods.COFFEE;
import static cofh.thermal.cultivation.init.TCulIDs.ID_COFFEE;
import static cofh.thermal.cultivation.init.TCulIDs.ID_TEA;
import cofh.core.item.ItemCoFH;
import static cofh.thermal.lib.common.ThermalItemGroups.THERMAL_ITEMS;
import static fdk123.ThermalFood.init.TFoodFoods.*;
import static fdk123.ThermalFood.init.TFoodIDs.*;
import fdk123.ThermalFood.data.TFoodGroup;
import fdk123.ThermalFood.data.TFoodIcon;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.world.World;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class TFoodItems {
    public static final DeferredRegister<Item> ITEM = DeferredRegister.create(ForgeRegistries.ITEMS, "thermal_food");
    public static final ItemGroup THERMAL_FOODS = new TFoodGroup("thermal_food", () -> new ItemStack(TFoodIcon.SHAVERMA));

    //fdk123 food
    //public static final RegistryObject<Item> = ITEM.register(ID_, () -> new Item(new Item.Properties().group(THERMAL_FOODS).food( ).rarity(Rarity.UNCOMMON)));
    //CHEESE
    public static final RegistryObject<Item> SULGUNI_CHEESE = ITEM.register(ID_SULGUNI_CHEESE, () -> new Item(new Item.Properties().group(THERMAL_FOODS).food(TFoodFoods.SULGUNI_CHEESE).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> ADYGHE_CHEESE = ITEM.register(ID_ADYGHE_CHEESE, () -> new Item(new Item.Properties().group(THERMAL_FOODS).food(TFoodFoods.ADYGHE_CHEESE).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> FETA_CHEESE = ITEM.register(ID_FETA_CHEESE, () -> new Item(new Item.Properties().group(THERMAL_FOODS).food(TFoodFoods.FETA_CHEESE).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> MOZZARELLA_CHEESE = ITEM.register(ID_MOZZARELLA_CHEESE, () -> new Item(new Item.Properties().group(THERMAL_FOODS).food(TFoodFoods.MOZZARELLA_CHEESE).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> SOUR_CREAM = ITEM.register(ID_SOUR_CREAM, () -> new Item(new Item.Properties().group(THERMAL_FOODS).food(TFoodFoods.SOUR_CREAM).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> MAYONNAISE = ITEM.register(ID_MAYONNAISE, () -> new Item(new Item.Properties().group(THERMAL_FOODS).food(TFoodFoods.MAYONNAISE).rarity(Rarity.UNCOMMON)));

    //PIE
    public static final RegistryObject<Item> KHACHAPURI = ITEM.register(ID_KHACHAPURI, () -> new Item(new Item.Properties().group(THERMAL_FOODS).food(TFoodFoods.KHACHAPURI).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> KULEBYAKA_WITH_MEAT = ITEM.register(ID_KULEBYAKA_WITH_MEAT, () -> new Item(new Item.Properties().group(THERMAL_FOODS).food(TFoodFoods.KULEBYAKA_WITH_MEAT).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> KULEBYAKA_WITH_COD = ITEM.register(ID_KULEBYAKA_WITH_COD, () -> new Item(new Item.Properties().group(THERMAL_FOODS).food(TFoodFoods.KULEBYAKA_WITH_COD).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> KULEBYAKA_WITH_SALMON = ITEM.register(ID_KULEBYAKA_WITH_SALMON, () -> new Item(new Item.Properties().group(THERMAL_FOODS).food(TFoodFoods.KULEBYAKA_WITH_SALMON).rarity(Rarity.UNCOMMON)));

    //ICECREAM
    public static final RegistryObject<Item> ICECREAM = ITEM.register(ID_ICECREAM, () -> new Item(new Item.Properties().group(THERMAL_FOODS).food(TFoodFoods.ICECREAM).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> ICECREAM_WITH_SWEET_BERRIES = ITEM.register(ID_ICECREAM_WITH_SWEET_BERRIES, () -> new Item(new Item.Properties().group(THERMAL_FOODS).food(TFoodFoods.ICECREAM_WITH_SWEET_BERRIES).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> ICECREAM_WITH_STRAWBERRY = ITEM.register(ID_ICECREAM_WITH_STRAWBERRY, () -> new Item(new Item.Properties().group(THERMAL_FOODS).food(TFoodFoods.ICECREAM_WITH_STRAWBERRY).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> ICECREAM_WITH_CHOCOLATE = ITEM.register(ID_ICECREAM_WITH_CHOCOLATE, () -> new Item(new Item.Properties().group(THERMAL_FOODS).food(TFoodFoods.ICECREAM_WITH_CHOCOLATE).rarity(Rarity.UNCOMMON)));

    //french
    public static final RegistryObject<Item> JULIENNE = ITEM.register(ID_JULIENNE, () -> new Item(new Item.Properties().maxStackSize(1).group(THERMAL_FOODS).food(TFoodFoods.JULIENNE).rarity(Rarity.UNCOMMON)) {

        @Override
        public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {

            ItemStack itemstack = super.onItemUseFinish(stack, worldIn, entityLiving);
            return entityLiving instanceof PlayerEntity && ((PlayerEntity) entityLiving).abilities.isCreativeMode ? itemstack : new ItemStack(Items.BOWL);
        }
    });
    public static final RegistryObject<Item> SALAD = ITEM.register(ID_SALAD, () -> new Item(new Item.Properties().maxStackSize(1).group(THERMAL_FOODS).food(TFoodFoods.SALAD).rarity(Rarity.UNCOMMON)) {

        @Override
        public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {

            ItemStack itemstack = super.onItemUseFinish(stack, worldIn, entityLiving);
            return entityLiving instanceof PlayerEntity && ((PlayerEntity) entityLiving).abilities.isCreativeMode ? itemstack : new ItemStack(Items.BOWL);
        }
    });
    public static final RegistryObject<Item> RICE_SALAD = ITEM.register(ID_RICE_SALAD, () -> new Item(new Item.Properties().maxStackSize(1).group(THERMAL_FOODS).food(TFoodFoods.RICE_SALAD).rarity(Rarity.UNCOMMON)) {

        @Override
        public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {

            ItemStack itemstack = super.onItemUseFinish(stack, worldIn, entityLiving);
            return entityLiving instanceof PlayerEntity && ((PlayerEntity) entityLiving).abilities.isCreativeMode ? itemstack : new ItemStack(Items.BOWL);
        }
    });

    //italian
    public static final RegistryObject<Item> PIZZA = ITEM.register(ID_PIZZA, () -> new Item(new Item.Properties().group(THERMAL_FOODS).food(TFoodFoods.PIZZA).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> PASTA = ITEM.register(ID_PASTA, () -> new Item(new Item.Properties().maxStackSize(1).group(THERMAL_FOODS).food(TFoodFoods.PASTA).rarity(Rarity.UNCOMMON)) {

        @Override
        public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {

            ItemStack itemstack = super.onItemUseFinish(stack, worldIn, entityLiving);
            return entityLiving instanceof PlayerEntity && ((PlayerEntity) entityLiving).abilities.isCreativeMode ? itemstack : new ItemStack(Items.BOWL);
        }
    });

    //asian
    public static final RegistryObject<Item> PITA = ITEM.register(ID_PITA, () -> new Item(new Item.Properties().group(THERMAL_FOODS).food(TFoodFoods.PITA).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> RICE_WITH_RABBIT = ITEM.register(ID_RICE_WITH_RABBIT, () -> new Item(new Item.Properties().maxStackSize(1).group(THERMAL_FOODS).food(TFoodFoods.RICE_WITH_RABBIT).rarity(Rarity.UNCOMMON)) {

        @Override
        public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {

            ItemStack itemstack = super.onItemUseFinish(stack, worldIn, entityLiving);
            return entityLiving instanceof PlayerEntity && ((PlayerEntity) entityLiving).abilities.isCreativeMode ? itemstack : new ItemStack(Items.BOWL);
        }
    });
    public static final RegistryObject<Item> RICE_WITH_CHICKEN = ITEM.register(ID_RICE_WITH_CHICKEN, () -> new Item(new Item.Properties().maxStackSize(1).group(THERMAL_FOODS).food(TFoodFoods.RICE_WITH_CHICKEN).rarity(Rarity.UNCOMMON)) {

        @Override
        public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {

            ItemStack itemstack = super.onItemUseFinish(stack, worldIn, entityLiving);
            return entityLiving instanceof PlayerEntity && ((PlayerEntity) entityLiving).abilities.isCreativeMode ? itemstack : new ItemStack(Items.BOWL);
        }
    });
    public static final RegistryObject<Item> SHAVERMA = ITEM.register(ID_SHAVERMA, () -> new Item(new Item.Properties().group(THERMAL_FOODS).food(TFoodFoods.SHAVERMA).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> PILAF = ITEM.register(ID_PILAF, () -> new Item(new Item.Properties().maxStackSize(1).group(THERMAL_FOODS).food(TFoodFoods.PILAF).rarity(Rarity.UNCOMMON)) {

        @Override
        public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {

            ItemStack itemstack = super.onItemUseFinish(stack, worldIn, entityLiving);
            return entityLiving instanceof PlayerEntity && ((PlayerEntity) entityLiving).abilities.isCreativeMode ? itemstack : new ItemStack(Items.BOWL);
        }
    });
    public static final RegistryObject<Item> SUSHI_ROLL = ITEM.register(ID_SUSHI_ROLL, () -> new Item(new Item.Properties().group(THERMAL_FOODS).food(TFoodFoods.SUSHI_ROLL).rarity(Rarity.UNCOMMON)));

    //drinks
    public static final RegistryObject<Item> BLACK_TEA = ITEM.register(ID_BLACK_TEA, () -> new Item(new Item.Properties().group(THERMAL_FOODS).food(TFoodFoods.BLACK_TEA).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> BLACK_TEA_WITH_BERRIES = ITEM.register(ID_BLACK_TEA_WITH_BERRIES, () -> new Item(new Item.Properties().group(THERMAL_FOODS).food(TFoodFoods.BLACK_TEA_WITH_BERRIES).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> COLD_TEA = ITEM.register(ID_COLD_TEA, () -> new Item(new Item.Properties().group(THERMAL_FOODS).food(TFoodFoods.COLD_TEA).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> COFFEE_CUP = ITEM.register(ID_COFFEE_CUP, () -> new Item(new Item.Properties().group(THERMAL_FOODS).food(TFoodFoods.COFFEE_CUP).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> ICED_COFFEE = ITEM.register(ID_ICED_COFFEE, () -> new Item(new Item.Properties().group(THERMAL_FOODS).food(TFoodFoods.ICED_COFFEE).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> CAPPUCCINO = ITEM.register(ID_CAPPUCCINO, () -> new Item(new Item.Properties().group(THERMAL_FOODS).food(TFoodFoods.CAPPUCCINO).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> CACAO = ITEM.register(ID_CACAO, () -> new Item(new Item.Properties().group(THERMAL_FOODS).food(TFoodFoods.CACAO).rarity(Rarity.UNCOMMON)));
    //fdk123 food end

    public static void register() {
        ITEM.register(FMLJavaModLoadingContext.get().getModEventBus());
        registerCrops();
    }

    private static void registerCrops() {
        registerCropAndSeed(ID_TEA);
        ITEMS.register(ID_COFFEE, () -> new ItemCoFH(new Item.Properties().group(THERMAL_ITEMS).food(COFFEE)));
    }

    private static void registerFoods() {


    }
}
