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
    public static final LuxinPickaxe blue_luxin_pickaxe = new LuxinPickaxe(Material.Tools.BLUE_LUXIN, Names.Tools.BLUE_LUXIN_PICKAXE);
    public static final LuxinPickaxe green_luxin_pickaxe = new LuxinPickaxe(Material.Tools.GREEN_LUXIN, Names.Tools.GREEN_LUXIN_PICKAXE);
    public static final LuxinPickaxe yellow_luxin_pickaxe = new LuxinPickaxe(Material.Tools.YELLOW_LUXIN, Names.Tools.YELLOW_LUXIN_PICKAXE);
    public static final ItemLuxinSword blue_luxin_sword = new ItemLuxinSword(Material.Tools.BLUE_LUXIN, Names.Tools.BLUE_LUXIN_SWORD);
    public static final ItemLuxinSword green_luxin_sword = new ItemLuxinSword(Material.Tools.GREEN_LUXIN, Names.Tools.GREEN_LUXIN_SWORD);
    public static final ItemLuxinSword yellow_luxin_sword = new ItemLuxinSword(Material.Tools.YELLOW_LUXIN, Names.Tools.YELLOW_LUXIN_SWORD);
    public static final ItemLuxinShovel blue_luxin_shovel = new ItemLuxinShovel(Material.Tools.BLUE_LUXIN, Names.Tools.BLUE_LUXIN_SHOVEL);
    public static final ItemLuxinShovel green_luxin_shovel = new ItemLuxinShovel(Material.Tools.GREEN_LUXIN, Names.Tools.GREEN_LUXIN_SHOVEL);
    public static final ItemLuxinShovel yellow_luxin_shovel = new ItemLuxinShovel(Material.Tools.YELLOW_LUXIN, Names.Tools.YELLOW_LUXIN_SHOVEL);
    public static final ItemLuxinAxe blue_luxin_axe = new ItemLuxinAxe(Material.Tools.BLUE_LUXIN, Names.Tools.BLUE_LUXIN_AXE);
    public static final ItemLuxinAxe green_luxin_axe = new ItemLuxinAxe(Material.Tools.GREEN_LUXIN, Names.Tools.GREEN_LUXIN_AXE);
    public static final ItemLuxinAxe yellow_luxin_axe = new ItemLuxinAxe(Material.Tools.YELLOW_LUXIN, Names.Tools.YELLOW_LUXIN_AXE);
    public static final ItemLuxinHoe blue_luxin_hoe = new ItemLuxinHoe(Material.Tools.BLUE_LUXIN, Names.Tools.BLUE_LUXIN_HOE);
    public static final ItemLuxinHoe green_luxin_hoe = new ItemLuxinHoe(Material.Tools.GREEN_LUXIN, Names.Tools.GREEN_LUXIN_HOE);
    public static final ItemLuxinHoe yellow_luxin_hoe = new ItemLuxinHoe(Material.Tools.YELLOW_LUXIN, Names.Tools.YELLOW_LUXIN_HOE);

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
    public static final ItemArmorLuxinCraft blue_luxin_helmet = new ItemArmorLuxinCraft(Names.Armors.BLUE_LUXIN_HELMET, Material.Armors.BLUE_LUXIN, ItemArmorLuxinCraft.HELMET_TYPE);
    public static final ItemArmorLuxinCraft blue_luxin_chestplate = new ItemArmorLuxinCraft(Names.Armors.BLUE_LUXIN_CHESTPLATE, Material.Armors.BLUE_LUXIN, ItemArmorLuxinCraft.CHESTPLATE_TYPE);
    public static final ItemArmorLuxinCraft blue_luxin_leggings = new ItemArmorLuxinCraft(Names.Armors.BLUE_LUXIN_LEGGINGS, Material.Armors.BLUE_LUXIN, ItemArmorLuxinCraft.LEGGINGS_TYPE);
    public static final ItemArmorLuxinCraft blue_luxin_boots = new ItemArmorLuxinCraft(Names.Armors.BLUE_LUXIN_BOOTS, Material.Armors.BLUE_LUXIN, ItemArmorLuxinCraft.BOOTS_TYPE);
    public static final ItemArmorLuxinCraft yellow_luxin_helmet = new ItemArmorLuxinCraft(Names.Armors.YELLOW_LUXIN_HELMET, Material.Armors.YELLOW_LUXIN, ItemArmorLuxinCraft.HELMET_TYPE);
    public static final ItemArmorLuxinCraft yellow_luxin_chestplate = new ItemArmorLuxinCraft(Names.Armors.YELLOW_LUXIN_CHESTPLATE, Material.Armors.YELLOW_LUXIN, ItemArmorLuxinCraft.CHESTPLATE_TYPE);
    public static final ItemArmorLuxinCraft yellow_luxin_leggings = new ItemArmorLuxinCraft(Names.Armors.YELLOW_LUXIN_LEGGINGS, Material.Armors.YELLOW_LUXIN, ItemArmorLuxinCraft.LEGGINGS_TYPE);
    public static final ItemArmorLuxinCraft yellow_luxin_boots = new ItemArmorLuxinCraft(Names.Armors.YELLOW_LUXIN_BOOTS, Material.Armors.YELLOW_LUXIN, ItemArmorLuxinCraft.BOOTS_TYPE);
    public static final ItemArmorLuxinCraft green_luxin_helmet = new ItemArmorLuxinCraft(Names.Armors.GREEN_LUXIN_HELMET, Material.Armors.GREEN_LUXIN, ItemArmorLuxinCraft.HELMET_TYPE);
    public static final ItemArmorLuxinCraft green_luxin_chestplate = new ItemArmorLuxinCraft(Names.Armors.GREEN_LUXIN_CHESTPLATE, Material.Armors.GREEN_LUXIN, ItemArmorLuxinCraft.CHESTPLATE_TYPE);
    public static final ItemArmorLuxinCraft green_luxin_leggings = new ItemArmorLuxinCraft(Names.Armors.GREEN_LUXIN_LEGGINGS, Material.Armors.GREEN_LUXIN, ItemArmorLuxinCraft.LEGGINGS_TYPE);
    public static final ItemArmorLuxinCraft green_luxin_boots = new ItemArmorLuxinCraft(Names.Armors.GREEN_LUXIN_BOOTS, Material.Armors.GREEN_LUXIN, ItemArmorLuxinCraft.BOOTS_TYPE);

    public static void init(){
        GameRegistry.registerItem(blue_luxin_pickaxe, Names.Tools.BLUE_LUXIN_PICKAXE);
        GameRegistry.registerItem(green_luxin_pickaxe, Names.Tools.GREEN_LUXIN_PICKAXE);
        GameRegistry.registerItem(yellow_luxin_pickaxe, Names.Tools.YELLOW_LUXIN_PICKAXE);
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
        GameRegistry.registerItem(blue_luxin_helmet, Names.Armors.BLUE_LUXIN_HELMET);
        GameRegistry.registerItem(blue_luxin_chestplate, Names.Armors.BLUE_LUXIN_CHESTPLATE);
        GameRegistry.registerItem(blue_luxin_leggings, Names.Armors.BLUE_LUXIN_LEGGINGS);
        GameRegistry.registerItem(blue_luxin_boots, Names.Armors.BLUE_LUXIN_BOOTS);
        GameRegistry.registerItem(yellow_luxin_helmet, Names.Armors.YELLOW_LUXIN_HELMET);
        GameRegistry.registerItem(yellow_luxin_chestplate, Names.Armors.YELLOW_LUXIN_CHESTPLATE);
        GameRegistry.registerItem(yellow_luxin_leggings, Names.Armors.YELLOW_LUXIN_LEGGINGS);
        GameRegistry.registerItem(yellow_luxin_boots, Names.Armors.YELLOW_LUXIN_BOOTS);
        GameRegistry.registerItem(green_luxin_helmet, Names.Armors.GREEN_LUXIN_HELMET);
        GameRegistry.registerItem(green_luxin_chestplate, Names.Armors.GREEN_LUXIN_CHESTPLATE);
        GameRegistry.registerItem(green_luxin_leggings, Names.Armors.GREEN_LUXIN_LEGGINGS);
        GameRegistry.registerItem(green_luxin_boots, Names.Armors.GREEN_LUXIN_BOOTS);
        GameRegistry.registerItem(blue_luxin_sword, Names.Tools.BLUE_LUXIN_SWORD);
        GameRegistry.registerItem(green_luxin_sword, Names.Tools.GREEN_LUXIN_SWORD);
        GameRegistry.registerItem(yellow_luxin_sword, Names.Tools.YELLOW_LUXIN_SWORD);
        GameRegistry.registerItem(blue_luxin_shovel, Names.Tools.BLUE_LUXIN_SHOVEL);
        GameRegistry.registerItem(green_luxin_shovel, Names.Tools.GREEN_LUXIN_SHOVEL);
        GameRegistry.registerItem(yellow_luxin_shovel, Names.Tools.YELLOW_LUXIN_SHOVEL);
        GameRegistry.registerItem(blue_luxin_axe, Names.Tools.BLUE_LUXIN_AXE);
        GameRegistry.registerItem(green_luxin_axe, Names.Tools.GREEN_LUXIN_AXE);
        GameRegistry.registerItem(yellow_luxin_axe, Names.Tools.YELLOW_LUXIN_AXE);
        GameRegistry.registerItem(blue_luxin_hoe, Names.Tools.BLUE_LUXIN_HOE);
        GameRegistry.registerItem(green_luxin_hoe, Names.Tools.GREEN_LUXIN_HOE);
        GameRegistry.registerItem(yellow_luxin_hoe, Names.Tools.YELLOW_LUXIN_HOE);
    }

    public static void registerRenders(){
        registerRender(blue_luxin_pickaxe);
        registerRender(green_luxin_pickaxe);
        registerRender(yellow_luxin_pickaxe);
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
        registerRender(blue_luxin_helmet);
        registerRender(blue_luxin_chestplate);
        registerRender(blue_luxin_leggings);
        registerRender(blue_luxin_boots);
        registerRender(yellow_luxin_helmet);
        registerRender(yellow_luxin_chestplate);
        registerRender(yellow_luxin_leggings);
        registerRender(yellow_luxin_boots);
        registerRender(green_luxin_helmet);
        registerRender(green_luxin_chestplate);
        registerRender(green_luxin_leggings);
        registerRender(green_luxin_boots);
        registerRender(blue_luxin_sword);
        registerRender(green_luxin_sword);
        registerRender(yellow_luxin_sword);
        registerRender(blue_luxin_shovel);
        registerRender(green_luxin_shovel);
        registerRender(yellow_luxin_shovel);
        registerRender(blue_luxin_axe);
        registerRender(green_luxin_axe);
        registerRender(yellow_luxin_axe);
        registerRender(blue_luxin_hoe);
        registerRender(green_luxin_hoe);
        registerRender(yellow_luxin_hoe);
    }

    public static void registerRender(Item item){
        registerRender(item,0,Names.getName(item));
    }

    public static void registerRender(Item item, int metadata, String itemName){
        ItemModelMesher modelRegistry = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
        modelRegistry.register(item, metadata, new ModelResourceLocation(Reference.withMODID(itemName), "inventory"));
    }
}
