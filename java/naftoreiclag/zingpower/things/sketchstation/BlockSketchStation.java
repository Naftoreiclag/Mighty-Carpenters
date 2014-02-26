package naftoreiclag.zingpower.things.sketchstation;

import naftoreiclag.zingpower.util.MyStaticStrings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSketchStation extends Block
{
	public BlockSketchStation()
	{
		super(Material.wood);
		this.setBlockName(MyStaticStrings.UNLOCALIZED_SKETCH_STATION);
		
		this.setHardness(3f);
		this.setResistance(15f);
		this.setStepSound(soundTypeStone);
		
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ir)
    {
        this.blockIcon = ir.registerIcon(MyStaticStrings.TEXTURE_SKETCH_STATION_SIDE);
    }
}