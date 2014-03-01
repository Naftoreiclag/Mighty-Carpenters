package naftoreiclag.mightycarpenters.things.engineerhandtools;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EHTItem extends Item
{
	protected EHTTier tier;
	protected EHTType type;
	
	protected float minability;
	protected float painfulness;
	
	protected Material[] minableMaterials;
	
	public EHTItem(String unlocalizedName, EHTTier tier, EHTType type)
	{
		super();
		
		this.tier = tier;
		this.type = type;
		
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(CreativeTabs.tabTools);
		
		this.setFull3D();
		
		this.setMaxStackSize(1);
		this.setMaxDamage(300);
		
		this.painfulness = 1.5f;
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack item, World world, Block block, int x, int y, int z, EntityLivingBase user)
    {
		// If it isn't already insta-mine
        if((double) block.getBlockHardness(world, x, y, z) != 0.0D)
        {
        	// Damage it
            item.damageItem(1, user);
        }

        return true;
    }
	
	@Override
	public boolean hitEntity(ItemStack item, EntityLivingBase enemy, EntityLivingBase user)
    {
        item.damageItem(1, user);
        
        DamageSource damageSource;
        
        if(user instanceof EntityPlayer)
        {
        	damageSource = DamageSource.causePlayerDamage((EntityPlayer) user);
        }
        else
        {
        	damageSource = DamageSource.causeMobDamage(user);
        }
        
        enemy.attackEntityFrom(damageSource, painfulness);
        
        return true;
    }

	// Something like isMinable() or something
	// This appears to return true whenever getItemEffectivenessAgainstBlock() returns a value higher than 1.0
	@Override
	public boolean func_150897_b(Block target)
	{
		if(minableMaterials == null)
		{
			return false;
		}
		
		for (Material m : minableMaterials)
		{
			if(target.getMaterial() == m)
			{
				return true;
			}
		}
		
		return false;
	}

	// Something like getItemEffectivenessAgainstBlock() or something
	@Override
	public float func_150893_a(ItemStack item, Block target)
	{
		if(minableMaterials == null)
		{
			return super.func_150893_a(item, target);
		}
		
		for (Material m : minableMaterials)
		{
			if(target.getMaterial() == m)
			{
				return minability;
			}
		}
		
		return super.func_150893_a(item, target);
	}
}
