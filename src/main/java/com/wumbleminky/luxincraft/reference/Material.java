package com.wumbleminky.luxincraft.reference;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

public class Material {

    public static final class Tools{
        public static final Item.ToolMaterial BLUE_LUXIN = EnumHelper.addToolMaterial(Names.Materials.BLUE_LUXIN, 2, 150, 6.0F, 2.0F, 5);
        public static final Item.ToolMaterial GREEN_LUXIN = EnumHelper.addToolMaterial(Names.Materials.GREEN_LUXIN, 1, 300, 6.0F, 1.0F, 5);
        public static final Item.ToolMaterial YELLOW_LUXIN = EnumHelper.addToolMaterial(Names.Materials.YELLOW_LUXIN, 3, 1500, 8.0F, 3.0F, 5);

    }
}
