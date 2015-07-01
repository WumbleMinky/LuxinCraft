package com.wumbleminky.luxincraft.init;

import com.wumbleminky.luxincraft.item.*;
import com.wumbleminky.luxincraft.reference.Material;
import com.wumbleminky.luxincraft.reference.Names;
import com.wumbleminky.luxincraft.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {

    //Tools
    public static final LuxinPickaxe blueLuxinPickaxe = new LuxinPickaxe(Material.Tools.BLUE_LUXIN, Names.Tools.BLUE_LUXIN_PICKAXE);
    public static final LuxinPickaxe greenLuxinPickaxe = new LuxinPickaxe(Material.Tools.GREEN_LUXIN, Names.Tools.GREEN_LUXIN_PICKAXE);
    public static final LuxinPickaxe yellowLuxinPickaxe = new LuxinPickaxe(Material.Tools.YELLOW_LUXIN, Names.Tools.YELLOW_LUXIN_PICKAXE);

    //Items
    public static final ItemLuxinCraft softCloth = new ItemSoftCloth();
    public static final ItemLuxinCraft ruby = new ItemRuby();
    public static final ItemLuxinCraft sapphire = new ItemSapphire();
    public static final ItemLuxinCraft garnet = new ItemGarnet();
    public static final ItemLuxinCraft citrine = new ItemCitrine();
    public static final ItemLuxinCraft lense = new ItemLense();

    //Armours
    public static final ItemArmorLuxinCraft spectacles = new ItemSpectacles();

    public static void init(){
        GameRegistry.registerItem(blueLuxinPickaxe, Names.Tools.BLUE_LUXIN_PICKAXE);
        GameRegistry.registerItem(greenLuxinPickaxe, Names.Tools.GREEN_LUXIN_PICKAXE);
        GameRegistry.registerItem(yellowLuxinPickaxe, Names.Tools.YELLOW_LUXIN_PICKAXE);
        GameRegistry.registerItem(softCloth, Names.Items.SOFT_CLOTH);
        GameRegistry.registerItem(ruby, Names.Items.RUBY);
        GameRegistry.registerItem(sapphire, Names.Items.SAPPHIRE);
        GameRegistry.registerItem(garnet, Names.Items.GARNET);
        GameRegistry.registerItem(citrine, Names.Items.CITRINE);
        GameRegistry.registerItem(spectacles, Names.Armors.SPECTACLES);
        GameRegistry.registerItem(lense, Names.Items.LENSE);

    }

    public static void registerRenders(){
        registerRender(blueLuxinPickaxe);
        registerRender(greenLuxinPickaxe);
        registerRender(yellowLuxinPickaxe);
        registerRender(softCloth);
        registerRender(ruby);
        registerRender(sapphire);
        registerRender(garnet);
        registerRender(citrine);
        registerRender(spectacles);
        registerRender(lense);
    }

    public static void registerRender(Item item){
        String itemname = item.getUnlocalizedName().substring(item.getUnlocalizedName().indexOf(":")+1);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + itemname, "inventory"));
    }
}
