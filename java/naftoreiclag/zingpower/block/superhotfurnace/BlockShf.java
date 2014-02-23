package naftoreiclag.zingpower.block.superhotfurnace;

import naftoreiclag.zingpower.util.MyStaticStrings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockShf extends Block
{
	protected BlockShf()
	{
		super(Material.rock);
		this.setBlockName(MyStaticStrings.UNLOCALIZED_SHF);
		this.setHardness(3.5f);
		this.setResistance(17.5f);
		this.setCreativeTab(CreativeTabs.tabDecorations);
	}
	
	// Tile entity
	@Override
	public boolean hasTileEntity(int metadata)
	{
		return true;
	}
	@Override
	public TileEntity createTileEntity(World world, int metadata)
	{
		return new ShfTentity();
	}
}
