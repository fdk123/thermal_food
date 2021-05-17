package cofh.ensorcellation.enchantment.override;

import cofh.lib.enchantment.EnchantmentOverride;
import cofh.lib.util.helpers.MathHelper;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.HorseArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.world.World;
import net.minecraftforge.common.util.BlockSnapshot;
import net.minecraftforge.event.ForgeEventFactory;

import static cofh.lib.util.constants.Constants.ID_ENSORCELLATION;
import static cofh.lib.util.references.CoreReferences.GLOSSED_MAGMA;

public class FrostWalkerEnchantmentImp extends EnchantmentOverride {

    private static boolean freezeLava = true;

    public FrostWalkerEnchantmentImp() {

        super(Rarity.RARE, EnchantmentType.ARMOR_FEET, new EquipmentSlotType[]{EquipmentSlotType.FEET});
        maxLevel = 2;
        treasureEnchantment = true;
    }

    @Override
    public int getMinEnchantability(int level) {

        return level * 10;
    }

    @Override
    public int getMaxEnchantability(int level) {

        return getMinEnchantability(level) + 15;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack) {

        if (!enable) {
            return super.canApplyAtEnchantingTable(stack);
        }
        return super.canApplyAtEnchantingTable(stack) || stack.getItem() instanceof HorseArmorItem;
    }

    @Override
    public boolean canApplyTogether(Enchantment ench) {

        return super.canApplyTogether(ench) && ench != Enchantments.DEPTH_STRIDER;
    }

    // region HELPERS
    public static void freezeNearby(LivingEntity living, World worldIn, BlockPos pos, int level) {

        if (!freezeLava) {
            return;
        }
        if (living.isOnGround() && GLOSSED_MAGMA != null) {
            BlockState state = GLOSSED_MAGMA.getDefaultState();
            float f = (float) Math.min(16, 2 + level);
            BlockPos.Mutable mutable = new BlockPos.Mutable();

            for (BlockPos blockpos : BlockPos.getAllInBoxMutable(pos.add(-f, -1.0D, -f), pos.add(f, -1.0D, f))) {
                if (blockpos.withinDistance(living.getPositionVec(), f)) {
                    mutable.setPos(blockpos.getX(), blockpos.getY() + 1, blockpos.getZ());
                    BlockState blockstate1 = worldIn.getBlockState(mutable);
                    if (blockstate1.isAir(worldIn, mutable)) {
                        BlockState blockstate2 = worldIn.getBlockState(blockpos);
                        boolean isFull = blockstate2.getBlock() == Blocks.LAVA && blockstate2.get(FlowingFluidBlock.LEVEL) == 0;
                        if (blockstate2.getMaterial() == Material.LAVA && isFull && state.isValidPosition(worldIn, blockpos) && worldIn.placedBlockCollides(state, blockpos, ISelectionContext.dummy()) && !ForgeEventFactory.onBlockPlace(living, BlockSnapshot.create(worldIn.getDimensionKey(), worldIn, blockpos), net.minecraft.util.Direction.UP)) {
                            worldIn.setBlockState(blockpos, state);
                            worldIn.getPendingBlockTicks().scheduleTick(blockpos, GLOSSED_MAGMA, MathHelper.nextInt(living.getRNG(), 60, 120));
                        }
                    }
                }
            }
        }
    }

    public void setFreezeLava(boolean freezeLava) {

        FrostWalkerEnchantmentImp.freezeLava = freezeLava;
        name = "enchantment." + (freezeLava ? ID_ENSORCELLATION + ".frost_walker" : "minecraft.frost_walker");
    }
    // endregion
}