package naftoreiclag.zingpower;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;

import naftoreiclag.zingpower.things.metals.BlockCopperOre;
import naftoreiclag.zingpower.things.metals.ItemCopperIngot;
import naftoreiclag.zingpower.things.monkeywrench.ItemMonkeyWrench;
import naftoreiclag.zingpower.things.nailgun.EntityFlyingNail;
import naftoreiclag.zingpower.things.nailgun.ItemNailgun;
import naftoreiclag.zingpower.things.sketchstation.BlockSketchStation;
import naftoreiclag.zingpower.things.sketchstation.SketchStationTentity;
import naftoreiclag.zingpower.things.steelscaffold.BlockSteelScaffold;
import naftoreiclag.zingpower.things.superhotfurnace.BlockShf;
import naftoreiclag.zingpower.things.superhotfurnace.ShfGuiHandler;
import naftoreiclag.zingpower.things.superhotfurnace.ShfTentity;
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
	
	public static Block block_steel_scaffold;
	
	public static Block block_sketch_station;
	
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
		

		EntityRegistry.registerModEntity(EntityFlyingNail.class, "emeraldArrow", 0, instance, 120, 3, true);
		
		item_nailgun = new ItemNailgun();
		GameRegistry.registerItem(item_nailgun, item_nailgun.getUnlocalizedName());
		
		block_steel_scaffold = new BlockSteelScaffold();
		GameRegistry.registerBlock(block_steel_scaffold, block_steel_scaffold.getUnlocalizedName());
		
		block_sketch_station = new BlockSketchStation();
		GameRegistry.registerBlock(block_sketch_station, block_sketch_station.getUnlocalizedName());
		GameRegistry.registerTileEntity(SketchStationTentity.class, MyStaticStrings.TEID_SKETCH_STATION);
		
		new ShfGuiHandler();
    }
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		//RenderingRegistry.registerEntityRenderingHandler(EntityFlyingNail.class, new RenderSnowball(item_monkeywrench));
		RenderingRegistry.registerEntityRenderingHandler(EntityFlyingNail.class, new RenderSnowball(item_monkeywrench));
	}
}
