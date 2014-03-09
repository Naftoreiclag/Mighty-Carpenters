package naftoreiclag.mightycarpenters.things.models;

import naftoreiclag.mightycarpenters.things.mech.Joint;
import naftoreiclag.mightycarpenters.things.mech.JointColor;
import naftoreiclag.mightycarpenters.things.mech.JointShade;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class Model_Joint extends ModelBase
{
	ModelRenderer shape;

	public Model_Joint(int color, int shade)
	{
		textureWidth = 64;
		textureHeight = 128;

		shape = new ModelRenderer(this, shade * 32, color * 16);
		shape.addBox(-4F, -4F, -4F, 8, 8, 8);
		shape.setRotationPoint(0F, 0F, 0F);
		shape.setTextureSize(textureWidth, textureHeight);
		shape.mirror = true;
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		
		shape.render(f5);
	}
}
