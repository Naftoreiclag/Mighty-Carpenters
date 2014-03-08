package naftoreiclag.mightycarpenters.things.mech;

import org.lwjgl.util.vector.Vector3f;


public class Joint
{
	private final JointColor color;
	private final JointShade shade;
	
	private final Vector3f dir;
	private final Vector3f loc;

	private final Part owner;
	
	private Joint partner;
	
	public Joint(Part owner, JointColor color, JointShade shade, Vector3f direction, Vector3f relativeLocation)
	{
		this.owner = owner;
		
		this.color = color;
		this.shade = shade;
		
		this.dir = direction;
		this.loc = relativeLocation;
	}
	
	public Joint(Part owner, JointColor color, JointShade shade, float x, float y, float z, Vector3f relativeLocation)
	{
		this(owner, color, shade, new Vector3f(x, y, z), relativeLocation);
	}
	
	public JointColor getColor()
	{
		return color;
	}
	
	public JointShade getShade()
	{
		return shade;
	}
	
	public Vector3f getDir()
	{
		return dir;
	}
	
	public Vector3f getLoc()
	{
		return loc;
	}
	
	public Joint getPartner()
	{
		return partner;
	}
	
	public Part getOwner()
	{
		return owner;
	}
	
	public Vector3f getRelativeLocation()
	{
		return loc;
	}
	
	public boolean isCompatable(Joint other)
	{
		if(other.getColor() == color)
		{
			switch(shade)
			{
				case dark:
				{
					if(other.getShade() == JointShade.light)
					{
						return true;
					}
					break;
				}
				case light:
				{
					if(other.getShade() == JointShade.dark)
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
	}
}
