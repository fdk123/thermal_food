package cofh.ensorcellation.enchantment;

import cofh.core.init.CoreEnchantments;
import cofh.lib.enchantment.DamageEnchantmentCoFH;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.monster.EndermiteEntity;
import net.minecraft.entity.monster.ShulkerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.potion.EffectInstance;

import static cofh.lib.util.references.CoreReferences.ENDERFERENCE;

public class DamageEnderEnchantment extends DamageEnchantmentCoFH {

    public DamageEnderEnchantment() {

        super(Rarity.UNCOMMON, CoreEnchantments.Types.SWORD_OR_AXE, new EquipmentSlotType[]{EquipmentSlotType.MAINHAND});
        maxLevel = 5;
    }

    @Override
    public void onEntityDamaged(LivingEntity user, Entity target, int level) {

        // Should never actually happen.
        if (ENDERFERENCE == null) {
            return;
        }
        if (target instanceof LivingEntity) {
            LivingEntity living = (LivingEntity) target;
            int i = 100 + user.getRNG().nextInt(40 * level);
            living.addPotionEffect(new EffectInstance(ENDERFERENCE, i, 0, false, false));
        }
    }

    public static boolean validTarget(Entity entity) {

        return entity instanceof EndermanEntity || entity instanceof EndermiteEntity || entity instanceof EnderDragonEntity || entity instanceof ShulkerEntity;
    }

}
