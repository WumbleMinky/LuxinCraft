package com.wumbleminky.luxincraft.item;

import com.wumbleminky.luxincraft.creativetab.CreativeTabLC;
import com.wumbleminky.luxincraft.reference.Reference;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemArmorLuxinCraft extends ItemArmor {

    public ItemArmorLuxinCraft(String name, ArmorMaterial material, int renderIndex, int armorType){
        super(material, renderIndex, armorType);
        setUnlocalizedName(name);
        setCreativeTab(CreativeTabLC.LuxinCraftTab);
    }

    @Override
    public String getUnlocalizedName(){
        return String.format("item.%s:%s", Reference.MOD_ID.toLowerCase(), getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack){
        return String.format("item.%s:%s", Reference.MOD_ID.toLowerCase(), getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName){
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
