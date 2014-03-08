package naftoreiclag.mightycarpenters.things.clothing;

import naftoreiclag.mightycarpenters.MightyCarpentersMod;
import naftoreiclag.mightycarpenters.util.MyStaticStrings;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class ItemOveralls extends ItemArmor
{
	public ItemOveralls()
	{
		super(MightyCarpentersMod.armor_useless_iron, 1, 2);
		
		this.setCreativeTab(CreativeTabs.tabFood);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		return MyStaticStrings.MODEL_TEXTURE_OVERALLS;
	}

}
