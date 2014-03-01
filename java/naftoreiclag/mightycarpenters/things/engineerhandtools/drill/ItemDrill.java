package naftoreiclag.mightycarpenters.things.engineerhandtools.drill;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import naftoreiclag.mightycarpenters.things.engineerhandtools.EHTTier;
import naftoreiclag.mightycarpenters.things.engineerhandtools.EHTType;
import naftoreiclag.mightycarpenters.things.engineerhandtools.ItemEHT;
import naftoreiclag.mightycarpenters.util.MyStaticStrings;
import net.minecraft.client.renderer.texture.IIconRegister;

public class ItemDrill extends ItemEHT
{
	public ItemDrill()
	{
		super(MyStaticStrings.UNLOCALIZED_CHAINSAW, EHTTier.MULTI, EHTType.DESTROY);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir)
	{
		this.itemIcon = ir.registerIcon(MyStaticStrings.TEXTURE_CHAINSAW);
	}
}
