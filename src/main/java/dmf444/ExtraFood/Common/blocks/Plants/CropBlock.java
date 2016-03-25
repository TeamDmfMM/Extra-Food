package dmf444.ExtraFood.Common.blocks.Plants;

import dmf444.ExtraFood.Common.items.ItemLoader;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraftforge.common.EnumPlantType;

/*--Future Reference. Copied of the BlockCarrot DIRECTLY w/ minimal change--*/
public class CropBlock extends BlockCrops{
	

	    private String Crop;
	private Item crop;
	private Item seed;
	    
	    /*
	     * This is modified from original to allow multiple types of plants
	     */
	    public CropBlock(String cropName){
	    	super();
	    	this.Crop = cropName;

	    }

	public CropBlock(Item c, Item s){
		super();
		this.seed = s;
		this.crop = c;

	}


	    	//Seeds
	    protected Item getSeed()
	    {	
	        if(Crop == "tomato"){
	        	return ItemLoader.tomatoSeeds;
	        }else if (Crop == "lettuce") {
				return ItemLoader.rawlettuceSeeds;
			}else if(Crop == "pineapple"){
				return ItemLoader.pineapple;
	        }else if(seed != null){
				return this.seed;
			}
	        return null;
	    }
	    	//Fruit
	    protected Item getCrop()
	    {
	        if(Crop == "tomato"){
	        	return ItemLoader.tomato;
	        }else if (Crop == "lettuce") {
				return ItemLoader.lettuce;
			}else if(Crop == "pineapple"){
				return ItemLoader.pineapple;
	        }else if(this.crop != null){
				return this.crop;
			}
	        return null;
	    }

	@Override
	public net.minecraftforge.common.EnumPlantType getPlantType(net.minecraft.world.IBlockAccess world, BlockPos pos)
	{
		return EnumPlantType.Crop;
	}

	}