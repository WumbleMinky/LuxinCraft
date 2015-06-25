package com.wumbleminky.luxincraft.proxy;

import com.wumbleminky.luxincraft.init.ModBlocks;
import com.wumbleminky.luxincraft.init.ModItems;

public class ClientProxy extends CommonProxy {

    @Override
    public void registerRenders(){
        ModItems.registerRenders();
        ModBlocks.registerRenders();
    }
}
