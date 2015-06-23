package com.wumbleminky.luxincraft.init;

import com.wumbleminky.luxincraft.item.ItemBlueLuxinPickaxe;
import com.wumbleminky.luxincraft.item.ItemLuxinCraft;
import com.wumbleminky.luxincraft.reference.Names;
import com.wumbleminky.luxincraft.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
    public static final ItemLuxinCraft blueLuxinPickaxe = new ItemBlueLuxinPickaxe();

    public static void init(){
        GameRegistry.registerItem(blueLuxinPickaxe, Names.Tools.BLUE_LUXIN_PICKAXE);
    }

    public static void registerRenders(){
        registerRender(blueLuxinPickaxe);
    }

    public static void registerRender(ItemLuxinCraft item){
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getName(), "inventory"));
    }
}
