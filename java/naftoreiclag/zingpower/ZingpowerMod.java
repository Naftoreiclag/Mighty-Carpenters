package naftoreiclag.zingpower;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

import naftoreiclag.zingpower.util.MyStaticStrings;

@Mod(modid = MyStaticStrings.MOD_ID, version = MyStaticStrings.MOD_VER)
public class ZingpowerMod
{
	public static Block tutorialBlock;
	
	WorldGenManager ev = new WorldGenManager();
	
	@EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
		tutorialBlock = new BlockOreCopper();
		GameRegistry.registerBlock(tutorialBlock, tutorialBlock.getUnlocalizedName());
    
		GameRegistry.registerWorldGenerator(ev, 1);
    }
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
	}
}
