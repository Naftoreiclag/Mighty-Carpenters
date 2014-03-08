package naftoreiclag.mightycarpenters.things.mech;


import org.lwjgl.util.vector.Vector3f;

public abstract class Part
{
	private final PartMaterial material;
	
	private final float x_length;
	private final float y_length;
	private final float z_length;
	
	private final Joint darkJoint;
	private final Joint[] lightJoint;
	
	public Part(Joint joint, PartMaterial material, float x_length, float y_length, float z_length, Joint darkJoint, Joint ... lightJoints)
	{
		this.material = material;
		
		this.x_length = x_length;
		this.y_length = y_length;
		this.z_length = z_length;
		
		this.darkJoint = darkJoint;
		this.lightJoint = lightJoints;
		
		darkJoint.connectTo(joint);
	}
	
	public abstract void renderModel();
	
	public void render(PartEntity entity)
	{
		
	}
}
