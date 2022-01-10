package lol.bai.megane.module.indrev.provider;

import lol.bai.megane.api.provider.ItemProvider;
import me.steven.indrev.blockentities.BaseMachineBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class BaseMachineItemProvider extends ItemProvider<BaseMachineBlockEntity> {

    private SidedInventory inventory;

    @Override
    public void setContext(World world, BlockPos pos, PlayerEntity player, BaseMachineBlockEntity baseMachineBlockEntity) {
        super.setContext(world, pos, player, baseMachineBlockEntity);

        this.inventory = baseMachineBlockEntity.getInventory(world.getBlockState(pos), world, pos);
    }

    @Override
    public boolean hasItems() {
        return inventory != null;
    }

    @Override
    public int getSlotCount() {
        return inventory.size();
    }

    @Override
    public @NotNull ItemStack getStack(int slot) {
        return inventory.getStack(slot);
    }

}
