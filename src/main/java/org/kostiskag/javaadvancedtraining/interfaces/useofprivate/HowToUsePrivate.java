package org.kostiskag.javaadvancedtraining.interfaces.useofprivate;

public interface HowToUsePrivate {

    static int hello = 5;

    private int add() {
        return 10;
    }

    private int substract() {
        return 5;
    }

    default int addition(int x) {
        if (x >5)
            return add();
        else
            return substract();
    }

    int substraction();


}
