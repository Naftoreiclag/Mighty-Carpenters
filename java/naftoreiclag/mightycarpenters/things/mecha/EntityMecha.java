package naftoreiclag.mightycarpenters.things.mecha;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityMecha extends Entity
{
	private EntityDummyBB potato;
	private AxisAlignedBB emptyBB;
	
	public EntityMecha(World world)
	{
		super(world);
		
		System.out.println("Constructor called!");
		
        this.preventEntitySpawning = true;
        
        emptyBB = AxisAlignedBB.getBoundingBox(0, 0, 0, 0, 0, 0);
        
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
	public void entityInit()
	{
		System.out.println("Entity init called!");
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
