package de.petrofsky.nuclearsciencefix.mixin;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import nuclearscience.common.tile.reactor.logisticsnetwork.TileAlarmModule;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import voltaic.common.block.states.VoltaicBlockStates;
import voltaic.prefab.utilities.BlockEntityUtils;

@Mixin(value = TileAlarmModule.class, remap = false)
public class TileAlarmModuleCableFixMixin {

    @Inject(method = "getCableLocation", at = @At("HEAD"), cancellable = true)
    private void nuclearsciencefix$cableFromBlockState(CallbackInfoReturnable<Direction> cir) {
        TileAlarmModule self = (TileAlarmModule) (Object) this;
        BlockState state = self.getBlockState();

        if (state.hasProperty(VoltaicBlockStates.FACING)) {
            cir.setReturnValue(BlockEntityUtils.getRelativeSide(
                    state.getValue(VoltaicBlockStates.FACING),
                    BlockEntityUtils.MachineDirection.BACK.mappedDir));
        }
    }
}
