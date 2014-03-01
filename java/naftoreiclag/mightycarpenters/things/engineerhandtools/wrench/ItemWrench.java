package naftoreiclag.mightycarpenters.things.engineerhandtools.wrench;


import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import naftoreiclag.mightycarpenters.MightyCarpentersMod;
import naftoreiclag.mightycarpenters.things.engineerhandtools.EHTTier;
import naftoreiclag.mightycarpenters.things.engineerhandtools.EHTType;
import naftoreiclag.mightycarpenters.things.engineerhandtools.EHTItem;
import naftoreiclag.mightycarpenters.things.steelscaffold.BlockScaffoldFence;
import naftoreiclag.mightycarpenters.util.MyStaticStrings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemWrench extends EHTItem
{
	public ItemWrench()
	{
		super(MyStaticStrings.UNLOCALIZED_WRENCH, EHTTier.METAL, EHTType.CREATE);
		
		// Painful as a gold sword
		this.painfulness = 5.0f;
		
		// Mines like a gold pickaxe but cannot mine stone
		this.minability = ToolMaterial.GOLD.getEfficiencyOnProperMaterial();
		this.minableMaterials = new Material[]{ Material.anvil, Material.circuits, Material.glass, Material.piston, Material.iron, Material.ice };
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir)
	{
		this.itemIcon = ir.registerIcon(MyStaticStrings.TEXTURE_WRENCH);
	}
	
	@Override
	public boolean onItemUse(ItemStack item, EntityPlayer user, World world, int x, int y, int z, int side, float par8, float par9, float par10)
    {
		// No clients allowed
		if(world.isRemote) { return false; }
		
		if(world.getBlock(x, y, z) == MightyCarpentersMod.block_steel_scaffold)
		{
			if(side == 0 || side == 1)
			{
				// check z
				// check x
				return 
						foo(world, x, y, z, side, 2) | 
						foo(world, x, y, z, side, 3) | 
						foo(world, x, y, z, side, 4) | 
						foo(world, x, y, z, side, 5);
				
			}
			else if(side == 2 || side == 3)
			{
				// check y
				// check x
				return 
						foo(world, x, y, z, side, 0) | 
						foo(world, x, y, z, side, 1) | 
						foo(world, x, y, z, side, 4) | 
						foo(world, x, y, z, side, 5);
			}
			else if(side == 4 || side == 5)
			{
				// check y
				// check z
				return 
						foo(world, x, y, z, side, 0) | 
						foo(world, x, y, z, side, 1) | 
						foo(world, x, y, z, side, 2) | 
						foo(world, x, y, z, side, 3);
			}
			
			return false;
		}
		
        return false;
    }
	
	private boolean foo(World world, int x, int y, int z, int side, int dir)
	{
		int cornerBlockOffset = 0;
		
		for(int a = 1; a < 7; ++ a)
		{
			Block b;
			
			switch(dir)
			{
				case 0:
				{
					b = world.getBlock(x, y + a, z);
					break;
				}
				case 1:
				{
					b = world.getBlock(x, y - a, z);
					break;
				}
				case 2:
				{
					b = world.getBlock(x, y, z + a);
					break;
				}
				case 3:
				{
					b = world.getBlock(x, y, z - a);
					break;
				}
				case 4:
				{
					b = world.getBlock(x + a, y, z);
					break;
				}
				case 5:
				{
					b = world.getBlock(x - a, y, z);
					break;
				}
				default:
				{
					return false;
				}
			}
			
			if(b.getMaterial() == Material.air || b == MightyCarpentersMod.block_scaffold_fence)
			{
				continue;
			}
			else if(b == MightyCarpentersMod.block_steel_scaffold)
			{
				cornerBlockOffset = a;
				break;
			}
			else
			{
				break;
			}
		}
		
		if(cornerBlockOffset != 0)
		{
			for(int a = 1; a < cornerBlockOffset; ++ a)
			{
				switch(dir)
				{
					case 0:
					{
						world.setBlock(x, y + a, z, MightyCarpentersMod.block_scaffold_fence, side, 2);
						break;
					}
					case 1:
					{
						world.setBlock(x, y - a, z, MightyCarpentersMod.block_scaffold_fence, side, 2);
						break;
					}
					case 2:
					{
						world.setBlock(x, y, z + a, MightyCarpentersMod.block_scaffold_fence, side, 2);
						break;
					}
					case 3:
					{
						world.setBlock(x, y, z - a, MightyCarpentersMod.block_scaffold_fence, side, 2);
						break;
					}
					case 4:
					{
						world.setBlock(x + a, y, z, MightyCarpentersMod.block_scaffold_fence, side, 2);
						break;
					}
					case 5:
					{
						world.setBlock(x - a, y, z, MightyCarpentersMod.block_scaffold_fence, side, 2);
						break;
					}
				}
			}
			
			return true;
		}
		
		return false;
	}
}
