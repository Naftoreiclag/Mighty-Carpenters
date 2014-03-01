package naftoreiclag.mightycarpenters.things.engineerhandtools;

import net.minecraft.item.Item;

public class EHTRegistry
{
	public static boolean isEHT(Item questionable)
	{
		return questionable instanceof EHTItem;
	}
	
	public static EHTTier getTier(EHTItem eht)
	{
		return eht.tier;
	}
	
	public static EHTType getType(EHTItem eht)
	{
		return eht.type;
	}
}
