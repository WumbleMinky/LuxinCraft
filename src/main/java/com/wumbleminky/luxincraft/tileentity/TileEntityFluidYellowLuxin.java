package com.wumbleminky.luxincraft.tileentity;

import com.wumbleminky.luxincraft.block.BlockFluid;
import com.wumbleminky.luxincraft.reference.Names;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityFluidYellowLuxin extends TileEntity implements IUpdatePlayerListBox {

    private int lifespanInTicks = -1;
    public static final int DEFAULT_LIFESPAN = 3;

    public TileEntityFluidYellowLuxin(){
        this(DEFAULT_LIFESPAN);
    }

    public TileEntityFluidYellowLuxin(int lifespanInSeconds){
        super();
        lifespanInTicks = lifespanInSeconds * 20;
    }

    @Override
    public void writeToNBT(NBTTagCompound compound){
        super.writeToNBT(compound);
        if (lifespanInTicks > 0){
            compound.setInteger(Names.NBT.LIFESPAN_IN_TICKS, lifespanInTicks);
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);
        if (compound.hasKey(Names.NBT.LIFESPAN_IN_TICKS)){
            lifespanInTicks = compound.getInteger(Names.NBT.LIFESPAN_IN_TICKS);
        }
    }

    @Override
    public Packet getDescriptionPacket(){
        NBTTagCompound compound = new NBTTagCompound();
        writeToNBT(compound);
        int metadata = getBlockMetadata();
        return new S35PacketUpdateTileEntity(this.pos, metadata, compound);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt){
        readFromNBT(pkt.getNbtCompound());
    }

    @Override
    public void update() {
        if (!this.hasWorldObj()) return;
        World world = this.getWorld();
        if (world.isRemote) return;
        if ((Integer)world.getBlockState(this.pos).getValue(BlockFluid.LEVEL) != 0) {
            this.invalidate();
            return;
        }
        if (lifespanInTicks < 0) return;
        lifespanInTicks--;
        if (lifespanInTicks > 0) return;
        BlockFluid block = (BlockFluid)world.getBlockState(pos).getBlock();
        if (block != null){
            if (block.isSourceBlock(world, pos)){
                world.setBlockToAir(pos);
            }
        }
    }
}
