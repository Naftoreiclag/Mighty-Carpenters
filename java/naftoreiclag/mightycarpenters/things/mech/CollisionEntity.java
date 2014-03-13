package naftoreiclag.mightycarpenters.things.mech;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class CollisionEntity extends Entity
{
	protected MechControllerEntity controller;
	protected Collision collision;
	
	// This is if it is constructed incorrectly
	public CollisionEntity(World world)
	{
		super(world);
		System.out.println("WHAT");
		this.kill();
	}
	
	// Correct constructor
	public CollisionEntity(MechControllerEntity controller, Collision collision)
	{
		super(controller.getWorld());
		
		this.setSize(1.0f, 1.0f);
		
		this.controller = controller;
		this.collision = collision;
	}
	
	@Override
	public void setPosition(double x, double y, double z)
    {
        super.setPosition(x, y - (((double) this.ySize) * 0.5d), z);
    }

	@Override
	public void entityInit()
	{
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound var1)
	{
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound var1)
	{
	}
}
