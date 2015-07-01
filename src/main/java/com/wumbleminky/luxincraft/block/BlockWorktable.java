package com.wumbleminky.luxincraft.block;

import com.wumbleminky.luxincraft.reference.Names;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockWorktable extends BlockLuxinCraft {

    public BlockWorktable(){
        super(Material.wood);
        setUnlocalizedName(Names.Blocks.WORKTABLE);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (worldIn.isRemote) {
            return true;
        } else {

        }
        return true;
    }
}
