package com.wumbleminky.luxincraft.tileentity;

import com.wumbleminky.luxincraft.reference.Names;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

public class TileEntityWorktable extends TileEntity {

    private ItemStack inventory;
    private EnumFacing facing;

    public TileEntityWorktable(){
        super();
        inventory = null;
        facing = null;
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound){
        super.writeToNBT(nbtTagCompound);
        if (inventory != null){
            NBTTagList tagList = new NBTTagList();
            NBTTagCompound invCompound = new NBTTagCompound();
            inventory.writeToNBT(invCompound);
            tagList.appendTag(invCompound);
            nbtTagCompound.setTag(Names.NBT.INVENTORY, tagList);
        }
        if (facing != null){
            nbtTagCompound.setInteger(Names.NBT.FACING, facing.getIndex());
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound)
    {
        super.readFromNBT(nbtTagCompound);
        NBTTagList tagList = nbtTagCompound.getTagList(Names.NBT.INVENTORY, 10);
        if (tagList.tagCount() > 0){
            inventory = ItemStack.loadItemStackFromNBT(tagList.getCompoundTagAt(0));
        }else{
            inventory = null;
        }
        if (nbtTagCompound.hasKey(Names.NBT.FACING)){
            facing = EnumFacing.getFront(nbtTagCompound.getInteger(Names.NBT.FACING));
        }else{
            facing = null;
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

    public void setFacing(EnumFacing facingIndex){
        facing = facingIndex;
    }

    public EnumFacing getFacing(){
        return facing;
    }

    public ItemStack getInventory(){
        return inventory;
    }

    public void setInventory(ItemStack itemStack){
        inventory = itemStack;
        needsUpdate();
    }

    public boolean hasInventory(){
        return inventory != null;
    }

    public void clearInventory(){
        inventory = null;
        needsUpdate();
    }

    private void needsUpdate(){
        this.markDirty();
        this.worldObj.markBlockForUpdate(this.pos);
    }
}
