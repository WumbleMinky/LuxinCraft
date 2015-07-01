package com.wumbleminky.luxincraft.item;

import com.wumbleminky.luxincraft.reference.Colors;
import com.wumbleminky.luxincraft.reference.Names;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ItemLense extends ItemLuxinCraft {

    public ItemLense(){
        super();
        this.setMaxStackSize(1);
        this.setMaxDamage(64);
        this.setHasSubtypes(false);
        this.setNoRepair();
        this.setUnlocalizedName(Names.Items.LENSE);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack stack, int renderPass){
        if (renderPass > 0){
            return Colors.WHITE;
        }
        return getColor(stack);
    }

    public boolean hasColor(ItemStack stack)
    {
        if (stack.hasTagCompound() &&
                stack.getTagCompound().hasKey(Names.NBT.DISPLAY) &&
                stack.getTagCompound().getCompoundTag(Names.NBT.DISPLAY).hasKey(Names.NBT.COLOR)){
            return true;
        }
        return false;
    }

    public int getColor(ItemStack stack){
        if (hasColor(stack)){
            NBTTagCompound nbtTagCompound = stack.getTagCompound().getCompoundTag(Names.NBT.DISPLAY);
            return nbtTagCompound.getInteger(Names.NBT.COLOR);

        }
        return Colors.WHITE;
    }

    public void removeColor(ItemStack stack){
        NBTTagCompound nbttagcompound = stack.getTagCompound();

        if (nbttagcompound != null){
            NBTTagCompound nbttagcompoundDisplay = nbttagcompound.getCompoundTag(Names.NBT.DISPLAY);

            if (nbttagcompoundDisplay.hasKey(Names.NBT.COLOR)){
                nbttagcompoundDisplay.removeTag(Names.NBT.COLOR);
            }
        }
    }

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
