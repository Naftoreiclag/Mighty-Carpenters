package naftoreiclag.mightycarpenters.things.multipart;

import net.minecraft.entity.Entity;
import net.minecraft.entity.IEntityMultiPart;
import net.minecraft.entity.boss.EntityDragonPart;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityArbolRoot extends Entity
{
	EntityArbolPart[] parts;
	
	EntityArbolPart partA;
	
	public EntityArbolRoot(World world)
	{
		super(world);
		
		System.out.println("a root");
		
		parts = new EntityArbolPart[]{partA = new EntityArbolPart(this)};
		world.spawnEntityInWorld(partA);
	}
	
	@Override
	public Entity[] getParts()
    {
		//return parts;
		
		return null;
    }
	
	protected World getWorld()
	{
		return worldObj;
	}
	
	@Override
	public void onEntityUpdate()
    {
		partA.setPosition(posX, posY + 1, posZ);
    }

	@Override
	public void entityInit()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound var1)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound var1)
	{
		// TODO Auto-generated method stub
		
	}
	
}
