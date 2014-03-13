package naftoreiclag.mightycarpenters.things.mech;

import org.lwjgl.util.vector.Vector3f;

public class Joint extends PartPoint
{
	protected final JointColor color;
	protected final JointShade shade;
	
	protected final Vector3f dir;
	
	protected Joint partner;
	
	public Joint(Vector3f relativePosition, JointColor color, JointShade shade, Vector3f direction)
	{
		super(relativePosition);
		
		this.color = color;
		this.shade = shade;
		
		this.dir = direction;
	}
	
	public Vector3f getRelativeLocation()
	{
		return relPos;
	}
	
	public boolean isCompatable(Joint other)
	{
		if(other.color == color)
		{
			switch(shade)
			{
				case dark:
				{
					if(other.shade == JointShade.light)
					{
						return true;
					}
					break;
				}
				case light:
				{
					if(other.shade == JointShade.dark)
					{
						return true;
					}
					break;
				}
			}
		}
		
		return false;
	}

	public void connectTo(Joint joint)
	{
		partner = joint;
		joint.partner = this;
	}
}
