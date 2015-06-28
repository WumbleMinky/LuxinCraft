package com.wumbleminky.luxincraft.item;

public class ItemLense extends ItemLuxinCraft {

    public ItemLense(String name){
        super();
        this.setMaxStackSize(1);
        this.setMaxDamage(64);
        this.setHasSubtypes(false);
        this.setNoRepair();
        this.setUnlocalizedName(name);
    }
}
