package naftoreiclag.zingpower.things.nailgun;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityFlyingNail extends EntityThrowable
{
	public EntityFlyingNail(World par1)
	{
		super(par1);
	}

	public EntityFlyingNail(World par1, EntityLivingBase player)
	{
		super(par1, player);
	}

	public EntityFlyingNail(World par1, double par2, double par4, double par6)
	{
		super(par1, par2, par4, par6);
	}

	@Override
	protected float getGravityVelocity()
	{
		return 0.001F;
	}

	@Override
	protected void onImpact(MovingObjectPosition movingobjectposition)
	{
		this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 5.0f, true);
		this.setDead();
	}
}