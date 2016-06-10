package dmf444.ExtraFood.Client.modelbake;

import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ICustomModelLoader;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelLoaderRegistry;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by TeamDMFMM on 6/9/2016. Code originally written
 * for ExtraFood1.9TEST. Do not copy without permission,
 * because that is just mean. Code is VISIBLE SOURCE, therfore
 * credit us, just don't steal large portions of this.
 */
public enum ModelLoaderz implements ICustomModelLoader {
    INSTANCE;

    private IResourceManager manager;
    private final Map<ResourceLocation, OBJModel> cache = new HashMap<ResourceLocation, OBJModel>();
    private final Map<ResourceLocation, Exception> errors = new HashMap<ResourceLocation, Exception>();


    public void onResourceManagerReload(IResourceManager resourceManager)
    {
        this.manager = resourceManager;
        cache.clear();
        errors.clear();
    }

    public boolean accepts(ResourceLocation modelLocation)
    {
        return modelLocation.getResourceDomain().equals("extrafood") && modelLocation.getResourcePath().endsWith(".obj");
    }

    public IModel loadModel(ResourceLocation modelLocation) throws Exception
    {
        ResourceLocation file = new ResourceLocation(modelLocation.getResourceDomain(), modelLocation.getResourcePath());
        if (!cache.containsKey(file))
        {
            IResource resource = null;
            try
            {
                resource = manager.getResource(file);
            }
            catch (FileNotFoundException e)
            {
                if (modelLocation.getResourcePath().startsWith("models/block/"))
                    resource = manager.getResource(new ResourceLocation(file.getResourceDomain(), "models/item/" + file.getResourcePath().substring("models/block/".length())));
                else if (modelLocation.getResourcePath().startsWith("models/item/"))
                    resource = manager.getResource(new ResourceLocation(file.getResourceDomain(), "models/block/" + file.getResourcePath().substring("models/item/".length())));
                else throw e;
            }
            OBJModel.Parser parser = new OBJModel.Parser(resource, manager);
            OBJModel model = null;
            try
            {
                model = parser.parse();
            }
            catch (Exception e)
            {
                errors.put(modelLocation, e);
            }
            finally
            {
                cache.put(modelLocation, model);
            }
        }
        OBJModel model = cache.get(file);
        if (model == null) throw new ModelLoaderRegistry.LoaderException("Error loading model previously: " + file, errors.get(modelLocation));
        return model;
    }
}