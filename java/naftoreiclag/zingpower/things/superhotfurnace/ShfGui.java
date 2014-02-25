package naftoreiclag.zingpower.things.superhotfurnace;

import naftoreiclag.zingpower.util.MyStaticStrings;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class ShfGui extends GuiContainer
{
	public static final ResourceLocation texture = new ResourceLocation(MyStaticStrings.MOD_ID + "textures/gui/shf_gui.png");
	
	public ShfTentity entity;
	
	public ShfGui(InventoryPlayer inventoryPlayer, ShfTentity entity)
	{
		super(null);//new ShfContainer(inventoryPlayer, entity));
		
		this.entity = entity;
		
		this.xSize = 176;
		this.ySize = 166;
	}
	
	@Override
	public void drawGuiContainerForegroundLayer(int var2, int var3)
	{
		this.fontRendererObj.drawString("aaaaa", 5, 5, 5050505);
	}

	@Override
	public void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
	{
		// TODO Auto-generated method stub
		
	}

}
