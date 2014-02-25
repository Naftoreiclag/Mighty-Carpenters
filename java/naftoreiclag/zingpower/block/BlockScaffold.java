package naftoreiclag.zingpower.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import naftoreiclag.zingpower.util.MyStaticStrings;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class BlockScaffold extends BlockGlass
{
	public BlockScaffold()
	{
		super(Material.iron, false);
		this.setBlockName(MyStaticStrings.UNLOCALIZED_SCAFFOLD);
		
		this.setHardness(5.0F);
		this.setResistance(10.0F);
		this.setStepSound(soundTypeMetal);
		
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister ir)
	{
	    this.blockIcon = ir.registerIcon(MyStaticStrings.TEXTURE_SCAFFOLD);
	}
}
