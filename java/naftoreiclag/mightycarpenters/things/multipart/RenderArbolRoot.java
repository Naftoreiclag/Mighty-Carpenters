package naftoreiclag.mightycarpenters.things.multipart;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import naftoreiclag.mightycarpenters.MightyCarpentersMod;
import naftoreiclag.mightycarpenters.things.steelscaffold.BlockScaffoldFence;
import naftoreiclag.mightycarpenters.util.MyStaticStrings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAnvil;
import net.minecraft.block.BlockDragonEgg;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelLeashKnot;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLeashKnot;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class RenderArbolRoot extends Render
{
	private final ModelMechCore model;
	private final ResourceLocation modelTexture;

	public RenderArbolRoot()
	{
		model = new ModelMechCore();
		modelTexture = new ResourceLocation(MyStaticStrings.MODEL_TEXTURE_METAL_MECHA_CORE);
		
		this.shadowSize = 0.0f;
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float uselessFloat1_, float uselessFloat2_)
    {
		GL11.glPushMatrix();
			GL11.glTranslatef((float) x + 0.5f, (float) y + 1.5F, (float) z + 0.5f);
			Minecraft.getMinecraft().renderEngine.bindTexture(modelTexture);
			GL11.glPushMatrix();
				GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
				this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity genericEntity)
	{
		return TextureMap.locationBlocksTexture;
	}
}
