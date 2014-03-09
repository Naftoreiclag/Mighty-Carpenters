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
				new Joint(null, JointColor.invisible, JointShade.dark, 0.5f, 0.5f, 0.5f, new Vector3f(0.0f, 1.0f, 0.0f)),
				new Joint(null, JointColor.blue, JointShade.light, 0.5f, 0.5f, 0.5f, new Vector3f(0.0f, 1.0f, 0.0f))
		);
	}

	@Override
	public void renderModel()
	{
		ModelLoader.render("foop");
	}
}
