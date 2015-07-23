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
    public static final ItemLuxinPickaxe blue_luxin_pickaxe = new ItemLuxinPickaxe(Material.Tools.BLUE_LUXIN, Names.Tools.BLUE_LUXIN_PICKAXE);
    public static final ItemLuxinPickaxe green_luxin_pickaxe = new ItemLuxinPickaxe(Material.Tools.GREEN_LUXIN, Names.Tools.GREEN_LUXIN_PICKAXE);
    public static final ItemLuxinPickaxe yellow_luxin_pickaxe = new ItemLuxinPickaxe(Material.Tools.YELLOW_LUXIN, Names.Tools.YELLOW_LUXIN_PICKAXE);
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
    public static final ItemLuxinCraft ruby = new ItemGem(Names.Items.RUBY);
    public static final ItemLuxinCraft sapphire = new ItemGem(Names.Items.SAPPHIRE);
    public static final ItemLuxinCraft garnet = new ItemGem(Names.Items.GARNET);
    public static final ItemLuxinCraft citrine = new ItemGem(Names.Items.CITRINE);
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
        register(blue_luxin_pickaxe);
        register(green_luxin_pickaxe);
        register(yellow_luxin_pickaxe);
        register(softCloth);
        register(ruby);
        register(sapphire);
        register(garnet);
        register(citrine);
        register(spectacles);
        register(lense);
        register(wire);
        register(sandpaper);
        register(polished_iron);
        register(blue_luxin_helmet);
        register(blue_luxin_chestplate);
        register(blue_luxin_leggings);
        register(blue_luxin_boots);
        register(yellow_luxin_helmet);
        register(yellow_luxin_chestplate);
        register(yellow_luxin_leggings);
        register(yellow_luxin_boots);
        register(green_luxin_helmet);
        register(green_luxin_chestplate);
        register(green_luxin_leggings);
        register(green_luxin_boots);
        register(blue_luxin_sword);
        register(green_luxin_sword);
        register(yellow_luxin_sword);
        register(blue_luxin_shovel);
        register(green_luxin_shovel);
        register(yellow_luxin_shovel);
        register(blue_luxin_axe);
        register(green_luxin_axe);
        register(yellow_luxin_axe);
        register(blue_luxin_hoe);
        register(green_luxin_hoe);
        register(yellow_luxin_hoe);
    }

    public static void register(Item item){
        GameRegistry.registerItem(item, Names.getName(item));
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
