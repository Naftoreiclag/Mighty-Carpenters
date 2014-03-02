package naftoreiclag.mightycarpenters;

import naftoreiclag.mightycarpenters.things.engineerhandtools.nailgun.EntityFlyingNail;
import naftoreiclag.mightycarpenters.things.mecha.EntityDummyBB;
import naftoreiclag.mightycarpenters.things.mecha.EntityMecha;
import naftoreiclag.mightycarpenters.things.mecha.RenderDummyBB;
import naftoreiclag.mightycarpenters.things.mecha.RenderMecha;
import net.minecraft.client.renderer.entity.RenderSnowball;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerEntityRenderers()
	{
		super.registerEntityRenderers();
		
		RenderingRegistry.registerEntityRenderingHandler(EntityFlyingNail.class, new RenderSnowball(MightyCarpentersMod.item_wrench));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityMecha.class, new RenderMecha());
		RenderingRegistry.registerEntityRenderingHandler(EntityDummyBB.class, new RenderDummyBB());
	}
}
