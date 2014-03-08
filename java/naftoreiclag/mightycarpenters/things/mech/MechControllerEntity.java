package naftoreiclag.mightycarpenters.things.mech;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.util.vector.Vector3f;

import net.minecraft.entity.Entity;
import net.minecraft.entity.IEntityMultiPart;
import net.minecraft.entity.boss.EntityDragonPart;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class MechControllerEntity extends Entity
{
	List<Part> parts = new ArrayList<Part>();
	
	Part_Root part_root;
	
	public MechControllerEntity(World world)
	{
		super(world);
		
		this.noClip = true;
		
		this.part_root = new Part_Root(this);
		new Part_Core(this, part_root.getLightJoints()[0]);
	}
	
	protected World getWorld()
	{
		return worldObj;
	}
	
	@Override
	public void onEntityUpdate()
    {
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
