package naftoreiclag.mightycarpenters.things.engineerhandtools.nailgun;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityFlyingNail extends EntityThrowable
{
	float speed = 10f;
	
	public EntityFlyingNail(World par1)
	{
		super(par1);
	}

	public EntityFlyingNail(World world, EntityLivingBase player)
	{
		super(world, player);
		
        this.setSize(0.25F, 0.25F);
        this.setLocationAndAngles(player.posX, player.posY + (double)player.getEyeHeight(), player.posZ, player.rotationYaw, player.rotationPitch);
        this.posX -= (double)(MathHelper.cos(this.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
        this.posY -= 0.10000000149011612D;
        this.posZ -= (double)(MathHelper.sin(this.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
        this.setPosition(this.posX, this.posY, this.posZ);
        this.yOffset = 0.0F;
        float f = speed;
        this.motionX = (double)(-MathHelper.sin(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI) * f);
        this.motionZ = (double)(MathHelper.cos(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI) * f);
        this.motionY = (double)(-MathHelper.sin((this.rotationPitch + this.func_70183_g()) / 180.0F * (float)Math.PI) * f);
        
        this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, this.func_70182_d(), 1.0F);
	}

	public EntityFlyingNail(World par1, double par2, double par4, double par6)
	{
		super(par1, par2, par4, par6);
	}

	@Override
	protected float getGravityVelocity()
	{
		return 0.05F;
	}

	@Override
	protected void onImpact(MovingObjectPosition movingobjectposition)
	{
		//this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 5.0f, true);
		this.setDead();
	}
}