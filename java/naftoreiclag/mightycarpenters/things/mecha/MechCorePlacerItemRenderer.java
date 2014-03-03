package naftoreiclag.mightycarpenters.things.mecha;

import org.lwjgl.opengl.GL11;

import naftoreiclag.mightycarpenters.things.multipart.ModelMechCore;
import naftoreiclag.mightycarpenters.util.MyStaticStrings;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class MechCorePlacerItemRenderer implements IItemRenderer
{
	private final ModelMechCore model;
	private final ResourceLocation modelTexture;

	public MechCorePlacerItemRenderer()
	{
		model = new ModelMechCore();
		modelTexture = new ResourceLocation(MyStaticStrings.MODEL_TEXTURE_METAL_MECHA_CORE_FAKE_SHADING);
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
			case EQUIPPED:
			{
				GL11.glPushMatrix();
					GL11.glDisable(GL11.GL_LIGHTING);
					GL11.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
					GL11.glPushMatrix();
						GL11.glTranslatef((float) 0.5f, (float) 1.5F, (float) 0.5f);
						Minecraft.getMinecraft().renderEngine.bindTexture(modelTexture);
						GL11.glPushMatrix();
							GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
							this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
						GL11.glPopMatrix();
					GL11.glPopMatrix();
					GL11.glEnable(GL11.GL_LIGHTING);
				GL11.glPopMatrix();
				return;
			}
	
			case EQUIPPED_FIRST_PERSON:
			{
				GL11.glPushMatrix();
					GL11.glDisable(GL11.GL_LIGHTING);
					GL11.glPushMatrix();
						GL11.glTranslatef((float) 0.5f, (float) 1.5F, (float) 0.5f);
						Minecraft.getMinecraft().renderEngine.bindTexture(modelTexture);
						GL11.glPushMatrix();
							GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
							this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
						GL11.glPopMatrix();
					GL11.glPopMatrix();
					GL11.glEnable(GL11.GL_LIGHTING);
				GL11.glPopMatrix();
				return;
			}
	
			case INVENTORY:
			{
				GL11.glPushMatrix();
					GL11.glDisable(GL11.GL_LIGHTING);
					GL11.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
					GL11.glTranslatef(0.0f, -0.87f, 0.0f);
					GL11.glPushMatrix();
						GL11.glTranslatef((float) 0.5f, (float) 1.5F, (float) 0.5f);
						Minecraft.getMinecraft().renderEngine.bindTexture(modelTexture);
						GL11.glPushMatrix();
							GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
							this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
						GL11.glPopMatrix();
					GL11.glPopMatrix();
					GL11.glEnable(GL11.GL_LIGHTING);
				GL11.glPopMatrix();
				return;
			}
	
			default:return;
		}
	}
}
