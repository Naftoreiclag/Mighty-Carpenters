package naftoreiclag.mightycarpenters;

import naftoreiclag.mightycarpenters.things.blueprint.ItemBlueprint;
import naftoreiclag.mightycarpenters.things.cement.concrete.BlockConcrete;
import naftoreiclag.mightycarpenters.things.clothing.ItemGoggles;
import naftoreiclag.mightycarpenters.things.clothing.ItemOveralls;
import naftoreiclag.mightycarpenters.things.clothing.ItemVest;
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
import naftoreiclag.mightycarpenters.things.mech.MechControllerEntity;
import naftoreiclag.mightycarpenters.things.mech.MechControllerEntityPlacerItem;
import naftoreiclag.mightycarpenters.things.mech.PartEntity;
import naftoreiclag.mightycarpenters.things.rawcraftingmaterials.metals.BlockCopperOre;
import naftoreiclag.mightycarpenters.things.rawcraftingmaterials.metals.ItemCopperIngot;
import naftoreiclag.mightycarpenters.things.sketchstation.BlockSketchStation;
import naftoreiclag.mightycarpenters.things.sketchstation.SketchStationTentity;
import naftoreiclag.mightycarpenters.things.steelscaffold.BlockScaffold;
import naftoreiclag.mightycarpenters.things.steelscaffold.BlockScaffoldFence;
import naftoreiclag.mightycarpenters.util.MyStaticStrings;
import naftoreiclag.mightycarpenters.world.WorldGenManager;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

import static naftoreiclag.mightycarpenters.MightyCarpentersMod.*;
import static naftoreiclag.mightycarpenters.util.MyStaticStrings.*;

public class CommonProxy
{
	// Register an Item
	private void registerPls(Item item)
	{
		GameRegistry.registerItem(item, item.getUnlocalizedName());
	}
	
	// Register a Block
	private void registerPls(Block block)
	{
		GameRegistry.registerBlock(block, block.getUnlocalizedName());
	}
	
	// Register an Entity
	private void registerPls(String entityName, int id, Class<? extends Entity> entityClass, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates)
	{
		EntityRegistry.registerModEntity(entityClass, entityName, id, instance, trackingRange, updateFrequency, sendsVelocityUpdates);
	}
	
	// Register an Item as an Ore
	private void registerPls(Item item, String oreName)
	{
		registerPls(item);
		OreDictionary.registerOre(oreName, item);
	}
	
	// Register a Block as an Ore
	private void registerPls(Block block, String oreName)
	{
		registerPls(block);
		OreDictionary.registerOre(oreName, block);
	}

	public void registerEngineerHandTools()
	{
		item_blowtorch = new ItemBlowtorch();
		item_chainsaw = new ItemChainsaw();
		item_drill = new ItemDrill();
		item_glue = new ItemGlue();
		item_hammer = new ItemHammer();
		item_mallet = new ItemMallet();
		item_nailgun = new ItemNailgun();
		item_saw = new ItemSaw();
		item_scissors = new ItemScissors();
		item_screwdriver = new ItemScrewdriver();
		item_tape = new ItemTape();
		item_wrench = new ItemWrench();
		
		registerPls(item_blowtorch);
		registerPls(item_chainsaw);
		registerPls(item_drill);
		registerPls(item_glue);
		registerPls(item_hammer);
		registerPls(item_mallet);
		registerPls(item_nailgun);
		registerPls(item_saw);
		registerPls(item_scissors);
		registerPls(item_screwdriver);
		registerPls(item_tape);
		registerPls(item_wrench);
		
		registerPls("flyingNail", 0, EntityFlyingNail.class, 120, 3, true);
	}

	public void registerMechSystem()
	{
		item_mech_core_placer = new MechControllerEntityPlacerItem();
		registerPls(item_mech_core_placer);
		
		registerPls(ENTITY_ID_STRING_MECH_ROOT, ENTITY_ID_INT_MECH_ROOT, MechControllerEntity.class, 80, 1, true);
		registerPls(ENTITY_ID_STRING_MECH_PART, ENTITY_ID_INT_MECH_ROOT, PartEntity.class, 80, 1, true);
	}

	public void registerScaffold()
	{
		block_steel_scaffold = new BlockScaffold();
		registerPls(block_steel_scaffold);
		
		block_scaffold_fence = new BlockScaffoldFence();
		registerPls(block_scaffold_fence);
	}

	public void registerMobs()
	{
		// TODO Auto-generated method stub
		
	}

	public void registerMiscItems()
	{
		
		block_sketch_station = new BlockSketchStation();
		registerPls(block_sketch_station);
		GameRegistry.registerTileEntity(SketchStationTentity.class, TEID_SKETCH_STATION);
		
		item_blueprint = new ItemBlueprint();
		registerPls(item_blueprint);
		GameRegistry.addShapelessRecipe(new ItemStack(item_blueprint, 1), new ItemStack((Item) Item.itemRegistry.getObject("paper")));
		
		block_concrete = new BlockConcrete();
		registerPls(block_concrete);
		
	}

	public void registerMetals()
	{
		block_copperOre = new BlockCopperOre();
		registerPls(block_copperOre, "oreCopper");
		
		item_copperIngot = new ItemCopperIngot();
		registerPls(item_copperIngot, "ingotCopper");
    
	}
	public void registerWorldGenModifier()
	{
		worldGenModifier = new WorldGenManager();
		GameRegistry.registerWorldGenerator(worldGenModifier, 1);
	}
	
	public void registerClothing()
	{
		// You gotta register the armor materials first
		armor_useless_iron = EnumHelper.addArmorMaterial("USELESSIRON", 15, new int[]{0, 0, 0, 0}, 9);
		
		item_overalls = new ItemOveralls();
		registerPls(item_overalls);
		
		item_vest = new ItemVest();
		registerPls(item_vest);
		
		item_goggles = new ItemGoggles();
		registerPls(item_goggles);
	}
	
	public void registerEntityRenderers()
	{
		// =================================
		// | DONT PUT ANYTHING HERE DUMMY! |
		// =================================
	}

}
