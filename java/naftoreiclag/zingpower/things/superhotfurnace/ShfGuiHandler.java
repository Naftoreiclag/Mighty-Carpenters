package naftoreiclag.zingpower.things.superhotfurnace;

import naftoreiclag.zingpower.ZingpowerMod;
import naftoreiclag.zingpower.util.MyStaticStrings;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class ShfGuiHandler implements IGuiHandler
{
	public ShfGuiHandler()
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(ZingpowerMod.instance, this);
	}
	
	/**
     * Returns a Server side Container to be displayed to the user.
     *
     * @param ID The Gui ID Number
     * @param player The player viewing the Gui
     * @param world The current world
     * @param x X Position
     * @param y Y Position
     * @param z Z Position
     * @return A GuiScreen/Container to be displayed to the user, null if none.
     */
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if(entity == null)
		{
			return null;
		}
		
		switch(ID)
		{
			case MyStaticStrings.GUIID_SHF:
			{
				if(entity instanceof ShfTentity)
				{
					return new ShfContainer(player.inventory, (ShfTentity) entity);
				}
			}
		}
		
		return null;
	}
	
	/**
     * Returns a Container to be displayed to the user. On the client side, this
     * needs to return a instance of GuiScreen On the server side, this needs to
     * return a instance of Container
     *
     * @param ID The Gui ID Number
     * @param player The player viewing the Gui
     * @param world The current world
     * @param x X Position
     * @param y Y Position
     * @param z Z Position
     * @return A GuiScreen/Container to be displayed to the user, null if none.
     */

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if(entity == null)
		{
			return null;
		}
		
		switch(id)
		{
		case MyStaticStrings.GUIID_SHF:
		{
			if(entity instanceof ShfTentity)
			{
				return new ShfGui(player.inventory, (ShfTentity) entity);
			}
		}
		}
		
		return null;
	}

}
