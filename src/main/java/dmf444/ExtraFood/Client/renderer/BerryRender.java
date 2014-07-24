package dmf444.ExtraFood.Client.renderer;




import org.lwjgl.opengl.GL11;


import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;




public class BerryRender implements ISimpleBlockRenderingHandler {




	static int myRenderID;




	public BerryRender() {
		BerryRender.myRenderID = RenderingRegistry.getNextAvailableRenderId();
		// TODO Auto-generated constructor stub
	}




	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
		Tessellator tessellator = Tessellator.instance;




		    // if you don't perform this translation, the item won't sit in the player's hand properly in 3rd person view
		    GL11.glTranslatef(-0.3F, -0.3F, -0.3F);
		    GL11.glDisable(GL11.GL_CULL_FACE);
		    GL11.glDisable(GL11.GL_LIGHTING);
		    GL11.glEnable(GL11.GL_ALPHA_TEST);



		    // for "inventory" blocks (actually for items which are equipped, dropped, or in inventory), should render in [0,0,0] to [1,1,1]
		    tessellator.startDrawingQuads();
		    renderBlock(tessellator, 0.0, 0.0, 0.0, block);
		    tessellator.draw();




		    // don't forget to undo the translation you made at the start
		    GL11.glTranslatef(0.3F, 0.3F, 0.3F);
		    GL11.glEnable(GL11.GL_CULL_FACE);
		    GL11.glEnable(GL11.GL_LIGHTING);
		    GL11.glDisable(GL11.GL_ALPHA_TEST);





	}




	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {
		// TODO Auto-generated method stub




		/*Tessellator tessellator = Tessellator.instance;




	    // world blocks should render in [x,y,z] to [x+1, y+1, z+1]
	    //     tessellator.startDrawingQuads() has already been called by the caller




	    int lightValue = block.getMixedBrightnessForBlock(world, x, y, z);
	    tessellator.setBrightness(lightValue);
	    tessellator.setColorOpaque_F(1.0F, 1.0F, 1.0F);




	    renderBlock(tessellator, x, y, z, block);*/








	    //     tessellator.draw() will be called by the caller after return
		renderer.setRenderBoundsFromBlock(block);
		renderer.renderStandardBlock(block, x, y,z );
		renderer.setRenderBounds(0, 0, 0, 1,  1,  1);
	    return true;
	}




	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return true;
	}




	@Override
	public int getRenderId() {
		// TODO Auto-generated method stub
		return BerryRender.myRenderID;
	}




	private void renderBlock(Tessellator tess, double x, double y, double z, Block block){
		IIcon icon1 = block.getIcon(0, 0);
		double minU1 = (double)icon1.getMinU();
	    double minV1 = (double)icon1.getMinV();
	    double maxU1 = (double)icon1.getMaxU();
	    double maxV1 = (double)icon1.getMaxV();




	    tess.setTranslation(x, y, z);
	    tess.addVertexWithUV(0, 0, 0, maxU1, maxV1);
	    tess.addVertexWithUV(0, 0.25, 0, maxU1, minV1);
	    tess.addVertexWithUV(1, 0.25, 0, minU1, minV1);
	    tess.addVertexWithUV(1, 0, 0, minU1, maxV1);
	    tess.draw();




	    tess.startDrawingQuads();
	    tess.addVertexWithUV(1, 0, 1, minU1, maxV1);
	    tess.addVertexWithUV(1, 0.25, 1, minU1, minV1);
	    tess.addVertexWithUV(0, 0.25, 1, maxU1, minV1);
	    tess.addVertexWithUV(0, 0, 1, maxU1, maxV1);
	    tess.draw();




	    tess.startDrawingQuads();
	    tess.addVertexWithUV(0, 0, 1, minU1, maxV1);
	    tess.addVertexWithUV(0, 0.25, 1, minU1, minV1);
	    tess.addVertexWithUV(0, 0.25, 0, maxU1, minV1);
	    tess.addVertexWithUV(0, 0, 0, maxU1, maxV1);
	    tess.draw();




	    tess.startDrawingQuads();
	    tess.addVertexWithUV(1, 0, 1, maxU1, maxV1);
	    tess.addVertexWithUV(1, 0.25, 1, maxU1, minV1);
	    tess.addVertexWithUV(1, 0.25, 0, minU1, minV1);
	    tess.addVertexWithUV(1, 0, 0, minU1, maxV1);
	    tess.draw();


	    tess.startDrawingQuads();
	    tess.addVertexWithUV(1, 0.25, 1, maxU1, maxV1);
	    tess.addVertexWithUV(1, 0.25, 0, maxU1, minV1);
	    tess.addVertexWithUV(0, 0.25, 0, minU1, minV1);
	    tess.addVertexWithUV(0, 0.25, 1, minU1, maxV1);
	    tess.draw();


	    tess.startDrawingQuads();
	    tess.addVertexWithUV(1, 0, 1, maxU1, maxV1);
	    tess.addVertexWithUV(1, 0, 0, maxU1, minV1);
	    tess.addVertexWithUV(0, 0, 0, minU1, minV1);
	    tess.addVertexWithUV(0, 0, 1, minU1, maxV1);










	}




}

