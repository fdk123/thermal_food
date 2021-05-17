package cofh.thermal.dynamics.init;

import cofh.thermal.dynamics.inventory.container.device.DeviceFluidBufferContainer;
import cofh.thermal.dynamics.inventory.container.device.DeviceItemBufferContainer;
import cofh.thermal.dynamics.tileentity.device.DeviceFluidBufferTile;
import cofh.thermal.dynamics.tileentity.device.DeviceItemBufferTile;
import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

import static cofh.lib.util.constants.Constants.ID_THERMAL;
import static cofh.thermal.dynamics.init.TDynIDs.ID_DEVICE_FLUID_BUFFER;
import static cofh.thermal.dynamics.init.TDynIDs.ID_DEVICE_ITEM_BUFFER;

@ObjectHolder(ID_THERMAL)
public class TDynReferences {

    private TDynReferences() {

    }

    // region DEVICES
    @ObjectHolder(ID_DEVICE_FLUID_BUFFER)
    public static final Block DEVICE_FLUID_BUFFER_BLOCK = null;
    @ObjectHolder(ID_DEVICE_FLUID_BUFFER)
    public static final TileEntityType<DeviceFluidBufferTile> DEVICE_FLUID_BUFFER_TILE = null;
    @ObjectHolder(ID_DEVICE_FLUID_BUFFER)
    public static final ContainerType<DeviceFluidBufferContainer> DEVICE_FLUID_BUFFER_CONTAINER = null;

    @ObjectHolder(ID_DEVICE_ITEM_BUFFER)
    public static final Block DEVICE_ITEM_BUFFER_BLOCK = null;
    @ObjectHolder(ID_DEVICE_ITEM_BUFFER)
    public static final TileEntityType<DeviceItemBufferTile> DEVICE_ITEM_BUFFER_TILE = null;
    @ObjectHolder(ID_DEVICE_ITEM_BUFFER)
    public static final ContainerType<DeviceItemBufferContainer> DEVICE_ITEM_BUFFER_CONTAINER = null;
    // endregion
}
