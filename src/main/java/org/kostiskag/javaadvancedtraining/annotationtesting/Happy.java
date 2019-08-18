package org.kostiskag.javaadvancedtraining.annotationtesting;

import org.kostiskag.javaadvancedtraining.interfaces.useofprivate.HowToUsePrivate;

public class Happy implements HowToUsePrivate {

    @MyAnnot int hello;
    @MyAnnot() int hello2;
    @MyAnnot(Animal.DOG) int hello3;
    @MyAnnot(value = Animal.DOG, num = 15) int hello4;


    public @Override() int addition(int x) {
        return 0;
    }

    @MyAnnot
    @Override
    public int substraction() {
        return 0;
    }


    @MyAnnot public static void main(String[] args) {

    }


    @MyAnnot int hello(@MyAnnot int x, int y) {
       return 0;
    }

    @MyAnnot void hello2() {

    }

    private <@MyAnnot A> A pakis() {
        return (A) new Object();
    }


}
