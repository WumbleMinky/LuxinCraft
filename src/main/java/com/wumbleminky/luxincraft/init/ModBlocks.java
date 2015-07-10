package com.wumbleminky.luxincraft.init;

import com.wumbleminky.luxincraft.block.*;
import com.wumbleminky.luxincraft.reference.Names;
import com.wumbleminky.luxincraft.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
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
        GameRegistry.registerBlock(solidYellowLuxin, Names.Blocks.SOLID_YELLOW_LUXIN);
        GameRegistry.registerBlock(solidGreenLuxin, Names.Blocks.SOLID_GREEN_LUXIN);
        GameRegistry.registerBlock(solidBlueLuxin, Names.Blocks.SOLID_BLUE_LUXIN);
        GameRegistry.registerBlock(oreRuby, Names.Blocks.ORE_RUBY);
        GameRegistry.registerBlock(oreCitrine, Names.Blocks.ORE_CITRINE);
        GameRegistry.registerBlock(oreSapphire, Names.Blocks.ORE_SAPPHIRE);
        GameRegistry.registerBlock(oreGarnet, Names.Blocks.ORE_GARNET);
        GameRegistry.registerBlock(worktable, Names.Blocks.WORKTABLE);
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
        ItemModelMesher itemModelMesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
        itemModelMesher.register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(Reference.withMODID(Names.getName(block)), "inventory"));
    }
}
