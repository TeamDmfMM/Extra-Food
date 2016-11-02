package com.dmfmm.extrafood.items.nbt;

/**
 * Created by mincrmatt12. Do not copy this or you will have to face
 * our legal team. (dmf444)
 */
public class NBTCount {
    private static NBTCount ourInstance = new NBTCount();

    public static NBTCount getInstance() {
        return ourInstance;
    }

    public int lastId = 0;

    private NBTCount() {
    }
}
