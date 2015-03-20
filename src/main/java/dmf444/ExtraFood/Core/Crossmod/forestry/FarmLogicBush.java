package dmf444.ExtraFood.Core.Crossmod.forestry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dmf444.ExtraFood.Common.blocks.BlockLoader;
import dmf444.ExtraFood.Common.items.ItemLoader;
import dmf444.ExtraFood.util.EFLog;
import forestry.api.farming.Farmables;
import forestry.api.farming.ICrop;
import forestry.api.farming.IFarmHousing;
import forestry.api.farming.IFarmLogic;
import forestry.api.farming.IFarmable;

public class FarmLogicBush implements IFarmLogic {

	boolean manuals;
	private final ItemStack[] resource = new ItemStack[2];
	IFarmHousing housing;
	ArrayList<ItemStack> produce = new ArrayList<ItemStack>();
	IFarmable[] germlings;
	ItemStack groundblock = new ItemStack(Blocks.dirt);
	static HashSet<Block> breakable = new HashSet<Block>();
	
	public FarmLogicBush(IFarmHousing housing){
		this.housing = housing;
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
		return itemstack.getItem() == Item.getItemFromBlock(Blocks.dirt);
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
	public Collection<ItemStack> collect() {

		Collection<ItemStack> products = produce;
		produce = new ArrayList<ItemStack>();

		Vect coords = new Vect(housing.getCoords());
		Vect area = new Vect(housing.getArea());
		Vect offset = new Vect(housing.getOffset());

		Vect min = coords.add(offset);
		Vect max = coords.add(offset).add(area);

		AxisAlignedBB harvestBox = AxisAlignedBB.getBoundingBox(min.x, min.y, min.z, max.x, max.y, max.z);
		List<Entity> list = housing.getWorld().getEntitiesWithinAABB(Entity.class, harvestBox);

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


	@Override
	public boolean cultivate(int x, int y, int z, ForgeDirection direction, int extent) {

		if (maintainSoil(x, y, z, direction, extent))
			return true;

		if (maintainGermlings(x, y + 1, z, direction, extent))
			return true;

		return false;
	}

	private boolean maintainSoil(int x, int yGround, int z, ForgeDirection direction, int extent) {
		if (!housing.hasResources(resource))
			return false;

		for (int i = 0; i < extent; i++) {
			Vect position = new Vect(x + direction.offsetX * i, yGround + direction.offsetY * i, z + direction.offsetZ * i);
			
			ItemStack stack = new ItemStack(housing.getWorld().getBlock(position.x, position.y, position.z), 1, housing.getWorld().getBlockMetadata(position.x, position.y, position.z));
			if (isAcceptedGround(stack) || !canBreakGround(housing.getWorld().getBlock(position.x, position.y, position.z)))
				continue;

			produce.addAll(this.getBlockItemStack(housing.getWorld(), position));

			housing.getWorld().setBlock(position.x, position.y, position.z, this.getBlock(groundblock), groundblock.getItemDamage(), 1 | 2);
			housing.removeResources(resource);
			return true;
		}

		return false;
	}
	
	public boolean canBreakGround(Block block) {
		if (breakable.isEmpty()) {
			breakable.add(Blocks.air);
			breakable.add(Blocks.dirt);
			breakable.add(Blocks.grass);
			breakable.add(Blocks.sand);
			breakable.add(Blocks.farmland);
			breakable.add(Blocks.mycelium);
			breakable.add(Blocks.soul_sand);
			breakable.add(Blocks.water);
			breakable.add(Blocks.flowing_water);
		}
		return breakable.contains(block);
	}

	protected boolean maintainGermlings(int x, int y, int z, ForgeDirection direction, int extent) {
		World world = housing.getWorld();

		for (int i = 0; i < extent; i++) {
			Vect position = new Vect(x + direction.offsetX * i, y + direction.offsetY * i, z + direction.offsetZ * i);
			if (!world.isAirBlock(position.x, position.y, position.z) && !this.isReplaceableBlock(world, position.x, position.y, position.z))
				continue;

			ItemStack below = new ItemStack(world.getBlock(position.x, position.y - 1, position.z), 1, world.getBlockMetadata(position.x, position.y - 1, position.z));
			if (!isAcceptedGround(below))
				continue;

			return trySetCrop(position);
		}

		return false;
	}

	public boolean isAcceptedGround(ItemStack itemStack) {
		if(itemStack.getItem() == resource[1].getItem() || itemStack.getItem() == resource[0].getItem()){
			return false;
			}else if(itemStack.getItem() != groundblock.getItem()){
			return true;
			}else{
				return false;
			}
	}

	public static boolean isReplaceableBlock(World world, int x, int y, int z) { 
		Block block = world.getBlock(x, y, z); 
		return block == Blocks.vine || block == Blocks.tallgrass || block == Blocks.deadbush || block == Blocks.snow_layer || block.isReplaceable(world, x, y, z); 
	} 
	
	public static ArrayList<ItemStack> getBlockItemStack(World world, Vect posBlock) { 
 		Block block = world.getBlock(posBlock.x, posBlock.y, posBlock.z); 
		int meta = world.getBlockMetadata(posBlock.x, posBlock.y, posBlock.z); 
 		return block.getDrops(world, posBlock.x, posBlock.y, posBlock.z, meta, 0); 
 	} 
	public static Block getBlock(ItemStack stack) { 
 		Item item = stack.getItem(); 
 		if (item instanceof ItemBlock) { 
 			return ((ItemBlock) item).field_150939_a; 
 		} else { 
 			return null; 
 		} 
 	} 



	private boolean trySetCrop(Vect position) {
		World world = housing.getWorld();

		for (IFarmable candidate : germlings)
			if (housing.plantGermling(candidate, world, position.x, position.y, position.z))
				return true;

		return false;
	}
	@Override
	public Collection<ICrop> harvest(int x, int y, int z, ForgeDirection direction, int extent) {
		World world = housing.getWorld();

		Stack<ICrop> crops = new Stack<ICrop>();
		for (int i = 0; i < extent; i++) {
			Vect position = new Vect(x + direction.offsetX * i, y + 0 + direction.offsetY * i, z + direction.offsetZ * i);
			for (IFarmable seed : germlings) {
				ICrop crop = seed.getCropAt(world, position.x, position.y, position.z);
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
	public IIcon getIcon() {
		return ItemLoader.strawberry.getIconFromDamage(0);
	}

	@Override
	public ResourceLocation getSpriteSheet() {
		return TextureMap.locationItemsTexture; //new ResourceLocation("extrafood", "textures/items/strawberry.png");
	}

	@Override
	public String getName() {
		return StatCollector.translateToLocal("managedBush");
	}
 class Vect{
			public int x;
			public int y;
			public int z;

			public Vect(int[] dim) {
				if (dim.length != 3)
					throw new RuntimeException("Cannot instantiate a vector with less or more than 3 points.");

				this.x = dim[0];
				this.y = dim[1];
				this.z = dim[2];
			}

			public Vect(int x, int y, int z) {
				this.x = x;
				this.y = y;
				this.z = z;
			}
			public Vect add(Vect other) {
				Vect result = new Vect(x, y, z);
				result.x += other.x;
				result.y += other.y;
				result.z += other.z;
				return result;
			}
 	}
}

