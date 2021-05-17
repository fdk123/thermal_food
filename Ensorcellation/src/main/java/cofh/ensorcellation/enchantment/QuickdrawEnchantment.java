package cofh.ensorcellation.enchantment;

import cofh.lib.enchantment.EnchantmentCoFH;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;

import static cofh.lib.util.helpers.ArcheryHelper.validBow;

public class QuickdrawEnchantment extends EnchantmentCoFH {

    public QuickdrawEnchantment() {

        super(Rarity.UNCOMMON, EnchantmentType.BOW, new EquipmentSlotType[]{EquipmentSlotType.MAINHAND});
        maxLevel = 3;
    }

    @Override
    public int getMinEnchantability(int level) {

        return 12 + (level - 1) * 20;
    }

    @Override
    protected int maxDelegate(int level) {

        return getMinEnchantability(level) + 50;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack) {

        return enable && (stack.canApplyAtEnchantingTable(this) || validBow(stack) || supportsEnchantment(stack));
    }

}
