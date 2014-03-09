package naftoreiclag.mightycarpenters.things.clothing;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import naftoreiclag.mightycarpenters.MightyCarpentersMod;
import naftoreiclag.mightycarpenters.util.MyStaticStrings;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class ItemGoggles extends ItemArmor
{
	public ItemGoggles()
	{
		super(MightyCarpentersMod.armor_useless_iron, 1, 0);
		this.setUnlocalizedName(MyStaticStrings.UNLOCALIZED_GOGGLES);
		
		this.setCreativeTab(CreativeTabs.tabDecorations);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(MyStaticStrings.TEXTURE_GOGGLES);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		return MyStaticStrings.MODEL_TEXTURE_GOGGLES;
	}

}
