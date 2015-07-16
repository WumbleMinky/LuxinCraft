package com.wumbleminky.luxincraft.init;

import com.wumbleminky.luxincraft.item.*;
import com.wumbleminky.luxincraft.reference.Material;
import com.wumbleminky.luxincraft.reference.Names;
import com.wumbleminky.luxincraft.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
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
    public static final ItemLuxinCraft wire = new ItemLuxinCraft(Names.Items.WIRE);
    public static final ItemLuxinCraft sandpaper = new ItemLuxinCraft(Names.Items.SANDPAPER);
    public static final ItemLuxinCraft polished_iron = new ItemLuxinCraft(Names.Items.POLISHED_IRON);

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
        GameRegistry.registerItem(wire, Names.Items.WIRE);
        GameRegistry.registerItem(sandpaper, Names.Items.SANDPAPER);
        GameRegistry.registerItem(polished_iron, Names.Items.POLISHED_IRON);
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
        registerRender(wire);
        registerRender(sandpaper);
        registerRender(polished_iron);
    }

    public static void registerRender(Item item){
        registerRender(item,0,Names.getName(item));
    }

    public static void registerRender(Item item, int metadata, String itemName){
        ItemModelMesher modelRegistry = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
        modelRegistry.register(item, metadata, new ModelResourceLocation(Reference.withMODID(itemName), "inventory"));
    }
}
