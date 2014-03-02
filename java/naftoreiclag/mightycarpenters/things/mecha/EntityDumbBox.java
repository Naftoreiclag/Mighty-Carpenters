package naftoreiclag.mightycarpenters.things.mecha;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityDumbBox extends Entity
{
	public EntityDumbBox(World world)
	{
		super(world);
		
		
	}
	
	@Override
	public boolean canBeCollidedWith()
    {
        return false;
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
