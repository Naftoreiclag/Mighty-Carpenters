package naftoreiclag.mightycarpenters.things.mech;

import naftoreiclag.mightycarpenters.things.mech.partdefinitions.MechPartDefinition;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IEntityMultiPart;
import net.minecraft.entity.boss.EntityDragonPart;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityMechPart extends Entity
{
	private EntityMechRoot root;
	
	private MechPartDefinition part;
	
	// This is if it is constructed incorrectly
	public EntityMechPart(World world)
	{
		super(world);
		System.out.println("WHAT");
		this.kill();
	}
	
	// Correct constructor
	public EntityMechPart(EntityMechRoot root, MechPartDefinition part)
	{
		super(root.getWorld());
		
		this.noClip = true;
		
		this.root = root;
		
		this.part = part;
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
