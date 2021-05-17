package cofh.ensorcellation.event;

import cofh.ensorcellation.enchantment.DisplacementEnchantment;
import cofh.ensorcellation.enchantment.FireRebukeEnchantment;
import cofh.ensorcellation.enchantment.FrostRebukeEnchantment;
import cofh.ensorcellation.enchantment.override.FrostWalkerEnchantmentImp;
import cofh.lib.util.helpers.MathHelper;
import net.minecraft.enchantment.FrostWalkerEnchantment;
import net.minecraft.enchantment.ThornsEnchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static cofh.lib.util.Utils.getItemEnchantmentLevel;
import static cofh.lib.util.constants.Constants.ID_ENSORCELLATION;
import static cofh.lib.util.references.EnsorcReferences.*;
import static net.minecraft.enchantment.Enchantments.*;

@Mod.EventBusSubscriber(modid = ID_ENSORCELLATION)
public class HorseEnchEvents {

    private static final int HORSE_MODIFIER = 3;

    private HorseEnchEvents() {

    }

    @SubscribeEvent
    public static void handleLivingAttackEvent(LivingAttackEvent event) {

        if (event.isCanceled()) {
            return;
        }
        LivingEntity entity = event.getEntityLiving();
        DamageSource source = event.getSource();
        Entity attacker = source.getTrueSource();

        if (!(entity instanceof AbstractHorseEntity)) {
            return;
        }
        ItemStack armor = ((AbstractHorseEntity) entity).horseChest.getStackInSlot(1);
        if (!armor.isEmpty()) {
            // FROST WALKER
            int encFrostWalker = getItemEnchantmentLevel(FROST_WALKER, armor);
            if (event.getSource().equals(DamageSource.HOT_FLOOR) && encFrostWalker > 0) {
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public static void handleLivingHurtEvent(LivingHurtEvent event) {

        if (event.isCanceled()) {
            return;
        }
        LivingEntity entity = event.getEntityLiving();
        DamageSource source = event.getSource();
        Entity attacker = source.getTrueSource();

        if (!(entity instanceof AbstractHorseEntity)) {
            return;
        }
        ItemStack armor = ((AbstractHorseEntity) entity).horseChest.getStackInSlot(1);
        if (!armor.isEmpty()) {
            int totalProtection = 0;
            // PROTECTION
            int encProtection = getItemEnchantmentLevel(PROTECTION, armor);
            if (encProtection > 0) {
                totalProtection += PROTECTION.calcModifierDamage(encProtection, source);
            }
            // FIRE PROTECTION
            int encProtectionFire = getItemEnchantmentLevel(FIRE_PROTECTION, armor);
            if (encProtectionFire > 0) {
                totalProtection += FIRE_PROTECTION.calcModifierDamage(encProtection, source);
            }
            // FEATHER FALLING
            int encProtectionFall = getItemEnchantmentLevel(FEATHER_FALLING, armor);
            if (encProtectionFall > 0) {
                totalProtection += FEATHER_FALLING.calcModifierDamage(encProtection, source);
            }
            // BLAST PROTECTION
            int encProtectionExplosion = getItemEnchantmentLevel(BLAST_PROTECTION, armor);
            if (encProtectionExplosion > 0) {
                totalProtection += BLAST_PROTECTION.calcModifierDamage(encProtection, source);
            }
            // PROJECTILE PROTECTION
            int encProtectionProjectile = getItemEnchantmentLevel(PROJECTILE_PROTECTION, armor);
            if (encProtectionProjectile > 0) {
                totalProtection += PROJECTILE_PROTECTION.calcModifierDamage(encProtection, source);
            }
            float damageReduction = Math.min(totalProtection * HORSE_MODIFIER, 20.0F);
            event.setAmount(event.getAmount() * (1.0F - damageReduction / 25.0F));

            if (attacker != null) {
                // THORNS
                int encThorns = getItemEnchantmentLevel(THORNS, armor);
                if (ThornsEnchantment.shouldHit(encThorns, entity.getRNG())) {
                    attacker.attackEntityFrom(DamageSource.causeThornsDamage(entity), ThornsEnchantment.getDamage(encThorns, MathHelper.RANDOM));
                }
                // DISPLACEMENT
                int encDisplacement = getItemEnchantmentLevel(DISPLACEMENT, armor);
                if (DisplacementEnchantment.shouldHit(encDisplacement, entity.getRNG())) {
                    DisplacementEnchantment.onHit(entity, attacker, encDisplacement);
                }
                // FIRE REBUKE
                int encFireRebuke = getItemEnchantmentLevel(FIRE_REBUKE, armor);
                if (FireRebukeEnchantment.shouldHit(encFireRebuke, entity.getRNG())) {
                    FireRebukeEnchantment.onHit(entity, attacker, encFireRebuke);
                }
                // FROST REBUKE
                int encFrostRebuke = getItemEnchantmentLevel(FROST_REBUKE, armor);
                if (FrostRebukeEnchantment.shouldHit(encFrostRebuke, entity.getRNG())) {
                    FrostRebukeEnchantment.onHit(entity, attacker, encFrostRebuke);
                }
            }
        }
    }

    @SubscribeEvent
    public static void handleLivingUpdateEvent(LivingEvent.LivingUpdateEvent event) {

        if (event.isCanceled()) {
            return;
        }
        LivingEntity entity = event.getEntityLiving();

        if (!(entity instanceof AbstractHorseEntity)) {
            return;
        }
        ItemStack armor = ((AbstractHorseEntity) entity).horseChest.getStackInSlot(1);
        if (!armor.isEmpty()) {
            // FROST WALKER
            int encFrostWalker = getItemEnchantmentLevel(FROST_WALKER, armor);
            if (encFrostWalker > 0) {
                FrostWalkerEnchantment.freezeNearby(entity, entity.world, entity.getPosition(), encFrostWalker);
                FrostWalkerEnchantmentImp.freezeNearby(entity, entity.world, entity.getPosition(), encFrostWalker);
            }
        }
    }

}