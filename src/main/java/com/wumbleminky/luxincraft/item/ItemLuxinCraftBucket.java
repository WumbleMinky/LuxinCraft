package com.wumbleminky.luxincraft.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.wumbleminky.luxincraft.creativetab.CreativeTabLC;
import com.wumbleminky.luxincraft.reference.Names;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemLuxinCraftBucket extends ItemBucket
{
	public List<Block> fillFluids = new ArrayList<Block>();
	public HashMap<Block, Integer> FillFluidIds = new HashMap<Block, Integer>();
	
	public ItemLuxinCraftBucket() {
		super(Blocks.air);
		setUnlocalizedName(Names.Items.BUCKET);
		setCreativeTab(CreativeTabLC.LuxinCraftTab);
	}

	/**
	 * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
	 */
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player){
		MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(world, player, false);

		if (movingobjectposition == null){
			return itemStack;
		}
		else{
			FillBucketEvent event = new FillBucketEvent(player, itemStack, world, movingobjectposition);
			if (MinecraftForge.EVENT_BUS.post(event)){
				return itemStack;
			}

			if (event.getResult() == Result.ALLOW)	{
				if (player.capabilities.isCreativeMode){
					return itemStack;
				}

				if (--itemStack.stackSize <= 0)	{
					return event.result;
				}

				if (!player.inventory.addItemStackToInventory(event.result))	{
					player.dropItem(event.result, false, false);
				}

				return itemStack;
			}

			if (movingobjectposition.typeOfHit == MovingObjectType.BLOCK){
				BlockPos pos = movingobjectposition.getBlockPos();

				if (!world.canMineBlockBody(player, pos))	{
					return itemStack;
				}

				if (itemStack.getItemDamage() < 0)	{
					return new ItemStack(Items.bucket);
				}
				
				pos = pos.offset(movingobjectposition.sideHit);
				
				if (!player.canPlayerEdit(pos, movingobjectposition.sideHit, itemStack)){
					return itemStack;
				}

				if (this.tryPlaceContainedLiquid(world, pos, fillFluids.get(itemStack.getItemDamage())) && !player.capabilities.isCreativeMode){
					return new ItemStack(Items.bucket);
				}
			}

			return itemStack;
		}
	}

	/**
	 * Attempts to place the liquid contained inside the bucket.
	 */
	public boolean tryPlaceContainedLiquid(World par1World, BlockPos pos, Block block){
		Material material = par1World.getBlockState(pos).getBlock().getMaterial();
		boolean flag = !material.isSolid();

		if (!par1World.isAirBlock(pos) && !flag){
			return false;
		}
		else{
			if (!par1World.isRemote && flag && !material.isLiquid()){
				par1World.destroyBlock(pos, true);
			}
			
			par1World.setBlockState(pos, block.getDefaultState(), 3);
			
			return true;
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List subItems){
		for(int id = 0; id < fillFluids.size(); id++)
			subItems.add(new ItemStack(this, 1, id));
	}
	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		return getUnlocalizedName() + "." + Names.getUnwrappedName(fillFluids.get(itemStack.getItemDamage()).getUnlocalizedName());
	}
	
	public void addFluidBlock(Block block){
		fillFluids.add(block);
		FillFluidIds.put(block, fillFluids.size() - 1);

	}


}
