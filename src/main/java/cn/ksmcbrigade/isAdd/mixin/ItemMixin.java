package cn.ksmcbrigade.isAdd.mixin;

import cn.ksmcbrigade.isAdd.ItemStackAdd;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.io.IOException;

@Mixin(Item.Properties.class)
public abstract class ItemMixin {

    @Shadow
    int maxStackSize;

    @Inject(method = "<init>",at = @At("TAIL"))
    public void init(CallbackInfo ci) throws IOException {
        ItemStackAdd.init();
        this.maxStackSize = ItemStackAdd.max;
    }

    @Inject(method = "stacksTo",at = @At("RETURN"))
    public void stackTo(int p_41488_, CallbackInfoReturnable<Item.Properties> cir) throws IOException {
        ItemStackAdd.init();
        this.maxStackSize = ItemStackAdd.max;
    }
}
