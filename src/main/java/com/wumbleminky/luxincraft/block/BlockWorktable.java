package com.wumbleminky.luxincraft.block;

import com.wumbleminky.luxincraft.init.ModItems;
import com.wumbleminky.luxincraft.item.ItemLense;
import com.wumbleminky.luxincraft.reference.Colors;
import com.wumbleminky.luxincraft.reference.Names;
import com.wumbleminky.luxincraft.reference.WorktableRecipes;
import com.wumbleminky.luxincraft.tileentity.TileEntityWorktable;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockWorktable extends BlockLuxinCraft implements ITileEntityProvider {

    public BlockWorktable(){
        super(Material.wood);
        this.setHardness(2.0F);
        this.setStepSound(Block.soundTypeWood);
        setUnlocalizedName(Names.Blocks.WORKTABLE);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
        EnumFacing enumfacing = EnumFacing.getHorizontal(MathHelper.floor_double((double) (placer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3).getOpposite();

        TileEntity te = world.getTileEntity(pos);
        if (te instanceof TileEntityWorktable){
            TileEntityWorktable teWorktable = (TileEntityWorktable)te;
            teWorktable.setFacing(enumfacing);
        }

        super.onBlockPlacedBy(world,pos,state,placer,stack);
    }


    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (world.isRemote) {
            return true;
        } else {
            ItemStack equipped = player.getCurrentEquippedItem();
            TileEntity te  = world.getTileEntity(pos);
            if (te instanceof TileEntityWorktable){
                TileEntityWorktable tileEntityWorktable = (TileEntityWorktable)te;

                //Remove the current item or perform work on the item
                if (tileEntityWorktable.hasInventory()){
                    ItemStack inventory = tileEntityWorktable.getInventory();

                    //perform work on the item on the worktable
                    if (equipped != null && WorktableRecipes.hasRecipe(equipped.getItem(), inventory.getItem())) {
                        Item equipped_item = equipped.getItem();
                        //set the amount of work if has not been set
                        if (!tileEntityWorktable.hasWork() && WorktableRecipes.getWork(equipped_item, inventory.getItem()) > 0){
                            tileEntityWorktable.setWorkRemaining(WorktableRecipes.getWork(equipped_item, inventory.getItem()));
                        }
                        equipped.damageItem(1, player);

                        //perform work on the wortable item, if it finishes, update the inventory
                        if (tileEntityWorktable.doWork()){
                            tileEntityWorktable.setInventory(WorktableRecipes.getOutput(equipped_item, inventory.getItem()));
                        }
                    //try to add the item to the player's inventory)
                    }else if (player.inventory.addItemStackToInventory(inventory)){
                        player.inventoryContainer.detectAndSendChanges();
                        if (player instanceof EntityPlayerMP){
                            ((EntityPlayerMP) player).worldObj.playSoundAtEntity(player,"random.pop", 0.2F, 2.0F);
                        }
                        tileEntityWorktable.clearInventory();
                    }else{
                        //Spawn item at player's feet in case inventory is full
                        EntityItem itemEntity = new EntityItem(world, player.posX + 0.5D, player.posY + 0.5D, player.posZ + 0.5D, inventory);
                        world.spawnEntityInWorld(itemEntity);
                        tileEntityWorktable.clearInventory();
                    }
                //add an item
                }else{
                    if (equipped != null){
                        tileEntityWorktable.setInventory(equipped.splitStack(1));
                    }
                }
                return true;
            }
        }
        return true;
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state){

    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityWorktable();
    }
}
