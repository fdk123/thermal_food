package cofh.thermal.dynamics.inventory.container.device;

import cofh.core.inventory.container.TileContainer;
import cofh.lib.inventory.container.slot.SlotCoFH;
import cofh.lib.inventory.wrapper.InvWrapperCoFH;
import cofh.thermal.dynamics.tileentity.device.DeviceItemBufferTile;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static cofh.thermal.dynamics.init.TDynReferences.DEVICE_ITEM_BUFFER_CONTAINER;

public class DeviceItemBufferContainer extends TileContainer {

    public final DeviceItemBufferTile tile;

    public DeviceItemBufferContainer(int windowId, World world, BlockPos pos, PlayerInventory inventory, PlayerEntity player) {

        super(DEVICE_ITEM_BUFFER_CONTAINER, windowId, world, pos, inventory, player);
        this.tile = (DeviceItemBufferTile) world.getTileEntity(pos);
        InvWrapperCoFH tileInv = new InvWrapperCoFH(this.tile.getItemInv());

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                addSlot(new SlotCoFH(tileInv, j + i * 3, 62 + j * 18, 17 + i * 18));
            }
        }
        bindPlayerInventory(inventory);
    }

}
