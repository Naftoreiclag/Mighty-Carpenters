package naftoreiclag.mightycarpenters.things.blueprint;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import naftoreiclag.mightycarpenters.util.MyStaticStrings;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemBlueprint extends Item
{
	IIcon itemIconWritten;
	
	public ItemBlueprint() 
	{
		super();
		this.setUnlocalizedName(MyStaticStrings.UNLOCALIZED_BLUEPRINT);
		
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}

	public void onCreated(ItemStack itemStack, World world, EntityPlayer player)
	{
		// Exit on client
		if(world.isRemote) {return;}
		
		itemStack.stackTagCompound = new NBTTagCompound();
		
		NBTTagCompound display = new NBTTagCompound();
		char col = 21;
		display.setString("Name", col + "r\"Maxed Out Crane Plans\"");
		
		itemStack.stackTagCompound.setTag("display", display);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir)
	{
		this.itemIcon = ir.registerIcon(MyStaticStrings.TEXTURE_BLUEPRINT_BLANK);
		this.itemIconWritten = ir.registerIcon(MyStaticStrings.TEXTURE_BLUEPRINT_WRITTEN);
	}
}
