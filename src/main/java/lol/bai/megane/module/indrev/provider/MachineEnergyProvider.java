package lol.bai.megane.module.indrev.provider;

import lol.bai.megane.api.provider.EnergyProvider;
import me.steven.indrev.IREnergyStorage;
import me.steven.indrev.api.machines.Tier;
import me.steven.indrev.blockentities.MachineBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@SuppressWarnings("rawtypes")
public class MachineEnergyProvider extends EnergyProvider<MachineBlockEntity> {

    private IREnergyStorage energyStorage;

    @Override
    public void setContext(World world, BlockPos pos, PlayerEntity player, MachineBlockEntity machineBlockEntity) {
        super.setContext(world, pos, player, machineBlockEntity);

        this.energyStorage = machineBlockEntity.getStorage();
    }

    @Override
    public long getStored() {
        return isCreative() ? -1L : energyStorage.getAmount();
    }

    @Override
    public long getMax() {
        return isCreative() ? -1L : energyStorage.getCapacity();
    }

    private boolean isCreative() {
        return getObject().getTier() == Tier.CREATIVE;
    }

}
