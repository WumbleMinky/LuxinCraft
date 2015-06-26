package com.wumbleminky.luxincraft.client.handler;

import com.wumbleminky.luxincraft.client.settings.Keybindings;
import com.wumbleminky.luxincraft.reference.Key;
import com.wumbleminky.luxincraft.utility.LogHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class KeyInputEventHandler {

    @SubscribeEvent
    public void handleKeyInputEvent(InputEvent.KeyInputEvent event){
        if (getPressedKeybindings() == Key.ACTIVATE){
            LogHelper.info("Activate Pressed!!");
        }
    }

    private static Key getPressedKeybindings(){
        if (Keybindings.activate.isPressed()){
            return Key.ACTIVATE;
        }
        return Key.UNKNOWN;
    }
}
