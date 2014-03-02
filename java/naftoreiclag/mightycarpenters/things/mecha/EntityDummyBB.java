package naftoreiclag.mightycarpenters.things.mecha;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityDummyBB extends Entity
{
	public AxisAlignedBB bounds;
	
	public EntityDummyBB(World par1World)
	{
		super(par1World);
		
		this.setSize(0.0f, 0.0f);
		
        this.preventEntitySpawning = true;
	}

	// Sets the bounds to be somewhere in space.
	// n1 is smaller than n2
	public void setBounds(double x1, double y1, double z1, double x2, double y2, double z2)
	{
		// Make the bounds, obviously
		bounds = AxisAlignedBB.getBoundingBox(x1, y1, z1, x2, y2, z2);
		
		// Try keep Minecraft's dumb prismic BB system in sync
		this.setSize((float) (x2 - x1 < z2 - z1 ? x2 - x1 : z2 - z1), (float) (y2 - y1));
		this.setPosition((x1 + x2) / 2, y1, (z1 + z2) / 2);
	}
	
	@Override
	public boolean canBeCollidedWith()
    {
        return !this.isDead;
    }
	
	@Override
    public AxisAlignedBB getCollisionBox(Entity entity)
    {
        return entity.getBoundingBox();
    }

	@Override
    public AxisAlignedBB getBoundingBox()
    {
        return bounds;
    }

	@Override
	protected void entityInit()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound var1)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound var1)
	{
		// TODO Auto-generated method stub
		
	}
}
