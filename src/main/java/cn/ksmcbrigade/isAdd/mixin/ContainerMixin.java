package cn.ksmcbrigade.isAdd.mixin;

import cn.ksmcbrigade.isAdd.ItemStackAdd;
import net.minecraft.world.Clearable;
import net.minecraft.world.Container;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.io.IOException;

@Mixin(Container.class)
public interface ContainerMixin extends Clearable {

    /**
     * @author KSmc_brigade
     * @reason re
     */
    @Overwrite
    default int getMaxStackSize() {
        try {
            ItemStackAdd.init();
            return ItemStackAdd.max;
        }
        catch (IOException e){
            e.printStackTrace();
            return 64;
        }
    }
}
