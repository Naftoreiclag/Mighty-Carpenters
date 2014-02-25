package naftoreiclag.zingpower.things.monkeywrench;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import naftoreiclag.zingpower.util.MyStaticStrings;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemMonkeyWrench extends Item
{
	public ItemMonkeyWrench() 
	{
		super();
		this.setUnlocalizedName(MyStaticStrings.UNLOCALIZED_MONKEY_WRENCH);
		this.setFull3D();
		
		this.setCreativeTab(CreativeTabs.tabTools);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(MyStaticStrings.TEXTURE_MONKEY_WRENCH);
	}
}
