package cn.yesterday17.kokoalinux.tweaker;

import cn.yesterday17.kokoalinux.KokoaLinux;
import cn.yesterday17.kokoalinux.transformer.GuiTextFieldTransformer;
import cn.yesterday17.kokoalinux.transformer.LwjglTransformer;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

import java.util.Map;

public class KokoaLoadingPlugin implements IFMLLoadingPlugin {
    @Override
    public String[] getASMTransformerClass() {
        return new String[]{GuiTextFieldTransformer.class.getName(), LwjglTransformer.class.getName()};
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

    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}
