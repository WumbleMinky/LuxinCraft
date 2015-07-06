package com.wumbleminky.luxincraft.client.renderer.tileentity;

import com.wumbleminky.luxincraft.tileentity.TileEntityWorktable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import org.lwjgl.opengl.GL11;

public class TileEntityRendererWorktable extends TileEntitySpecialRenderer {

    public TileEntityRendererWorktable(){
        super();
    }

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double relativeX, double relativeY, double relativeZ, float partialTicks, int blockDamageProgress) {
        if (!(tileEntity instanceof TileEntityWorktable)) return;

        TileEntityWorktable teWorktable = (TileEntityWorktable)tileEntity;
        if (!(teWorktable.hasInventory())) return;

        EntityItem inventoryEntity = new EntityItem(teWorktable.getWorld());
        inventoryEntity.hoverStart = 0.0f;
        inventoryEntity.setEntityItemStack(teWorktable.getInventory());

        GL11.glPushMatrix();
        GlStateManager.translate(relativeX + 0.5, relativeY+ 0.8, relativeZ + 0.5);

        if (teWorktable.getFacing() == EnumFacing.EAST){
            GlStateManager.rotate(-90, 0, 1, 0);
        }else if(teWorktable.getFacing() == EnumFacing.SOUTH){
            GlStateManager.rotate(180, 0, 1, 0);
        }else if(teWorktable.getFacing() == EnumFacing.WEST){
            GlStateManager.rotate(90, 0, 1, 0);
        }
        //rotate items to be flat on the table
        if (!(teWorktable.getInventory().getItem() instanceof ItemBlock)){
            GlStateManager.translate(0f,0.25f,0f);
            GlStateManager.rotate(90f,1f,0f,0f);
            GlStateManager.translate(0f,-0.35f,0f);
        }
        Minecraft.getMinecraft().getRenderManager().renderEntityWithPosYaw(inventoryEntity, 0, 0, 0, 0, 0);
        GL11.glPopMatrix();
    }
}
