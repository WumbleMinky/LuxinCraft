package com.wumbleminky.luxincraft.block;

import com.wumbleminky.luxincraft.creativetab.CreativeTabLC;
import com.wumbleminky.luxincraft.reference.Names;
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
        return String.format("tile.%s", Reference.withMODID(Names.getUnwrappedName(super.getUnlocalizedName())));
    }
}
