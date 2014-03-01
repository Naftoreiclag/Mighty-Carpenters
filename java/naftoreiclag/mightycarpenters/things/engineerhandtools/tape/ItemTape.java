package naftoreiclag.mightycarpenters.things.engineerhandtools.tape;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import naftoreiclag.mightycarpenters.things.engineerhandtools.EHTTier;
import naftoreiclag.mightycarpenters.things.engineerhandtools.EHTType;
import naftoreiclag.mightycarpenters.things.engineerhandtools.EHTItem;
import naftoreiclag.mightycarpenters.util.MyStaticStrings;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemTape extends EHTItem
{
	public ItemTape()
	{
		super(MyStaticStrings.UNLOCALIZED_TAPE, EHTTier.CARDBOARD, EHTType.MODIFY);
		
		this.minability = 1.0f;
		this.painfulness = 1.0f;
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack item, World world, Block block, int x, int y, int z, EntityLivingBase user)
    {
		return true;
    }
	
	@Override
	public boolean hitEntity(ItemStack par1, EntityLivingBase par2, EntityLivingBase par3)
    {
        return true;
    }
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir)
	{
		this.itemIcon = ir.registerIcon(MyStaticStrings.TEXTURE_TAPE);
	}
}
