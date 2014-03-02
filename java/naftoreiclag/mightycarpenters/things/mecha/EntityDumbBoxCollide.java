package naftoreiclag.mightycarpenters.things.mecha;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityDumbBoxCollide extends Entity
{
	public EntityDumbBoxCollide(World world)
	{
		super(world);
		
		this.setSize(1.0f, 1.0f);
	}
	
	@Override
	public boolean canBeCollidedWith()
    {
        return true;
    }

	@Override
	protected void entityInit()
	{
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound var1)
	{
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound var1)
	{
	}

}
