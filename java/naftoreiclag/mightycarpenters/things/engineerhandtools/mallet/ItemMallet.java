package naftoreiclag.mightycarpenters.things.engineerhandtools.mallet;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import naftoreiclag.mightycarpenters.things.engineerhandtools.EHTTier;
import naftoreiclag.mightycarpenters.things.engineerhandtools.EHTType;
import naftoreiclag.mightycarpenters.things.engineerhandtools.ItemEHT;
import naftoreiclag.mightycarpenters.util.MyStaticStrings;
import net.minecraft.client.renderer.texture.IIconRegister;

public class ItemMallet extends ItemEHT
{
	public ItemMallet()
	{
		super(MyStaticStrings.UNLOCALIZED_MALLET, EHTTier.WOOD, EHTType.MODIFY);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir)
	{
		this.itemIcon = ir.registerIcon(MyStaticStrings.TEXTURE_MALLET);
	}
}
