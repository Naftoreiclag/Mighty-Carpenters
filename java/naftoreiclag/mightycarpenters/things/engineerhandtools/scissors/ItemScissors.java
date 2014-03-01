package naftoreiclag.mightycarpenters.things.engineerhandtools.scissors;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import naftoreiclag.mightycarpenters.things.engineerhandtools.EHTTier;
import naftoreiclag.mightycarpenters.things.engineerhandtools.EHTType;
import naftoreiclag.mightycarpenters.things.engineerhandtools.EHTItem;
import naftoreiclag.mightycarpenters.util.MyStaticStrings;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item.ToolMaterial;

public class ItemScissors extends EHTItem
{
	public ItemScissors()
	{
		super(MyStaticStrings.UNLOCALIZED_SCISSORS, EHTTier.CARDBOARD, EHTType.MODIFY);
		
		// Painful as a two punches
		this.painfulness = 2.0f;
		
		// Mines like shears, but does not return item
		this.minability = ToolMaterial.GOLD.getEfficiencyOnProperMaterial();
		this.minableMaterials = new Material[]{ Material.leaves, Material.cactus, Material.carpet, Material.cloth, Material.plants, Material.vine, Material.web };
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir)
	{
		this.itemIcon = ir.registerIcon(MyStaticStrings.TEXTURE_SCISSORS);
	}
}
