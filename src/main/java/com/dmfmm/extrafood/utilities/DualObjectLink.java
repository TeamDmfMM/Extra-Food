package com.dmfmm.extrafood.utilities;

/**
 * Created by mincrmatt12. Do not copy this or you will have to face
 * our legal team. (dmf444)
 */
public class DualObjectLink<A, B> {
    private A a;
    private B b;

    public DualObjectLink(A a, B b){
        this.a = a;
        this.b = b;
    }


    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }
}