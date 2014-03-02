package naftoreiclag.mightycarpenters.things.multipart;

import net.minecraft.entity.Entity;
import net.minecraft.entity.IEntityMultiPart;
import net.minecraft.entity.boss.EntityDragonPart;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityArbolPart extends Entity
{
	private EntityArbolRoot root;
	
	public EntityArbolPart(World world)
	{
		super(world);
		
		this.kill();
	}
	
	public EntityArbolPart(EntityArbolRoot root)
	{
		super(root.getWorld());
		
		this.root = root;
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
