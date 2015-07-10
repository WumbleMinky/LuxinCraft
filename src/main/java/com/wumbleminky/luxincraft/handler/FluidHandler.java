package com.wumbleminky.luxincraft.handler;

import com.wumbleminky.luxincraft.init.ModFluids;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class FluidHandler
{

	@SubscribeEvent
	public void onBucketFill(FillBucketEvent event) {

		ItemStack result = fillCustomBucket(event.world, event.target);

		if (result == null)
			return;

		event.result = result;
		event.setResult(Result.ALLOW);
	}
	

	private ItemStack fillCustomBucket(World world, MovingObjectPosition pos) 	{

		Block block = world.getBlockState(pos.getBlockPos()).getBlock();

		if (ModFluids.bucket.FillFluidIds.containsKey(block) && ((Integer) world.getBlockState(pos.getBlockPos()).getValue(BlockFluidBase.LEVEL)) == 0){
			world.setBlockToAir(pos.getBlockPos());
			return new ItemStack(ModFluids.bucket, 1, ModFluids.bucket.FillFluidIds.get(block));
		} else
			return null;

	}
}
