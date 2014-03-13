package naftoreiclag.mightycarpenters.things.mech;

import org.lwjgl.util.vector.Vector3f;

public abstract class PartPoint
{
	protected final Vector3f absPos;
	protected final Vector3f relPos;
	
	protected Part owner;
	
	protected PartPoint(Vector3f relPos)
	{
		this.relPos = relPos;
		this.absPos = new Vector3f(0.0f, 0.0f, 0.0f);
	}
}
