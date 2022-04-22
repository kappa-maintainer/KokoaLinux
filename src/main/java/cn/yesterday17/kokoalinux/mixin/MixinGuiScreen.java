package cn.yesterday17.kokoalinux.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import org.lwjgl.input.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({GuiScreen.class})
public class MixinGuiScreen {

    @Shadow
    public Minecraft mc;

    @Inject(at = @At("HEAD"), method = "handleKeyboardInput", cancellable = true)
    public void mixinHandleInput(CallbackInfo ci) {
        char c0 = Keyboard.getEventCharacter();

        if (Keyboard.getEventKey() == 0 && c0 >= ' ' || Keyboard.getEventKeyState())
        {
            this.keyTyped(c0, Keyboard.getEventKey());
        }

        this.mc.func_152348_aa();
        ci.cancel();
    }

    @Shadow
    protected void keyTyped(char p_73869_1_, int p_73869_2_){}

}
