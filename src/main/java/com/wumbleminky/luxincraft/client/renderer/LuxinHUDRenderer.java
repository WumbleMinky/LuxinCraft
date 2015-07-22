package com.wumbleminky.luxincraft.client.renderer;

import com.wumbleminky.luxincraft.item.ItemSpectacles;
import com.wumbleminky.luxincraft.reference.Colors;
import com.wumbleminky.luxincraft.reference.Names;
import com.wumbleminky.luxincraft.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class LuxinHUDRenderer extends Gui {

    private final static ResourceLocation hudOverlay = new ResourceLocation(Reference.MOD_ID, Names.Textures.HUD_OVERLAY);

    private Minecraft mc;

    private final int LUXIN_PER_CELL = 10;

    //The left and top edges of the HUD
    private final int LEFT_EDGE = 4;
    private final int TOP_EDGE = 4;

    //texture variables
    private final int WINDOW_WIDTH = 35;
    private final int WINDOW_HEIGHT = 35;
    private final int WINDOW_LEFT = 0;
    private final int WINDOW_TOP = 0;

    private final int BAR_BG_HEIGHT = 10;
    private final int BAR_BG_WIDTH = 20;
    private final int BAR_BG_LEFT = WINDOW_LEFT + WINDOW_WIDTH;
    private final int BAR_BG_TOP = 0;

    private final int BAR_HEIGHT = 6;
    private final int BAR_LEFT = BAR_BG_LEFT;
    private final int BAR_TOP = BAR_BG_TOP + BAR_BG_HEIGHT;
    private final int BAR_WIDTH = 20;

    public LuxinHUDRenderer(Minecraft mc){
        this.mc = mc;
    }

    public void renderHUD(ItemStack stack, ScaledResolution resolution){
        ItemSpectacles spectacles = (ItemSpectacles)stack.getItem();
        int color = spectacles.getColor(stack);

        mc.entityRenderer.setupOverlayRendering();

        GL11.glPushAttrib(GL11.GL_ALL_ATTRIB_BITS);
        GlStateManager.enableBlend();
        GlStateManager.pushMatrix();

            mc.renderEngine.bindTexture(hudOverlay);

            GlStateManager.translate(LEFT_EDGE, TOP_EDGE, 0);
            GlStateManager.color(1,1,1,1);
            drawTexturedModalRect(0,0,WINDOW_LEFT,WINDOW_TOP,WINDOW_WIDTH,WINDOW_HEIGHT);
            GlStateManager.pushMatrix();
                GlStateManager.translate(WINDOW_WIDTH, 0, 0);
                renderBar(4, 18, color);
            GlStateManager.popMatrix();
        GlStateManager.popMatrix();
        GlStateManager.disableBlend();
        GL11.glPopAttrib();

    }


    private void renderBar(int number_segments, int luxin_amount, int color){
        int luxin_remaining = luxin_amount > number_segments * LUXIN_PER_CELL ? LUXIN_PER_CELL :luxin_amount;

        //get the RGB float values from the item color;
        float red = (color >> 16 & 255) / 255.0F;
        float green = (color >> 8 & 255) / 255.0F;
        float blue = (color & 255) / 255.0F;
        GlStateManager.pushMatrix();
            GlStateManager.scale(0.5,0.5,0);
            //render the bar BG
            GlStateManager.color(1,1,1,1);
            for (int i = 0; i < number_segments - 1; i++){
                drawTexturedModalRect(0, 0, BAR_BG_LEFT, BAR_BG_TOP, BAR_BG_WIDTH, BAR_BG_HEIGHT);
                GlStateManager.translate(LUXIN_PER_CELL * 2, 0, 0);
            }
            drawTexturedModalRect(0,0,BAR_BG_LEFT, BAR_BG_TOP, BAR_BG_WIDTH + 2, BAR_BG_HEIGHT);
        GlStateManager.popMatrix();

        //render the bar interior
        GlStateManager.pushMatrix();
            GlStateManager.scale(0.5,0.5,0);
            GlStateManager.translate(0,2,0);
            GlStateManager.color(red,green,blue,1);
            while(luxin_remaining >= LUXIN_PER_CELL){
                drawTexturedModalRect(0, 0, BAR_LEFT, BAR_TOP, BAR_WIDTH, BAR_HEIGHT);
                luxin_remaining -= LUXIN_PER_CELL;
                GlStateManager.translate(LUXIN_PER_CELL * 2,0,0);
            }
            if (luxin_remaining > 0){
                drawTexturedModalRect(0,0,BAR_LEFT, BAR_TOP, (int)(BAR_WIDTH * (luxin_remaining / (float)LUXIN_PER_CELL)), BAR_HEIGHT);
            }
        GlStateManager.popMatrix();


    }
}
