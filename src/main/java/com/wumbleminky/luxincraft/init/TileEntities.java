package com.wumbleminky.luxincraft.init;

import com.wumbleminky.luxincraft.reference.Names;
import com.wumbleminky.luxincraft.tileentity.TileEntityFluidYellowLuxin;
import com.wumbleminky.luxincraft.tileentity.TileEntityWorktable;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntities {

    public static void init(){
        GameRegistry.registerTileEntity(TileEntityWorktable.class, Names.Blocks.WORKTABLE);
        GameRegistry.registerTileEntity(TileEntityFluidYellowLuxin.class, Names.Blocks.FLUID_YELLOW_LUXIN);
    }

}
