package com.wumbleminky.luxincraft.reference;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class Names {

    public static final String[] LUXIN_COLOURS = new String[] {"subred", "red", "orange", "yellow", "green", "blue", "superviolet"};
    public static final String[] SOLID_LUXINS = Arrays.copyOfRange(LUXIN_COLOURS,3,6);
    public static final String[] VISIBLE_LUXINS = Arrays.copyOfRange(LUXIN_COLOURS, 1, 7);

    public static String getUnwrappedName(String unlocalizedName){
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    public static String getName(String unlocalizedName){
        return unlocalizedName.substring(unlocalizedName.indexOf(":") + 1);
    }

    public static String getName(Block block){
        return getName(block.getUnlocalizedName());
    }

    public static String getName(Item item){
        return getName(item.getUnlocalizedName());
    }

    public static final class Blocks {
        public static final String SOLID_BLUE_LUXIN = "block_blue_luxin_solid";
        public static final String SOLID_GREEN_LUXIN = "block_green_luxin_solid";
        public static final String SOLID_YELLOW_LUXIN = "block_yellow_luxin_solid";

        public static final String ORE_RUBY = "ore_ruby";
        public static final String ORE_SAPPHIRE = "ore_sapphire";
        public static final String ORE_GARNET = "ore_garnet";
        public static final String ORE_CITRINE = "ore_citrine";

        public static final String WORKTABLE = "block_worktable";

        public static final String FLUID_YELLOW_LUXIN = "block_fluid_yellow_luxin";
    }

    public static final class Items {
        public static final String SOFT_CLOTH = "soft_cloth";
        public static final String BUCKET = "bucket";
        public static final String BUCKET_YELLOW_LUXIN = "bucket_yellow_luxin";

        //lenses
        public static final String LENSE_CLEAR = "lense_clear";
        public static final String LENSE_BLUE = "lense_blue";
        public static final String LENSE_GREEN = "lense_green";
        public static final String LENSE_ORANGE = "lense_orange";
        public static final String LENSE_YELLOW = "lense_yellow";
        public static final String LENSE_RED = "lense_red";
        public static final String LENSE = "lense";
        public static final String[] LENSES = new String[]{LENSE_BLUE, LENSE_RED, LENSE_YELLOW, LENSE_ORANGE, LENSE_GREEN, LENSE_CLEAR};

        //gems
        public static final String RUBY = "ruby";
        public static final String SAPPHIRE = "sapphire";
        public static final String GARNET = "garnet";
        public static final String CITRINE = "citrine";
    }

    public static final class Armors {
        public static final String SPECTACLES = "spectacles";
    }

    public static final class Materials {
        public static final String BLUE_LUXIN = "blue_luxin";
        public static final String GREEN_LUXIN = "green_luxin";
        public static final String YELLOW_LUXIN = "yellow_luxin";

        public static final String SPECTACLES = "spectacles";
    }

    public static final class Fluids {
        public static final String YELLOW_LUXIN = "yellow_luxin";
    }

    public static final class Keys {
        public static final String CATEGORY = "keys.luxincraft.category";
        public static final String ACTIVATE = "keys.luxincraft.activate";
    }

    public static final class Tools {
        public static final String BLUE_LUXIN_PICKAXE = "blue_luxin_pickaxe";
        public static final String GREEN_LUXIN_PICKAXE = "green_luxin_pickaxe";
        public static final String YELLOW_LUXIN_PICKAXE = "yellow_luxin_pickaxe";
    }

    public static final class NBT {
        public static final String DISPLAY = "display";
        public static final String COLOR = "luxincolor";
        public static final String INVENTORY = "inventory";
        public static final String FACING = "facing";
        public static final String LIFESPAN_IN_TICKS = "lifespanInTicks";
    }

    public static final class Textures {
        public static final String STILL_YELLOW_LUXIN = "blocks/fluid_yellow_luxin_still";
        public static final String FLOWING_YELLOW_LUXIN = "blocks/fluid_yellow_luxin_flowing";
    }
}
