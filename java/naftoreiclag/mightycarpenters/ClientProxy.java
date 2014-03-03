package naftoreiclag.mightycarpenters;

import naftoreiclag.mightycarpenters.things.engineerhandtools.nailgun.EntityFlyingNail;
import naftoreiclag.mightycarpenters.things.multipart.EntityArbolPart;
import naftoreiclag.mightycarpenters.things.multipart.EntityArbolRoot;
import naftoreiclag.mightycarpenters.things.multipart.RenderArbolPart;
import naftoreiclag.mightycarpenters.things.multipart.RenderArbolRoot;
import net.minecraft.client.renderer.entity.RenderSnowball;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerEntityRenderers()
	{
		super.registerEntityRenderers();

		RenderingRegistry.registerEntityRenderingHandler(EntityArbolRoot.class, new RenderArbolRoot());
		RenderingRegistry.registerEntityRenderingHandler(EntityArbolPart.class, new RenderArbolPart());
		
		RenderingRegistry.registerEntityRenderingHandler(EntityFlyingNail.class, new RenderSnowball(MightyCarpentersMod.item_wrench));
	}
}
