package com.wumbleminky.luxincraft.item;

import com.wumbleminky.luxincraft.reference.Colors;
import com.wumbleminky.luxincraft.reference.Material;
import com.wumbleminky.luxincraft.reference.Names;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ItemSpectacles extends ItemArmorLuxinCraft {

    public ItemSpectacles(){
        super(Names.Armors.SPECTACLES, Material.Armors.SPECTACLES, 1, ItemArmorLuxinCraft.HELMET_TYPE);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack stack, int renderPass){
        if (renderPass > 0){
            return Colors.WHITE;
        }
        return getColor(stack);
    }

    @Override
    public boolean hasColor(ItemStack stack) {
        return (stack.hasTagCompound() &&
                stack.getTagCompound().hasKey(Names.NBT.DISPLAY) &&
                stack.getTagCompound().getCompoundTag(Names.NBT.DISPLAY).hasKey(Names.NBT.COLOR));
    }

    @Override
    public int getColor(ItemStack stack){
        if (hasColor(stack)){
            NBTTagCompound nbtTagCompound = stack.getTagCompound().getCompoundTag(Names.NBT.DISPLAY);
            return nbtTagCompound.getInteger(Names.NBT.COLOR);

        }
        return Colors.WHITE;
    }

    @Override
    public void removeColor(ItemStack stack){
        NBTTagCompound nbttagcompound = stack.getTagCompound();

        if (nbttagcompound != null){
            NBTTagCompound nbttagcompoundDisplay = nbttagcompound.getCompoundTag(Names.NBT.DISPLAY);

            if (nbttagcompoundDisplay.hasKey(Names.NBT.COLOR)){
                nbttagcompoundDisplay.removeTag(Names.NBT.COLOR);
            }
        }
    }

    @Override
    public void setColor(ItemStack stack, int color){
        NBTTagCompound nbttagcompound = stack.getTagCompound();

        if (nbttagcompound == null){
            nbttagcompound = new NBTTagCompound();
            stack.setTagCompound(nbttagcompound);
        }

        NBTTagCompound nbtTagCompoundDisplay = nbttagcompound.getCompoundTag(Names.NBT.DISPLAY);
        if (!nbttagcompound.hasKey(Names.NBT.DISPLAY)){
            nbttagcompound.setTag(Names.NBT.DISPLAY, nbtTagCompoundDisplay);
        }

        nbtTagCompoundDisplay.setInteger(Names.NBT.COLOR, color);
    }

    @SideOnly(Side.CLIENT)
    public void getSubItems(Item itemIn, CreativeTabs tab, List subItems){
        for (int color: Colors.Luxin.COLORS){
            ItemStack itemStack = new ItemStack(itemIn, 1, 0);
            setColor(itemStack, color);
            subItems.add(itemStack);
        }
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
        if (hasColor(stack)){
            String colorInt = Integer.toString(getColor(stack));
            if (Colors.LUXIN_TO_TEXT_MAP.containsKey(colorInt)){
                tooltip.add(Colors.LUXIN_TO_TEXT_MAP.get(colorInt)[0] + Colors.LUXIN_TO_TEXT_MAP.get(colorInt)[1]);
            }


        }
    }
}
