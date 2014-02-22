package naftoreiclag.zingpower;

import naftoreiclag.zingpower.util.MyStaticStrings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockOreCopper extends Block
{
	public BlockOreCopper()
	{
		super(Material.rock);
		this.setBlockName(MyStaticStrings.COPPER_ORE_UNLOCALIZED);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
}