package naftoreiclag.mightycarpenters.things.engineerhandtools.nailgun;

import naftoreiclag.mightycarpenters.util.MyStaticStrings;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemNailgun extends Item
{
	public ItemNailgun() 
	{
		super();
		this.setUnlocalizedName(MyStaticStrings.UNLOCALIZED_NAILGUN);
		this.setFull3D();
		this.setCreativeTab(CreativeTabs.tabTools);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(MyStaticStrings.TEXTURE_NAILGUN);
	}
	
	/**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
	/*@Override
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
    {
		// Get out if client
		if(!world.isRemote) {return itemstack;}
		
		System.out.println("bang!");
		
		player.setItemInUse(itemstack, this.getMaxItemUseDuration(itemstack));
		
        return itemstack;
    }*/

	/**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
	{
		world.playSoundAtEntity(player, MyStaticStrings.SOUND_NAILGUN_FIRE, 1.0F, 1.0F);
		
		// Only in server
		if(!world.isRemote)
		{
			world.spawnEntityInWorld(new EntityFlyingNail(world, (EntityLivingBase) player));
		}
		
		return itemStack;
	}
}
