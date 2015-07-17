package com.wumbleminky.luxincraft.item;

import com.wumbleminky.luxincraft.creativetab.CreativeTabLC;
import com.wumbleminky.luxincraft.reference.Names;
import com.wumbleminky.luxincraft.reference.Reference;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemArmorLuxinCraft extends ItemArmor {

    public static final int HELMET_TYPE = 0;
    public static final int CHESTPLATE_TYPE = 1;
    public static final int LEGGINGS_TYPE = 2;
    public static final int BOOTS_TYPE = 3;

    public ItemArmorLuxinCraft(ArmorMaterial material, int renderIndex, int armorType){
        super(material, renderIndex, armorType);
        setCreativeTab(CreativeTabLC.LuxinCraftTab);
    }

    public ItemArmorLuxinCraft(String name, ArmorMaterial material, int renderIndex, int armorType){
        this(material,renderIndex,armorType);
        setUnlocalizedName(name);
    }
    public ItemArmorLuxinCraft(String name, ArmorMaterial material, int armorType){
        this(name, material, 0, armorType);
    }

    @Override
    public String getUnlocalizedName(){
        return String.format("item.%s", Reference.withMODID(Names.getUnwrappedName(super.getUnlocalizedName())));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack){
        return this.getUnlocalizedName();
    }
}
