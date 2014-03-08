package naftoreiclag.mightycarpenters.things.mech.partdefinitions;

import org.lwjgl.util.vector.Vector3f;


public class MechJoint
{
	private final MechJointColor color;
	
	private final Vector3f dir;
	private final Vector3f loc;
	
	public MechJoint(MechJointColor color, Vector3f direction, Vector3f relativeLocation)
	{
		this.color = color;
		
		this.dir = direction;
		this.loc = relativeLocation;
	}
	
	public MechJoint(MechJointColor color, float x, float y, float z, Vector3f relativeLocation)
	{
		this(color, new Vector3f(x, y, z), relativeLocation);
	}
	
	public MechJointColor getColor()
	{
		return color;
	}
	
	public Vector3f getDir()
	{
		return dir;
	}
	
	public Vector3f getLoc()
	{
		return loc;
	}
}
