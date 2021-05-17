package cofh.thermal.dynamics.inventory.container.device;

import cofh.core.inventory.container.TileContainer;
import cofh.thermal.dynamics.tileentity.device.DeviceFluidBufferTile;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static cofh.thermal.dynamics.init.TDynReferences.DEVICE_FLUID_BUFFER_CONTAINER;

public class DeviceFluidBufferContainer extends TileContainer {

    public final DeviceFluidBufferTile tile;

    public DeviceFluidBufferContainer(int windowId, World world, BlockPos pos, PlayerInventory inventory, PlayerEntity player) {

        super(DEVICE_FLUID_BUFFER_CONTAINER, windowId, world, pos, inventory, player);
        this.tile = (DeviceFluidBufferTile) world.getTileEntity(pos);

        bindPlayerInventory(inventory);
    }

}
