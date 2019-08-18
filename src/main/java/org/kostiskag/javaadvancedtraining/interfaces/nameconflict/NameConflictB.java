package org.kostiskag.javaadvancedtraining.interfaces.nameconflict;

//Error:(3, 8) java: types interfaces.nameconflict.InterfaceA and interfaces.nameconflict.InterfaceB are incompatible;
//class interfaces.nameconflict.NameConflict inherits unrelated defaults for helloWorld() from types interfaces.nameconflict.InterfaceA and interfaces.nameconflict.InterfaceB
//error is not resolved with the usage of abstract modifier
public class NameConflictB extends AbsName implements InterfaceA, InterfaceB {

    //comment this and a conflict will occur as InterfaceA and InterfaceB both describe the same method!
    @Override
    public void helloWorld() {
        //why not have both????
        //InterfaceA.super.helloWorld();  //Error:(12, 19) java: bad type qualifier interfaces.nameconflict.InterfaceA in default super call
        InterfaceB.super.helloWorld();
    }

    public static void main(String[] args) {

    }

}
