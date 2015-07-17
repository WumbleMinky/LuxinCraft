package com.wumbleminky.luxincraft.reference;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class Material {

    public static final class Tools{
        public static final Item.ToolMaterial BLUE_LUXIN = EnumHelper.addToolMaterial(Names.Materials.BLUE_LUXIN, 2, 150, 6.0F, 2.0F, 5);
        public static final Item.ToolMaterial GREEN_LUXIN = EnumHelper.addToolMaterial(Names.Materials.GREEN_LUXIN, 1, 300, 6.0F, 1.0F, 5);
        public static final Item.ToolMaterial YELLOW_LUXIN = EnumHelper.addToolMaterial(Names.Materials.YELLOW_LUXIN, 3, 1500, 8.0F, 3.0F, 5);

    }

    public static final class Armors{
        public static final ItemArmor.ArmorMaterial SPECTACLES = EnumHelper.addArmorMaterial(Names.Materials.SPECTACLES, Reference.withMODID(Names.Materials.SPECTACLES), 10, new int[]{0,0,0,0}, 0);
        public static final ItemArmor.ArmorMaterial BLUE_LUXIN = EnumHelper.addArmorMaterial(Names.Materials.BLUE_LUXIN_ARMOR, Reference.withMODID(Names.Materials.BLUE_LUXIN_ARMOR), 5, new int[]{2,6,5,2}, 0);
        public static final ItemArmor.ArmorMaterial GREEN_LUXIN = EnumHelper.addArmorMaterial(Names.Materials.GREEN_LUXIN_ARMOR, Reference.withMODID(Names.Materials.GREEN_LUXIN_ARMOR), 15, new int[]{1,3,2,1}, 0);
        public static final ItemArmor.ArmorMaterial YELLOW_LUXIN = EnumHelper.addArmorMaterial(Names.Materials.YELLOW_LUXIN_ARMOR, Reference.withMODID(Names.Materials.YELLOW_LUXIN_ARMOR), 33, new int[]{3,8,6,3}, 0);
    }
}
