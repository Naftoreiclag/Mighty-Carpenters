package naftoreiclag.mightycarpenters.things.mecha;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMechCore extends ModelBase
{
	// fields
	ModelRenderer top1;
	ModelRenderer top2;
	ModelRenderer top3;
	ModelRenderer top4;
	ModelRenderer bot1;
	ModelRenderer bot2;
	ModelRenderer bot3;
	ModelRenderer bot4;
	ModelRenderer mid;

	public ModelMechCore()
	{
		textureWidth = 64;
		textureHeight = 32;

		top1 = new ModelRenderer(this, 0, 0);
		top1.addBox(0F, 0F, 0F, 6, 6, 6);
		top1.setRotationPoint(2F, 8F, 2F);
		top1.setTextureSize(64, 32);
		top1.mirror = true;
		setRotation(top1, 0F, 0F, 0F);
		top2 = new ModelRenderer(this, 0, 0);
		top2.addBox(0F, 0F, 0F, 6, 6, 6);
		top2.setRotationPoint(-8F, 8F, 2F);
		top2.setTextureSize(64, 32);
		top2.mirror = true;
		setRotation(top2, 0F, 0F, 0F);
		top3 = new ModelRenderer(this, 0, 0);
		top3.addBox(0F, 0F, 0F, 6, 6, 6);
		top3.setRotationPoint(-8F, 8F, -8F);
		top3.setTextureSize(64, 32);
		top3.mirror = true;
		setRotation(top3, 0F, 0F, 0F);
		top4 = new ModelRenderer(this, 0, 0);
		top4.addBox(0F, 0F, 0F, 6, 6, 6);
		top4.setRotationPoint(2F, 8F, -8F);
		top4.setTextureSize(64, 32);
		top4.mirror = true;
		setRotation(top4, 0F, 0F, 0F);
		bot1 = new ModelRenderer(this, 0, 12);
		bot1.addBox(0F, 0F, 0F, 6, 6, 6);
		bot1.setRotationPoint(2F, 18F, 2F);
		bot1.setTextureSize(64, 32);
		bot1.mirror = true;
		setRotation(bot1, 0F, 0F, 0F);
		bot2 = new ModelRenderer(this, 0, 12);
		bot2.addBox(0F, 0F, 0F, 6, 6, 6);
		bot2.setRotationPoint(-8F, 18F, 2F);
		bot2.setTextureSize(64, 32);
		bot2.mirror = true;
		setRotation(bot2, 0F, 0F, 0F);
		bot3 = new ModelRenderer(this, 0, 12);
		bot3.addBox(0F, 0F, 0F, 6, 6, 6);
		bot3.setRotationPoint(-8F, 18F, -8F);
		bot3.setTextureSize(64, 32);
		bot3.mirror = true;
		setRotation(bot3, 0F, 0F, 0F);
		bot4 = new ModelRenderer(this, 0, 12);
		bot4.addBox(0F, 0F, 0F, 6, 6, 6);
		bot4.setRotationPoint(2F, 18F, -8F);
		bot4.setTextureSize(64, 32);
		bot4.mirror = true;
		setRotation(bot4, 0F, 0F, 0F);
		mid = new ModelRenderer(this, 24, 0);
		mid.addBox(0F, 0F, 0F, 6, 6, 6);
		mid.setRotationPoint(-3F, 13F, -3F);
		mid.setTextureSize(64, 32);
		mid.mirror = true;
		setRotation(mid, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		top1.render(f5);
		top2.render(f5);
		top3.render(f5);
		top4.render(f5);
		bot1.render(f5);
		bot2.render(f5);
		bot3.render(f5);
		bot4.render(f5);
		mid.render(f5);
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
