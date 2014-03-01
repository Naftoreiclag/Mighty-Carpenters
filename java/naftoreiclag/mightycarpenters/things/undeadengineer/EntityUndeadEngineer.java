package naftoreiclag.mightycarpenters.things.undeadengineer;

import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.world.World;

public class EntityUndeadEngineer extends EntityMob
{

	public EntityUndeadEngineer(World par1World)
	{
		super(par1World);
		// TODO Auto-generated constructor stub
	}
	
	public EnumCreatureAttribute getCreatureAttribute()
	{
		return EnumCreatureAttribute.UNDEAD;
	}

}
