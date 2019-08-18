package org.kostiskag.javaadvancedtraining.packagetesting;

import org.kostiskag.javaadvancedtraining.packagetesting.packagea.*;
import org.kostiskag.javaadvancedtraining.packagetesting.packageb.*;

public class Wii {
    public static void main(String[] args) {
        //Bamies b = new Bamies();  //Error:(8, 9) java: reference to Bamies is ambiguous
        org.kostiskag.javaadvancedtraining.packagetesting.packagea.Bamies b;
        org.kostiskag.javaadvancedtraining.packagetesting.packageb.Bamies a;
        //You used two different classes of the same name!
    }
}
