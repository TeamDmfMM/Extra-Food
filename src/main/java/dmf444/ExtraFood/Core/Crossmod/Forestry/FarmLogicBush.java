package dmf444.ExtraFood.Core.Crossmod.Forestry;


import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Common.items.ItemLoader;
import forestry.api.farming.*;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.*;

public class FarmLogicBush implements IFarmLogic {

	boolean manuals;
	private final ItemStack[] resource = new ItemStack[2];
	ArrayList<ItemStack> produce = new ArrayList<ItemStack>();
	IFarmable[] germlings;
	ItemStack groundblock = new ItemStack(Blocks.DIRT);
	static HashSet<Block> breakable = new HashSet<Block>();
	
	public FarmLogicBush(){
		germlings = Farmables.farmables.get("farmBush").toArray(new IFarmable[0]);
		resource[0] = new ItemStack(BlockLoader.strawberryBush);
		resource[1] = new ItemStack(BlockLoader.peanutbush);

	}
	
	@Override
	public int getFertilizerConsumption() {
		return 50;
	}

	@Override
	public int getWaterConsumption(float hydrationModifier) {
		return (int) (hydrationModifier * 25);
	}

	@Override
	public boolean isAcceptedResource(ItemStack itemstack) {
		return itemstack.getItem() == Item.getItemFromBlock(Blocks.DIRT);
		//itemstack == new ItemStack(BlockLoader.strawberryBush) || itemstack == new ItemStack(BlockLoader.peanutbush) ||
	}

