package naftoreiclag.mightycarpenters.things.engineerhandtools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemEHT extends Item
{
	public ItemEHT(String unlocalizedName, EHTTier tier, EHTType type)
	{
		super();
		
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(CreativeTabs.tabTools);
	}
}
