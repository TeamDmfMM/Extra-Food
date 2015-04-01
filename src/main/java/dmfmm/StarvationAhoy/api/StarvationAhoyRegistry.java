package dmfmm.StarvationAhoy.api;

import dmfmm.StarvationAhoy.api.FoodEdit.Module;

public class StarvationAhoyRegistry {
	
	public interface IStarvationAhoyProvider {
		
		
		
		/**
		 * To maunally add food overrides to Starvation Ahoy, create a class extending {@link dmf444.api.FoodEdit.Module}, and register with this method. 
		 * This will be injected into Starvation Ahoy's known food list at the begining of Pre-init event
		 * 
		 * @param m class of the module to be registerd
		 * @return nothing
		 */
		public void registerModule(Class<? extends Module> m);
			
		
		
		
	}

	public static IStarvationAhoyProvider instance;
	
	public static IStarvationAhoyProvider getInstance(){
		return instance;
	}
	public static void init(IStarvationAhoyProvider inst){
		if (instance == null) { instance = inst; }
	}
	
	
}
