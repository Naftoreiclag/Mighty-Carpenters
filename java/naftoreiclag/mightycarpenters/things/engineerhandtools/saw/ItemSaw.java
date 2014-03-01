package naftoreiclag.mightycarpenters.things.engineerhandtools.saw;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import naftoreiclag.mightycarpenters.things.engineerhandtools.EHTTier;
import naftoreiclag.mightycarpenters.things.engineerhandtools.EHTType;
import naftoreiclag.mightycarpenters.things.engineerhandtools.EHTItem;
import naftoreiclag.mightycarpenters.util.MyStaticStrings;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class ItemSaw extends EHTItem
{
	public ItemSaw()
	{
		super(MyStaticStrings.UNLOCALIZED_SAW, EHTTier.WOOD, EHTType.DESTROY);
		
		// Painful as a stone sword
		this.painfulness = 6.0f;
		
		// Mines like a stone axe
		this.minability = ToolMaterial.STONE.getEfficiencyOnProperMaterial();
		this.minableMaterials = new Material[]{ Material.wood, Material.vine };
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir)
	{
		this.itemIcon = ir.registerIcon(MyStaticStrings.TEXTURE_SAW);
	}
}
	