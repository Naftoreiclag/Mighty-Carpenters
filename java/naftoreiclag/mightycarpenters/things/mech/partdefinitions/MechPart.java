package naftoreiclag.mightycarpenters.things.mech.partdefinitions;

import org.lwjgl.util.vector.Vector3f;

public abstract class MechPart
{
	private final MechJoint socket;
	private final MechJoint[] joints;
	
	public MechPart(MechJoint socket, MechJoint ... joints)
	{
		this.socket = socket;
		this.joints = joints;
	}
}
