package naftoreiclag.mightycarpenters.things.mech;

import naftoreiclag.mightycarpenters.things.models.ModelLoader;

import org.lwjgl.util.vector.Vector3f;

public class Part_Core extends Part
{
	public Part_Core(MechControllerEntity controller, Joint attachTo)
	{
		super
		(
				controller,
				attachTo,
				PartMaterial.metal,
				1.0f,
				1.0f,
				1.0f,
				new Joint(new Vector3f(0.5f, 0.5f, 0.5f), JointColor.invisible, JointShade.dark, new Vector3f(0.0f, 1.0f, 0.0f)),
				new Joint[]
				{
					new Joint(new Vector3f(0.5f, 0.5f, 0.5f), JointColor.blue, JointShade.light, new Vector3f(0.0f, 1.0f, 0.0f))
				},
				new Collision[]
				{
					new Collision(new Vector3f(0.0f, 0.0f, 0.0f))
				}
		);
	}

	@Override
	public void renderModel()
	{
		ModelLoader.render("foop");
	}
}
