package com.wumbleminky.luxincraft.handler;

import com.wumbleminky.luxincraft.reference.Reference;
import com.wumbleminky.luxincraft.reference.Settings;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

public class ConfigurationHandler {

    public static Configuration configuration;

    public static void init(File configFile){

        if (configuration == null) {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event){
        if (event.modID.equals(Reference.MOD_ID)){
            loadConfiguration();
        }
    }

    private static void loadConfiguration(){
        //read in properties from the config file
        Settings.WorldGen.spawnRubyOre = configuration.get("WorldGen", "spawnRubyore", true).getBoolean(true);
        Settings.WorldGen.spawnSapphireOre = configuration.get("WorldGen", "spawnSapphireOre", true).getBoolean(true);
        Settings.WorldGen.spawnGarnetOre = configuration.get("WorldGen", "spawnGarnetOre", true).getBoolean(true);
        Settings.WorldGen.spawnCitrineOre = configuration.get("WorldGen", "spawnCitrineOre", true).getBoolean(true);
        if (configuration.hasChanged()) {
            configuration.save();
        }
    }
}
