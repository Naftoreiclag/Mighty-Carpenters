package naftoreiclag.mightycarpenters;

import naftoreiclag.mightycarpenters.things.engineerhandtools.nailgun.EntityFlyingNail;
import naftoreiclag.mightycarpenters.things.mecha.EntityMechPart;
import naftoreiclag.mightycarpenters.things.mecha.EntityMechCore;
import naftoreiclag.mightycarpenters.things.mecha.RenderMechPart;
import naftoreiclag.mightycarpenters.things.mecha.RenderMechCore;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerMechSystem()
	{
		super.registerMechSystem();
		
		MinecraftForgeClient.registerItemRenderer(MightyCarpentersMod.item_mech_core_placer, new RenderMechCore());
	}
	
	@Override
	public void registerEntityRenderers()
	{
		super.registerEntityRenderers();

		RenderingRegistry.registerEntityRenderingHandler(EntityMechCore.class, new RenderMechCore());
		RenderingRegistry.registerEntityRenderingHandler(EntityMechPart.class, new RenderMechPart());
		
		RenderingRegistry.registerEntityRenderingHandler(EntityFlyingNail.class, new RenderSnowball(MightyCarpentersMod.item_wrench));
	}
}
