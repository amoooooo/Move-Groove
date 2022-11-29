package coffee.amo.veil.mixin.client;

import coffee.amo.veil.Veil;
import coffee.amo.veil.client.ClientUtil;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.world.entity.LivingEntity;
import org.checkerframework.checker.units.qual.A;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(InventoryScreen.class)
public class InventoryScreenMixin {

    @Inject(method = "renderEntityInInventory", at = @At("HEAD"), locals = LocalCapture.CAPTURE_FAILHARD, cancellable = true)
    private static void renderEntity(int i, int j, int k, float f, float g, LivingEntity livingEntity, CallbackInfo ci){
        ClientUtil.renderEntityInInventory(i, j, k, f, g, livingEntity);
        ci.cancel();
    }

    @Inject(method = "mouseReleased", at = @At("HEAD"), cancellable = true)
    private void mouseReleased(double d, double e, int i, CallbackInfoReturnable<Boolean> cir){
        Veil.LOGGER.error("X: " + d + " Y: " + e + " Button: " + i);
        InventoryScreen screen = (InventoryScreen) (Object) this;
        int width = Minecraft.getInstance().getWindow().getGuiScaledWidth() / 2;
        int height = Minecraft.getInstance().getWindow().getGuiScaledHeight() / 2;
        if(d > width - 30 && d < width + 30 && e > height - 30 && e < height + 30){
            Veil.LOGGER.error("Clicked on entity");
            cir.setReturnValue(true);
        }
    }
}
