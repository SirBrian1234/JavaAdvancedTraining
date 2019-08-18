package packagetesting;

import packagetesting.packagea.*;
import packagetesting.packageb.*;

public class Wii {
    public static void main(String[] args) {
        //Bamies b = new Bamies();  //Error:(8, 9) java: reference to Bamies is ambiguous
        packagetesting.packagea.Bamies b;
        packagetesting.packageb.Bamies a;
        //You used two different classes of the same name!
    }
}
