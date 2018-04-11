package com.dmfmm.extrafood.tileentities;

import com.dmfmm.extrafood.container.JuiceMixerContainer;
import com.dmfmm.extrafood.crafting.JuiceMixerRegistry;
import java.util.ArrayList;
import java.util.Arrays;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class JuiceMixerTileEntity extends TileEntity implements /*IFluidHandler,*/ ITickable, IInventory {

    public enum SelectedTank {
        LEFT(0),
        MIDDLE(1),
        RIGHT(2);

        private int id;

        SelectedTank(int id) {
            this.id = id;
        }

        public int toInt() {
            return this.id;
        }

        public static SelectedTank fromInt(int i) {
            return SelectedTank.values()[i];
        }
    }

    // Back is middle
    // L is L
    // R is R
    // Bottom is  out

    public FluidTank input1;
    public FluidTank input2;
    public FluidTank input3;

    public ArrayList<FluidStack> outputState;

    public SelectedTank selected;
    private ItemStack[] inv;

    public JuiceMixerTileEntity() {
        inv = new ItemStack[4];
        selected = SelectedTank.LEFT;
        input1 = new FluidTank(2000);
        input2 = new FluidTank(2000);
        input3 = new FluidTank(2000);
        outputState = new ArrayList<>();
    }

    public void handleMakeDestroy(int id) {
        switch (id){
            case 0:
                this.outputState = new ArrayList<>(Arrays.asList(JuiceMixerRegistry.instance.getOutputForCurrent(outputState)));
                break;
            case 1:
                this.outputState = new ArrayList<>();
                break;
        }
    }
    public void handleClickingRelease(int
                                              tank) {
        FluidTank toDrain = null;
        switch (tank) {
            case 0:
                toDrain = input1;
                break;
            case 1:
                toDrain = input2;
                break;
            case 2:
                toDrain = input3;
                break;
        }
        FluidStack drainable = toDrain.drain(500, false);
        if (drainable == null || drainable.amount < 500) {
            return;
        }
        int total = 0;
        for (FluidStack fluidStack : outputState) {
            total += fluidStack.amount;
        }
        if (total > 500 * 11) {
            return;
        }
        else {
            Fluid fluid = toDrain.getFluid().getFluid();
            toDrain.drain(500, true);
            ArrayList<FluidStack> outputStateNew = new ArrayList<>();
            boolean existed = false;
            for (FluidStack fluidStack : outputState) {
                if (fluidStack.getFluid() == fluid) {
                    FluidStack newFluidStack = fluidStack.copy();
                    newFluidStack.amount += 500;
                    outputStateNew.add(newFluidStack);
                    existed = true;
                }
                else {
                    outputStateNew.add(fluidStack.copy());
                }
            }
            if (!existed) {
                outputStateNew.add(new FluidStack(fluid, 500));
            }
            outputState = outputStateNew;
        }

    }

    public void changeSelected(SelectedTank tank){
        selected = tank;
    }

    /*@Override
    public int fill(EnumFacing from, FluidStack resource, boolean doFill) {
        switch (BlockContainerRotate.RelativeDirection.getRelativeDirection(from, BlockContainerRotate.getFacing(world, pos))) {
            case LEFT:
                return input1.fill(resource, doFill);
            case RIGHT:
                return input3.fill(resource, doFill);
            case BACK:
                return input2.fill(resource, doFill);
            case DOWN:
                return 0;
            default:
                break;
        }
        return 0;
    }

    @Override
    public FluidStack drain(EnumFacing from, FluidStack resource, boolean doDrain) {
        switch (BlockContainerRotate.RelativeDirection.getRelativeDirection(from, BlockContainerRotate.getFacing(world, pos))) {
            case LEFT:
                if (input1.getFluid().isFluidEqual(resource)) {
                    return input1.drain(resource.amount, doDrain);
                }
                return null;
            case RIGHT:
                if (input3.getFluid().isFluidEqual(resource)) {
                    return input3.drain(resource.amount, doDrain);
                }
                return null;
            case BACK:
                if (input2.getFluid().isFluidEqual(resource)) {
                    return input2.drain(resource.amount, doDrain);
                }
                return null;
            case DOWN:
                if (outputState.size() == 1) {
                    if (resource.isFluidEqual(outputState.get(0))) {
                        return drainOutput(resource.amount, doDrain);
                    }
                }
                return null;
            default:
                return null;

        }
    }*/

    public FluidStack drainOutput(int maxDrain, boolean doDrain) {
        FluidStack fluid = outputState.get(0);
        if (outputState.size() != 1) {
            return null;
        }
        int drained = maxDrain;
        if (fluid.amount < drained)
        {
            drained = fluid.amount;
        }
        FluidStack stack = new FluidStack(fluid, drained);
        if (doDrain) {
            fluid.amount -= drained;
            if (fluid.amount <= 0)
            {
                outputState.clear();
            }
            else {
                outputState.set(0, fluid);
            }

        }
        return stack;
    }

    /*@Override
    public FluidStack drain(EnumFacing from, int maxDrain, boolean doDrain) {
        switch (BlockContainerRotate.RelativeDirection.getRelativeDirection(from, BlockContainerRotate.getFacing(world, pos))) {
            case LEFT:
                return input1.drain(maxDrain, doDrain);
            case BACK:
                return input2.drain(maxDrain, doDrain);
            case RIGHT:
                return input3.drain(maxDrain, doDrain);
            case DOWN:
                return drainOutput(maxDrain, doDrain);
            default:
                return null;
        }
    }

    @Override
    public boolean canFill(EnumFacing from, Fluid fluid) {
        switch (BlockContainerRotate.RelativeDirection.getRelativeDirection(from, BlockContainerRotate.getFacing(world, pos))) {
            case LEFT:
            case BACK:
            case RIGHT:
                return true;
            default:
                return false;
        }
    }

    @Override
    public boolean canDrain(EnumFacing from, Fluid fluid) {
        switch (BlockContainerRotate.RelativeDirection.getRelativeDirection(from, BlockContainerRotate.getFacing(world, pos))) {
            case LEFT:
            case BACK:
            case RIGHT:
                return true;
            case DOWN:
                if (outputState.size() == 1){
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    @Override
    public IFluidTankProperties[] getTankProperties() {
        return new IFluidTankProperties[] {new FluidTankProperties(input1.getFluid(), input1.getFluidAmount()), new FluidTankProperties(input2.getFluid(), input2.getFluidAmount()), new FluidTankProperties(input3.getFluid(), input3.getFluidAmount())};
    }*/

    @Override
    public int getSizeInventory() {
        return inv.length;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        return inv[index];
    }

    @Override
    public ItemStack decrStackSize(int slot, int amt) {
        ItemStack stack = getStackInSlot(slot);
        if (stack != null) {
            if (stack.getCount() <= amt) {
                setInventorySlotContents(slot, null);
            } else {
                stack = stack.splitStack(amt);
                if (stack.getCount() == 0) {
                    setInventorySlotContents(slot, null);
                }
            }
        }
        return stack;
    }

    @Override
    public ItemStack removeStackFromSlot(int slot) {
        ItemStack stack = getStackInSlot(slot);
        if (stack != null) {
            setInventorySlotContents(slot, null);
        }
        return stack;
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        inv[index] = stack;
        if (stack != null && stack.getCount() > getInventoryStackLimit()) {
            stack.setCount(getInventoryStackLimit());
        }
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer player) {
        return true;
    }

    @Override
    public void openInventory(EntityPlayer player) {

    }

    @Override
    public void closeInventory(EntityPlayer player) {

    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return !(index == 2 || index == 3);
    }

    @Override
    public int getField(int id) {
        return 0;
    }

    @Override
    public void setField(int id, int value) {

    }

    @Override
    public int getFieldCount() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public void update() {
        if (getStackInSlot(JuiceMixerContainer.INPUT_1) != null) {
            /*if (FluidContainerRegistryHelper.isFilledContainer(getStackInSlot(JuiceMixerContainer.INPUT_1))) {
                FluidStack toAdd = FluidContainerRegistryHelper.getFluidForFilledItem(getStackInSlot(JuiceMixerContainer.INPUT_1));

                if (toAdd != null) {
                    if (JuiceMixerRegistry.instance.validFluid(toAdd.getFluid())) {
                        FluidTank toFill = null;
                        switch (selected) {
                            case LEFT:
                                toFill = input1;
                                break;
                            case MIDDLE:
                                toFill = input2;
                                break;
                            case RIGHT:
                                toFill = input3;
                                break;
                        }
                        if (toFill.fill(toAdd, false) == toAdd.amount && this.getStackInSlot(JuiceMixerContainer.OUTPUT_1) == null) {
                            this.setInventorySlotContents(JuiceMixerContainer.OUTPUT_1, FluidContainerRegistryHelper.drainFluidContainer(getStackInSlot(JuiceMixerContainer.INPUT_1)));
                            this.setInventorySlotContents(JuiceMixerContainer.INPUT_1, null);
                            toFill.fill(toAdd, true);
                        }
                    }
                }

            }
        }
        if (getStackInSlot(JuiceMixerContainer.INPUT_2) != null) {
            if (FluidContainerRegistryHelper.isEmptyContainer(getStackInSlot(JuiceMixerContainer.INPUT_2))) {
                if (outputState.size() == 1) {
                    int amount = FluidContainerRegistryHelper.getContainerCapacity(outputState.get(0), getStackInSlot(JuiceMixerContainer.INPUT_2));
                    if (drainOutput(amount, false).amount == amount && amount > 0) {
                        if (getStackInSlot(JuiceMixerContainer.OUTPUT_2) == null) {
                            setInventorySlotContents(JuiceMixerContainer.OUTPUT_2, FluidContainerRegistryHelper.fillFluidContainer(drainOutput(amount, true), getStackInSlot(JuiceMixerContainer.INPUT_2)));
                            setInventorySlotContents(JuiceMixerContainer.INPUT_2, null);
                        }
                    }
                }
            }*/
        }
    }

    @Override
    public String getName() {
        return "extrafood.juicemixerTE";
    }

    @Override
    public boolean hasCustomName() {
        return false;
    }

    @Override
    public ITextComponent getDisplayName() {
        return null;
    }

    @Override
    public SPacketUpdateTileEntity getUpdatePacket()
    {
        NBTTagCompound syncData = new NBTTagCompound();
        syncData.setInteger("State", selected.toInt());
        NBTTagCompound fluidTank1 = new NBTTagCompound();
        input1.writeToNBT(fluidTank1);
        NBTTagCompound fluidTank2 = new NBTTagCompound();
        input2.writeToNBT(fluidTank2);
        NBTTagCompound fluidTank3 = new NBTTagCompound();
        input3.writeToNBT(fluidTank3);
        syncData.setTag("InputTank1", fluidTank1);
        syncData.setTag("InputTank2", fluidTank2);
        syncData.setTag("InputTank3", fluidTank3);
        NBTTagList output = new NBTTagList();
        for (FluidStack f : outputState) {
            NBTTagCompound fluidCompound = new NBTTagCompound();
            f.writeToNBT(fluidCompound);
            output.appendTag(fluidCompound);
        }

        syncData.setTag("OutputState", output);
        return new SPacketUpdateTileEntity(this.getPos(), 1, syncData);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt)
    {
        selected = SelectedTank.values()[pkt.getNbtCompound().getInteger("State")];
        NBTTagCompound compound = pkt.getNbtCompound();
        input1.readFromNBT(compound.getCompoundTag("InputTank1"));
        input2.readFromNBT(compound.getCompoundTag("InputTank2"));
        input3.readFromNBT(compound.getCompoundTag("InputTank3"));

        NBTTagList outputStateList = compound.getTagList("OutputState", 10);
        for (int outputIndex = 0; outputIndex < outputStateList.tagCount(); outputIndex++) {
            NBTTagCompound fluidStackCompound = outputStateList.getCompoundTagAt(outputIndex);
            this.outputState.add(FluidStack.loadFluidStackFromNBT(fluidStackCompound));
        }
    }
    public NBTTagCompound getUpdateTag()
    {
        return this.writeToNBT(new NBTTagCompound());
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        NBTTagCompound fluidTank1 = new NBTTagCompound();
        input1.writeToNBT(fluidTank1);
        NBTTagCompound fluidTank2 = new NBTTagCompound();
        input2.writeToNBT(fluidTank2);
        NBTTagCompound fluidTank3 = new NBTTagCompound();
        input3.writeToNBT(fluidTank3);
        compound.setTag("InputTank1", fluidTank1);
        compound.setTag("InputTank2", fluidTank2);
        compound.setTag("InputTank3", fluidTank3);

        NBTTagList output = new NBTTagList();
        for (FluidStack f : outputState) {
            NBTTagCompound fluidCompound = new NBTTagCompound();
            f.writeToNBT(fluidCompound);
            output.appendTag(fluidCompound);
        }

        compound.setTag("OutputState", output);
        compound.setInteger("Selected", selected.toInt());

        NBTTagList inventory = new NBTTagList();

        for (int i = 0; i < 4; i++) {
            ItemStack stacky = this.inv[i];
            if (stacky == null) {
                continue;
            }
            NBTTagCompound stackCompound = new NBTTagCompound();
            stacky.writeToNBT(stackCompound);
            stackCompound.setInteger("Slot", i);
        }

        compound.setTag("Inventory", inventory);
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        input1.readFromNBT(compound.getCompoundTag("InputTank1"));
        input2.readFromNBT(compound.getCompoundTag("InputTank2"));
        input3.readFromNBT(compound.getCompoundTag("InputTank3"));

        NBTTagList outputStateList = compound.getTagList("OutputState", 10);
        for (int outputIndex = 0; outputIndex < outputStateList.tagCount(); outputIndex++) {
            NBTTagCompound fluidStackCompound = outputStateList.getCompoundTagAt(outputIndex);
            this.outputState.add(FluidStack.loadFluidStackFromNBT(fluidStackCompound));
        }

        selected = SelectedTank.fromInt(compound.getInteger("Selected"));

        NBTTagList inventoryList = compound.getTagList("Inventory", 10);
        for (int inventoryListIndex = 0; inventoryListIndex < inventoryList.tagCount(); inventoryListIndex++) {
            NBTTagCompound stackCompound = inventoryList.getCompoundTagAt(inventoryListIndex);
            int slot = stackCompound.getInteger("Slot");
            inv[slot] = new ItemStack(stackCompound);
        }
    }
}
