package naftoreiclag.mightycarpenters;

import naftoreiclag.mightycarpenters.things.engineerhandtools.nailgun.EntityFlyingNail;
import naftoreiclag.mightycarpenters.things.mech.MechControllerEntity;
import naftoreiclag.mightycarpenters.things.mech.PartEntity;
import naftoreiclag.mightycarpenters.things.mech.PartEntityRenderer;
import naftoreiclag.mightycarpenters.things.mech.MechControllerEntityPlacerItemItemRenderer;
import naftoreiclag.mightycarpenters.things.models.ModelLoader;
import naftoreiclag.mightycarpenters.things.models.Model_Core;
import naftoreiclag.mightycarpenters.things.models.Model_Joint;
import naftoreiclag.mightycarpenters.util.MyStaticStrings;
import naftoreiclag.mightycarpenters.util.RenderNothing;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.RenderingRegistry;

import static naftoreiclag.mightycarpenters.MightyCarpentersMod.*;
import static naftoreiclag.mightycarpenters.util.MyStaticStrings.*;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerMechSystem()
	{
		super.registerMechSystem();
		
		MinecraftForgeClient.registerItemRenderer(item_mech_controller_entity_placer, new MechControllerEntityPlacerItemItemRenderer());
	
		ModelLoader.addModelAndTexture("foop", new Model_Core(), new ResourceLocation(MODEL_TEXTURE_METAL_MECHA_CORE));
		
		for(int color = 0; color < 6; ++ color)
		{
			for(int shade = 0; shade < 2; ++ shade)
			{
				ModelLoader.addModelAndTexture(MODEL_ID_JOINT_HIGHLIGHTER[color][shade], new Model_Joint(color, shade), new ResourceLocation(MODEL_TEXTURE_JOINT_HIGHLIGHTER));
			}
		}
	}
	
	@Override
	public void registerEntityRenderers()
	{
		super.registerEntityRenderers();

		//RenderingRegistry.registerEntityRenderingHandler(EntityMechCore.class, new RenderNothing());
		RenderingRegistry.registerEntityRenderingHandler(PartEntity.class, new PartEntityRenderer());
		
		RenderingRegistry.registerEntityRenderingHandler(EntityFlyingNail.class, new RenderSnowball(item_wrench));
	}
}
