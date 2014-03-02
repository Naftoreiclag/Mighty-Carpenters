package naftoreiclag.mightycarpenters.things.mecha;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import naftoreiclag.mightycarpenters.MightyCarpentersMod;
import naftoreiclag.mightycarpenters.things.steelscaffold.BlockScaffoldFence;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAnvil;
import net.minecraft.block.BlockDragonEgg;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class RenderMecha extends Render
{
	private final RenderBlocks renderBlocks = new RenderBlocks();

	public RenderMecha()
	{
		this.shadowSize = 0.5f;
	}

	/**
	 * Actually renders the given argument. This is a synthetic bridge method,
	 * always casting down its argument and then handing it off to a worker
	 * function which does the actual work. In all probabilty, the class Render
	 * is generic (Render<T extends Entity) and this method has signature public
	 * void doRender(T entity, double d, double d1, double d2, float f, float
	 * f1). But JAD is pre 1.5 so doesn't do that.
	 */
	@Override
	public void doRender(Entity entity, double x, double y, double z, float uselessFloat1_, float uselessFloat2_)
	{
		World world = entity.worldObj;
		Block block = MightyCarpentersMod.block_concrete;
		int blockX = MathHelper.floor_double(entity.posX);
		int blockY = MathHelper.floor_double(entity.posY);
		int blockZ = MathHelper.floor_double(entity.posZ);

		if (block != null && block != world.getBlock(blockX, blockY, blockZ))
		{
			GL11.glPushMatrix();
			GL11.glTranslatef((float) x, (float) y, (float) z);
			this.bindEntityTexture(entity);
			GL11.glDisable(GL11.GL_LIGHTING);
			Tessellator tessellator;

			/*
			if (block instanceof BlockAnvil)
			{

				renderBlocks.blockAccess = world;
				tessellator = Tessellator.instance;
				tessellator.startDrawingQuads();
				tessellator.setTranslation((double) ((float) (-blockX) - 0.5F), (double) ((float) (-blockY) - 0.5F), (double) ((float) (-blockZ) - 0.5F));
				renderBlocks.renderBlockAnvilMetadata((BlockAnvil) block, blockX, blockY, blockZ, 0);
				tessellator.setTranslation(0.0D, 0.0D, 0.0D);
				tessellator.draw();

			}
			else if (block instanceof BlockDragonEgg)
			{
				renderBlocks.blockAccess = world;
				tessellator = Tessellator.instance;
				tessellator.startDrawingQuads();
				tessellator.setTranslation((double) ((float) (-blockX) - 0.5F), (double) ((float) (-blockY) - 0.5F), (double) ((float) (-blockZ) - 0.5F));
				renderBlocks.renderBlockDragonEgg((BlockDragonEgg) block, blockX, blockY, blockZ);
				tessellator.setTranslation(0.0D, 0.0D, 0.0D);
				tessellator.draw();
			}
			else
			{
				renderBlocks.setRenderBoundsFromBlock(block);
				renderBlocks.renderBlockSandFalling(block, world, blockX, blockY, blockZ, entity.field_145814_a);
			}
			*/
			
			
			renderBlocks.setRenderBoundsFromBlock(block);
			renderBlocks.renderBlockSandFalling(block, world, blockX, blockY, blockZ, 0);

			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glPopMatrix();
		}
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity genericEntity)
	{
		return TextureMap.locationBlocksTexture;
	}
}
