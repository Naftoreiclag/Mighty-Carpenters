package naftoreiclag.mightycarpenters;

import naftoreiclag.mightycarpenters.things.engineerhandtools.nailgun.EntityFlyingNail;
import naftoreiclag.mightycarpenters.things.mech.MechControllerEntity;
import naftoreiclag.mightycarpenters.things.mech.PartEntity;
import naftoreiclag.mightycarpenters.things.mech.PartEntityRenderer;
import naftoreiclag.mightycarpenters.things.mech.MechControllerEntityPlacerItemItemRenderer;
import naftoreiclag.mightycarpenters.things.mech.models.ModelLoader;
import naftoreiclag.mightycarpenters.things.mech.models.Model_Core;
import naftoreiclag.mightycarpenters.util.MyStaticStrings;
import naftoreiclag.mightycarpenters.util.RenderNothing;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerMechSystem()
	{
		super.registerMechSystem();
		
		MinecraftForgeClient.registerItemRenderer(MightyCarpentersMod.item_mech_controller_entity_placer, new MechControllerEntityPlacerItemItemRenderer());
	
		ModelLoader.addModelAndTexture("foop", new Model_Core(), new ResourceLocation(MyStaticStrings.MODEL_TEXTURE_METAL_MECHA_CORE));
	}
	
	@Override
	public void registerEntityRenderers()
	{
		super.registerEntityRenderers();

		//RenderingRegistry.registerEntityRenderingHandler(EntityMechCore.class, new RenderNothing());
		RenderingRegistry.registerEntityRenderingHandler(PartEntity.class, new PartEntityRenderer());
		
		RenderingRegistry.registerEntityRenderingHandler(EntityFlyingNail.class, new RenderSnowball(MightyCarpentersMod.item_wrench));
	}
}
