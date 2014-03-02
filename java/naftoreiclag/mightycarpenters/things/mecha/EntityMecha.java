package naftoreiclag.mightycarpenters.things.mecha;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityMecha extends Entity
{
	private final EntityDummyBB potato;
	
	public EntityMecha(World world)
	{
		super(world);
		
		this.setSize(1.0f, 1.0f);
		
        this.preventEntitySpawning = true;
        
        potato = new EntityDummyBB(world);
        
        world.spawnEntityInWorld(potato);
	}
	
	public EntityMecha setPos(int x, int y, int z)
	{
        this.posX = x;
        this.posY = y;
        this.posZ = z;
        
        syncBounds();
        
		return this;
	}
	
	private void syncBounds()
	{
		potato.setBounds(posX, posY, posZ, posX + 1, posY + 1, posZ + 1);
	}
	
	@Override
	public boolean canBeCollidedWith()
    {
        return !this.isDead;
    }
	
	@Override
	public void onUpdate()
    {
		
    }

	@SideOnly(Side.CLIENT)
    public float getShadowSize()
    {
        return 0.0f;
    }
	
	/**
     * Returns a boundingBox used to collide the entity with other entities and blocks. This enables the entity to be
     * pushable on contact, like boats or minecarts.
     */
	@Override
    public AxisAlignedBB getCollisionBox(Entity par1Entity)
    {
        return par1Entity.boundingBox;
    }

    /**
     * returns the bounding box for this entity
     */
	@Override
    public AxisAlignedBB getBoundingBox()
    {
        return this.boundingBox;
    }

	@Override
	public void entityInit()
	{
		
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound savefile)
	{
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound savefile)
	{
	}
}
