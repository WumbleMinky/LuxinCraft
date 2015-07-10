package com.wumbleminky.luxincraft.init;

import com.wumbleminky.luxincraft.block.BlockFluid;
import com.wumbleminky.luxincraft.item.ItemLuxinCraftBucket;
import com.wumbleminky.luxincraft.reference.Names;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModFluids {

    public static final Fluid fluidYellowLuxin = new Fluid(Names.Fluids.YELLOW_LUXIN);

    public static BlockFluid blockFluidYellowLuxin;

    public static final ItemLuxinCraftBucket bucket = new ItemLuxinCraftBucket();

    public static void init(){
        FluidRegistry.registerFluid(fluidYellowLuxin);

        blockFluidYellowLuxin = new BlockFluid(fluidYellowLuxin, Material.water, Names.Fluids.YELLOW_LUXIN);
        GameRegistry.registerBlock(blockFluidYellowLuxin, null, Names.Blocks.FLUID_YELLOW_LUXIN);

        bucket.addFluidBlock(blockFluidYellowLuxin);

        GameRegistry.registerItem(bucket, Names.Items.BUCKET);
    }

    public static void registerRenders(){
        ModItems.registerRender(bucket, 0, Names.Items.BUCKET_YELLOW_LUXIN);
    }
}
