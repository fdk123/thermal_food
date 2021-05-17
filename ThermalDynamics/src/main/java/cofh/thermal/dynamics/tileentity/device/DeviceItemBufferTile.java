package cofh.thermal.dynamics.tileentity.device;

import cofh.lib.inventory.ItemStorageCoFH;
import cofh.lib.util.Utils;
import cofh.lib.util.helpers.InventoryHelper;
import cofh.lib.util.helpers.MathHelper;
import cofh.thermal.dynamics.inventory.container.device.DeviceItemBufferContainer;
import cofh.thermal.lib.tileentity.ReconfigurableTile4Way;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.util.Direction;

import javax.annotation.Nullable;

import static cofh.lib.util.StorageGroup.ACCESSIBLE;
import static cofh.lib.util.constants.Constants.DIRECTIONS;
import static cofh.lib.util.constants.NBTTags.TAG_AMOUNT_IN;
import static cofh.lib.util.constants.NBTTags.TAG_AMOUNT_OUT;
import static cofh.thermal.dynamics.init.TDynReferences.DEVICE_ITEM_BUFFER_TILE;

public class DeviceItemBufferTile extends ReconfigurableTile4Way implements ITickableTileEntity {

    public static int XFER_MAX = 64;

    public int amountInput = 4;
    public int amountOutput = 4;

    public DeviceItemBufferTile() {

        super(DEVICE_ITEM_BUFFER_TILE);

        inventory.addSlots(ACCESSIBLE, 9);

        initHandlers();
    }

    @Override
    public void tick() {

        boolean curActive = isActive;

        if (isActive) {
            if (Utils.timeCheckHalf(world)) {
                transferOutput();
                transferInput();
            }
            if (!redstoneControl.getState()) {
                isActive = false;
            }
        } else if (redstoneControl.getState()) {
            isActive = true;
        }
        updateActiveState(curActive);
    }

    @Nullable
    @Override
    public Container createMenu(int i, PlayerInventory inventory, PlayerEntity player) {

        return new DeviceItemBufferContainer(i, world, pos, inventory, player);
    }

    @Override
    protected void transferInput() {

        if (!transferControl.getTransferIn()) {
            return;
        }
        int newTracker = inputTracker;
        boolean updateTracker = false;

        for (int i = inputTracker + 1; i <= inputTracker + 6; ++i) {
            Direction side = DIRECTIONS[i % 6];
            if (reconfigControl.getSideConfig(side).isInput()) {
                for (ItemStorageCoFH slot : inputSlots()) {
                    if (slot.getSpace() > 0) {
                        if (InventoryHelper.extractFromAdjacent(this, slot, Math.min(getInputItemAmount(), slot.getSpace()), side)) {
                            break;
                        }
                    }
                }
                if (!updateTracker) {
                    newTracker = side.ordinal();
                    updateTracker = true;
                }
            }
        }
        inputTracker = newTracker;
    }

    @Override
    protected void transferOutput() {

        if (!transferControl.getTransferOut()) {
            return;
        }
        int newTracker = outputTracker;
        boolean updateTracker = false;

        for (int i = outputTracker + 1; i <= outputTracker + 6; ++i) {
            Direction side = DIRECTIONS[i % 6];
            if (reconfigControl.getSideConfig(side).isOutput()) {
                for (int j = outputSlots().size(); j-- > 0; ) {
                    if (InventoryHelper.insertIntoAdjacent(this, outputSlots().get(j), getOutputItemAmount(), side)) {
                        break;
                    }
                }
                if (!updateTracker) {
                    newTracker = side.ordinal();
                    updateTracker = true;
                }
            }
        }
        outputTracker = newTracker;
    }

    @Override
    protected int getInputItemAmount() {

        return amountInput;
    }

    @Override
    protected int getOutputItemAmount() {

        return amountOutput;
    }

    // region NETWORK

    // CONFIG
    @Override
    public PacketBuffer getConfigPacket(PacketBuffer buffer) {

        super.getConfigPacket(buffer);

        buffer.writeByte(amountInput);
        buffer.writeByte(amountOutput);

        return buffer;
    }

    @Override
    public void handleConfigPacket(PacketBuffer buffer) {

        super.handleConfigPacket(buffer);

        amountInput = MathHelper.clamp(buffer.readByte(), 0, XFER_MAX);
        amountOutput = MathHelper.clamp(buffer.readByte(), 0, XFER_MAX);
    }

    // GUI
    @Override
    public PacketBuffer getGuiPacket(PacketBuffer buffer) {

        super.getGuiPacket(buffer);

        buffer.writeByte(amountInput);
        buffer.writeByte(amountOutput);

        return buffer;
    }

    @Override
    public void handleGuiPacket(PacketBuffer buffer) {

        super.handleGuiPacket(buffer);

        amountInput = buffer.readByte();
        amountOutput = buffer.readByte();
    }
    // endregion

    // region NBT
    @Override
    public void read(BlockState state, CompoundNBT nbt) {

        super.read(state, nbt);

        amountInput = nbt.getInt(TAG_AMOUNT_IN);
        amountOutput = nbt.getInt(TAG_AMOUNT_OUT);
    }

    @Override
    public CompoundNBT write(CompoundNBT nbt) {

        super.write(nbt);

        nbt.putInt(TAG_AMOUNT_IN, amountInput);
        nbt.putInt(TAG_AMOUNT_OUT, amountOutput);

        return nbt;
    }
    // endregion

}
