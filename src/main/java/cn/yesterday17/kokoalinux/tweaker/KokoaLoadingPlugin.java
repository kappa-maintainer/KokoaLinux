package cn.yesterday17.kokoalinux.tweaker;

import cn.yesterday17.kokoalinux.KokoaLinux;
import cn.yesterday17.kokoalinux.transformer.GuiTextFieldTransformer;
import cn.yesterday17.kokoalinux.transformer.LwjglTransformer;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import org.apache.commons.lang3.SystemUtils;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.mixin.Mixins;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static net.minecraft.launchwrapper.Launch.classLoader;

public class KokoaLoadingPlugin implements IFMLLoadingPlugin, IMixinConfigPlugin {
    @Override
    public String[] getASMTransformerClass() {
        if(SystemUtils.IS_OS_UNIX || SystemUtils.IS_OS_FREE_BSD || SystemUtils.IS_OS_NET_BSD || SystemUtils.IS_OS_OPEN_BSD) {
            LwjglTransformer.prepare(classLoader);
            return new String[]{GuiTextFieldTransformer.class.getName(), LwjglTransformer.class.getName()};
        } else {
            return new String[0];
        }
    }

    @Override
    public String getModContainerClass() {
        return KokoaLinux.class.getName();
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {
        MixinBootstrap.init();
        Mixins.addConfiguration("mixins.kokoalinux.json");
    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }

    @Override
    public void onLoad(String mixinPackage) {

    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        return true;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {

    }

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }
}
