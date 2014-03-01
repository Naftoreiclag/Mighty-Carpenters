package naftoreiclag.mightycarpenters;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
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

import naftoreiclag.mightycarpenters.things.blueprint.ItemBlueprint;
import naftoreiclag.mightycarpenters.things.engineerhandtools.nailgun.EntityFlyingNail;
import naftoreiclag.mightycarpenters.things.engineerhandtools.nailgun.ItemNailgun;
import naftoreiclag.mightycarpenters.things.engineerhandtools.wrench.ItemMonkeyWrench;
import naftoreiclag.mightycarpenters.things.rawcraftingmaterials.metals.BlockCopperOre;
import naftoreiclag.mightycarpenters.things.rawcraftingmaterials.metals.ItemCopperIngot;
import naftoreiclag.mightycarpenters.things.sketchstation.BlockSketchStation;
import naftoreiclag.mightycarpenters.things.sketchstation.SketchStationTentity;
import naftoreiclag.mightycarpenters.things.steelscaffold.BlockSteelScaffold;
import naftoreiclag.mightycarpenters.things.superhotfurnace.BlockShf;
import naftoreiclag.mightycarpenters.things.superhotfurnace.ShfGuiHandler;
import naftoreiclag.mightycarpenters.things.superhotfurnace.ShfTentity;
import naftoreiclag.mightycarpenters.things.undeadengineer.EntityUndeadEngineer;
import naftoreiclag.mightycarpenters.things.undeadengineer.RenderUndeadEngineer;
import naftoreiclag.mightycarpenters.util.MyStaticStrings;
import naftoreiclag.mightycarpenters.world.WorldGenManager;

@Mod(modid = MyStaticStrings.MOD_ID, version = MyStaticStrings.MOD_VER)
public class MightyCarpentersMod
{
	@Instance(MyStaticStrings.MOD_ID)
	public static MightyCarpentersMod instance;
	
	public static Block block_copperOre;
	
	public static Item item_copperIngot;
	
	public static Item item_monkeywrench;
	public static Item item_nailgun;
	
	public static Block block_shf;
	
	public static Block block_steel_scaffold;
	
	public static Block block_sketch_station;
	
	public static Item item_blueprint;
	
	private static int first_available_entity_id = 300;
	
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
		
		item_blueprint = new ItemBlueprint();
		GameRegistry.registerItem(item_blueprint, item_blueprint.getUnlocalizedName());
		
		GameRegistry.addShapelessRecipe(new ItemStack(this.item_blueprint, 1), new ItemStack((Item) Item.itemRegistry.getObject("paper")));
		
		new ShfGuiHandler();
    }
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		BiomeGenBase[] biomeList = BiomeGenBase.getBiomeGenArray();

		EntityRegistry.registerModEntity(EntityUndeadEngineer.class, "eddy", 1, this, 80, 3, true);

		for(int i = 0; i < biomeList.length; i++)
		{
			if(biomeList[i] != null)
			{
				EntityRegistry.addSpawn(EntityUndeadEngineer.class, 10, 1, 3, EnumCreatureType.monster, biomeList[i]);
			}
		}
		
		RenderingRegistry.registerEntityRenderingHandler(EntityUndeadEngineer.class, new RenderUndeadEngineer());

		registerEntityEgg(EntityUndeadEngineer.class, 22967, 4825967);
		
		//RenderingRegistry.registerEntityRenderingHandler(EntityFlyingNail.class, new RenderSnowball(item_monkeywrench));
		RenderingRegistry.registerEntityRenderingHandler(EntityFlyingNail.class, new RenderSnowball(item_monkeywrench));
	}

	public static int getUniqueEntityId()
	{
		while(EntityList.getClassFromID(first_available_entity_id) == null)
		{
			++ first_available_entity_id;
		}
		return first_available_entity_id;
	}

	public static void registerEntityEgg(Class entity, int primaryColor,
			int secondaryColor)
	{
		int id = getUniqueEntityId();
		//EntityList.addMapping(entity, "eddy", id, primaryColor, secondaryColor);
	}
}
