package com.wumbleminky.luxincraft.item;

import com.wumbleminky.luxincraft.reference.Names;

public class ItemBlueLuxinPickaxe extends ItemLuxinCraft {

    public ItemBlueLuxinPickaxe(){
        super();
        this.setUnlocalizedName(Names.Tools.BLUE_LUXIN_PICKAXE);
        this.setMaxStackSize(1);
    }

    public String getName(){
        return Names.Tools.BLUE_LUXIN_PICKAXE;
    }
}
