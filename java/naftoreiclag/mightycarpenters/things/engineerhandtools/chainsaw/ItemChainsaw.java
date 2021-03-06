package naftoreiclag.mightycarpenters.things.engineerhandtools.chainsaw;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import naftoreiclag.mightycarpenters.things.engineerhandtools.EHTTier;
import naftoreiclag.mightycarpenters.things.engineerhandtools.EHTType;
import naftoreiclag.mightycarpenters.things.engineerhandtools.EHTItem;
import naftoreiclag.mightycarpenters.util.MyStaticStrings;
import net.minecraft.client.renderer.texture.IIconRegister;

public class ItemChainsaw extends EHTItem
{
	public ItemChainsaw()
	{
		super(MyStaticStrings.UNLOCALIZED_DRILL, EHTTier.MULTI, EHTType.DESTROY);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir)
	{
		this.itemIcon = ir.registerIcon(MyStaticStrings.TEXTURE_DRILL);
	}
}
