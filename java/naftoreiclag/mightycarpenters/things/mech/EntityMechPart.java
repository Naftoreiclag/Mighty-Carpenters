package naftoreiclag.mightycarpenters.things.mech;

import net.minecraft.entity.Entity;
import net.minecraft.entity.IEntityMultiPart;
import net.minecraft.entity.boss.EntityDragonPart;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityMechPart extends Entity
{
	private EntityMechCore root;
	
	public EntityMechPart(World world)
	{
		super(world);
		
		this.noClip = true;

		System.out.println("WHAT");
		
		this.kill();
	}
	
	public EntityMechPart(EntityMechCore root)
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
