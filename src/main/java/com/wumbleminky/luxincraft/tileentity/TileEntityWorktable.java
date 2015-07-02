package com.wumbleminky.luxincraft.tileentity;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityWorktable extends TileEntity {

    private ItemStack inventory;

    public TileEntityWorktable(){
        super();
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound){
        super.writeToNBT(nbtTagCompound);
        if (inventory != null){
            NBTTagList tagList = new NBTTagList();
            NBTTagCompound invCompound = new NBTTagCompound();
            inventory.writeToNBT(invCompound);
            tagList.appendTag(invCompound);
            nbtTagCompound.setTag("inventory", tagList);
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound)
    {
        super.readFromNBT(nbtTagCompound);
        NBTTagList tagList = nbtTagCompound.getTagList("inventory", 10);
        if (tagList.tagCount() > 0){
            inventory = ItemStack.loadItemStackFromNBT(tagList.getCompoundTagAt(0));
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

    public ItemStack getInventory(){
        return inventory;
    }

    public void setInventory(ItemStack itemStack){
        inventory = itemStack;
    }

    public boolean hasInventory(){
        return inventory != null;
    }

    public void clearInventory(){
        inventory = null;
    }
}
