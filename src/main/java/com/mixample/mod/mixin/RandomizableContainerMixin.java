package com.mixample.mod.mixin;

import com.min01.archaeology.container.RandomizableContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import javax.annotation.Nullable;

@Mixin(value = RandomizableContainer.class, remap = false)
public interface RandomizableContainerMixin {

    /**
     * @author inklightly
     * @reason Make a default implementation so DecoratedPotBlockEntity doesn't
     *         crash with AbstractMethodError.
     */
    @Overwrite
    @Nullable
    default Level getLevel() {
        if (this instanceof BlockEntity be) {
            return be.getLevel();
        }
        // Fallback: no level available.
        return null;
    }

    /**
    * @author inklightly
    * @reason Same reason, different scope.
    */
    @Overwrite
    default BlockPos getBlockPos() {
        if (this instanceof BlockEntity be) {
            return be.getBlockPos();
        }
        throw new IllegalStateException(
                "RandomizableContainer is not a BlockEntity: " + this.getClass()
        );
    }
}
