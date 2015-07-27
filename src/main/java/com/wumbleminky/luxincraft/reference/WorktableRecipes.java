package com.wumbleminky.luxincraft.reference;

import com.wumbleminky.luxincraft.init.ModItems;
import com.wumbleminky.luxincraft.item.ItemLense;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WorktableRecipes {

    public static WorktableRecipes instance = new WorktableRecipes();

    private Map<Item, ToolRecipe> work_list= new HashMap<Item, ToolRecipe>();

    public WorktableRecipes(){
        addRecipe(ModItems.sandpaper, Blocks.glass_pane, ItemLense.getColoredLense(Colors.WHITE), 5);
        addRecipe(ModItems.sandpaper, Blocks.glass, Blocks.glass_pane, 10);

        addRecipe(ModItems.sandpaper, ModItems.ruby, ItemLense.getColoredLense(Colors.Luxin.RED), 5);
        addRecipe(ModItems.sandpaper, ModItems.garnet, ItemLense.getColoredLense(Colors.Luxin.ORANGE), 5);
        addRecipe(ModItems.sandpaper, ModItems.sapphire, ItemLense.getColoredLense(Colors.Luxin.BLUE), 5);
        addRecipe(ModItems.sandpaper, ModItems.citrine, ItemLense.getColoredLense(Colors.Luxin.YELLOW), 5);
        addRecipe(ModItems.sandpaper, Items.emerald, ItemLense.getColoredLense(Colors.Luxin.GREEN), 5);
    }

    public void addRecipe(Item tool, Block input, ItemStack result, int work){
        addRecipe(tool, Item.getItemFromBlock(input), result, work);
    }

    public void addRecipe(Item tool, Block input,  Block result, int work){
        addRecipe(tool, Item.getItemFromBlock(input), new ItemStack(result, 1, 0), work);
    }

    public void addRecipe(Item tool, Item input, ItemStack result, int work){
        if (!work_list.containsKey(tool)){
            work_list.put(tool, new ToolRecipe());
        }
        work_list.get(tool).addRecipe(input, result, work);
    }

    public static boolean hasRecipe(Item tool, Item input){
        return instance.work_list.containsKey(tool) && instance.work_list.get(tool).hasRecipe(input);
    }

    public static int getWork(Item tool, Item input){
        if (hasRecipe(tool, input)){
            return instance.work_list.get(tool).getWork(input);
        }
        return 0;
    }

    public static ItemStack getOutput(Item tool, Item input){
        if (hasRecipe(tool, input)){
            return instance.work_list.get(tool).getOutput(input);
        }
        return null;
    }

    private class ToolRecipe{
        private Map<Item, ArrayList> recipes = new HashMap<Item, ArrayList>();

        public void addRecipe(Item input, ItemStack output, int work_amount){
            ArrayList tmp = new ArrayList();
            tmp.add(output);
            tmp.add(work_amount);
            recipes.put(input, tmp);
        }

        public boolean hasRecipe(Item input){
            return recipes.containsKey(input);
        }

        public ItemStack getOutput(Item input){
            if (hasRecipe(input)){
                return ItemStack.copyItemStack((ItemStack)recipes.get(input).get(0));
            }
            return null;
        }

        public int getWork(Item input){
            if (hasRecipe(input)){
                return (Integer)recipes.get(input).get(1);
            }
            return 0;
        }
    }
}
