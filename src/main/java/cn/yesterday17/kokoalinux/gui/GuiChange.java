package cn.yesterday17.kokoalinux.gui;

import cn.yesterday17.kokoalinux.input.InputHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiScreenBook;
import net.minecraft.client.gui.inventory.GuiEditSign;
import net.minecraftforge.client.event.GuiOpenEvent;

public class GuiChange {
    @SubscribeEvent
    public static void didChangeGui(GuiOpenEvent event) {
        System.out.println("Gui changing: " + event.gui);
        boolean canInput;
        if (event.gui == null) {
            // Ignore null GuiScreens
            canInput = false;
        } else if (event.gui instanceof GuiChat) {
            // Skip, this should be handled by Focus
            return;
        } else {
            // Vanilla GuiScreens
            canInput = event.gui instanceof GuiScreenBook
                    || event.gui instanceof GuiEditSign;

            // TODO: Force enable map
        }

        InputHelper.toggleIC(canInput);


    }

    public static void focus(boolean old, boolean now) {
        if (old != now) {
            InputHelper.toggleIC(now);
        }

    }
}
