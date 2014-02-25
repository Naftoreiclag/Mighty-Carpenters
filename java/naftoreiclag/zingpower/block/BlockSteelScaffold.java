package naftoreiclag.zingpower.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import naftoreiclag.zingpower.util.MyStaticStrings;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockSteelScaffold extends BlockGlass
{
	public BlockSteelScaffold()
	{
		super(Material.iron, false);
		this.setBlockName(MyStaticStrings.UNLOCALIZED_SCAFFOLD);
		
		this.setHardness(5.0F);
		this.setResistance(10.0F);
		this.setStepSound(soundTypeMetal);
		
		this.lightOpacity = 5;
		
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister ir)
	{
	    this.blockIcon = ir.registerIcon(MyStaticStrings.TEXTURE_SCAFFOLD);
	}
	
	@Override
	public boolean isSideSolid(IBlockAccess world, int x, int y, int z, ForgeDirection side)
    {
		return true;
    }
}
