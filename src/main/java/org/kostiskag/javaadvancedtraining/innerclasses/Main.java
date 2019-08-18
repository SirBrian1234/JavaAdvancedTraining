package org.kostiskag.javaadvancedtraining.innerclasses;

public class Main {

    public static void main(String[] args) {

        //STATIC

        //public
        //you can use the public static inner class from AdvInnerClassesPublicStatic
        //technically all outer classes are static as well they just don say it!
        AdvInnerClassesPublicStatic.InnerClass o = new AdvInnerClassesPublicStatic.InnerClass(5);

        //default
        //let's see a default static case
        //the compiler says you can use it! Therefore default is for within the package
        AdvInnerClassesStatic.InnerClass o2 = new AdvInnerClassesStatic.InnerClass(6);

        //private
        //you can't from the outside
        //innerclasses.AdvInnerClassesPrivateStatic.InnerClass has private access in innerclasses.AdvInnerClassesPrivateStatic
        //AdvInnerClassesPrivateStatic.InnerClass i = new AdvInnerClassesPrivateStatic.InnerClass(6);

        //NON-STATIC

        //public
        //default
        //Non-static is treated like an outer class field ONLY if it is either default or public
        AdvInnerClassesNonStatic o3 = new AdvInnerClassesNonStatic();
        AdvInnerClassesNonStatic.InnerClass in = o3.new InnerClass(5); //don't forget -> ClassName.new <-

        //private
        //Non-static private nor it may find the class nor it may instantiate it!
        AdvInnerClassesPrivateStatic o4 = new AdvInnerClassesPrivateStatic();
        //Error:(28, 37) java: innerclasses.AdvInnerClassesPrivateStatic.InnerClass has private access in innerclasses.AdvInnerClassesPrivateStatic
        //AdvInnerClassesPrivateStatic.InnerClass in2;
        //Error:(30, 22) java: innerclasses.AdvInnerClassesPrivateStatic.InnerClass has private access in innerclasses.AdvInnerClassesPrivateStatic
        //in2 = o4.new InnerClass(5);
    }
}
