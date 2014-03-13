package naftoreiclag.mightycarpenters.things.mech;

import naftoreiclag.mightycarpenters.things.models.ModelLoader;

import org.lwjgl.util.vector.Vector3f;

public class Part_Root extends Part
{
	public Part_Root(MechControllerEntity controller)
	{
		super
		(
				controller,
				null,
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
	
	private float test(Part_Root te)
	{
		return 1.0f;
	}

	@Override
	public void renderModel()
	{
		ModelLoader.render("foop");
	}
}
