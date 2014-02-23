package naftoreiclag.zingpower.block.superhotfurnace;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockShf extends Block
{
	protected BlockShf()
	{
		super(Material.rock);
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
