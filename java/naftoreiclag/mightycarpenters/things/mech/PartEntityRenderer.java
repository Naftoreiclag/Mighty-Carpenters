package naftoreiclag.mightycarpenters.things.mech;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import naftoreiclag.mightycarpenters.MightyCarpentersMod;
import naftoreiclag.mightycarpenters.things.mech.models.JointModel;
import naftoreiclag.mightycarpenters.things.mech.models.Model_Core;
import naftoreiclag.mightycarpenters.things.steelscaffold.BlockScaffoldFence;
import naftoreiclag.mightycarpenters.util.MyStaticStrings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAnvil;
import net.minecraft.block.BlockDragonEgg;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelLeashKnot;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLeashKnot;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;

@SideOnly(Side.CLIENT)
public class PartEntityRenderer extends Render
{
	private final JointModel model;
	private final ResourceLocation modelTexture;
	
	public PartEntityRenderer()
	{
		this.model = new JointModel();
		this.modelTexture = new ResourceLocation(MyStaticStrings.MODEL_TEXTURE_JOINT_HIGHLIGHTER);
		
		this.shadowSize = 0.0f;
	}
	
	void doRender(PartEntity entity, float x, float y, float z)
	{

		// Somehow, the x, y, z combo is relative to the player
		
		// System.out.println("la:" + entity.posX + ", " + entity.posY + ", " + entity.posZ);
		// System.out.println("da:" + x + ", " + y + ", " + z);
		
		GL11.glPushMatrix();
			GL11.glTranslatef(x, y, z);
			entity.part.renderModel();

			/*Minecraft.getMinecraft().renderEngine.bindTexture(modelTexture);
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			
			for(Joint j : entity.part.getLightJoints())
			{
				GL11.glPushMatrix();
					GL11.glTranslatef(j.getLoc().x, j.getLoc().y, j.getLoc().z);
					model.easyRender(j);
				GL11.glPopMatrix();
			}*/
			
		GL11.glPopMatrix();
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float uselessFloat1_, float uselessFloat2_)
    {
		if(!(entity instanceof PartEntity))
		{
			// HUH!?
			return;
		}
		
		doRender((PartEntity) entity, (float) x, (float) y, (float) z);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity genericEntity)
	{
		return TextureMap.locationBlocksTexture;
	}
}
