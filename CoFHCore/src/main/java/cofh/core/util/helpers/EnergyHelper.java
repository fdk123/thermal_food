package cofh.core.util.helpers;

import cofh.lib.util.helpers.BlockHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.energy.CapabilityEnergy;

import static cofh.lib.util.constants.Constants.RF_PER_FURNACE_UNIT;

/**
 * This class contains helper functions related to Redstone Flux, aka the Forge Energy system.
 *
 * @author King Lemming
 */
public class EnergyHelper {

    private EnergyHelper() {

    }

    public static boolean validFurnaceFuel(ItemStack input) {

        return getEnergyFurnaceFuel(input) > 0;
    }

    public static int getEnergyFurnaceFuel(ItemStack stack) {

        return ForgeHooks.getBurnTime(stack) * RF_PER_FURNACE_UNIT;
    }

    public static boolean hasEnergyHandlerCap(ItemStack item) {

        return !item.isEmpty() && item.getCapability(CapabilityEnergy.ENERGY).isPresent();
    }

    // region BLOCK TRANSFER
    public static void insertIntoAdjacent(TileEntity tile, int amount, Direction side) {

        TileEntity adjTile = BlockHelper.getAdjacentTileEntity(tile, side);
        Direction opposite = side.getOpposite();

        if (adjTile != null) {
            adjTile.getCapability(CapabilityEnergy.ENERGY, opposite).ifPresent(e -> e.receiveEnergy(amount, false));
        }
    }
    // endregion
}
