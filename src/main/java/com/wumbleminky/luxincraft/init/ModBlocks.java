package com.wumbleminky.luxincraft.init;

import com.wumbleminky.luxincraft.block.BlockLuxinCraft;
import com.wumbleminky.luxincraft.block.BlockSolidBlueLuxin;
import com.wumbleminky.luxincraft.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {

    public static final BlockLuxinCraft solidBlueLuxin = new BlockSolidBlueLuxin();

    public static void init(){
        GameRegistry.registerBlock(solidBlueLuxin, solidBlueLuxin.getName());
    }

    public static void registerRenders(){
        registerRender(solidBlueLuxin);
    }

    public static void registerRender(BlockLuxinCraft block){
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(Reference.MOD_ID + ":" + block.getName(), "inventory"));
    }
}
