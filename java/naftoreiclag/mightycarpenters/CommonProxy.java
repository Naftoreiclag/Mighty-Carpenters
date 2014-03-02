package naftoreiclag.mightycarpenters;

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
import naftoreiclag.mightycarpenters.things.mecha.RenderDummyBB;
import naftoreiclag.mightycarpenters.things.mecha.RenderMecha;
import naftoreiclag.mightycarpenters.things.rawcraftingmaterials.metals.BlockCopperOre;
import naftoreiclag.mightycarpenters.things.rawcraftingmaterials.metals.ItemCopperIngot;
import naftoreiclag.mightycarpenters.things.sketchstation.BlockSketchStation;
import naftoreiclag.mightycarpenters.things.sketchstation.SketchStationTentity;
import naftoreiclag.mightycarpenters.things.steelscaffold.BlockScaffold;
import naftoreiclag.mightycarpenters.things.steelscaffold.BlockScaffoldFence;
import naftoreiclag.mightycarpenters.util.MyStaticStrings;
import naftoreiclag.mightycarpenters.world.WorldGenManager;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy
{
	private void itemRegisterMacro(Item item)
	{
		GameRegistry.registerItem(item, item.getUnlocalizedName());
	}
	private void blockRegisterMacro(Block block)
	{
		GameRegistry.registerBlock(block, block.getUnlocalizedName());
	}

	public void registerEngineerHandTools()
	{
		MightyCarpentersMod.item_blowtorch = new ItemBlowtorch();
		MightyCarpentersMod.item_chainsaw = new ItemChainsaw();
		MightyCarpentersMod.item_drill = new ItemDrill();
		MightyCarpentersMod.item_glue = new ItemGlue();
		MightyCarpentersMod.item_hammer = new ItemHammer();
		MightyCarpentersMod.item_mallet = new ItemMallet();
		MightyCarpentersMod.item_nailgun = new ItemNailgun();
		MightyCarpentersMod.item_saw = new ItemSaw();
		MightyCarpentersMod.item_scissors = new ItemScissors();
		MightyCarpentersMod.item_screwdriver = new ItemScrewdriver();
		MightyCarpentersMod.item_tape = new ItemTape();
		MightyCarpentersMod.item_wrench = new ItemWrench();
		
		itemRegisterMacro(MightyCarpentersMod.item_blowtorch);
		itemRegisterMacro(MightyCarpentersMod.item_chainsaw);
		itemRegisterMacro(MightyCarpentersMod.item_drill);
		itemRegisterMacro(MightyCarpentersMod.item_glue);
		itemRegisterMacro(MightyCarpentersMod.item_hammer);
		itemRegisterMacro(MightyCarpentersMod.item_mallet);
		itemRegisterMacro(MightyCarpentersMod.item_nailgun);
		itemRegisterMacro(MightyCarpentersMod.item_saw);
		itemRegisterMacro(MightyCarpentersMod.item_scissors);
		itemRegisterMacro(MightyCarpentersMod.item_screwdriver);
		itemRegisterMacro(MightyCarpentersMod.item_tape);
		itemRegisterMacro(MightyCarpentersMod.item_wrench);
		
		EntityRegistry.registerModEntity(EntityFlyingNail.class, "flyingNail", 0, MightyCarpentersMod.instance, 120, 3, true);
	}

	public void registerMechaSystem()
	{
		MightyCarpentersMod.item_mecha_core = new ItemMechaCore();
		itemRegisterMacro(MightyCarpentersMod.item_blowtorch);
		
		EntityRegistry.registerModEntity(EntityMecha.class, "dylanbutt", 500, MightyCarpentersMod.instance, 80, 1, true);
		EntityRegistry.registerModEntity(EntityDummyBB.class, "cjbutt", 501, MightyCarpentersMod.instance, 80, 1, true);
		EntityRegistry.registerModEntity(EntityDumbBox.class, "dumbbox", 42, MightyCarpentersMod.instance, 80, 1, true);
	}

	public void registerScaffold()
	{
		MightyCarpentersMod.block_steel_scaffold = new BlockScaffold();
		blockRegisterMacro(MightyCarpentersMod.block_steel_scaffold);
		
		MightyCarpentersMod.block_scaffold_fence = new BlockScaffoldFence();
		blockRegisterMacro(MightyCarpentersMod.block_scaffold_fence);
	}

	public void registerMobs()
	{
		// TODO Auto-generated method stub
		
	}

	public void registerMiscItems()
	{
		/*
		block_sketch_station = new BlockSketchStation();
		GameRegistry.registerBlock(block_sketch_station, block_sketch_station.getUnlocalizedName());
		GameRegistry.registerTileEntity(SketchStationTentity.class, MyStaticStrings.TEID_SKETCH_STATION);
		
		item_blueprint = new ItemBlueprint();
		GameRegistry.registerItem(item_blueprint, item_blueprint.getUnlocalizedName());
		GameRegistry.addShapelessRecipe(new ItemStack(this.item_blueprint, 1), new ItemStack((Item) Item.itemRegistry.getObject("paper")));
		
		block_concrete = new BlockConcrete();
		GameRegistry.registerBlock(block_concrete, block_concrete.getUnlocalizedName());
		*/
	}

	public void registerMetals()
	{
		MightyCarpentersMod.block_copperOre = new BlockCopperOre();
		blockRegisterMacro(MightyCarpentersMod.block_copperOre);
		OreDictionary.registerOre("oreCopper", MightyCarpentersMod.block_copperOre);
		
		MightyCarpentersMod.item_copperIngot = new ItemCopperIngot();
		itemRegisterMacro(MightyCarpentersMod.item_copperIngot);
		OreDictionary.registerOre("ingotCopper", MightyCarpentersMod.item_copperIngot);
    
	}
	public void registerWorldGenModifier()
	{
		MightyCarpentersMod.ev = new WorldGenManager();
		
		GameRegistry.registerWorldGenerator(MightyCarpentersMod.ev, 1);
	}
	
	public void registerEntityRenderers()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityMecha.class, new RenderMecha());
		RenderingRegistry.registerEntityRenderingHandler(EntityDummyBB.class, new RenderDummyBB());
	}

}
