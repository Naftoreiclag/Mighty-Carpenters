package naftoreiclag.mightycarpenters.things.mecha;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityMecha extends Entity
{
	private EntityCreeper potato;
	
	boolean stuffCreated;
	
	public EntityMecha(World world)
	{
		super(world);
        this.preventEntitySpawning = true;
        
        stuffCreated = false;
		
		System.out.println("Constructor called!");
	}
	
	/*
	public EntityMecha setPos(int x, int y, int z)
	{
        this.posX = x;
        this.posY = y;
        this.posZ = z;
        
        syncBounds();
        
		return this;
	}
	*/
	
	/**
     * Sets the x,y,z of the entity from the given parameters. Also seems to set up a bounding box.
     */
	@Override
    public void setPosition(double x, double y, double z)
    {
        super.setPosition(x, y, z);

		//System.out.println("Position called!");
		
		if(potato != null)//stuffCreated)
		{
			syncBounds();
		}
    }
    
    private void createStuff()
    {
        potato = new EntityCreeper(worldObj);//new EntityDummyBB(worldObj);
        syncBounds();
        //System.out.println("Potato created at " + posX + ", " + posY + ", " + posZ);
        
        worldObj.spawnEntityInWorld(potato);
        
        stuffCreated = true;
        
    }
	
	private void syncBounds()
	{
		//potato.setBounds(posX, posY, posZ, posX + 1, posY + 1, posZ + 1);
		potato.setPosition(posX, posY, posZ);
        //System.out.println("Moved to:" + posX + ", " + posY + ", " + posZ);
	}

	@Override
	public void entityInit()
	{
		System.out.println("Entity init called!");
		
		createStuff();
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
