package naftoreiclag.mightycarpenters.things.sketchstation;

import naftoreiclag.mightycarpenters.util.MyStaticStrings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSketchStation extends Block
{
    @SideOnly(Side.CLIENT)
    protected IIcon texDef;
    protected IIcon texSide;
    protected IIcon[] texTopEL = new IIcon[4];
    protected IIcon[] texTopER = new IIcon[4];
    protected IIcon texTopFL;
    protected IIcon texTopFR;
    
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
        this.blockIcon = ir.registerIcon(MyStaticStrings.TEXTURE_SKETCH_STATION_DEFAULT);
        
        this.texDef = ir.registerIcon(MyStaticStrings.TEXTURE_SKETCH_STATION_DEFAULT);
        this.texSide = ir.registerIcon(MyStaticStrings.TEXTURE_SKETCH_STATION_SIDE);
        
        this.texTopEL[0] = ir.registerIcon(MyStaticStrings.TEXTURE_SKETCH_STATION_TOP_EMPTY_LEFT_0);
        this.texTopEL[1] = ir.registerIcon(MyStaticStrings.TEXTURE_SKETCH_STATION_TOP_EMPTY_LEFT_1);
        //this.texTopEL[2] = ir.registerIcon(MyStaticStrings.TEXTURE_SKETCH_STATION_TOP_EMPTY_LEFT_2);
        //this.texTopEL[3] = ir.registerIcon(MyStaticStrings.TEXTURE_SKETCH_STATION_TOP_EMPTY_LEFT_3);
        this.texTopEL[2] = ir.registerIcon(MyStaticStrings.TEXTURE_SKETCH_STATION_TOP_EMPTY_RIGHT_2);
        this.texTopEL[3] = ir.registerIcon(MyStaticStrings.TEXTURE_SKETCH_STATION_TOP_EMPTY_RIGHT_3);
        
        /*
        this.texTopER[0] = ir.registerIcon(MyStaticStrings.TEXTURE_SKETCH_STATION_TOP_EMPTY_RIGHT_0);
        this.texTopER[1] = ir.registerIcon(MyStaticStrings.TEXTURE_SKETCH_STATION_TOP_EMPTY_RIGHT_1);
        this.texTopER[2] = ir.registerIcon(MyStaticStrings.TEXTURE_SKETCH_STATION_TOP_EMPTY_RIGHT_2);
        this.texTopER[3] = ir.registerIcon(MyStaticStrings.TEXTURE_SKETCH_STATION_TOP_EMPTY_RIGHT_3);
        */
        
        this.texTopFL = ir.registerIcon(MyStaticStrings.TEXTURE_SKETCH_STATION_TOP_FILLED_LEFT);
        this.texTopFR = ir.registerIcon(MyStaticStrings.TEXTURE_SKETCH_STATION_TOP_FILLED_RIGHT);
    }
	
	/**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        if(side == 0)
        {
            return texDef;
        }
        
        if(side == 1)
        {
        	if(meta < 0 || meta > 3)
        	{
        		return texDef;
        	}
        	return texTopEL[meta];
        }
        
        switch(sideToCardinal(side))
        {
	        case 0:
	        {
	        	if(meta == 1)
	        	{
	        		return texTopFR;
	        	}
	        	if(meta == 3)
	        	{
	        		return texTopFL;
	        	}
	        	
	        	break;
	        }
	        case 1:
	        {
	        	if(meta == 0)
	        	{
	        		return texTopFL;
	        	}
	        	if(meta == 2)
	        	{
	        		return texTopFR;
	        	}
	        	
	        	break;
	        }
	        case 2:
	        {
	        	if(meta == 1)
	        	{
	        		return texTopFR;
	        	}
	        	if(meta == 3)
	        	{
	        		return texTopFL;
	        	}
	        	
	        	break;
	        }
	        case 3:
	        {
	        	if(meta == 0)
	        	{
	        		return texTopFL;
	        	}
	        	if(meta == 2)
	        	{
	        		return texTopFR;
	        	}
	        	
	        	break;
	        }
        }
        
        return texSide;
    }
    
	public static int flipCardinal(int c)
	{
		// 1 -> 3
		// 3 -> 1
		// 0 -> 2
		// 2 -> 0
		// def: 0
		return c == 1 ? 3 : (c == 3 ? 1 : (c == 0 ? 2 : 0));
	}
	public static int sideToCardinal(int s)
	{
		// 2 -> 2
		// 4 -> 1
		// 5 -> 3
		// 3 -> 0
		
		return s == 2 ? 2 : (s == 4 ? 1 : (s == 5 ? 3 : 0));
	}
    
	/**
	 * Called when a block is placed using its ItemBlock. Args: World, X, Y, Z,
	 * side, hitX, hitY, hitZ, block metadata
	 */
	// 0 south increase z
	// 1 west decrease x
	// 2 north decrease z
	// 3 east increase x
    
    /*
     * Meta values:
     * 
     * ("facing" direction points toward twin block)
     * 
     * 0: facing south
     * 1: facing west
     * 2: facing north
     * 3: facing east
     * 
     * 4: no orientation
     * 
     *    2
     *   1x3
     *    0
     * 
     * The "dummy" block will have the larger value (2 or 3)
     * 
     * I'll have something in the Tentity if it needs to be flipped or something
     * 
     */
	public int onBlockPlaced(World world, int x, int y, int z, int side,
			float hitX, float hitY, float hitZ, int meta)
	{
    	Block block0 = world.getBlock     (x    , y, z + 1);
    	int meta0 = world.getBlockMetadata(x    , y, z + 1);
    	Block block1 = world.getBlock     (x - 1, y, z    );
    	int meta1 = world.getBlockMetadata(x - 1, y, z    );
    	Block block2 = world.getBlock     (x    , y, z - 1);
    	int meta2 = world.getBlockMetadata(x    , y, z - 1);
    	Block block3 = world.getBlock     (x + 1, y, z    );
    	int meta3 = world.getBlockMetadata(x + 1, y, z    );
    	
    	Block partner = this;
    	
    	if(block0 == partner && meta0 == 4)
    	{
    		world.setBlockMetadataWithNotify(x, y, z + 1, 2, 2);
    		
    		return 0;
    	}
    	else if(block1 == partner && meta1 == 4)
    	{
    		world.setBlockMetadataWithNotify(x - 1, y, z, 3, 2);
    		
    		return 1;
    	}
    	else if(block2 == partner && meta2 == 4)
    	{
    		world.setBlockMetadataWithNotify(x, y, z - 1, 0, 2);
    		
    		return 2;
    	}
    	else if(block3 == partner && meta3 == 4)
    	{
    		world.setBlockMetadataWithNotify(x + 1, y, z, 1, 2);
    		
    		return 3;
    	}
    	
        return 4;
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
        return new SketchStationTentity();
    }
}