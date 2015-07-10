package com.wumbleminky.luxincraft;

import com.wumbleminky.luxincraft.client.handler.KeyInputEventHandler;
import com.wumbleminky.luxincraft.client.handler.ModelBakeEventHandler;
import com.wumbleminky.luxincraft.handler.ConfigurationHandler;
import com.wumbleminky.luxincraft.handler.FluidHandler;
import com.wumbleminky.luxincraft.init.ModBlocks;
import com.wumbleminky.luxincraft.init.ModFluids;
import com.wumbleminky.luxincraft.init.ModItems;
import com.wumbleminky.luxincraft.init.TileEntities;
import com.wumbleminky.luxincraft.proxy.IProxy;
import com.wumbleminky.luxincraft.reference.Reference;
import com.wumbleminky.luxincraft.worldgen.LuxinCraftWorldGen;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid= Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class LuxinCraft {

    @Mod.Instance(Reference.MOD_ID)
    public static LuxinCraft instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){

        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());

        ModItems.init();
        ModBlocks.init();
        ModFluids.init();
        //proxy.registerSided();
        proxy.registerVariants();
        proxy.registerKeybindings();
        GameRegistry.registerWorldGenerator(new LuxinCraftWorldGen(), 2);
        MinecraftForge.EVENT_BUS.register(ModelBakeEventHandler.instance);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        proxy.registerRenders();
        TileEntities.init();
        MinecraftForge.EVENT_BUS.register(new FluidHandler());
        FMLCommonHandler.instance().bus().register(new KeyInputEventHandler());

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){

    }
}
