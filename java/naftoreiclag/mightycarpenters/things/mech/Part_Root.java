package naftoreiclag.mightycarpenters.things.mech;

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
				new Joint(null, JointColor.invisible, JointShade.dark, 0.5f, 0.5f, 0.5f, new Vector3f(0.0f, 1.0f, 0.0f)),
				new Joint(null, JointColor.invisible, JointShade.light, 0.5f, 0.5f, 0.5f, new Vector3f(0.0f, 1.0f, 0.0f))
		);
	}

	@Override
	public void renderModel()
	{
		
	}
}
