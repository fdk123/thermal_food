package cofh.ensorcellation.enchantment.override;

import cofh.core.init.CoreEnchantments;
import cofh.lib.enchantment.EnchantmentOverride;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;

public class KnockbackEnchantmentImp extends EnchantmentOverride {

    public KnockbackEnchantmentImp() {

        super(Rarity.UNCOMMON, EnchantmentType.WEAPON, new EquipmentSlotType[]{EquipmentSlotType.MAINHAND});
        maxLevel = 2;
    }

    @Override
    public int getMinEnchantability(int level) {

        return 5 + 20 * (level - 1);
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack) {

        if (!enable) {
            return super.canApplyAtEnchantingTable(stack);
        }
        return CoreEnchantments.Types.SWORD_OR_AXE.canEnchantItem(stack.getItem()) || supportsEnchantment(stack);
    }

}
