package dmf444.ExtraFood.Client.renderer;

import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dmf444.ExtraFood.Core.lib.GuiLib;


@SideOnly(Side.CLIENT)
public class JuiceMixerModel {

	private IModelCustom modelJM;
	
	public JuiceMixerModel(){
		modelJM = AdvancedModelLoader.loadModel(GuiLib.ModelJM);
	}
	
	public void render(){
		modelJM.renderAll();
	}
}
