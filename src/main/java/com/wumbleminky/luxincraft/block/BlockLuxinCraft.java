package com.wumbleminky.luxincraft.block;

import com.wumbleminky.luxincraft.creativetab.CreativeTabLC;
import com.wumbleminky.luxincraft.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockLuxinCraft extends Block {

    public BlockLuxinCraft(){
        this(Material.rock);
    }

    public BlockLuxinCraft(Material material) {
        super(material);
        setCreativeTab(CreativeTabLC.LuxinCraftTab);
    }

    @Override
    public String getUnlocalizedName(){
        return String.format("tile.%s:%s", Reference.MOD_ID, getUnwrappedLocalizedName(super.getUnlocalizedName()));
    }

    protected String getUnwrappedLocalizedName(String unlocalizedName){
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    public String getName(){
        return null;
    }
}
