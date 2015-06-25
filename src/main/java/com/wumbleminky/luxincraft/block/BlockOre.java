package com.wumbleminky.luxincraft.block;

public class BlockOre extends BlockLuxinCraft {

    private String name;

    public BlockOre(String name){
        super();
        setUnlocalizedName(name);
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

}
