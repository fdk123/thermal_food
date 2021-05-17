package cofh.ensorcellation.enchantment;

import cofh.core.init.CoreEnchantments;
import cofh.lib.enchantment.EnchantmentCoFH;
import net.minecraft.inventory.EquipmentSlotType;

public class CavalierEnchantment extends EnchantmentCoFH {

    public static float damageMult = 0.5F;

    public CavalierEnchantment() {

        super(Rarity.UNCOMMON, CoreEnchantments.Types.SWORD_OR_AXE, new EquipmentSlotType[]{EquipmentSlotType.MAINHAND});
        maxLevel = 4;
    }

    @Override
    public int getMinEnchantability(int level) {

        return 5 + (level - 1) * 10;
    }

    @Override
    protected int maxDelegate(int level) {

        return getMinEnchantability(level) + 50;
    }

}
