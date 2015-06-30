package com.wumbleminky.luxincraft.reference;


import java.util.HashMap;
import java.util.Map;

public class Colors {

    public static final int WHITE = 0xFFFFFF;

    public static class Luxin{
        public static final int SUBRED = 0x680000;
        public static final int RED = 0xFF0000;
        public static final int ORANGE = 0xFF6600;
        public static final int YELLOW = 0xffff00;
        public static final int GREEN = 0x00FF00;
        public static final int BLUE = 0x0000FF;
        public static final int SUPERVIOLET = 0xff66ff;
        public static final int[] COLORS = new int[]{SUBRED,RED,ORANGE,YELLOW,GREEN,BLUE,SUPERVIOLET};
    }

    public static final Map<String, String[]> LUXIN_TO_TEXT_MAP;
    static {
        Map<String, String[]> aMap = new HashMap<String, String[]>();
        aMap.put(Integer.toString(Luxin.SUBRED), new String[]{"\u00A74", "Subred"});
        aMap.put(Integer.toString(Luxin.RED), new String[]{"\u00A7c", "Red"});
        aMap.put(Integer.toString(Luxin.ORANGE), new String[]{"\u00A76", "Orange"});
        aMap.put(Integer.toString(Luxin.YELLOW), new String[]{"\u00a7e", "Yellow"});
        aMap.put(Integer.toString(Luxin.GREEN), new String[]{"\u00A72", "Green"});
        aMap.put(Integer.toString(Luxin.BLUE), new String[]{"\u00A71", "Blue"});
        aMap.put(Integer.toString(Luxin.SUPERVIOLET), new String[]{"\u00A75", "Superviolet"});
        LUXIN_TO_TEXT_MAP =  aMap;
    }
}
