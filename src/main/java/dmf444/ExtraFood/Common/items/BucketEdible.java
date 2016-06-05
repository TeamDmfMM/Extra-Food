package dmf444.ExtraFood.Common.items;

import dmf444.ExtraFood.Common.fluids.GeneralFluid;
import dmf444.ExtraFood.Core.util.FluidContainerRegistryHelper;
import dmf444.ExtraFood.Core.util.Tabs.EFTabs;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidContainerItem;

import java.util.ArrayList;

public class BucketEdible extends ItemBucket implements IFluidContainerItem{
	
	private int FoodStat;
	private float SaturationLvl;
	private Block containedBlock;

	
	public BucketEdible(int foodBar, float saturation, Block fluidBlock, String localName){
		super(fluidBlock);
		this.setCreativeTab(EFTabs.INSTANCE);
        this.setUnlocalizedName(localName);

		this.FoodStat = foodBar;
		this.SaturationLvl = saturation;
		this.containedBlock = fluidBlock;
		try {
			FluidContainerRegistryHelper.specialCases.get(Items.BUCKET).add(this);
		} catch (NullPointerException e) {
			FluidContainerRegistryHelper.specialCases.put(Items.BUCKET, new ArrayList<IFluidContainerItem>());
			FluidContainerRegistryHelper.specialCases.get(Items.BUCKET).add(this);
		}
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World world, EntityLivingBase entityLiving)
	{
		--stack.stackSize;

		if (entityLiving instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)entityLiving;
			player.getFoodStats().addStats(FoodStat, SaturationLvl);
			world.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
			if (!world.isRemote) {
				player.addChatComponentMessage(new TextComponentString("That tasted good!"));
			}
		}

		return stack.stackSize <= 0 ? new ItemStack(Items.BUCKET) : stack;

	}
	@Override
    public int getMaxItemUseDuration(ItemStack p_77626_1_)
    {
        return 32;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
	@Override
    public EnumAction getItemUseAction(ItemStack p_77661_1_)
    {
        return EnumAction.DRINK;
    }
	
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStack, World world, EntityPlayer player, EnumHand hand){
		ItemStack t = super.onItemRightClick(itemStack, world, player, hand).getResult();
		if (t.getItem() == this){
			player.setActiveHand(hand);
			return new ActionResult<>(EnumActionResult.SUCCESS, itemStack);
		}
		else {
			return new ActionResult<>(EnumActionResult.FAIL, t);
		}
	}

	//THIS MAY NOT BE PROPER IMPLEMENTATION OF IFLUIDCONTAINER. RECHECK LATER.
	// It wasn't. (tehe dmfderp)
	@Override
	public FluidStack getFluid(ItemStack container) {
		if(containedBlock instanceof GeneralFluid) {
			return new FluidStack(((GeneralFluid)containedBlock).getFluid(), 1000);
		}else{
			return new FluidStack(FluidRegistry.WATER, 1000);
		}
	}

	@Override
	public int getCapacity(ItemStack container) {
		return 1000;
	}

	@Override
	public int fill(ItemStack container, FluidStack resource, boolean doFill) {
		if (container.getItem() == Items.BUCKET) {
			if (containedBlock instanceof GeneralFluid) {
				if (resource.getFluid() == ((GeneralFluid) containedBlock).getFluid()) {
					if (doFill) {
						container.setItem(this);
						return 1000;
					}
					else {
						return 1000;
					}
				}
			}
		}
		return 0;
	}

	@Override
	public FluidStack drain(ItemStack container, int maxDrain, boolean doDrain) {
		if (container.getItem() == this) {
			if (maxDrain > 999) {
				if (doDrain) {
					container.setItem(Items.BUCKET);
					return new FluidStack(((GeneralFluid)(this.containedBlock)).getFluid(), 1000);
				}
				else {
					return new FluidStack(((GeneralFluid)(this.containedBlock)).getFluid(), 1000);
				}
			}
		}
		return null;
	}
}
