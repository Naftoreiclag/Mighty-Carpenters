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
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;

import naftoreiclag.mightycarpenters.things.blueprint.ItemBlueprint;
import naftoreiclag.mightycarpenters.things.cement.concrete.BlockConcrete;
import naftoreiclag.mightycarpenters.things.engineerhandtools.blowtorch.ItemBlowtorch;
import naftoreiclag.mightycarpenters.things.engineerhandtools.chainsaw.ItemChainsaw;
import naftoreiclag.mightycarpenters.things.engineerhandtools.drill.ItemDrill;
import naftoreiclag.mightycarpenters.things.engineerhandtools.glue.ItemGlue;
import naftoreiclag.mightycarpenters.things.engineerhandtools.hammer.ItemHammer;
import naftoreiclag.mightycarpenters.things.engineerhandtools.mallet.ItemMallet;
import naftoreiclag.mightycarpenters.things.engineerhandtools.nailgun.EntityFlyingNail;
import naftoreiclag.mightycarpenters.things.engineerhandtools.nailgun.ItemNailgun;
import naftoreiclag.mightycarpenters.things.engineerhandtools.saw.ItemSaw;
import naftoreiclag.mightycarpenters.things.engineerhandtools.scissors.ItemScissors;
import naftoreiclag.mightycarpenters.things.engineerhandtools.screwdriver.ItemScrewdriver;
import naftoreiclag.mightycarpenters.things.engineerhandtools.tape.ItemTape;
import naftoreiclag.mightycarpenters.things.engineerhandtools.wrench.ItemWrench;
import naftoreiclag.mightycarpenters.things.mecha.EntityDumbBox;
import naftoreiclag.mightycarpenters.things.mecha.EntityDummyBB;
import naftoreiclag.mightycarpenters.things.mecha.EntityMecha;
import naftoreiclag.mightycarpenters.things.mecha.ItemMechaCore;
import naftoreiclag.mightycarpenters.things.mecha.RenderDumbBox;
import naftoreiclag.mightycarpenters.things.mecha.RenderDummyBB;
import naftoreiclag.mightycarpenters.things.mecha.RenderMecha;
import naftoreiclag.mightycarpenters.things.rawcraftingmaterials.metals.BlockCopperOre;
import naftoreiclag.mightycarpenters.things.rawcraftingmaterials.metals.ItemCopperIngot;
import naftoreiclag.mightycarpenters.things.sketchstation.BlockSketchStation;
import naftoreiclag.mightycarpenters.things.sketchstation.SketchStationTentity;
import naftoreiclag.mightycarpenters.things.steelscaffold.BlockScaffold;
import naftoreiclag.mightycarpenters.things.steelscaffold.BlockScaffoldFence;
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
	
	@SidedProxy(clientSide = "naftoreiclag.mightycarpenters.ClientProxy", serverSide = "naftoreiclag.mightycarpenters.CommonProxy")
	public static CommonProxy proxy;
	
	public static Block block_copperOre;
	public static Item item_copperIngot;
	public static Item item_blowtorch;
	public static Item item_chainsaw;
	public static Item item_drill;
	public static Item item_glue;
	public static Item item_hammer;
	public static Item item_mallet;
	public static Item item_nailgun;
	public static Item item_saw;
	public static Item item_scissors;
	public static Item item_screwdriver;
	public static Item item_tape;
	public static Item item_wrench;
	public static Block block_shf;
	public static Block block_steel_scaffold;
	public static Block block_scaffold_fence;
	public static Block block_concrete;
	public static Block block_sketch_station;
	public static Item item_blueprint;
	public static Item item_mecha_core;
	public static WorldGenManager ev;
	
	@EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
		proxy.registerWorldGenModifier();
		proxy.registerMetals();
		proxy.registerEngineerHandTools();
		proxy.registerMiscItems();
		proxy.registerMechaSystem();
		proxy.registerScaffold();
		proxy.registerMobs();
    }
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.registerEntityRenderers();
	}
}
