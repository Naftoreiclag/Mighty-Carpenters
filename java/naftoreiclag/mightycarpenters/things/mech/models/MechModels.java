package naftoreiclag.mightycarpenters.things.mech.models;

import java.util.HashMap;
import java.util.Map;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class MechModels
{
	public static Map<String, ModelBase> models = new HashMap<String, ModelBase>();
	public static Map<String, ResourceLocation> textures = new HashMap<String, ResourceLocation>();
	
	public static void addModelAndTexture(String s, ModelBase model, ResourceLocation texture)
	{
		models.put(s, model);
		textures.put(s, texture);
	}
	
	public static void render(String s)
	{
		Minecraft.getMinecraft().renderEngine.bindTexture(textures.get(s));
		GL11.glTranslatef((float) 0.5f, (float) 1.5F, (float) 0.5f);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		models.get(s).render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	}
}
