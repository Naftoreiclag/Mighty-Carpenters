package naftoreiclag.mightycarpenters.things.superhotfurnace;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import naftoreiclag.mightycarpenters.MightyCarpentersMod;
import naftoreiclag.mightycarpenters.util.MyStaticStrings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockShf extends Block
{
    @SideOnly(Side.CLIENT)
    IIcon texTop;
    @SideOnly(Side.CLIENT)
    IIcon texSide;
    @SideOnly(Side.CLIENT)
    IIcon texBottom;
    @SideOnly(Side.CLIENT)
    IIcon texOn;
    @SideOnly(Side.CLIENT)
    IIcon texOff;

    @SideOnly(Side.CLIENT)
    IIcon[] texDebug = new IIcon[6];
	
	public BlockShf()
	{
		super(Material.rock);
		this.setBlockName(MyStaticStrings.UNLOCALIZED_SHF);
		this.setHardness(3.5f);
		this.setResistance(17.5f);
		this.setCreativeTab(CreativeTabs.tabDecorations);
	}
	
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister r)
    {
        this.blockIcon = r.registerIcon(MyStaticStrings.TEXTURE_SHF_TOP);
        
        texTop = r.registerIcon(MyStaticStrings.TEXTURE_SHF_TOP);
        texSide = r.registerIcon(MyStaticStrings.TEXTURE_SHF_SIDE);
        texBottom = r.registerIcon(MyStaticStrings.TEXTURE_SHF_BOTTOM);
        texOn = r.registerIcon(MyStaticStrings.TEXTURE_SHF_FRONT_ON);
        texOff = r.registerIcon(MyStaticStrings.TEXTURE_SHF_FRONT_OFF);
        
        texDebug[0] = r.registerIcon(MyStaticStrings.TEXTURE_DEBUG_0);
        texDebug[1] = r.registerIcon(MyStaticStrings.TEXTURE_DEBUG_1);
        texDebug[2] = r.registerIcon(MyStaticStrings.TEXTURE_DEBUG_2);
        texDebug[3] = r.registerIcon(MyStaticStrings.TEXTURE_DEBUG_3);
        texDebug[4] = r.registerIcon(MyStaticStrings.TEXTURE_DEBUG_4);
        texDebug[5] = r.registerIcon(MyStaticStrings.TEXTURE_DEBUG_5);
    }
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack p_149689_6_)
	{
		// Exit if on client-side
		if(world.isRemote) { return; }
		
		world.setBlockMetadataWithNotify(x, y, z, flipCardinal(lookToCardinal(player)), 2);
		System.out.println("metadata for block: " + world.getBlockMetadata(x, y, z));
	}

	// Returns standard direction (AKA the 0 to 3 values for north to east)
	public static int lookToCardinal(EntityLivingBase player)
	{
		return MathHelper.floor_double((double) (player.rotationYaw / 90.0f) + 0.5d) % 4;
	}
	
	//
	public static int flipCardinal(int c)
	{
		// 1 -> 3
		// 3 -> 1
		// 0 -> 2
		// 2 -> 0
		// def: 0
		return c == 1 ? 3 : (c == 3 ? 1 : (c == 0 ? 2 : 0));
	}

	/**
     * Gets the block's texture. Args: side, meta
     */
	
	// 0 = bottom
	// 1 = top
	
	public static int sideToCardinal(int s)
	{
		// 2 -> 2
		// 4 -> 1
		// 5 -> 3
		// 3 -> 0
		
		return s == 2 ? 2 : (s == 4 ? 1 : (s == 5 ? 3 : 0));
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		// Exit if on server-side
		if(!world.isRemote) { return true;}
		
		FMLNetworkHandler.openGui(player, MightyCarpentersMod.instance, MyStaticStrings.GUIID_SHF, world, x, y, z);
		
		return true;
	}
	
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
    	//return texDebug[side];
    	
        if(side == 0)
        {
        	return texBottom;
        }
        else if(side == 1)
        {
        	return texTop;
        }
        else if(sideToCardinal(side) == meta)
        {
        	return texOff;
        }
        else
        {
        	return texSide;
        }
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
