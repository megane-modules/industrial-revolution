package lol.bai.megane.module.indrev.provider;

import me.steven.indrev.blockentities.modularworkbench.ModularWorkbenchBlockEntity;

public class ModularWorkbenchProgressProvider extends AbstractMachineProgressProvider<ModularWorkbenchBlockEntity> {

    @Override
    public int getPercentage() {
        return getObject().getModuleProcessTime() / getObject().getModuleMaxProcessTime() * 100;
    }

}
