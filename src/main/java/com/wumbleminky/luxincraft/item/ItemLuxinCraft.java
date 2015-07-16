package com.wumbleminky.luxincraft.item;

import com.wumbleminky.luxincraft.creativetab.CreativeTabLC;
import com.wumbleminky.luxincraft.reference.Names;
import com.wumbleminky.luxincraft.reference.Reference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemLuxinCraft extends Item {

    public ItemLuxinCraft(){
        super();
        setCreativeTab(CreativeTabLC.LuxinCraftTab);
    }

    public ItemLuxinCraft(String name){
        this();
        setUnlocalizedName(name);
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
