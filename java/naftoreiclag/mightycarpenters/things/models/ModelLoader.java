package naftoreiclag.mightycarpenters.things.models;

import java.util.HashMap;
import java.util.Map;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class ModelLoader
{
	public static Map<String, LoadedModel> loadedModels = new HashMap<String, LoadedModel>();
	
	public static void addModelAndTexture(String s, ModelBase model, ResourceLocation texture)
	{
		loadedModels.put(s, new LoadedModel(model, texture));
	}
	
	public static void render(String s)
	{
		Minecraft.getMinecraft().renderEngine.bindTexture(loadedModels.get(s).resource);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		loadedModels.get(s).model.render(null, 0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f);
	}
	
	public static class LoadedModel
	{
		public final ResourceLocation resource;
		public final ModelBase model;
		
		public LoadedModel(ModelBase modelInstance, ResourceLocation resLoc)
		{
			this.resource = resLoc;
			this.model = modelInstance;
		}
	}
}
