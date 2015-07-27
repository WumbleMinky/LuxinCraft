package com.wumbleminky.luxincraft.item;

import com.wumbleminky.luxincraft.reference.Colors;
import com.wumbleminky.luxincraft.reference.Names;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemSandpaper extends ItemLuxinCraft {

    public ItemSandpaper(){
        super(Names.Items.SANDPAPER);
        setMaxStackSize(1);
        setMaxDamage(64);
    }
}
