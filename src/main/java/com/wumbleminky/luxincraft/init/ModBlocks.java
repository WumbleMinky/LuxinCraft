package com.wumbleminky.luxincraft.init;

import com.wumbleminky.luxincraft.block.*;
import com.wumbleminky.luxincraft.reference.Names;
import com.wumbleminky.luxincraft.reference.Reference;
import net.minecraft.block.Block;
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
        register(solidYellowLuxin);
        register(solidGreenLuxin);
        register(solidBlueLuxin);
        register(oreRuby);
        register(oreCitrine);
        register(oreSapphire);
        register(oreGarnet);
        register(worktable);
    }

    public static void register(Block block){
        GameRegistry.registerBlock(block, Names.getName(block));
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
        String resource_name = Reference.withMODID(Names.getName(block));
        itemModelMesher.register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(resource_name, "inventory"));
    }
}
