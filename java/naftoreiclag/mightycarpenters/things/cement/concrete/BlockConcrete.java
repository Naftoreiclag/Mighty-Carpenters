package naftoreiclag.mightycarpenters.things.cement.concrete;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import naftoreiclag.mightycarpenters.util.MyStaticStrings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class BlockConcrete extends Block
{
	public BlockConcrete()
	{
		super(Material.rock);
		
		this.setBlockName(MyStaticStrings.UNLOCALIZED_CONCRETE);
		
		this.setHardness(4.0f);
		this.setResistance(15.0f);
		this.setStepSound(soundTypeStone);
		
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister ir)
	{
	    this.blockIcon = ir.registerIcon(MyStaticStrings.TEXTURE_CONCRETE);
	}
	
	
}
