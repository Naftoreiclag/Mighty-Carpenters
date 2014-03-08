package naftoreiclag.mightycarpenters.things.mech;


import org.lwjgl.util.vector.Vector3f;

public abstract class Part
{
	private final PartMaterial material;
	
	private float xPos;
	private float yPos;
	private float zPos;
	
	private final float x_length;
	private final float y_length;
	private final float z_length;
	
	private final Joint darkJoint;
	private final Joint[] lightJoints;
	
	private final PartEntity entity;
	private final MechControllerEntity controller;
	
	public Part(MechControllerEntity controller, Joint joint, PartMaterial material, float x_length, float y_length, float z_length, Joint darkJoint, Joint ... lightJoints)
	{
		this.controller = controller;
		
		this.material = material;
		
		this.x_length = x_length;
		this.y_length = y_length;
		this.z_length = z_length;
		
		this.darkJoint = darkJoint;
		this.lightJoints = lightJoints;
		
		darkJoint.connectTo(joint);
		
		this.entity = new PartEntity(controller, this);
		controller.getWorld().spawnEntityInWorld(entity);
	}
	
	public void updatePosition()
	{
		if(darkJoint != null)
		{
			Joint j = darkJoint.getPartner();
			
			if(j != null)
			{
				Part p = j.getOwner();
				
				if(p != null)
				{
					this.setPosition(xPos + j.getRelativeLocation().x, yPos + j.getRelativeLocation().y, zPos + j.getRelativeLocation().z);
				}
			}
		}
	}
	
	public void setPosition(float x, float y, float z)
	{
		this.xPos = x;
		this.yPos = y;
		this.zPos = z;
		
		updateEntityPosition();
		
		updateChildrenPositions();
	}
	
	public void updateChildrenPositions()
	{
		
	}
	
	public void updateEntityPosition()
	{
		entity.setPosition(xPos, yPos, zPos);
	}
	
	public Joint getDarkJoint()
	{
		return darkJoint;
	}
	
	public Joint[] getLightJoints()
	{
		return lightJoints;
	}
	
	public abstract void renderModel();
	
	public void render(PartEntity entity)
	{
		
	}
}
