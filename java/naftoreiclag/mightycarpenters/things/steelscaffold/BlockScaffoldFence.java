package naftoreiclag.mightycarpenters.things.steelscaffold;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import naftoreiclag.mightycarpenters.util.MyStaticStrings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockScaffoldFence extends Block
{
	public static final float thick = 0.0625f;
	public static final float antithick = 1.0f - thick;
	
	
	public BlockScaffoldFence()
	{
		super(Material.iron);
		this.setBlockName(MyStaticStrings.UNLOCALIZED_SCAFFOLD_FENCE);
		
		this.setHardness(5.0F);
		this.setResistance(10.0F);
		this.setStepSound(soundTypeMetal);
		
		this.lightOpacity = 0;
		
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	/**
     * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
     */
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 0;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    @Override
    @SideOnly(Side.CLIENT)
    public boolean renderAsNormalBlock()
    {
        return false;
    }

	// Block bounds
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
	{
		int m = par1IBlockAccess.getBlockMetadata(par2, par3, par4);

		switch (m)
		{
			// Up
			case 0:
			{
				this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, thick, 1.0f);
				return;
			}
			
			// Down
			case 1:
			{
				this.setBlockBounds(0.0f, antithick, 0.0f, 1.0f, 1.0f, 1.0f);
				return;
			}
		
			// North
			case 2:
			{
				this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, thick);
				return;
			}
	
			// South
			case 3:
			{
				this.setBlockBounds(0.0f, 0.0f, antithick, 1.0f, 1.0f, 1.0f);
				return;
			}
	
			// West
			case 4:
			{
				this.setBlockBounds(0.0f, 0.0f, 0.0f, thick, 1.0f, 1.0f);
				return;
			}
			
			// East
			case 5:
			{
				this.setBlockBounds(antithick, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
				return;
			}
		}
	}
	
	/**
	 * Called when the block is placed. world, x, y, z, side, hitX, hitY, hitZ,
	 * metadata Returns metadata
	 */
	@Override
	public int onBlockPlaced(World world, int x, int y, int z, int side,
			float hx, float hy, float hz, int metadata)
	{
		return side;
	}

	// These allow for the bounding boxes to be block-specific; they re-call the
	// setBlockBoundsBasedOnState method whenever a collision is probable
	@SideOnly(Side.CLIENT)
	@Override
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World,
			int par2, int par3, int par4)
	{
		this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
		return super
				.getSelectedBoundingBoxFromPool(par1World, par2, par3, par4);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World,
			int par2, int par3, int par4)
	{
		this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
		return super.getCollisionBoundingBoxFromPool(par1World, par2, par3,
				par4);
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister ir)
	{
	    this.blockIcon = ir.registerIcon(MyStaticStrings.TEXTURE_SCAFFOLD_FENCE);
	}
	
	@Override
	public boolean isOpaqueCube()
    {
        return false;
    }
	
	@Override
	public boolean isSideSolid(IBlockAccess world, int x, int y, int z, ForgeDirection side)
    {
		return true;
    }
}
