package naftoreiclag.mightycarpenters.things.mech;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import naftoreiclag.mightycarpenters.MightyCarpentersMod;
import naftoreiclag.mightycarpenters.things.models.ModelLoader;
import naftoreiclag.mightycarpenters.things.models.Model_Core;
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
	public PartEntityRenderer()
	{
		this.shadowSize = 0.0f;
	}
	
	void render(PartEntity entity, float x, float y, float z)
	{
		// Somehow, the x, y, z combo is relative to the player
		
		// System.out.println("la:" + entity.posX + ", " + entity.posY + ", " + entity.posZ);
		// System.out.println("da:" + x + ", " + y + ", " + z);
		
		GL11.glPushMatrix();
			GL11.glTranslatef(x, y, z);
			entity.part.renderModel();
			for(Joint j : entity.part.lightJoints)
			{
				GL11.glPushMatrix();
					GL11.glTranslatef(j.relPos.x, j.relPos.y, j.relPos.z);
					ModelLoader.render(MyStaticStrings.MODEL_ID_JOINT_HIGHLIGHTER[2][0]);
				GL11.glPopMatrix();
			}
			
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
		
		render((PartEntity) entity, (float) x, (float) y, (float) z);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity genericEntity)
	{
		return TextureMap.locationBlocksTexture;
	}
	
	public static int getIntegerFromColor(JointColor color)
	{
		switch(color)
		{
			case red: return 0;
			case orange: return 1;
			case yellow: return 2;
			case green: return 3;
			case blue: return 4;
			case purple: return 5;
			default: return 1337;
		}
	}
	
	public static int getIntegerFromShade(JointShade shade)
	{
		switch(shade)
		{
			case dark: return 0;
			case light: return 1;
			default: return 1337;
		}
	}
}
