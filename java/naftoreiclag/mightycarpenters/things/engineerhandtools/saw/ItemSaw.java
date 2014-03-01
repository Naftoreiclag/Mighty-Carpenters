package naftoreiclag.mightycarpenters.things.engineerhandtools.saw;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import naftoreiclag.mightycarpenters.things.engineerhandtools.EHTTier;
import naftoreiclag.mightycarpenters.things.engineerhandtools.EHTType;
import naftoreiclag.mightycarpenters.things.engineerhandtools.ItemEHT;
import naftoreiclag.mightycarpenters.util.MyStaticStrings;
import net.minecraft.client.renderer.texture.IIconRegister;

public class ItemSaw extends ItemEHT
{
	public ItemSaw()
	{
		super(MyStaticStrings.UNLOCALIZED_SAW, EHTTier.WOOD, EHTType.DESTROY);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir)
	{
		this.itemIcon = ir.registerIcon(MyStaticStrings.TEXTURE_SAW);
	}
}
	