package lol.bai.megane.module.indrev.provider;

import java.util.Objects;

import lol.bai.megane.api.provider.ProgressProvider;
import me.steven.indrev.blockentities.MachineBlockEntity;
import me.steven.indrev.inventories.IRInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("rawtypes")
public abstract class AbstractMachineProgressProvider<T extends MachineBlockEntity> extends ProgressProvider<T> {

    private IRInventory inventory;

    @Override
    public void setContext(World world, BlockPos pos, PlayerEntity player, T t) {
        super.setContext(world, pos, player, t);

        this.inventory = Objects.requireNonNull(t.getInventoryComponent()).getInventory();
    }

    @Override
    public int getInputSlotCount() {
        return inventory.getInputSlots().length;
    }

    @Override
    public int getOutputSlotCount() {
        return inventory.getOutputSlots().length;
    }

    @Override
    public @NotNull ItemStack getInputStack(int slot) {
        return inventory.getStack(inventory.getInputSlots()[slot]);
    }

    @Override
    public @NotNull ItemStack getOutputStack(int slot) {
        return inventory.getStack(inventory.getOutputSlots()[slot]);
    }

}
