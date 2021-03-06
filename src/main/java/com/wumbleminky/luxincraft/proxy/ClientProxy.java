package com.wumbleminky.luxincraft.proxy;

import com.wumbleminky.luxincraft.client.handler.KeyInputEventHandler;
import com.wumbleminky.luxincraft.client.handler.RenderGameOverlayEventHandler;
import com.wumbleminky.luxincraft.client.renderer.LuxinHUDRenderer;
import com.wumbleminky.luxincraft.client.renderer.tileentity.TileEntityRendererWorktable;
import com.wumbleminky.luxincraft.client.settings.Keybindings;
import com.wumbleminky.luxincraft.handler.FluidHandler;
import com.wumbleminky.luxincraft.init.ModBlocks;
import com.wumbleminky.luxincraft.init.ModFluids;
import com.wumbleminky.luxincraft.init.ModItems;
import com.wumbleminky.luxincraft.reference.Names;
import com.wumbleminky.luxincraft.reference.Reference;
import com.wumbleminky.luxincraft.tileentity.TileEntityWorktable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy {

    @Override
    public void registerRenders() {
        ModItems.registerRenders();
        ModBlocks.registerRenders();
        ModFluids.registerRenders();

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWorktable.class, new TileEntityRendererWorktable());
    }

    @Override
    public void registerKeybindings() {
        ClientRegistry.registerKeyBinding(Keybindings.activate);
    }

    @Override
    public void registerEventHandlers(){
        MinecraftForge.EVENT_BUS.register(new FluidHandler());
        FMLCommonHandler.instance().bus().register(new KeyInputEventHandler());
        MinecraftForge.EVENT_BUS.register(new RenderGameOverlayEventHandler(new LuxinHUDRenderer(Minecraft.getMinecraft())));
    }

    @SideOnly(Side.CLIENT)
    public void registerVariants(){
        //Items
        ModelBakery.addVariantName(ModFluids.bucket, Reference.withMODID(Names.Items.BUCKET_YELLOW_LUXIN));
        //Blocks
        ModelLoader.setCustomStateMapper(ModFluids.blockFluidYellowLuxin, (new StateMap.Builder()).addPropertiesToIgnore(BlockFluidBase.LEVEL).build());
    }
}