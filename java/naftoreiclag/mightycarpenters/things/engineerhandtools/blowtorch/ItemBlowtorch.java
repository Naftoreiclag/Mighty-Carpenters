package naftoreiclag.mightycarpenters.things.engineerhandtools.blowtorch;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import naftoreiclag.mightycarpenters.things.engineerhandtools.EHTTier;
import naftoreiclag.mightycarpenters.things.engineerhandtools.EHTType;
import naftoreiclag.mightycarpenters.things.engineerhandtools.EHTItem;
import naftoreiclag.mightycarpenters.util.MyStaticStrings;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class ItemBlowtorch extends EHTItem
{
	public ItemBlowtorch()
	{
		super(MyStaticStrings.UNLOCALIZED_BLOWTORCH, EHTTier.METAL, EHTType.DESTROY);
		
		this.minability = 1.0f;
		this.painfulness = 1.0f;
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack item, World world, Block block, int x, int y, int z, EntityLivingBase user)
    {
		return true;
    }
	
	@Override
	public boolean hitEntity(ItemStack item, EntityLivingBase enemy, EntityLivingBase user)
    {
        item.damageItem(5, user);
        
        DamageSource damageSource;
        
        if(user instanceof EntityPlayer)
        {
        	damageSource = DamageSource.causePlayerDamage((EntityPlayer) user);
        }
        else
        {
        	damageSource = DamageSource.causeMobDamage(user);
        }
        
        damageSource.setFireDamage();
        
        enemy.attackEntityFrom(damageSource, painfulness);
        
        return true;
    }
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir)
	{
		this.itemIcon = ir.registerIcon(MyStaticStrings.TEXTURE_BLOWTORCH);
	}
	
	/**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
	// Copied from flint and steel
	@Override
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        if (par7 == 0)
        {
            --par5;
        }

        if (par7 == 1)
        {
            ++par5;
        }

        if (par7 == 2)
        {
            --par6;
        }

        if (par7 == 3)
        {
            ++par6;
        }

        if (par7 == 4)
        {
            --par4;
        }

        if (par7 == 5)
        {
            ++par4;
        }

        if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
        {
            return false;
        }
        else
        {
            if (par3World.isAirBlock(par4, par5, par6))
            {
                par3World.playSoundEffect((double)par4 + 0.5D, (double)par5 + 0.5D, (double)par6 + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
                par3World.setBlock(par4, par5, par6, Blocks.fire);
            }

            par1ItemStack.damageItem(1, par2EntityPlayer);
            return true;
        }
    }
}
