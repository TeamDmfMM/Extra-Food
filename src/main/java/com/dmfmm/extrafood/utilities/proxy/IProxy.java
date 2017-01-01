package com.dmfmm.extrafood.utilities.proxy;

/**
 * Created by TeamDMFMM on 12/31/2016. Code originally written
 * for ExtraFood1.9TEST. Do not copy without permission,
 * because that is just mean. Code is VISIBLE SOURCE, therfore
 * credit us, just don't steal large portions of this.
 */
public interface IProxy {


    public void registerRenderers();
    public void registerKeybinds();
    public void intermodComm();
    public void preInit();
    public void init();
    public void postInit();
}
