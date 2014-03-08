package naftoreiclag.mightycarpenters;

import naftoreiclag.mightycarpenters.things.engineerhandtools.nailgun.EntityFlyingNail;
import naftoreiclag.mightycarpenters.things.mech.MechControllerEntity;
import naftoreiclag.mightycarpenters.things.mech.PartEntity;
import naftoreiclag.mightycarpenters.things.mech.rendering.PartEntityRenderer;
import naftoreiclag.mightycarpenters.util.RenderNothing;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerMechSystem()
	{
		super.registerMechSystem();
		
		MinecraftForgeClient.registerItemRenderer(MightyCarpentersMod.item_mech_core_placer, new PartEntityRenderer());
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
