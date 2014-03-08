package naftoreiclag.mightycarpenters.things.mech.partdefinitions;

import org.lwjgl.util.vector.Vector3f;

public class MPD_Core extends MechPartDefinition
{
	public MPD_Core()
	{
		super
		(
				MechPartMaterial.metal,
				1.0f,
				1.0f,
				1.0f,
				new MechJoint(MechJointColor.invisible, 0.5f, 0.5f, 0.5f, new Vector3f(0.0f, 1.0f, 0.0f)),
				new MechJoint(MechJointColor.blue, 0.5f, 0.5f, 0.5f, new Vector3f(0.0f, 1.0f, 0.0f))
		);
	}

	@Override
	public void renderModel()
	{
		
	}
}
