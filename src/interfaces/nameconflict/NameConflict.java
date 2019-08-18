package interfaces.nameconflict;

//Error:(3, 8) java: types interfaces.nameconflict.InterfaceA and interfaces.nameconflict.InterfaceB are incompatible;
//class interfaces.nameconflict.NameConflict inherits unrelated defaults for helloWorld() from types interfaces.nameconflict.InterfaceA and interfaces.nameconflict.InterfaceB
//error is not resolved with the usage of abstract modifier
public class NameConflict implements InterfaceA, InterfaceB {

    //comment this and a conflict will occur as InterfaceA and InterfaceB both describe the same method!
    @Override
    public void helloWorld() {
        //why not have both????
        InterfaceA.super.helloWorld();
        InterfaceB.super.helloWorld();
    }

    public static void main(String[] args) {

    }

}
