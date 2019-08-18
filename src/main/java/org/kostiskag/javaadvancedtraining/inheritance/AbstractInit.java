package org.kostiskag.javaadvancedtraining.inheritance;

public abstract class AbstractInit {

    public AbstractInit() {

    }

    //public abstract AbstractInit(int x); //abstract constructors are not allowed!

    static class Inner extends AbstractInit {

    }

    public static void main(String[] args) {
        //Error:(10, 26) java: inheritance.AbstractInit is abstract; cannot be instantiated
        //AbstractInit a = new AbstractInit();

        //However we can use a variable of type AbstractInit and assign a subclass object of AbstractInit as Inner!
        AbstractInit a = new Inner();
    }
}
