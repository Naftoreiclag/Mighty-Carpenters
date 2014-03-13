package naftoreiclag.mightycarpenters.things.mech;

import org.lwjgl.util.vector.Vector3f;

public class Collision extends PartPoint
{
	private CollisionEntity entity;
	
	public Collision(Vector3f relativePosition)
	{
		super(relativePosition);
	}
	
	protected void setAbsolutePos(float x, float y, float z)
	{
		absPos.set(x, y, z);
	}
	
	private void updateEntityPos()
	{
		entity.setPosition(absPos.x, absPos.y, absPos.z);
	}
	
	protected void createEntity()
	{
		entity = new CollisionEntity(owner.controller, this);
		owner.controller.getWorld().spawnEntityInWorld(entity);
	}
}
