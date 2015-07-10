package com.wumbleminky.luxincraft.client.handler;

import com.wumbleminky.luxincraft.client.model.ModelFluidBlock;
import com.wumbleminky.luxincraft.init.ModFluids;
import com.wumbleminky.luxincraft.reference.Names;
import com.wumbleminky.luxincraft.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModelBakeEventHandler {

    public static final ModelBakeEventHandler instance = new ModelBakeEventHandler();

    private ModelBakeEventHandler() {}

    @SubscribeEvent
    public void onModelBakeEvent(ModelBakeEvent event){
        event.modelRegistry.putObject(new ModelResourceLocation(Reference.withMODID(Names.Blocks.FLUID_YELLOW_LUXIN), "normal"), new ModelFluidBlock());

        TextureMap textureMap = Minecraft.getMinecraft().getTextureMapBlocks();
        ModFluids.fluidYellowLuxin.setIcons(textureMap.getAtlasSprite(Reference.withMODID(Names.Textures.STILL_YELLOW_LUXIN)), textureMap.getAtlasSprite(Reference.withMODID(Names.Textures.FLOWING_YELLOW_LUXIN)));
    }
}
