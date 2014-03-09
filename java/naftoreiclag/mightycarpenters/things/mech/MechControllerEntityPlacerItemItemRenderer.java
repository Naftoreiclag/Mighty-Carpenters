package naftoreiclag.mightycarpenters.things.mech;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import naftoreiclag.mightycarpenters.MightyCarpentersMod;
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
public class MechControllerEntityPlacerItemItemRenderer implements IItemRenderer
{
	private final ModelBase model;
	private final ResourceLocation modelTexture;

	public MechControllerEntityPlacerItemItemRenderer()
	{
		model = new Model_Core();
		modelTexture = new ResourceLocation(MyStaticStrings.MODEL_TEXTURE_METAL_MECHA_CORE);
	}
	
	private void rawRender()
	{
		Minecraft.getMinecraft().renderEngine.bindTexture(modelTexture);
		GL11.glTranslatef((float) 0.5f, (float) 1.5F, (float) 0.5f);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
		switch(type)
		{
			case ENTITY:
			{
				GL11.glPushMatrix();
					GL11.glScalef(0.5f, 0.5f, 0.5f);
					GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
					rawRender();
				GL11.glPopMatrix();
				return;
			}
			
			case EQUIPPED:
			{
				GL11.glPushMatrix();
					rawRender();
				GL11.glPopMatrix();
				return;
			}
	
			case EQUIPPED_FIRST_PERSON:
			{
				GL11.glPushMatrix();
					rawRender();
				GL11.glPopMatrix();
				return;
			}
	
			case INVENTORY:
			{
				GL11.glPushMatrix();
					GL11.glTranslatef(0.0f, -0.07f, 0.0f);
					rawRender();
				GL11.glPopMatrix();
				return;
			}
	
			default:return;
		}
	}
}
