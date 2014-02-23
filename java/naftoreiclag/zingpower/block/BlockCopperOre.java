package naftoreiclag.zingpower.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import naftoreiclag.zingpower.util.MyStaticStrings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class BlockCopperOre extends Block
{
	public BlockCopperOre()
	{
		super(Material.rock);
		this.setBlockName(MyStaticStrings.UNLOCALIZED_COPPER_ORE);
		this.setHardness(3f);
		this.setResistance(15f);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.blockIcon = p_149651_1_.registerIcon(MyStaticStrings.MOD_ID + ":copper_ore");
    }
}