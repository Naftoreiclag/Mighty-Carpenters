package naftoreiclag.mightycarpenters.things.mech.models;

import naftoreiclag.mightycarpenters.things.mech.Joint;
import naftoreiclag.mightycarpenters.things.mech.JointColor;
import naftoreiclag.mightycarpenters.things.mech.JointShade;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class JointModel extends ModelBase
{
	ModelRenderer shape;

	public JointModel()
	{
		textureWidth = 64;
		textureHeight = 128;

		shape = new ModelRenderer(this, 0, 0);
		shape.addBox(-4F, -4F, -4F, 8, 8, 8);
		shape.setRotationPoint(0F, 0F, 0F);
		shape.setTextureSize(textureWidth, textureHeight);
		shape.mirror = true;
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
	
	public void easyRender(Joint j)
	{
		if(j.getColor() == JointColor.invisible)
		{
			return;
		}
		
		shape.setTextureOffset(getIntegerFromShade(j.getShade()) * 32, getIntegerFromColor(j.getColor()) * 16);
		render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		
		shape.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}

}
