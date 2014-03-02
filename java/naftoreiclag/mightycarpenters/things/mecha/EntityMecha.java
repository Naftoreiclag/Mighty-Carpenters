package naftoreiclag.mightycarpenters.things.mecha;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityMecha extends Entity
{
	private EntityDummyBB potato;
	
	public EntityMecha(World world)
	{
		super(world);
        this.preventEntitySpawning = true;
		
		System.out.println("Constructor called!");
	}
	
	@Override
    public void setPosition(double x, double y, double z)
    {
        super.setPosition(x, y, z);
        
        if(potato == null)
        {
        	System.out.println("Created without first making potato!");
        }
        else
        {
    		potato.setPosition(posX, posY, posZ);
        }
    }

	@Override
	public void entityInit()
	{
		System.out.println("Entity init called!");
		
		if(worldObj.isRemote) { return; }
		
		potato = new EntityDummyBB(worldObj);
		potato.setPosition(posX, posY, posZ);
		worldObj.spawnEntityInWorld(potato);
	}
	
	@Override
	public void onUpdate()
    {
    }

	@Override
	public void readEntityFromNBT(NBTTagCompound savefile)
	{
		System.out.println("Read called!");
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound savefile)
	{
		System.out.println("Write called!");
	}
	
	@Override
	public boolean canBeCollidedWith()
    {
        return false;
    }

	@SideOnly(Side.CLIENT)
    public float getShadowSize()
    {
        return 0.0f;
    }
}
