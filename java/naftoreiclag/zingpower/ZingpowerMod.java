package naftoreiclag.zingpower;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

import naftoreiclag.zingpower.block.BlockCopperOre;
import naftoreiclag.zingpower.block.superhotfurnace.BlockShf;
import naftoreiclag.zingpower.block.superhotfurnace.ShfGuiHandler;
import naftoreiclag.zingpower.block.superhotfurnace.ShfTentity;
import naftoreiclag.zingpower.item.ItemCopperIngot;
import naftoreiclag.zingpower.item.monkeywrench.ItemMonkeyWrench;
import naftoreiclag.zingpower.item.nailgun.ItemNailgun;
import naftoreiclag.zingpower.util.MyStaticStrings;
import naftoreiclag.zingpower.world.WorldGenManager;

@Mod(modid = MyStaticStrings.MOD_ID, version = MyStaticStrings.MOD_VER)
public class ZingpowerMod
{
	@Instance(MyStaticStrings.MOD_ID)
	public static ZingpowerMod instance;
	
	public static Block block_copperOre;
	
	public static Item item_copperIngot;
	
	public static Item item_monkeywrench;
	public static Item item_nailgun;
	
	public static Block block_shf;
	
	WorldGenManager ev = new WorldGenManager();
	
	@EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
		block_copperOre = new BlockCopperOre();
		GameRegistry.registerBlock(block_copperOre, block_copperOre.getUnlocalizedName());
		OreDictionary.registerOre("oreCopper", block_copperOre);
		
		item_copperIngot = new ItemCopperIngot();
		GameRegistry.registerItem(item_copperIngot, item_copperIngot.getUnlocalizedName());
		OreDictionary.registerOre("ingotCopper", item_copperIngot);
    
		GameRegistry.registerWorldGenerator(ev, 1);
		
		block_shf = new BlockShf();
		GameRegistry.registerBlock(block_shf, block_shf.getUnlocalizedName());
		GameRegistry.registerTileEntity(ShfTentity.class, MyStaticStrings.TEID_SHF);
		
		GameRegistry.addSmelting(block_copperOre, new ItemStack(item_copperIngot), 0.1f);
		
		item_monkeywrench = new ItemMonkeyWrench();
		GameRegistry.registerItem(item_monkeywrench, item_monkeywrench.getUnlocalizedName());
		
		item_nailgun = new ItemNailgun();
		GameRegistry.registerItem(item_nailgun, item_nailgun.getUnlocalizedName());
		
		
		new ShfGuiHandler();
    }
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
	}
}
