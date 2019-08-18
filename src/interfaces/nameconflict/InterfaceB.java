package interfaces.nameconflict;

public interface InterfaceB {
    default void helloWorld() {
        System.out.println("hi");
    }
}
