package com.wumbleminky.luxincraft.item;

import com.wumbleminky.luxincraft.creativetab.CreativeTabLC;
import com.wumbleminky.luxincraft.reference.Names;
import com.wumbleminky.luxincraft.reference.Reference;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemLuxinSword extends ItemSword {

    public ItemLuxinSword(ToolMaterial material, String name) {
        super(material);
        setCreativeTab(CreativeTabLC.LuxinCraftTab);
        this.setUnlocalizedName(name);
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
