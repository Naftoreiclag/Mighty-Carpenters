package naftoreiclag.mightycarpenters.things.superhotfurnace;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

import net.minecraft.item.crafting.FurnaceRecipes;

public class ShfTentity extends TileEntity implements ISidedInventory
{
	private ItemStack[] slots = new ItemStack[3];
	
	public static final int[] slots_top = new int[]{0};
	public static final int[] slots_bottom = new int[]{2};
	public static final int[] slots_side = new int[]{};
	
	public int furnaceSpeed = 100;
	public int burnTime;
	public int currentItemBurnTime;
	
	public int cookTime;
	
	public int getSizeInventory()
	{
		return this.slots.length;
	}
	
	@Override
	public void updateEntity()
	{
		boolean flag = this.burnTime > 0;
		boolean flag1;
		
		if(this.burnTime > 0)
		{
			this.burnTime --;
		}
		
		// If client
		if(this.worldObj.isRemote)
		{
			if(this.burnTime == 0 && this.canSmelt())
			{
				this.currentItemBurnTime = this.burnTime = getItemBurnTime(this.slots[1]);
			
				if(this.burnTime > 0)
				{
					flag1 = true;
					
					if(this.slots[1] != null)
					{
						this.slots[1].stackSize--;
						
						if(this.slots[1].stackSize == 0)
						{
							this.slots[1] = this.slots[1].getItem().getContainerItem(this.slots[1]);
						}
					}
				}
			}
			
			if(this.isBurning() && this.canSmelt())
			{
				this.cookTime ++;
				
				if(this.cookTime == this.furnaceSpeed)
				{
					this.cookTime = 0;
					this.smeltItem();
					flag1 = true;
				}
			}
			else
			{
				this.cookTime = 0;
			}
			
			if(flag != this.burnTime > 0)
			{
				//watwatwat
			}
		}
	}

	private void smeltItem()
	{
		// TODO Auto-generated method stub
		
	}

	private boolean isBurning()
	{
		// TODO Auto-generated method stub
		return false;
	}

	private boolean canSmelt()
	{
		if(this.slots[0] == null)
		{
			return false;
		}
		else
		{
			ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(slots[0]);
			
			return itemstack != null;
		}
	}

	@Override
	public ItemStack getStackInSlot(int var1)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack decrStackSize(int var1, int var2)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int var1)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInventorySlotContents(int var1, ItemStack var2)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getInventoryName()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasCustomInventoryName()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getInventoryStackLimit()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer var1)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void openInventory()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeInventory()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack item)
	{
		if(slot == 1)
		{
			return isItemFuel(item);
		}
		else if(slot == 2)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	private boolean isItemFuel(ItemStack item)
	{
		return getItemBurnTime(item) > 0;
	}

	private int getItemBurnTime(ItemStack item)
	{
		if(item == null)
		{
			return 0;
		}
		else
		{
			return 200;//GameRegistry.getFuelValue(item);
		}
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int side)
	{
		return side == 0 ? slots_bottom : (side == 1 ? slots_top : slots_side);
	}

	@Override
	public boolean canInsertItem(int slot, ItemStack itemstack, int side)
	{
		return this.isItemValidForSlot(slot, itemstack);
	}

	@Override
	public boolean canExtractItem(int slot, ItemStack itemstack, int side)
	{
		return slot == 2;
	}
}
