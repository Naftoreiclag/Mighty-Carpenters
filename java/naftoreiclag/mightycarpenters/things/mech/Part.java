package naftoreiclag.mightycarpenters.things.mech;


import org.lwjgl.util.vector.Vector3f;

public abstract class Part
{
	private final PartMaterial material;
	
	protected float xPos;
	protected float yPos;
	protected float zPos;
	
	protected final float x_length;
	protected final float y_length;
	protected final float z_length;
	
	protected final Joint darkJoint;
	protected final Joint[] lightJoints;
	protected final Collision[] collisions;
	
	private final PartEntity entity;
	
	protected final MechControllerEntity controller;
	
	public Part
	(
			MechControllerEntity controller, 
			Joint joint, PartMaterial material, 
			float x_length, float y_length, float z_length, 
			Joint darkJoint, 
			Joint[] lightJoints,
			Collision[] collisions
	)
	{
		// Remember our controller
		this.controller = controller;
		
		// Material
		this.material = material;
		
		// Length?
		this.x_length = x_length;
		this.y_length = y_length;
		this.z_length = z_length;
		
		// Setup dark joint
		this.darkJoint = darkJoint;
		darkJoint.owner = this;
		
		// Setup light joints
		this.lightJoints = lightJoints;
		for(Joint j : lightJoints)
		{
			j.owner = this;
		}
		
		// Setup collisions
		this.collisions = collisions;
		for(Collision c : collisions)
		{
			c.owner = this;
			c.createEntity();
		}
		
		// Connect self to the given joint
		darkJoint.connectTo(joint);
		
		// Make entity
		this.entity = new PartEntity(controller, this);
		controller.getWorld().spawnEntityInWorld(entity);
	}
	
	public void setPosition(float x, float y, float z)
	{
		// Set own position
		this.xPos = x;
		this.yPos = y;
		this.zPos = z;
		
		// Update entity position
		entity.setPosition(xPos, yPos, zPos);
		
		// Update collision positions
		for(Collision c : collisions)
		{
			Vector3f.add(c.absPos, this.absPos, c.absPos);
		}
		
		// Update joint positions
		for(Joint j : lightJoints)
		{
			
		}
	}
	
	public abstract void renderModel();
}
