package com.wumbleminky.luxincraft.proxy;

import com.wumbleminky.luxincraft.client.settings.Keybindings;
import com.wumbleminky.luxincraft.init.ModBlocks;
import com.wumbleminky.luxincraft.init.ModItems;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {

    @Override
    public void registerRenders(){
        ModItems.registerRenders();
        ModBlocks.registerRenders();
    }

    @Override
    public void registerKeybindings() {
        ClientRegistry.registerKeyBinding(Keybindings.activate);
    }
}
