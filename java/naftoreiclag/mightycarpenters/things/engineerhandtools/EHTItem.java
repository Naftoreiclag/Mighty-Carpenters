package naftoreiclag.mightycarpenters.things.engineerhandtools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class EHTItem extends Item
{
	protected EHTTier tier;
	protected EHTType type;
	
	public EHTItem(String unlocalizedName, EHTTier tier, EHTType type)
	{
		super();
		
		this.tier = tier;
		this.type = type;
		
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(CreativeTabs.tabTools);
	}
}
