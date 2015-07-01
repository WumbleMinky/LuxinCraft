package com.wumbleminky.luxincraft.block;

import com.wumbleminky.luxincraft.init.ModItems;
import com.wumbleminky.luxincraft.reference.Names;
import com.wumbleminky.luxincraft.utility.LogHelper;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockOre extends BlockLuxinCraft {


    public BlockOre(String name){
        super();
        this.setHardness(3.0F);
        this.setResistance(100.0f);
        setUnlocalizedName(name);
        this.setHarvestLevel("pickaxe", 2);
    }

    @Override
    public Item getItemDropped(IBlockState blockState, Random random, int fortune ){
        String name = this.getName();
        if (name.equals(Names.Blocks.ORE_RUBY)){
            return ModItems.ruby;
        }else if (name.equals(Names.Blocks.ORE_SAPPHIRE)){
            return ModItems.sapphire;
        }else if (name.equals(Names.Blocks.ORE_GARNET)){
            return ModItems.garnet;
        }else if (name.equals(Names.Blocks.ORE_CITRINE)){
            return ModItems.citrine;
        }
        return null;
    }

    @Override
    public int quantityDropped(Random random){
        return 1;
    }

}
