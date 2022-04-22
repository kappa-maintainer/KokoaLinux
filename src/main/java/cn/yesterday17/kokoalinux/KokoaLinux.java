package cn.yesterday17.kokoalinux;


import cn.yesterday17.kokoalinux.gui.GuiChange;
import com.google.common.eventbus.EventBus;
import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = KokoaLinux.MOD_ID, name = KokoaLinux.NAME)
public class KokoaLinux extends DummyModContainer {
    public static final String MOD_ID = "kokoalinux";
    public static final String NAME = "KokoaLinux";

    public KokoaLinux() {
        super(new ModMetadata());

        ModMetadata metadata = getMetadata();
        metadata.modId = MOD_ID + "Container";
        metadata.name = NAME;
        metadata.version = "@VERSION@";
        metadata.description = "IME solution for Minecraft under Linux.";
        metadata.authorList.add("Yesterday17");
        metadata.url = "https://github.com/Yesterday17/KokoaLinux";
        metadata.credits = "Axeryok";
    }



    @Override
    public boolean registerBus(EventBus bus, LoadController controller) {
        bus.register(this);
        return true;
    }
    @Mod.EventHandler
    public void init(FMLPreInitializationEvent event) {
        // Subscribe events
        MinecraftForge.EVENT_BUS.register(new GuiChange());
    }


}
