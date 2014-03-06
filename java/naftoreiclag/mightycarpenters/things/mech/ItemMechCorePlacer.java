package naftoreiclag.mightycarpenters.things.mech;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import naftoreiclag.mightycarpenters.MightyCarpentersMod;
import naftoreiclag.mightycarpenters.util.MyStaticStrings;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class ItemMechCorePlacer extends Item
{
	Random soundPitch;
	
	public ItemMechCorePlacer()
	{
		super();
		this.setUnlocalizedName(MyStaticStrings.UNLOCALIZED_MECH_CORE_PLACER);
		
		this.setCreativeTab(CreativeTabs.tabTransport);
		
		soundPitch = new Random();
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(MyStaticStrings.TEXTURE_DEBUG_0);
	}
	
	public boolean onItemUse(ItemStack item, EntityPlayer user, World world, int x, int y, int z, int side, float par8, float par9, float par10)
    {
		// Otherwise, shoving the item toward your knee makes me uncomfortable
		user.swingItem();
		
		// Gotta have that sound tho
		world.playSoundAtEntity(user, MyStaticStrings.SOUND_METAL_HIT_1, 1.0f, 0.6f + (soundPitch.nextFloat() * 0.2f));
		
		// No clients allowed
		if(world.isRemote)
		{
			// Get outta here
			return false;
		}
		
		EntityMechCore d = new EntityMechCore(world);
		d.setPosition(x, y + 1, z);
		world.spawnEntityInWorld(d);
		
        return true;
    }
}