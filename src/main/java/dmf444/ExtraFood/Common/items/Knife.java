package dmf444.ExtraFood.Common.items;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dmf444.ExtraFood.util.EFLog;

public class Knife extends StanItem {


	
	public Knife()
	{
        super();
        this.maxStackSize = 1;
        this.setMaxDamage(10);
        this.setTextureName("extrafood:knife");
        this.setContainerItem(this);
    }

	public Item setNoRepair() {
		boolean canRepairng = false;
		return this;
	}
	
	@Override
	public boolean isRepairable() {
		return false;
	}
	
	@Override
	public ItemStack getContainerItem(ItemStack itemstack) {
		 ItemStack copiedStack = itemstack.copy();

	        copiedStack.setItemDamage(copiedStack.getItemDamage() + 1);
	        copiedStack.stackSize = 1;
	        return copiedStack;
	}

    
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemstack) 
    {
    	return false;
    }
    
    public boolean getShareTag()
    {
        return true;
    }
    @SideOnly(Side.CLIENT)

    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    public boolean isFull3D()
    {
        return true;
    }
    /*
	@Override
	public boolean itemInteractionForEntity(ItemStack itemstack, EntityPlayer player, EntityLivingBase target){
		EFLog.debug("BACON SPAWN0");
		if(!target.worldObj.isRemote){
			EFLog.debug("BACON SPAWN1");
			if(target instanceof EntityPig){
				
				ItemStack item = new ItemStack(ItemLoader.bacon, 1);
				EFLog.debug("BACON SPAWN2");
				Entity Ientity = new EntityItem(target.worldObj, target.posX, target.posY, target.posZ, item);
				target.worldObj.spawnEntityInWorld(Ientity);
				return true;
			} else if (target instanceof EntityCow){
								
			} else {
				return super.itemInteractionForEntity(itemstack, player, target);
			}
			EFLog.debug("BACON SPAWN4");
		}
		return false;
	}*/
    
	@Override
	 public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity){
		if(!entity.worldObj.isRemote){
			if(entity instanceof EntityPig){
				int PigDropA = MathHelper.getRandomIntegerInRange(itemRand, 3, 6);
				ItemStack item = new ItemStack(ItemLoader.bacon, PigDropA);
				EFLog.debug("BACON SPAWN2");
				Entity Ientity = new EntityItem(entity.worldObj, entity.posX, entity.posY, entity.posZ, item);
				entity.worldObj.spawnEntityInWorld(Ientity);
				((EntityPig) entity).setHealth(0);
				stack.damageItem(2, player);
				return false;
			} else if (entity instanceof EntityCow){
				if(((EntityCow) entity).isChild()){
					int BabyCowDropA = MathHelper.getRandomIntegerInRange(itemRand, 1, 3);
					ItemStack item = new ItemStack(ItemLoader.veal, BabyCowDropA);
					EFLog.debug("BACON SPAWN2");
					Entity Ientity = new EntityItem(entity.worldObj, entity.posX, entity.posY, entity.posZ, item);
					entity.worldObj.spawnEntityInWorld(Ientity);
					((EntityCow) entity).setHealth(0);
					stack.damageItem(2, player);
					return false;
				}
			}
		}
		return false;
	}

}

