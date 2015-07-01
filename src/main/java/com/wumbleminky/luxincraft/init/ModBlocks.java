package com.wumbleminky.luxincraft.init;

import com.wumbleminky.luxincraft.block.*;
import com.wumbleminky.luxincraft.reference.Names;
import com.wumbleminky.luxincraft.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {

    public static final BlockLuxinCraft solidBlueLuxin = new BlockSolidBlueLuxin();
    public static final BlockLuxinCraft solidGreenLuxin = new BlockSolidGreenLuxin();
    public static final BlockLuxinCraft solidYellowLuxin = new BlockSolidYellowLuxin();

    public static final BlockLuxinCraft oreRuby = new BlockOre(Names.Blocks.ORE_RUBY);
    public static final BlockLuxinCraft oreSapphire = new BlockOre(Names.Blocks.ORE_SAPPHIRE);
    public static final BlockLuxinCraft oreGarnet = new BlockOre(Names.Blocks.ORE_GARNET);
    public static final BlockLuxinCraft oreCitrine = new BlockOre(Names.Blocks.ORE_CITRINE);

    public static final BlockLuxinCraft worktable = new BlockWorktable();

    public static void init(){
        registerBlock(solidBlueLuxin);
        registerBlock(solidGreenLuxin);
        registerBlock(solidYellowLuxin);
        registerBlock(oreRuby);
        registerBlock(oreSapphire);
        registerBlock(oreGarnet);
        registerBlock(oreCitrine);
        registerBlock(worktable);
    }

    public static void registerBlock(BlockLuxinCraft block){
        GameRegistry.registerBlock(block, block.getName());
    }

    public static void registerRenders(){
        registerRender(solidBlueLuxin);
        registerRender(solidGreenLuxin);
        registerRender(solidYellowLuxin);
        registerRender(oreRuby);
        registerRender(oreSapphire);
        registerRender(oreGarnet);
        registerRender(oreCitrine);
        registerRender(worktable);
    }

    public static void registerRender(BlockLuxinCraft block){
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(Reference.MOD_ID + ":" + block.getName(), "inventory"));
    }
}
