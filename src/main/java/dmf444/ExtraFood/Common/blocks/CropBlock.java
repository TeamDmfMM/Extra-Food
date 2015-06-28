package dmf444.ExtraFood.Common.blocks;

import dmf444.ExtraFood.Common.items.ItemLoader;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;

/*--Future Reference. Copied of the BlockCarrot DIRECTLY w/ minimal change--*/
public class CropBlock extends BlockCrops{
	

	    private String Crop;
	    
	    /*
	     * This is modified from original to allow multiple types of plants
	     */
	    public CropBlock(String cropName){
	    	super();
	    	this.Crop = cropName;

	    }


	    	//Seeds
	    protected Item getSeed()
	    {	
	        if(Crop == "tomato"){
	        	return ItemLoader.tomato;
	        }else if (Crop == "lettuce"){
	        	return ItemLoader.rawlettuceSeeds;
	        }
	        return null;
	    }
	    	//Fruit
	    protected Item getCrop()
	    {
	        if(Crop == "tomato"){
	        	return ItemLoader.tomato;
	        }else if (Crop == "lettuce"){
	        	return ItemLoader.lettuce;
	        }
	        return null;
	    }

	}