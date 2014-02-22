package naftoreiclag.zingpower.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import naftoreiclag.zingpower.util.MyStaticStrings;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemCopperIngot extends Item
{
	public ItemCopperIngot() 
	{
		super();
		this.setUnlocalizedName(MyStaticStrings.UNLOCALIZED_COPPER_INGOT);
		
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(MyStaticStrings.TEXTURE_COPPER_INGOT);
	}
}
