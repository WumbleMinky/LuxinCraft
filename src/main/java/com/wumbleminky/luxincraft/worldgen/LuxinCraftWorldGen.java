package com.wumbleminky.luxincraft.worldgen;

import com.wumbleminky.luxincraft.block.BlockLuxinCraft;
import com.wumbleminky.luxincraft.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class LuxinCraftWorldGen implements IWorldGenerator {

    private class BlockGenInfo {
        BlockLuxinCraft block;
        public int chanceToSpawn;
        public int minY;
        public int maxY;
        public int maxVeinSize;

        public BlockGenInfo(BlockLuxinCraft block, int chanceToSpawn, int minY, int maxY, int maxVeinSize){
            this.block = block;
            this.chanceToSpawn = chanceToSpawn;
            this.minY = minY;
            this.maxY = maxY;
            this.maxVeinSize = maxVeinSize;
        }

        public void generate(World world, Random random, int chunkX, int chunkZ){
            for (int i = 0; i < this.chanceToSpawn; i++){
                BlockPos pos = new BlockPos(
                        chunkX + random.nextInt(16),
                        this.minY + random.nextInt(this.maxY - this.minY),
                        chunkZ + random.nextInt(16)
                );
                WorldGenMinable wgm = new WorldGenMinable(this.block.getDefaultState(), this.maxVeinSize);
                wgm.generate(world, random, pos);
            }

        }
    }

    private final BlockGenInfo rubyGenInfo = new BlockGenInfo(ModBlocks.oreRuby, 25, 10, 40, 4);
    private final BlockGenInfo sapphireGenInfo = new BlockGenInfo(ModBlocks.oreSapphire, 25, 10, 40, 4);
    private final BlockGenInfo garnetGenInfo = new BlockGenInfo(ModBlocks.oreGarnet, 25, 10, 40, 4);
    private final BlockGenInfo citrineGenInfo = new BlockGenInfo(ModBlocks.oreCitrine, 25, 10, 40, 4);

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        if (world.provider.getDimensionId() == 0){
            rubyGenInfo.generate(world, random, chunkX*16, chunkZ*16);
            sapphireGenInfo.generate(world, random, chunkX*16, chunkZ*16);
            garnetGenInfo.generate(world, random, chunkX*16, chunkZ*16);
            citrineGenInfo.generate(world, random, chunkX*16, chunkZ*16);
        }
    }
}