	@Override
	public boolean isAcceptedGermling(ItemStack itemstack) {
		if(itemstack.getItem() == resource[0].getItem() || itemstack.getItem() == resource[1].getItem()){
		return true;
		}else{
		return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<ItemStack> collect(World world, IFarmHousing housing) {

		Collection<ItemStack> products = produce;
		produce = new ArrayList<ItemStack>();

		AxisAlignedBB harvestBox = getHarvestBox(world, housing, false);


		List<Entity> list = world.getEntitiesWithinAABB(Entity.class, harvestBox);

		int i;
		for (i = 0; i < list.size(); i++) {
			Entity entity = list.get(i);

			if (entity instanceof EntityItem) {
				EntityItem item = (EntityItem) entity;
				if (!item.isDead) {
					ItemStack contained = item.getEntityItem();
					//EFLog.fatal(contained);
					if (isAcceptedGermling(contained)) {
						produce.add(contained.copy());
						item.setDead();
					}
				}
			}
		}

		return products;
	}

	private static AxisAlignedBB getHarvestBox(World world, IFarmHousing farmHousing, boolean toWorldHeight) {
		BlockPos coords = farmHousing.getCoords();
		Vec3i area = farmHousing.getArea();
		Vec3i offset = farmHousing.getOffset();

		BlockPos min = coords.add(offset);
		BlockPos max = min.add(area);

		int maxY = max.getY();
		if (toWorldHeight) {
			maxY = world.getHeight();
		}

		return new AxisAlignedBB(min.getX(), min.getY(), min.getZ(), max.getX(), maxY, max.getZ());
	}


	@Override
	public boolean cultivate(World world, IFarmHousing farmHousing, BlockPos pos, FarmDirection direction, int extent) {

		if (maintainSoil(world, farmHousing, pos, direction, extent))
			return true;

		if (maintainGermlings(world, farmHousing, pos, direction, extent))
			return true;

		return false;
	}

	private boolean maintainSoil(World world, IFarmHousing farmHousing, BlockPos pos, FarmDirection direction, int extent) {
		if (farmHousing.getFarmInventory().hasResources(resource))
			return false;

		for (int i = 0; i < extent; i++) {
			BlockPos position = translateWithOffset(pos, direction, i);
			
			ItemStack stack = new ItemStack(world.getBlockState(position).getBlock(), 1, world.getBlockState(position).getBlock().getMetaFromState(world.getBlockState(position)));
			if (isAcceptedGround(stack) || !canBreakGround(world.getBlockState(position).getBlock()))
				continue;

			produce.addAll(this.getBlockItemStack(world, position));

			world.setBlockState(position, this.getBlock(groundblock).getStateFromMeta(groundblock.getItemDamage()), 1 | 2);
			farmHousing.getFarmInventory().removeResources(resource);
			return true;
		}

		return false;
	}
	
	public boolean canBreakGround(Block block) {
		if (breakable.isEmpty()) {
			breakable.add(Blocks.AIR);
			breakable.add(Blocks.DIRT);
			breakable.add(Blocks.GRASS);
			breakable.add(Blocks.SAND);
			breakable.add(Blocks.FARMLAND);
			breakable.add(Blocks.MYCELIUM);
			breakable.add(Blocks.SOUL_SAND);
			breakable.add(Blocks.WATER);
			breakable.add(Blocks.FLOWING_WATER);
		}
		return breakable.contains(block);
	}

	protected boolean maintainGermlings(World world, IFarmHousing farmHousing, BlockPos pos, FarmDirection direction, int extent) {
		pos = pos.up();
		for (int i = 0; i < extent; i++) {
			BlockPos position = translateWithOffset(pos, direction, i);
			if (!world.isAirBlock(position) && !this.isReplaceableBlock(world, position))
				continue;

			ItemStack below = new ItemStack(world.getBlockState(position.down()).getBlock());
			if (!isAcceptedGround(below))
				continue;

			return trySetCrop(world, farmHousing, position);
		}

		return false;
	}

	public boolean isAcceptedGround(ItemStack itemStack) {
		if(itemStack.getItem() == resource[1].getItem() || itemStack.getItem() == resource[0].getItem()){
			return false;
			}else if(itemStack.getItem() == groundblock.getItem()){
			return true;
			}else{
				return false;
			}
	}

	public static boolean isReplaceableBlock(World world, BlockPos pos) {
		Block block = world.getBlockState(pos).getBlock();
		return block == Blocks.VINE || block == Blocks.TALLGRASS || block == Blocks.DEADBUSH || block == Blocks.SNOW_LAYER || block.isReplaceable(world, pos);
	} 
	
	public static ArrayList<ItemStack> getBlockItemStack(World world, BlockPos pos) {
 		Block block = world.getBlockState(pos).getBlock();
		IBlockState meta = world.getBlockState(pos);
 		return (ArrayList) block.getDrops(world, pos, meta, 0);
 	} 
	public static Block getBlock(ItemStack stack) { 
 		Item item = stack.getItem(); 
 		if (item instanceof ItemBlock) { 
 			return ((ItemBlock) item).getBlock();
 		} else { 
 			return null; 
 		} 
 	} 



	private boolean trySetCrop(World world, IFarmHousing farmHousing, BlockPos position) {
		if(contains(farmHousing.getFarmInventory().getGermlingsInventory(), resource[0])){
			farmHousing.plantGermling(germlings[0], world, position);
			return true;
		}else if(contains(farmHousing.getFarmInventory().getGermlingsInventory(), resource[1])){
 			farmHousing.plantGermling(germlings[1], world, position);
			return true;
		}
		return false;
	}

	private boolean contains(IInventory inv, ItemStack stack){
		for(int i=0; i < inv.getSizeInventory(); i++){
			if(inv.getStackInSlot(i) != null){
				if(inv.getStackInSlot(i).getItem().equals(stack.getItem())) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Collection<ICrop> harvest(World world, BlockPos pos, FarmDirection direction, int extent) {

		Stack<ICrop> crops = new Stack<ICrop>();
		for (int i = 0; i < extent; i++) {
			BlockPos position = translateWithOffset(pos.up(), direction, i);
			for (IFarmable seed : germlings) {
				ICrop crop = seed.getCropAt(world, position, world.getBlockState(pos));
				if (crop != null)
					crops.push(crop);
			}
		}
		return crops;
	}


	@Override
	public IFarmLogic setManual(boolean manual) {
		this.manuals = manual;
		return this;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getStack(){
		return new ItemStack(ItemLoader.strawberry);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ResourceLocation getTextureMap() {
		return new ResourceLocation("textures/atlas/items.png"); //new ResourceLocation("extrafood", "textures/items/Strawberry.png");
	}

	@Override
	public String getName() {
		return I18n.translateToLocal("managedBush");
	}

	protected final BlockPos translateWithOffset(BlockPos pos, FarmDirection farmDirection, int step) {
		return this.scale(farmDirection.getFacing().getDirectionVec(), step).add(pos);
	}

	public static BlockPos scale(Vec3i vect, float factor) {
		return new BlockPos(vect.getX() * factor, vect.getY() * factor, vect.getZ() * factor);
	}



}

