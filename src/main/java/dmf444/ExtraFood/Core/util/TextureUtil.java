package dmf444.ExtraFood.Core.util;

import java.nio.ByteBuffer;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public class TextureUtil {
	
	
	
	public static int genTexture(ResourceLocation r1, ResourceLocation r2, int w, int h){
		Minecraft mc = Minecraft.getMinecraft();
		int gl1 = mc.getTextureManager().getTexture(r1).getGlTextureId();
		int gl2 = mc.getTextureManager().getTexture(r2).getGlTextureId();
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		int im = GL11.glGenTextures();
		// gen blank image
		
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, im);
		
		GL11.glPixelStorei(GL11.GL_UNPACK_ALIGNMENT, 1);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S,
				GL11.GL_CLAMP);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T,
				GL11.GL_CLAMP);
		GL11.glTexEnvf(GL11.GL_TEXTURE_ENV, GL11.GL_TEXTURE_ENV_MODE, GL11.GL_MODULATE);

		GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA, w, h, 0, GL11.GL_RGBA,
				GL11.GL_UNSIGNED_BYTE, (ByteBuffer)null);
		
		//copy image 1
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, gl1);
		
		ByteBuffer gl1buf = BufferUtils.createByteBuffer(4 * w *h);
		
	
		
		GL11.glGetTexImage(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, gl1buf);
		
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, im);
		
		GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA, w, h, 0, GL11.GL_RGBA,
				GL11.GL_UNSIGNED_BYTE, gl1buf);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, gl2);
		
		ByteBuffer gl2buf = BufferUtils.createByteBuffer(4 * w *h);
		
		GL11.glGetTexImage(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, gl2buf);
		
GL11.glBindTexture(GL11.GL_TEXTURE_2D, im);
		
		GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA, w, h, 0, GL11.GL_RGBA,
				GL11.GL_UNSIGNED_BYTE, gl2buf);
		
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_BLEND);
		
		return im;
		
		
		
		
		
	}
	public static int addTexture(ResourceLocation r1,int w, int h){
		Minecraft mc = Minecraft.getMinecraft();
		int gl1 = mc.getTextureManager().getTexture(r1).getGlTextureId();
		
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		int im = GL11.glGenTextures();
		// gen blank image
ByteBuffer bbuf = BufferUtils.createByteBuffer(4 * w *h);
		
	
		
		GL11.glGetTexImage(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE,bbuf);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, im);
		
		GL11.glPixelStorei(GL11.GL_UNPACK_ALIGNMENT, 1);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S,
				GL11.GL_CLAMP);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T,
				GL11.GL_CLAMP);
		GL11.glTexEnvf(GL11.GL_TEXTURE_ENV, GL11.GL_TEXTURE_ENV_MODE, GL11.GL_MODULATE);

		GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA, w, h, 0, GL11.GL_RGBA,
				GL11.GL_UNSIGNED_BYTE, (ByteBuffer)bbuf);
		
		//copy image 1
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, gl1);
		
		ByteBuffer gl1buf = BufferUtils.createByteBuffer(4 * w *h);
		
	
		
		GL11.glGetTexImage(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, gl1buf);
		
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, im);
		
		GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA, w, h, 0, GL11.GL_RGBA,
				GL11.GL_UNSIGNED_BYTE, gl1buf);
		
		
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_BLEND);
		
		return im;
		
		
		
		
		
	}
}

