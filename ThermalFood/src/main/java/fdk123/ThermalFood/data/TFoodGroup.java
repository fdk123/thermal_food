package fdk123.ThermalFood.data;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;


public class TFoodGroup extends ItemGroup{

    private final Supplier<ItemStack> iconSupplier;

    public TFoodGroup(final String name, final Supplier<ItemStack> iconSupplier) {
        super(name);
        this.iconSupplier = iconSupplier;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public ItemStack createIcon() {
        return iconSupplier.get();
    }

//    public static final ItemGroup THERMAL_FOODS = new ItemGroup(-1, "thermal_food") {
//
//        @Override
//        @OnlyIn(Dist.CLIENT)
//        public ItemStack createIcon() {
//
//            return new ItemStack();
//        }
//    };

}
