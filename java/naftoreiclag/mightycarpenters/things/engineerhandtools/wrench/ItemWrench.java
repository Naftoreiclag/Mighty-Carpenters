package naftoreiclag.mightycarpenters.things.engineerhandtools.wrench;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import naftoreiclag.mightycarpenters.things.engineerhandtools.EHTTier;
import naftoreiclag.mightycarpenters.things.engineerhandtools.EHTType;
import naftoreiclag.mightycarpenters.things.engineerhandtools.EHTItem;
import naftoreiclag.mightycarpenters.util.MyStaticStrings;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

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
}
