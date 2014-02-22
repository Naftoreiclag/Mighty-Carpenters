package naftoreiclag.zingpower;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import naftoreiclag.zingpower.util.MyStaticStrings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class BlockOreCopper extends Block
{
	public BlockOreCopper()
	{
		super(Material.rock);
		this.setBlockName(MyStaticStrings.COPPER_ORE_UNLOCALIZED);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.blockIcon = p_149651_1_.registerIcon(MyStaticStrings.MOD_ID + ":copper_ore");
    }
}