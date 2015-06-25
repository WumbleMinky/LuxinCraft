package com.wumbleminky.luxincraft.creativetab;

import com.wumbleminky.luxincraft.init.ModItems;
import com.wumbleminky.luxincraft.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabLC {
    public static final CreativeTabs LuxinCraftTab = new CreativeTabs(Reference.MOD_ID) {
        @Override
        public Item getTabIconItem() {
            return ModItems.blueLuxinPickaxe;
        }

        @Override
        public String getTranslatedTabLabel(){
            return Reference.MOD_NAME;
        }
    };
}
