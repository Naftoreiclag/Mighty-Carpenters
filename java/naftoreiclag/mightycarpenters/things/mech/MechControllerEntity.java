package naftoreiclag.mightycarpenters.things.mech;

import org.lwjgl.util.vector.Vector3f;

import net.minecraft.entity.Entity;
import net.minecraft.entity.IEntityMultiPart;
import net.minecraft.entity.boss.EntityDragonPart;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class MechControllerEntity extends Entity
{
	PartEntity[] parts;
	
	PartEntity partA;
	
	Part_Root rootPart;
	
	public MechControllerEntity(World world)
	{
		super(world);
		
		this.rootPart = new Part_Root();
		
		this.noClip = true;
		
		//parts = new PartEntity[]{partA = new PartEntity(this, new Part_Core(rootJoint))};
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
		// Don't use this method it's evil
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
