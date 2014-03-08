package naftoreiclag.mightycarpenters.things.mech.partdefinitions;

import naftoreiclag.mightycarpenters.things.mech.EntityMechPart;

import org.lwjgl.util.vector.Vector3f;

public abstract class MechPartDefinition
{
	private final MechPartMaterial material;
	
	private final float x_length;
	private final float y_length;
	private final float z_length;
	
	private final MechJoint darkJoint;
	private final MechJoint[] lightJoint;
	
	public MechPartDefinition(MechPartMaterial material, float x_length, float y_length, float z_length, MechJoint darkJoint, MechJoint ... lightJoints)
	{
		this.material = material;
		
		this.x_length = x_length;
		this.y_length = y_length;
		this.z_length = z_length;
		
		this.darkJoint = darkJoint;
		this.lightJoint = lightJoints;
	}
	
	public abstract void renderModel();
	
	public void render(EntityMechPart entity)
	{
		
	}
}
