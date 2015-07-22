package com.wumbleminky.luxincraft.client.handler;

import com.wumbleminky.luxincraft.client.renderer.LuxinHUDRenderer;
import com.wumbleminky.luxincraft.item.ItemSpectacles;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGameOverlayEventHandler {

    private LuxinHUDRenderer hudRenderer;
    private Minecraft mc;

    private final int HELMET_SLOT_ID = 4;

    public RenderGameOverlayEventHandler(LuxinHUDRenderer renderer){
        this.hudRenderer = renderer;
        this.mc = FMLClientHandler.instance().getClient();
    }

    @SubscribeEvent
    public void onRenderGameOverlayEvent(RenderGameOverlayEvent.Pre event){
        if (event.type == RenderGameOverlayEvent.ElementType.HOTBAR) {
            EntityPlayer player = mc.thePlayer;
            if (player != null) {
                ItemStack stack = player.getEquipmentInSlot(HELMET_SLOT_ID);
                if (stack != null && stack.getItem() instanceof ItemSpectacles) {
                    ScaledResolution res = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
                    hudRenderer.renderHUD(stack, res);
                }
            }
        }
    }
}
